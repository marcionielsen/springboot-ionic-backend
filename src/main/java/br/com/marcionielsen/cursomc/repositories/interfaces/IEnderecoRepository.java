package br.com.marcionielsen.cursomc.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import br.com.marcionielsen.cursomc.domain.Endereco;

@Repository
public interface IEnderecoRepository extends JpaRepository<Endereco, Long>, QueryByExampleExecutor<Endereco> {

//	@Query("select e from Endereco e where e.logradouro = :logradouro and e.numero = :numero and e.cep = :cep and e.cliente.id = :clienteId")
//	Optional<Endereco> findByLogradAndNumAndCepAndClienteId(@Param("logradouro") String logradouro,
//			@Param("numero") String numero, @Param("cep") String cep, @Param("clienteId") Long clienteId);

}
