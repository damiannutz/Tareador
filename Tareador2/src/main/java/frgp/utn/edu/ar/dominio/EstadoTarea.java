package frgp.utn.edu.ar.dominio;

import javax.persistence.*;



import frgp.utn.edu.ar.dominio.Departamento;
@Entity
@Table(name = "estados_tareas")
public class EstadoTarea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Estado_Tarea")
	private Integer idEstadoTarea;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	@Column(name = "Is_Activo")
	private Boolean isActivo;
	
	@Column(name = "Is_Primero")
	private Boolean isPrimero;
	
	@Column(name = "Is_Final")
	private Boolean isFinal;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_departamento", nullable = true  )
	private Departamento departamento; 
	
	public EstadoTarea(Integer id, String descripcion, Boolean isActivo, Boolean isPrimero, Boolean isFinal,
			Departamento departamento) {
		super();
		this.idEstadoTarea=id;
		this.descripcion = descripcion;
		this.isActivo = isActivo;
		this.isPrimero = isPrimero;
		this.isFinal = isFinal;
		this.departamento = departamento;
	}
	
	public EstadoTarea( String descripcion, Boolean isActivo, Boolean isPrimero, Boolean isFinal,
			Departamento departamento) {
		super();
		this.descripcion = descripcion;
		this.isActivo = isActivo;
		this.isPrimero = isPrimero;
		this.isFinal = isFinal;
		this.departamento = departamento;
	}

	public EstadoTarea() {
		super();// TODO Auto-generated constructor stub
	}

	public Integer getIdEstadoTarea() {
		return idEstadoTarea;
	}

	public void setIdEstadoTarea(Integer idEstadoTarea) {
		this.idEstadoTarea = idEstadoTarea;
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

	public Boolean getIsPrimero() {
		return isPrimero;
	}

	public void setIsPrimero(Boolean isPrimero) {
		this.isPrimero = isPrimero;
	}

	public Boolean getIsFinal() {
		return isFinal;
	}

	public void setIsFinal(Boolean isFinal) {
		this.isFinal = isFinal;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	
}
