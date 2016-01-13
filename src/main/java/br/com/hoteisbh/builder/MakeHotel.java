package br.com.hoteisbh.builder;

import br.com.hoteisbh.model.Hotel;

/**
 * Classe utilizada para construir o builder do hotel
 * 
 * @author Rafael
 *
 */
public class MakeHotel {
	private HotelBuilder hotelBuilder;

	public void setHotelBuilder(HotelBuilder pb) {
		hotelBuilder = pb;
	}

	public Hotel getHotel() {
		return hotelBuilder.getHotel();
	}

	/**
	 * Metodo utilizado para construir o hote, este metodo ira acionar os builds
	 * de cada atributo do hotel e assim setando-os ao objeto
	 */
	public void constructHotel() {
		hotelBuilder.createNewHotel();
		hotelBuilder.buildNome();
		hotelBuilder.buildClassificacao();
		hotelBuilder.buildPreco();
	}
}