package br.com.marcionielsen.cursomc.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Util {

	private static final String FORMATO_DATA_HORA  = "dd/MM/yyyy HH:mm";
	private static final String FORMATO_TIME_STAMP = "yyyy-MM-dd HH:mm:ss";
	
	public static String formatoDataHora(Instant data) {
		
		return LocalDateTime.ofInstant(data, ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(FORMATO_DATA_HORA));
	}
	
	public static String formatoTimeStamp(Instant data) {
		
		return LocalDateTime.ofInstant(data, ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(FORMATO_TIME_STAMP));
	}
}
