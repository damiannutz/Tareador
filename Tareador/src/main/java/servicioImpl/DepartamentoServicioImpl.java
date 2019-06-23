package servicioImpl;

import java.util.*;

import dao.DepartamentoDao;
import dominio.Departamento;
import servicio.DepartamentoServicio;

public class DepartamentoServicioImpl implements DepartamentoServicio {

	private DepartamentoDao dataAccess = null;

	public void setDataAccess(DepartamentoDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<Departamento> obtenerAll() {
		return dataAccess.obtenerAll();
	}

	@Override
	public ArrayList<Departamento> obtenerAllActivos() {
		return (ArrayList)dataAccess.obtenerAllActivos();
	}
	
	@Override
	public Departamento obtenerById(Integer idDepartamento) {
		return dataAccess.obtenerById(idDepartamento);
	}

	@Override
	public void insertar(Departamento Departamento) {
		 dataAccess.insertar(Departamento);
		
	}

	@Override
	public void eliminar(Integer idDepartamento) {
		dataAccess.eliminar(idDepartamento);
		
	}
	    
	@Override
	public  void bajaLogica(Integer idDepartamento) {
		dataAccess.bajaLogica(idDepartamento);
	}
	
	@Override
	public void actualizar(Departamento Departamento) {
		dataAccess.actualizar(Departamento);
		
	}

}
