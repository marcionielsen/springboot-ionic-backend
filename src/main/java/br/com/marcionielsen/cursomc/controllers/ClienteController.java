package br.com.marcionielsen.cursomc.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcionielsen.cursomc.controllers.interfaces.IGenericaController;
import br.com.marcionielsen.cursomc.domain.Cliente;
import br.com.marcionielsen.cursomc.dto.ClienteDTO;
import br.com.marcionielsen.cursomc.dto.ClienteEnderecoTelefonesDTO;
import br.com.marcionielsen.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController extends AbstrataController implements IGenericaController<Cliente, ClienteDTO, ClienteEnderecoTelefonesDTO> {

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
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ClienteDTO>> listPerPage(
			@RequestParam(value = "numPage", defaultValue = "0") Integer numPage,
			@RequestParam(value = "linesPage", defaultValue = "24") Integer linesPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Cliente> lista = clienteService.listPerPage(numPage, linesPage, orderBy, direction);

		Page<ClienteDTO> listaDTO = lista.map(obj -> new ClienteDTO(obj));

		return ResponseEntity.ok().body(listaDTO);
	}

	@Override
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteEnderecoTelefonesDTO objDTO) {
		Cliente obj = clienteService.insert(clienteService.fromDTO(objDTO));

		return ResponseEntity.created(super.getNovaUri("inserir", "/" + obj.getId().toString())).build();
	}
	
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody ClienteDTO objDTO) {

		objDTO.setId(id);

		clienteService.update(clienteService.fromDTO(objDTO));

		return ResponseEntity.noContent().build();
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clienteService.delete(id);

		return ResponseEntity.noContent().build();
	}

}
