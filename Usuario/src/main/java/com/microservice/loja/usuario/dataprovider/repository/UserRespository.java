package com.microservice.loja.usuario.dataprovider.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.loja.usuario.dataprovider.repository.entity.UserEntity;
import com.microservice.loja.usuario.usecase.model.response.UserDomainResponse;

@Repository
public interface UserRespository extends JpaRepository<UserEntity, String> {
	
	Optional<UserEntity> findByEmail(String email);
	
	//UserEntity createAccount(UserDomainResponse userDomain);

}
