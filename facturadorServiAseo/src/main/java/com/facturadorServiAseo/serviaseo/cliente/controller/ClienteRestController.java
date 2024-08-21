package com.facturadorServiAseo.serviaseo.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturadorServiAseo.serviaseo.cliente.entities.ClienteEntity;
import com.facturadorServiAseo.serviaseo.cliente.service.ClienteService;

@RestController
@RequestMapping
public class ClienteRestController {

	@Autowired
	ClienteService clienteService;

	@GetMapping("/conusulta/{cedula}")
	public String consultaCliente(@PathVariable String cedula) {
		return clienteService.consultaCliente(cedula);
	}

	@PostMapping("/usuarioPr")
	ResponseEntity<?> savaUsuarioPr(@RequestBody ClienteEntity usuario) {
		return clienteService.saveUsuarioPr(usuario);
	}

	@GetMapping("/usuario")
	ResponseEntity<?> getUsuario() {
		return clienteService.getUsuario();
	}

	@GetMapping("/usuario/{id}")
	ResponseEntity<?> getUsuario(@PathVariable String id) {
		return clienteService.getUsuarioId(id);
	}

	@PostMapping("/usuario")
	ResponseEntity<?> saveUsuario(@RequestBody ClienteEntity usuario) {
		return clienteService.saveUsuario(usuario);
	}

	@PutMapping("/usuario/{id}")
	ResponseEntity<?> updateUsuario(@PathVariable String id, @RequestBody ClienteEntity usuario) {
		try {
			return clienteService.updateUsuario(id, usuario);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage() + ": verificar datos ingresados", HttpStatus.OK);

		}
	}

	@DeleteMapping("/usuario/{id}")
	ResponseEntity<?> deleteUsuario(@PathVariable String id) {
		return clienteService.deleteUsuario(id);
	}

}
