package com.lucascmorais.vendas.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lucascmorais.vendas.entity.Cliente;

@Repository
public class Clientes {
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public Cliente save(Cliente cliente) {
		entityManager.persist(cliente);
		return cliente;
	}
	
	@Transactional
	public Cliente update(Cliente cliente) {
		entityManager.merge(cliente);
		return cliente;
	}
	
	@Transactional
	public void delete(Cliente cliente) {
		if(!entityManager.contains(cliente)){
            cliente = entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
	}
	
	@Transactional
	public void delete(Long id) {
		Cliente cliente = entityManager.find(Cliente.class, id);
		delete(cliente);
	}
	
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return entityManager.createQuery("from Cliente", Cliente.class)
				.getResultList();
	}
	
	@Transactional(readOnly = true)
	public List<Cliente> findByName(String name) {
		String jpql = " select c from Cliente c where c.nome like :nome ";
		TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
		query.setParameter("nome", "%" + name +"%");
		return query.getResultList();
	}
	
}
