package com.github.lucascmorais.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.lucascmorais.vendas.entity.ItemPedido;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {

}