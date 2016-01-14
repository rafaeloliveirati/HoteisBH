package br.com.hoteisbh.model;

import java.util.Date;

public class DiariaReserva {
	private Date data;
	private double valor;

	public DiariaReserva(Date diaria) {
		data = diaria;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date datas) {
		this.data = datas;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
