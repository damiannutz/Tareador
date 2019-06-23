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
                <a class="navbar-brand page-scroll" href="Index.jsp">Tareador</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                	<li>
                        <a class="page-scroll" href="IrAdministrarDepartamentos.html">VOLVER</a>
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
            <br><br>
                <h2 id="homeHeading">Listado de Departamentos</h2>
    
<table >
<tr>
 <th style="padding-bottom: 5px;">
 	<form action="IrListarDepartamentos.html" method="post" >
 		<input type="submit" name="ListarDepartamentos" value="Actualizar Lista" class="btn btn-primary">
	</form>
</th>
 <th style="padding-left: 5px;   padding-right: 5px; padding-bottom: 5px;">
	<form action="IrAltaDepartamento.html" method="post" >
	 	<input type="submit" name="NuevoDepartamento" value="Nuevo Departamento" class="btn btn-primary">
	</form>
</th>

</tr>

</table>
    
    <form method="get" id = "adminForm" >
    </form>
    
               
<table class="table display AllDataTables">
	<thead>
		<tr>
			<th>Codigo</th>
		   <th>Descripcion</th>
		   <th>Opciones</th>
	 	</tr>
	</thead>
	<tbody>

		<c:forEach items="${lstDepartamentos}" var="item">
				<tr style="text-align: left" data-dto="cc" data-user="cc" >
			
				<td>${item.getCodigo()}</td>
				<td>${item.getDescripcion()}</td>
<<<<<<< HEAD
				<td ><input type="button" name="btnEliminar"   value="Eliminar" class="btn btn-primary"><a href="<c:url value='/edit-departamento-${item.getIdDepartamento()}' />">Editar</a></input></td>
=======
				<td >
<%-- 				<a href="<c:url value='/edit-departamento-${item.getIdDepartamento()}' />">Editar</a>--%>

			<button type="button" class="btn btn-primary"  onclick="callEditar(${item.getIdDepartamento()})"> Editar</button>
				</td> 
>>>>>>> origin/master
				
<!-- 				<button type="submit" class="btn btn-primary"  onclick="callServlet()"> Editar</button> -->
				</tr>
				
			</c:forEach>

		
	</tbody>
</table>

			</div>
	</div>
	</header>




<script type="text/javascript">

function callEditar(idDepartamento){
	
	 form = document.createElement('form');
    form.setAttribute('method', 'POST');
    form.setAttribute('action', 'edit-departamento.html');
    myvar = document.createElement('input');
    myvar.setAttribute('name', 'idDepartamento');
    myvar.setAttribute('type', 'hidden');
    myvar.setAttribute('value', idDepartamento);
    form.appendChild(myvar);
    document.body.appendChild(form);
    form.submit();   
		 
//		 document.getElementById("adminForm").action="/edit-proyecto-" + idProyecto;
//		 document.getElementById("adminForm").method = "GET";
//		 document.getElementById("adminForm").submit();
		 
}




</script>

<script src="<c:url value="/resources/jquery/jquery.min.js" />" type="text/javascript"></script>


    <!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>



    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    
    <script src="<c:url value="/resources/scrollreveal/scrollreveal.min.js" />" type="text/javascript"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Theme JavaScript -->
    <script src="<c:url value="/resources/js/creative.min.js" />" type="text/javascript"></script>
    
    <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />" type="text/javascript"></script>
    
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>
    
    <script src="<c:url value="/resources/js/jquery.dataTables.min.js" />" type="text/javascript"></script>
    
    <script src="<c:url value="/resources/js/dataTables.bootstrap.min.js" />" type="text/javascript"></script>
	<script>
		$(document).ready( function () {
		    $('.AllDataTables').DataTable({
		    	pageLength: 10,
	            lengthMenu: [[10],["de 10"]],
		    	language: {
		    		"sProcessing":     "Procesando...",
				    "sLengthMenu":     "Mostrar _MENU_ registros",
				    "sZeroRecords":    "No se encontraron resultados",
				    "sEmptyTable":     "Ning�n dato disponible en esta tabla",
				    "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
				    "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
				    "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
				    "sInfoPostFix":    "",
				    "sSearch":         "Buscar:",
				    "sUrl":            "",
				    "sInfoThousands":  ",",
				    "sLoadingRecords": "Cargando...",
				    "oPaginate": {
				        "sFirst":    "Primero",
				        "sLast":     "�ltimo",
				        "sNext":     "Siguiente",
				        "sPrevious": "Anterior"
				    },
				    "oAria": {
				        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
				        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
				    }
		    	}
		    
		

			
		    });
		  
		
// 		$("#cmbDepartamento").on('change',function(){
			
			
			
// 			$("#DataTables_Table_0_wrapper").find('tbody').find('tr').each(function(index,element){
				
				
// 				if($("#cmbDepartamento").val() == $(element).attr('data-dto')){
// 					$(element).removeAttr('hidden');
// 				}else if($("#cmbDepartamento").val() == "TODOS"){
					
// 					$(element).removeAttr('hidden');
					
// 				}else{
// 					$(element).attr('hidden','true');
// 				}
				
					
// 			});
			
		
			
			
// 		});
		
// 		$("#cmbTipoUsuario").on('change',function(){
			
			
			
// 			$("#DataTables_Table_0_wrapper").find('tbody').find('tr').each(function(index,element){
				
				
// 				if($("#cmbTipoUsuario").val() == $(element).attr('data-user')){
// 					$(element).removeAttr('hidden');
// 				}else if($("#cmbTipoUsuario").val() == "TODOS"){
					
// 					$(element).removeAttr('hidden');
					
// 				}else{
// 					$(element).attr('hidden','true');
// 				}
				
					
// 			});
			

			
		
// 		}); 
		
		}); 

	</script>



</body>
</html>
