package servicioImpl;

import java.util.ArrayList;

import dao.TipoTareaDao;
import dominio.Tarea;
import dominio.TipoTarea;
import servicio.TipoTareaServicio;

public class TipoTareaServicioImpl implements TipoTareaServicio {

	private TipoTareaDao dataAccess = null;

	public void setDataAccess(TipoTareaDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<TipoTarea> obtenerAll() {
		return dataAccess.obtenerAll();
	}

	@Override
	public ArrayList<TipoTarea> obtenerAllActivos() {
		return (ArrayList)dataAccess.obtenerAllActivos();
	}
	
	@Override
	public TipoTarea obtenerById(Integer idTipoTarea) {
		return dataAccess.obtenerById(idTipoTarea);
	}

	@Override
	public void insertar(TipoTarea TipoTarea) {
		 dataAccess.insertar(TipoTarea);
		
	}

	@Override
	public void eliminar(Integer idTipoTarea) {
		dataAccess.eliminar(idTipoTarea);
		
	}

	@Override
	public  void bajaLogica(Integer idTipoTarea) {
		dataAccess.bajaLogica(idTipoTarea);
	}
	
	@Override
	public void actualizar(TipoTarea TipoTarea) {
		dataAccess.actualizar(TipoTarea);
		
	}

}
