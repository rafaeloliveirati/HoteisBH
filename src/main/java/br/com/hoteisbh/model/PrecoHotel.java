package br.com.hoteisbh.model;

public class PrecoHotel {
	private double precoRegularSemana;
	private double precoRegularFds;
	private double precoVipSemana;
	private double precoVipFds;

	/**
	 * Construtor utilizado para receber os valos dos precos da reserva
	 * 
	 * @param precoRegularSemana
	 * @param precoRegularFds
	 * @param precoVipSemana
	 * @param precoVipFds
	 */
	public PrecoHotel(double precoRegularSemana, double precoRegularFds, double precoVipSemana, double precoVipFds) {
		this.precoRegularSemana = precoRegularSemana;
		this.precoRegularFds = precoRegularFds;
		this.precoVipSemana = precoVipSemana;
		this.precoVipFds = precoVipFds;
	}

	public double getPrecoRegularSemana() {
		return precoRegularSemana;
	}

	public void setPrecoRegularSemana(double precoRegularSemana) {
		this.precoRegularSemana = precoRegularSemana;
	}

	public double getPrecoRegularFds() {
		return precoRegularFds;
	}

	public void setPrecoRegularFds(double precoRegularFds) {
		this.precoRegularFds = precoRegularFds;
	}

	public double getPrecoVipSemana() {
		return precoVipSemana;
	}

	public void setPrecoVipSemana(double precoVipSemana) {
		this.precoVipSemana = precoVipSemana;
	}

	public double getPrecoVipFds() {
		return precoVipFds;
	}

	public void setPrecoVipFds(double precoVipFds) {
		this.precoVipFds = precoVipFds;
	}
}
