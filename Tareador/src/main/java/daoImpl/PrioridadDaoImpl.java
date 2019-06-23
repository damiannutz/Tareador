package daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.PrioridadDao;
import dominio.Departamento;
import dominio.EstadoTarea;
import dominio.Prioridad;

public class PrioridadDaoImpl implements PrioridadDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Prioridad Prioridad) {
		this.hibernateTemplate.save(Prioridad);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Prioridad obtenerById(Integer idPrioridad) {
		return this.hibernateTemplate.get(Prioridad.class, idPrioridad);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Prioridad> obtenerAll() {
		return (ArrayList<Prioridad>) this.hibernateTemplate.loadAll(Prioridad.class);
	}

	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Prioridad> obtenerAllActivos() {
		return (List<Prioridad>)  this.hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Prioridad.class).add(Restrictions.eq("isActivo", true)));
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminar(Integer idPrioridad) {
		Prioridad item = new Prioridad();
		item.setIdPrioridad(idPrioridad);
		this.hibernateTemplate.delete(item);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void bajaLogica(Integer idPrioridad) {
		
		Prioridad item = this.hibernateTemplate.get(Prioridad.class, idPrioridad);
		item.setIsActivo(false);
		this.hibernateTemplate.update(item);
	}
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Prioridad Prioridad) {
		this.hibernateTemplate.update(Prioridad);
	}


}
