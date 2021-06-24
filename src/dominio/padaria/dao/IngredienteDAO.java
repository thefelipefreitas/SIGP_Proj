package dominio.padaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.padaria.entity.Ingrediente;

public class IngredienteDAO implements IIngredienteDAO {

	private Connection c;

	public IngredienteDAO() {
		try {
			IGenericDAO gDao = new GenericDAO();
			c = gDao.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void adicionar(Ingrediente i) {
		try {
			String sql = "INSERT INTO ingrediente (nome, tipoUnit) VALUES (?, ?)";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, i.getNome());
			stmt.setString(2, i.getTipoUnit());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Ingrediente> pesquisarPorNome(String nome) {
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
	public void remover(Ingrediente i) {
		try {
			String sql = "DELETE FROM ingrediente WHERE nome LIKE ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, "%" + i.getNome() + "%");
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Ingrediente i) {

		try {
			String sql = "UPDATE ingrediente SET nome = ?, tipoUnit = ? WHERE id = ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, i.getNome());
			stmt.setString(2, i.getTipoUnit());
			stmt.setInt(3, i.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void adicionarEstoque(Ingrediente i) {
		try {
			String sql = "INSERT INTO estoque (quantidade, ingrediente_id) VALUES (?, ?)";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.setInt(2, i.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}