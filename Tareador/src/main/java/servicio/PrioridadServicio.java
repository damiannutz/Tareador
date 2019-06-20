package servicio;

import java.util.ArrayList;

import dominio.Prioridad;

public interface PrioridadServicio {

	ArrayList<Prioridad> obtenerAll();

	Prioridad obtenerById(Integer idPrioridad);

	void insertar(Prioridad Prioridad);

    void eliminar(Integer idUser) ;

	void actualizar(Prioridad Prioridad);
}
