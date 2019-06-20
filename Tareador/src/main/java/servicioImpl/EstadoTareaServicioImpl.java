package servicioImpl;

import java.util.ArrayList;

import dao.EstadoTareaDao;
import dominio.EstadoTarea;
import servicio.EstadoTareaServicio;

public class EstadoTareaServicioImpl implements EstadoTareaServicio {

	private EstadoTareaDao dataAccess = null;

	public void setDataAccess(EstadoTareaDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<EstadoTarea> obtenerAll() {
		return dataAccess.obtenerAll();
	}

	@Override
	public EstadoTarea obtenerById(Integer idEstadoTarea) {
		return dataAccess.obtenerById(idEstadoTarea);
	}

	@Override
	public void insertar(EstadoTarea EstadoTarea) {
		 dataAccess.insertar(EstadoTarea);
		
	}

	@Override
	public void eliminar(Integer idUser) {
		dataAccess.eliminar(idUser);
		
	}

	@Override
	public void actualizar(EstadoTarea EstadoTarea) {
		dataAccess.actualizar(EstadoTarea);
		
	}

}
