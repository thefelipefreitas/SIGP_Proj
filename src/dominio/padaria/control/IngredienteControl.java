package dominio.padaria.control;

import java.util.List;

import dominio.padaria.dao.IIngredienteDAO;
import dominio.padaria.dao.IngredienteDAO;
import dominio.padaria.entity.Ingrediente;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class IngredienteControl {

	private ObservableList<Ingrediente> lista = FXCollections.observableArrayList();
	private TableView<Ingrediente> table = new TableView<>();

	private StringProperty nome = new SimpleStringProperty("");

	public StringProperty nomeProperty() {
		return nome;
	}

	private StringProperty tipoUnit = new SimpleStringProperty("");

	public StringProperty tipoUnitProperty() {
		return tipoUnit;
	}

	private IntegerProperty id = new SimpleIntegerProperty();

	public IntegerProperty idProperty() {
		return id;
	}

	private IIngredienteDAO ingDAO = new IngredienteDAO();

	public Ingrediente getEntity() {
		Ingrediente i = new Ingrediente();
		i.setId(id.get());
		i.setNome(nome.get());
		i.setTipoUnit(tipoUnit.get());
		return i;
	}

	private void setEntity(Ingrediente i) {
		if (i != null) {
			id.set(i.getId());
			nome.set(i.getNome());
			tipoUnit.set(i.getTipoUnit());
		}
	}

	public void adicionar() {
		Ingrediente i = getEntity();
		ingDAO.adicionar(i);
	}

	public void pesquisarPorNome() {
		List<Ingrediente> i = ingDAO.pesquisarPorNome(nome.get());
		lista.clear();
		lista.addAll(i);
	}

	public void remover() {
		Ingrediente i = getEntity();
		ingDAO.remover(i);
	}

	public void alterar() {
		Ingrediente i = getEntity();
		ingDAO.alterar(i);
	}

	public void adicinarEstoque() {
		Ingrediente i = getEntity();
		ingDAO.adicionarEstoque(i);
	}

	@SuppressWarnings("unchecked")
	public void generateTable() {

		TableColumn<Ingrediente, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("nome"));

		TableColumn<Ingrediente, String> colTipoUnit = new TableColumn<>("Tipo Unitário");
		colTipoUnit.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("tipoUnit"));

		TableColumn<Ingrediente, Integer> colId = new TableColumn<>("Id");
		colId.setCellValueFactory(new PropertyValueFactory<Ingrediente, Integer>("id"));

		table.getColumns().addAll(colId, colNome, colTipoUnit);
		table.setItems(lista);

		table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			setEntity(newValue);
		});

		table.setItems(lista);
		pesquisarPorNome();
	}

	public TableView<Ingrediente> getTable() {
		return table;
	}

}