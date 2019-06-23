package servicio;

import java.util.ArrayList;

import dominio.Prioridad;

public interface PrioridadServicio {

	ArrayList<Prioridad> obtenerAll();

	ArrayList<Prioridad> obtenerAllActivos();
	
	Prioridad obtenerById(Integer idPrioridad);

	void insertar(Prioridad Prioridad);

    void eliminar(Integer idPrioridad) ;

	void bajaLogica(Integer idPrioridad);
	
	void actualizar(Prioridad Prioridad);
}
