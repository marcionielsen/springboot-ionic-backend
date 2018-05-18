package br.com.marcionielsen.cursomc.util;

import java.math.BigDecimal;

/* 
  * Moeda.java 
  * 
  * Created on 24 de Fevereiro de 2005, 21:09 
  */

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Classe que padroniza a internacionalizacao de valores monetarios
 * 
 * FONTE: "http://www.guj.com.br/t/formatacao-de-valores-monetarios/227203"
 * 
 * @author Luiz Cavalcanti
 * @version 0.1
 * @see java.util.Locale
 * @see java.text.DecimalFormat
 * @see java.text.DecimalFormatSymbols
 */
public final class Moeda {

	/**
	 * Locale Brasileiro
	 */
	private static final Locale BRAZIL = new Locale("pt", "BR");
	
	/**
	 * Simbolos especificos do Real Brasileiro
	 */
	private static final DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
	
	/**
	 * Simbolos especificos do Dolar Americano
	 */
	private static final DecimalFormatSymbols DOLAR = new DecimalFormatSymbols(Locale.US);
	
	/**
	 * Simbolos especificos do Euro
	 */
	private static final DecimalFormatSymbols EURO = new DecimalFormatSymbols(Locale.GERMANY);
	
	/**
	 * Mascara de dinheiro para Dolar Americano
	 */
	public static final DecimalFormat DINHEIRO_DOLAR = new DecimalFormat("¤ ###,###,##0.00", DOLAR);
	
	/**
	 * Mascara de dinheiro para Euro
	 */
	public static final DecimalFormat DINHEIRO_EURO = new DecimalFormat("¤ ###,###,##0.00", EURO);
	
	/**
	 * Mascara de dinheiro para Real Brasileiro
	 */
	public static final DecimalFormat DINHEIRO_REAL = new DecimalFormat("¤ ###,###,##0.00", REAL);

	/**
	 * Mascara texto com formatacao monetaria
	 * 
	 * @param valor
	 *            Valor a ser mascarado
	 * @param moeda
	 *            Padrao monetario a ser usado
	 * @return Valor mascarado de acordo com o padrao especificado
	 */
	public static String mascaraDinheiro(BigDecimal valor, DecimalFormat moeda) {
		return moeda.format(valor);
	}
}
