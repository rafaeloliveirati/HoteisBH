package br.com.hoteisbh.builder;

import br.com.hoteisbh.model.Hotel;

public class MakeHotel {
	private HotelBuilder hotelBuilder;

	public void setHotelBuilder(HotelBuilder pb) {
		hotelBuilder = pb;
	}

	public Hotel getHotel() {
		return hotelBuilder.getHotel();
	}

	public void constructHotel() {
		hotelBuilder.createNewHotel();
		hotelBuilder.buildNome();
		hotelBuilder.buildClassificacao();
		hotelBuilder.buildPreco();
	}
}