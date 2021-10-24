package com.microservice.loja.estoque.dataprovider.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservice.loja.estoque.dataprovider.repository.entity.ProdutoEntity;

/**@author Jefferson Russo
 * @since  29/07/2021
 * 
 * Repositorio com objetivo de retornar os PRODUTO.
 */

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<ProdutoEntity, Integer>, JpaSpecificationExecutor<ProdutoEntity> {
	
	Optional<ProdutoEntity> findByIdProdutoAndAtivoTrue(String id);

	List<ProdutoEntity> findAllByNomeLike(String nome);
	
	List<ProdutoEntity> findByIdProdutoIn(List<String> ids);
}