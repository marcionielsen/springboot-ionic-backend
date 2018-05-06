package br.com.marcionielsen.cursomc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class VendedorController extends AbstrataController implements IGenericaController<Vendedor> {

	@Autowired
	private VendedorService vendedorService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vendedor> findById(@PathVariable Long id) {

		Vendedor vendedor = vendedorService.findById(id);
		return ResponseEntity.ok().body(vendedor);
	}

	@Override
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<?>> listAll() {

		List<Vendedor> lista = vendedorService.listAll();
		return ResponseEntity.ok().body(lista);

	}

	@Override
	public ResponseEntity<Page<?>> listPerPage(Integer numPage, Integer linesPage, String orderBy, String direction) {
		return null;
	}

	@Override
	public ResponseEntity<Void> insert(Vendedor obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> update(Long id, Vendedor obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> delete(Long id) {
		return null;
	}

}
