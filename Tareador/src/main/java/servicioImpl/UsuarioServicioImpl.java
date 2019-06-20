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
		return dataAccess.obtenerAll();
	}

	@Override
	public Usuario obtenerUnRegistro(Integer idUsuario) {
		return dataAccess.obtenerById(idUsuario);
	}

	@Override
	public void insertarUsuario(Usuario usuario) {
		 dataAccess.insertar(usuario);
		
	}

	@Override
	public void eliminarUsuario(Integer idUser) {
		dataAccess.eliminar(idUser);
		
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		dataAccess.actualizar(usuario);
		
	}

}
