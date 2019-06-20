package dao;

import java.util.ArrayList;

import dominio.EstadoTarea;

public interface EstadoTareaDao {
	//Alta de EstadoTarea
		public void insertar(EstadoTarea EstadoTarea);

		//Obtiene un EstadoTarea por id
		public EstadoTarea obtenerById(Integer idEstadoTarea);

		//Obtiene todos los EstadoTareas
		public ArrayList<EstadoTarea> obtenerAll();

		//Elimina un EstadoTarea a aprtir del id
		public void eliminar(Integer idEstadoTarea);

		//Actualiza los datos de un EstadoTarea
		public void actualizar(EstadoTarea EstadoTarea);
}
