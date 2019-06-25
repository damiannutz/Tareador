<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>TAREADOR</title>

<style type="text/css">
	<%@ include file="Recursos/bootstrap.min.css" %>
	<%@ include file="Recursos/font-awesome.min.css" %>
	<%@ include file="Recursos/css1.css" %>
	<%@ include file="Recursos/css2.css" %>
	<%@ include file="Recursos/magnific-popup.css" %>
	<%@ include file="Recursos/creative.min.css" %>


</style>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Registration</title>
<script type="text/javascript" src="${jsURL}">
</script>





    
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<style>

input:invalid, textarea:invalid {
  background: 	#FFB6C1;
}
</style>

<body id="page-top">


    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="Index.jsp">Tareador</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                	<li>
             <a    class="page-scroll" href="<c:url value='/IrAdministrarUsuarios.html' />"  >VOLVER</a>
                	
                    </li>
                    <li>
                        <a class="page-scroll" href="#about">userName</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="Login?CerrarSesion=1">Cerrar Sesion</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <h1 id="homeHeading">Editar Usuario</h1>
                <hr>
                <!--   <a href="ListarUsuarios.jsp" class="btn btn-primary btn-xl page-scroll">LISTA DE USUARIOS</a><br><br><br>-->
                          <a class="btn btn-primary btn-xl page-scroll" href="<c:url value='/IrListarUsuarios.html' />"  >LISTA DE USUARIOS</a><br><br><br>
                
			
			<div align="center">
			<h3 id="homeHeading">   </h3>
						
					<table>
					
						<tr>
			
						<td>
			
						<form method="post" action="UsuariosTareadorServlet?UserIdGestionado=">
						
						<tr>
						<td>Nombre:</td>
						<td><input maxlength="30" type="text" value="<c:out value="${ nombre.toString() }" />" style=" color: black " size="20" required="required" id="inputNombre" name="nombre"></td>
						</tr>
						<tr>
						<td>Apellido:</td>
						<td><input maxlength="30" type="text" value="<c:out value="${ apellido.toString() }" />" style=" color: black " size="20" required="required" id="inputApellido" name="apellido"></td>
						</tr>
						<tr>
						<td>Correo:</td>
						<td><input id="inputCorreo" maxlength="40" type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Mail invalido" size="20"  value="<c:out value="${ email.toString() }"/>" style=" color: black " required="required" name="correo"></td>
						</tr>
						<tr>
						<td>Usuario:</td>
						<td><input id="inputUsuario"  pattern="^[A-Za-z][A-Za-z0-9._%+-]*$" title="No se permiten espacios"   maxlength="30" type="text" size="20"  value="<c:out value="${ nombreUsuario.toString() }" />"  style=" color: black " required="required" name="usuario"></td>
<!-- 						  pattern="^[A-Za-z][A-Za-z0-9]*$" -->
						</tr>
						<tr>
						<td>Contraseña:</td>
						<td><input maxlength="25"  value="<c:out value="${ contrasenia.toString() }" />" id="inputPassword" pattern=".{6,}" title="Seis o mas caracteres" type="password"  style=" color: black " required="required" size="20" name="contrasenia" /></td>
						</tr>
												
						
						<tr>
						<td style="padding-top:5px; padding-bottom:5px;">Departamento:</td>
							<td style="padding-top:5px; padding-bottom:5px;">
								<select  id="cmbDepartamento" name="cmTipoUsuario" required="required" class="btn btn-info dropdown-toggle">
								

											   <option id="selectedDep"  value="<c:out value="${ idDepartamento.toString() }" />" value="${idDepartamento}" selected="selected"><c:out value="${ nombreDepartamento.toString() }" /></option>
										
							<c:forEach items="${departamentos}" var="item">
								
								
								<option value="${item.idDepartamento}" >${item.descripcion}</option>
								
								
								
							
							</c:forEach>
									
						
							</select> 	
							</td>
						</tr>
						<tr >
						<td style="padding-top:5px; padding-bottom:5px;">Tipo de usuario:</td>
						<td style="padding-top:5px; padding-bottom:5px;">
						
						
						<select  id="cmbTipoUsuario" name="cmTipoUsuario" required="required" class="btn btn-info dropdown-toggle">
								

												<option id="selectedTipo"  value="<c:out value="${ idTipo.toString() }" />"  selected="selected" ><c:out value="${ descripcionTipo.toString() }" /></option>
										
							<c:forEach items="${tiposUsuario}" var="item">
								
								<option value="${item.idTipoUsuario}" >${item.descripcion}</option>
								
								

		
								
								
								
							
							</c:forEach>
									
						
							</select> 	
							
							</td>
						</tr>
						
						<tr>
						<td colspan="2" align="center">
						
						<input type="button"  id="btnEliminar" data-id="/EliminarUsuario-${idUsuario}"  value="Eliminar" class="btn btn-danger" onclick="eliminarUsuario()"></button>					
						
						<input type="button" name="btnGuardarUsuario"  myContextPath="${pageContext.request.contextPath}"  onclick="guardarUsuario(this)"  value="Guardar" class="btn btn-success"/>
						<input hidden="true" id="idUsuario" value="<c:out value="${ idUsuario.toString() }" />" />
						
							
						
                          <a  name="cancelar"  class="btn btn-primary btn-xl page-scroll" href="<c:url value='/IrListarUsuarios.html' />"   >cancelar</a><br><br><br>
						
						
						
							</tr>
							</form>
						</td>
						</tr>
		</table>

			                
            </div>
        </div>
    </header>
    
    
    
<script type="text/javascript">
	<%@ include file="Recursos/js/jquery.min.js" %>
	<%@ include file="Recursos/js/bootstrap.min.js" %>
	<%@ include file="Recursos/js/jquery.easing.min.js" %>
	<%@ include file="Recursos/js/scrollreveal.min.js" %>
	<%@ include file="Recursos/js/jquery.magnific-popup.min.js" %>
	<%@ include file="Recursos/js/creative.min.js" %>

</script>
    
    
    
    




    <!-- jQuery 
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript 
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Theme JavaScript 
    <script src="js/creative.min.js"></script>-->

<script type=text/javascript>


$( document ).ready(function() {
debugger;
	$("#cmbDepartamento").children().each(function(index,elem){
		if($("#selectedDep").text() == $(elem).text()){
		$(elem).remove();
		}
		});
		
		
	$("#cmbTipoUsuario").children().each(function(index,elem){
		if($("#selectedTipo").text() == $(elem).text()){
		$(elem).remove();
		}
		});
});

var eliminarUsuario= function(){
	debugger;
	alert('Eliminado correctamente'); window.location.replace("http://localhost:8080/Tareador/"+$("#btnEliminar").attr('data-id')+"")
}


var guardarUsuario= function(element){
	
var CONTEXT_PATH =	$(element).attr('myContextPath');
	debugger;
//	var parameters = { nombreU: $('#inputNombre').val() , apellido: $('#inputApellido').val() , contraseña: $('#inputPassword').val() , correo:  $('#inputCorreo').val(), idDepartamento: $('#cmbDepartamento').val(), departamento: $('#cmbDepartamento').text(), tipoUsuario: $('#cmbTipoUsuario').text(), idTipoUsuario: $('#cmbTipoUsuario').val(),  };
	

	//var user = '{' "user" ':' '{' "Nombre" : $('#inputNombre').val() , Apellido: $('#inputApellido').val() , Contrasenia: $('#inputPassword').val() , Email:  $('#inputCorreo').val()}};//, idDepartamento: 1, departamento: 'Sistemas', tipoUsuario: 'Super usuario', idTipoUsuario: 'SUPER' } };
	
	
//	var user = { "user" : { "Nombre" : ""$('#inputNombre').val()"", "Apellido"  : ""$('#inputApellido').val()"", "Contrasenia" : ""$('#inputPassword').val()"", "Email" : ""$('#inputCorreo').val()"" } };
//	var user = { "user": { "Nombre": "$('#inputNombre').val()'", "Apellido": ""$('#inputApellido').val()"", "Contrasenia": ""$('#inputPassword').val()"", "Email": ""$('#inputCorreo').val()"", "Departamento": {  "descripcion": "", "codigo": "",  "idDepartamento": "" }, "TipoUsuario": {"idTipoUsuario": "", "descripcion": ""  }  }}      

	//var user = { "user": { "Nombre": "", "Apellido": "", "Contrasenia": "", "Email": "", "Departamento": {  "descripcion": "", "codigo": "",  "idDepartamento": "" }, "TipoUsuario": {"idTipoUsuario": "", "descripcion": ""  }  }}      

	var user  = new Object();
	user.idUsuario= $("#idUsuario").val();
	user.nombreUsuario= $('#inputUsuario').val();
	user.nombre= $('#inputNombre').val();
	user.apellido= $('#inputApellido').val();
	user.contrasenia = $('#inputPassword').val();
    user.email =  $('#inputCorreo').val();
    user.departamento= new Object();
    user.tipoUsuario= new Object();
        
    user.departamento.idDepartamento = $("#cmbDepartamento").val();
    user.departamento.descripcion = $("#cmbDepartamento option:selected").text();
    
    user.tipoUsuario.idTipoUsuario= $("#cmbTipoUsuario").val();
    user.tipoUsuario.descripcion= $("#cmbTipoUsuario option:selected").text();

    user.isActivo= true;

    
/*	$.ajax({type: "POST",
	    url: CONTEXT_PATH+"/AgregarUsuario",
	    data: parameters,
	    contentType : 'application/json; charset=utf-8',
	    dataType : 'json',
	    success: function (response) {
	        if (response != null) {
	            if (response.errorMsg != null && response.errorMsg != "") { // Login Error
	                alert(response.errorMsg);
	            } else {
	                 // Here i need to call spring controller method and to redirect to another page
	
	                 // I have tried
	               /*  $.ajax({type: "GET",
	                        url: CONTEXT_PATH+"navigateMainPage",
	                        data:JSON.stringify(loginDO),
	                        contentType : 'application/json; charset=utf-8',
	                        dataType : 'json'
	                });
	            }
	        }
	    }
	});*/
	
	
	$.ajax({ url: CONTEXT_PATH+"/EditarUsuario",
		type: "POST",
		dataType: "json",
		data: JSON.stringify(user),
		contentType: "application/json; charset=utf-8",
		success: function (result) {
			if (result.success) 
			{ alert('en el true'); } 
			else { alert('en el false') } }, 
			error:function(error) {alert('Editado correctamente'); window.location.replace("http://localhost:8080/Tareador/IrListarUsuarios.html");
; } });
	
	
}
			
</script>

</body>

</html>
