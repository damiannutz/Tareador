package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dominio.Tarea;

public interface TareaDao {

		//Alta de Tarea
			public void insertar(Tarea Tarea);

			//Obtiene un Tarea por id
			public Tarea obtenerById(Integer idTarea);

			//Obtiene todos los Tareas
			public Set<Tarea> obtenerAll();
			
			public Set<Tarea> obtenerAllActivos() ;

			//Elimina un Tarea a aprtir del id
			public void eliminar(Integer idTarea);

			public void bajaLogica(Integer idTarea) ;
			
			//Actualiza los datos de un Tarea
			public void actualizar(Tarea Tarea);
	
}
