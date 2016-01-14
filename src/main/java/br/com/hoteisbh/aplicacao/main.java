package br.com.hoteisbh.aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class main {
	public static void main(String[] args) {
		String input = "Sep 31 2013";
		LocalDate localDate = LocalDate.parse(input,
				DateTimeFormatter.ofPattern("MMM d yyyy").withLocale(Locale.ENGLISH));
		System.out.println(localDate);
	}
}
