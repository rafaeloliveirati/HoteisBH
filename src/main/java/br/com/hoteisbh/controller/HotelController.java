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
		Hotel melhorHotel = null;
		float valorMelhorHotel = 0;
		for (Hotel hotel : hoteis) {
			float valorTotal = getValorTotal(getValoresReserva(reserva, hotel));
			System.out.println(valorTotal);
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
		return melhorHotel.getNome() + " - Valor: " + valorMelhorHotel;
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
}
