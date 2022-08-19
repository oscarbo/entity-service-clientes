package com.demo.rest;

import java.util.List;

import com.demo.model.Cliente;


public interface ClienteInterfaz {
	public List<Cliente> list();
	public Cliente find(int id);
	public Cliente save(Cliente cli);
	public Cliente update(int id, Cliente cli);
	public boolean delete(int id);
}
