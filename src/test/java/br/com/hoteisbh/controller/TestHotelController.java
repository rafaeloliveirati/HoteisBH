package br.com.hoteisbh.controller;

import java.util.List;

import org.junit.Test;

import br.com.hoteisbh.builder.PlazaBuilder;
import br.com.hoteisbh.builder.RoyalBuilder;
import br.com.hoteisbh.model.Hotel;
import br.com.hoteisbh.model.Reserva;
import br.com.hoteisbh.model.TipoHospede;
import br.com.hoteisbh.util.Utils;
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
	public void testGetMelhorHotel() {
		String entrada = "Regular: 16Mar2015(seg), 17Mar2015(ter),18Mar2015(qua)";
		List<Hotel> hoteis = HotelController.buildListaHoteis();
		Reserva reserva = ReservaController.builderReserva(AplicacaoController.formataEntrada(entrada));
		String retornoEsperado = "The Carlyle: R$330";
		assertEquals(retornoEsperado,
				AplicacaoController.formataStringPrintTerminal(HotelController.getMelhorHotel(reserva, hoteis)));
	}

	@Test
	public void testGetMelhorHotelVip() {
		String entrada = "Vip: 26Mar2015(qui), 27Mar2015(sex), 28Mar2015(sab";
		List<Hotel> hoteis = HotelController.buildListaHoteis();
		Reserva reserva = ReservaController.builderReserva(AplicacaoController.formataEntrada(entrada));
		String retornoEsperado = "Royal Hotel: R$240";
		assertEquals(retornoEsperado,
				AplicacaoController.formataStringPrintTerminal(HotelController.getMelhorHotel(reserva, hoteis)));
	}

	@Test
	public void testGetValorDiariaRegular() {
		Hotel hotel = HotelController.buildHotel(new PlazaBuilder());
		TipoHospede tipoHospede = TipoHospede.HOSPEDE_REGULAR;
		double retornoEsperado = 160;
		String strData = "01Jan2016";
		assertEquals(retornoEsperado, HotelController.getValorDiaria(Utils.formataData(strData), hotel, tipoHospede));
	}

	@Test
	public void testGetValorDiariaVip() {
		Hotel hotel = HotelController.buildHotel(new RoyalBuilder());
		TipoHospede tipoHospede = TipoHospede.HOSPEDE_VIP;
		double retornoEsperado = 100;
		String strData = "13Jan2016";
		assertEquals(retornoEsperado, HotelController.getValorDiaria(Utils.formataData(strData), hotel, tipoHospede));
	}
}
