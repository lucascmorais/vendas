package com.github.lucascmorais.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.lucascmorais.vendas.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer> {

}