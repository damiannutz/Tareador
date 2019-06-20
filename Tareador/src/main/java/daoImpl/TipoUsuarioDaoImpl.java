package daoImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.TipoUsuarioDao;
import dominio.TipoUsuario;

public class TipoUsuarioDaoImpl implements TipoUsuarioDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(TipoUsuario TipoUsuario) {
		this.hibernateTemplate.save(TipoUsuario);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public TipoUsuario obtenerById(String idTipoUsuario) {
		return this.hibernateTemplate.get(TipoUsuario.class, idTipoUsuario);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<TipoUsuario> obtenerAll() {
		return (ArrayList<TipoUsuario>) this.hibernateTemplate.loadAll(TipoUsuario.class);
	}

//	
//	@Override
//	@Transactional(propagation=Propagation.REQUIRES_NEW)
//	public void eliminar(Integer idTipoUsuario) {
//		TipoUsuario user = new TipoUsuario();
//		user.setIdTipoUsuario(idTipoUsuario);
//		this.hibernateTemplate.delete(user);
//	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(TipoUsuario TipoUsuario) {
		this.hibernateTemplate.update(TipoUsuario);
	}

}
