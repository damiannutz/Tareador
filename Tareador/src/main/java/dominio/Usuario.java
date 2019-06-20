package dominio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dominio.Departamento;
import dominio.Proyecto;
import dominio.Rol;
import dominio.TipoUsuario;


@Entity
@Table(name = "Usuario")

public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Usuario", unique = true, nullable = false)
	private Integer IdUsuario;
	

	@Column(name = "nombre", nullable = false)
	private String Nombre;
	

	@Column(name = "apellido", nullable = false)
	 private String Apellido;
	

	@Column(name = "email", nullable = true)
	 private String Email;
	

	@Column(name = "NombreUsuario", nullable = false)
	 private String NombreUsuario;
	

	@Column(name = "contrasenia", nullable = true)
	 private String Contrasenia;
	

	@Column(name = "is_activo", nullable = true)
	  private Boolean IsActivo;
	  
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="Id_Departamento", nullable = true  )
	  private Departamento Departamento;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_tipo_usuario")
	  private TipoUsuario TipoUsuario;


	  @ManyToMany(cascade= {CascadeType.ALL})
		@JoinTable(name="usuarios_x_proyectos",joinColumns={@JoinColumn(name="id_usuario")}, inverseJoinColumns={@JoinColumn(name="id_proyecto")})
	  private Set<Proyecto> lsProyectos = new HashSet<Proyecto>();
	  

		
	    @ManyToMany(cascade= {CascadeType.ALL})
		@JoinTable(name="Roles_x_Usuarios",joinColumns={@JoinColumn(name="id_usuario")}, inverseJoinColumns={@JoinColumn(name="id_rol")})
  		private Set<Rol> lsRoles = new HashSet<Rol>();
	  
	 
	  public int getIdUsuario() {
			  return IdUsuario;
			 }
	  public void setIdUsuario(int id) {
		  this.IdUsuario = id;
	  }
	 
	 public String getNombre() {
		  return Nombre;
		 }
		 public void setNombre(String nombre) {
		  this.Nombre = nombre;
		 }
		 
		 public String getApellido() {
			  return Apellido;
			
		 }
		 public void setApellido(String apellido) {
		  this.Apellido = apellido;
		 }
		 public String getEmail() {
			  return Email;
		 }
		 public void setEmail(String email) {
		  this.Email = email;
		 }
		 public String getNombreUsuario() {
			  return NombreUsuario;
		 }
		 public void setNombreUsuario(String nombreUsuario) {
		  this.NombreUsuario = nombreUsuario;
		 }
		 public String getContrasenia() {
				  return Contrasenia;
		 }
		 
		 public void setContrasenia(String contrasenia) {
		  this.Contrasenia = contrasenia;
		 }

		public Boolean getIsActivo() {
			return IsActivo;
		}
		public void setIsActivo(Boolean isActivo) {
			IsActivo = isActivo;
		}

		
		public Departamento getDepartamento() {
				return Departamento;
			}

			public void setDepartamento(Departamento departamento) {
				Departamento = departamento;
			}

			
			public TipoUsuario getTipoUsuario() {
				return TipoUsuario;
			}
		public void setTipoUsuario(TipoUsuario tipoUsuario) {
				TipoUsuario = tipoUsuario;
			}
		
		
	  	public Set<Proyecto> getLsProyectos() {
			return lsProyectos;
		}
		public void setLsProyectos(Set<Proyecto> lsProyectos) {
			this.lsProyectos = lsProyectos;
		}
		
    	public Set<Rol> getLsRoles() {
			return lsRoles;
		}
		public void setLsRoles(Set<Rol> lsRoles) {
			this.lsRoles = lsRoles;
		}
	public Usuario() {
		super();
	}
	public Usuario(Integer idUsuario, String nombre, String apellido, String email, String nombreUsuario,
			String contrasenia, Boolean isActivo, dominio.Departamento departamento,
			dominio.TipoUsuario tipoUsuario, Set<Proyecto> lsProyectos, Set<Rol> lsRoles) {
		super();
		IdUsuario = idUsuario;
		Nombre = nombre;
		Apellido = apellido;
		Email = email;
		NombreUsuario = nombreUsuario;
		Contrasenia = contrasenia;
		IsActivo = isActivo;
		Departamento = departamento;
		TipoUsuario = tipoUsuario;
		this.lsProyectos = lsProyectos;
		this.lsRoles = lsRoles;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nombreU;
	private String passU;
	
	public Usuario()
	{
		
	}

	public String getNombreU() {
		return nombreU;
	}

	public void setNombreU(String nombreU) {
		this.nombreU = nombreU;
	}

	public String getPassU() {
		return passU;
	}

	public void setPassU(String passU) {
		this.passU = passU;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario(int id, String nombreU, String passU) {
		super();
		this.id = id;
		this.nombreU = nombreU;
		this.passU = passU;
	}
*/
	


	
	
}
