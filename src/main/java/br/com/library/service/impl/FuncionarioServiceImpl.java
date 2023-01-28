package br.com.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.core.MapperConvert;
import br.com.library.dto.EnderecoDTO;
import br.com.library.dto.FuncionarioDTO;
import br.com.library.entity.Endereco;
import br.com.library.entity.Funcionario;
import br.com.library.exception.CepInvalidoException;
import br.com.library.exception.CpfExistenteException;
import br.com.library.exception.EnderecoNotFoundException;
import br.com.library.exception.FuncionarioNotFoundException;
import br.com.library.repositories.FuncionarioRepository;
import br.com.library.service.EnderecoService;
import br.com.library.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private ViaCepService viacepService;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private MapperConvert mapper;

	@Override
	public FuncionarioDTO cadastrar(FuncionarioDTO funcionario) {
		if (funcionarioRepository.existsByCpf(funcionario.getCpf())) {
			throw new CpfExistenteException();
		}
		return recebendoCampos(funcionario);
	}

	private FuncionarioDTO recebendoCampos(FuncionarioDTO funcionario) {
		verificaCep(funcionario.getEndereco().getCep());
		EnderecoDTO dto = viacepService.obterDadosCep(funcionario.getEndereco().getCep());
		Endereco end = mapper.converterParaEndereco(dto);
		Funcionario colaborador = new Funcionario(null, funcionario.getNomeCompleto(), funcionario.getCpf(), end);
		return mapper.converterParaFuncionarioDTO(funcionarioRepository.save(colaborador));
	}

	private void verificaCep(String cep) {
		if (cep == null || cep.length() != 8) {
			throw new CepInvalidoException();
		}
	}

	@Override
	public FuncionarioDTO consultar(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return mapper.converterParaFuncionarioDTO(funcionario.orElseThrow(() -> new FuncionarioNotFoundException()));
	}

	@Override
	public void excluir(Long id) {
		funcionarioRepository.deleteById(id);
	}

	@Override
	public List<Funcionario> listarTodos() {
		return funcionarioRepository.findAll();
	}

	@Override
	public EnderecoDTO consultarEndereco(String cep) {
		List<Funcionario> colaboradores = funcionarioRepository.findFuncionariosByEnderecoCep(cep);
		Funcionario funcionario = colaboradores.stream().filter(func -> func.getEndereco().getCep() != null).findFirst()
				.orElseThrow(EnderecoNotFoundException::new);
		return enderecoService.consultarEnderecoCep(funcionario.getEndereco().getCep());
	}

	@Override
	public FuncionarioDTO editar(Long id, Funcionario funcionario) {
		funcionario.setId(id);
		Funcionario colaborador = funcionarioRepository.save(funcionario);
		BeanUtils.copyProperties(funcionario, colaborador, "cpf");
		return mapper.converterParaFuncionarioDTO(colaborador);
	}
}
