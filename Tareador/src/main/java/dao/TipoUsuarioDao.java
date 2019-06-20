package dao;

import java.util.ArrayList;

import dominio.TipoUsuario;

public interface TipoUsuarioDao {

		//Alta de TipoUsuario
		public void insertar(TipoUsuario TipoUsuario);

		//Obtiene un TipoUsuario por id
		public TipoUsuario obtenerById(String idTipoUsuario);

		//Obtiene todas TipoUsuario
		public ArrayList<TipoUsuario> obtenerAll();

		//Actualiza los datos de TipoUsuario
		public void actualizar(TipoUsuario TipoUsuario);
		
}
