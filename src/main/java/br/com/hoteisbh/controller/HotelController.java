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
	public static String verificaMelhorHotel(Reserva reserva, List<Hotel> hoteis) {
		/*
		 * Cria uma instancia de hotel que ira representar o Hotel com o melhor
		 * preco
		 */
		Hotel melhorHotel = null;
		/*
		 * Cria um valor utilizado para buscar o menor valor total da reserva
		 */
		float valorMelhorHotel = 0;
		// Percorre a lista de hoteis
		for (Hotel hotel : hoteis) {
			/*
			 * Aciona o getValorTotal para buscar o valor total da reserva de
			 * acordo com as datas de reserva e os valores de cada hotel
			 */
			float valorReserva = getValorTotal(getValoresReserva(reserva, hotel));
			/*
			 * Verifica se o hotel esta nulo, caso seja verdadeiro então está
			 * passando pela primeira ocorrencia do laço e assim seta o
			 * melhorHotel e o melhor valor para os valores atuais
			 */
			if (melhorHotel == null) {
				melhorHotel = hotel;
				valorMelhorHotel = valorReserva;
			}
			/*
			 * Verifica se o valorTotal de acordo com a reserva é menor ou igual
			 * ao valorMelhor(Valor atual)
			 */
			else if (valorReserva < valorMelhorHotel) {
				// Caso o valor seja menor então seta os valores atuais
				melhorHotel = hotel;
				valorMelhorHotel = valorReserva;
			}
			/*
			 * Verifica se os valores são iguais, caso seja verdadeiro então irá
			 * validar a classificacao do hotel
			 */
			else if (valorReserva == valorMelhorHotel) {
				// Verifica se o hotel atual possui maior classificação
				if (melhorHotel.getClassificacao() > hotel.getClassificacao()) {
					melhorHotel = hotel;
					valorMelhorHotel = valorReserva;
				}
			}
		}
		/*
		 * Tratei esta excessão pois tento converter para inteiro caso seja
		 * possivel, se não for possivel então retorna o proprio float
		 */
		try {
			return melhorHotel.getNome() + ": R$" + (int) valorMelhorHotel;
		} catch (Exception e) {
			return melhorHotel.getNome() + ": R$" + valorMelhorHotel;
		}
	}

	/**
	 * Metodo que recebe uma reserva e retorna o valor de todas as diarias
	 * 
	 * @param reserva
	 * @return
	 */
	private static float getValorTotal(Reserva reserva) {
		float valor = 0;
		/*
		 * Percorre a lista de diarias e incrementa o valor das mesmas no float
		 */
		for (DiariaReserva diaria : reserva.getDiarias()) {
			valor += diaria.getValor();
		}
		return valor;
	}

	/**
	 * Metodo que retorna a reserva copulada com seus valores de acordo com o
	 * tipo do hospede, hotel e dia da semana
	 * 
	 * @param reserva
	 * @param hotel
	 * @return
	 */
	private static Reserva getValoresReserva(Reserva reserva, Hotel hotel) {
		Reserva resultReserva = reserva;
		// Percorre a lista de reservas
		for (DiariaReserva diaria : resultReserva.getDiarias()) {
			/*
			 * Seta o valor da diaria de acordo com o retrono do metodo
			 * getValorDiaria
			 */
			diaria.setValor(getValorDiaria(diaria.getData(), hotel, resultReserva.getTipo()));
		}
		return resultReserva;
	}

	/**
	 * Metodo responsavel por retornar o valor da diaria de acordo com o
	 * hospede, hotel e dia da semana
	 * 
	 * @param data
	 * @param hotel
	 * @param tipoHospede
	 * @return
	 */
	private static float getValorDiaria(Date data, Hotel hotel, TipoHospede tipoHospede) {
		/*
		 * Verifica o tipo do hospede, para cada hospede será considerado um
		 * preço diferente
		 */
		if (tipoHospede == TipoHospede.HOSPEDE_REGULAR) {
			/*
			 * Aciona o metodo util.isDiaSemana para verificar se a data da
			 * reserva é um dia da semana ou não
			 */
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
