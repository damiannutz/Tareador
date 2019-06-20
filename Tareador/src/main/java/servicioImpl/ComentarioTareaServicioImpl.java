package servicioImpl;

import java.util.ArrayList;

import dao.ComentarioTareaDao;
import dominio.ComentarioTarea;
import servicio.ComentarioTareaServicio;

public class ComentarioTareaServicioImpl implements ComentarioTareaServicio {

	private ComentarioTareaDao dataAccess = null;

	public void setDataAccess(ComentarioTareaDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<ComentarioTarea> obtenerAll() {
		return dataAccess.obtenerAll();
	}

	@Override
	public ComentarioTarea obtenerById(Integer idComentarioTarea) {
		return dataAccess.obtenerById(idComentarioTarea);
	}

	@Override
	public void insertar(ComentarioTarea ComentarioTarea) {
		 dataAccess.insertar(ComentarioTarea);
		
	}

	@Override
	public void eliminar(Integer idUser) {
		dataAccess.eliminar(idUser);
		
	}

	@Override
	public void actualizar(ComentarioTarea ComentarioTarea) {
		dataAccess.actualizar(ComentarioTarea);
		
	}

}
