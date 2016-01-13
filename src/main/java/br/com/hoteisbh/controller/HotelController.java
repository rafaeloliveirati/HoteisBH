package br.com.hoteisbh.controller;

import java.util.Date;
import java.util.List;

import br.com.hoteisbh.model.DiariaReserva;
import br.com.hoteisbh.model.Hotel;
import br.com.hoteisbh.model.Reserva;
import br.com.hoteisbh.model.TipoHospede;
import br.com.hoteisbh.util.Utils;

public class HotelController {

	public static String verificaMelhorHotel(Reserva reserva, List<Hotel> hoteis) {
		for (Hotel hotel : hoteis) {
			getValoresReserva(reserva, hotel);
		}
		return null;
	}

	private static Reserva getValoresReserva(Reserva reserva, Hotel hotel) {
		for (DiariaReserva diaria : reserva.getDiaria()) {
			diaria.setValor(getValorDiaria(diaria.getData(), hotel, reserva.getTipo()));
		}
		return reserva;
	}

	private static float getValorDiaria(Date data, Hotel hotel, TipoHospede tipoHospede) {
		if (tipoHospede == TipoHospede.HOSPEDE_REGULAR) {
			if (Utils.isDiaSemana(data)) {
				return hotel.getPreco().getPrecoRegularSemana();

			} else {
				return hotel.getPreco().getPrecoRegularFds();
			}
		} else if (tipoHospede == TipoHospede.HOSPEDE_REGULAR) {
			if (Utils.isDiaSemana(data)) {
				return hotel.getPreco().getPrecoVipSemana();

			} else {
				return hotel.getPreco().getPrecoVipFds();
			}
		}
		return 0;
	}
}
