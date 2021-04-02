package com.github.lucascmorais.vendas;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.lucascmorais.vendas.entity.Cliente;
import com.github.lucascmorais.vendas.entity.Pedido;
import com.github.lucascmorais.vendas.repository.Clientes;
import com.github.lucascmorais.vendas.repository.Pedidos;

@SpringBootApplication
public class VendasApplication {
	
    @Bean
    public CommandLineRunner init(
    		@Autowired Clientes clientes,
    		@Autowired Pedidos pedidos
    		){
        return args -> {
            System.out.println("Salvando clientes");
            Cliente fulano = new Cliente("Fulano");
            clientes.save(fulano);
            
            Pedido pedido = new Pedido();
            pedido.setCliente(fulano);
            pedido.setDataPedido(LocalDate.now());
            pedido.setTotal(BigDecimal.valueOf(100));
            
            pedidos.save(pedido);
            
            Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());

        };
    }

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
