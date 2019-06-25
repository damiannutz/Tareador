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

    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">Tareador</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="#about">Log In</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#services">Caracteristicas</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contactenos</a>
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
                <h1 id="homeHeading">Tareador le permite trabajar de forma más colaborativa y ser más productivo!</h1>
                <hr>
                <p>Las tarjetas, listas y tableros de Tareador le permiten organizar y priorizar sus proyectos de forma divertida, flexible y provechosa.</p>
                <a href="#about" class="btn btn-primary btn-xl page-scroll">Conoce Mas!</a>
            </div>
        </div>
    </header>

    <section class="bg-primary" id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Trabaje con cualquier equipo</h2>
                    <hr class="light">
                    <p class="text-faded">Ya sea para un trabajo, un proyecto o incluso las próximas vacaciones en familia, Tareador ayuda a tu equipo a permanecer organizado.</p>
                    <a class="page-scroll btn btn-default btn-xl sr-button" href="<c:url value='/IrLogin.html' />"  >LogIn</a>
                    
                </div>
            </div>
        </div>
    </section>

    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Caracteristicas</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-diamond text-primary sr-icons"></i>
                        <h3>Manual de estrategia del equipo</h3>
                        <p class="text-muted">No encontrará complicaciones a la hora de configurar y poner a todo su equipo a trabajar con Tareador. Hemos reunido todos los tableros y herramientas que necesita para lograr el éxito en un práctico recurso.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-paper-plane text-primary sr-icons"></i>
                        <h3>Una plataforma de productividad</h3>
                        <p class="text-muted">ntegre directamente en su flujo de trabajo las aplicaciones que su equipo ya utiliza. Los Power-Up convierten los tableros de Tareador en aplicaciones vivas para cumplir con las necesidades particulares de su equipo.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-newspaper-o text-primary sr-icons"></i>
                        <h3>Información de un vistazo</h3>
                        <p class="text-muted">Profundice en los detalles añadiendo comentarios, archivos adjuntos, fechas de vencimiento y mucho más directamente en las tarjetas de Tareador. Colabore en los proyectos de principio a fin.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-heart text-primary sr-icons"></i>
                        <h3>Siempre sincronizado</h3>
                        <p class="text-muted">Tareador permanece sincronizado en todos sus dispositivos allá donde esté. Colabore con su equipo desde cualquier lugar, ya sea en el autobús o en la playa.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>

   
    

    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Contactenos</h2>
                    <hr class="primary">
                    <p>¿Listo para comenzar tu próximo proyecto con nosotros? ¡Eso es genial! ¡Llámenos o envíenos un correo electrónico y nos pondremos en contacto con usted lo antes posible!</p>
                </div>
                <div class="col-lg-4 col-lg-offset-2 text-center">
                    <i class="fa fa-phone fa-3x sr-contact"></i>
                    <p>123-456-6789</p>
                </div>
                <div class="col-lg-4 text-center">
                    <i class="fa fa-envelope-o fa-3x sr-contact"></i>
                    <p><a href="mailto:your-email@your-domain.com">contacto@tareador.com</a></p>
                </div>
            </div>
        </div>
    </section>

    <!-- jQuery -->
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
