<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="lab01.Clases.DataPedido" %>
<html lang="es">

    <head>
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="/Branding/css/bootstrapverRestaurante.css" >
        <link rel="stylesheet" type="text/css" href="/Branding/css/round-aboutRestaurante.css">
        <link rel="stylesheet" type="text/css" href="/Branding/css/bootstrap.minRestaurante.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <!--<script type="text/javascript" src="/js/CategoriasTree.js"></script>-->
        <script type="text/javascript" src="../Branding/js/bootstrapRestauranteRestaurante.js"></script>
        <script type="text/javascript" src="../Branding/js/jqueryRestaurante.js.js"></script>
        <script type="text/javascript" src="../Branding/js/bootstrap.min_1.js"></script>
        <script src="../Branding/js/bootstrap.min.js"></script>
                <!--<script type="text/javascript" src="../Branding/js/head.js"></script>-->
        <script src="./Branding/js/jquerylogin.js" type="text/javascript"></script>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <style>
            body {
                padding-top: 70px;
                /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
            }
        </style>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        
        
    </head>

    <body>
        <!-- Page Content -->
        <jsp:include page="/layout/head.jsp"/>
        <div class="container">

            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="tabbable">
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a href="#1" data-toggle="tab">Perfil</a>
                            </li>
                            <li>
                                <a href="#2" data-toggle="tab">Pedidos</a>
                            </li>

                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="1">
                                <div class="row">
                                <br></br>
                                <ul class="list-unstyled">

                                </ul>
                                </div>
                                <div class="col-lg-4 col-sm-6 text-center">
                                    <img class="img-circle img-responsive img-center" src="http://placehold.it/200x200" alt="">
                                    <option value="cliente" item="${dc}">
                                        <h3><a>Nombre: <c:out value="${cliente.getMail()}"/></a></h3>
                                        <h3><a>Apellido: <c:out value="${cliente.getApellido()}"/></a></h3>
                                        <h3><a>Email: <c:out value="${cliente.getNombre()}"/></a></h3>
                                        <h3><a>Nickname: <c:out value="${cliente.getNickname()}"/></a></h3>
                                        <h3><a>Direccion: <c:out value="${cliente.getDireccion()}"/></a></h3>
                                        <h3><a>Fecha de Nacimiento: <c:out value="${cliente.getFNac()}"/></a></h3>
                                    </option>    
                                </div>
                            </div>
                            <div class="tab-pane fade" id="2">
                                <!--<div class="row">-->
                                    <!--<br></br>-->
                                    <c:forEach var="lPedidos" items="${listaPed}">
                                        <h3><a>Nombre: <c:out value="lala"/></a></h3>
                                        <!--<div class="col-sm-4 col-lg-4 col-md-4">-->
                                        <!--<div class="thumbnail" >-->
                                            <!--<div class="caption">-->
                                                <!--<h4 class="pull-right">$${pedidos.getId()}</h4>-->
                                                
                                                <!--<p>${pedidos.getNickRest()}</p>-->
                                            <!--</div>-->
                                        <!--</div>-->
                                        <!--</div>-->
                                    </c:forEach>        
                                <!--</div>-->            
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>                            

        <!-- jQuery Version 1.11.1 -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
        <script src="../Branding/js/bootstrap.min.js"></script>
        <script src="../Branding/js/bootstrap.tab.js"></script>
        <script src="js/libs/underscore-min.js"></script>
        <script src="js/libs/backbone-min.js"></script>
        <script src="js/libs/lightbox.js"></script>
        <script src="js/store.js"></script>
        <script src="../Branding/js/jquery.js"></script>
    </body>

</html>
