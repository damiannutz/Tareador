package servicio;

import java.util.ArrayList;

import dominio.TipoTarea;

public interface TipoTareaServicio {


	ArrayList<TipoTarea> obtenerAll();

	ArrayList<TipoTarea> obtenerAllActivos() ;
	
	TipoTarea obtenerById(Integer idTipoTarea);

	void insertar(TipoTarea TipoTarea);

    void eliminar(Integer idTipoTarea) ;

    void bajaLogica(Integer idTipoTarea);
    
	void actualizar(TipoTarea TipoTarea);
}
