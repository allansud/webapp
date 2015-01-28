package allanfreitas.webapp.dao;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import allanfreitas.webapp.model.Usuario;

@Component("usuarioDAO")
public class UsuarioDAOImpl implements UsuarioDAO{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public UsuarioDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void salvar(Usuario usuario) {
		this.sessionFactory.getCurrentSession().save(usuario);
	}

	@Transactional
	public void deletar(Usuario usuario) {
		this.sessionFactory.getCurrentSession().delete(usuario);
	}
	
	@Transactional
	public boolean verificaUsuario(String email){
		Usuario usuario = null;
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Usuario usr where usr.email = ?");
		query.setString(0, email);
		usuario = (Usuario) query.uniqueResult();
		
		if(usuario == null){
			return true;
		}else{
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Usuario> listar() {
		List<Usuario> listUsers = null;
		listUsers = (List<Usuario>) this.sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUsers;
	}

	@Transactional
	public Usuario getUsuario(String login, String senha) {
		String hashSenha = DigestUtils.sha256Hex(senha);
		Usuario usuario = null;
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery("from Usuario usr where usr.login = ? and usr.hashSenha = ?");
			query.setString(0, login);
			query.setString(1, hashSenha);
			usuario = (Usuario) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	@Transactional
	public Usuario getUsuario(String login) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Usuario usr where usr.login = ?");
		query.setString(0, login);
		return (Usuario) query.uniqueResult();
	}
	
}
