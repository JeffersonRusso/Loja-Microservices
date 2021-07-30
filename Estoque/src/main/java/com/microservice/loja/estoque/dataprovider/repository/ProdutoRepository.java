package com.microservice.loja.estoque.dataprovider.repository;

import java.util.List;
import java.util.Optional;

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
public interface ProdutoRepository extends PagingAndSortingRepository<ProdutoEntity, Integer> {
	
	 Optional<ProdutoEntity> findByIdProduto(Integer id);

	 List<ProdutoEntity> findAll();
	 
	 @Query(value = "select * from tb_produto where id_Produto in :ids", nativeQuery = true )
	 List<ProdutoEntity> findByIds(@Param("ids") List<Integer> postIdsList );
}