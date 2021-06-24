package dominio.padaria.entity;

public class Ingrediente {

	private int id;
	private String nome;
	private String tipoUnit;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoUnit() {
		return tipoUnit;
	}

	public void setTipoUnit(String tipoUnit) {
		this.tipoUnit = tipoUnit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}