package servicioImpl;

import java.util.ArrayList;

import dao.UsuarioDao;
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
	public Usuario obtenerById(Integer idUsuario) {
		return dataAccess.obtenerById(idUsuario);
	}

	@Override
	public void insertar(Usuario usuario) {
		 dataAccess.insertar(usuario);
		
	}

	@Override
	public void eliminar(Integer idUser) {
		dataAccess.eliminar(idUser);
		
	}

	@Override
	public void actualizar(Usuario usuario) {
		dataAccess.actualizar(usuario);
		
	}

}
