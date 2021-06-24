package dominio.padaria.boundary;

import dominio.padaria.control.LoginControl;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginBoundary extends Application {

	private TextField txtUser = new TextField();
	private TextField txtPassword = new TextField();

	private Button btnEntrar = new Button("Entrar");

	private LoginControl control = new LoginControl();

	private HomeBoundary hb = new HomeBoundary();

	public static void main(String[] args) {
		Application.launch(LoginBoundary.class, args);
	}

	@Override
	public void start(Stage stg) throws Exception {

		Label nome = new Label("SIGP");

		VBox vbox = new VBox();
		GridPane grid = new GridPane();

		Scene scn = new Scene(vbox, 600, 400);

		vbox.setPadding(new Insets(15, 15, 15, 15));

		grid.setAlignment(Pos.CENTER);

		vbox.setAlignment(Pos.CENTER);

		grid.setPadding(new Insets(15, 15, 15, 15));

		grid.setHgap(10);
		grid.setVgap(15);

		grid.add(new Label("Usuário"), 0, 0);
		grid.add(txtUser, 1, 0);
		grid.add(new Label("Senha"), 0, 1);
		grid.add(txtPassword, 1, 1);

		vbox.getChildren().addAll(nome, grid, btnEntrar);

		Bindings.bindBidirectional(txtUser.textProperty(), control.usernameProperty());
		Bindings.bindBidirectional(txtPassword.textProperty(), control.passwordProperty());

		btnEntrar.setOnAction((e) -> {
			control.validacao();
			try {
				hb.start(stg);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		stg.setTitle("Login");
		stg.setScene(scn);
		stg.show();
	}

}