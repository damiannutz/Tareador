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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dominio.*;
import servicio.*;

import org.springframework.web.bind.annotation.PathVariable;

@SessionAttributes("Sessuser")
@Controller
public class ProyectoController {

	@Autowired
	public ProyectoServicio proyectoServicio;
	
	@Autowired
	public DepartamentoServicio departamentoServicio;
	
	@Autowired
	public  UsuarioServicio usuarioService;
	
	@Autowired
	public  TipoUsuarioServicio tipoUsuarioService;
	
	@Autowired
	public RolServicio rolServicio;
	
	@RequestMapping("IrAdministrarProyectos.html")
	public ModelAndView redireccionAdministrarProyectos( ){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AdministrarProyectos");
		
		return MV;
	}
	@RequestMapping("IrAltaProyecto.html")
	public ModelAndView redireccionAltaProyecto(  ){
		Set<Departamento> lstDepartamentos = departamentoServicio.obtenerAllActivos().stream().collect(Collectors.toSet());
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AltaProyectos");
		MV.addObject("headerTitle", "Nuevo Proyecto");
		MV.addObject("lstDepartamentos", lstDepartamentos);
		
		return MV;
	}
	@RequestMapping("IrListarProyectos.html")
	public ModelAndView redireccionListarProyectos(@SessionAttribute("Sessuser") Usuario userSession){

		Set<Proyecto> lstProyectos = proyectoServicio.obtenerAllActivos().stream().collect(Collectors.toSet());
		Set<Departamento> lstDepartamentos = departamentoServicio.obtenerAllActivos().stream().collect(Collectors.toSet());
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ListarProyectos");
		MV.addObject("lstProyectos", lstProyectos);
		MV.addObject("lstDepartamentos", lstDepartamentos);
		
		asignarRolesParaUsuario(MV, userSession);
		
		return MV;
	}
	
	
//	@RequestMapping(value={ "/edit-proyecto-{idProyecto}" }, method= { RequestMethod.GET})
//	public ModelAndView redireccionAltaProyecto(@PathVariable Integer idProyecto){
//	
//		Proyecto Proyecto = proyectoServicio.obtenerById(idProyecto);
//		
//		ModelAndView MV = new ModelAndView();
//		MV.addObject("IdProyecto", Proyecto.getIdProyecto());
//		MV.addObject("ProyectoDescripcion", Proyecto.getDescripcion());
//		MV.addObject("headerTitle", "Editar Proyecto");
//		MV.setViewName("AltaProyecto");
//		return MV;
//	}
	
	@RequestMapping(value={ "edit-proyecto.html" }, method= { RequestMethod.GET,RequestMethod.POST})
	public ModelAndView redireccionAltaProyecto(Integer idProyecto){
	
		Proyecto Proyecto = proyectoServicio.obtenerById(idProyecto);
		Set<Departamento> lstDepartamentos = departamentoServicio.obtenerAllActivos().stream().collect(Collectors.toSet());
		
		ModelAndView MV = new ModelAndView();
		MV.addObject("IdProyecto", Proyecto.getIdProyecto());
		MV.addObject("ProyectoDescripcion", Proyecto.getDescripcion());
		MV.addObject("ProyectoDepartamentoId", Proyecto.getDepartamento().getIdDepartamento());
		MV.addObject("lstDepartamentos", lstDepartamentos);
		MV.addObject("headerTitle", "Editar Proyecto");
		MV.setViewName("AltaProyectos");
		return MV;
	}
	
	
//	@RequestMapping(value="/edit-Proyecto-{Proyecto}", method= { RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView redireccionAltaProyecto(@PathVariable Proyecto Proyecto){
//	
//		ModelAndView MV = new ModelAndView();
//		MV.addObject("IdProyecto", Proyecto.getIdProyecto());
//		MV.addObject("ProyectoCodigo", Proyecto.getCodigo());
//		MV.addObject("ProyectoDescripcion", Proyecto.getDescripcion());
//		MV.setViewName("AltaProyecto");
//		return MV;
//	}
	
	@RequestMapping(value={ "/save-proyecto.html" }, method= { RequestMethod.POST})
	public ModelAndView redireccionGuardarProyecto(Integer IdProyecto, String descripcion , Integer cmbDepartamentoId){
		
		Departamento departamento = departamentoServicio.obtenerById(cmbDepartamentoId);
		
		Proyecto Proyecto= new Proyecto(null,  descripcion, true, departamento);
		
		if(IdProyecto != null && IdProyecto>0)
			Proyecto.setIdProyecto(IdProyecto);
	
		if(Proyecto.getIdProyecto() == null)
			proyectoServicio.insertar(Proyecto);
		else
			proyectoServicio.actualizar(Proyecto);
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("forward:/IrListarProyectos.html");
		return MV;
	}
	
	@RequestMapping(value={ "/baja-proyecto-{IdProyecto}" }, method= { RequestMethod.GET})
	public ModelAndView redireccionBajaLogicaProyecto(@PathVariable Integer IdProyecto){
	
		if(IdProyecto != null && IdProyecto>0)
			proyectoServicio.bajaLogica(IdProyecto);
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("forward:/IrListarProyectos.html");
		return MV;
	}
	
	
	@RequestMapping(value={ "agregar-usuario-proyecto.html" }, method= { RequestMethod.GET,RequestMethod.POST})
	public ModelAndView redireccionAgregarUsuarioProyecto(Integer idProyecto){
	
		Proyecto Proyecto = proyectoServicio.obtenerById(idProyecto);

		
		ModelAndView MV = new ModelAndView();
		Set<Usuario> userList = usuarioService.obtenerAllActivos().stream().filter(r->!r.getLsProyectos().stream().anyMatch(s->s.getIdProyecto().equals(idProyecto))).collect(Collectors.toSet());
		MV.addObject("departamentos", departamentoServicio.obtenerAllActivos().stream().collect(Collectors.toSet()));
		MV.addObject("tiposUsuario", tipoUsuarioService.obtenerAll());
		MV.addObject("usuarios", userList);
		MV.addObject("IdProyecto", idProyecto);
		MV.addObject("ProyectoDescripcion", Proyecto.getDescripcion());
		MV.addObject("ProyectoDepartamentoId", Proyecto.getDepartamento().getIdDepartamento());
		MV.addObject("headerTitle", "Agregar Usuario");
		MV.setViewName("AgregarUsuarioAProyecto");
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
	
}
