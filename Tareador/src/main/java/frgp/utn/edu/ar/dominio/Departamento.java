package frgp.utn.edu.ar.dominio;

import javax.persistence.*;



@Entity

@Table(name ="departamentos")
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Departamento")
	private Integer idDepartamento;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="descripcion" )
	private String descripcion;
	
	@Column(name="is_activo" )
	private Boolean isActivo;

//	public Departamento(String codigo , String descripcion, Boolean isActivo) {
//		super();
//		this.codigo = codigo;
//		this.descripcion = descripcion;
//		this.isActivo = isActivo;
//	}
//	
	public Departamento(Integer id,String codigo , String descripcion, Boolean isActivo) {
		super();
		this.idDepartamento= id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.isActivo = isActivo;
	}

	public Departamento() {
		super();
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
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
	
	
	
	
}
