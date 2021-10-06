package com.microservice.loja.usuario.entrypoint.model.response;

import java.io.Serializable;
import java.util.List;

import com.microservice.loja.usuario.usecase.model.response.UserDomainResponse.Endereco;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModelResponse {
	
	private String nome;
	private String email;
	private String idCarrinho;
	private List<Endereco> endereco;
	
	@AllArgsConstructor
	@Getter
	public static class Endereco {
	
	private int idEndereco;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private int numero;
	private int cep;
	}
}