package br.com.marcionielsen.cursomc.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import br.com.marcionielsen.cursomc.domain.Cidade;

@Repository
public interface ICidadeRepository extends JpaRepository<Cidade, Long>, QueryByExampleExecutor<Cidade> {

//	@Query("select c from Cidade c where c.nome = :nomeCidade and c.estado.id = :ufId")
//	Optional<Cidade> findByNomeAndUF(@Param("nomeCidade") String nomeCidade, @Param("ufId") Long ufId);
}
