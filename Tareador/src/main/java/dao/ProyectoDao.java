package dao;

import java.util.ArrayList;

import dominio.Proyecto;

public interface ProyectoDao {

	//Alta de Proyecto
	public void insertar(Proyecto Proyecto);

	//Obtiene un Proyecto por id
	public Proyecto obtenerById(Integer idProyecto);

	//Obtiene todos los Proyectos
	public ArrayList<Proyecto> obtenerAll();

	//Elimina un Proyecto a aprtir del id
	public void eliminar(Integer idProyecto);

	//Actualiza los datos de un Proyecto
	public void actualizar(Proyecto Proyecto);
	
}
