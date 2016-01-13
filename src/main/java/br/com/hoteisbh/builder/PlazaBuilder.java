package br.com.hoteisbh.builder;

import br.com.hoteisbh.model.PrecoHotel;

/**
 * Classe concreta do Hotel Builder apra montar os dados doHotel The Plaza
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
		hotel.setPreco(new PrecoHotel(160, 110, 60, 50));
	}
}
