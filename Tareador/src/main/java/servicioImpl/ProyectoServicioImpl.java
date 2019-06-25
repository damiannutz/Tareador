package servicioImpl;

import java.util.ArrayList;
import java.util.List;

import dao.ProyectoDao;
import dominio.Prioridad;
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
	public ArrayList<Proyecto> obtenerAllActivos() {
		return (ArrayList)dataAccess.obtenerAllActivos();
	}
	@Override
	public ArrayList<Proyecto> obtenerByUsuario(Integer idUsuario){
		return (ArrayList)dataAccess.obtenerByUsuario(idUsuario);
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
	public void eliminar(Integer idProyecto) {
		dataAccess.eliminar(idProyecto);
		
	}

	@Override
	public  void bajaLogica(Integer idProyecto) {
		dataAccess.bajaLogica(idProyecto);
	}
	
	
	@Override
	public void actualizar(Proyecto Proyecto) {
		dataAccess.actualizar(Proyecto);
		
	}

}
