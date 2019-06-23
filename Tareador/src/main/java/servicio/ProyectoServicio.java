package servicio;

import java.util.ArrayList;

import dominio.Proyecto;

public interface ProyectoServicio {

	ArrayList<Proyecto> obtenerAll();
	
	ArrayList<Proyecto> obtenerAllActivos();

	Proyecto obtenerById(Integer idProyecto);

	void insertar(Proyecto Proyecto);

    void eliminar(Integer idProyecto) ;
    
     void bajaLogica(Integer idProyecto) ;

	void actualizar(Proyecto Proyecto);
}
