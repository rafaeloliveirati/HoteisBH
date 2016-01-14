package br.com.hoteisbh.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.hoteisbh.builder.CarlyleBuilder;
import br.com.hoteisbh.builder.HotelBuilder;
import br.com.hoteisbh.builder.MakeHotel;
import br.com.hoteisbh.builder.PlazaBuilder;
import br.com.hoteisbh.builder.RoyalBuilder;
import br.com.hoteisbh.model.Hotel;
import br.com.hoteisbh.model.Reserva;
import br.com.hoteisbh.model.ReservaHotel;
import br.com.hoteisbh.model.TipoHospede;
import br.com.hoteisbh.util.Utils;

/**
 * Classe controladora utilizado para gerenciar as ações vinculadas aos hoteis
 * 
 * @author Rafael
 *
 */
public class HotelController {
	/**
	 * Metodo utilizado para verificar o hotel com o menor preco. Este metodo
	 * recebe como parametro uma reserva que foi criada apartir da entrada do
	 * usuario e a lista de hoteis.
	 * 
	 * @param reserva
	 * @param hoteis
	 * @return
	 */
	public static ReservaHotel getMelhorHotel(Reserva reserva, List<Hotel> hoteis) {
		/*
		 * Cria um valor utilizado para buscar o menor valor total da reserva
		 */
		ReservaHotel reservaHotel = null;
		// Percorre a lista de hoteis
		for (Hotel hotel : hoteis) {
			/*
			 * Aciona o getValorTotal para buscar o valor total da reserva de
			 * acordo com as datas de reserva e os valores de cada hotel
			 */
			double valorReserva = ReservaController.getValorTotal(ReservaController.getValoresReserva(reserva, hotel));
			/*
			 * Verifica se o hotel esta nulo, caso seja verdadeiro então está
			 * passando pela primeira ocorrencia do laço e assim seta o
			 * melhorHotel e o melhor valor para os valores atuais
			 */
			if (reservaHotel == null) {
				reservaHotel = new ReservaHotel(hotel, valorReserva);
			}
			/*
			 * Verifica se o valorTotal de acordo com a reserva é menor ou
			 * igual ao valorMelhor(Valor atual)
			 */
			else if (valorReserva < reservaHotel.getValor()) {
				// Caso o valor seja menor então seta os valores atuais
				reservaHotel.setHotel(hotel);
				reservaHotel.setValor(valorReserva);
			}
			/*
			 * Verifica se os valores são iguais, caso seja verdadeiro entao
			 * ira� validar a classificacao do hotel
			 */
			else if (valorReserva == reservaHotel.getValor()) {
				// Verifica se o hotel atual possui maior classificação
				if (reservaHotel.getHotel().getClassificacao() < hotel.getClassificacao()) {
					reservaHotel.setHotel(hotel);
					reservaHotel.setValor(valorReserva);
				}
			}
		}
		return reservaHotel;
	}

	/**
	 * Metodo responsavel por retornar o valor da diaria de acordo com o
	 * hospede, hotel e dia da semana
	 * 
	 * @param localDate
	 * @param hotel
	 * @param tipoHospede
	 * @return
	 */
	public static double getValorDiaria(LocalDate localDate, Hotel hotel, TipoHospede tipoHospede) {
		/*
		 * Verifica o tipo do hospede, para cada hospede será considerado um
		 * preço diferente
		 */
		if (tipoHospede == TipoHospede.HOSPEDE_REGULAR) {
			/*
			 * Aciona o metodo util.isDiaSemana para verificar se a data da
			 * reserva é um dia da semana ou não
			 */
			if (Utils.isDiaSemana(localDate.getDayOfWeek())) {
				return hotel.getPreco().getPrecoRegularSemana();

			} else {
				return hotel.getPreco().getPrecoRegularFds();
			}
		} else if (tipoHospede == TipoHospede.HOSPEDE_VIP) {
			if (Utils.isDiaSemana(localDate.getDayOfWeek())) {
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
