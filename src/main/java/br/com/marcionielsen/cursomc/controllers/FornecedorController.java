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

import br.com.marcionielsen.cursomc.domain.Fornecedor;
import br.com.marcionielsen.cursomc.dto.FornecedorDTO;
import br.com.marcionielsen.cursomc.services.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorController extends AbstrataController {

	@Autowired
	private FornecedorService fornecedorService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Fornecedor> findById(@PathVariable Long id) {

		Fornecedor fornecedor = fornecedorService.findById(id);
		return ResponseEntity.ok().body(fornecedor);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<FornecedorDTO>> listAll() {

		List<Fornecedor> lista = fornecedorService.listAll();
		
		List<FornecedorDTO> listaDTO = lista.stream().map(obj -> new FornecedorDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDTO);
	}

	public ResponseEntity<Page<FornecedorDTO>> listPerPage(Integer numPage, Integer linesPage, String orderBy, String direction) {
		return null;
	}

	public ResponseEntity<Void> insert(FornecedorDTO obj) {
		return null;
	}

	public ResponseEntity<Void> update(Long id, FornecedorDTO obj) {
		return null;
	}

	public ResponseEntity<Void> delete(Long id) {
		return null;
	}

}
