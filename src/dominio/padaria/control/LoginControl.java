package dominio.padaria.control;

import javax.swing.JOptionPane;

import dominio.padaria.entity.Funcionario;
import dominio.padaria.entity.Gestor;
import dominio.padaria.entity.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginControl {

	private StringProperty username = new SimpleStringProperty("");

	public StringProperty usernameProperty() {
		return username;
	}

	private StringProperty password = new SimpleStringProperty("");

	public StringProperty passwordProperty() {
		return password;
	}

	public Usuario getEntity() {
		Usuario u = new Usuario();
		u.setUsername(username.get());
		u.setPassword(password.get());
		return u;
	}

	public void validacao() {
		Usuario f = new Funcionario();
		Usuario g = new Gestor();
		Usuario u = new Usuario();
		u = getEntity();
		if (u.getUsername().equals(f.getUsername()) && u.getPassword().equals(f.getPassword())) {
			u.setAutenticador(f.getAutenticador());
			abreHome(u);
		} else if (u.getUsername().equals(g.getUsername()) && u.getPassword().equals(g.getPassword())) {
			u.setAutenticador(g.getAutenticador());
			abreHome(u);
		} else {
			JOptionPane.showMessageDialog(null, "Login Invalido!!!");
		}
	}

	public void abreHome(Usuario u) {
		HomeControl control = new HomeControl(u);

	}

}