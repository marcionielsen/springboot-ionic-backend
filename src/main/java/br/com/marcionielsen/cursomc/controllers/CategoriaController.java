package br.com.marcionielsen.cursomc.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.marcionielsen.cursomc.controllers.interfaces.IGenericaController;
import br.com.marcionielsen.cursomc.domain.Categoria;
import br.com.marcionielsen.cursomc.services.CategoriaService;
import br.com.marcionielsen.cursomc.util.Util;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController implements IGenericaController<Categoria> {

	@Autowired
	private CategoriaService categoriaService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {

		Categoria categoria = categoriaService.findById(id);
		return ResponseEntity.ok().body(categoria);
	}

	@Override
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> listAll() {

		List<Categoria> lista = categoriaService.listAll();
		return ResponseEntity.ok().body(lista);
	}

	@Override
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Categoria obj) {
		obj = categoriaService.inserir(obj);

		return ResponseEntity.created(getNovaUri("inserir", "/" + obj.getId().toString())).build();
	}

	@Override
	public Categoria editar(Categoria obj) {
		return null;
	}

	@Override
	public void excluir(Long id) {
	}

	private URI getNovaUri(String elementoRemover, String novoElemento) {
		String uriOri = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
		
		String str = Util.removerElementoURI(ServletUriComponentsBuilder.fromCurrentRequest().toUriString(), elementoRemover);

		StringBuilder novaStr = new StringBuilder(str);

		URI novaUri = ServletUriComponentsBuilder.fromUriString(novaStr.toString()).path(novoElemento).build().toUri();

		System.out.println("================================================");
		System.out.println("URI orig: " + uriOri + "\n");
		System.out.println("nova URI: " + novaUri.toString());
		System.out.println("================================================");

		return novaUri;
	}

}
