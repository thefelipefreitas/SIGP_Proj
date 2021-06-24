package dominio.padaria.boundary;

import dominio.padaria.control.RelatorioControl;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RelatorioBoundary implements ITelaStrategy {

	private Label lblAtivos = new Label("Ativos");
	private Label lblHist = new Label("Historico");

	private RelatorioControl control = new RelatorioControl();

	private VBox vbox = new VBox();

	public RelatorioBoundary() {

		control.generateTableEstoque();
		control.generateTableHist();
		vbox.getChildren().addAll(lblAtivos, control.getTableEstoque(), lblHist, control.getTableHist());

	}

	@Override
	public Pane fornecerConteudo() {
		// TODO Auto-generated method stub
		return vbox;
	}

}