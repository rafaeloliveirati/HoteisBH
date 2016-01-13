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
