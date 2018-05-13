package br.com.marcionielsen.cursomc.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import br.com.marcionielsen.cursomc.domain.Bairro;

@Repository
public interface IBairroRepository extends JpaRepository<Bairro, Long>, QueryByExampleExecutor<Bairro> {

//	@Query("select b from Bairro b where b.nome = :nomeBairro and b.cidade.id = :cidadeId")
//	Optional<Bairro> findByNomeAndCidadeId(@Param("nomeBairro") String nomeBairro, @Param("cidadeId") Long cidadeId);

}
