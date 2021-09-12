package com.microservice.loja.usuario.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.loja.usuario.usecase.gateway.UserGateway;
import com.microservice.loja.usuario.usecase.model.request.UserDomainRequest;
import com.microservice.loja.usuario.usecase.model.response.UserDomainResponse;

@Component
public class UserUseCase {
	
	@Autowired
	private UserGateway userGateway;
	
	public Optional<UserDomainResponse> findByEmail(UserDomainRequest userDomainRequest) {
		return userGateway.findByEmail(userDomainRequest);
	}

}
