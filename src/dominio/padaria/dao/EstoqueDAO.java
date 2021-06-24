package dominio.padaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import dominio.padaria.entity.Ingrediente;

public class EstoqueDAO implements IEstoqueDAO {

	private Connection c;

	public EstoqueDAO() {
		try {
			IGenericDAO gDao = new GenericDAO();
			c = gDao.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Ingrediente i, int qtde) {
		try {
			String sql = "UPDATE estoque SET quantidade = (quantidade - ?) WHERE ingrediente_id = ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, qtde);
			stmt.setInt(2, i.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void adicionar(Ingrediente i, int qtde) {
		try {
			String sql = "UPDATE estoque SET quantidade = (quantidade + ?) WHERE ingrediente_id = ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, qtde);
			stmt.setInt(2, i.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public List<Ingrediente> pesquisarIngrediente(String nome) {
		List<Ingrediente> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM ingrediente WHERE nome LIKE ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Ingrediente i = new Ingrediente();
				i.setId(rs.getInt("id"));
				i.setNome(rs.getString("nome"));
				i.setTipoUnit(rs.getString("tipoUnit"));
				lista.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public void gerarHistorico(Ingrediente i, String acao, int qtde) {
		try {
			String sql = "INSERT INTO historico (acao, quantidade, nome, data_acao) VALUES (?, ?, ?, GETDATE())";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, acao);
			stmt.setInt(2, qtde);
			stmt.setString(3, i.getNome());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
