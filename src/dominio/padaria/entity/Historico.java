package dominio.padaria.entity;

public class Historico {

	private int id;
	private String nome;
	private String quantidadeOperacao;
	private String acao;
	private String date;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQuantidadeOperacao() {
		return quantidadeOperacao;
	}

	public void setQuantidadeOperacao(String quantidadeOperacao) {
		this.quantidadeOperacao = quantidadeOperacao;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}