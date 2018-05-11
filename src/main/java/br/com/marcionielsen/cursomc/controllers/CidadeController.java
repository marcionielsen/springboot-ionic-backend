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

import br.com.marcionielsen.cursomc.domain.Cidade;
import br.com.marcionielsen.cursomc.dto.CidadeDTO;
import br.com.marcionielsen.cursomc.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController extends AbstrataController {

	@Autowired
	private CidadeService cidadeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cidade> findById(@PathVariable Long id) {

		Cidade cidade = cidadeService.findById(id);
		return ResponseEntity.ok().body(cidade);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> listAll() {

		List<Cidade> lista = cidadeService.listAll();

		List<CidadeDTO> listaDTO = lista.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaDTO);
	}

	public ResponseEntity<Page<CidadeDTO>> listPerPage(Integer numPage, Integer linesPage, String orderBy, String direction) {
		return null;
	}

	public ResponseEntity<Void> insert(CidadeDTO obj) {
		return null;
	}

	public ResponseEntity<Void> update(Long id, CidadeDTO obj) {
		return null;
	}

	public ResponseEntity<Void> delete(Long id) {
		return null;
	}

}
