package com.microservice.loja.usuario.dataprovider.mapper;

import java.util.ArrayList;
import java.util.List;

import com.microservice.loja.usuario.dataprovider.repository.entity.UserEntity;
import com.microservice.loja.usuario.usecase.model.response.UserDomainResponse;
import com.microservice.loja.usuario.usecase.model.response.UserDomainResponse.Endereco;

public class UserDataProviderDomainMapper {
	
	public static UserDomainResponse toUserDomain(UserEntity userEntity) {
		
		List<UserDomainResponse.Endereco> enderecoUser = new ArrayList<>();
		
		userEntity.getEndereco().forEach(endereco -> 
			enderecoUser.add(
					new UserDomainResponse.Endereco(
							endereco.getIdEndereco(),
							endereco.getLogradouro(),
							endereco.getBairro(),
							endereco.getCidade(),
							endereco.getEstado(),
							endereco.getNumero(),
							endereco.getCep()))
		);
		
		return UserDomainResponse.builder()
				.nome(userEntity.getNome())
				.email(userEntity.getEmail())
				.idCarrinho(userEntity.getIdCarrinho())
				.endereco(enderecoUser)
				.build();	
	}
}