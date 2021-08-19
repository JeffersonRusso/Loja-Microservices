package com.microservice.loja.carrinho.dataprovider;

import static com.microservice.loja.carrinho.dataprovider.mapper.CarrinhoDataProviderDomainMapper.toCarrinhoDomain;
import static com.microservice.loja.carrinho.dataprovider.mapper.CarrinhoDataProviderEntityMapper.forEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.JDBCException;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Splitter;
import com.microservice.loja.carrinho.dataprovider.repository.CarrinhoRepository;
import com.microservice.loja.carrinho.dataprovider.repository.entity.CarrinhoEntity;
import com.microservice.loja.carrinho.usecase.gateway.CarrinhoGateway;
import com.microservice.loja.carrinho.usecase.model.request.CarrinhoDomainRequest;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse;

@Component
public class CarrinhoDataProvider implements CarrinhoGateway  {
	
	/**
	 * @author Jefferson Russo
	 * @since 31/07/2021
	 * 
	 * Classe que trabalha junto ao repositorio, é uma abstração para o repositorio
	 * todo acesso a dados partem dessa classe
	 * classe que consulta o repositorio do CARRINHO
	 * cada USUARIO tem UM CARRINHO, exemplo : ID_USUARIO 1 ... 1 ID_CARRINHO
	 */
	
	private CarrinhoRepository carrinhoRepository;
	
	@Autowired
	public CarrinhoDataProvider (CarrinhoRepository carrinhoRepository) {
		this.carrinhoRepository = carrinhoRepository;
	}
	
	@Override
	public Optional<CarrinhoDomainResponse> buscarCarrinhoPorId(CarrinhoDomainRequest carrinhoDomainRequest) {
		
		Optional<CarrinhoEntity> carrinhoEntity = carrinhoRepository.findById(carrinhoDomainRequest.getIdCarrinho());
		
		return carrinhoEntity.isPresent() ? Optional.of(toCarrinhoDomain(carrinhoEntity.get())) : Optional.empty();
 	}
	
	@Override
	public Optional<CarrinhoDomainResponse> AtualizarProdutoCarrinho(CarrinhoDomainRequest carrinhoDomainRequest) {
			
		//Optional<CarrinhoEntity> carrinhoEntity = carrinhoRepository.atualizaQuantidadeProduto
			//	(carrinhoDomainRequest.getProduto().getIdProduto(),
			//	 carrinhoDomainRequest.getProduto().getQuantidade(),
			//	 carrinhoDomainRequest.getIdCarrinho());
		
		//return Optional.of(carrinhoEntity).isPresent() ? Optional.of(toCarrinhoDomain(carrinhoEntity.get()))
			//	: Optional.empty();
		
		return null;
	}

	@Override
	public Optional<CarrinhoDomainResponse> adicionarProduto(CarrinhoDomainRequest carrinhoDomainRequest) {
		
		CarrinhoEntity carrinhoEntity = carrinhoRepository.findById(carrinhoDomainRequest.getIdCarrinho()).get();
		
		carrinhoRepository.save(atualizaProdutosEntidade(carrinhoEntity, carrinhoDomainRequest));
		
		return Optional.of(carrinhoEntity).isPresent() ? Optional.of(toCarrinhoDomain(carrinhoEntity))
				: Optional.empty();
	}
	
	public CarrinhoEntity atualizaProdutosEntidade(CarrinhoEntity carrinhoDesatualizado, CarrinhoDomainRequest produtoAtualizado) {
		
		Map<String, String> produtosCarrinho = new HashMap<String, String>();
		
		Map<String, String> produtosSeparados = Splitter.on(",").withKeyValueSeparator(":").split(carrinhoDesatualizado.getProdutos());
		
		String stringProdutos = null;

		if(produtosSeparados.containsKey(produtoAtualizado.getProduto().getIdProduto())) {
			int quantidade = Integer.parseInt(produtosSeparados.get(produtoAtualizado.getProduto().getIdProduto())) + produtoAtualizado.getProduto().getQuantidade();
			stringProdutos += produtoAtualizado.getProduto().getIdProduto() + ":"+ String.valueOf(quantidade) + ",";
		} else {
			stringProdutos += produtoAtualizado.getProduto().getIdProduto() + ":"+ produtoAtualizado.getProduto().getQuantidade() + ",";
		}
				
		return new CarrinhoEntity(produtoAtualizado.getIdCarrinho(), 1, stringProdutos );
	}
}