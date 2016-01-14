package br.com.hoteisbh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {
	/**
	 * Metodo para formatar a data com base na string digitada na entrada. Esta
	 * entrada hoje tem a seguinte estrutura {ddMMMyyyy}
	 * 
	 * @param data
	 * @return
	 */
	public static Date formataData(String data) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
			Date date = dateFormat.parse(data.trim());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			return sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Metodo que recebe uma data e retorna se a mesma é um dia da semana ou não
	 * 
	 * @param data
	 * @return
	 */
	public static boolean isDiaSemana(Date data) {
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		int dia = c.get(Calendar.DAY_OF_WEEK);
		if (dia == Calendar.SUNDAY || dia == Calendar.SATURDAY) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo para formatar o valor de acordo com a saida.Tratei esta excessÃ£o
	 * pois tento converter para inteiro caso seja possivel, se nÃ£o for
	 * possivel entÃ£o retorna o proprio double
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
