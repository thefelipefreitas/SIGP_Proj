package dominio.padaria.dao;

import java.util.List;

import dominio.padaria.entity.Ingrediente;

public interface IIngredienteDAO {

	public void adicionar(Ingrediente i);

	public void adicionarEstoque(Ingrediente i);

	public List<Ingrediente> pesquisarPorNome(String nome);

	public void remover(Ingrediente i);

	public void alterar(Ingrediente i);

}
