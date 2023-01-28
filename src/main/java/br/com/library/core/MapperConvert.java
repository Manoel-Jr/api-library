package br.com.library.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.library.dto.ClienteDTO;
import br.com.library.dto.EnderecoDTO;
import br.com.library.dto.FuncionarioDTO;
import br.com.library.entity.Cliente;
import br.com.library.entity.Endereco;
import br.com.library.entity.Funcionario;

@Configuration
public class MapperConvert {

	@Autowired
	private ConfigMapper mapper;

	public Funcionario converterParaFuncionario(FuncionarioDTO dto) {
		Funcionario funcionario = ((ConfigMapper) mapper).model().map(dto, Funcionario.class);
		return funcionario;
	}

	public FuncionarioDTO converterParaFuncionarioDTO(Funcionario funcionario) {
		FuncionarioDTO dto = mapper.model().map(funcionario, FuncionarioDTO.class);
		return dto;
	}

	public Cliente converterParaCliente(ClienteDTO dto) {
		Cliente cliente = mapper.model().map(dto, Cliente.class);
		return cliente;
	}

	public ClienteDTO converterParaClienteDTO(Cliente cliente) {
		ClienteDTO dto = mapper.model().map(cliente, ClienteDTO.class);
		return dto;
	}
	
	
	public Endereco converterParaEndereco(EnderecoDTO dto) {
		Endereco endereco = mapper.model().map(dto, Endereco.class);
		return endereco;
	}

	public EnderecoDTO converterParaEnderecoDTO(Endereco endereco) {
		EnderecoDTO dto = mapper.model().map(endereco, EnderecoDTO.class);
		return dto;
	}
}
