package controllers;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Convert;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.exception.spi.ConversionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.cloudinary.Search;

import dominio.*;

import servicio.*;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.codehaus.jettison.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@SessionAttributes("Sessuser")
public class UserController {
	
	@Autowired
	public  UsuarioServicio usuarioService;
	
	@Autowired
	public  DepartamentoServicio departamentoService;
	
	@Autowired
	public  TipoUsuarioServicio tipoUsuarioService;
	

	@Autowired
	public ProyectoServicio proyectoServicio;
	
	@Autowired
	public RolServicio rolServicio;

//	public void init(ServletConfig config) {
//		ApplicationContext ctx = WebApplicationContextUtils
//				.getRequiredWebApplicationContext(config.getServletContext());
//		
//		this.service = (UsuarioServicio) ctx.getBean("serviceBean");
//	}
//	
	
	
	//Inicio
	
	@RequestMapping(value={"Index.html"})
	public ModelAndView redireccion(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Index"); 
		return MV;
	}
	@RequestMapping(value={"Inicio.html"})
	public ModelAndView redireccionUserIn(  @SessionAttribute("Sessuser") Usuario userSession){
		ModelAndView MV = new ModelAndView();
		
		
		MV.setViewName("userin");
		MV.addObject("nombre", userSession.getNombreUsuario());
		MV.addObject("Usuario",userSession);
		MV.setViewName("userin");
			
		asignarRolesParaUsuario(MV, userSession);
		 
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
		
		MV.addObject("departamentos", departamentoService.obtenerAllActivos());
		MV.addObject("tiposUsuario", tipoUsuarioService.obtenerAll());

		
		MV.setViewName("AltaUsuario"); 
		return MV;
	}
	@RequestMapping("IrAdministrarUsuarios.html")
	public ModelAndView redireccionAdministrarUsuario(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AdministrarUsuarios"); 
		return MV;
	}
	
	@RequestMapping(value={ "/EliminarUsuario-{idUsuario}" }, method= { RequestMethod.GET})
	 public ModelAndView eliminarUsuario(@PathVariable Integer idUsuario , @SessionAttribute("Sessuser") Usuario userSession) throws JsonParseException, JsonMappingException, IOException {
		ModelAndView MV = new ModelAndView();
	usuarioService.bajaLogica(idUsuario);
	Set<Usuario> userList = usuarioService.obtenerAllActivos();
	MV.addObject("departamentos", departamentoService.obtenerAllActivos());
	MV.addObject("tiposUsuario", tipoUsuarioService.obtenerAll());
	MV.addObject("usuarios", userList);	
	
	asignarRolesParaUsuario(MV, userSession);
	
	MV.setViewName("ListarUsuario");
	return MV;
	}
	
	@RequestMapping(value={ "/EditarUsuario-{idUsuario}" }, method= { RequestMethod.GET})

	 public ModelAndView editarUsuario(@PathVariable Integer idUsuario, @SessionAttribute("Sessuser") Usuario userSession) throws JsonParseException, JsonMappingException, IOException {
 
 
		ModelAndView MV = new ModelAndView();

	    Usuario user =	usuarioService.obtenerById(idUsuario);
	    MV.addObject("idUsuario", idUsuario);
		MV.addObject("departamentos", departamentoService.obtenerAllActivos());
		MV.addObject("tiposUsuario", tipoUsuarioService.obtenerAll());
		MV.addObject("nombre", user.getNombre());
		MV.addObject("apellido", user.getApellido());
		MV.addObject("email", user.getEmail());
		MV.addObject("contrasenia", user.getContrasenia());
		MV.addObject("nombreUsuario", user.getNombreUsuario());
		
		if(user.getDepartamento() != null) {
			MV.addObject("idDepartamento", user.getDepartamento().getIdDepartamento());
			MV.addObject("nombreDepartamento", user.getDepartamento().getDescripcion());
		}
	
		if(user.getTipoUsuario() !=null) {
			MV.addObject("idTipo", user.getTipoUsuario().getIdTipoUsuario());
			MV.addObject("descripcionTipo", user.getTipoUsuario().getDescripcion());

			}

//		if(user.getLsProyectos() != null)
//		{
//			for(Proyecto p : user.getLsProyectos())
//				System.out.println(p.getDescripcion());
//		}
//		
//		if(user.getLsRoles() != null)
//		{
//			for(Rol r : user.getLsRoles())
//				System.out.println(r.getDescripcion());
//		}
//		
		asignarRolesParaUsuario(MV, userSession);
		
		MV.setViewName("EditarUsuario"); 
		return MV;
	}
	
	@RequestMapping("IrListarUsuarios.html")
	public ModelAndView redireccionListarUsuarios( @SessionAttribute("Sessuser") Usuario userSession){
		
		ModelAndView MV = new ModelAndView();

		Set<Usuario> userList = usuarioService.obtenerAllActivos();
		MV.addObject("departamentos", departamentoService.obtenerAllActivos());
		MV.addObject("tiposUsuario", tipoUsuarioService.obtenerAll());
		MV.addObject("usuarios", userList);
		
		asignarRolesParaUsuario(MV, userSession);
		
		if(userSession.getTipoUsuario().getIdTipoUsuario().equals(TipoUsuario.tipo_user))
			MV.setViewName("forward:/Inicio.html"); 
		else
			MV.setViewName("ListarUsuario");
		
		
		return MV;
	}
	@RequestMapping(value= "IrListarUsuariosMensaje.html" ,method= { RequestMethod.POST})
	public ModelAndView redireccionListarUsuarios(String Mensaje ,  @SessionAttribute("Sessuser") Usuario userSession){
		ModelAndView MV = new ModelAndView();

		Set<Usuario> userList = usuarioService.obtenerAllActivos();
		MV.addObject("departamentos", departamentoService.obtenerAllActivos());
		MV.addObject("tiposUsuario", tipoUsuarioService.obtenerAll());
		MV.addObject("usuarios", userList);
		MV.addObject("Mensaje", Mensaje);
		
		asignarRolesParaUsuario(MV, userSession);
		
		MV.setViewName("ListarUsuario");
		return MV;
	}
	
	@RequestMapping("IrGestionarUsuario.html")
	public ModelAndView redireccionGestionarUsuario(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("GestionarUsuario");
		return MV;
	}
	
	

		@RequestMapping(value={"/AgregarUsuario"},method = RequestMethod.POST,  consumes  = "application/json")
	//	public ModelAndView AgregarUsuario(@RequestBody Usuario user) {			
			 
			public @ResponseBody String searchAddress(HttpServletRequest request, HttpServletResponse response, @RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
			
			byte[] jsonData = userJson.toString().getBytes();

		        ObjectMapper mapper = new ObjectMapper();
		        Usuario usuario = mapper.readValue(jsonData, Usuario.class); 

		//ModelAndView MV = new ModelAndView();
		
		String Message="";
		
		try{
			if(usuario.getDepartamento()!= null && usuario.getDepartamento().getIdDepartamento() == 0)
				usuario.setDepartamento(null);
				
			usuarioService.insertar(usuario);
			Message = "Usuario agregado";
		}
		catch(Exception e)
		{
			Message = "No se pudo insertar el usuario";
		}
		finally
		{
		
		}
	
//		MV.setViewName("Usuarios");
//		MV.addObject("Mensaje", Message);
//		MV.addObject("listaUsuarios",this.usuarioService.obtenerAll());
//		MV.setViewName("Usuarios"); 
//		
	//	return MV;
		return Message;
		//return redireccionListarUsuarios(Message);
		
	}
		
		@RequestMapping(value={"/EditarUsuario"},method = RequestMethod.POST,  consumes  = "application/json")
	//	public ModelAndView AgregarUsuario(@RequestBody Usuario user) {			
			
			public @ResponseBody String editUser(HttpServletRequest request, HttpServletResponse response, @RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
			
			byte[] jsonData = userJson.toString().getBytes();

		        ObjectMapper mapper = new ObjectMapper();
		        Usuario usuario = mapper.readValue(jsonData, Usuario.class); 

		        Usuario usuarioAEditar = usuarioService.obtenerById(usuario.getIdUsuario());
		        
		        		        
		        usuarioAEditar.setApellido(usuario.getApellido());
		        usuarioAEditar.setNombre(usuario.getNombre());
		        usuarioAEditar.setEmail(usuario.getEmail());
		        usuarioAEditar.setIsActivo(usuario.getIsActivo());
		        usuarioAEditar.setContrasenia(usuario.getContrasenia());
		        
		        if(usuario.getDepartamento() != null || usuario.getDepartamento().getIdDepartamento()> 0) {
		        	Departamento dep=	departamentoService.obtenerById(usuario.getDepartamento().getIdDepartamento());
		        	usuarioAEditar.setDepartamento(dep);
		        }
		        else {
		        	usuarioAEditar.setDepartamento(null);	
		        }
//		        
//		        if(usuarioAEditar.getDepartamento().getIdDepartamento() != usuario.getDepartamento().getIdDepartamento()) {
//		        	Departamento dep=	departamentoService.obtenerById(usuario.getDepartamento().getIdDepartamento());
//		        	usuarioAEditar.setDepartamento(dep);
//		        }
//		        	
		        if(usuarioAEditar.getTipoUsuario().getIdTipoUsuario() != usuario.getTipoUsuario().getIdTipoUsuario() ) {
		        	TipoUsuario tipo= tipoUsuarioService.obtenerById(usuario.getTipoUsuario().getIdTipoUsuario());
					usuarioAEditar.setTipoUsuario(tipo);
		        }
	        	
		        
				
				String Message="";
		
		try{
			
			usuarioService.actualizar(usuarioAEditar);
			Message = "Usuario agregado";
		}
		catch(Exception e)
		{
			Message = "No se pudo insertar el usuario";
		}
		finally
		{
		
		}

//		ModelAndView MV = new ModelAndView();
//		MV.addObject("Mensaje", Message);
//		MV.setViewName("forward:/IrListarUsuariosMensaje.html");
//		return MV;
		return Message;
		
	}
	
	
	
     
//	@RequestMapping(value ="/eliminarUsuario.html" , method= { RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView eliminarUsuario(Integer id, String nombreU, String passU){
//		ModelAndView MV = new ModelAndView();
//		usuarioService.eliminar(id);
//		MV.addObject("listaUsuarios",this.usuarioService.obtenerAllActivos());
//		MV.setViewName("Usuarios"); 
//		MV.addObject("Mensaje", "Usuario eliminado");
//		return MV;
//	}
//	
//	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
//    public ModelAndView deleteUser(@PathVariable Integer ssoId) {
//		usuarioService.eliminar(ssoId);
//		ModelAndView MV = new ModelAndView();
//		MV.setViewName("Usuarios");
//		
//		//Actualiza los usuarios
//		MV.addObject("listaUsuarios",this.usuarioService.obtenerAllActivos());
//		MV.setViewName("Usuarios"); 
//		return MV;
//    }
//	
//
// 
//	
//	@RequestMapping(value ="/recargaGrillaUsuarios.html" , method= { RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView recargarUsuario(){
//		ModelAndView MV = new ModelAndView();
//		MV.addObject("listaUsuarios",this.usuarioService.obtenerAllActivos());
//		MV.setViewName("Usuarios"); 
//		return MV;
//		
//	}
	
	@RequestMapping(value ="IngresoUsuario.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView validarUsuario(String nombreU, String passU, @SessionAttribute("Sessuser") Usuario userSession){
		ModelAndView MV = new ModelAndView();

		boolean flagname = false;
		boolean flagpass = false;
		Usuario x = new Usuario();
		x.setNombre(nombreU);
		x.setContrasenia(passU);
		String Message="";
		HashSet<Usuario> listausuarios =  (HashSet<Usuario>)usuarioService.obtenerAllActivos();

		
		for(Usuario user : listausuarios) {
			if (user.getNombreUsuario().compareTo(nombreU) == 0) {
	    		if(user.getContrasenia().compareTo(passU) == 0) {
	    			flagpass = true;
	    		}
	    		flagname = true;
	    		x.setIdUsuario(user.getIdUsuario());
	    	}


		}
		
//	    for(int n=0;n<listausuarios.size();n++) {
//	    	if (listausuarios.get(n).getNombreUsuario().compareTo(nombreU) == 0) {
//	    		if(listausuarios.get(n).getContrasenia().compareTo(passU) == 0) {
//	    			flagpass = true;
//	    		}
//	    		flagname = true;
//	    		x.setIdUsuario(listausuarios.get(n).getIdUsuario());
//	    	}
//
//
//	      }
		if (flagpass) {
			
		
			try{
				x = usuarioService.obtenerById(x.getIdUsuario());
				//Message = "bien";
				MV.setViewName("userin");
				MV.addObject("nombre", x.getNombreUsuario());
				MV.addObject("Usuario",x);
				MV.setViewName("userin");
				MV.addObject("Sessuser",x);
				
				
				asignarRolesParaUsuario(MV, x);
			
				
			}
			catch(Exception e)
			{
				//Message = "No se pudo insertar el usuario";
			}
			finally
			{
			
			}
		}
		else {
			//Message = "Usuario incorrecto";
			MV.setViewName("login");
			MV.addObject("Mensaje", Message);
			MV.addObject("Usuario",x);
			MV.setViewName("login"); 
			
		}
		
		return MV;
	}
	@RequestMapping(value={ "AgregarProyectoUsuario.html" }, method= { RequestMethod.GET,RequestMethod.POST})

	 public ModelAndView agregarProyectoUsuario(Integer idUsuario, Integer idProyecto){

		Set <Proyecto> lstProy = new HashSet<Proyecto>();
		ModelAndView MV = new ModelAndView();
		Proyecto proy = proyectoServicio.obtenerById(idProyecto);
	    Usuario user =	usuarioService.obtenerById(idUsuario);
	    lstProy = user.getLsProyectos();
	    lstProy.add(proy);
	    //idProyecto = lstProy.size();
	    
	    //user.setLsProyectos(lstProy);
	    
		try{
			usuarioService.actualizar(user);
		}
		catch(Exception e)
		{
			//Message = "No se pudo insertar el usuario";
		}
	    
	    
	    String usuario = idUsuario.toString();
	    String proyecto = idProyecto.toString();
		
		MV.setViewName("forward:/IrListarProyectos.html"); 
		return MV;
	}
	
	@RequestMapping(value={ "AgregarProyectoRol.html" }, method= { RequestMethod.GET,RequestMethod.POST})

	 public ModelAndView agregarProyectoRol(Integer idUsuario, Integer idRol){

		Set <Rol> lstProy = new HashSet<Rol>();
		ModelAndView MV = new ModelAndView();
		Rol proy = rolServicio.obtenerById(idRol);
	    Usuario user =	usuarioService.obtenerById(idUsuario);
	    lstProy = user.getLsRoles();
	    lstProy.add(proy);
	    //idProyecto = lstProy.size();
	    
	    //user.setLsProyectos(lstProy);
	    
		try{
			usuarioService.actualizar(user);
		}
		catch(Exception e)
		{
			//Message = "No se pudo insertar el usuario";
		}
	    
		
		MV.setViewName("forward:/IrListarRoles.html"); 
		return MV;
	}
	
	@RequestMapping(value={ "CerrarSesion.html" }, method= { RequestMethod.GET,RequestMethod.POST})

	 public ModelAndView cerrarSession(@SessionAttribute("Sessuser") Usuario userSession , WebRequest request, SessionStatus status){


		ModelAndView MV = new ModelAndView();
		userSession = null;
		
		status.setComplete();
	    request.removeAttribute("Sessuser", WebRequest.SCOPE_SESSION);
		
		
		MV.setViewName("forward:/Index.html"); 
		return MV;
	}
	
	@ModelAttribute("Sessuser")
	 public Usuario usuarioSession() {
		return new Usuario();
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
