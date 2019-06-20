package daoImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.DepartamentoDao;
import dominio.Departamento;

public class DepartamentoDaoImpl implements DepartamentoDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Departamento Departamento) {
		this.hibernateTemplate.save(Departamento);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Departamento obtenerById(Integer idDepartamento) {
		return this.hibernateTemplate.get(Departamento.class, idDepartamento);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Departamento> obtenerAll() {
		return (ArrayList<Departamento>) this.hibernateTemplate.loadAll(Departamento.class);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminar(Integer idDepartamento) {
		Departamento item = new Departamento();
		item.setIdDepartamento(idDepartamento);
		this.hibernateTemplate.delete(item);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Departamento Departamento) {
		this.hibernateTemplate.update(Departamento);
	}


}
