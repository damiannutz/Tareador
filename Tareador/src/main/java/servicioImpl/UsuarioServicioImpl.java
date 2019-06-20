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
	public ArrayList<Usuario> obtenerUsuarios() {
		return dataAccess.obtenerUsuarios();
	}

	@Override
	public Usuario obtenerUnRegistro(Integer idUsuario) {
		return dataAccess.obtenerUsuarioPorId(idUsuario);
	}

	@Override
	public void insertarUsuario(Usuario usuario) {
		 dataAccess.insertarUsuario(usuario);
		
	}

	@Override
	public void eliminarUsuario(Integer idUser) {
		dataAccess.eliminarUsuario(idUser);
		
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		dataAccess.actualizarUsuario(usuario);
		
	}

}
