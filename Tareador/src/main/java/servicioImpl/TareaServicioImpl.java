package servicioImpl;

import java.util.ArrayList;

import dao.TareaDao;
import dominio.Tarea;
import servicio.TareaServicio;

public class TareaServicioImpl implements TareaServicio {

	private TareaDao dataAccess = null;

	public void setDataAccess(TareaDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<Tarea> obtenerAll() {
		return dataAccess.obtenerAll();
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
	public void eliminar(Integer idUser) {
		dataAccess.eliminar(idUser);
		
	}

	@Override
	public void actualizar(Tarea Tarea) {
		dataAccess.actualizar(Tarea);
		
	}

}
