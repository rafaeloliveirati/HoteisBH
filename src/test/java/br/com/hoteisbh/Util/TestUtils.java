package br.com.hoteisbh.Util;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.Test;

import br.com.hoteisbh.util.Utils;
import junit.framework.TestCase;

public class TestUtils extends TestCase {

	@Test
	public void testFormataData() throws ParseException {
		String entrada = "01Jan2016";
		LocalDate dataEsperada = LocalDate.of(2016, 01, 01);
		assertEquals(dataEsperada, Utils.formataData(entrada));
	}

	@Test
	public void testIsDiaSemanaTrue() throws ParseException {
		assertTrue(Utils.isDiaSemana(LocalDate.of(2016, 01, 01).getDayOfWeek()));
	}

	@Test
	public void testIsDiaSemanaFalse() throws ParseException {
		assertFalse(Utils.isDiaSemana(LocalDate.of(2016, 01, 16).getDayOfWeek()));
	}

	@Test
	public void testTryFloatToInt() {
		String valorEsperado1 = "30";
		String valorEsperado2 = "30.20";
		assertEquals(valorEsperado1, Utils.tryDoubleToInt(30));
		assertEquals(valorEsperado2, Utils.tryDoubleToInt(30.2));
	}

}
