package dominio;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "Usuarios")

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
	  
	@ManyToOne(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="Id_Departamento", nullable = true  )
	  private Departamento Departamento;
	
	@ManyToOne(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="id_tipo_usuario")
	  private TipoUsuario TipoUsuario;


	  @ManyToMany(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
		@JoinTable(name="usuarios_x_proyectos",joinColumns={@JoinColumn(name="id_usuario")}, inverseJoinColumns={@JoinColumn(name="id_proyecto")})
	  private List<Proyecto> lsProyectos = new ArrayList<Proyecto>();
	  

		
	    @ManyToMany(cascade= {CascadeType.ALL})
		@JoinTable(name="Roles_x_Usuarios",joinColumns={@JoinColumn(name="id_usuario")}, inverseJoinColumns={@JoinColumn(name="id_rol")})
  		private List<Rol> lsRoles = new ArrayList<Rol>();
	  
	 
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
		
		
	  	public List<Proyecto> getLsProyectos() {
			return lsProyectos;
		}
		public void setLsProyectos(List<Proyecto> lsProyectos) {
			this.lsProyectos = lsProyectos;
		}
		
    	public List<Rol> getLsRoles() {
			return lsRoles;
		}
		public void setLsRoles(List<Rol> lsRoles) {
			this.lsRoles = lsRoles;
		}
	public Usuario() {
		super();
	}
	public Usuario(Integer idUsuario, String nombre, String apellido, String email, String nombreUsuario,
			String contrasenia, Boolean isActivo, dominio.Departamento departamento,
			dominio.TipoUsuario tipoUsuario, List<Proyecto> lsProyectos, List<Rol> lsRoles) {
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
