package servicioImpl;

import java.util.ArrayList;

import dao.RolDao;
import dominio.Rol;
import servicio.RolServicio;

public class RolServicioImpl implements RolServicio {

	private RolDao dataAccess = null;

	public void setDataAccess(RolDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<Rol> obtenerAll() {
		return dataAccess.obtenerAll();
	}

	
	@Override
	public ArrayList<Rol> obtenerAllActivos() {
		return (ArrayList)dataAccess.obtenerAllActivos();
	}
	
	@Override
	public Rol obtenerById(Integer idRol) {
		return dataAccess.obtenerById(idRol);
	}

	@Override
	public void insertar(Rol Rol) {
		 dataAccess.insertar(Rol);
		
	}

	@Override
	public void eliminar(Integer idRol) {
		dataAccess.eliminar(idRol);
	}

	@Override
	public void actualizar(Rol Rol) {
		dataAccess.actualizar(Rol);
		
	}

	
	@Override
	public  void bajaLogica(Integer idRol) {
		dataAccess.bajaLogica(idRol);
	}


	
}
