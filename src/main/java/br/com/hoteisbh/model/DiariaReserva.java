package br.com.hoteisbh.model;

import java.util.Date;

public class DiariaReserva {
	private Date data;
	private float valor;

	public DiariaReserva(Date diaria) {
		data = diaria;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date datas) {
		this.data = datas;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
