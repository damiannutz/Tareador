package servicio;

import java.util.ArrayList;

import dominio.Usuario;

public interface UsuarioServicio {

	ArrayList<Usuario> obtenerAll();

	Usuario obtenerById(Integer idUsuario);

	void insertar(Usuario usuario);

    void eliminar(Integer idUser) ;

	void actualizar(Usuario usuario);
	
}
