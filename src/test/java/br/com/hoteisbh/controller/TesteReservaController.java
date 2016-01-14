package br.com.hoteisbh.controller;

import org.junit.Test;

import br.com.hoteisbh.builder.PlazaBuilder;
import br.com.hoteisbh.builder.RoyalBuilder;
import br.com.hoteisbh.model.Reserva;
import junit.framework.TestCase;

public class TesteReservaController extends TestCase {

	@Test
	public void testGetValorTotal() {
		Reserva reserva1 = ReservaController.builderReserva(
				AplicacaoController.formataEntrada("Vip: 26Mar2015(qui), 27Mar2015(sex), 28Mar2015(sab"));
		Reserva reserva2 = ReservaController.builderReserva(
				AplicacaoController.formataEntrada("Regular: 20Mar2015(sex), 21Mar2015(sab), 22Mar2015(dom)"));
		reserva1 = ReservaController.getValoresReserva(reserva1, HotelController.buildHotel(new RoyalBuilder()));
		reserva2 = ReservaController.getValoresReserva(reserva2, HotelController.buildHotel(new PlazaBuilder()));
		double valorEsperado1 = 240;
		double valorEsperado2 = 280;
		assertEquals(valorEsperado1, ReservaController.getValorTotal(reserva1));
		assertEquals(valorEsperado2, ReservaController.getValorTotal(reserva2));
	}

	@Test
	public void testGetValoresReserva() {
		Reserva reserva1 = ReservaController
				.builderReserva(AplicacaoController.formataEntrada("Vip: 01Jan2015(sab), 05Mar2015(ter)"));
		reserva1.getDiarias().get(0).setValor(40);
		reserva1.getDiarias().get(1).setValor(100);
		for (int i = 0; i < reserva1.getDiarias().size(); i++) {
			assertEquals(reserva1.getDiarias().get(i), ReservaController
					.getValoresReserva(reserva1, HotelController.buildHotel(new RoyalBuilder())).getDiarias().get(i));
		}
	}
}
