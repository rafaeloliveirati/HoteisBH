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
		String entrada1 = "Regular: 16Mar2015(seg), 17Mar2015(ter),18Mar2015(qua)";
		String entrada2 = "Regular: 20Mar2015(sex), 21Mar2015(sab),22Mar2015(dom)";
		String entrada3 = "Vip: 26Mar2015(qui), 27Mar2015(sex), 28Mar2015(sab";
		List<Hotel> hoteis = HotelController.buildListaHoteis();
		Reserva reserva1 = ReservaController.builderReserva(AplicacaoController.formataEntrada(entrada1));
		Reserva reserva2 = ReservaController.builderReserva(AplicacaoController.formataEntrada(entrada2));
		Reserva reserva3 = ReservaController.builderReserva(AplicacaoController.formataEntrada(entrada3));
		String retornoEsperado1 = "The Carlyle: R$330";
		String retornoEsperado2 = "The Plaza: R$280";
		String retornoEsperado3 = "Royal Hotel: R$240";
		assertEquals(retornoEsperado1,
				AplicacaoController.formataStringPrintTerminal(HotelController.getMelhorHotel(reserva1, hoteis)));
		assertEquals(retornoEsperado2,
				AplicacaoController.formataStringPrintTerminal(HotelController.getMelhorHotel(reserva2, hoteis)));
		assertEquals(retornoEsperado3,
				AplicacaoController.formataStringPrintTerminal(HotelController.getMelhorHotel(reserva3, hoteis)));
	}

	@Test
	public void testGetValorDiaria() {
		Hotel hotel1 = HotelController.buildHotel(new PlazaBuilder());
		Hotel hotel2 = HotelController.buildHotel(new RoyalBuilder());
		TipoHospede tipoHospede1 = TipoHospede.HOSPEDE_REGULAR;
		TipoHospede tipoHospede2 = TipoHospede.HOSPEDE_VIP;
		double retornoEsperado = 160;
		double retornoEsperado2 = 100;
		String strData = "01Jan2016";
		String strData2 = "13Jan2016";
		assertEquals(retornoEsperado, HotelController.getValorDiaria(Utils.formataData(strData), hotel1, tipoHospede1));
		assertEquals(retornoEsperado2,
				HotelController.getValorDiaria(Utils.formataData(strData2), hotel2, tipoHospede2));
	}
}
