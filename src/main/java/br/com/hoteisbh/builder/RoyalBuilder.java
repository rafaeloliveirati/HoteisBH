package br.com.hoteisbh.builder;

import br.com.hoteisbh.model.PrecoHotel;

/**
 * Classe concreta do Hotel Builder para montar os dados doH otel The Royal
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
		hotel.setPreco(new PrecoHotel(220, 110, 60, 50));
	}
}
