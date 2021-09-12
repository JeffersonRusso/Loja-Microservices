package com.microservice.loja.usuario.usecase.model.response;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.microservice.loja.usuario.dataprovider.repository.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class UserDomainResponse {
	
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