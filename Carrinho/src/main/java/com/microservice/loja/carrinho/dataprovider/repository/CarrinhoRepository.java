package com.microservice.loja.carrinho.dataprovider.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.loja.carrinho.dataprovider.repository.entity.CarrinhoEntity;

@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Integer> {
	
	//Optional<CarrinhoEntity> finByIdCarrinho(Integer id);
	
	List<CarrinhoEntity> findAll();
	
	//@Transactional
	//@Modifying
	//@Query(value = "UPDATE CARRINHO_ENTITY_PRODUTOS PRODUTO SET PRODUTO.QUANTIDADE = :quantidade WHERE PRODUTO.ID_PRODUTO = :idProduto AND PRODUTO.CARRINHO_ENTITY_ID_CARRINHO = :idCarrinho", nativeQuery = true)
	//Optional<CarrinhoEntity> atualizaQuantidadeProduto(@Param("idProduto") Integer idProduto, @Param("quantidade") Integer quantidade, @Param("idCarrinho") Integer idCarrinho);

}

//@Modifying
		//@Query("update User u set u.firstname = ?1, u.lastname = ?2 where u.id = ?3")
		//void setUserInfoById(String firstname, String lastname, Integer userId);
		// ao inves de um get dps um atualização, é melhor só fazer um att direto.
		//https://stackoverflow.com/questions/11881479/how-do-i-update-an-entity-using-spring-data-jpa
		