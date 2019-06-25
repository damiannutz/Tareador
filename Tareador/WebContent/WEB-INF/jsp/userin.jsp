<%@page import="dominio.TipoUsuario"%>
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
                <h1 id="homeHeading">Bienvenido <%= nombreU %></h1>
                <hr>
                <%if( !((Usuario)session.getAttribute("Sessuser")).getTipoUsuario().getIdTipoUsuario().equals(TipoUsuario.tipo_user) ) {%> 
                <p>Desde aqui podra administrar todo lo que necesite para realizar grupos de trabajo y proyecyos en su empresa.</p>
                   <%} %>
                <c:if test="${ ADM_DEPAR == 1 }"><a class="btn btn-primary btn-xl page-scroll" href="<c:url value='/IrAdministrarDepartamentos.html' />"  >ADMINISTRAR DEPARTAMENTOS</a></c:if>
                <c:if test="${ ADM_PROY == 1 }"><br><br><br><a class="btn btn-primary btn-xl page-scroll" href="<c:url value='/IrAdministrarProyectos.html' />"  >ADMINISTRAR PROYECTOS</a>   </c:if>
                <%if( ((Usuario)session.getAttribute("Sessuser")).getTipoUsuario().getIdTipoUsuario().equals(TipoUsuario.tipo_super) ) {%> 
                	<c:if test="${ ADM_ROL == 1 }"><br><br><br><a class="btn btn-primary btn-xl page-scroll" href="<c:url value='/IrAdministrarRoles.html' />"  >ADMINISTRAR ROLES</a>   </c:if>
                <%} %>
                <c:if test="${ ADM_USERS == 1 }"><br><br><br><a class="btn btn-primary btn-xl page-scroll" href="<c:url value='/IrAdministrarUsuarios.html' />"  >ADMINISTRAR USUARIOS</a>   </c:if>
                <c:if test="${ NEW_TAREA == 1 ||  EDIT_TAREA == 1 || DEL_TAREA == 1 || MSG_TAREA == 1 }">
                	<br><br><br><a class="btn btn-primary btn-xl page-scroll" href="<c:url value='/IrListarTareas.html' />"  >TAREAS</a> 
                 </c:if>
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
