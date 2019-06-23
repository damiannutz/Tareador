package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public class UserController {
	
	@Autowired
	public  UsuarioServicio usuarioService;
	
//	public void init(ServletConfig config) {
//		ApplicationContext ctx = WebApplicationContextUtils
//				.getRequiredWebApplicationContext(config.getServletContext());
//		
//		this.service = (UsuarioServicio) ctx.getBean("serviceBean");
//	}
//	
	
	
//	@Autowired
//	public EstadoTareaServicio estadoTareaServicio;
//	
//	@Autowired
//	public PrioridadServicio prioridadServicio;
//	
//	@Autowired
//	public RolServicio rolServicio;
//	
//	@Autowired
//	public TipoTareaServicio tipoTareaServicio;
//	
//	@Autowired
//	public TipoUsuarioServicio tipoUsuarioServicio;

	
	
	//Inicio
	
	@RequestMapping(value={"Index.html", "Inicio.html"})
	public ModelAndView redireccion(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("userin"); 
		return MV;
	}
	@RequestMapping("IrLogin.html")
	public ModelAndView redireccionLogin(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("login"); 
		return MV;
	}
	@RequestMapping("IrAltaUsuario.html")
	public ModelAndView redireccionAltaUsuario(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AltaUsuario"); 
		return MV;
	}
	@RequestMapping("IrAdministrarUsuarios.html")
	public ModelAndView redireccionAdministrarUsuario(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AdministrarUsuarios"); 
		return MV;
	}
	@RequestMapping("IrListarUsuarios.html")
	public ModelAndView redireccionListarUsuarios(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ListarUsuario");
		return MV;
	}
	@RequestMapping("IrGestionarUsuario.html")
	public ModelAndView redireccionGestionarUsuario(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("GestionarUsuario");
		return MV;
	}
	@RequestMapping("IrAdministrarProyectos.html")
	public ModelAndView redireccionAdministrarProyectos(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AdministrarProyectos");
		return MV;
	}
	@RequestMapping("IrAltaProyecto.html")
	public ModelAndView redireccionAltaProyecto(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AltaProyectos");
		return MV;
	}
	@RequestMapping("IrListarProyectos.html")
	public ModelAndView redireccionListarProyectos(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ListarProyectos");
		return MV;
	}
	
	
	
	@RequestMapping(value ="/altaUsuario.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView validarUsuario(String nombreU, String passU){
		ModelAndView MV = new ModelAndView();
		
		Usuario x = new Usuario();
		x.setNombre(nombreU);
		x.setContrasenia(passU);
		
		String Message="";
		
		try{
			
			usuarioService.insertar(x);
			Message = "Usuario agregado";
		}
		catch(Exception e)
		{
			Message = "No se pudo insertar el usuario";
		}
		finally
		{
		
		}
	
		MV.setViewName("Usuarios");
		MV.addObject("Mensaje", Message);
		MV.addObject("listaUsuarios",this.usuarioService.obtenerAll());
		MV.setViewName("Usuarios"); 
		return MV;
		
	}
	
     
	@RequestMapping(value ="/eliminarUsuario.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView eliminarUsuario(Integer id, String nombreU, String passU){
		ModelAndView MV = new ModelAndView();
		usuarioService.eliminar(id);
		MV.addObject("listaUsuarios",this.usuarioService.obtenerAll());
		MV.setViewName("Usuarios"); 
		MV.addObject("Mensaje", "Usuario eliminado");
		return MV;
	}
	
	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer ssoId) {
		usuarioService.eliminar(ssoId);
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Usuarios");
		
		//Actualiza los usuarios
		MV.addObject("listaUsuarios",this.usuarioService.obtenerAll());
		MV.setViewName("Usuarios"); 
		return MV;
    }
	

 
	
	@RequestMapping(value ="/recargaGrillaUsuarios.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView recargarUsuario(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("listaUsuarios",this.usuarioService.obtenerAll());
		MV.setViewName("Usuarios"); 
		return MV;
		
	}
	
}
