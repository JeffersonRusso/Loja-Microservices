package com.microservice.loja.usuario.dataprovider.repository.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_role", 
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>();
	
	@ElementCollection
	private List<Endereco> endereco;
	
	@Id
	private String id;
	private String nome;
	
	@Column (unique = true)
	private String idCarrinho;
	
	@Column (unique = true)
	private String email;
	private String password;
	
	
	@Builder
	@Getter
	@Setter
	@AllArgsConstructor
	public static class Endereco implements Serializable {

		private int idEndereco;
		private String Logradouro;
		private String Bairro;
		private String cidade;
		private String estado;
		private int numero;
		private int cep;
	
	}
}