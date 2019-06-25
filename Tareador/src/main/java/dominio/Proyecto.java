package dominio;

import java.util.Set;

import javax.persistence.*;

import dominio.Departamento;


@Entity
@Table(name = "proyectos")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proyecto")
	private Integer idProyecto;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "is_activo")
	private Boolean isActivo;
	
	@ManyToOne(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="Id_Departamento", nullable = true  )
	private Departamento departamento;
	
	@ManyToMany(mappedBy="lsProyectos" ,fetch=FetchType.EAGER)
	private Set<Usuario> usuariosByProyecto;
	
	public Proyecto() {
		super();
	}
	
	public Proyecto(Integer id, String descripcion, Boolean isActivo, Departamento departamento) {
		super();
		this.idProyecto=id;
		this.descripcion = descripcion;
		this.isActivo = isActivo;
		this.departamento = departamento;
	}

//	public Proyecto( String descripcion, Boolean isActivo, Departamento departamento) {
//		super();
//		this.descripcion = descripcion;
//		this.isActivo = isActivo;
//		this.departamento = departamento;
//	}

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getIsActivo() {
		return isActivo;
	}

	public void setIsActivo(Boolean isActivo) {
		this.isActivo = isActivo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Set<Usuario> getUsuariosByProyecto() {
		return usuariosByProyecto;
	}

	public void setUsuariosByProyecto(Set<Usuario> usuarios) {
		this.usuariosByProyecto = usuarios;
	}

	
	
	
}
