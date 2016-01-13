package br.com.hoteisbh.builder;

import br.com.hoteisbh.model.PrecoHotel;

/**
 * Classe concreta do Hotel Builder para montar os dados do Hotel The Carlyle
 * 
 * @author Rafael
 *
 */
public class CarlyleBuilder extends HotelBuilder {

	@Override
	public void buildNome() {
		hotel.setNome("The Carlyle");
	}

	@Override
	public void buildClassificacao() {
		hotel.setClassificacao(3);
	}

	@Override
	public void buildPreco() {
		hotel.setPreco(new PrecoHotel(110, 90, 80, 80));
	}
}
