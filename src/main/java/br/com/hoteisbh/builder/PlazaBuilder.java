package br.com.hoteisbh.builder;

import br.com.hoteisbh.model.PrecoHotel;

/**
 * Classe concreta do Hotel Builder para montar os dados do Hotel The Plaza
 * 
 * @author Rafael
 *
 */
public class PlazaBuilder extends HotelBuilder {

	@Override
	public void buildNome() {
		hotel.setNome("The Plaza");
	}

	@Override
	public void buildClassificacao() {
		hotel.setClassificacao(4);
	}

	@Override
	public void buildPreco() {
		hotel.setPreco(new PrecoHotel(160, 60, 110, 50));
	}
}
