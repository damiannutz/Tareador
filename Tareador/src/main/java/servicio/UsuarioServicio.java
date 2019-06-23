package servicio;

import java.util.ArrayList;

import dominio.Usuario;

public interface UsuarioServicio {

	ArrayList<Usuario> obtenerAll();
	
	ArrayList<Usuario> obtenerAllActivos();

	Usuario obtenerById(Integer idUsuario);
	
	Usuario obtenerByUName(String UName);

	void insertar(Usuario usuario);

    void eliminar(Integer idUsuario) ;
    
    void bajaLogica(Integer idUsuario);

	void actualizar(Usuario usuario);
	
}
