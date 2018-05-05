package br.com.marcionielsen.cursomc.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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

	public static String formatoMoeda(BigDecimal valor) {
		DecimalFormat df = new DecimalFormat("¤ #,###,##0.00");

		return df.format(valor);
	}

}
