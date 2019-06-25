package controllers;


import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.Convert;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.spi.ConversionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dominio.*;
import servicio.*;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TareaController {

	@Autowired
	public TareaServicio tareaServicio;
	
	@Autowired
	public ProyectoServicio proyectoServicio;
	@Autowired
	public TipoTareaServicio tipoTareaServicio;
	@Autowired
	public EstadoTareaServicio estadoTareaServicio;
	@Autowired
	public PrioridadServicio prioridadServicio;
	@Autowired
	public UsuarioServicio usuarioServicio;
	
	
//	@RequestMapping("IrAdministrarTareas.html")
//	public ModelAndView redireccionAdministrarTareas(){
//		ModelAndView MV = new ModelAndView();
//		MV.setViewName("AdministrarTareas");
//		return MV;
//	}
	@RequestMapping("IrAltaTarea.html")
	public ModelAndView redireccionAltaTarea(@SessionAttribute("Sessuser") Usuario userSession){
		
		Integer usuarioReportaId=null;
		String usuarioReportaNombreUsuario=null;
		List<Proyecto> lstProyectos ;
		if(userSession != null && userSession.getTipoUsuario().getIdTipoUsuario().equals(TipoUsuario.tipo_user)) {
			
			lstProyectos = userSession.getLsProyectos().stream().collect(Collectors.toList());
			usuarioReportaId = userSession.getIdUsuario();
			usuarioReportaNombreUsuario= userSession.getNombreUsuario();
		}
		else
			lstProyectos = proyectoServicio.obtenerAllActivos();
		List<Prioridad> lstPrioridades = prioridadServicio.obtenerAllActivos();
		List<EstadoTarea> lstEstadoTareas = estadoTareaServicio.obtenerAllActivos();
		List<TipoTarea> lstTipoTareas = tipoTareaServicio.obtenerAllActivos();
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AltaTareas");
		MV.addObject("headerTitle", "Nuevo Tarea");
		MV.addObject("lstProyectos", lstProyectos);
		MV.addObject("lstPrioridades", lstPrioridades);
		MV.addObject("lstEstadoTareas", lstEstadoTareas);
		MV.addObject("lstTipoTareas", lstTipoTareas);
		MV.addObject("usuarioReportaId", usuarioReportaId);
		MV.addObject("usuarioReportaNombreUsuario", usuarioReportaNombreUsuario);
		
		
		return MV;
	}
	@RequestMapping("IrListarTareas.html")
	public ModelAndView redireccionListarTareas(){

		Set<Tarea> lstTareas = tareaServicio.obtenerAllActivos();
		List<Proyecto> lstProyectos = proyectoServicio.obtenerAllActivos();
		List<Prioridad> lstPrioridades = prioridadServicio.obtenerAllActivos();
		List<EstadoTarea> lstEstadoTareas = estadoTareaServicio.obtenerAllActivos();
		List<TipoTarea> lstTipoTareas = tipoTareaServicio.obtenerAllActivos();
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ListarTareas");
		MV.addObject("lstTareas", lstTareas);
		MV.addObject("lstProyectos", lstProyectos);
		MV.addObject("lstPrioridades", lstPrioridades);
		MV.addObject("lstEstadoTareas", lstEstadoTareas);
		MV.addObject("lstTipoTareas", lstTipoTareas);
		
		
		return MV;
	}
	
	
	
	@RequestMapping(value={ "edit-tarea.html" }, method= { RequestMethod.GET,RequestMethod.POST})
	public ModelAndView redireccionAltaTarea(Integer idTarea){
	
		Tarea Tarea = tareaServicio.obtenerById(idTarea);
		List<Proyecto> lstProyectos = proyectoServicio.obtenerAllActivos();
		List<Prioridad> lstPrioridades = prioridadServicio.obtenerAllActivos();
		List<EstadoTarea> lstEstadoTareas = estadoTareaServicio.obtenerAllActivos();
		List<TipoTarea> lstTipoTareas = tipoTareaServicio.obtenerAllActivos();
		
		Set<Usuario> lstUsuarios = null ;
		try {
			lstUsuarios= usuarioServicio.obtenerAllActivos().stream().					
				filter(r->r.getLsProyectos() != null && r.getLsProyectos().stream().
				anyMatch(s-> s.getIdProyecto().equals(Tarea.getProyecto().getIdProyecto()) ) ).distinct().collect(Collectors.toSet()); 
			
		}
		catch(Exception e) {
			System.out.println("No hay Usuarios asignables para ese proyecto");
		}
		
		ModelAndView MV = new ModelAndView();
		MV.addObject("IdTarea", Tarea.getIdTarea());
		MV.addObject("TareaTitulo", Tarea.getTitulo());
		MV.addObject("TareaDescripcion", Tarea.getDescripcion());
		MV.addObject("TareaProyectoId", Tarea.getProyecto().getIdProyecto());
		MV.addObject("TareaPrioridadId", Tarea.getPrioridad().getIdPrioridad());
		MV.addObject("TareaEstadoTareaId", Tarea.getEstadoTarea().getIdEstadoTarea());
		MV.addObject("TareaTipoTareaId", Tarea.getTipoTarea().getIdTipoTareas());
		MV.addObject("TareaUsuarioReportaId", Tarea.getUsuarioReporta().getIdUsuario());
		MV.addObject("usuarioReportaId", Tarea.getUsuarioReporta().getIdUsuario());
		MV.addObject("usuarioReportaNombreUsuario", Tarea.getUsuarioReporta().getNombreUsuario());
		
		if(Tarea.getUsuarioAsignado() != null) {
			MV.addObject("usuarioAsignadoId", Tarea.getUsuarioAsignado().getIdUsuario());
			MV.addObject("usuarioAsignadoNombreUsuario", Tarea.getUsuarioAsignado().getNombreUsuario());
			
		}
		else {
			MV.addObject("usuarioAsignadoId", null);
			MV.addObject("usuarioAsignadoNombreUsuario", null);			
		}
		
		MV.addObject("lstProyectos", lstProyectos);
		MV.addObject("lstPrioridades", lstPrioridades);
		MV.addObject("lstEstadoTareas", lstEstadoTareas);
		MV.addObject("lstTipoTareas", lstTipoTareas);
		MV.addObject("lstUsuarios", lstUsuarios);
		MV.addObject("headerTitle", "Editar Tarea");
		MV.setViewName("AltaTareas");
		
		return MV;
	}
	
	
	@RequestMapping(value={ "/save-tarea.html" }, method= { RequestMethod.POST})
	public ModelAndView redireccionGuardarTarea(Integer IdTarea,
												String titulo,
												String descripcion,
												Integer cmbTipoTareaId,
												Integer cmbEstadoTareaId,
												Integer cmbPrioridadId,
												Integer cmbProyectoId,
												Integer IdUsuarioReporta,
												Integer cmbUsuarioAsignadoId
	){
		
		
		
		TipoTarea tipoTarea = tipoTareaServicio.obtenerById(cmbTipoTareaId);
		EstadoTarea estadoTarea = estadoTareaServicio.obtenerById(cmbEstadoTareaId);
		Prioridad prioridad = prioridadServicio.obtenerById(cmbPrioridadId);
		Proyecto proyecto = proyectoServicio.obtenerById(cmbProyectoId);
		Usuario usuarioReporta = usuarioServicio.obtenerById(IdUsuarioReporta);
		Usuario usuarioAsignado = null;
		if(cmbUsuarioAsignadoId != null && cmbUsuarioAsignadoId>0)
			usuarioAsignado= usuarioServicio.obtenerById(cmbUsuarioAsignadoId);
		
		Tarea Tarea = new Tarea(null,  titulo, descripcion,true,tipoTarea,estadoTarea,prioridad,proyecto,usuarioReporta,usuarioAsignado);
		
	
		if(IdTarea != null && IdTarea>0)
			Tarea.setIdTarea(IdTarea);
	
		if(Tarea.getIdTarea() == null)
			tareaServicio.insertar(Tarea);
		else
			tareaServicio.actualizar(Tarea);
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("forward:/IrListarTareas.html");
		return MV;
	}
	
	@RequestMapping(value={ "/baja-tarea-{IdTarea}" }, method= { RequestMethod.GET})
	public ModelAndView redireccionBajaLogicaTarea(@PathVariable Integer IdTarea){
	
		if(IdTarea != null && IdTarea>0)
			tareaServicio.bajaLogica(IdTarea);
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("forward:/IrListarTareas.html");
		return MV;
	}
	
	
	
}
