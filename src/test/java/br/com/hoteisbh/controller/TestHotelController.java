package br.com.hoteisbh.controller;

import java.util.List;

import org.junit.Test;

import br.com.hoteisbh.builder.PlazaBuilder;
import br.com.hoteisbh.model.Hotel;
import br.com.hoteisbh.model.PrecoHotel;
import br.com.hoteisbh.model.Reserva;
import junit.framework.TestCase;

/**
 * Classe de testes para verificar a consistencia dos metodos da classe
 * HotelController
 * 
 * @author Rafael
 *
 */
public class TestHotelController extends TestCase {
	/**
	 * Teste efetuado no metodo testVerificaMelhorHotel, onde passar algumas
	 * entradas e verifica se o retorno do melhor hotel esta correto
	 */
	@Test
	public void testVerificaMelhorHotel() {
		String entrada1 = "Regular: 16Mar2015(seg), 17Mar2015(ter), 18Mar2015(qua)";
		String entrada2 = "Regular: 16Mar2015(seg), 17Mar2015(ter), 18Mar2015(qua)";
		String entrada3 = "Regular: 16Mar2015(seg), 17Mar2015(ter),	18Mar2015(qua)";
		List<Hotel> hotel = HotelController.buildListaHoteis();
		Reserva reserva1 = ReservaController.builderReserva(entrada1);
		Reserva reserva2 = ReservaController.builderReserva(entrada2);
		Reserva reserva3 = ReservaController.builderReserva(entrada3);
		String retornoEsperado1 = "The Carlyle: R$330";
		String retornoEsperado2 = "The Plaza: R$280";
		String retornoEsperado3 = "Royal Hotel: R$240";
		assertEquals(retornoEsperado1, HotelController.verificaMelhorHotel(reserva1, hotel));
		assertEquals(retornoEsperado2, HotelController.verificaMelhorHotel(reserva2, hotel));
		assertEquals(retornoEsperado3, HotelController.verificaMelhorHotel(reserva3, hotel));
	}

	@Test
	public void testBuildHotel() {
		Hotel hotelEsperado = new Hotel();
		hotelEsperado.setNome("The Plaza");
		hotelEsperado.setClassificacao(4);
		hotelEsperado.setPreco(new PrecoHotel(160, 110, 60, 50));
		Hotel hotelRetorno = HotelController.buildHotel(new PlazaBuilder());
		assertEquals(hotelEsperado, hotelRetorno);
	}

	@Test
	public void testBuildListaHoteis() {
	}

}
