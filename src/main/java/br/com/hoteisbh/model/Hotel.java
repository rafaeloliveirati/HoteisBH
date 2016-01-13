package br.com.hoteisbh.model;

/**
 * Model utilizado para manipular os dados dos hoteis
 * 
 * @author Rafael
 *
 */
public class Hotel {
	private String nome;
	private int classificacao;
	private PrecoHotel preco;

	/**
	 * Construtor utilizado para copular as informa��es pr� definidas dos hoteis
	 * existentes
	 * 
	 * @param nome
	 * @param classificacao
	 * @param precoRegularSemana
	 * @param precoRegularFds
	 * @param precoVipSemana
	 * @param precoVipFds
	 */
	// public Hotel(String razaoSocial, int classificacao, Double
	// precoRegularSemana, Double precoRegularFds,
	// Double precoVipSemana, Double precoVipFds) {
	// this.razaoSocial = razaoSocial;
	// this.classificacao = classificacao;
	// preco = new PrecoHotel(precoRegularSemana, precoRegularFds,
	// precoVipSemana, precoVipFds);
	// }

	public String getNome() {
		return nome;
	}

	public void setNome(String razaoSocial) {
		this.nome = razaoSocial;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	public PrecoHotel getPreco() {
		return preco;
	}

	public void setPreco(PrecoHotel preco) {
		this.preco = preco;
	}
}
