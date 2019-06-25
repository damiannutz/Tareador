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

    <!-- Theme CSS -->
<link href="<c:url value="/resources/css/creative.min.css" />" rel="stylesheet">
    <!-- Custom Fonts -->
<link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
    <!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Plugin CSS -->
<link href="<c:url value="/resources/vendor/magnific-popup/magnific-popup.css" />" rel="stylesheet">



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


    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="Inicio.html">Tareador</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                	<li>
                        <a class="page-scroll" href="IrListarTareas.html">VOLVER</a>
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
                <h1 id="homeHeading"><c:out value="${ headerTitle}"></c:out></h1>
                <hr>
                 <a href="IrListarTareas.html" class="btn btn-primary btn-xl page-scroll">TAREAS</a><br><br><br>
          
			<div align="center">
			<h3 id="homeHeading">   </h3>
						
				<form method="post" action="save-tarea.html">
					<table>
					
						<tr>
							<td>Titulo:</td>
							<td><input maxlength="30" type="text" style=" color: black " size="20" required="required" name="titulo" value="<c:out value="${ TareaTitulo.toString() }"/>"></td>
						</tr>
						
						<tr>
						<td>Descripcion:</td>
						<td>
							<textarea rows="5" cols="18" style=" color: black " required="required" name="descripcion" 
							><c:out value="${ TareaDescripcion.toString() }" /></textarea>
							
						</td>
						</tr>
						
						<tr><td><br></td></tr>
						
						<tr>			
						<td style="padding-top:5px; padding-bottom:5px;">Prioridad:</td>
							<td style="padding-top:5px; padding-bottom:5px;">
							
								<select name="cmbPrioridadId"  class="btn btn-info dropdown-toggle">
								
								<c:forEach items="${lstPrioridades}" var="item">
										<c:choose>
										    <c:when test="${ TareaPrioridadId != null && TareaPrioridadId == item.getIdPrioridad() }">
										       	<option value="<c:out value="${item.getIdPrioridad()}" />" selected="selected" >${item.getDescripcion()}</option>
										    </c:when>    
										    <c:otherwise>
										        <option  value="<c:out value="${item.getIdPrioridad()}" />"  >${item.getDescripcion()}</option>
										    </c:otherwise>
										</c:choose>
										
								</c:forEach>
								
							</select>
								</td>
						</tr>
						<tr>
						
						<tr><td><br></td></tr>
						
						<tr>			
						<td style="padding-top:5px; padding-bottom:5px;">Tipo Tarea:</td>
							<td style="padding-top:5px; padding-bottom:5px;">
							
								<select name="cmbTipoTareaId"  class="btn btn-info dropdown-toggle">
								
								<c:forEach items="${lstTipoTareas}" var="item">
										<c:choose>
										    <c:when test="${ TareaTipoTareaId != null && TareaTipoTareaId == item.getIdTipoTareas() }">
										       	<option value="<c:out value="${item.getIdTipoTareas()}" />" selected="selected" >${item.getDescripcion()}</option>
										    </c:when>    
										    <c:otherwise>
										        <option  value="<c:out value="${item.getIdTipoTareas()}" />"  >${item.getDescripcion()}</option>
										    </c:otherwise>
										</c:choose>
										
								</c:forEach>
								
							</select>
								</td>
						</tr>
						<tr>
						
						<tr><td><br></td></tr>
						
						<tr>			
						<td style="padding-top:5px; padding-bottom:5px;">Estado Tarea:</td>
							<td style="padding-top:5px; padding-bottom:5px;">
							
								<select name="cmbEstadoTareaId"  class="btn btn-info dropdown-toggle">
								
								<c:forEach items="${lstEstadoTareas}" var="item">
										<c:choose>
										    <c:when test="${ TareaEstadoTareaId != null && TareaEstadoTareaId == item.getIdEstadoTarea() }">
										       	<option value="<c:out value="${item.getIdEstadoTarea()}" />" selected="selected" >${item.getDescripcion()}</option>
										    </c:when>    
										    <c:otherwise>
										        <option  value="<c:out value="${item.getIdEstadoTarea()}" />"  >${item.getDescripcion()}</option>
										    </c:otherwise>
										</c:choose>
										
								</c:forEach>
								
							</select>
								</td>
						</tr>
						<tr>
						
						<tr><td><br></td></tr>
						
						<tr>			
						<td style="padding-top:5px; padding-bottom:5px;">Proyecto:</td>
							<td style="padding-top:5px; padding-bottom:5px;">
							
								<select name="cmbProyectoId"  class="btn btn-info dropdown-toggle">
								
								<c:forEach items="${lstProyectos}" var="item">
										<c:choose>
										    <c:when test="${ TareaProyectoId != null && TareaProyectoId == item.getIdProyecto() }">
										       	<option value="<c:out value="${item.getIdProyecto()}" />" selected="selected" >${item.getDescripcion()}</option>
										    </c:when>    
										    <c:otherwise>
										        <option  value="<c:out value="${item.getIdProyecto()}" />"  >${item.getDescripcion()}</option>
										    </c:otherwise>
										</c:choose>
										
								</c:forEach>
								
							</select>
								</td>
						</tr>
						
						<tr><td><br></td></tr>
						
						<tr>			
						<td style="padding-top:5px; padding-bottom:5px;">Usuario Asignado:</td>
							<td style="padding-top:5px; padding-bottom:5px;">
							
								<select name="cmbUsuarioAsignadoId"  class="btn btn-info dropdown-toggle">
								<option value="0" selected="selected" >Ninguno</option>
								
								<c:forEach items="${lstUsuarios}" var="item">
										<c:choose>
										    <c:when test="${ usuarioAsignadoId != null && usuarioAsignadoId == item.getIdUsuario() }">
										       	<option value="<c:out value="${item.getIdUsuario()}" />" selected="selected" >${item.getNombreUsuario()}</option>
										    </c:when>    
										    <c:otherwise>
										        <option  value="<c:out value="${item.getIdUsuario()}" />"  >${item.getNombreUsuario()}</option>
										    </c:otherwise>
										</c:choose>
										
								</c:forEach>
								
							</select>
								</td>
						</tr>
						
						
						<tr>
						
						<td>Usuario Reporta:</td>
							<td><input maxlength="30" type="text" style=" color: black " readonly="readonly" required="required" name="usuarioReportaNombreUsuario" value="<c:out value="${ usuarioReportaNombreUsuario.toString() }"/>"></td>
												
						</tr>
						
						<tr>
						<td>
							<input type="hidden" style=" color: black " name="IdUsuarioReporta" value="<c:out value="${ usuarioReportaId }" />">
						</td>
						
						</tr>
						
						<tr>
						<td>
							<input type="hidden" style=" color: black " name="IdTarea" value="<c:out value="${ IdTarea }" />">
						</td>
						
						</tr>
						<tr>
						<td colspan="2" align="center">
							
						<input type="submit" name="btnGuardarTarea"  value="Guardar" class="btn btn-success"/>
						
						
						
						<c:if test="${ IdTarea != null }">
						
								<a type="button" href="<c:url value="/baja-tarea-${IdTarea}"/>" name="btnBorrarTarea" value="Eliminar_Tarea" class="btn btn-danger">Eliminar</a>
						</c:if>
						
						<a type="button" href="IrListarTareas.html" id="btnCancelar" value="Cancelar"  class="btn btn-warning">Cancelar</a>
						
						</td> 
						</tr>
						
		</table>
						</form>

			                
            </div>
        </div>
    </header>




    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Theme JavaScript -->
    <script src="js/creative.min.js"></script>

</body>

</html>
