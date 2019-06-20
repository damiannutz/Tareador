package daoImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.RolDao;
import dominio.Rol;

public class RolDaoImpl implements RolDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Rol Rol) {
		this.hibernateTemplate.save(Rol);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Rol obtenerById(Integer idRol) {
		return this.hibernateTemplate.get(Rol.class, idRol);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Rol> obtenerAll() {
		return (ArrayList<Rol>) this.hibernateTemplate.loadAll(Rol.class);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminar(Integer idRol) {
		Rol item = new Rol();
		item.setIdRol(idRol);
		this.hibernateTemplate.delete(item);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Rol Rol) {
		this.hibernateTemplate.update(Rol);
	}


}