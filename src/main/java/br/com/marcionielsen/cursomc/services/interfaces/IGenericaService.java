package br.com.marcionielsen.cursomc.services.interfaces;

import java.util.List;

public interface IGenericaService<T> {

	public T findById(Long id);
	
	public List<T> listAll();
	
	public T inserir(T obj);
	
	public T editar(T obj);
	
	public void excluir(Long id);
	
}
