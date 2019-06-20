package daoImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.EstadoTareaDao;
import dominio.EstadoTarea;

public class EstadoTareaDaoImpl implements EstadoTareaDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(EstadoTarea EstadoTarea) {
		this.hibernateTemplate.save(EstadoTarea);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public EstadoTarea obtenerById(Integer idEstadoTarea) {
		return this.hibernateTemplate.get(EstadoTarea.class, idEstadoTarea);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<EstadoTarea> obtenerAll() {
		return (ArrayList<EstadoTarea>) this.hibernateTemplate.loadAll(EstadoTarea.class);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminar(Integer idEstadoTarea) {
		EstadoTarea item = new EstadoTarea();
		item.setIdEstadoTarea(idEstadoTarea);
		this.hibernateTemplate.delete(item);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(EstadoTarea EstadoTarea) {
		this.hibernateTemplate.update(EstadoTarea);
	}


}
