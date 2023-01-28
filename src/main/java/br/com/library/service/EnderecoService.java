package br.com.library.service;

import br.com.library.dto.EnderecoDTO;

public interface EnderecoService {

	public EnderecoDTO consultarEnderecoCep(String cep);
}
