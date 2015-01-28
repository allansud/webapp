package allanfreitas.webapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import allanfreitas.webapp.model.PermissaoUsuario;
import allanfreitas.webapp.model.Usuario;

@Component("permissaoDao")
public class DAOPermissaoUsuarioImpl implements DAOPermissaoUsuario{

	private SessionFactory sessionFactory;
	
	@Autowired
	public DAOPermissaoUsuarioImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<PermissaoUsuario> getPermissoesUsuario(Usuario usuario) {
		if(usuario == null){
			return new ArrayList<PermissaoUsuario>();
		}
		Query query = this.sessionFactory.getCurrentSession().createQuery("from PermissaoUsuario pu where pu.usuario = ?");
		query.setEntity(0, usuario);
		return query.list();
	}

	@Transactional
	public void addRole(String role, Usuario usuario) {		
		if(role != null && usuario != null){
			PermissaoUsuario permissaoUsuario = new PermissaoUsuario();
			permissaoUsuario.setRole(role);
			permissaoUsuario.setUsuario(usuario);
			this.sessionFactory.getCurrentSession().saveOrUpdate(permissaoUsuario);
		}
	}

}
