package com.microservice.loja.usuario.usecase.gateway;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.microservice.loja.usuario.usecase.model.request.UserDomainRequest;
import com.microservice.loja.usuario.usecase.model.response.UserDomainResponse;

public interface UserGateway {
	
	Optional<UserDomainResponse> findByEmail(UserDomainRequest userDomainRequest);
	
	Optional<UserDomainResponse> save(UserDomainRequest userDomainRequest);
	
	Page<UserDomainResponse> findAll(Pageable pageable);
}
