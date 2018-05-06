package br.com.marcionielsen.cursomc.services;

import org.springframework.data.domain.Page;

public abstract class AbstrataService<T> {

	public Page<T> listPerPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		return null;
	}
} 
