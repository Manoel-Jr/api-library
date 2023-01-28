package br.com.library.service;

import java.util.List;

import br.com.library.dto.EnderecoDTO;
import br.com.library.dto.FuncionarioDTO;
import br.com.library.entity.Funcionario;

public interface FuncionarioService {

	public FuncionarioDTO cadastrar(FuncionarioDTO funcionario);

	public FuncionarioDTO consultar(Long id);

	public void excluir(Long id);

	public FuncionarioDTO editar(Long id, Funcionario funcionario);

	public List<Funcionario> listarTodos();

	public EnderecoDTO consultarEndereco(String cep);
}
