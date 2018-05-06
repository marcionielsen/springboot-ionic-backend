package br.com.marcionielsen.cursomc.controllers.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface IGenericaController<T> {

	public ResponseEntity<T> findById(Long id);

	public ResponseEntity<List<?>> listAll();

	public ResponseEntity<Page<?>> listPerPage(Integer numPage, Integer linesPage, String orderBy, String direction);
	
	public ResponseEntity<Void> insert(T obj);

	public ResponseEntity<Void> update(Long id, T obj);

	public ResponseEntity<Void> delete(Long id);
}
