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
public class ProdutoController implements IGenericaController<Produto> {

	@Autowired
	private ProdutoService produtoService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {

		Produto produto = produtoService.findById(id);
		return ResponseEntity.ok().body(produto);
	}

	@Override
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> listAll() {

		List<Produto> lista = produtoService.listAll();
		return ResponseEntity.ok().body(lista);
	}

	@Override
	public Produto inserir(Produto obj) {
		return null;
	}

	@Override
	public Produto editar(Produto obj) {
		return null;
	}

	@Override
	public void excluir(Long id) {

	}

}
