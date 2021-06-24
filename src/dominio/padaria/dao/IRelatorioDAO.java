package dominio.padaria.dao;

import java.util.List;
import dominio.padaria.entity.Historico;
import dominio.padaria.entity.RelatorioEstoque;

public interface IRelatorioDAO {

	public List<RelatorioEstoque> relatorioEstoque();

	public List<Historico> relatorioHistorico();

}