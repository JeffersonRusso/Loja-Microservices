package com.microservice.loja.usuario.usecase;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.microservice.loja.usuario.enumerator.Status;
import com.microservice.loja.usuario.keycloak.service.KeycloakUserService;
import com.microservice.loja.usuario.usecase.gateway.UserGateway;
import com.microservice.loja.usuario.usecase.model.request.UserDomainRequest;
import com.microservice.loja.usuario.usecase.model.response.UserDomainResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserUseCase {
	
	/**
	 * Jefferson Russo
	 * @since 29/09/21
	 * 
	 * Classe responsavel por criar um usuario
	 */
	
	@Autowired
	private UserGateway userGateway;
	
	private final KeycloakUserService keycloakUserService;
	
	public Optional<UserDomainResponse> findByEmail(UserDomainRequest userDomainRequest) {
		return userGateway.findByEmail(userDomainRequest);
	}

	public Optional<UserDomainResponse> createUser(UserDomainRequest userDomainRequest) {

        List<UserRepresentation> userRepresentations = keycloakUserService.readUserByEmail(userDomainRequest.getEmail());
        if (userRepresentations.size() > 0) {
            throw new RuntimeException("This email already registered as a user. Please check and retry.");
        }

        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEmail(userDomainRequest.getEmail());
        userRepresentation.setEmailVerified(false);
        userRepresentation.setEnabled(false);
        userRepresentation.setUsername(userDomainRequest.getEmail());

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setValue(userDomainRequest.getPassword());
        credentialRepresentation.setTemporary(false);
        userRepresentation.setCredentials(Collections.singletonList(credentialRepresentation));

        Integer userCreationResponse = keycloakUserService.createUser(userRepresentation);

        if (userCreationResponse == 201) {
            //log.info("User created under given username {}", userDomainRequest.getEmail());

            List<UserRepresentation> userRepresentations1 = keycloakUserService.readUserByEmail(userDomainRequest.getEmail());
            //userDomainRequest.setId(UUID.randomUUID().toString()); // adicionado para teste // ATT TESTE FALHOU
            userDomainRequest.setAuthId(userRepresentations1.get(0).getId());
            userDomainRequest.setStatus(Status.PENDING);
            userDomainRequest.setIdentification(UUID.randomUUID().toString());
            
            return userGateway.save(userDomainRequest);
        }

        throw new RuntimeException("We couldn't find user under given identification. Please check and retry");
    }
	
	public List<UserDomainResponse> readUsers(Pageable pageable) {
		Page<UserDomainResponse> listUserDomainResponse = userGateway.findAll(pageable);
		
    
        List<UserDomainResponse> users = listUserDomainResponse.getContent();
        users.forEach(user -> {
            UserRepresentation userRepresentation = keycloakUserService.readUser(user.getAuthId());
            user.setId(user.getId());
            user.setEmail(userRepresentation.getEmail());
            user.setIdentification(user.getIdentification());
        });
        return users;
    }
}