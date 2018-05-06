package br.com.marcionielsen.cursomc.controllers;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.marcionielsen.cursomc.util.Util;

public abstract class AbstrataController {

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
