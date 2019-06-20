package dao;

import java.util.ArrayList;

import dominio.ComentarioTarea;

public interface ComentarioTareaDao {
	//Alta de ComentarioTarea
		public void insertar(ComentarioTarea ComentarioTarea);

		//Obtiene un ComentarioTarea por id
		public ComentarioTarea obtenerById(Integer idComentarioTarea);

		//Obtiene todos los ComentarioTareas
		public ArrayList<ComentarioTarea> obtenerAll();

		//Elimina un ComentarioTarea a aprtir del id
		public void eliminar(Integer idComentarioTarea);

		//Actualiza los datos de un ComentarioTarea
		public void actualizar(ComentarioTarea ComentarioTarea);
}
