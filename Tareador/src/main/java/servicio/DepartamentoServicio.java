package servicio;

import java.util.ArrayList;

import dominio.Departamento;

public interface DepartamentoServicio {

	ArrayList<Departamento> obtenerAll();

	Departamento obtenerById(Integer idDepartamento);

	void insertar(Departamento Departamento);

    void eliminar(Integer idUser) ;

	void actualizar(Departamento Departamento);
}
