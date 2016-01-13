package br.com.hoteisbh.model;

import java.util.Date;

public class Reserva {
	private TipoHospede tipo;
	private Date[] datas;

	public TipoHospede getTipo() {
		return tipo;
	}

	public void setTipo(TipoHospede tipo) {
		this.tipo = tipo;
	}

	public Date[] getDatasReserva() {
		return datas;
	}

	public void setDatasReserva(Date[] datasReserva) {
		this.datas = datasReserva;
	}

	public Reserva(TipoHospede tipo, Date... data) {
		this.tipo = tipo;
		datas = data;
	}
}
