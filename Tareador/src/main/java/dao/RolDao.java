package dao;

import java.util.ArrayList;

import dominio.Rol;

public interface RolDao {

	//Alta de Rol
	public void insertar(Rol Rol);

	//Obtiene un Rol por id
	public Rol obtenerById(Integer idRol);

	//Obtiene todos los Rols
	public ArrayList<Rol> obtenerAll();

	//Elimina un Rol a aprtir del id
	public void eliminar(Integer idRol);

	//Actualiza los datos de un Rol
	public void actualizar(Rol Rol);
	
}
