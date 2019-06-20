package servicioImpl;

import java.util.ArrayList;

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
	public Departamento obtenerById(Integer idDepartamento) {
		return dataAccess.obtenerById(idDepartamento);
	}

	@Override
	public void insertar(Departamento Departamento) {
		 dataAccess.insertar(Departamento);
		
	}

	@Override
	public void eliminar(Integer idUser) {
		dataAccess.eliminar(idUser);
		
	}

	@Override
	public void actualizar(Departamento Departamento) {
		dataAccess.actualizar(Departamento);
		
	}

}
