package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dominio.*;
import servicio.*;

import org.springframework.web.bind.annotation.PathVariable;

@SessionAttributes("Sessuser")
@Controller
public class DepartamentoController {

	@Autowired
	public DepartamentoServicio departamentoServicio;
	
	@RequestMapping("IrAdministrarDepartamentos.html")
	public ModelAndView redireccionAdministrarDepartamentos(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AdministrarDepartamentos");
		return MV;
	}
	@RequestMapping("IrAltaDepartamento.html")
	public ModelAndView redireccionAltaDepartamento(){
	
		ModelAndView MV = new ModelAndView();
		//MV.addObject("departamento", departamento);
		MV.addObject("headerTitle", "Nuevo Departamento");
		MV.setViewName("AltaDepartamento");
		return MV;
	}
	@RequestMapping("IrListarDepartamentos.html")
	public ModelAndView redireccionListarDepartamentos(){
		
		Set<Departamento> lstDepartamentos = departamentoServicio.obtenerAllActivos().stream().collect(Collectors.toSet());
		
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ListarDepartamentos");
		MV.addObject("lstDepartamentos", lstDepartamentos);
		return MV;
	}
	
	@RequestMapping(value={ "edit-departamento.html" }, method= { RequestMethod.GET,RequestMethod.POST})
	public ModelAndView redireccionAltaDepartamento(Integer idDepartamento){

		Departamento departamento = departamentoServicio.obtenerById(idDepartamento);
		
		ModelAndView MV = new ModelAndView();
		MV.addObject("IdDepartamento", departamento.getIdDepartamento());
		MV.addObject("departamentoCodigo", departamento.getCodigo());
		MV.addObject("departamentoDescripcion", departamento.getDescripcion());
		MV.addObject("headerTitle", "Editar Departamento");
		MV.setViewName("AltaDepartamento");
		return MV;
	}
	
//	@RequestMapping(value={ "/edit-departamento-{idDepartamento}" }, method= { RequestMethod.GET})
//	public ModelAndView redireccionAltaDepartamento(@PathVariable Integer idDepartamento){
//	
//		Departamento departamento = departamentoServicio.obtenerById(idDepartamento);
//		
//		ModelAndView MV = new ModelAndView();
//		MV.addObject("IdDepartamento", departamento.getIdDepartamento());
//		MV.addObject("departamentoCodigo", departamento.getCodigo());
//		MV.addObject("departamentoDescripcion", departamento.getDescripcion());
//		MV.addObject("headerTitle", "Editar Departamento");
//		MV.setViewName("AltaDepartamento");
//		return MV;
//	}
//	@RequestMapping(value="/edit-departamento-{departamento}", method= { RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView redireccionAltaDepartamento(@PathVariable Departamento departamento){
//	
//		ModelAndView MV = new ModelAndView();
//		MV.addObject("IdDepartamento", departamento.getIdDepartamento());
//		MV.addObject("departamentoCodigo", departamento.getCodigo());
//		MV.addObject("departamentoDescripcion", departamento.getDescripcion());
//		MV.setViewName("AltaDepartamento");
//		return MV;
//	}
	
	@RequestMapping(value={ "/save-departamento.html" }, method= { RequestMethod.POST})
	public ModelAndView redireccionGuardarDepartamento(Integer idDepartamento, String codigo , String descripcion){
		
		Departamento departamento= new Departamento(null, codigo, descripcion, true);
		
		if(idDepartamento != null && idDepartamento>0)
			departamento.setIdDepartamento(idDepartamento);
	
		if(departamento.getIdDepartamento() == null)
			departamentoServicio.insertar(departamento);
		else
			departamentoServicio.actualizar(departamento);
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("forward:/IrListarDepartamentos.html");
		return MV;
	}
	
	@RequestMapping(value={ "/baja-departamento-{idDepartamento}" }, method= { RequestMethod.GET})
	public ModelAndView redireccionBajaLogicaDepartamento(@PathVariable Integer idDepartamento){
	
		if(idDepartamento != null && idDepartamento>0)
			departamentoServicio.bajaLogica(idDepartamento);
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("forward:/IrListarDepartamentos.html");
		return MV;
	}
	
	

	
	
	
	
}
