package dao;

import java.util.ArrayList;
import java.util.List;

import dominio.Prioridad;

public interface PrioridadDao {
	//Alta de Prioridad
		public void insertar(Prioridad Prioridad);

		//Obtiene un Prioridad por id
		public Prioridad obtenerById(Integer idPrioridad);

		//Obtiene todos los Prioridads
		public ArrayList<Prioridad> obtenerAll();

		public List<Prioridad> obtenerAllActivos();
		
		//Elimina un Prioridad a aprtir del id
		public void eliminar(Integer idPrioridad);

		public void bajaLogica(Integer idPrioridad);
		
		//Actualiza los datos de un Prioridad
		public void actualizar(Prioridad Prioridad);
}
