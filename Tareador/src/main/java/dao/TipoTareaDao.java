package dao;

import java.util.ArrayList;
import java.util.List;

import dominio.TipoTarea;

public interface TipoTareaDao {

	//Alta de TipoTarea
		public void insertar(TipoTarea TipoTarea);

		//Obtiene un TipoTarea por id
		public TipoTarea obtenerById(Integer idTipoTarea);

		//Obtiene todos los TipoTareas
		public ArrayList<TipoTarea> obtenerAll();

		public List<TipoTarea> obtenerAllActivos() ;
		
		//Elimina un TipoTarea a aprtir del id
		public void eliminar(Integer idTipoTarea);

		public void bajaLogica(Integer idTipoTarea) ;
		
		//Actualiza los datos de un TipoTarea
		public void actualizar(TipoTarea TipoTarea);
	
}
