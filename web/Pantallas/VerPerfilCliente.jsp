<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="lab01.server.DataCliente" %>
<%@page import="lab01.server.DataPedido" %>
<%@page import="java.util.ArrayList"%>
<html lang="es">

    <head>
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">-->
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <!-- Optional theme -->
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">-->
        <link href="../Branding/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../Branding/css/nav.css" rel="stylesheet" type="text/css"/>
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
        <link rel="stylesheet" type="text/css" href="./Branding/css/nav.css" >
        <link href="../Branding/css/perfil.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>
 
    <!-- Page Content -->
    <div class="container">
        <jsp:include page="/layout/head.jsp"/>

        <div class="row">

            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >

                <option value="cliente" item="${dc}">
                <div class="col-md-14 col-lg-14 " align="center"> 
                    <img id="ImgCliente" alt="Red dot" src="" class="img-circle img-responsive"> </div>
                 </div>
                <br></br>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <!--<h3 class="panel-title">Perfil</h3>-->
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a href="#1" data-toggle="tab">Perfil</a>
                        </li>
                        <li>
                            <a href="#2" data-toggle="tab">Pedidos</a>
                        </li>
                    </ul>
                    </div>
                <div class="tab-content">
                <div class="tab-pane active" id="1">
                    <div class="row">
                        <div class=" col-md-9 col-lg-9 "> 
                            <table class="table table-user-information">
                                <tbody>
                                    
                                    <tr>
                                        <td>Nombre:</td>
                                        <td><c:out value="${cliente.getNombre()}"></c:out></td>
                                    </tr>
                                    <tr>
                                        <h3><p> </p></h3>
                                        <h3><p> </p></h3>
                                        <h3><p> </p></h3>
                                        <h3><p> </p></h3>
                                        <td>Apellido:</td>
                                        <td><c:out value="${cliente.getApellido()}"></c:out></td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td><c:out value="${cliente.getEmail()}"></c:out></td>
                                    </tr>
                                    <tr>
                                        <td>Nickname:</td>
                                        <td><c:out value="${cliente.getNickname()}"></c:out></td>
                                    </tr>
                                    <tr>
                                        <td>Direccion:</td>
                                        <td><c:out value="${cliente.getDireccion()}"></c:out></td>
                                    </tr>
                                    <tr>
                                        <td>Fecha de Nacimiento:</td>
                                        <td><c:out value="${cliente.getFNac()}"></c:out></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="2">  
                    <form action="pedido" method="get" accept-charset="UTF-8">
                        <div class="pedidosCliente" align="center">
                        <c:forEach items="${lPedidos}" var="pedido">
                            <button class="btn btn-link btnPedidos" align="center" type="submit" name="pedido" value="${pedido.getId()}" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xs-offset-0 col-sm-offset-0 col-md-offset-0 col-lg-offset-0 toppad" data-toggle="tooltip" title="Haga clic para ver el detalle">
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xs-offset-0 col-sm-offset-0 col-md-offset-0 col-lg-offset-0 toppad" >
                                    <div class="thumbnail" >
                                        <div class="caption">
                                            <h4 class="pull-center">ID pedido: ${pedido.getId()}</h4>  
                                            
                                            <h4 class="pull-center">Nick restaurante: ${pedido.getNickRest()}</h4>
                                            
                                            <h4 class="pull-center">Total: $${pedido.getPrecioTotal()}<h4>        
                                        </div>                                                 
                                    </div>
                                </div>   
                            </button>        
                        </c:forEach> 
                        </div>
                    </form>     
                </div>  
                </div>    
                </div>
            </div>
        </div>
    </div>                       
        <script>
            document.getElementById("ImgCliente").src = "data:image/png;charset=utf-8;base64,"+'${cliente.getImagen()}';
        </script>                            

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
