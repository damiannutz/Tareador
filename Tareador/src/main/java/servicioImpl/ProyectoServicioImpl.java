package servicioImpl;

import java.util.ArrayList;

import dao.ProyectoDao;
import dominio.Proyecto;
import servicio.ProyectoServicio;

public class ProyectoServicioImpl implements ProyectoServicio {

	private ProyectoDao dataAccess = null;

	public void setDataAccess(ProyectoDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<Proyecto> obtenerAll() {
		return dataAccess.obtenerAll();
	}

	@Override
	public Proyecto obtenerById(Integer idProyecto) {
		return dataAccess.obtenerById(idProyecto);
	}

	@Override
	public void insertar(Proyecto Proyecto) {
		 dataAccess.insertar(Proyecto);
		
	}

	@Override
	public void eliminar(Integer idUser) {
		dataAccess.eliminar(idUser);
		
	}

	@Override
	public void actualizar(Proyecto Proyecto) {
		dataAccess.actualizar(Proyecto);
		
	}

}
