package br.com.marcionielsen.cursomc.services.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;

public interface IGenericaService<T, D> {

	public T findById(Long id);
	
	public List<T> listAll();

	public Page<T> listPerPage(Integer numPage, Integer numLines, String orderBy, String direction);
	
	public T insert(T obj);
	
	public T update(T obj);
	
	public void delete(Long id);
	
	public T fromDTO(D obj);
	
}
