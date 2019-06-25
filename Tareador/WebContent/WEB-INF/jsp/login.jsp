<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<title>TAREADOR</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link href="<c:url value="/resources/img/icons/favicon.ico" />" rel="icon">
<!--===============================================================================================-->
	<link href="<c:url value="/resources/vendor/bootstrap2/css/bootstrap.min.css" />" rel="stylesheet">
<!--===============================================================================================-->
	<link href="<c:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css" />" rel="stylesheet">
<!--===============================================================================================-->
	<link href="<c:url value="/resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css" />" rel="stylesheet">
<!--===============================================================================================-->
	<link href="<c:url value="/resources/vendor/animate/animate.css" />" rel="stylesheet">
<!--===============================================================================================-->	
	<link href="<c:url value="/resources/vendor/css-hamburgers/hamburgers.min.css" />" rel="stylesheet">
<!--===============================================================================================-->
	<link href="<c:url value="/resources/vendor/animsition/css/animsition.min.css" />" rel="stylesheet">
<!--===============================================================================================-->
	<link href="<c:url value="/resources/vendor/select2/select2.min.css" />" rel="stylesheet">
<!--===============================================================================================-->	
	<link href="<c:url value="/resources/vendor/daterangepicker/daterangepicker.css" />" rel="stylesheet">
<!--===============================================================================================-->
	<link href="<c:url value="/resources/css/util.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
 <!--===============================================================================================-->
 </head>
 <body>
	
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('img/bg-01.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					Cuenta de Ingreso
				</span>
				<form class="login100-form validate-form p-b-33 p-t-5"  method="post" action="IngresoUsuario.html">

					<div class="wrap-input100 validate-input" data-validate = "Enter username">
						<input class="input100" type="text" name="nombreU" placeholder="Username" value="USUARIO_1_IT">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input class="input100" type="password" name="passU" placeholder="Password">
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
						<span class="focus-input100"> </span>
				
					</div>
					<div class="container-login100-form-btn m-t-32">
						<input type="submit" class="login100-form-btn" value="Aceptar" name="btnAceptar">
							
						
					</div>

				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>