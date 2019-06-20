package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Roles")
public class Rol {

	public final static String rol_nueva_tarea = "NEW_TAREA";
	public final static String rol_editar_tarea = "EDIT_TAREA";
	public final static String rol_eliminar_tarea = "DEL_TAREA";
	public final static String rol_comentar_tarea = "MSG_TAREA";
	
	public final static String rol_adm_tipos_tarea = "ADM_T_TAR";
	public final static String rol_adm_estados_tarea = "ADM_E_TAR";
	public final static String rol_adm_usuarios_x_proyectos = "ADM_US_PRO";
	public final static String rol_adm_usuarios = "ADM_USERS";
	public final static String rol_adm_proyectos = "ADM_PROY";
	public final static String rol_adm_departamentos = "ADM_DEPAR";
	
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="Id_Rol")
	    private Integer IdRol;
		
		@Column(name="Codigo")
		private String Codigo;
	
		@Column(name="Descripcion")
		private String Descripcion;
		
		
		@Column(name="Is_Activo")
		private Boolean IsActivo;
		
		
//	    @ManyToMany(cascade= {CascadeType.ALL})
//		@JoinTable(name="Roles_x_Usuarios",joinColumns={@JoinColumn(name="id_usuario")}, inverseJoinColumns={@JoinColumn(name="id_rol")})
//		private Set<Usuario> lsUsuario = new HashSet<Usuario>();


		
		
		public Rol(Integer id, String codigo, String descripcion, Boolean isActivo) {
			super();
			this.IdRol=id;
			Codigo = codigo;
			Descripcion = descripcion;
			IsActivo = isActivo;
		}
		
//		public Rol( String codigo, String descripcion, Boolean isActivo) {
//			super();
//			
//			Codigo = codigo;
//			Descripcion = descripcion;
//			IsActivo = isActivo;
//		}

		
		public Rol() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Integer getIdRol() {
			return IdRol;
		}



		public void setIdRol(Integer idRol) {
			IdRol = idRol;
		}


		public String getCodigo() {
			return Codigo;
		}


		public void setCodigo(String codigo) {
			Codigo = codigo;
		}


		public String getDescripcion() {
			return Descripcion;
		}


		public void setDescripcion(String descripcion) {
			Descripcion = descripcion;
		}


		public Boolean getIsActivo() {
			return IsActivo;
		}


		public void setIsActivo(Boolean isActivo) {
			IsActivo = isActivo;
		}
	    


}