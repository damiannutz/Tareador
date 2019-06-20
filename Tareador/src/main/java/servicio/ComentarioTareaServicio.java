package servicio;

import java.util.ArrayList;

import dominio.ComentarioTarea;

public interface ComentarioTareaServicio {

	ArrayList<ComentarioTarea> obtenerAll();

	ComentarioTarea obtenerById(Integer idComentarioTarea);

	void insertar(ComentarioTarea ComentarioTarea);

    void eliminar(Integer idUser) ;

	void actualizar(ComentarioTarea ComentarioTarea);
}
