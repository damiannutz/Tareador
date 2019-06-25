package servicioImpl;

import java.util.*;

import dao.TareaDao;
import dominio.Rol;
import dominio.Tarea;
import servicio.TareaServicio;

public class TareaServicioImpl implements TareaServicio {

	private TareaDao dataAccess = null;

	public void setDataAccess(TareaDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public Set<Tarea> obtenerAll() {
		return dataAccess.obtenerAll();
	}

	@Override
	public Set<Tarea> obtenerAllActivos() {
		return dataAccess.obtenerAllActivos();
	}
	
	
	@Override
	public Tarea obtenerById(Integer idTarea) {
		return dataAccess.obtenerById(idTarea);
	}

	@Override
	public void insertar(Tarea Tarea) {
		 dataAccess.insertar(Tarea);
		
	}

	@Override
	public void eliminar(Integer idTarea) {
		dataAccess.eliminar(idTarea);
		
	}


	@Override
	public  void bajaLogica(Integer idTarea) {
		dataAccess.bajaLogica(idTarea);
	}

	@Override
	public void actualizar(Tarea Tarea) {
		dataAccess.actualizar(Tarea);
		
	}

}
