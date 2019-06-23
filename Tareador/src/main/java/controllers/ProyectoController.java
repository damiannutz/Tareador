package controllers;


import java.util.*;

import javax.persistence.Convert;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.spi.ConversionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dominio.*;
import servicio.*;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProyectoController {

	@Autowired
	public ProyectoServicio proyectoServicio;
	
	@Autowired
	public DepartamentoServicio departamentoServicio;
	
	@RequestMapping("IrAdministrarProyectos.html")
	public ModelAndView redireccionAdministrarProyectos(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AdministrarProyectos");
		return MV;
	}
	@RequestMapping("IrAltaProyecto.html")
	public ModelAndView redireccionAltaProyecto(){
		List<Departamento> lstDepartamentos = departamentoServicio.obtenerAllActivos();
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AltaProyectos");
		MV.addObject("headerTitle", "Nuevo Proyecto");
		MV.addObject("lstDepartamentos", lstDepartamentos);
		return MV;
	}
	@RequestMapping("IrListarProyectos.html")
	public ModelAndView redireccionListarProyectos(){

		List<Proyecto> lstProyectos = proyectoServicio.obtenerAllActivos();
		List<Departamento> lstDepartamentos = departamentoServicio.obtenerAllActivos();
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ListarProyectos");
		MV.addObject("lstProyectos", lstProyectos);
		MV.addObject("lstDepartamentos", lstDepartamentos);
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
		List<Departamento> lstDepartamentos = departamentoServicio.obtenerAllActivos();
		
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
	
	
	
}
