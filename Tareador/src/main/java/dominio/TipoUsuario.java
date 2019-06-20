package frgp.utn.edu.ar.dominio;
import javax.persistence.*;


@Entity
@Table(name = "tipos_usuarios")
public class TipoUsuario {

	
	public final static String tipo_super = "SUPER";
	public final static String tipo_admin = "ADMIN";
	public final static String tipo_user = "USER";
	
	@Id
	@Column(name="id_tipo_usuario")
	private String idTipoUsuario;
	
	@Column(name="descripcion" )
	private String descripcion;
	
	public TipoUsuario() {
		super();
	}
	public TipoUsuario(String idTipoUsuario, String descripcion) {
		super();
		this.idTipoUsuario = idTipoUsuario;
		this.descripcion = descripcion;
	}
	
	
	public String getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(String idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}

