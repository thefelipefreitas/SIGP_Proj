package dominio.padaria.control;

import java.util.List;

import dominio.padaria.dao.EstoqueDAO;
import dominio.padaria.dao.IEstoqueDAO;
import dominio.padaria.entity.Ingrediente;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EstoqueControl {

	private ObservableList<Ingrediente> listaIng = FXCollections.observableArrayList();
	private TableView<Ingrediente> table = new TableView<>();

	private IEstoqueDAO estDAO = new EstoqueDAO();

	private StringProperty nome = new SimpleStringProperty("");

	public StringProperty nomeProperty() {
		return nome;
	}

	private IntegerProperty quantidade = new SimpleIntegerProperty();

	public IntegerProperty quantidadeProperty() {
		return quantidade;
	}

	private IntegerProperty id = new SimpleIntegerProperty();

	public IntegerProperty idProperty() {
		return id;
	}

	private ObjectProperty<Ingrediente> ing = new SimpleObjectProperty<Ingrediente>();

	public ObjectProperty<Ingrediente> idIngProperty() {
		return ing;
	}

	private void setEntity(Ingrediente i) {
		if (i != null) {
			id.set(i.getId());
			nome.set(i.getNome());
		}
	}

	public Ingrediente getEntity() {
		Ingrediente i = new Ingrediente();
		i.setId(id.get());
		i.setNome(nome.get());
		return i;
	}

	public void adicionar() {
		Ingrediente i = getEntity();
		estDAO.adicionar(i, quantidade.get());
	}

	public void remover() {
		Ingrediente i = getEntity();
		estDAO.remover(i, quantidade.get());
	}

	public void pesquisarIngrediente() {
		List<Ingrediente> i = estDAO.pesquisarIngrediente(nome.get());
		listaIng.clear();
		listaIng.addAll(i);
	}

	public void gerarHistorico(String acao) {
		Ingrediente i = getEntity();
		estDAO.gerarHistorico(i, acao, quantidade.get());
	}

	@SuppressWarnings("unchecked")
	public void generateTable() {
		TableColumn<Ingrediente, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("nome"));

		TableColumn<Ingrediente, Integer> colId = new TableColumn<>("Id");
		colId.setCellValueFactory(new PropertyValueFactory<Ingrediente, Integer>("id"));

		table.getColumns().addAll(colNome, colId);
		table.setItems(listaIng);

		table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			setEntity(newValue);
		});
	}

	public TableView<Ingrediente> getTable() {
		return table;
	}

}