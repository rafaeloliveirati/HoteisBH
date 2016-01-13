package br.com.hoteisbh.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.hoteisbh.model.DiariaReserva;
import br.com.hoteisbh.model.Reserva;
import br.com.hoteisbh.model.TipoHospede;
import br.com.hoteisbh.util.Utils;

/**
 * Classe controladora utilizado para gerenciar as ações vinculadas as reservas
 * 
 * @author Rafael
 *
 */
public class ReservaController {
	/**
	 * Metodo que recebe uma entrada de texto referente aos parametros de
	 * entrada da reserva de hotel. (Exemplo: TipoHospede, data01, data02 ...)
	 * 
	 * @param entrada
	 */
	public static Reserva builderReserva(String entrada) {
		String[] parametros = formataEntrada(entrada.trim());
		/*
		 * Cria um array com o tamanho da quantidade de parametros, com exceção
		 * do primeiro parametro(TipoParametro)
		 */
		String strTipoHostpede = parametros[0];
		List<DiariaReserva> listDiarias = new ArrayList<>();
		for (int i = 1; i < parametros.length; i++) {
			listDiarias.add(new DiariaReserva(Utils.formataData(parametros[i].replaceAll("\\(.+?\\)", ""))));
		}
		return new Reserva(TipoHospede.get(strTipoHostpede), listDiarias);
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
}
