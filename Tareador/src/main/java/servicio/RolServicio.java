package servicio;

import java.util.ArrayList;

import dominio.Rol;

public interface RolServicio {

	ArrayList<Rol> obtenerAll();

	ArrayList<Rol> obtenerAllActivos(); 
	
	Rol obtenerById(Integer idRol);

	void insertar(Rol Rol);

    void eliminar(Integer idRol) ;
    
    void bajaLogica(Integer idRol);

	void actualizar(Rol Rol);
}
