package br.com.hoteisbh.builder;

import br.com.hoteisbh.model.Hotel;

/**
 * Classe abstrata do hotel builder
 * 
 * @author Rafael
 *
 */
abstract class HotelBuilder {
	protected Hotel hotel;

	public Hotel getHotel() {
		return hotel;
	}

	public void createNewHotel() {
		hotel = new Hotel();
	}

	public abstract void buildNome();

	public abstract void buildClassificacao();

	public abstract void buildPreco();

}
