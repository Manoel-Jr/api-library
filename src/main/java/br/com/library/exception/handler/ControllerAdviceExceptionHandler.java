package br.com.library.exception.handler;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.library.exception.CepInvalidoException;
import br.com.library.exception.CepNaoEncontradoException;
import br.com.library.exception.ClienteExistenteException;
import br.com.library.exception.ClienteNaoEncontradoException;
import br.com.library.exception.CpfExistenteException;
import br.com.library.exception.CpfNaoEncontradoException;
import br.com.library.exception.EnderecoNotFoundException;
import br.com.library.exception.FuncionarioNotFoundException;
import br.com.library.exception.StandarError;
import br.com.library.utils.Constantes;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

	@ExceptionHandler(FuncionarioNotFoundException.class)
	public ResponseEntity<StandarError> funcionarioNotFound(FuncionarioNotFoundException ex,
			HttpServletRequest request) {
		StandarError error = new StandarError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
				Constantes.FUNCIONARIO_NAO_EXISTE, request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(CpfExistenteException.class)
	public ResponseEntity<StandarError> cpfBadRequest(CpfExistenteException ex, HttpServletRequest request) {
		StandarError error = new StandarError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				Constantes.CPF_EXISTENTE, request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(CepInvalidoException.class)
	public ResponseEntity<StandarError> cepIvalidoException(CepInvalidoException ex, HttpServletRequest request) {
		StandarError error = new StandarError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				Constantes.CEP_INVALIDO, request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(CepNaoEncontradoException.class)
	public ResponseEntity<StandarError> cepNaoEncontradoException(CepNaoEncontradoException ex,
			HttpServletRequest request) {
		StandarError error = new StandarError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				Constantes.CEP_NAO_ENCONTRADO, request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public ResponseEntity<StandarError> cepNaoEncontradoException(ClienteNaoEncontradoException ex,
			HttpServletRequest request) {
		StandarError error = new StandarError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
				Constantes.CLIENTE_NAO_ENCONTRADO, request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(CpfNaoEncontradoException.class)
	public ResponseEntity<StandarError> cpfNaoEncontradoException(CpfNaoEncontradoException ex,
			HttpServletRequest request) {
		StandarError error = new StandarError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
				Constantes.CPF_NAO_ENCONTRADO, request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(EnderecoNotFoundException.class)
	public ResponseEntity<StandarError> enderecoNaoEncontradoException(EnderecoNotFoundException ex,
			HttpServletRequest request) {
		StandarError error = new StandarError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
				Constantes.ENDERECO_NAO_ENCONTRADO, request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(ClienteExistenteException.class)
	public ResponseEntity<StandarError> enderecoNaoEncontradoException(ClienteExistenteException ex,
			HttpServletRequest request) {
		StandarError error = new StandarError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				Constantes.CLIENTE_JÁ_EXISTE, request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
