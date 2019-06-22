package helpers;

import org.springframework.beans.factory.annotation.Autowired;

import servicio.EstadoTareaServicio;
import servicio.PrioridadServicio;
import servicio.RolServicio;
import servicio.TipoTareaServicio;
import servicio.TipoUsuarioServicio;

public class InicializacionBD {
	
	@Autowired
	public EstadoTareaServicio estadoTareaServicio;
	
	@Autowired
	public PrioridadServicio prioridadServicio;
	
	@Autowired
	public RolServicio rolServicio;
	
	@Autowired
	public TipoTareaServicio tipoTareaServicio;
	
	@Autowired
	public TipoUsuarioServicio tipoUsuarioServicio;
	
}
