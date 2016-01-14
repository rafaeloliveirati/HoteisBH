package br.com.hoteisbh.aplicacao;

import java.util.List;
import java.util.Scanner;

import br.com.hoteisbh.controller.AplicacaoController;
import br.com.hoteisbh.controller.HotelController;
import br.com.hoteisbh.controller.ReservaController;
import br.com.hoteisbh.model.Hotel;
import br.com.hoteisbh.model.Reserva;
import br.com.hoteisbh.util.ConstantesString;

/**
 * Classe main utilizada para inicializar o sistema
 * 
 * @author Rafael
 *
 */
public class Aplicacao {

	private static Scanner sc;

	/**
	 * Metodo main que inicializa a aplicação
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Cria uma lista de hoteis invocando o metodo builder hoteis
		List<Hotel> hoteis = HotelController.buildListaHoteis();
		System.out.println(ConstantesString.MENSAGEM_ENTRADA);
		// Cria um scanner para capturar a entrada de dados atraves do terminal
		sc = new Scanner(System.in);
		// TODO - String de testes, retirar quando for gerar o .jar
		// String entrada = "Regular: 20Mar2015(sex), 21Mar2015(sab),
		// 22Mar2015(dom)";
		// Insere na string de entrada o valor digitado pelo usuario no terminal
		String entrada = "";
		while (!AplicacaoController.isEntradaValida(entrada)) {
			entrada = sc.nextLine();
			if (entrada.equals("x")) {
				System.exit(1);
			}
			if (!AplicacaoController.isEntradaValida(entrada)) {
				System.out.println(ConstantesString.MENSAGE_ERRO_ENTRADA + "\n"
						+ ConstantesString.MENSAGE_FORMATO_MASCARA + "\n" + ConstantesString.MENSAGE_FORMATO_CORRETO);
				System.out.println(ConstantesString.MENSAGEM_EXIT);

			}
		}
		/*
		 * Cria uma reserva a partir dos dados inseridos pelo usuario, estes
		 * dados serão repassados ao metodo builder reserva para geracao da
		 * reserva apartir dos mesmos
		 */
		Reserva reserva = ReservaController.builderReserva(AplicacaoController.formataEntrada(entrada.trim()));
		// Printa no terminal o hotel com o melhor preco
		System.out.println(
				AplicacaoController.formataStringPrintTerminal(HotelController.getMelhorHotel(reserva, hoteis)));
	}
}
