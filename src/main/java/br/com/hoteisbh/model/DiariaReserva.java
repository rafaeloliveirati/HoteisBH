package br.com.hoteisbh.model;

import java.time.LocalDate;

public class DiariaReserva {
	private LocalDate data;
	private double valor;

	public DiariaReserva(LocalDate localDate) {
		data = localDate;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate datas) {
		this.data = datas;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
