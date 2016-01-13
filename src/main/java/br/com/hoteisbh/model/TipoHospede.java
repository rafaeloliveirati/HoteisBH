package br.com.hoteisbh.model;

public enum TipoHospede {
	/**
	 * Tipo regular
	 */
	HOSPEDE_REGULAR("Regular"),
	/**
	 * Tipo vip
	 */
	HOSPEDE_VIP("Vip");
	String valor;

	TipoHospede(String valorOpcao) {
		valor = valorOpcao;
	}

	public String getValor() {
		return valor;
	}

	public static TipoHospede get(String tipoCampo) {
		TipoHospede[] tipos = TipoHospede.values();
		for (TipoHospede tipo : tipos) {
			if (tipo.getValor().equals(tipoCampo)) {
				return tipo;
			}
		}
		return null;
	}

}
