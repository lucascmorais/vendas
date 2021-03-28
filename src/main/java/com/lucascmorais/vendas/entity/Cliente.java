package com.lucascmorais.vendas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", length = 100)
    private String nome;
    
    public Cliente() {
	}
    
	public Cliente(Long id, String nome) {
		super();
		this.nome = nome;
		this.id = id;
	}
	
	public Cliente(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
    
}
