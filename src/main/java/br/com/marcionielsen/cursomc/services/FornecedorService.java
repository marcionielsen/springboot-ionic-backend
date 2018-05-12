package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Fornecedor;
import br.com.marcionielsen.cursomc.dto.FornecedorDTO;
import br.com.marcionielsen.cursomc.repositories.interfaces.IFornecedorRepository;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class FornecedorService {

	@Autowired
	private IFornecedorRepository repo;

	public Fornecedor findById(Long id) {
		Optional<Fornecedor> fornecedor = repo.findById(id);

		return fornecedor
				.orElseThrow(() -> new ObjetoNaoEncontradoException(id.toString(), Fornecedor.class.getName()));
	}

	public List<Fornecedor> listAll() {
		List<Fornecedor> lista = repo.findAll();

		return lista;
	}

	public Page<Fornecedor> listPerPage(Integer numPage, Integer numLines, String orderBy, String direction) {
		return null;
	}

	public Fornecedor insert(Fornecedor obj) {
		return null;
	}

	public Fornecedor update(Fornecedor obj) {
		return null;
	}

	public void delete(Long id) {

	}

	public Fornecedor fromDTO(FornecedorDTO obj) {
		return null;
	}

}
