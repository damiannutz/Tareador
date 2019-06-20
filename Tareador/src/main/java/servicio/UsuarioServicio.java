package servicio;

import java.util.ArrayList;

import dominio.Usuario;

public interface UsuarioServicio {

	ArrayList<Usuario> obtenerUsuarios();

	Usuario obtenerUnRegistro(Integer idUsuario);

	void insertarUsuario(Usuario usuario);

    void eliminarUsuario(Integer idUser) ;

	void actualizarUsuario(Usuario usuario);
	
}
