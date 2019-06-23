package servicio;

import java.util.ArrayList;

import dominio.Tarea;

public interface TareaServicio {

	ArrayList<Tarea> obtenerAll();

	ArrayList<Tarea> obtenerAllActivos();
	
	Tarea obtenerById(Integer idTarea);

	void insertar(Tarea Tarea);

    void eliminar(Integer idUser) ;

    void bajaLogica(Integer idTarea);
    
	void actualizar(Tarea Tarea);
}
