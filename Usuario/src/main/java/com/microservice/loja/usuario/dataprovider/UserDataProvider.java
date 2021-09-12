package com.microservice.loja.usuario.dataprovider;

import static com.microservice.loja.usuario.dataprovider.mapper.UserDataProviderDomainMapper.toUserDomain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.loja.usuario.dataprovider.repository.UserRespository;
import com.microservice.loja.usuario.usecase.gateway.UserGateway;
import com.microservice.loja.usuario.usecase.model.request.UserDomainRequest;
import com.microservice.loja.usuario.usecase.model.response.UserDomainResponse;

@Component
public class UserDataProvider implements UserGateway {
	
	/**
	 * @author Jefferson Russo
	 * @since 10/09/2021
	 * 
	 * Classe que trabalha junto ao repositorio
	 * todo acesso a dados partem dessa classe
	 * classe que consulta o repositorio de contendo Usuarios
	 */

	private UserRespository userRespository;
	
	@Autowired
	public UserDataProvider(UserRespository userRespository) {
		this.userRespository = userRespository;
	}
	
	@Override
	public Optional<UserDomainResponse> findByEmail(UserDomainRequest userDomainRequest) {
		
		return Optional.of(toUserDomain(userRespository.findByEmail(userDomainRequest.getEmail())));
	}

}