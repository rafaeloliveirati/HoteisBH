package br.com.hoteisbh.controller;

import java.io.BufferedReader;
import java.io.FileReader;

import br.com.hoteisbh.model.ReservaHotel;
import br.com.hoteisbh.model.TipoHospede;
import br.com.hoteisbh.util.Utils;

/**
 * Classe destinada a utilidades relacionadas a aplicacao HoteisBH
 * 
 * @author Rafael
 *
 */
public class AplicacaoController {
	/**
	 * Metodo para validar a entrada de dados no terminal, fiz algumas regras
	 * seguindo o padrao de entrada. Imaginando que o backEnd receberia uma
	 * estrutura padronizada daquela forma.
	 * 
	 * @param entrada
	 * @return
	 */
	public static boolean isEntradaValida(String entrada) {
		// Valida se a entrada esta vazia ou nula
		if (Utils.IsEmptyOrNull(entrada)) {
			return false;
		}
		/*
		 * Valida se contem a "," ou o ":" , pois de acordo com a entada seriam
		 * os parametros de divisoes entre tipos de dados. Onde o ":" dividiria
		 * o tipo das datas e a "," as divisoes das proprias datas
		 */
		else if (!entrada.contains(",") || !entrada.contains(":")) {
			return false;
		}
		/*
		 * Valida o tipo de hospede se é um hospede valido
		 */
		else if (TipoHospede.get(formataEntrada(entrada)[0]) == null) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo que formata a string corretamente para retornar ao usuario
	 * 
	 * @param melhorHotel
	 * @return
	 */
	public static String formataStringPrintTerminal(ReservaHotel melhorHotel) {
		return melhorHotel.getHotel().getNome() + ": R$" + Utils.tryDoubleToInt(melhorHotel.getValor());
	}

	/**
	 * Metodo que recebe o valor um valor de entrada e quebra em varios
	 * parametros
	 * 
	 * @param entrada
	 * @return
	 */
	public static String[] formataEntrada(String entrada) {
		/*
		 * Retorna a entrada formatada de acordo com os separadores : || ,
		 */
		String[] split = entrada.split("\\,|\\:");
		for (int i = 0; i < split.length; i++) {
			split[i] = split[i].replaceAll(" ", "");
		}
		return split;
	}

	public static String getTextoArquivo(String localFile) {
		try {
			// c:\\file.txt
			String srtFile = localFile;
			FileReader inputFile = new FileReader(srtFile);
			BufferedReader bufferReader = new BufferedReader(inputFile);
			String line;
			while ((line = bufferReader.readLine()) != null) {
				if (isEntradaValida(line)) {
					return line.trim();
				}
			}
			bufferReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
