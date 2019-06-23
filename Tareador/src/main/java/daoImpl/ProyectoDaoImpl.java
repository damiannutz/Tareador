package daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.ProyectoDao;
import dominio.Prioridad;
import dominio.Proyecto;

public class ProyectoDaoImpl implements ProyectoDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Proyecto Proyecto) {
		this.hibernateTemplate.save(Proyecto);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Proyecto obtenerById(Integer idProyecto) {
		return this.hibernateTemplate.get(Proyecto.class, idProyecto);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Proyecto> obtenerAll() {
		return (ArrayList<Proyecto>) this.hibernateTemplate.loadAll(Proyecto.class);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Proyecto> obtenerAllActivos() {
		return (List<Proyecto>)  this.hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Proyecto.class).add(Restrictions.eq("isActivo", true)));
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminar(Integer idProyecto) {
		Proyecto item = new Proyecto();
		item.setIdProyecto(idProyecto);
		this.hibernateTemplate.delete(item);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void bajaLogica(Integer idProyecto) {
		
		Proyecto item = this.hibernateTemplate.get(Proyecto.class, idProyecto);
		item.setIsActivo(false);
		this.hibernateTemplate.update(item);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Proyecto Proyecto) {
		this.hibernateTemplate.update(Proyecto);
	}


}
