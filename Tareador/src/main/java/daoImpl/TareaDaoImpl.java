package daoImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.TareaDao;
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
	public Tarea obtenerById(Integer idTarea) {
		return this.hibernateTemplate.get(Tarea.class, idTarea);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Tarea> obtenerAll() {
		return (ArrayList<Tarea>) this.hibernateTemplate.loadAll(Tarea.class);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminar(Integer idTarea) {
		Tarea item = new Tarea();
		item.setIdTarea(idTarea);
		this.hibernateTemplate.delete(item);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Tarea Tarea) {
		this.hibernateTemplate.update(Tarea);
	}


	
}
