package dominio.padaria.control;

import dominio.padaria.entity.Funcionario;
import dominio.padaria.entity.Usuario;

public class HomeControl {

	private Usuario u = new Usuario();
	private Usuario f = new Funcionario();
	private static String username;

	@SuppressWarnings("unused")
	public HomeControl(Usuario u) {
		this.u = u;
		final String user = u.getUsername();
		username = u.getUsername();
	}

	public HomeControl() {
	}

	public boolean autenticador() {
		if (username.equals(f.getUsername())) {
			return false;
		}
		return true;

	}

}