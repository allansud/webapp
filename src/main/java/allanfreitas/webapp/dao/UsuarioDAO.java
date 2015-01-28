package allanfreitas.webapp.dao;

import java.util.List;

import allanfreitas.webapp.model.Usuario;

public interface UsuarioDAO {
	
	public void salvar(Usuario usuario);
	
	public void deletar(Usuario usuario);
	
	public List<Usuario> listar();
	
	public boolean verificaUsuario(String email);
	
	/** Busca usuario por login e senha */
	public Usuario getUsuario(String login, String senha);
	
	/** Busca usuario pelo login */
	public Usuario getUsuario(String login);
}
