package br.com.marcionielsen.cursomc.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marcionielsen.cursomc.domain.Estado;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, Long> {

}
