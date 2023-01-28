package br.com.library.exception;

public class FuncionarioNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FuncionarioNotFoundException(String message) {
		super(message);
	}

	public FuncionarioNotFoundException() {

	}

}
