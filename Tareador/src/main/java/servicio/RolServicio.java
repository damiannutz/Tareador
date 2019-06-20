package servicio;

import java.util.ArrayList;

import dominio.Rol;

public interface RolServicio {

	ArrayList<Rol> obtenerAll();

	Rol obtenerById(Integer idRol);

	void insertar(Rol Rol);

    void eliminar(Integer idUser) ;

	void actualizar(Rol Rol);
}
