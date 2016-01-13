package br.com.hoteisbh.model;

import java.util.List;

public class Reserva {
	private TipoHospede tipo;
	private List<DiariaReserva> diarias;

	public Reserva(TipoHospede tipo, List<DiariaReserva> listDiarias) {
		this.tipo = tipo;
		this.diarias = listDiarias;
	}

	public TipoHospede getTipo() {
		return tipo;
	}

	public void setTipo(TipoHospede tipo) {
		this.tipo = tipo;
	}

	public List<DiariaReserva> getDiarias() {
		return diarias;
	}

	public void setDiarias(List<DiariaReserva> diaria) {
		this.diarias = diaria;
	}
}
