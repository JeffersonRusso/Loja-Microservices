package com.microservice.loja.usuario.entrypoint.mapper;

import java.util.ArrayList;
import java.util.List;

import com.microservice.loja.usuario.entrypoint.model.response.UserModelResponse;
import com.microservice.loja.usuario.usecase.model.response.UserDomainResponse;

public class UserEntryPointModelMapper {
	
	public static UserModelResponse forModel(UserDomainResponse userDomainResponse) {
		
		List<UserModelResponse.Endereco> enderecoUser = new ArrayList<>();
		
		userDomainResponse.getEndereco().forEach(endereco -> 
		enderecoUser.add(
				new UserModelResponse.Endereco(
						endereco.getIdEndereco(),
						endereco.getLogradouro(),
						endereco.getBairro(),
						endereco.getCidade(),
						endereco.getEstado(),
						endereco.getNumero(),
						endereco.getCep()))
	);
	
	return UserModelResponse.builder()
			.nome(userDomainResponse.getNome())
			.email(userDomainResponse.getEmail())
			.idCarrinho(userDomainResponse.getIdCarrinho())
			.endereco(enderecoUser)
			.build();		
	}
}