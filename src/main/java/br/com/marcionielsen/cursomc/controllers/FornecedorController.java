package br.com.marcionielsen.cursomc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcionielsen.cursomc.controllers.interfaces.IGenericaController;
import br.com.marcionielsen.cursomc.domain.Fornecedor;
import br.com.marcionielsen.cursomc.services.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorController extends AbstrataController implements IGenericaController<Fornecedor> {

	@Autowired
	private FornecedorService fornecedorService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Fornecedor> findById(@PathVariable Long id) {

		Fornecedor fornecedor = fornecedorService.findById(id);
		return ResponseEntity.ok().body(fornecedor);
	}

	@Override
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Fornecedor>> listAll() {

		List<Fornecedor> lista = fornecedorService.listAll();
		return ResponseEntity.ok().body(lista);

	}

	@Override
	public ResponseEntity<Void> insert(Fornecedor obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> update(Long id, Fornecedor obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> delete(Long id) {
		return null;
	}

}
