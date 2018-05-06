package br.com.marcionielsen.cursomc.controllers.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface IGenericaController<T, D> {

	public ResponseEntity<T> findById(Long id);

	public ResponseEntity<List<D>> listAll();

	public ResponseEntity<Page<D>> listPerPage(Integer numPage, Integer linesPage, String orderBy, String direction);
	
	public ResponseEntity<Void> insert(D obj);

	public ResponseEntity<Void> update(Long id, D obj);

	public ResponseEntity<Void> delete(Long id);
}
