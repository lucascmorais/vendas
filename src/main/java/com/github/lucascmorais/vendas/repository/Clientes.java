package com.github.lucascmorais.vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.lucascmorais.vendas.entity.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer> {

	@Query(value = " select * from Cliente c where c.nome like :nome", nativeQuery = true)
    List<Cliente> findByNameLike(@Param("nome") String nome);
	
	@Query(value = " delete from Cliente c where c.nome = :nome")
	@Modifying
	void deleteByName(String nome);

    boolean existsByNome(String nome);
    
    @Query(value = " select c from Cliente c left join fetch c.pedidos p where c.id = :id")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);

}