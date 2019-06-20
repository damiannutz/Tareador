package servicio;

import java.util.ArrayList;

import dominio.EstadoTarea;

public interface EstadoTareaServicio {

	ArrayList<EstadoTarea> obtenerAll();

	EstadoTarea obtenerById(Integer idEstadoTarea);

	void insertar(EstadoTarea EstadoTarea);

    void eliminar(Integer idUser) ;

	void actualizar(EstadoTarea EstadoTarea);
}
