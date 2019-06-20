package dominio;

import javax.persistence.*;

import dominio.Departamento;

@Entity

@Table(name = "Tipo_Tareas")
public class TipoTarea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Tipo_Tareas")
	private Integer IdTipoTareas;
	
	@Column(name="Descripcion")
	private String Descripcion;
	
	@Column(name="Is_Activo")
	private boolean IsActivo;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="Id_Departamento" , nullable = true  )
    private Departamento departamentos;

	public Integer getIdTipoTareas() {
		return IdTipoTareas;
	}

	public void setIdTipoTareas(Integer idTipoTareas) {
		IdTipoTareas = idTipoTareas;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public boolean isIsActivo() {
		return IsActivo;
	}

	public void setIsActivo(boolean isActivo) {
		IsActivo = isActivo;
	}

	public Departamento getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Departamento departamentos) {
		this.departamentos = departamentos;
	}

	public TipoTarea( String descripcion, boolean isActivo, Departamento departamentos) {
		super();
		Descripcion = descripcion;
		IsActivo = isActivo;
		this.departamentos = departamentos;
	}
	
	public TipoTarea(Integer id, String descripcion, boolean isActivo, Departamento departamentos) {
		super();
		this.IdTipoTareas=id;
		Descripcion = descripcion;
		IsActivo = isActivo;
		this.departamentos = departamentos;
	}

	public TipoTarea() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
