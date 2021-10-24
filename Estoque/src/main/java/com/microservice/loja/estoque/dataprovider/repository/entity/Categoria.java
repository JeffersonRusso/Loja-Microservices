package com.microservice.loja.estoque.dataprovider.repository.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria {
	
	@Id
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.ALL)
	private Set<ProdutoEntity> products = new HashSet(); 

	public Categoria(String nome) {
		this.nome = nome;
	}
	
	private String getNome() {
		return this. nome;
	}
}
