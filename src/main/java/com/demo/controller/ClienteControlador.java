package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Cliente;
import com.demo.rest.ClienteServicio;


@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

	private final ClienteServicio service;

	public ClienteControlador(ClienteServicio service) {
		this.service = service;
	}
	

	@GetMapping
	public Iterable<Cliente> list() {
		return service.list();
	}

	@GetMapping("/{id}")
	public Cliente find(@PathVariable("id") int id) {
		return service.find(id);
	}

	@PostMapping
	public void insertar (@RequestBody Cliente cliente) {
		service.save(cliente);
	}

	@PutMapping
	public void modificar(@PathVariable("id") int id, @RequestBody Cliente cliente) {
		service.update(id, cliente);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") int id) {
		service.delete(id);
	}

}

