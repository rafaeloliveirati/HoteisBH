package br.com.hoteisbh.controller;

import java.util.Date;

public class Hospede {
	private TipoReserva tipo;
	private Date[] datasReserva;

	public TipoReserva getTipo() {
		return tipo;
	}

	public void setTipo(TipoReserva tipo) {
		this.tipo = tipo;
	}

	public Date[] getDatasReserva() {
		return datasReserva;
	}

	public void setDatasReserva(Date[] datasReserva) {
		this.datasReserva = datasReserva;
	}

	public Hospede(TipoReserva tipo, Date... data) {
		this.tipo = tipo;
		datasReserva = data;
	}
}
