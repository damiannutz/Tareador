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
	public ComentarioTareaServicio comentarioTareaServicio;
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
	
	@Autowired
	public RolServicio rolServicio;
	
	
	
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
		Set<Proyecto> lstProyectos =null;
		if(userSession != null ) {
			if(userSession.getTipoUsuario().getIdTipoUsuario().equals(TipoUsuario.tipo_user))
				lstProyectos = userSession.getLsProyectos();
			else
				lstProyectos = proyectoServicio.obtenerAllActivos().stream().collect(Collectors.toSet());
				
			usuarioReportaId = userSession.getIdUsuario();
			usuarioReportaNombreUsuario= userSession.getNombreUsuario();
		}
		
		List<Prioridad> lstPrioridades = prioridadServicio.obtenerAllActivos();
		List<EstadoTarea> lstEstadoTareas = estadoTareaServicio.obtenerAllActivos();
		List<TipoTarea> lstTipoTareas = tipoTareaServicio.obtenerAllActivos();
		
		

		Set<Usuario> lstUsuariosPosibles = new HashSet<Usuario>() ;
		try {
			if(lstProyectos!= null)
				for(Proyecto item : lstProyectos ) {
				
					if(item.getUsuariosByProyecto() != null && item.getUsuariosByProyecto().size()>0)
						lstUsuariosPosibles.addAll(item.getUsuariosByProyecto());
				}
			
			//			lstUsuariosPosibles= usuarioServicio.obtenerAllActivos().stream().					
//				filter(r->r.getLsProyectos() != null && r.getLsProyectos().stream().
//				anyMatch(s-> s.getIdProyecto().equals(Tarea.getProyecto().getIdProyecto()) ) ).distinct().collect(Collectors.toSet()); 
			
		}
		catch(Exception e) {
			System.out.println("No hay Usuarios asignables para ese proyecto");
		}
		
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AltaTareas");
		MV.addObject("headerTitle", "Nuevo Tarea");
		MV.addObject("lstProyectos", lstProyectos);
		MV.addObject("lstPrioridades", lstPrioridades);
		MV.addObject("lstEstadoTareas", lstEstadoTareas);
		MV.addObject("lstTipoTareas", lstTipoTareas);
		MV.addObject("usuarioReportaId", usuarioReportaId);
		MV.addObject("usuarioReportaNombreUsuario", usuarioReportaNombreUsuario);
		MV.addObject("lstUsuarios", lstUsuariosPosibles);
		
		asignarRolesParaUsuario(MV, userSession);
		
		
		return MV;
	}
	@RequestMapping("IrListarTareas.html")
	public ModelAndView redireccionListarTareas(@SessionAttribute("Sessuser") Usuario userSession){

		Set<Tarea> lstTareas = tareaServicio.obtenerAllActivos();
		Set<Proyecto> lstProyectos = proyectoServicio.obtenerAllActivos().stream().collect(Collectors.toSet());
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
		
		asignarRolesParaUsuario(MV, userSession);
		
		return MV;
	}
	
	
	
	@RequestMapping(value={ "edit-tarea.html" }, method= { RequestMethod.GET,RequestMethod.POST})
	public ModelAndView redireccionAltaTarea(Integer idTarea,@SessionAttribute("Sessuser") Usuario userSession){
	
		Tarea tarea = tareaServicio.obtenerById(idTarea);
		
		Set<Proyecto> lstProyectos ;
		if(userSession != null && userSession.getTipoUsuario().getIdTipoUsuario().equals(TipoUsuario.tipo_user)) {
			
			lstProyectos = tarea.getUsuarioReporta().getLsProyectos();
		}
		else
			lstProyectos = proyectoServicio.obtenerAllActivos().stream().collect(Collectors.toSet());
		
		List<Prioridad> lstPrioridades = prioridadServicio.obtenerAllActivos();
		List<EstadoTarea> lstEstadoTareas = estadoTareaServicio.obtenerAllActivos();
		List<TipoTarea> lstTipoTareas = tipoTareaServicio.obtenerAllActivos();
		
		
		Set<Usuario> lstUsuariosPosibles = new HashSet<Usuario>() ;
		try {
				for(Proyecto item : lstProyectos ) {
					if(item.getUsuariosByProyecto() != null && item.getUsuariosByProyecto().size()>0)
						lstUsuariosPosibles.addAll(item.getUsuariosByProyecto());
				}
	
			
			
			//			lstUsuariosPosibles= usuarioServicio.obtenerAllActivos().stream().					
//				filter(r->r.getLsProyectos() != null && r.getLsProyectos().stream().
//				anyMatch(s-> s.getIdProyecto().equals(Tarea.getProyecto().getIdProyecto()) ) ).distinct().collect(Collectors.toSet()); 
			
		}
		catch(Exception e) {
			System.out.println("No hay Usuarios asignables para ese proyecto");
		}
		
		ModelAndView MV = new ModelAndView();
		MV.addObject("IdTarea", tarea.getIdTarea());
		MV.addObject("TareaTitulo", tarea.getTitulo());
		MV.addObject("TareaDescripcion", tarea.getDescripcion());
		MV.addObject("TareaProyectoId", tarea.getProyecto().getIdProyecto());
		MV.addObject("TareaPrioridadId", tarea.getPrioridad().getIdPrioridad());
		MV.addObject("TareaEstadoTareaId", tarea.getEstadoTarea().getIdEstadoTarea());
		MV.addObject("TareaTipoTareaId", tarea.getTipoTarea().getIdTipoTareas());
		MV.addObject("TareaUsuarioReportaId", tarea.getUsuarioReporta().getIdUsuario());
		MV.addObject("usuarioReportaId", tarea.getUsuarioReporta().getIdUsuario());
		MV.addObject("usuarioReportaNombreUsuario", tarea.getUsuarioReporta().getNombreUsuario());
		
		if(tarea.getUsuarioAsignado() != null) {
			MV.addObject("usuarioAsignadoId", tarea.getUsuarioAsignado().getIdUsuario());
			MV.addObject("usuarioAsignadoNombreUsuario", tarea.getUsuarioAsignado().getNombreUsuario());
			
		}
		else {
			MV.addObject("usuarioAsignadoId", null);
			MV.addObject("usuarioAsignadoNombreUsuario", null);			
		}
		
		MV.addObject("lstProyectos", lstProyectos);
		MV.addObject("lstPrioridades", lstPrioridades);
		MV.addObject("lstEstadoTareas", lstEstadoTareas);
		MV.addObject("lstTipoTareas", lstTipoTareas);
		MV.addObject("lstUsuarios", lstUsuariosPosibles);
		MV.addObject("headerTitle", "Editar Tarea");
		MV.setViewName("AltaTareas");
		
		asignarRolesParaUsuario(MV, userSession);
		
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
		
		Tarea tarea = new Tarea(null,  titulo, descripcion,true,tipoTarea,estadoTarea,prioridad,proyecto,usuarioReporta,usuarioAsignado);
		
	
		if(IdTarea != null && IdTarea>0)
			tarea.setIdTarea(IdTarea);
	
		if(tarea.getIdTarea() == null)
			tareaServicio.insertar(tarea);
		else
			tareaServicio.actualizar(tarea);
		
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
	
	
	public void asignarRolesParaUsuario(ModelAndView MV, Usuario user){
		
		Set<Rol> lstRoles = rolServicio.obtenerAllActivos().stream().collect(Collectors.toSet());
		
		for (Rol rol : lstRoles) {
			if(user != null && user.getLsRoles()!= null && user.getLsRoles().stream().anyMatch(r-> r.getCodigo().equals(rol.getCodigo())))
				MV.addObject(rol.getCodigo(),1);
			else
				MV.addObject(rol.getCodigo(),0);
		}
			
	}
	
	@RequestMapping("IrListarComentarios.html")
	public ModelAndView redireccionListarComentarios(Integer idTarea,@SessionAttribute("Sessuser") Usuario userSession){
		

		Tarea objtarea = tareaServicio.obtenerById(idTarea);
		



		Set<ComentarioTarea> lstComentarioTareas = objtarea.getComentariostarea();
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ListarComentarios");
		MV.addObject("idUsuario", userSession.getIdUsuario());
		MV.addObject("tituloTarea", objtarea.getTitulo());
		MV.addObject("idTarea", idTarea);
		MV.addObject("lstComentarioTareas", lstComentarioTareas);

		
		asignarRolesParaUsuario(MV, userSession);
		
		return MV;
	}
	
	@RequestMapping(value={"AgregarComentarioATarea.html"}, method= { RequestMethod.GET,RequestMethod.POST})
	public ModelAndView agregarComentarioATarea(Integer txtidTarea, Integer txtidUsuario, String txtComentario,@SessionAttribute("Sessuser") Usuario userSession){
		
		String mensajeguardar = userSession.getNombreUsuario();
		mensajeguardar = mensajeguardar + ": " + txtComentario;
		
		java.util.Date fecha = new Date();
		Tarea objtarea = tareaServicio.obtenerById(txtidTarea);
		ComentarioTarea objcoment = new ComentarioTarea();
		objcoment.setTarea(objtarea);
		objcoment.setComentario(mensajeguardar);
		objcoment.setFechaRegistro(fecha);
		
		try {
			comentarioTareaServicio.insertar(objcoment);
		}
		catch (Exception e){
			
		}
		objtarea = tareaServicio.obtenerById(txtidTarea);
		Set<ComentarioTarea> lstComentarioTareas = objtarea.getComentariostarea();
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ListarComentarios");
		MV.addObject("idUsuario", userSession.getIdUsuario());
		MV.addObject("tituloTarea", objtarea.getTitulo());
		MV.addObject("idTarea", objtarea.getIdTarea());
		MV.addObject("lstComentarioTareas", lstComentarioTareas);

		
		asignarRolesParaUsuario(MV, userSession);
		
		return MV;
	}
	
}
