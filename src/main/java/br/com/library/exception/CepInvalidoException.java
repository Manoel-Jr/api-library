package br.com.library.exception;

public class CepInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CepInvalidoException(String message) {
		super(message);
	}

	public CepInvalidoException() {

	}
}
