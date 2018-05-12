package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Cidade;
import br.com.marcionielsen.cursomc.dto.CidadeDTO;
import br.com.marcionielsen.cursomc.repositories.interfaces.ICidadeRepository;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class CidadeService {

	@Autowired
	private ICidadeRepository repo;

	public Cidade findById(Long id) {
		Optional<Cidade> cidade = repo.findById(id);

		return cidade.orElseThrow(() -> new ObjetoNaoEncontradoException(id.toString(), Cidade.class.getName()));
	}

	public List<Cidade> listAll() {
		List<Cidade> lista = repo.findAll();

		return lista;
	}

	public Page<Cidade> listPerPage(Integer numPage, Integer numLines, String orderBy, String direction) {
		return null;
	}

	public Cidade insert(Cidade obj) {
		return null;
	}

	public Cidade update(Cidade obj) {
		return null;
	}

	public void delete(Long id) {

	}

	public Cidade fromDTO(CidadeDTO obj) {
		return null;
	}

}
