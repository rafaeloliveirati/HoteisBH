package br.com.hoteisbh.controller;

import org.junit.Test;

import br.com.hoteisbh.builder.PlazaBuilder;
import br.com.hoteisbh.model.ReservaHotel;
import br.com.hoteisbh.util.Utils;
import junit.framework.TestCase;

public class TestAplicacaoController extends TestCase {

	@Test
	public void testIsEntradaValida() {
		String entradaTrue = "Regular: 16Mar2015(seg), 17Mar2015(ter), 18Mar2015(qua)";
		assertTrue(AplicacaoController.isEntradaValida(entradaTrue));
	}

	@Test
	public void testIsEntradaInvalida() {
		String entradaFalse = "Regular 16Mar2015(seg), 17Mar2015(ter), 18Mar2015(qua)";
		assertFalse(AplicacaoController.isEntradaValida(entradaFalse));
	}

	@Test()
	public void testFormataStringMelhorHotel() {
		ReservaHotel reservaHotel1 = new ReservaHotel(HotelController.buildHotel(new PlazaBuilder()), 280);
		String valorEsperado1 = "The Plaza: R$280";
		assertEquals(valorEsperado1,
				reservaHotel1.getHotel().getNome() + ": R$" + Utils.tryDoubleToInt(reservaHotel1.getValor()));
	}

	@Test
	public void testFormataEntrada() {
		String entrada = "Regular: 16Mar2015(seg), 17Mar2015(ter), 18Mar2015(qua)";
		String valorEsperado[] = { "Regular", "16Mar2015(seg)", "17Mar2015(ter)", "18Mar2015(qua)" };
		String[] valorRetorno1 = AplicacaoController.formataEntrada(entrada);
		for (int i = 0; i < valorEsperado.length; i++) {
			assertEquals(valorEsperado[i], valorRetorno1[i]);
		}
	}

	@Test
	public void testGetTextoArquivo() {
		String valorEsperado = "Regular: 16Mar2015(seg), 17Mar2015(ter), 18Mar2015(qua)";
		assertEquals(valorEsperado, AplicacaoController.getTextoArquivo("c:\\file.txt"));
	}

}
