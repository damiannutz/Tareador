package dao;

import java.util.ArrayList;
import java.util.List;

import dominio.EstadoTarea;

public interface EstadoTareaDao {
	//Alta de EstadoTarea
		public void insertar(EstadoTarea EstadoTarea);

		//Obtiene un EstadoTarea por id
		public EstadoTarea obtenerById(Integer idEstadoTarea);

		//Obtiene todos los EstadoTareas
		public ArrayList<EstadoTarea> obtenerAll();
		
		//Obtiene todos los Departamentos activos
		public List<EstadoTarea> obtenerAllActivos();

		//Elimina un EstadoTarea a aprtir del id
		public void eliminar(Integer idEstadoTarea);

		//Baja Logica un Estado de Tarea a aprtir del id
		public void bajaLogica(Integer idEstadoTarea);
		
		//Actualiza los datos de un EstadoTarea
		public void actualizar(EstadoTarea EstadoTarea);
}
