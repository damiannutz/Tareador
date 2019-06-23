package dao;

import java.util.ArrayList;
import java.util.List;

import dominio.Departamento;

public interface DepartamentoDao {
	//Alta de Departamento
		public void insertar(Departamento Departamento);

		//Obtiene un Departamento por id
		public Departamento obtenerById(Integer idDepartamento);

		//Obtiene todos los Departamentos
		public ArrayList<Departamento> obtenerAll();
		
		//Obtiene todos los Departamentos activos
		public List<Departamento> obtenerAllActivos();
		
		//Elimina un Departamento a aprtir del id
		public void eliminar(Integer idDepartamento);
		
		//Baja Logica un Departamento a aprtir del id
		public void bajaLogica(Integer idDepartamento);
		
		//Actualiza los datos de un Departamento
		public void actualizar(Departamento Departamento);
}
