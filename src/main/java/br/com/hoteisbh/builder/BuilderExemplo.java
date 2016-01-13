package br.com.hoteisbh.builder;

import java.util.List;

import br.com.hoteisbh.controller.ReservaController;
import br.com.hoteisbh.controller.HotelController;
import br.com.hoteisbh.model.Reserva;
import br.com.hoteisbh.model.Hotel;

public class BuilderExemplo {
	// private static Scanner sc;

	public static void main(String[] args) {
		List<Hotel> hoteis = ReservaController.buildListaHoteis();
		System.out.println("Bem vindo ao sistema Hoteis BH");
		// sc = new Scanner(System.in);
		String entrada = "Regular: 16Mar2015(seg), 17Mar2015(ter), 18Mar2015(qua)";
		// entrada = sc.nextLine();
		Reserva reserva = ReservaController.builderReserva(entrada);
		System.out.println(HotelController.verificaMelhorHotel(reserva, hoteis));
		// System.out.println(hotel.getNome() + " R$" +
	}

}
