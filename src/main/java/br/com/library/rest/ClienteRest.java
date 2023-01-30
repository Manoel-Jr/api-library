package br.com.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.library.dto.ClienteDTO;
import br.com.library.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteRest {


	@Autowired
	private ClienteService service;

	@PostMapping
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody ClienteDTO cliente) {
		return new ResponseEntity<>(service.adicionar(cliente), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> consultar(@PathVariable Long id) {
		return new ResponseEntity<>(service.buscar(id), HttpStatus.OK);
	}

}
