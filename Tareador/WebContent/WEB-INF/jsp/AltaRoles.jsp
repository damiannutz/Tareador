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
    if((Usuario)session.getAttribute("Sessuser") != null){
    	nombreU = ((Usuario)session.getAttribute("Sessuser")).getNombreUsuario();
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
                <a class="navbar-brand page-scroll" href="<c:url value='Index.html' />"  >Tareador</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                	<li>
                        <a class="page-scroll" href="<c:url value='IrListarRoles.html' />"  >VOLVER</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#about"><%= nombreU %></a>
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
                <h1 id="homeHeading"><c:out value="${ headerTitle}"></c:out></h1>
                <hr>
                 <a href="IrListarRoles.html" class="btn btn-primary btn-xl page-scroll">LISTA DE ROLES</a><br><br><br>
          
			<div align="center">
			<h3 id="homeHeading">   </h3>
						
				<form method="post" action="save-rol.html">
					<table>
					
					<tr>
							<td>Codigo:</td>
							<td><input maxlength="30" type="text" style=" color: black " size="20" required="required" name="codigo" value="<c:out value="${ RolCodigo.toString() }"/>"></td>
						</tr>
					
						<tr>
							<td>Nombre:</td>
							<td><input maxlength="30" type="text" style=" color: black " size="20" required="required" name="descripcion" value="<c:out value="${ RolDescripcion.toString() }"/>"></td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
						
						<tr>			
									
						
						<tr>
						<td>
							<input type="hidden" style=" color: black " name="IdRol" value="<c:out value="${ IdRol }" />">
						</td>
						
						</tr>
						<tr>
						<td colspan="2" align="center">
							
						<input type="submit" name="btnGuardarRol"  value="Guardar" class="btn btn-success"/>
						
						
						
						<c:if test="${ IdRol != null }">
						
								<a type="button" href="<c:url value="/baja-rol-${IdRol}"/>" name="btnBorrarRol" value="Eliminar_Rol" class="btn btn-danger">Eliminar</a>
						</c:if>
						
						<a type="button" href="IrListarRoles.html" id="btnCancelar" value="Cancelar"  class="btn btn-warning">Cancelar</a>
						
						</td> 
						</tr>
						
		</table>
						</form>

			                
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
