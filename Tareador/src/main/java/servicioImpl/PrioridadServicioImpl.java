package servicioImpl;

import java.util.ArrayList;

import dao.PrioridadDao;
import dominio.Prioridad;
import servicio.PrioridadServicio;

public class PrioridadServicioImpl implements PrioridadServicio {

	private PrioridadDao dataAccess = null;

	public void setDataAccess(PrioridadDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<Prioridad> obtenerAll() {
		return dataAccess.obtenerAll();
	}

	@Override
	public Prioridad obtenerById(Integer idPrioridad) {
		return dataAccess.obtenerById(idPrioridad);
	}

	@Override
	public void insertar(Prioridad Prioridad) {
		 dataAccess.insertar(Prioridad);
		
	}

	@Override
	public void eliminar(Integer idUser) {
		dataAccess.eliminar(idUser);
		
	}

	@Override
	public void actualizar(Prioridad Prioridad) {
		dataAccess.actualizar(Prioridad);
		
	}

}
