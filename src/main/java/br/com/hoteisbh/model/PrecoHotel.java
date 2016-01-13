package br.com.hoteisbh.model;

public class PrecoHotel {
	private float precoRegularSemana;
	private float precoRegularFds;
	private float precoVipSemana;
	private float precoVipFds;

	/**
	 * Construtor utilizado para receber os valos dos precos da reserva
	 * 
	 * @param precoRegularSemana
	 * @param precoRegularFds
	 * @param precoVipSemana
	 * @param precoVipFds
	 */
	public PrecoHotel(float precoRegularSemana, float precoRegularFds, float precoVipSemana, float precoVipFds) {
		this.precoRegularSemana = precoRegularSemana;
		this.precoRegularFds = precoRegularFds;
		this.precoVipSemana = precoVipSemana;
		this.precoVipFds = precoVipFds;
	}

	public float getPrecoRegularSemana() {
		return precoRegularSemana;
	}

	public void setPrecoRegularSemana(float precoRegularSemana) {
		this.precoRegularSemana = precoRegularSemana;
	}

	public float getPrecoRegularFds() {
		return precoRegularFds;
	}

	public void setPrecoRegularFds(float precoRegularFds) {
		this.precoRegularFds = precoRegularFds;
	}

	public float getPrecoVipSemana() {
		return precoVipSemana;
	}

	public void setPrecoVipSemana(float precoVipSemana) {
		this.precoVipSemana = precoVipSemana;
	}

	public float getPrecoVipFds() {
		return precoVipFds;
	}

	public void setPrecoVipFds(float precoVipFds) {
		this.precoVipFds = precoVipFds;
	}
}
