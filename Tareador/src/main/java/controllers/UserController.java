package controllers;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Convert;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.spi.ConversionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
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
		MV.setViewName("Index"); 
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
		
		MV.addObject("departamentos", departamentoService.obtenerAll());
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
	 public void eliminarUsuario(@PathVariable Integer idUsuario) throws JsonParseException, JsonMappingException, IOException {

	usuarioService.bajaLogica(idUsuario);
	}
	
	@RequestMapping(value={ "/EditarUsuario-{idUsuario}" }, method= { RequestMethod.GET})

	 public ModelAndView editarUsuario(@PathVariable Integer idUsuario) throws JsonParseException, JsonMappingException, IOException {
 
 
		ModelAndView MV = new ModelAndView();

	    Usuario user =	usuarioService.obtenerById(idUsuario);
	    MV.addObject("idUsuario", idUsuario);
		MV.addObject("departamentos", departamentoService.obtenerAll());
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

		

		
		MV.setViewName("EditarUsuario"); 
		return MV;
	}
	
	@RequestMapping("IrListarUsuarios.html")
	public ModelAndView redireccionListarUsuarios(){
		ModelAndView MV = new ModelAndView();

		List<Usuario> userList = usuarioService.obtenerAll();
		MV.addObject("departamentos", departamentoService.obtenerAll());
		MV.addObject("tiposUsuario", tipoUsuarioService.obtenerAll());
		MV.addObject("usuarios", userList);
		
		MV.setViewName("ListarUsuario");
		return MV;
	}
	@RequestMapping("IrGestionarUsuario.html")
	public ModelAndView redireccionGestionarUsuario(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("GestionarUsuario");
		return MV;
	}
	
	
	
	
	//@RequestMapping(value ="/AgregarUsuario" , method= { RequestMethod.POST})
//	@ResponseBody
	//public   String AgregarUsuario(@RequestBody final Usuario user) {
//	public ModelAndView AgregarUsuario(String nombreU, String apellido, String contraseña, String correo,Integer idDepartamento, String departamento,String tipoUsuario, String idTipoUsuario ){
	
		
		@RequestMapping(value={"/AgregarUsuario"},method = RequestMethod.POST,  consumes  = "application/json")
	//	public ModelAndView AgregarUsuario(@RequestBody Usuario user) {			
			@ResponseBody public String searchAddress(HttpServletRequest request, HttpServletResponse response, @RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
			
			byte[] jsonData = userJson.toString().getBytes();

		        ObjectMapper mapper = new ObjectMapper();
		        Usuario usuario = mapper.readValue(jsonData, Usuario.class); 

		ModelAndView MV = new ModelAndView();
		
		String Message="";
		
		try{
			
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
	
		MV.setViewName("Usuarios");
		MV.addObject("Mensaje", Message);
		MV.addObject("listaUsuarios",this.usuarioService.obtenerAll());
		MV.setViewName("Usuarios"); 
		
	//	return MV;
		return "adads";
		
	}
		
		@RequestMapping(value={"/EditarUsuario"},method = RequestMethod.POST,  consumes  = "application/json")
	//	public ModelAndView AgregarUsuario(@RequestBody Usuario user) {			
			@ResponseBody public String editUser(HttpServletRequest request, HttpServletResponse response, @RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
			
			byte[] jsonData = userJson.toString().getBytes();

		        ObjectMapper mapper = new ObjectMapper();
		        Usuario usuario = mapper.readValue(jsonData, Usuario.class); 

		ModelAndView MV = new ModelAndView();
		
		String Message="";
		
		try{
			
			usuarioService.actualizar(usuario);
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
		
	//	return MV;
		return "adads";
		
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
	
	@RequestMapping(value ="IngresoUsuario.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView validarUsuario(String nombreU, String passU){
		ModelAndView MV = new ModelAndView();

		boolean flagname = false;
		boolean flagpass = false;
		Usuario x = new Usuario();
		x.setNombre(nombreU);
		x.setContrasenia(passU);
		String Message="";
		ArrayList<Usuario> listausuarios = usuarioService.obtenerAll();

		
		

		
		int cantidad = listausuarios.size();
		Integer cant = cantidad;
		Message = listausuarios.get(4).getNombreUsuario();
		
	    for(int n=0;n<listausuarios.size();n++) {
	    	if (listausuarios.get(n).getNombreUsuario().compareTo(nombreU) == 0) {
	    		if(listausuarios.get(n).getContrasenia().compareTo(passU) == 0) {
	    			flagpass = true;
	    		}
	    		flagname = true;
	    		x.setIdUsuario(listausuarios.get(n).getIdUsuario());
	    	}


	      }
		if (flagpass) {
			
		
			try{
				x = usuarioService.obtenerById(x.getIdUsuario());
				//Message = "bien";
				MV.setViewName("userin");
				MV.addObject("Mensaje", Message);
				MV.addObject("Usuario",x);
				MV.setViewName("userin"); 
				MV.addObject("Sessuser",x.getNombreUsuario());
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

		List <Proyecto> lstProy = new ArrayList<Proyecto>();
		ModelAndView MV = new ModelAndView();
		Proyecto proy = proyectoServicio.obtenerById(idProyecto);
	    Usuario user =	usuarioService.obtenerById(idUsuario);
	    lstProy = user.getLsProyectos();
	    lstProy.add(proy);
	    //idProyecto = lstProy.size();
	    
	    //user.setLsProyectos(lstProy);
	    user.setApellido("hola");
	    usuarioService.actualizar(user);
		try{
			
		}
		catch(Exception e)
		{
			//Message = "No se pudo insertar el usuario";
		}
	    
	    
	    String usuario = idUsuario.toString();
	    String proyecto = idProyecto.toString();
	    MV.addObject("idUsuario", idUsuario);
		MV.addObject("departamentos", departamentoService.obtenerAll());
		MV.addObject("tiposUsuario", tipoUsuarioService.obtenerAll());
		MV.addObject("nombre", idUsuario);
		MV.addObject("apellido", idProyecto);
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

		

		
		MV.setViewName("EditarUsuario"); 
		return MV;
	}
	
}
