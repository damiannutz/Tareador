package daoImpl;

import java.util.*;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.UsuarioDao;
import dominio.Departamento;
import dominio.TipoUsuario;
import dominio.Usuario;
import servicio.DepartamentoServicio;
import servicio.TipoUsuarioServicio;

public class UsuarioDaoImpl implements UsuarioDao {

	private HibernateTemplate hibernateTemplate = null;
	
	@Autowired
	public  DepartamentoServicio departamentoService;
	
	@Autowired
	public  TipoUsuarioServicio tipoUsuarioService;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Usuario usuario) {
		this.hibernateTemplate.save(usuario);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Usuario obtenerById(Integer idUsuario) {
		return this.hibernateTemplate.get(Usuario.class, idUsuario);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Usuario obtenerByUName(String UName) {
		return this.hibernateTemplate.get(Usuario.class, UName);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Usuario> obtenerAll() {
		return (ArrayList<Usuario>) this.hibernateTemplate.loadAll(Usuario.class);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Usuario> obtenerAllActivos() {
		return (List<Usuario>)  this.hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Usuario.class).add(Restrictions.eq("IsActivo", true)));
	}
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminar(Integer idUsuario) {
		Usuario item = new Usuario();
		item.setIdUsuario(idUsuario);
		this.hibernateTemplate.delete(item);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void bajaLogica(Integer idUsuario) {
		
		Usuario item = this.hibernateTemplate.get(Usuario.class, idUsuario);
		item.setIsActivo(false);
		this.hibernateTemplate.update(item);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Usuario usuario) {
		
//	 Departamento dep=	departamentoService.obtenerById(usuario.getDepartamento().getIdDepartamento());
//		usuario.setDepartamento(dep);
//	
//	TipoUsuario tipo= tipoUsuarioService.obtenerById(usuario.getTipoUsuario().getIdTipoUsuario());
//	
//	usuario.setTipoUsuario(tipo);
//		
		this.hibernateTemplate.update(usuario);
	}


}
