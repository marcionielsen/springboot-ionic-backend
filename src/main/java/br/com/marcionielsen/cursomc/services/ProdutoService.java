package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Categoria;
import br.com.marcionielsen.cursomc.domain.Produto;
import br.com.marcionielsen.cursomc.dto.ProdutoDTO;
import br.com.marcionielsen.cursomc.dto.ProdutoSearchDTO;
import br.com.marcionielsen.cursomc.repositories.interfaces.ICategoriaRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IProdutoRepository;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class ProdutoService {

	@Autowired
	private IProdutoRepository repo;

	@Autowired
	private ICategoriaRepository repoCategoria;
	
	public Produto findById(Long id) {
		Optional<Produto> produto = repo.findById(id);

		return produto.orElseThrow(() -> new ObjetoNaoEncontradoException(id.toString(), Produto.class.getName()));
	}

	public List<Produto> listAll() {
		List<Produto> lista = repo.findAll();

		return lista;
	}

	public Page<Produto> search(ProdutoSearchDTO objDto, Integer numPage, Integer numLines, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(numPage, numLines, Direction.valueOf(direction), orderBy);
		
		List<Categoria> listaCategorias = repoCategoria.findAllById(objDto.getListaCategorias());
		
		return repo.findProdutoDistinctByDescricaoContainingAndCategoriasIn(objDto.getDescricao(), listaCategorias, pageRequest);
	}
	
	public Page<Produto> listPerPage(Integer numPage, Integer numLines, String orderBy, String direction) {
		return null;
	}

	public Produto insert(Produto obj) {
		return null;
	}

	public Produto update(Produto obj) {
		return null;
	}

	public void delete(Long id) {
	}

	public ProdutoDTO fromEntity(Produto obj) {
		ProdutoDTO objDTO = new ProdutoDTO(obj);
		
		return objDTO;
	}
	
	public Produto fromDTO(ProdutoDTO obj) {
		return null;
	}
	
}
