package com.microservice.loja.carrinho.dataprovider;

import static com.microservice.loja.carrinho.dataprovider.mapper.CarrinhoDataProviderDomainMapper.toCarrinhoDomain;
import static com.microservice.loja.carrinho.dataprovider.mapper.CarrinhoDataProviderEntityMapper.forEntity;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.microservice.loja.carrinho.dataprovider.repository.CarrinhoRepository;
import com.microservice.loja.carrinho.dataprovider.repository.entity.CarrinhoEntity;
import com.microservice.loja.carrinho.usecase.gateway.CarrinhoGateway;
import com.microservice.loja.carrinho.usecase.model.request.CarrinhoDomainRequest;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse;

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
	
	public Optional<CarrinhoDomainResponse> buscarCarrinhoPorId(CarrinhoDomainRequest carrinhoDomainRequest) {
		
		Optional<CarrinhoEntity> carrinhoEntity = carrinhoRepository.findById(carrinhoDomainRequest.getIdCarrinho());
		return carrinhoEntity.isPresent() ? Optional.of(toCarrinhoDomain(carrinhoEntity.get())) : Optional.empty();
 	}
	
	public Optional<CarrinhoDomainResponse> atualizarProdutoCarrinho(CarrinhoDomainRequest carrinhoDomainRequest) {		
		
		return Optional.of(
				toCarrinhoDomain(carrinhoRepository.save(
						forEntity(carrinhoDomainRequest))));
	}

	public Optional<CarrinhoDomainResponse> adicionaProduto(CarrinhoDomainRequest carrinhoDomainRequest) {
		
		return Optional.of(
				toCarrinhoDomain(carrinhoRepository.save(
						forEntity(carrinhoDomainRequest))));
	}

	public Optional<CarrinhoDomainResponse> criaCarrinho(String idUsuario) {
		
		Optional<CarrinhoEntity> carrinhoEntity = carrinhoRepository.findById(idUsuario); 
		
		return !carrinhoEntity.isPresent() ? 
			Optional.of(
				toCarrinhoDomain(
					carrinhoRepository.save(new CarrinhoEntity(UUID.randomUUID().toString(), idUsuario, null)))) 
			: Optional.empty()	;
	}
}