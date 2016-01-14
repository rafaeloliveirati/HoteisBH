package br.com.hoteisbh.model;

public class ReservaHotel {
	private Hotel hotel;
	private double valor;

	public double getValor() {
		return valor;
	}

	public void setValor(double valorReserva) {
		this.valor = valorReserva;
	}

	public ReservaHotel(Hotel hotel, double valorReserva) {
		this.hotel = hotel;
		this.valor = valorReserva;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
