package br.com.hoteisbh.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.hoteisbh.builder.CarlyleBuilder;
import br.com.hoteisbh.builder.HotelBuilder;
import br.com.hoteisbh.builder.MakeHotel;
import br.com.hoteisbh.builder.PlazaBuilder;
import br.com.hoteisbh.builder.RoyalBuilder;
import br.com.hoteisbh.model.Reserva;
import br.com.hoteisbh.model.Hotel;
import br.com.hoteisbh.model.TipoHospede;
import br.com.hoteisbh.util.Utils;

public class ReservaController {
	/**
	 * Metodo que recebe uma entrada de texto referente aos parametros de
	 * entrada da reserva de hotel. (Exemplo: TipoHospede, data01, data02 ...)
	 * 
	 * @param entrada
	 */
	public static Reserva builderReserva(String entrada) {
		String[] parametros = formataEntrada(entrada);
		/*
		 * Cria um array com o tamanho da quantidade de parametros, com exceção
		 * do primeiro parametro(TipoParametro)
		 */
		Date[] datasSolicitadas = new Date[parametros.length - 1];
		String strTipoHostpede = parametros[0];
		for (int i = 1; i < parametros.length; i++) {
			datasSolicitadas[i - 1] = Utils.formataData(parametros[i].replaceAll("\\(.+?\\)", ""));
		}
		return new Reserva(TipoHospede.get(strTipoHostpede), datasSolicitadas);
	}

	/**
	 * Metodo que recebe o valor um valor de entrada e quebra em varios
	 * parametros
	 * 
	 * @param entrada
	 * @return
	 */
	private static String[] formataEntrada(String entrada) {
		/*
		 * Retorna a entrada formatada de acordo com os separadores : || ,
		 */
		return entrada.split("\\,|\\:");
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

	/**
	 * Constroi o hotel e o retorna a partir de um builder
	 * 
	 * @param hotelBuilder
	 * @return
	 */
	private static Hotel buildHotel(HotelBuilder hotelBuilder) {
		MakeHotel director = new MakeHotel();
		director.setHotelBuilder(hotelBuilder);
		director.constructHotel();
		return director.getHotel();
	}

}
