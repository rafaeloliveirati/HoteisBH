package br.com.hoteisbh.controller;

import java.util.Date;

import br.com.hoteisbh.util.Constantes;
import br.com.hoteisbh.util.Utils;

public class HotelController {

	public static void verificaMelhorHotel(String entrada) {
		String tipoHostpede = null;
		String[] parametros = entrada.split("\\,|\\:");
		Date[] data = new Date[parametros.length - 1];
		if (parametros != null) {
			tipoHostpede = parametros[0];
			for (int i = 1; i < parametros.length; i++) {
				data[i - 1] = Utils.formataData(parametros[i].replaceAll("\\(.+?\\)", ""));
			}
		}
		TipoReserva tr = null;
		if (tipoHostpede.contains(Constantes.REGULAR)) {
			tr = TipoReserva.HOSPEDE_REGULAR;
		} else if (tipoHostpede.contains(Constantes.VIP)) {
			tr = TipoReserva.HOSPEDE_VIP;
		}
		Hospede hospede = new Hospede(tr, data);
		System.out.println("O Hospede do tipo: " + hospede.getTipo());
		for (Date date : hospede.getDatasReserva()) {
			System.out.println("data: " + date);
		}
	}

}
