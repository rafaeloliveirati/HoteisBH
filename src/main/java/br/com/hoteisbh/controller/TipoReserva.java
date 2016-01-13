package br.com.hoteisbh.controller;

public enum TipoReserva {
	HOSPEDE_REGULAR("Regular"), HOSPEDE_VIP("Vip");

	private final String value;

	TipoReserva(String valueOption) {
		value = valueOption;
	}

	public String getValor() {
		return value;
	}

}
