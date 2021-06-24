package dominio.padaria.boundary;

import dominio.padaria.control.EstoqueControl;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class EstoqueBoundary implements ITelaStrategy {

	private TextField nomeProduto = new TextField();
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnRemover = new Button("Remover");
	private Label lblNome = new Label("Nome Ingrediente");
	private Label lblId = new Label("");
	private TextField qtde = new TextField();

	private BorderPane border = new BorderPane();
	private HBox hbox = new HBox();
	private HBox hbox2 = new HBox();
	private HBox hbox3 = new HBox();
	private VBox vbox = new VBox();

	private EstoqueControl control = new EstoqueControl();

	@SuppressWarnings("unchecked")
	public EstoqueBoundary() {

		border.setPadding(new Insets(15, 15, 15, 15));

		hbox.getChildren().addAll(lblNome, nomeProduto, btnPesquisar);

		border.setTop(hbox);

		control.generateTable();
		border.setCenter(control.getTable());

		hbox3.getChildren().addAll(qtde, btnAdicionar, btnRemover);
		vbox.getChildren().addAll(hbox2, hbox3);
		border.setRight(vbox);

		@SuppressWarnings("rawtypes")
		StringConverter converter = new IntegerStringConverter();
		Bindings.bindBidirectional(nomeProduto.textProperty(), control.nomeProperty());
		Bindings.bindBidirectional(qtde.textProperty(), control.quantidadeProperty(), converter);
		Bindings.bindBidirectional(lblId.textProperty(), control.idProperty(), converter);

		btnPesquisar.setOnAction((e) -> {
			control.pesquisarIngrediente();
		});
		btnAdicionar.setOnAction((e) -> {
			control.adicionar();
			control.gerarHistorico("Adicionar");
		});
		btnRemover.setOnAction((e) -> {
			control.adicionar();
			control.gerarHistorico("Remover");
		});

	}

	@Override
	public Pane fornecerConteudo() {
		// TODO Auto-generated method stub
		return border;
	}
}
