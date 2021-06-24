package dominio.padaria.entity;

public class Funcionario extends Usuario {

	public Funcionario() {
		this.setUsername("func");
		this.setPassword("123456");
		this.setAutenticador("a");
	}
}
