package frgp.utn.edu.ar.dominio;
import javax.persistence.*;


@Entity

@Table(name = "Prioridades")
public class Prioridad {

	public static final String P_Muy_Baja = "MB";
	public static final String P_Baja = "B";
	public static final String P_Media = "M";
	public static final String P_Alta = "A";
	public static final String P_Muy_Alta = "MA";
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Prioridad")
	private Integer IdPrioridad;
	
	@Column(name="Codigo")
	private String Codigo;
	
	@Column(name="Descripcion")
	private String Descripcion;
	
	@Column(name="Is_Activo")
	private boolean IsActivo;

	public Integer getIdPrioridad() {
		return IdPrioridad;
	}

	public void setIdPrioridad(Integer idPrioridad) {
		IdPrioridad = idPrioridad;
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

	public boolean isIsActivo() {
		return IsActivo;
	}

	public void setIsActivo(boolean isActivo) {
		IsActivo = isActivo;
	}
	
	
	public Prioridad(Integer id, String codigo, String descripcion, boolean isActivo) {
		super();
		this.IdPrioridad=id;
		Codigo = codigo;
		Descripcion = descripcion;
		IsActivo = isActivo;
	}


	public Prioridad( String codigo, String descripcion, boolean isActivo) {
		super();
		Codigo = codigo;
		Descripcion = descripcion;
		IsActivo = isActivo;
	}

	public Prioridad() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
