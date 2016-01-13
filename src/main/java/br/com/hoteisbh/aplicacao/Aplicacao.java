package br.com.hoteisbh.aplicacao;

import java.util.List;
import java.util.Scanner;

import br.com.hoteisbh.controller.HotelController;
import br.com.hoteisbh.controller.ReservaController;
import br.com.hoteisbh.model.Hotel;
import br.com.hoteisbh.model.Reserva;

/**
 * Classe main utilizada para inicializar o sistema
 * 
 * @author Rafael
 *
 */
public class Aplicacao {
	private static Scanner sc;

	public static void main(String[] args) {
		// Cria uma lista de hoteis invocando o metodo builder hoteis
		List<Hotel> hoteis = HotelController.buildListaHoteis();
		System.out.println("Bem vindo ao sistema Hoteis BH - Digite os parametros de entrada:");
		// Cria um scanner para capturar a entrada de dados atraves do terminal
		sc = new Scanner(System.in);
		// TODO - String de testes, retirar quando for gerar o .jar
		// String entrada = "Regular: 20Mar2015(sex), 21Mar2015(sab),
		// 22Mar2015(dom)";
		// Insere na string de entrada o valor digitado pelo usuario no terminal
		String entrada = sc.nextLine();
		/*
		 * Cria uma reserva a partir dos dados inseridos pelo usuario, estes
		 * dados serão repassados ao metodo builder reserva para geracao da
		 * reserva apartir dos mesmos
		 */
		Reserva reserva = ReservaController.builderReserva(entrada);
		/*
		 * Aciona o metodo para buscar o melhor preco de hotel apartir da
		 * reserva criada e da lista de hoteis criada pelo builder
		 */
		System.out.println(HotelController.verificaMelhorHotel(reserva, hoteis));
	}

}
