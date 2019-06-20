package servicio;

import java.util.ArrayList;

import dominio.TipoTarea;

public interface TipoTareaServicio {


	ArrayList<TipoTarea> obtenerAll();

	TipoTarea obtenerById(Integer idTipoTarea);

	void insertar(TipoTarea TipoTarea);

    void eliminar(Integer idUser) ;

	void actualizar(TipoTarea TipoTarea);
}
