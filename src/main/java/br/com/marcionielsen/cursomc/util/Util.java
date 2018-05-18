package br.com.marcionielsen.cursomc.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Util {

	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm";
	public static final String FORMATO_TIME_STAMP = "yyyy-MM-dd HH:mm:ss";

	public static String formatoDataHora(Instant data) {

		return LocalDateTime.ofInstant(data, ZoneId.systemDefault())
				.format(DateTimeFormatter.ofPattern(FORMATO_DATA_HORA));
	}

	public static String formatoTimeStamp(Instant data) {

		return LocalDateTime.ofInstant(data, ZoneId.systemDefault())
				.format(DateTimeFormatter.ofPattern(FORMATO_TIME_STAMP));
	}

	public static String removerElementoURI(String strOri, String paramRemove) {

		StringBuilder sb = new StringBuilder();

		String[] elementosUri = strOri.split("/");

		for (String elemento : elementosUri) {

			if (!paramRemove.equalsIgnoreCase(elemento)) {
				sb.append(elemento).append("/");
			}
		}

		int idx = sb.toString().lastIndexOf("/");

		return sb.toString().substring(0, idx);
	}

}
