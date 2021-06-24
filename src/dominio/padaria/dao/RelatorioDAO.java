package dominio.padaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.padaria.entity.Historico;
import dominio.padaria.entity.RelatorioEstoque;

public class RelatorioDAO implements IRelatorioDAO {

	private Connection c;

	public RelatorioDAO() {
		try {
			IGenericDAO gDao = new GenericDAO();
			c = gDao.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<RelatorioEstoque> relatorioEstoque() {
		List<RelatorioEstoque> lista = new ArrayList<>();
		try {
			String sql = "SELECT CAST(i.id AS VARCHAR(100)) AS id , i.nome, CAST(e.quantidade AS VARCHAR(100)) AS qtde\r\n"
					+ "FROM ingrediente i INNER JOIN estoque e\r\n" + "ON i.id = e.ingrediente_id";
			PreparedStatement stmt = c.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				RelatorioEstoque re = new RelatorioEstoque();
				re.setId(rs.getString("id"));
				re.setNome(rs.getString("nome"));
				re.setQtde(rs.getString("qtde"));
				lista.add(re);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	@Override
	public List<Historico> relatorioHistorico() {
		List<Historico> lista = new ArrayList<>();
		try {
			String sql = "SELECT nome, acao, quantidade, CONVERT(CHAR(10), data_acao, 103) AS data_acao FROM historico";
			PreparedStatement stmt = c.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Historico h = new Historico();
				h.setNome(rs.getString("nome"));
				h.setAcao(rs.getString("acao"));
				h.setQuantidadeOperacao(rs.getString("quantidade"));
				h.setDate(rs.getString("data_acao"));
				lista.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

}