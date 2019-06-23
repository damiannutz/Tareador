package servicio;

import java.util.*;

import dominio.Departamento;

public interface DepartamentoServicio {

	ArrayList<Departamento> obtenerAll();
	
	ArrayList<Departamento> obtenerAllActivos();

	Departamento obtenerById(Integer idDepartamento);

	void insertar(Departamento Departamento);

    void eliminar(Integer idDepartamento) ;
    
    void bajaLogica(Integer idDepartamento) ;

	void actualizar(Departamento Departamento);
}
