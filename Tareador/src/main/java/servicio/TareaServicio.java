package servicio;

import java.util.*;

import dominio.Tarea;

public interface TareaServicio {

	Set<Tarea> obtenerAll();

	Set<Tarea> obtenerAllActivos();
	
	Tarea obtenerById(Integer idTarea);

	void insertar(Tarea Tarea);

    void eliminar(Integer idUser) ;

    void bajaLogica(Integer idTarea);
    
	void actualizar(Tarea Tarea);
}
