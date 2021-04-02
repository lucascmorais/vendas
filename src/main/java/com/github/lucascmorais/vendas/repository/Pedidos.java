package com.github.lucascmorais.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.lucascmorais.vendas.entity.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

}