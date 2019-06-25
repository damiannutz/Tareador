package servicio;

import java.util.ArrayList;
import java.util.List;

import dominio.Proyecto;

public interface ProyectoServicio {

	ArrayList<Proyecto> obtenerAll();
	
	ArrayList<Proyecto> obtenerAllActivos();

	Proyecto obtenerById(Integer idProyecto);

	List<Proyecto> obtenerByUsuario(Integer idUsuario);
	
	void insertar(Proyecto Proyecto);

    void eliminar(Integer idProyecto) ;
    
     void bajaLogica(Integer idProyecto) ;

	void actualizar(Proyecto Proyecto);
}
