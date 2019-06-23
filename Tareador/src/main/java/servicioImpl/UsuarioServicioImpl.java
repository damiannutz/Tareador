package servicioImpl;

import java.util.ArrayList;

import dao.UsuarioDao;
import dominio.TipoTarea;
import dominio.Usuario;
import servicio.UsuarioServicio;

public class UsuarioServicioImpl implements UsuarioServicio{

	private UsuarioDao dataAccess = null;

	public void setDataAccess(UsuarioDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<Usuario> obtenerAll() {
		return dataAccess.obtenerAll();
	}

	
	@Override
	public ArrayList<Usuario> obtenerAllActivos() {
		return (ArrayList)dataAccess.obtenerAllActivos();
	}
	
	@Override
	public Usuario obtenerById(Integer idUsuario) {
		return dataAccess.obtenerById(idUsuario);
	}
	
	@Override
	public Usuario obtenerByUName(String UName) {
		return dataAccess.obtenerByUName(UName);
	}

	@Override
	public void insertar(Usuario usuario) {
		 dataAccess.insertar(usuario);
		
	}

	@Override
	public void eliminar(Integer idUsuario) {
		dataAccess.eliminar(idUsuario);
		
	}
	@Override
	public  void bajaLogica(Integer idUsuario) {
		dataAccess.bajaLogica(idUsuario);
	}
	
	
	
	@Override
	public void actualizar(Usuario usuario) {
		dataAccess.actualizar(usuario);
		
	}

}
