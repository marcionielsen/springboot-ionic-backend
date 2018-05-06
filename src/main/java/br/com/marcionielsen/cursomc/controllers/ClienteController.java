package br.com.marcionielsen.cursomc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcionielsen.cursomc.controllers.interfaces.IGenericaController;
import br.com.marcionielsen.cursomc.domain.Cliente;
import br.com.marcionielsen.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController extends AbstrataController implements IGenericaController<Cliente> {

	@Autowired
	private ClienteService clienteService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {

		Cliente cliente = clienteService.findById(id);
		return ResponseEntity.ok().body(cliente);
	}

	@Override
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listAll() {

		List<Cliente> lista = clienteService.listAll();
		return ResponseEntity.ok().body(lista);
	}

	@Override
	public ResponseEntity<Void> insert(Cliente obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> update(Long id, Cliente obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> delete(Long id) {
		return null;
	}

}
