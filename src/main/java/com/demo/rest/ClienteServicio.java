package com.demo.rest;

import com.demo.model.Cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ClienteServicio implements ClienteInterfaz{
	
	private List<Cliente> clientes;

	public ClienteServicio() {
		clientes = new ArrayList<>();
	}

	@Override
	public List<Cliente> list() {
		return clientes;
	}

	// Metodo Buscar Cliente
	@Override
	public Cliente find(int id) {
		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				return cliente;
			}
		}
		return null;
	}

	public Cliente save(Cliente cliente) {
		cliente.setId(clientes.size());
		clientes.add(cliente);
		return cliente;
	}

	public Cliente update(int id, Cliente cliente) {
		int index = 0;
		for (Cliente cl : clientes) {
			if (cl.getId() == id) {
				cliente.setId(id);
				clientes.set(index, cliente);
			}
		}
		return cliente;
	}

	public boolean delete(int id) {
		for (Cliente c : clientes) {
			if (c.getId() == id) {
				return clientes.remove(c);
			}
		}
		return false;
	}

}

