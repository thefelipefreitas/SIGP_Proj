package dominio.padaria.boundary;

import dominio.padaria.control.IngredienteControl;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class IngredienteBoundary implements ITelaStrategy {

	private TextField txtNome = new TextField();
	private TextField txtTipoUnit = new TextField();
	private Button btAdicionar = new Button("Adicionar");
	private Button btPesquisar = new Button("Pesquisar");
	private Button btRemover = new Button("Remover");
	private Button btAlterar = new Button("Alterar");

	private BorderPane panePrincipal = new BorderPane();
	private GridPane gridPane = new GridPane();

	private HBox paneBotao = new HBox(10);
	private VBox paneSecundario = new VBox(20);

	private IngredienteControl control = new IngredienteControl();

	public IngredienteBoundary() {

		paneBotao.getChildren().addAll(btAdicionar, btAlterar, btRemover);

		paneSecundario.setPadding(new Insets(15, 15, 15, 15));

		gridPane.setHgap(10);

		gridPane.add(new Label("Nome"), 0, 0);
		gridPane.add(txtNome, 1, 0);
		gridPane.add(new Label("Tipo Unitario"), 0, 1);
		gridPane.add(txtTipoUnit, 1, 1);
		gridPane.add(btPesquisar, 2, 0);

		control.generateTable();
		panePrincipal.setCenter(control.getTable());

		btAdicionar.setOnAction((e) -> {
			control.adicionar();
		});

		btPesquisar.setOnAction((e) -> {
			control.pesquisarPorNome();
		});

		btAlterar.setOnAction((e) -> {
			control.alterar();
		});

		btRemover.setOnAction((e) -> {
			control.remover();
		});

		paneSecundario.getChildren().addAll(gridPane, paneBotao);

		panePrincipal.setTop(paneSecundario);

		Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
		Bindings.bindBidirectional(txtTipoUnit.textProperty(), control.tipoUnitProperty());

	}

	@Override
	public Pane fornecerConteudo() {
		return panePrincipal;
	}
}