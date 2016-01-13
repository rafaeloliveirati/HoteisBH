package br.com.hoteisbh.builder;

import br.com.hoteisbh.controller.HotelController;
import br.com.hoteisbh.model.Hotel;

public class BuilderExemplo {
	// private static Scanner sc;

	public static void main(String[] args) {
		Director director = new Director();
		HotelBuilder plaza = new PlazaBuilder();
		director.setHotelBuilder(plaza);
		director.constructHotel();
		Hotel hotel = director.getHotel();
		System.out.println("Bem vindo ao sistema Hoteis BH");
		// sc = new Scanner(System.in);
		String entrada = "Regular: 16Mar2015(seg), 17Mar2015(ter), 18Mar2015(qua)";
		// entrada = sc.nextLine();
		HotelController.verificaMelhorHotel(entrada);
		System.out.println(hotel.getNome() + " R$" + hotel.getPreco().getPrecoRegularFds());
	}

}
