package br.com.hoteisbh.controller;

import org.junit.Test;

import br.com.hoteisbh.builder.PlazaBuilder;
import br.com.hoteisbh.builder.RoyalBuilder;
import br.com.hoteisbh.model.ReservaHotel;
import br.com.hoteisbh.util.Utils;
import junit.framework.TestCase;

public class TestAplicacaoController extends TestCase {

	@Test
	public void testIsEntradaValida() {
		String entradaTrue1 = "Regular: 16Mar2015(seg), 17Mar2015(ter), 18Mar2015(qua)";
		String entradaTrue2 = "Regular:   20Mar2015(sex ),   21Mar2015(sab),    22Mar2015(dom)";
		String entradaFalse1 = "Regular 16Mar2015(seg), 17Mar2015(ter), 18Mar2015(qua)";
		String entradaFalse2 = ":20Mar2015(sex), 21Mar2015(sab), 22Mar2015(dom)";
		String entradaFalse3 = "Regular20Mar2015(sex), 21Mar2015(sab), 22Mar2015(dom)";
		assertTrue(AplicacaoController.isEntradaValida(entradaTrue1));
		assertTrue(AplicacaoController.isEntradaValida(entradaTrue2));
		assertFalse(AplicacaoController.isEntradaValida(entradaFalse1));
		assertFalse(AplicacaoController.isEntradaValida(entradaFalse2));
		assertFalse(AplicacaoController.isEntradaValida(entradaFalse3));
	}

	@Test
	public void testFormataStringMelhorHotel() {
		ReservaHotel reservaHotel1 = new ReservaHotel(HotelController.buildHotel(new PlazaBuilder()), 280);
		ReservaHotel reservaHotel2 = new ReservaHotel(HotelController.buildHotel(new RoyalBuilder()), 240);
		String valorEsperado1 = "The Plaza: R$280";
		String valorEsperado2 = "Royal Hotel: R$240";
		assertEquals(valorEsperado1,
				reservaHotel1.getHotel().getNome() + ": R$" + Utils.tryDoubleToInt(reservaHotel1.getValor()));
		assertEquals(valorEsperado2,
				reservaHotel2.getHotel().getNome() + ": R$" + Utils.tryDoubleToInt(reservaHotel2.getValor()));
	}

	@Test
	public void testFormataEntrada() {
		String entrada1 = "Regular: 16Mar2015(seg), 17Mar2015(ter), 18Mar2015(qua)";
		String entrada2 = "Regular:   20Mar2015(sex ),   21Mar2015(sab),    22Mar2015(dom)";
		String entrada3 = "Vip: 16Mar2015(seg), 17Mar2015(ter)";
		String valorEsperado1[] = { "Regular", "16Mar2015(seg)", "17Mar2015(ter)", "18Mar2015(qua)" };
		String valorEsperado2[] = { "Regular", "20Mar2015(sex)", "21Mar2015(sab)", "22Mar2015(dom)" };
		String valorEsperado3[] = { "Vip", "16Mar2015(seg)", "17Mar2015(ter)" };
		String[] valorRetorno1 = AplicacaoController.formataEntrada(entrada1);
		for (int i = 0; i < valorEsperado1.length; i++) {
			assertEquals(valorEsperado1[i], valorRetorno1[i]);
		}
		String[] valorRetorno2 = AplicacaoController.formataEntrada(entrada2);
		for (int i = 0; i < valorEsperado2.length; i++) {
			assertEquals(valorEsperado2[i], valorRetorno2[i]);
		}
		String[] valorRetorno3 = AplicacaoController.formataEntrada(entrada3);
		for (int i = 0; i < valorEsperado3.length; i++) {
			assertEquals(valorEsperado3[i], valorRetorno3[i]);
		}
	}

}
