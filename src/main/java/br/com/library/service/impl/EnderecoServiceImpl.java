package br.com.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.dto.EnderecoDTO;
import br.com.library.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private ViaCepService viacepService;

	@Override
	public EnderecoDTO consultarEnderecoCep(String cep) {
		EnderecoDTO dto = viacepService.obterDadosCep(cep);
		return dto;
	}

}
