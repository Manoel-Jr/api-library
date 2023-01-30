package br.com.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.library.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	public boolean existsByCpf(String cpf);

	public List<Funcionario> findFuncionariosByEnderecoCep(String cep);

	public Funcionario findByEnderecoCep(String cep);
	

}
