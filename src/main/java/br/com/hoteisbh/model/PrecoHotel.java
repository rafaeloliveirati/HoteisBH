package br.com.hoteisbh.model;

public class PrecoHotel {
	private Double precoRegularSemana;
	private Double precoRegularFds;
	private Double precoVipSemana;
	private Double precoVipFds;

	public PrecoHotel(Double precoRegularSemana, Double precoRegularFds, Double precoVipSemana, Double precoVipFds) {
		this.precoRegularSemana = precoRegularSemana;
		this.precoRegularFds = precoRegularFds;
		this.precoVipSemana = precoVipSemana;
		this.precoVipFds = precoVipFds;
	}

	public Double getPrecoRegularSemana() {
		return precoRegularSemana;
	}

	public void setPrecoRegularSemana(Double precoRegularSemana) {
		this.precoRegularSemana = precoRegularSemana;
	}

	public Double getPrecoRegularFds() {
		return precoRegularFds;
	}

	public void setPrecoRegularFds(Double precoRegularFds) {
		this.precoRegularFds = precoRegularFds;
	}

	public Double getPrecoVipSemana() {
		return precoVipSemana;
	}

	public void setPrecoVipSemana(Double precoVipSemana) {
		this.precoVipSemana = precoVipSemana;
	}

	public Double getPrecoVipFds() {
		return precoVipFds;
	}

	public void setPrecoVipFds(Double precoVipFds) {
		this.precoVipFds = precoVipFds;
	}
}
