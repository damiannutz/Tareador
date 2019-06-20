package dominio;

import java.util.List;

import javax.persistence.*;



@Entity

@Table(name = "Tareas")
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Tarea")
	private Integer IdTarea;
	
	@Column(name="Titulo")
	private String Titulo;
	
	
	@Column(name="Descripcion")
	private String Descripcion;
	
	
	@Column(name="Is_Activo")
	private boolean IsActivo;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="Id_Tipo_Tareas")
	private TipoTarea tipoTarea;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="Id_Estado_Tareas")
	private EstadoTarea estadoTarea;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="Id_Prioridad")
	private Prioridad prioridad;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="Id_Proyecto")
	private Proyecto proyecto;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="Id_Usuario_Reporta" , referencedColumnName = "Id_Usuario" )
	private Usuario usuarioReporta;

	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="Id_Usuario_Asignado" , referencedColumnName = "Id_Usuario" )
	private Usuario usuarioAsignado;

	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="Id_Tarea")
	private List<ComentarioTarea> comentariostarea;
	
	
	public Integer getIdTarea() {
		return IdTarea;
	}

	public void setIdTarea(Integer idTarea) {
		IdTarea = idTarea;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public boolean getIsActivo() {
		return IsActivo;
	}

	public void setIsActivo(boolean isActivo) {
		IsActivo = isActivo;
	}

	public TipoTarea getTipoTarea() {
		return tipoTarea;
	}

	public void setTipoTarea(TipoTarea tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	public EstadoTarea getEstadoTarea() {
		return estadoTarea;
	}

	public void setEstadoTarea(EstadoTarea estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Usuario getUsuarioReporta() {
		return usuarioReporta;
	}

	public void setUsuarioReporta(Usuario usuarioReporta) {
		this.usuarioReporta = usuarioReporta;
	}

	public Usuario getUsuarioAsignado() {
		return usuarioAsignado;
	}

	public void setUsuarioAsignado(Usuario usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}

	
	

	public List<ComentarioTarea> getComentariostarea() {
		return comentariostarea;
	}

	public void setComentariostarea(List<ComentarioTarea> comentariostarea) {
		this.comentariostarea = comentariostarea;
	}

	public Tarea( String titulo, String descripcion, boolean isActivo, TipoTarea tipoTarea,
			EstadoTarea estadoTarea, Prioridad prioridad, Proyecto proyecto, Usuario usuarioReporta,
			Usuario usuarioAsignado) {
		super();
		Titulo = titulo;
		Descripcion = descripcion;
		IsActivo = isActivo;
		this.tipoTarea = tipoTarea;
		this.estadoTarea = estadoTarea;
		this.prioridad = prioridad;
		this.proyecto = proyecto;
		this.usuarioReporta = usuarioReporta;
		this.usuarioAsignado = usuarioAsignado;
	}
	
	public Tarea(Integer id,String titulo, String descripcion, boolean isActivo, TipoTarea tipoTarea,
			EstadoTarea estadoTarea, Prioridad prioridad, Proyecto proyecto, Usuario usuarioReporta,
			Usuario usuarioAsignado) {
		super();
		this.IdTarea=id;
		Titulo = titulo;
		Descripcion = descripcion;
		IsActivo = isActivo;
		this.tipoTarea = tipoTarea;
		this.estadoTarea = estadoTarea;
		this.prioridad = prioridad;
		this.proyecto = proyecto;
		this.usuarioReporta = usuarioReporta;
		this.usuarioAsignado = usuarioAsignado;
	}

	public Tarea() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
	
	
}
