package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Produto;
import br.com.marcionielsen.cursomc.dto.ProdutoDTO;
import br.com.marcionielsen.cursomc.repositories.interfaces.IProdutoRepository;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;
import br.com.marcionielsen.cursomc.services.interfaces.IGenericaService;

@Service
public class ProdutoService implements IGenericaService<Produto, ProdutoDTO> {

	@Autowired
	private IProdutoRepository repo;

	@Override
	public Produto findById(Long id) {
		Optional<Produto> produto = repo.findById(id);

		return produto.orElseThrow(() -> new ObjetoNaoEncontradoException(id.toString(), Produto.class.getName()));
	}

	@Override
	public List<Produto> listAll() {
		List<Produto> lista = repo.findAll();

		return lista;
	}

	@Override
	public Page<Produto> listPerPage(Integer numPage, Integer numLines, String orderBy, String direction) {
		return null;
	}

	@Override
	public Produto insert(Produto obj) {
		return null;
	}

	@Override
	public Produto update(Produto obj) {
		return null;
	}

	@Override
	public void delete(Long id) {
	}

	@Override
	public Produto fromDTO(ProdutoDTO obj) {
		return null;
	}
	
}
