package servicioImpl;

import java.util.ArrayList;

import dao.TipoUsuarioDao;
import dominio.TipoUsuario;
import servicio.TipoUsuarioServicio;

public class TipoUsuarioServicioImpl implements TipoUsuarioServicio {


	private TipoUsuarioDao dataAccess = null;

	public void setDataAccess(TipoUsuarioDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<TipoUsuario> obtenerAll() {
		return dataAccess.obtenerAll();
	}

	@Override
	public TipoUsuario obtenerById(String idTipoUsuario) {
		return dataAccess.obtenerById(idTipoUsuario);
	}

	@Override
	public void insertar(TipoUsuario TipoUsuario) {
		 dataAccess.insertar(TipoUsuario);
		
	}

//	@Override
//	public void eliminar(Integer idUser) {
//		dataAccess.eliminar(idUser);
//		
//	}

	@Override
	public void actualizar(TipoUsuario TipoUsuario) {
		dataAccess.actualizar(TipoUsuario);
		
	}

	
}
