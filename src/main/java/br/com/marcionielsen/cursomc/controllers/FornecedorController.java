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
public class FornecedorController implements IGenericaController<Fornecedor> {

	@Autowired
	private FornecedorService fornecedorService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {

		Fornecedor fornecedor = fornecedorService.findById(id);
		return ResponseEntity.ok().body(fornecedor);
	}

	@Override
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> listAll() {

		List<Fornecedor> lista = fornecedorService.listAll();
		return ResponseEntity.ok().body(lista);

	}

	@Override
	public Fornecedor inserir(Fornecedor obj) {
		return null;
	}

	@Override
	public Fornecedor editar(Fornecedor obj) {
		return null;
	}

	@Override
	public void excluir(Long id) {

	}

}
