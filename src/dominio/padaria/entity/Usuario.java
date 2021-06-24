package dominio.padaria.entity;

public class Usuario {

	private String username;
	private String password;
	private String autenticador;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAutenticador() {
		return autenticador;
	}

	public void setAutenticador(String autenticador) {
		this.autenticador = autenticador;
	}

}