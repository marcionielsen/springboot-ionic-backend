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
import br.com.marcionielsen.cursomc.domain.Categoria;
import br.com.marcionielsen.cursomc.dto.CategoriaDTO;
import br.com.marcionielsen.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController extends AbstrataController implements IGenericaController<Categoria, CategoriaDTO> {

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
	public ResponseEntity<List<CategoriaDTO>> listAll() {

		List<Categoria> lista = categoriaService.listAll();

		List<CategoriaDTO> listaDTO = lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDTO);
	}

	@Override
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> listPerPage(@RequestParam(value = "numPage", defaultValue = "0") Integer numPage,
			@RequestParam(value = "linesPage", defaultValue = "24") Integer linesPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Categoria> lista = categoriaService.listPerPage(numPage, linesPage, orderBy, direction);

		Page<CategoriaDTO> listaDTO = lista.map(obj -> new CategoriaDTO(obj));

		return ResponseEntity.ok().body(listaDTO);
	}
	
	@Override
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDTO) {
		
		Categoria obj = categoriaService.insert(categoriaService.fromDTO(objDTO));

		return ResponseEntity.created(super.getNovaUri("inserir", "/" + obj.getId().toString())).build();
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Long id, 
			@Valid @RequestBody CategoriaDTO objDTO) {
		
		objDTO.setId(id);
		
		categoriaService.update(categoriaService.fromDTO(objDTO));

		return ResponseEntity.noContent().build();
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		categoriaService.delete(id);

		return ResponseEntity.noContent().build();
	}

}
