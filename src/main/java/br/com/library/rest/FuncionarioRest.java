package br.com.library.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.library.dto.EnderecoDTO;
import br.com.library.dto.FuncionarioDTO;
import br.com.library.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioRest {

	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping
	public ResponseEntity<FuncionarioDTO> cadFuncionario(@RequestBody FuncionarioDTO dto) {
		return new ResponseEntity<>(funcionarioService.cadastrar(dto), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioDTO> buscar(@PathVariable Long id) {
		return new ResponseEntity<>(funcionarioService.consultar(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deletarFuncionario(@PathVariable Long id) {
		funcionarioService.excluir(id);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<FuncionarioDTO> atualizar(@PathVariable Long id, @RequestBody FuncionarioDTO colaborador) {
		return new ResponseEntity<>(funcionarioService.editar(id, colaborador), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<FuncionarioDTO>> listar() {
		return new ResponseEntity<>(funcionarioService.listaFuncionariosDTOs(), HttpStatus.OK);
	}

	@GetMapping("/consultar-endereco-viacep/{cep}")
	public ResponseEntity<EnderecoDTO> consultarEndereco(@PathVariable(name = "cep") String cep) {
		return new ResponseEntity<>(funcionarioService.consultarEndereco(cep), HttpStatus.OK);
	}

}
