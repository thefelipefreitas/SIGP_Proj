package dominio.padaria.entity;

public class Estoque {

	private int id;

	private int quantidade;

	private Ingrediente ingrediente;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}