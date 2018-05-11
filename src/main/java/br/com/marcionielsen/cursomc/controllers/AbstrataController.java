package br.com.marcionielsen.cursomc.controllers;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.marcionielsen.cursomc.util.Util;

public abstract class AbstrataController {

//	public abstract  <T> ResponseEntity<T> findById(Long id);
//
//	public abstract  ResponseEntity<List<? extends AbstrataDTO>> listAll();
//
//	public abstract ResponseEntity<Page<? extends AbstrataDTO>> listPerPage(Integer numPage, Integer linesPage, String orderBy,
//			String direction);
//			
//	public abstract ResponseEntity<Void> delete(Long id);
//
//	public abstract <D> ResponseEntity<Void> insert(@Valid D objDTO);
//
//	public abstract <F> ResponseEntity<Void> update(Long id, @Valid F objDTO);
	
	protected URI getNovaUri(String elementoRemover, String novoElemento) {
		String uriOri = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();

		String str = Util.removerElementoURI(ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
				elementoRemover);

		StringBuilder novaStr = new StringBuilder(str);

		URI novaUri = ServletUriComponentsBuilder.fromUriString(novaStr.toString()).path(novoElemento).build().toUri();

		System.out.println("================================================");
		System.out.println("URI orig: " + uriOri + "\n");
		System.out.println("nova URI: " + novaUri.toString());
		System.out.println("================================================");

		return novaUri;
	}

	
}
