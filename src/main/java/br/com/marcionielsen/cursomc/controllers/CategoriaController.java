package br.com.marcionielsen.cursomc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcionielsen.cursomc.controllers.interfaces.IGenericaController;
import br.com.marcionielsen.cursomc.domain.Categoria;
import br.com.marcionielsen.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController extends AbstrataController implements IGenericaController<Categoria> {

	@Autowired
	private CategoriaService categoriaService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {

		Categoria categoria = categoriaService.findById(id);
		return ResponseEntity.ok().body(categoria);
	}

	@Override
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> listAll() {

		List<Categoria> lista = categoriaService.listAll();
		return ResponseEntity.ok().body(lista);
	}

	@Override
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = categoriaService.insert(obj);

		return ResponseEntity.created(super.getNovaUri("inserir", "/" + obj.getId().toString())).build();
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Categoria obj) {
		obj.setId(id);
		obj = categoriaService.update(obj);
		
		return ResponseEntity.noContent().build();
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		categoriaService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
