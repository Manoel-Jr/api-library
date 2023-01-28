package br.com.library.exception;

public class CepNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CepNaoEncontradoException(String message) {
		super(message);
	}

	public CepNaoEncontradoException() {

	}
}
