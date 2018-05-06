package br.com.marcionielsen.cursomc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcionielsen.cursomc.controllers.interfaces.IGenericaController;
import br.com.marcionielsen.cursomc.domain.Produto;
import br.com.marcionielsen.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController extends AbstrataController implements IGenericaController<Produto> {

	@Autowired
	private ProdutoService produtoService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> findById(@PathVariable Long id) {

		Produto produto = produtoService.findById(id);
		return ResponseEntity.ok().body(produto);
	}

	@Override
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listAll() {

		List<Produto> lista = produtoService.listAll();
		return ResponseEntity.ok().body(lista);
	}

	@Override
	public ResponseEntity<Void> insert(Produto obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> update(Long id, Produto obj) {
		return null;
	}

	@Override
	public void delete(Long id) {

	}

}
