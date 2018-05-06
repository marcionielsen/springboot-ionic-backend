package br.com.marcionielsen.cursomc.services.interfaces;

import java.util.List;

public interface IGenericaService<T> {

	public T findById(Long id);
	
	public List<T> listAll();
	
	public T insert(T obj);
	
	public T update(T obj);
	
	public void delete(Long id);
	
}
