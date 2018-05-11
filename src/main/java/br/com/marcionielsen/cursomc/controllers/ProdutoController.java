package br.com.marcionielsen.cursomc.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcionielsen.cursomc.domain.Produto;
import br.com.marcionielsen.cursomc.dto.ProdutoDTO;
import br.com.marcionielsen.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController extends AbstrataController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> findById(@PathVariable Long id) {

		Produto produto = produtoService.findById(id);
		return ResponseEntity.ok().body(produto);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoDTO>> listAll() {

		List<Produto> lista = produtoService.listAll();
		
		List<ProdutoDTO> listaDTO = lista.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDTO);
	}

	public ResponseEntity<Page<ProdutoDTO>> listPerPage(Integer numPage, Integer linesPage, String orderBy, String direction) {
		return null;
	}

	public ResponseEntity<Void> insert(ProdutoDTO obj) {
		return null;
	}

	public ResponseEntity<Void> update(Long id, ProdutoDTO obj) {
		return null;
	}

	public ResponseEntity<Void> delete(Long id) {
		return null;
	}

}
