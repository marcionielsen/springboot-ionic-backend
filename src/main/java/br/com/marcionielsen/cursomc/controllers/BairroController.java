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
import br.com.marcionielsen.cursomc.domain.Bairro;
import br.com.marcionielsen.cursomc.dto.BairroDTO;
import br.com.marcionielsen.cursomc.services.BairroService;

@RestController
@RequestMapping(value = "/bairros")
public class BairroController extends AbstrataController implements IGenericaController<Bairro, BairroDTO> {

	@Autowired
	private BairroService bairroService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Bairro> findById(@PathVariable Long id) {

		Bairro bairro = bairroService.findById(id);
		return ResponseEntity.ok().body(bairro);
	}

	@Override
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<BairroDTO>> listAll() {

		List<Bairro> lista = bairroService.listAll();

		List<BairroDTO> listaDTO = lista.stream().map(obj -> new BairroDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDTO);

	}

	@Override
	public ResponseEntity<Page<BairroDTO>> listPerPage(Integer numPage, Integer linesPage, String orderBy,
			String direction) {
		return null;
	}

	@Override
	public ResponseEntity<Void> insert(BairroDTO obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> update(Long id, BairroDTO obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> delete(Long id) {
		return null;
	}

}
