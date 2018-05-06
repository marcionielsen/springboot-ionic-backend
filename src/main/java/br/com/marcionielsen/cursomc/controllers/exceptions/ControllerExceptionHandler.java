package br.com.marcionielsen.cursomc.controllers.exceptions;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.marcionielsen.cursomc.services.exceptions.IntegridadeDadosException;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoException e, HttpServletRequest request) {

		Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
		DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
		String horaSistema = formatoDataHora.format(instant.atZone(ZoneId.of("America/Sao_Paulo")));

		System.out.println("======================================================");
		System.out.println("====== >> HTTP OBJECT NOT FOUND");
		System.out.println("------------------------------------------------------");
		System.out.println("====== >> Zona SystemDefault..: " + formatoDataHora.format(instant.atZone(ZoneId.systemDefault())));
		System.out.println("====== >> Zona BRASIL_SP......: " + formatoDataHora.format(instant.atZone(ZoneId.of("America/Sao_Paulo"))));
		System.out.println("======================================================"); 

		ErroPadrao erro = new ErroPadrao(HttpStatus.NOT_FOUND.value(), e.getMessage(), horaSistema);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(IntegridadeDadosException.class)
	public ResponseEntity<ErroPadrao> violacaoIntegridadeDadosEncontrado(IntegridadeDadosException e, HttpServletRequest request) {

		Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
		DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
		String horaSistema = formatoDataHora.format(instant.atZone(ZoneId.of("America/Sao_Paulo")));

		System.out.println("======================================================");
		System.out.println("====== >> HTTP BAD REQUEST ");
		System.out.println("------------------------------------------------------");
		System.out.println("====== >> Zona SystemDefault..: " + formatoDataHora.format(instant.atZone(ZoneId.systemDefault())));
		System.out.println("====== >> Zona BRASIL_SP......: " + formatoDataHora.format(instant.atZone(ZoneId.of("America/Sao_Paulo"))));
		System.out.println("======================================================"); 

		ErroPadrao erro = new ErroPadrao(HttpStatus.BAD_REQUEST.value(), e.getMessage(), horaSistema);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroPadrao> violacaoValidacao(MethodArgumentNotValidException e, HttpServletRequest request) {

		Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
		DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
		String horaSistema = formatoDataHora.format(instant.atZone(ZoneId.of("America/Sao_Paulo")));

		System.out.println("======================================================");
		System.out.println("====== >> HTTP BAD REQUEST ");
		System.out.println("------------------------------------------------------");
		System.out.println("====== >> Zona SystemDefault..: " + formatoDataHora.format(instant.atZone(ZoneId.systemDefault())));
		System.out.println("====== >> Zona BRASIL_SP......: " + formatoDataHora.format(instant.atZone(ZoneId.of("America/Sao_Paulo"))));
		System.out.println("======================================================"); 

		ErroValidacao erro = new ErroValidacao(HttpStatus.BAD_REQUEST.value(), "Erro de validação", horaSistema);
		
		for(FieldError elemento : e.getBindingResult().getFieldErrors()) {
			erro.addError(elemento.getField(), elemento.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
}
