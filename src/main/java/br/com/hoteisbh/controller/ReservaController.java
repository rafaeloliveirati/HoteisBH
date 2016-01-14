package br.com.hoteisbh.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.hoteisbh.model.DiariaReserva;
import br.com.hoteisbh.model.Hotel;
import br.com.hoteisbh.model.Reserva;
import br.com.hoteisbh.model.TipoHospede;
import br.com.hoteisbh.util.Utils;

/**
 * Classe controladora utilizado para gerenciar as ações vinculadas as
 * reservas
 * 
 * @author Rafael
 *
 */
public class ReservaController {
	/**
	 * Metodo que recebe uma entrada de texto referente aos parametros de
	 * entrada da reserva de hotel. (Exemplo: TipoHospede, data01, data02 ...)
	 * 
	 * @param entradaFormatada
	 */
	public static Reserva builderReserva(String[] parametros) {
		/*
		 * Cria um array com o tamanho da quantidade de parametros, com
		 * exceção do primeiro parametro(TipoParametro)
		 */
		String strTipoHostpede = parametros[0];
		List<DiariaReserva> listDiarias = new ArrayList<>();
		for (int i = 1; i < parametros.length; i++) {
			listDiarias.add(new DiariaReserva(Utils.formataData(parametros[i].replaceAll("\\(.+?\\)", ""))));
		}
		return new Reserva(TipoHospede.get(strTipoHostpede), listDiarias);
	}

	/**
	 * Metodo que recebe uma reserva e retorna o valor de todas as diarias
	 * 
	 * @param reserva
	 * @return
	 */
	public static double getValorTotal(Reserva reserva) {
		double valor = 0;
		/*
		 * Percorre a lista de diarias e incrementa o valor das mesmas no double
		 */
		valor = reserva.getDiarias().stream().mapToDouble(diaria -> diaria.getValor()).sum();
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
	public static Reserva getValoresReserva(Reserva reserva, Hotel hotel) {
		Reserva resultReserva = reserva;
		// Percorre a lista de reservas
		for (DiariaReserva diaria : resultReserva.getDiarias()) {
			/*
			 * Seta o valor da diaria de acordo com o retrono do metodo
			 * getValorDiaria
			 */
			diaria.setValor(HotelController.getValorDiaria(diaria.getData(), hotel, resultReserva.getTipo()));
		}
		return resultReserva;
	}
}
