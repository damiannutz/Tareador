package dao;

import java.util.*;

import dominio.Usuario;


public interface UsuarioDao {

	//Alta de usuario
	public void insertar(Usuario usuario);

	//Obtiene un usuario por id
	public Usuario obtenerById(Integer idUsuario);

	//Obtiene todos los usuarios
	public ArrayList<Usuario> obtenerAll();

	public List<Usuario> obtenerAllActivos();

	//Elimina un usuario a aprtir del id
	public void eliminar(Integer idUsuario);

	public void bajaLogica(Integer idUsuario);

	//Actualiza los datos de un usuario
	public void actualizar(Usuario usuario);


}
