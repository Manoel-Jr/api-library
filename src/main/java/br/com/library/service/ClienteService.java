package br.com.library.service;

import org.springframework.stereotype.Service;

import br.com.library.dto.ClienteDTO;

@Service
public interface ClienteService {

	public ClienteDTO adicionar(ClienteDTO cliente);

	public ClienteDTO buscar(Long id);
}
