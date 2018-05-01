package br.com.marcionielsen.cursomc.controllers.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IGenericaController<T> {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(Long id);

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> listAll();

	public T inserir(T obj);

	public T editar(T obj);

	public void excluir(Long id);
}
