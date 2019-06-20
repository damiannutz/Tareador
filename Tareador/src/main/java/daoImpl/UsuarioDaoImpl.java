package daoImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.UsuarioDao;
import dominio.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarUsuario(Usuario usuario) {
		this.hibernateTemplate.save(usuario);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Usuario obtenerUsuarioPorId(Integer idUsuario) {
		return this.hibernateTemplate.get(Usuario.class, idUsuario);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Usuario> obtenerUsuarios() {
		return (ArrayList<Usuario>) this.hibernateTemplate.loadAll(Usuario.class);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminarUsuario(Integer idUsuario) {
		Usuario user = new Usuario();
		user.setIdUsuario(idUsuario);
		this.hibernateTemplate.delete(user);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizarUsuario(Usuario persona) {
		this.hibernateTemplate.update(persona);
	}


}
