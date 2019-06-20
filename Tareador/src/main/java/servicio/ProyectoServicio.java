package servicio;

import java.util.ArrayList;

import dominio.Proyecto;

public interface ProyectoServicio {

	ArrayList<Proyecto> obtenerAll();

	Proyecto obtenerById(Integer idProyecto);

	void insertar(Proyecto Proyecto);

    void eliminar(Integer idUser) ;

	void actualizar(Proyecto Proyecto);
}
