package br.com.hoteisbh.aplicacao;

import java.util.List;

import br.com.hoteisbh.controller.AplicacaoController;
import br.com.hoteisbh.controller.HotelController;
import br.com.hoteisbh.controller.ReservaController;
import br.com.hoteisbh.model.Hotel;
import br.com.hoteisbh.model.Reserva;
import br.com.hoteisbh.util.ConstantesString;
import br.com.hoteisbh.util.Utils;

/**
 * Classe main utilizada para inicializar o sistema
 * 
 * @author Rafael
 *
 */
public class Aplicacao {

	/**
	 * Metodo main que inicializa a aplicacao
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Cria uma lista de hoteis invocando o metodo builder hoteis
		List<Hotel> hoteis = HotelController.buildListaHoteis();
		/*
		 * Cria uma reserva a partir dos dados inseridos pelo usuario, estes
		 * dados serao repassados ao metodo builder reserva para geracao da
		 * reserva apartir dos mesmos
		 */
		String textoArquivo = "";
		if (args.length > 0) {
			textoArquivo = AplicacaoController.getTextoArquivo(args[0]);
		} else {
			System.out.println(ConstantesString.MENSAGEM_ERRO_PARAMETRO);
			System.exit(1);
		}
		if (Utils.IsEmptyOrNull(textoArquivo)) {
			System.out.println(ConstantesString.MENSAGEM_ERRO_ARQUIVO);
			System.exit(1);
		}
		Reserva reserva = ReservaController.builderReserva(AplicacaoController.formataEntrada(textoArquivo));
		// Printa no terminal o hotel com o melhor preco
		System.out.println(
				AplicacaoController.formataStringPrintTerminal(HotelController.getMelhorHotel(reserva, hoteis)));
	}
}
