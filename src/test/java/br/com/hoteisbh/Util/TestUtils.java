package br.com.hoteisbh.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import br.com.hoteisbh.util.Utils;
import junit.framework.TestCase;

public class TestUtils extends TestCase {

	@Test
	public void testFormataData() throws ParseException {
		String entrada = "01Jan2016";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dataEsperada = sdf.parse("01-01-2016");
		assertEquals(dataEsperada, Utils.formataData(entrada));
	}

	@Test
	public void testIsDiaSemana() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dataTrue = sdf.parse("01-01-2016");
		Date dataFalse = sdf.parse("16-01-2016");
		assertTrue(Utils.isDiaSemana(dataTrue));
		assertFalse(Utils.isDiaSemana(dataFalse));
	}

	@Test
	public void testTryFloatToInt() {
		String valorEsperado1 = "30";
		String valorEsperado2 = "30.20";
		assertEquals(valorEsperado1, Utils.tryDoubleToInt(30));
		assertEquals(valorEsperado2, Utils.tryDoubleToInt(30.2));
	}

}
