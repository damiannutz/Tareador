package controllers;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dominio.*;
import servicio.DepartamentoServicio;
import servicio.EstadoTareaServicio;
import servicio.PrioridadServicio;
import servicio.ProyectoServicio;
import servicio.RolServicio;
import servicio.TipoTareaServicio;
import servicio.TipoUsuarioServicio;
import servicio.UsuarioServicio;

@Controller
public class GeneralController {

	@Autowired
	public DepartamentoServicio departamentoServicio;
	
	@Autowired
	public EstadoTareaServicio estadoTareaServicio;
	
	@Autowired
	public PrioridadServicio prioridadServicio;
	
	@Autowired
	public ProyectoServicio proyectoServicio;
	
	@Autowired
	public RolServicio rolServicio;
	
	@Autowired
	public TipoTareaServicio tipoTareaServicio;
	
	@Autowired
	public TipoUsuarioServicio tipoUsuarioServicio;
	
	@Autowired
	public UsuarioServicio usuarioServicio;
	
	@RequestMapping("Inicializacion.html" )
	public ModelAndView inicializar() {
		
		revisarSiSeCreoTodo();
		ModelAndView MV = new ModelAndView();
		MV.setViewName("forward:/Index.html");
		return MV;
		
	}
	
	private void revisarSiSeCreoTodo() {
	
		try {
			List<TipoUsuario> lstTiposUsuario = tipoUsuarioServicio.obtenerAll();
			
			if(lstTiposUsuario == null || lstTiposUsuario.size() == 0)
				crearTodo();
			
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	private void crearTodo() {
		List<TipoUsuario> lstTiposUsuario = insertTiposUsuarios();
		List<Prioridad> lstPrioridades = insertPrioridades();
		List<Rol> lstRoles =  insertRoles();
		List<Departamento> lstDepartamentos =  insertDepartamentos();
		List<Proyecto> lstProyectos = insertProyectos(lstDepartamentos);
		insertEstadosTareas(lstDepartamentos);
		insertTipoTareas(lstDepartamentos);
		insertUsuarios(lstDepartamentos,lstTiposUsuario,lstRoles,lstProyectos);


	}
	
	private List<TipoUsuario> insertTiposUsuarios() {

		
		List<TipoUsuario> lstTipoUsuarios = new ArrayList<TipoUsuario>();		
		
		lstTipoUsuarios.add(new TipoUsuario(TipoUsuario.tipo_super , "Super Usuario"));
		lstTipoUsuarios.add(new TipoUsuario(TipoUsuario.tipo_admin , "Administrador"));
		lstTipoUsuarios.add(new TipoUsuario(TipoUsuario.tipo_user , "Usuario"));
		
		for(TipoUsuario item : lstTipoUsuarios){
			tipoUsuarioServicio.insertar(item);
		}

		return lstTipoUsuarios;
	}
	

	private  List<Prioridad>  insertPrioridades() {

		List<Prioridad> lstPrioridades = new ArrayList<Prioridad>();
		lstPrioridades.add(new Prioridad(Prioridad.P_Muy_Baja,"Muy Baja",true));
		lstPrioridades.add(new Prioridad(Prioridad.P_Baja,"Baja",true));
		lstPrioridades.add(new Prioridad(Prioridad.P_Media,"Media",true));
		lstPrioridades.add(new Prioridad(Prioridad.P_Alta,"Alta",true));
		lstPrioridades.add(new Prioridad(Prioridad.P_Muy_Alta,"Muy Alta",true));
		
		for(Prioridad item : lstPrioridades){
				prioridadServicio.insertar(item);
		}
		
		return lstPrioridades;
		
	}

	private  List<Rol> insertRoles() {

		
		List<Rol> lstRoles = new ArrayList<Rol>();
		
		lstRoles.add(new Rol(null,Rol.rol_nueva_tarea , "Crear nuevas tareas", true));
		lstRoles.add(new Rol(null,Rol.rol_editar_tarea , "Editar tareas", true));
		lstRoles.add(new Rol(null,Rol.rol_eliminar_tarea , "Borrar tareas", true));
		lstRoles.add(new Rol(null,Rol.rol_comentar_tarea , "Comentar tareas", true));
		
		lstRoles.add(new Rol(null,Rol.rol_adm_tipos_tarea , "Administrar tipos de tareas", true));
		lstRoles.add(new Rol(null,Rol.rol_adm_estados_tarea , "Administrar estados de tareas", true));
		lstRoles.add(new Rol(null,Rol.rol_adm_usuarios_x_proyectos , "Administrar usuarios por proyectos", true));
		lstRoles.add(new Rol(null,Rol.rol_adm_usuarios , "Administrar usuarios", true));
		lstRoles.add(new Rol(null,Rol.rol_adm_proyectos , "Administrar proyectos", true));
		lstRoles.add(new Rol(null,Rol.rol_adm_departamentos , "Administrar departamentos", true));

		for(Rol item : lstRoles){
				rolServicio.insertar(item);
		}
				
		return lstRoles;
	}
	
	
	private  List<Departamento> insertDepartamentos() {
		
		List<Departamento> lstDepartamentos = new ArrayList<Departamento>();

		lstDepartamentos.add(new Departamento(null,"IT", "Sistemas" ,true));
		lstDepartamentos.add(new Departamento(null,"RRHH", "Recursos Humanos" ,true));
		lstDepartamentos.add(new Departamento(null,"DEV" , "Desarrollo" ,true));
		
		for(Departamento item : lstDepartamentos) {
				departamentoServicio.insertar(item);
				
		}
		
		return lstDepartamentos;
	}
	
	
	private List<EstadoTarea> insertEstadosTareas(List<Departamento> lstDepartamentos) {

		List<EstadoTarea> lstEstadosTareas = new ArrayList<EstadoTarea>();
		lstEstadosTareas.add(new EstadoTarea(null,    "Creacion",  true,  true,  false,  null)); //primera por defecto, para todos los departamentos
		lstEstadosTareas.add(new EstadoTarea(null,    "En Ejecucion",  true,  false,  false,  null));//para todos los departamentos
		lstEstadosTareas.add(new EstadoTarea(null,    "En Revision",  true,  false,  false,  null));//para todos los departamentos
		lstEstadosTareas.add(new EstadoTarea(null,    "Finalizada",  true,  false,  true,  null)); //ultima por defecto, para todos los departamentos
		lstEstadosTareas.add(new EstadoTarea(null,    "Para publicar",  true,  false,  false,  lstDepartamentos.stream().filter(r-> r.getCodigo().equals("DEV")).findFirst().get()));//solo para desarrollo
		
		for(EstadoTarea item : lstEstadosTareas){
				estadoTareaServicio.insertar(item);
		}

		return lstEstadosTareas;
	}

	private  List<TipoTarea>  insertTipoTareas(List<Departamento> lstDepartamentos) {


		List<TipoTarea> lstTiposTareas = new ArrayList<TipoTarea>();
		lstTiposTareas.add(new TipoTarea(null,"Nueva",true,null));//aplica a todos los departamentos
		lstTiposTareas.add(new TipoTarea(null,"Modificacion",true,null));//aplica a todos los departamentos
		lstTiposTareas.add(new TipoTarea(null,"Error",true,null));//aplica a todos los departamentos
		lstTiposTareas.add(new TipoTarea(null,"Soporte",true,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("IT")).findFirst().get()));//aplica a departamento IT
		
		for(TipoTarea item : lstTiposTareas){
				tipoTareaServicio.insertar(item);
		}
		
		return lstTiposTareas;

	}

	

	private  List<Proyecto> insertProyectos(List<Departamento> lstDepartamentos) {

		List<Proyecto> lstProyectos = new ArrayList<Proyecto>();
		lstProyectos.add(new Proyecto(null,"Proyecto IT 1",true,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("IT")).findFirst().get()));
		lstProyectos.add(new Proyecto(null,"Proyecto IT 2",true,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("IT")).findFirst().get()));
		lstProyectos.add(new Proyecto(null,"Proyecto DEV 1",true,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("DEV")).findFirst().get()));
		lstProyectos.add(new Proyecto(null,"Proyecto DEV 2",true,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("DEV")).findFirst().get()));
		lstProyectos.add(new Proyecto(null,"Proyecto RRHH",true,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("RRHH")).findFirst().get()));
		
		for(Proyecto item : lstProyectos){
				proyectoServicio.insertar(item);
		}

		return lstProyectos;
	}


	private  List<Usuario> insertUsuarios(List<Departamento> lstDepartamentos, List<TipoUsuario> lstTipoUsuarios,
			List<Rol> lstRoles, List<Proyecto> lstProyectos) {

		List<Usuario> lstUsuarios = creacionUsuarios(lstTipoUsuarios,lstDepartamentos,lstRoles,lstProyectos);
			
		for(Usuario item : lstUsuarios){
				usuarioServicio.insertar(item);
		}

		return lstUsuarios;
		
	}
	
	
	
	private  List<Usuario> creacionUsuarios(List<TipoUsuario> lstTiposUsuario , List<Departamento> lstDepartamentos , List<Rol> lstRoles , List<Proyecto> lstProyectos){
		
		List<Usuario> lstUsuario = new ArrayList<Usuario>();
		
		//super administradores
//		
//		
//		Usuario useraa = new Usuario(null, "juan"	, "santoro", "santoro@mail.com"	
//				, "juanisantoro"	, "1234"	, true
//				, lstDepartamentos.stream().filter(r-> r.getCodigo().equals("IT")).findFirst().get()	
//				, lstTiposUsuario.stream().filter(r-> r.getIdTipoUsuario().equals(TipoUsuario.tipo_super)).findFirst().get()
//				, null
//				, lstRoles);
		
		lstUsuario.add(new Usuario(null,"juan"		 			//nombre
				,"santoro"				//apellido
				,"santoro@mail.com"		//mail
				,"juanisantoro"			//nombre usuario
				,"1234"					//contraseña	
				,true					//isActivo
				,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("IT")).findFirst().get()				//Departamento
				,lstTiposUsuario.stream().filter(r-> r.getIdTipoUsuario().equals(TipoUsuario.tipo_super)).findFirst().get()//tipoUsuario
				,null
				,lstRoles
				));
		

		lstUsuario.add(new Usuario(null,"damian" 		//nombre
				,"nutz"				//apellido
				,"damian@mail.com"		//mail
				,"damiannutz"			//nombre usuario
				,"1234"					//contraseña	
				,true					//isActivo
				,null//,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("IT")).findFirst().get()				//Departamento
				,lstTiposUsuario.stream().filter(r-> r.getIdTipoUsuario().equals(TipoUsuario.tipo_super)).findFirst().get() //tipoUsuario	
				,null
				,lstRoles
				));
		
		lstUsuario.add(new Usuario(null,"pedro" 		//nombre
				,"mastroberti"				//apellido
				,"pedro@mail.com"		//mail
				,"pedromastroberti"			//nombre usuario
				,"1234"					//contraseña	
				,true					//isActivo
				,null//,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("IT")).findFirst().get()				//Departamento
				,lstTiposUsuario.stream().filter(r-> r.getIdTipoUsuario().equals(TipoUsuario.tipo_super)).findFirst().get() //tipoUsuario
				,null
				,lstRoles
				));
				
		lstUsuario.add(new Usuario(null,"ADMIN" 		//nombre
				,"ADMIN"				//apellido
				,"admin@mail.com"		//mail
				,"admin"			//nombre usuario
				,"1234"					//contraseña	
				,true					//isActivo
				,null//,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("IT")).findFirst().get()				//Departamento
				,lstTiposUsuario.stream().filter(r-> r.getIdTipoUsuario().equals(TipoUsuario.tipo_admin)).findFirst().get() //tipoUsuario	
				,null
				,lstRoles
				)); 
		
		lstUsuario.add(new Usuario(null,"USUARIO_1_IT" 		//nombre
				,"USUARIO_1_IT"				//apellido
				,"USUARIO_1_IT@mail.com"		//mail
				,"USUARIO_1_IT"			//nombre usuario
				,"1234"					//contraseña	
				,true					//isActivo
				,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("IT")).findFirst().get()				//Departamento
				,lstTiposUsuario.stream().filter(r-> r.getIdTipoUsuario().equals(TipoUsuario.tipo_super)).findFirst().get() //tipoUsuario
				,lstProyectos.stream().filter(r-> r.getDescripcion().contains("Proyecto IT")).collect(Collectors.toList())
				,lstRoles.stream().filter(r-> !r.getCodigo().contains("ADM")).collect(Collectors.toList()) //roles usuarios basicos
				));

		
		lstUsuario.add(new Usuario(null,"USUARIO_2_IT" 		//nombre
				,"USUARIO_2_IT"				//apellido
				,"USUARIO_2_IT@mail.com"		//mail
				,"USUARIO_2_IT"			//nombre usuario
				,"1234"					//contraseña	
				,true					//isActivo
				,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("IT")).findFirst().get()					//Departamento
				,lstTiposUsuario.stream().filter(r-> r.getIdTipoUsuario().equals(TipoUsuario.tipo_super)).findFirst().get() //tipoUsuario	
				,lstProyectos.stream().filter(r-> r.getDescripcion().equalsIgnoreCase("Proyecto IT 2")).collect(Collectors.toList())
				,lstRoles.stream().filter(r-> !r.getCodigo().contains("ADM")).collect(Collectors.toList())
				));
	
		lstUsuario.add(new Usuario(null,"USUARIO_1_DEV" 		//nombre
				,"USUARIO_1_DEV"				//apellido
				,"USUARIO_1_DEV@mail.com"		//mail
				,"USUARIO_1_DEV"			//nombre usuario
				,"1234"					//contraseña	
				,true					//isActivo
				,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("DEV")).findFirst().get()					//Departamento
				,lstTiposUsuario.stream().filter(r-> r.getIdTipoUsuario().equals(TipoUsuario.tipo_super)).findFirst().get() //tipoUsuario	
				,lstProyectos.stream().filter(r-> r.getDescripcion().contains("Proyecto DEV")).collect(Collectors.toList())
				,lstRoles.stream().filter(r-> !r.getCodigo().contains("ADM")).collect(Collectors.toList())
				));
		
		lstUsuario.add(new Usuario(null,"USUARIO_2_DEV" 		//nombre
				,"USUARIO_2_DEV"				//apellido
				,"USUARIO_2_DEV@mail.com"		//mail
				,"USUARIO_2_DEV"			//nombre usuario
				,"1234"					//contraseña	
				,true					//isActivo
				,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("DEV")).findFirst().get()					//Departamento
				,lstTiposUsuario.stream().filter(r-> r.getIdTipoUsuario().equals(TipoUsuario.tipo_super)).findFirst().get() //tipoUsuario
				,lstProyectos.stream().filter(r-> r.getDescripcion().equalsIgnoreCase("Proyecto DEV 1")).collect(Collectors.toList())
				,lstRoles.stream().filter(r-> !r.getCodigo().contains("ADM")).collect(Collectors.toList())
				));
	
		lstUsuario.add(new Usuario(null,"USUARIO_1_RRHH" 		//nombre
				,"USUARIO_1_RRHH"				//apellido
				,"USUARIO_1_RRHH@mail.com"		//mail
				,"USUARIO_1_RRHH"			//nombre usuario
				,"1234"					//contraseña	
				,true					//isActivo
				,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("RRHH")).findFirst().get()					//Departamento
				,lstTiposUsuario.stream().filter(r-> r.getIdTipoUsuario().equals(TipoUsuario.tipo_super)).findFirst().get() //tipoUsuario	
				,lstProyectos.stream().filter(r-> r.getDescripcion().contains("Proyecto RRHH")).collect(Collectors.toList())
				,lstRoles.stream().filter(r-> !r.getCodigo().contains("ADM")).collect(Collectors.toList())
				));
	
		lstUsuario.add(new Usuario(null,"USUARIO_2_RRHH" 		//nombre
				,"USUARIO_2_RRHH"				//apellido
				,"USUARIO_2_RRHH@mail.com"		//mail
				,"USUARIO_2_RRHH"			//nombre usuario
				,"1234"					//contraseña	
				,true					//isActivo
				,lstDepartamentos.stream().filter(r-> r.getCodigo().equals("RRHH")).findFirst().get()					//Departamento
				,lstTiposUsuario.stream().filter(r-> r.getIdTipoUsuario().equals(TipoUsuario.tipo_super)).findFirst().get() //tipoUsuario	
				,lstProyectos.stream().filter(r-> r.getDescripcion().equalsIgnoreCase("Proyecto RRHH")).collect(Collectors.toList())
				,lstRoles.stream().filter(r-> !r.getCodigo().contains("ADM")).collect(Collectors.toList())
				));
		
		return lstUsuario;
		
	}
	
	
	
	
	
	
	
	
	
	
}
