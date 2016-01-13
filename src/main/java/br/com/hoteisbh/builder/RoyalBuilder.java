package br.com.hoteisbh.builder;

import br.com.hoteisbh.model.PrecoHotel;

/**
 * Classe concreta do Hotel Builder apra montar os dados doHotel The Royal
 * 
 * @author Rafael
 *
 */
public class RoyalBuilder extends HotelBuilder {

	@Override
	public void buildNome() {
		hotel.setNome("The Royal");
	}

	@Override
	public void buildClassificacao() {
		hotel.setClassificacao(5);
	}

	@Override
	public void buildPreco() {
		hotel.setPreco(new PrecoHotel(110, 80, 90, 80));
	}
}