package br.com.marcionielsen.cursomc.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcionielsen.cursomc.domain.Produto;
import br.com.marcionielsen.cursomc.dto.ProdutoDTO;
import br.com.marcionielsen.cursomc.dto.ProdutoSearchDTO;
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

	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<ProdutoDTO>> search(@RequestBody ProdutoSearchDTO objDTO,
			@RequestParam(value = "numPage", defaultValue = "0") Integer numPage,
			@RequestParam(value = "numLines", defaultValue = "24") Integer numLines,
			@RequestParam(value = "orderBy", defaultValue = "descricao") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Produto> lista = produtoService.search(objDTO, numPage, numLines, orderBy, direction);

		Page<ProdutoDTO> listaDTO = lista.map(obj -> new ProdutoDTO(obj));

		return ResponseEntity.ok().body(listaDTO);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> listPerPage(
			@RequestParam(value = "numPage", defaultValue = "0") Integer numPage,
			@RequestParam(value = "numLines", defaultValue = "24") Integer numLines,
			@RequestParam(value = "orderBy", defaultValue = "descricao") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Produto> lista = produtoService.listPerPage(numPage, numLines, orderBy, direction);

		Page<ProdutoDTO> listaDTO = lista.map(obj -> new ProdutoDTO(obj));

		return ResponseEntity.ok().body(listaDTO);
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
