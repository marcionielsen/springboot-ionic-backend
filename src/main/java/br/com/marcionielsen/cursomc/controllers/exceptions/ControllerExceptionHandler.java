package br.com.marcionielsen.cursomc.controllers.exceptions;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoException e, HttpServletRequest request) {

		Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
		DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
		String horaSistema = formatoDataHora.format(instant.atZone(ZoneId.of("America/Sao_Paulo")));

		System.out.println("======================================================"); 
		System.out.println("====== >> Zona SystemDefault..: " + formatoDataHora.format(instant.atZone(ZoneId.systemDefault())));
		System.out.println("====== >> Zona BRASIL_SP......: " + formatoDataHora.format(instant.atZone(ZoneId.of("America/Sao_Paulo"))));
		System.out.println("======================================================"); 

		ErroPadrao erro = new ErroPadrao(HttpStatus.NOT_FOUND.value(), e.getMessage(), horaSistema);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
