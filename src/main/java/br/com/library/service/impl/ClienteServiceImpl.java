package br.com.library.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.core.ConvertService;
import br.com.library.dto.ClienteDTO;
import br.com.library.dto.EnderecoDTO;
import br.com.library.entity.Cliente;
import br.com.library.entity.Endereco;
import br.com.library.exception.CepInvalidoException;
import br.com.library.exception.ClienteExistenteException;
import br.com.library.exception.ClienteNaoEncontradoException;
import br.com.library.repositories.ClienteRepository;
import br.com.library.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ConvertService convert;

	@Autowired
	private ViaCepService viacepService;

	@Autowired
	private ClienteRepository repository;

	private ClienteDTO preenchendoCampos(ClienteDTO cliente) {
		verificaCep(cliente.getEndereco().getCep());
		EnderecoDTO enderecoDto = viacepService.obterDadosCep(cliente.getEndereco().getCep());
		Endereco endereco = convert.converterParaEndereco(enderecoDto);
		Cliente pessoa = new Cliente(null, cliente.getNomeCompleto(), cliente.getCpf(), endereco);
		return convert.converterParaClienteDTO(repository.save(pessoa));
	}

	private void verificaCep(String cep) {
		if (cep == null || cep.length() != 8) {
			throw new CepInvalidoException();
		}
	}

	@Override
	public ClienteDTO adicionar(ClienteDTO cliente) {
		if (repository.existsByCpf(cliente.getCpf())) {
			throw new ClienteExistenteException();
		}
		return preenchendoCampos(cliente);
	}

	@Override
	public ClienteDTO buscar(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		return convert.converterParaClienteDTO(cliente.orElseThrow(()-> new ClienteNaoEncontradoException()));
	}
}
