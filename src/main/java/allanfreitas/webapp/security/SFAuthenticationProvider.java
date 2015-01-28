package allanfreitas.webapp.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import allanfreitas.webapp.dao.DAOPermissaoUsuario;
import allanfreitas.webapp.dao.UsuarioDAO;
import allanfreitas.webapp.model.PermissaoUsuario;
import allanfreitas.webapp.model.Usuario;

public class SFAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	@Qualifier(value = "permissaoDao")
	private DAOPermissaoUsuario daoPermissaoUsuario;
	
	public Authentication authenticate(Authentication auth)	throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) auth;
		String username = token.getName();
		String senha    = token.getCredentials() != null ? token.getCredentials().toString() : null;
		Usuario usuario = usuarioDAO.getUsuario(username, senha);
		if (usuario == null) {
			return null;
		}
		List<PermissaoUsuario> permissoes = daoPermissaoUsuario.getPermissoesUsuario(usuario);
		SFAuthentication resultado = new SFAuthentication(usuario, permissoes);
		resultado.setAuthenticated(usuario != null);
		return resultado;
	}

	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
