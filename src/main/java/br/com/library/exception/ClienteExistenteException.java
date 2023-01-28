package br.com.library.exception;

public class ClienteExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteExistenteException(String message) {
		super(message);
	}

	public ClienteExistenteException() {

	}
}
