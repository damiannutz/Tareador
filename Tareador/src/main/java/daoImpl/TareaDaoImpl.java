package daoImpl;

import java.util.*;
import java.util.stream.Collectors;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.TareaDao;
import dominio.Rol;
import dominio.Tarea;

public class TareaDaoImpl implements TareaDao {


	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Tarea Tarea) {
		this.hibernateTemplate.save(Tarea);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Tarea obtenerById(Integer IdTarea) {
		return this.hibernateTemplate.get(Tarea.class, IdTarea);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Set<Tarea> obtenerAll() {
		return (Set<Tarea>) this.hibernateTemplate.loadAll(Tarea.class).stream().collect(Collectors.toSet());
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Set<Tarea> obtenerAllActivos() {
		return (Set<Tarea>)  this.hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Tarea.class).add(Restrictions.eq("IsActivo", true))).stream().collect(Collectors.toSet());
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminar(Integer idTarea) {
		Tarea item = new Tarea();
		item.setIdTarea(idTarea);
		this.hibernateTemplate.delete(item);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void bajaLogica(Integer idTarea) {
		
		Tarea item = this.hibernateTemplate.get(Tarea.class, idTarea);
		item.setIsActivo(false);
		this.hibernateTemplate.update(item);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Tarea Tarea) {
		this.hibernateTemplate.update(Tarea);
	}


	
}
