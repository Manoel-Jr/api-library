package br.com.library.core;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.dto.ClienteDTO;
import br.com.library.dto.EnderecoDTO;
import br.com.library.dto.FuncionarioDTO;
import br.com.library.entity.Cliente;
import br.com.library.entity.Endereco;
import br.com.library.entity.Funcionario;

@Service
public class ConvertService {

	@Autowired
	private ModelMapper model;

	public Funcionario converterParaFuncionario(FuncionarioDTO dto) {
		Funcionario funcionario = model.map(dto, Funcionario.class);
		return funcionario;
	}

	public FuncionarioDTO converterParaFuncionarioDTO(Funcionario funcionario) {
		FuncionarioDTO dto = model.map(funcionario, FuncionarioDTO.class);
		return dto;
	}

	public Cliente converterParaCliente(ClienteDTO dto) {
		Cliente cliente = model.map(dto, Cliente.class);
		return cliente;
	}

	public ClienteDTO converterParaClienteDTO(Cliente cliente) {
		ClienteDTO dto = model.map(cliente, ClienteDTO.class);
		return dto;
	}

	public Endereco converterParaEndereco(EnderecoDTO dto) {
		Endereco endereco = model.map(dto, Endereco.class);
		return endereco;
	}

	public EnderecoDTO converterParaEnderecoDTO(Endereco endereco) {
		EnderecoDTO dto = model.map(endereco, EnderecoDTO.class);
		return dto;
	}

}
