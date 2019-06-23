package daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.TipoTareaDao;
import dominio.Tarea;
import dominio.TipoTarea;


public class TipoTareaDaoImpl implements TipoTareaDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(TipoTarea TipoTarea) {
		this.hibernateTemplate.save(TipoTarea);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public TipoTarea obtenerById(Integer idTipoTarea) {
		return this.hibernateTemplate.get(TipoTarea.class, idTipoTarea);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<TipoTarea> obtenerAll() {
		return (ArrayList<TipoTarea>) this.hibernateTemplate.loadAll(TipoTarea.class);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<TipoTarea> obtenerAllActivos() {
		return (List<TipoTarea>)  this.hibernateTemplate.findByCriteria(DetachedCriteria.forClass(TipoTarea.class).add(Restrictions.eq("IsActivo", true)));
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminar(Integer idTipoTarea) {
		TipoTarea item = new TipoTarea();
		item.setIdTipoTareas(idTipoTarea);
		this.hibernateTemplate.delete(item);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void bajaLogica(Integer idTipoTarea) {
		
		TipoTarea item = this.hibernateTemplate.get(TipoTarea.class, idTipoTarea);
		item.setIsActivo(false);
		this.hibernateTemplate.update(item);
	}

	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(TipoTarea TipoTarea) {
		this.hibernateTemplate.update(TipoTarea);
	}


}
