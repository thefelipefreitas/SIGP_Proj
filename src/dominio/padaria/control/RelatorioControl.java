package dominio.padaria.control;

import java.util.List;

import dominio.padaria.dao.IRelatorioDAO;
import dominio.padaria.dao.RelatorioDAO;
import dominio.padaria.entity.Historico;
import dominio.padaria.entity.RelatorioEstoque;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RelatorioControl {

	private ObservableList<RelatorioEstoque> listaEstoque = FXCollections.observableArrayList();
	private TableView<RelatorioEstoque> tableEstoque = new TableView<>();

	private ObservableList<Historico> listaHist = FXCollections.observableArrayList();
	private TableView<Historico> tableHist = new TableView<>();

	private IRelatorioDAO relDAO = new RelatorioDAO();

	public void gerarEstoque() {
		List<RelatorioEstoque> re = relDAO.relatorioEstoque();
		listaEstoque.clear();
		listaEstoque.addAll(re);
	}

	public void gerarHistorico() {
		List<Historico> h = relDAO.relatorioHistorico();
		listaHist.clear();
		listaHist.addAll(h);
	}

	@SuppressWarnings("unchecked")
	public void generateTableEstoque() {

		TableColumn<RelatorioEstoque, String> colId = new TableColumn<>("Id");
		colId.setCellValueFactory(new PropertyValueFactory<RelatorioEstoque, String>("id"));

		TableColumn<RelatorioEstoque, String> colNome = new TableColumn<>("Nome Ingrediente");
		colNome.setCellValueFactory(new PropertyValueFactory<RelatorioEstoque, String>("nome"));

		TableColumn<RelatorioEstoque, String> colQtde = new TableColumn<>("Quantidade");
		colQtde.setCellValueFactory(new PropertyValueFactory<RelatorioEstoque, String>("qtde"));

		tableEstoque.getColumns().addAll(colId, colNome, colQtde);
		tableEstoque.setItems(listaEstoque);

		gerarEstoque();
	}

	@SuppressWarnings("unchecked")
	public void generateTableHist() {

		TableColumn<Historico, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(new PropertyValueFactory<Historico, String>("nome"));

		TableColumn<Historico, String> colAcao = new TableColumn<>("Ação");
		colAcao.setCellValueFactory(new PropertyValueFactory<Historico, String>("acao"));

		TableColumn<Historico, String> colQtde = new TableColumn<>("Quantidade");
		colQtde.setCellValueFactory(new PropertyValueFactory<Historico, String>("quantidadeOperacao"));

		TableColumn<Historico, String> colDate = new TableColumn<>("Data");
		colDate.setCellValueFactory(new PropertyValueFactory<Historico, String>("date"));

		tableHist.getColumns().addAll(colNome, colAcao, colQtde, colDate);
		tableHist.setItems(listaHist);

		gerarHistorico();
	}

	public TableView<RelatorioEstoque> getTableEstoque() {
		return tableEstoque;
	}

	public TableView<Historico> getTableHist() {
		return tableHist;
	}

}