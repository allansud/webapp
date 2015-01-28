package allanfreitas.webapp.dao;

import java.util.List;

import allanfreitas.webapp.model.PermissaoUsuario;
import allanfreitas.webapp.model.Usuario;

public interface DAOPermissaoUsuario {
	
	public List<PermissaoUsuario> getPermissoesUsuario(Usuario usuario);
	
	public void addRole(String role, Usuario usuario);
}
