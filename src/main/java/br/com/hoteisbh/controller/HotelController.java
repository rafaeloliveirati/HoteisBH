package br.com.hoteisbh.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.hoteisbh.builder.CarlyleBuilder;
import br.com.hoteisbh.builder.HotelBuilder;
import br.com.hoteisbh.builder.MakeHotel;
import br.com.hoteisbh.builder.PlazaBuilder;
import br.com.hoteisbh.builder.RoyalBuilder;
import br.com.hoteisbh.model.DiariaReserva;
import br.com.hoteisbh.model.Hotel;
import br.com.hoteisbh.model.Reserva;
import br.com.hoteisbh.model.TipoHospede;
import br.com.hoteisbh.util.Utils;

public class HotelController {

	public static String verificaMelhorHotel(Reserva reserva, List<Hotel> hoteis) {
		Hotel melhorHotel = null;
		float valorMelhorHotel = 0;
		for (Hotel hotel : hoteis) {
			float valorTotal = getValorTotal(getValoresReserva(reserva, hotel));
			if (melhorHotel == null) {
				melhorHotel = hotel;
				valorMelhorHotel = valorTotal;
			} else if (valorTotal <= valorMelhorHotel) {
				if (melhorHotel.getClassificacao() > hotel.getClassificacao()) {
					melhorHotel = hotel;
					valorMelhorHotel = valorTotal;
				}
			}
		}
		return melhorHotel.getNome() + ": R$" + valorMelhorHotel;
	}

	private static float getValorTotal(Reserva reserva) {
		float valor = 0;
		for (DiariaReserva diaria : reserva.getDiarias()) {
			valor += diaria.getValor();
		}
		return valor;
	}

	private static Reserva getValoresReserva(Reserva reserva, Hotel hotel) {
		Reserva resultReserva = reserva;
		for (DiariaReserva diaria : resultReserva.getDiarias()) {
			diaria.setValor(getValorDiaria(diaria.getData(), hotel, resultReserva.getTipo()));
		}
		return resultReserva;
	}

	private static float getValorDiaria(Date data, Hotel hotel, TipoHospede tipoHospede) {
		if (tipoHospede == TipoHospede.HOSPEDE_REGULAR) {
			if (Utils.isDiaSemana(data)) {
				return hotel.getPreco().getPrecoRegularSemana();

			} else {
				return hotel.getPreco().getPrecoRegularFds();
			}
		} else if (tipoHospede == TipoHospede.HOSPEDE_VIP) {
			if (Utils.isDiaSemana(data)) {
				return hotel.getPreco().getPrecoVipSemana();

			} else {
				return hotel.getPreco().getPrecoVipFds();
			}
		}
		return 0;
	}

	/**
	 * Constroi o hotel e o retorna a partir de um builder
	 * 
	 * @param hotelBuilder
	 * @return
	 */
	public static Hotel buildHotel(HotelBuilder hotelBuilder) {
		MakeHotel make = new MakeHotel();
		make.setHotelBuilder(hotelBuilder);
		make.constructHotel();
		return make.getHotel();
	}

	/**
	 * Constroi a lista de hoteis acionando o buildHotel
	 * 
	 * @return
	 */
	public static List<Hotel> buildListaHoteis() {
		List<Hotel> hoteis = new ArrayList<>();
		hoteis.add(buildHotel(new PlazaBuilder()));
		hoteis.add(buildHotel(new RoyalBuilder()));
		hoteis.add(buildHotel(new CarlyleBuilder()));
		return hoteis;
	}
}
