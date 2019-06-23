package servicio;

import java.util.ArrayList;

import dominio.EstadoTarea;

public interface EstadoTareaServicio {

	ArrayList<EstadoTarea> obtenerAll();

	
	ArrayList<EstadoTarea> obtenerAllActivos();
	
	
	EstadoTarea obtenerById(Integer idEstadoTarea);

	void insertar(EstadoTarea EstadoTarea);

    void eliminar(Integer idEstadoTarea) ;

   void bajaLogica(Integer idEstadoTarea) ;
    
	void actualizar(EstadoTarea EstadoTarea);
}
