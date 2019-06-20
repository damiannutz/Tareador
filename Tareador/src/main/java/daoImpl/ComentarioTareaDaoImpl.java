package daoImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.ComentarioTareaDao;
import dominio.ComentarioTarea;

public class ComentarioTareaDaoImpl implements ComentarioTareaDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(ComentarioTarea ComentarioTarea) {
		this.hibernateTemplate.save(ComentarioTarea);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ComentarioTarea obtenerById(Integer idComentarioTarea) {
		return this.hibernateTemplate.get(ComentarioTarea.class, idComentarioTarea);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<ComentarioTarea> obtenerAll() {
		return (ArrayList<ComentarioTarea>) this.hibernateTemplate.loadAll(ComentarioTarea.class);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminar(Integer idComentarioTarea) {
		ComentarioTarea item = new ComentarioTarea();
		item.setIdComentarioTarea(idComentarioTarea);
		this.hibernateTemplate.delete(item);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(ComentarioTarea ComentarioTarea) {
		this.hibernateTemplate.update(ComentarioTarea);
	}


}
