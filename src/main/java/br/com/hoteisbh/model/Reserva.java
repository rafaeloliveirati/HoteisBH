package br.com.hoteisbh.model;

import java.util.List;

public class Reserva {
	private TipoHospede tipo;
	private List<DiariaReserva> diaria;

	public Reserva(TipoHospede tipo, List<DiariaReserva> listDiarias) {
		this.tipo = tipo;
		this.diaria = listDiarias;
	}

	public TipoHospede getTipo() {
		return tipo;
	}

	public void setTipo(TipoHospede tipo) {
		this.tipo = tipo;
	}

	public List<DiariaReserva> getDiaria() {
		return diaria;
	}

	public void setDiaria(List<DiariaReserva> diaria) {
		this.diaria = diaria;
	}
}
