<%@page import="controllers.UserController"%>
<%@page import="dominio.Usuario"%>
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

<body id="page-top">

<%
String nombreU; 
Integer idU = null;
if((Usuario)session.getAttribute("Sessuser") != null){
	nombreU = ((Usuario)session.getAttribute("Sessuser")).getNombreUsuario();
	idU = ((Usuario)session.getAttribute("Sessuser")).getIdUsuario();
}
else
{
	nombreU = "LOG IN";
	UserController us = new UserController();
	us.redireccion();
}

%>


<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="<c:url value='Inicio.html' />"  >Tareador</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                	<li>
                        <a class="page-scroll" href="<c:url value='IrListarUsuarios.html' />"  >VOLVER</a>
                    </li>
                    <li>
<%--                         <a class="page-scroll" href="#about"><%= nombreU %></a> --%>
 <a class="page-scroll"  
                    	<%
		            		if(((Usuario)session.getAttribute("Sessuser")).getNombreUsuario() == null){
		            			
								// 
		            			out.print("style='display: none;'");
		            	    }
                    		///EditarUsuario-${Usuario.idUsuario}
						%>  href='EditarUsuario-<%= idU %>'><%= nombreU %></a>
						
                    </li>
                    <li>
                        <a class="page-scroll" href="<c:url value='CerrarSesion.html' />"  >Cerrar Sesion</a>
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
                <h1 id="homeHeading">Gestionar Usuario</h1>
                <hr>
                 <a href="ListarUsuarios.jsp" class="btn btn-primary btn-xl page-scroll">LISTA DE USUARIOS</a><br><br><br>
          
                
			
			<div align="center">
			<h3 id="homeHeading">   </h3>
						
					<table>
						<tr>
			
						<td>
			
						<form method="post" action="UsuariosTareadorServlet?UserIdGestionado=">
						
						<tr>
						<td>Nombre:</td>
						<td><input maxlength="30" type="text" value="" style=" color: black " size="20" required="required" name="nombre"></td>
						</tr>
						<tr>
						<td>Apellido:</td>
						<td><input maxlength="30" type="text" value="" style=" color: black " size="20" required="required" name="apellido"></td>
						</tr>
						<tr>
						<td>Correo:</td>
						<td><input maxlength="40" type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Mail invalido" size="20" value="" style=" color: black " required="required" name="correo"></td>
						</tr>
						<tr>
						<td>Usuario:</td>
						<td><input  pattern="^[A-Za-z][A-Za-z0-9._%+-]*$" title="No se permiten espacios"   maxlength="30" type="text" size="20" value="" style=" color: black " required="required" name="usuario"></td>
<!-- 						  pattern="^[A-Za-z][A-Za-z0-9]*$" -->
						</tr>
						<tr>
						<td>Contraseņa:</td>
						<td><input maxlength="25" pattern=".{6,}" title="Seis o mas caracteres" type="password" value="" style=" color: black " required="required" size="20" name="contrasenia" /></td>
						</tr>
						
						<tr>
						
						<td style="padding-top:5px; padding-bottom:5px;">Departamento:</td>
							<td style="padding-top:5px; padding-bottom:5px;">
								<select name="cmbDepartamento"  class="btn btn-info dropdown-toggle">
								
									<option value="" selected="selected" > </option>
								
										<option value="" > </option> 
										
						
							</select>
							</td>
						</tr>
						<tr ">
						<td style="padding-top:5px; padding-bottom:5px;">Tipo de usuario:</td>
						<td style="padding-top:5px; padding-bottom:5px;">
								<select name="cmbTipoUsuario" required="required" class="btn btn-info dropdown-toggle">
								
									<option value="" selected="selected" > </option>
								
										<option value="" > </option> 
									
						
							</select>
							</td>
						</tr>
						
						<tr>
						<td colspan="2" align="center">
						
						<input type="submit" name="btnGuardarUsuario"  value="Guardar" class="btn btn-success"/>
						
						
							<input type="submit" name="btnBorrarUsuario" value="Eliminar Usuario" class="btn btn-danger"/>
						
						
						<a type="button" href="/Lab5/ListarUsuarios.jsp" id="btnCancelar" value="Cancelar"  class="btn btn-warning">Cancelar</a>
						
						
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

</body>

</html>