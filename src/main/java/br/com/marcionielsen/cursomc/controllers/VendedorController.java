package br.com.marcionielsen.cursomc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcionielsen.cursomc.controllers.interfaces.IGenericaController;
import br.com.marcionielsen.cursomc.domain.Vendedor;
import br.com.marcionielsen.cursomc.services.VendedorService;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorController implements IGenericaController<Vendedor> {

	@Autowired
	private VendedorService vendedorService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {

		Vendedor vendedor = vendedorService.findById(id);
		return ResponseEntity.ok().body(vendedor);
	}

	@Override
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> listAll() {

		List<Vendedor> lista = vendedorService.listAll();
		return ResponseEntity.ok().body(lista);

	}

	@Override
	public Vendedor inserir(Vendedor obj) {
		return null;
	}

	@Override
	public Vendedor editar(Vendedor obj) {
		return null;
	}

	@Override
	public void excluir(Long id) {

	}

}
