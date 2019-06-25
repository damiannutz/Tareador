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
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import dominio.*;
import servicio.*;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RolController {

	@Autowired
	public RolServicio rolServicio;
	
	@Autowired
	public DepartamentoServicio departamentoServicio;
	
	@Autowired
	public  UsuarioServicio usuarioService;
	
	@Autowired
	public  TipoUsuarioServicio tipoUsuarioService;
	
	
	@RequestMapping("IrAdministrarRoles.html")
	public ModelAndView redireccionAdministrarRoles(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AdministrarRoles");
		return MV;
	}
	@RequestMapping("IrAltaRol.html")
	public ModelAndView redireccionAltaRol(){
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AltaRoles");
		MV.addObject("headerTitle", "Nuevo Rol");
		
		return MV;
	}
	@RequestMapping("IrListarRoles.html")
	public ModelAndView redireccionListarRoles(){

		Set<Rol> lstRoles = rolServicio.obtenerAllActivos().stream().collect(Collectors.toSet());
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ListarRoles");
		MV.addObject("lstRoles", lstRoles);
		
		return MV;
	}
	
	
	@RequestMapping(value={ "edit-rol.html" }, method= { RequestMethod.GET,RequestMethod.POST})
	public ModelAndView redireccionAltaRol(Integer idRol){
	
		Rol Rol = rolServicio.obtenerById(idRol);
		
		ModelAndView MV = new ModelAndView();
		MV.addObject("IdRol", Rol.getIdRol());
		MV.addObject("RolCodigo", Rol.getCodigo());
		MV.addObject("RolDescripcion", Rol.getDescripcion());
		
		MV.addObject("headerTitle", "Editar Rol");
		MV.setViewName("AltaRoles");
		return MV;
	}
	
	
	@RequestMapping(value={ "/save-rol.html" }, method= { RequestMethod.POST})
	public ModelAndView redireccionGuardarRol(Integer IdRol,String codigo, String descripcion ){
		
		Rol Rol= new Rol(null,  codigo ,descripcion, true);
		
		if(IdRol != null && IdRol>0)
			Rol.setIdRol(IdRol);
	
		if(Rol.getIdRol() == null)
			rolServicio.insertar(Rol);
		else
			rolServicio.actualizar(Rol);
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("forward:/IrListarRoles.html");
		return MV;
	}
	
	@RequestMapping(value={ "/baja-rol-{IdRol}" }, method= { RequestMethod.GET})
	public ModelAndView redireccionBajaLogicaRol(@PathVariable Integer IdRol){
	
		if(IdRol != null && IdRol>0)
			rolServicio.bajaLogica(IdRol);
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("forward:/IrListarRoles.html");
		return MV;
	}
	
	@RequestMapping(value={ "agregar-usuario-rol.html" }, method= { RequestMethod.GET,RequestMethod.POST})
	public ModelAndView redireccionAgregarUsuarioProyecto(Integer idRol){
	
		Rol rol = rolServicio.obtenerById(idRol);

		
		ModelAndView MV = new ModelAndView();
		Set<Usuario> userList = usuarioService.obtenerAllActivos().stream().filter(r->!r.getLsRoles().stream().anyMatch(s->s.getIdRol().equals(idRol))).collect(Collectors.toSet());;
		MV.addObject("departamentos", departamentoServicio.obtenerAllActivos().stream().collect(Collectors.toSet()));
		MV.addObject("tiposUsuario", tipoUsuarioService.obtenerAll());
		MV.addObject("usuarios", userList);
		MV.addObject("idRol", idRol);

		MV.addObject("headerTitle", "Agregar Rol");
		MV.setViewName("AgregarUsuarioARol");
		return MV;
	}
	
	
}
