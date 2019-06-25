package servicio;

import java.util.*;

import dominio.Usuario;

public interface UsuarioServicio {

	Set<Usuario> obtenerAll();
	
	Set<Usuario> obtenerAllActivos();

	Usuario obtenerById(Integer idUsuario);
	
	Usuario obtenerByUName(String UName);

	void insertar(Usuario usuario);

    void eliminar(Integer idUsuario) ;
    
    void bajaLogica(Integer idUsuario);

	void actualizar(Usuario usuario);
	
}
