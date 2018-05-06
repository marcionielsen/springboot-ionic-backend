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

import br.com.marcionielsen.cursomc.controllers.interfaces.IGenericaController;
import br.com.marcionielsen.cursomc.domain.Cliente;
import br.com.marcionielsen.cursomc.dto.ClienteDTO;
import br.com.marcionielsen.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController extends AbstrataController implements IGenericaController<Cliente, ClienteDTO> {

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
	public ResponseEntity<List<ClienteDTO>> listAll() {

		List<Cliente> lista = clienteService.listAll();
		
		List<ClienteDTO> listaDTO = lista.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDTO);
	}

	@Override
	public ResponseEntity<Page<ClienteDTO>> listPerPage(Integer numPage, Integer linesPage, String orderBy, String direction) {
		return null;
	}

	@Override
	public ResponseEntity<Void> insert(ClienteDTO obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> update(Long id, ClienteDTO obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> delete(Long id) {
		return null;
	}

}
