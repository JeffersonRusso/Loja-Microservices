package com.microservice.loja.carrinho.dataprovider.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.loja.carrinho.dataprovider.repository.entity.CarrinhoEntity;

@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Integer> {
	
	Optional<CarrinhoEntity> findById(Integer id);
	
	List<CarrinhoEntity> findAll();

}