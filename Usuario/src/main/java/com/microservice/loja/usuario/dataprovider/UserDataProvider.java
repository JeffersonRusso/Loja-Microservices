package com.microservice.loja.usuario.dataprovider;

import static com.microservice.loja.usuario.dataprovider.mapper.UserDataProviderDomainMapper.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.microservice.loja.usuario.dataprovider.mapper.UserDataProviderDomainMapper;
import com.microservice.loja.usuario.dataprovider.repository.UserRespository;
import com.microservice.loja.usuario.dataprovider.repository.entity.UserEntity;
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
		
		Optional<UserEntity> entity = userRespository.findByEmail(userDomainRequest.getEmail());
		
		return entity.isPresent() ?
				Optional.of(UserDataProviderDomainMapper.toUserDomain(entity.get())) : Optional.empty();
	}

	@Override
	public Optional<UserDomainResponse> save(UserDomainRequest userDomainRequest) {
		UserEntity entity = userRespository.save(toUserEntity(userDomainRequest));
		return Optional.of(toUserDomain( entity));
	}

	@Override
	public Page<UserDomainResponse> findAll(Pageable pageable) {
		return null;
	}
}