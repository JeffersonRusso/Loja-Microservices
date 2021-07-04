package com.microservice.loja.estoque.dataprovider.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.loja.estoque.dataprovider.repository.entity.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {
	
	public Optional<ProdutoEntity> findByIdProduto(Integer id);

	public List<ProdutoEntity> findAllByIdProduto();
}
