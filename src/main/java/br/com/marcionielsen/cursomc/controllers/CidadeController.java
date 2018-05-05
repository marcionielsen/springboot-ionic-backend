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
public class CidadeController implements IGenericaController<Cidade> {

	@Autowired
	private CidadeService cidadeService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {

		Cidade cidade = cidadeService.findById(id);
		return ResponseEntity.ok().body(cidade);
	}

	@Override
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> listAll() {

		List<Cidade> lista = cidadeService.listAll();
		return ResponseEntity.ok().body(lista);

	}

	@Override
	public ResponseEntity<Void> inserir(Cidade obj) {
		return null;
	}

	@Override
	public Cidade editar(Cidade obj) {
		return null;
	}

	@Override
	public void excluir(Long id) {

	}

}
