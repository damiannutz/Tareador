package servicioImpl;

import java.util.ArrayList;

import dao.EstadoTareaDao;
import dominio.Departamento;
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
	public ArrayList<EstadoTarea> obtenerAllActivos() {
		return (ArrayList)dataAccess.obtenerAllActivos();
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
	public void eliminar(Integer idEstadoTarea) {
		dataAccess.eliminar(idEstadoTarea);
		
	}

	@Override
	public  void bajaLogica(Integer idEstadoTarea) {
		dataAccess.bajaLogica(idEstadoTarea);
	}
	
	@Override
	public void actualizar(EstadoTarea EstadoTarea) {
		dataAccess.actualizar(EstadoTarea);
		
	}

}
