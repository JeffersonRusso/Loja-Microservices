package com.microservice.loja.estoque.dataprovider.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.microservice.loja.estoque.dataprovider.repository.entity.ProdutoEntity;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<ProdutoEntity, Integer> {
	
	 Optional<ProdutoEntity> findByIdProduto(Integer id);

	 List<ProdutoEntity> findAll();
}
