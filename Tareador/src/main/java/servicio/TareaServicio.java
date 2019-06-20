package servicio;

import java.util.ArrayList;

import dominio.Tarea;

public interface TareaServicio {

	ArrayList<Tarea> obtenerAll();

	Tarea obtenerById(Integer idTarea);

	void insertar(Tarea Tarea);

    void eliminar(Integer idUser) ;

	void actualizar(Tarea Tarea);
}
