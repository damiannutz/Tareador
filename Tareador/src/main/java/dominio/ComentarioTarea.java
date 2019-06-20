package dominio;

import java.util.Date;

import javax.persistence.*;



@Entity

@Table(name = "Comentarios_Tareas")
public class ComentarioTarea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Comentario_Tarea")
	private Integer IdComentarioTarea;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="Id_Tarea")
	private Tarea tarea;
	
	@Column(name="Fecha_Registro")
	private Date FechaRegistro;

	@Column(name="Comentario")
	private String Comentario;
	
	public Integer getIdComentarioTarea() {
		return IdComentarioTarea;
	}

	public void setIdComentarioTarea(Integer idComentarioTarea) {
		IdComentarioTarea = idComentarioTarea;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public Date getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}

	public String getComentario() {
		return Comentario;
	}

	public void setComentario(String comentario) {
		Comentario = comentario;
	}

	public ComentarioTarea(Integer idComentarioTarea, Tarea tarea, Date fechaRegistro, String comentario) {
		super();
		IdComentarioTarea = idComentarioTarea;
		this.tarea = tarea;
		FechaRegistro = fechaRegistro;
		Comentario = comentario;
	}

	public ComentarioTarea() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
