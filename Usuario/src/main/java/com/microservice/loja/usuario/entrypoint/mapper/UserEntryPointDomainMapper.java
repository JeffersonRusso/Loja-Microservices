package com.microservice.loja.usuario.entrypoint.mapper;

import com.microservice.loja.usuario.entrypoint.model.request.UserModelRequest;
import com.microservice.loja.usuario.usecase.model.request.UserDomainRequest;

public class UserEntryPointDomainMapper {
	
	private UserEntryPointDomainMapper() {}
	
	public static UserDomainRequest forDomain(UserModelRequest userModelRequest) {
		return UserDomainRequest.builder()
				.email(userModelRequest.getEmail())
				.password(userModelRequest.getPassword())
				.identification(userModelRequest.getIdentification())
				.authId(userModelRequest.getAuthId())
				.status(userModelRequest.getStatus())
				.build();
	}
}