package br.com.hoteisbh.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Utils {
	/**
	 * Metodo para formatar a data com base na string digitada na entrada. Esta
	 * entrada hoje tem a seguinte estrutura {ddMMMyyyy}
	 * 
	 * @param data
	 * @return
	 */
	public static LocalDate formataData(String input) {
		try {
			String data = input.substring(0, 9);
			LocalDate localDate = LocalDate.parse(data,
					DateTimeFormatter.ofPattern("ddMMMyyyy").withLocale(Locale.ENGLISH));
			return localDate;
		} catch (Exception e) {
			System.out.println("Falha ao formatar a data");
			return null;
		}
	}

	/**
	 * Metodo que recebe uma data e retorna se a mesma é um dia da semana ou
	 * não
	 * 
	 * @param diaSemana
	 * @return
	 */
	public static boolean isDiaSemana(DayOfWeek diaSemana) {
		if (diaSemana == DayOfWeek.SUNDAY || diaSemana == DayOfWeek.SATURDAY) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo para formatar o valor de acordo com a saida.Tratei esta
	 * excessÃ£o pois tento converter para inteiro caso seja possivel, se
	 * nÃ£o for possivel entÃ£o retorna o proprio double
	 * 
	 * @param valor
	 * @return String
	 */
	public static String tryDoubleToInt(double valor) {
		if ((int) valor == valor) {
			return Integer.toString((int) valor);
		} else {
			return String.format("%.2f", valor).replace(",", ".");
		}
	}

	/**
	 * Valida se a string é nula ou vazia
	 * 
	 * @param str
	 * @return
	 */
	public static boolean IsEmptyOrNull(String str) {
		if (str == null || str.isEmpty())
			return true;
		return false;
	}
}
