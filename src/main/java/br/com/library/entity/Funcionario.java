package br.com.library.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "funcionarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@SequenceGenerator(name = "seq_generator", sequenceName = "SEQ_LOJA_DOCUMENTO", initialValue = 5, allocationSize = 1)
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nomeCompleto;

	@Column(unique = true)
	private String cpf;

	@Embedded
	private Endereco endereco;
}