package br.com.library.dto;

import java.io.Serializable;

import br.com.library.entity.Endereco;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FuncionarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nomeCompleto;

	private String cpf;

	private Endereco endereco;

	public FuncionarioDTO(Long id,String nomeCompleto,String cpf, Endereco endereco) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.endereco = endereco;
	}

}
