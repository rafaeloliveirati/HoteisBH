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

	TipoHospede(String valueOption) {
	}

	public static TipoHospede get(String tipoCampo) {
		TipoHospede[] tipos = TipoHospede.values();
		for (TipoHospede tipo : tipos) {
			if (tipo.toString().equals(tipoCampo)) {
				return tipo;
			}
		}
		return null;
	}

}
