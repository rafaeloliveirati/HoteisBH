package br.com.hoteisbh.controller;

import org.junit.Test;

import br.com.hoteisbh.builder.RoyalBuilder;
import br.com.hoteisbh.model.Reserva;
import junit.framework.TestCase;

public class TestReservaController extends TestCase {

	@Test
	public void testGetValorTotal() {
		Reserva reserva = ReservaController.builderReserva(
				AplicacaoController.formataEntrada("Vip: 26Mar2015(qui), 27Mar2015(sex), 28Mar2015(sab"));
		reserva = ReservaController.getValoresReserva(reserva, HotelController.buildHotel(new RoyalBuilder()));
		double valorEsperado = 240;
		assertEquals(valorEsperado, ReservaController.getValorTotal(reserva));
	}

	@Test
	public void testGetValoresReserva() {
		Reserva reserva = ReservaController
				.builderReserva(AplicacaoController.formataEntrada("Vip: 01Jan2015(sab), 05Mar2015(ter)"));
		reserva.getDiarias().get(0).setValor(40);
		reserva.getDiarias().get(1).setValor(100);
		for (int i = 0; i < reserva.getDiarias().size(); i++) {
			assertEquals(reserva.getDiarias().get(i), ReservaController
					.getValoresReserva(reserva, HotelController.buildHotel(new RoyalBuilder())).getDiarias().get(i));
		}
	}
}
