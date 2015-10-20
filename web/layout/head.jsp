<%@page import="lab01.Clases.DataCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"  session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="../Branding/css/nav.css" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!--<link rel="stylesheet" type="text/css" href="../Branding/css/estilos.css" >-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../Branding/css/datepicker_1.css">

<!-- Latest compiled and minified JavaScript -->

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="../Branding/js/jquerylogin.js" type="text/javascript"></script>
<%
    HttpSession sesion = request.getSession();
%>

<div class="cabezal">
    <div class="navbar-header">

    <form action="usr" method="GET">
        <button type="submit" class="btn-link" name="home" id="home">
            <img src="./Branding/img/logo.png" class="img-head">
        </button>
    </form>
   </div>      
<!--    <div class="navbar-header">
                    <form action="usr" method="GET">
                        <button type="submit" class="btn-link" name="home" id="home">
                            <img src="./Branding/img/logo.png" class="img-head">
                        </button>
                    </form>
                    </a>
                </div>-->
                <!-- Collect the nav links, forms, and other content for toggling -->

                <div class="col-md-4 col-md-offset-3">
                    <form action="usr" class="search-form">
                        <div class="form-group has-feedback">
                            <label for="search" class="sr-only">Buscar restaurante...</label>
                            <input type="text" class="form-control" name="search" id="search" placeholder="Buscar restaurante...">
                            <span class="glyphicon glyphicon-search form-control-feedback"></span>
                        </div>
                    </form>
                </div>

                <ul class="nav navbar-nav navbar-right">

                    <%String iniciada = (String) sesion.getAttribute("iniciada");
                        String mostrar;
                        String user = (String) sesion.getAttribute("usuario");
                        if ("true".equals((String) sesion.getAttribute("iniciada"))) {
                            mostrar = "si";
                        } else {
                            mostrar = "no";
                        }
                        request.setAttribute("mostrar", mostrar);
                    %>




                    <c:if test="${mostrar=='no'}">
                        <div class="btn-dorpdounMenu">
                            <div class="botonReg">
                                <button class="btn  btn-warning" type="button" value="Registrarse" name="registrar" data-toggle="modal" data-target="#regmodal">Registro</button>
                            </div>    
                            <!--<button class="btnRegistrar btn-success" type="button" value="Registrarse" name="registrar" data-toggle="modal" data-target="#regmodal"></button></li>-->
                            <!--<li><a href="http://www.jquery2dotnet.com">Registrarse</a></li>-->
                            <div class="botonIniciar">

                                <!--<a href="#" class="mnIngresar dropdown-toggle" data-toggle="dropdown">Ingresar<b class="caret"></b></a>-->
                                <button type = "button" class = "btn btn-success dropdown-toggle" data-toggle = "dropdown">
                                    Iniciar Sesion
                                    <span class = "caret"></span>
                                </button>

                                <ul class = "dropdown-menu" role = "menu">
                                    
                                    <div class="col-md-12">
                                        <form class="form" role="form" method="post" action="usr" accept-charset="UTF-8" id="login-nav">
                                            <div class="form-login">
                                                <label class="sr-only" for="exampleInputEmail2">Email address</label>
                                                <input type="text" class="form-control" name="txtCorreo" id="txtCorreo" placeholder="Email address" required>
                                            </div>
                                            <div class="form-login">
                                                <label class="sr-only" for="exampleInputPassword2">Password</label>
                                                <input type="password" class="form-control" name="txtPass" id="txtCont" placeholder="Password" required>
                                            </div>
                                            <div class="form-login">
                                                <button type="submit" name="ingresar" class="btn btn-success btn-block">Ingresar</button>
                                          </div>  
                                        </form>
                                    </div> 
                                </ul>
                            </div>
                        </div>


                        
                        <div class = "btn-group">






                        </c:if>
                        <c:if test="${mostrar=='si'}">
                            <div class="btncerrarSesion">
                                <form class="form" role="form" method="get" action="usr" accept-charset="UTF-8" id="login-nav">
                                    <button type="submit" name="cerrar" class=" btn btn-danger">Cerrar sesion</button>
                                </form>
                            </div>    
                            <div class="btnPerfil">
                                <form action="pedido" method="GET" accept-charset="UTF-8">
                                    <option>
                                    <button class="btn btn-success" type="submit" name="pedidosUsuario" value="<c:out value="${dcliente.getNickname()}"/>">
                                        <c:out value="${dcliente.getNickname()}"/>                        
                                    </button>
                                    </option>
                                </form>
                            </div>   
                        </c:if>
                </ul>
    
</div>
    
<div class="container">
    <div class="row-head">
        <div class="col-md-12">

        </div>
        <!-- /.navbar-collapse -->
        <!--Registrar 
        -->
        <div class="modal fade" id="regmodal" tabindex="-1" role="dialog" aria-labelledby="registrarLabel">
            <div class="modal-dialog" role="document">


                <div class="modal-content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">


                                    <h3 class="panel-title text-center">Registrar<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button></h3>


                                </div>
                                <div class="panel-body">
                                    <form action="usr" method="POST" accept-charset="UTF-8">
                                        <fieldset>
                                            <div class="form-group">
                                                <input class="form-control" type="email" name="txtMail" placeholder="E-mail" required="required">
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="txtNickname" placeholder="Nickname" required="required">
                                            </div>

                                            <input class="btn btn-info " type="submit" value="Siguiente" name="registrar">


                                        </fieldset>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>

    <!-- jQuery -->
    <script src="../Branding/js/jquerylogin.js"></script>
    <script src="../Branding/js/bootstrap.min.js"></script>
</div>
