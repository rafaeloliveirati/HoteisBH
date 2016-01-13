package br.com.hoteisbh.builder;

import br.com.hoteisbh.model.Hotel;

/**
 * Classe abstrata do hotel builder
 * 
 * @author Rafael
 *
 */
public abstract class HotelBuilder {
	protected Hotel hotel;

	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * Metodo invocado para criar uma nova instancia de hotel
	 */
	public void createNewHotel() {
		hotel = new Hotel();
	}

	public abstract void buildNome();

	public abstract void buildClassificacao();

	public abstract void buildPreco();

}
