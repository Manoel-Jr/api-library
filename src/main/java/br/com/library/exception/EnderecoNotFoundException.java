package br.com.library.exception;

public class EnderecoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EnderecoNotFoundException(String message) {
		super(message);
	}
	
	public EnderecoNotFoundException() {
		
	}
}
