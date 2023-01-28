package br.com.library.dto;

import java.io.Serializable;

import br.com.library.entity.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nomeCompleto;

	private String cpf;
	
	private Endereco endereco;

//	private String bairro;
//
//	private String localidade;
//
//	private String uf;

	public ClienteDTO(Long id, String nomeCompleto, String cpf, Endereco endereco) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	

}
