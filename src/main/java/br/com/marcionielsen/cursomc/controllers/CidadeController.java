package br.com.marcionielsen.cursomc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcionielsen.cursomc.controllers.interfaces.IGenericaController;
import br.com.marcionielsen.cursomc.domain.Cidade;
import br.com.marcionielsen.cursomc.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController extends AbstrataController implements IGenericaController<Cidade> {

	@Autowired
	private CidadeService cidadeService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cidade> findById(@PathVariable Long id) {

		Cidade cidade = cidadeService.findById(id);
		return ResponseEntity.ok().body(cidade);
	}

	@Override
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Cidade>> listAll() {

		List<Cidade> lista = cidadeService.listAll();
		return ResponseEntity.ok().body(lista);

	}

	@Override
	public ResponseEntity<Void> insert(Cidade obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> update(Long id, Cidade obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> delete(Long id) {
		return null;
	}

}
