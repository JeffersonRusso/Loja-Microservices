package com.microservice.loja.carrinho.dataprovider;

import java.lang.reflect.Field;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import com.microservice.loja.carrinho.dataprovider.repository.CarrinhoRepository;
import com.microservice.loja.carrinho.dataprovider.repository.entity.CarrinhoEntity;
import com.microservice.loja.carrinho.dataprovider.repository.model.ProdutoModel;
import com.microservice.loja.carrinho.usecase.model.request.CarrinhoDomainRequest;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse;
import static com.microservice.loja.carrinho.dataprovider.mapper.CarrinhoDataProviderDomainMapper.toCarrinhoDomain;

public class CarrinhoDataProvider {
	
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
	
	public Optional<CarrinhoDomainResponse> buscarCarrinhoPorId(CarrinhoDomainRequest carrinhoDomainRequest) {
		
		Optional<CarrinhoEntity> carrinhoEntity = carrinhoRepository.findById(carrinhoDomainRequest.getIdCarrinho());
		
		return carrinhoEntity.isPresent() ? Optional.of(toCarrinhoDomain(carrinhoEntity.get())) : Optional.empty();
 	}
	
	public Optional<CarrinhoDomainResponse> AtualizarProdutoCarrinho(CarrinhoDomainRequest carrinhoDomainRequest) {
		
		Optional<CarrinhoEntity> carrinhoEntity = carrinhoRepository.save(carrinhoDomainRequest, carrinhoDomainRequest.getIdCarrinho());
	}
}
