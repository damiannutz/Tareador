package servicio;

import java.util.ArrayList;

import dominio.TipoUsuario;

public interface TipoUsuarioServicio {

	ArrayList<TipoUsuario> obtenerAll();

	TipoUsuario obtenerById(String idTipoUsuario);

	void insertar(TipoUsuario TipoUsuario);

//    void eliminar(Integer idUser) ;

	void actualizar(TipoUsuario TipoUsuario);
}
