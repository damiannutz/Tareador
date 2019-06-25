package dao;

import java.util.ArrayList;
import java.util.List;

import dominio.Proyecto;

public interface ProyectoDao {

	//Alta de Proyecto
	public void insertar(Proyecto Proyecto);

	//Obtiene un Proyecto por id
	public Proyecto obtenerById(Integer idProyecto);

	//Obtiene todos los Proyectos
	public ArrayList<Proyecto> obtenerAll();

	public List<Proyecto> obtenerAllActivos();
	
	//Elimina un Proyecto a aprtir del id
	public void eliminar(Integer idProyecto);

	public void bajaLogica(Integer idProyecto); 
	
	public List<Proyecto> obtenerByUsuario(Integer idUsuario);
	
	//Actualiza los datos de un Proyecto
	public void actualizar(Proyecto Proyecto);
	
}
