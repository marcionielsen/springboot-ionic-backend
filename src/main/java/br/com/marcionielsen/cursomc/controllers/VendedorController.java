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

import br.com.marcionielsen.cursomc.domain.Vendedor;
import br.com.marcionielsen.cursomc.dto.VendedorDTO;
import br.com.marcionielsen.cursomc.services.VendedorService;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorController extends AbstrataController {

	@Autowired
	private VendedorService vendedorService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vendedor> findById(@PathVariable Long id) {

		Vendedor vendedor = vendedorService.findById(id);
		return ResponseEntity.ok().body(vendedor);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<VendedorDTO>> listAll() {

		List<Vendedor> lista = vendedorService.listAll();
		
		List<VendedorDTO> listaDTO = lista.stream().map(obj -> new VendedorDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDTO);
	}

	public ResponseEntity<Page<VendedorDTO>> listPerPage(Integer numPage, Integer linesPage, String orderBy, String direction) {
		return null;
	}

	public ResponseEntity<Void> insert(VendedorDTO obj) {
		return null;
	}

	public ResponseEntity<Void> update(Long id, VendedorDTO obj) {
		return null;
	}

	public ResponseEntity<Void> delete(Long id) {
		return null;
	}

}
