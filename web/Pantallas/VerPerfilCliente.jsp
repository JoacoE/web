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
        <jsp:include page="/layout/head.jsp"/>



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
                        <div class="tab-pane active" id="1">

                            <div class="row">
                                        <option value="cliente" item="${dc}">

                                        <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="<%=request.getContextPath()%>/Branding/img/${cliente.getImagen()}.jpeg" class="img-circle img-responsive"> </div>
                                <div class=" col-md-9 col-lg-9 "> 
                                    <table class="table table-user-information">
                                        <tbody>

                                        <tr>
                                            <td>Nombre:</td>
                                            <td><c:out value="${cliente.getNombre()}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Apellido:</td>
                                            <td><c:out value="${cliente.getApellido()}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Email:</td>
                                            <td><c:out value="${cliente.getMail()}"/></td>
                                        </tr>

                                        <tr>
                                        <tr>
                                            <td>Nickname:</td>
                                            <td><c:out value="${cliente.getNickname()}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Direccion:</td>
                                            <td><c:out value="${cliente.getDireccion()}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Fecha de Nacimiento:</td>
                                            <td><c:out value="${cliente.getFNac()}"/></td>
                                        </tr>

                                        </tbody>
                                    </table>

                                </div>
                            </div>
                        </div>

                        <div class="tab-pane fade" id="2">                             
                            <c:forEach var="lPedidos" items="${lPedidos}">
                                <div class="col-sm-9 col-lg-9 col-md-9">
                                    <div class="thumbnail" >                                        
                                        <div class="caption">
                                            <h4 class="pull-right">${lPedidos.getId()}</h4>                                         
                                            <h4><p>${lPedidos.getNickRest()}</p><h4>
                                                    <h4><p>${lPedidos.getPrecio_total()}</p><h4>        
                                                            </div>                                                 
                                                            <p><span class="glyphicon glyphicon-th-list"></span>Detalle</p>                                                
                                                            <p><span class="glyphicon glyphicon-pencil"></span>Comentar</p>                                                

                                                            </div>
                                                            </div>       
                                                        </c:forEach>        
                                                        <!--</div>-->            
                                                        </div>   


                                                        </div>
                                                        </div>
                                                        </div>
                                                        </div>












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
                                                                                <div class="col-lg-4 col-sm-6 text-left">
                                                                                    <img class="img-circle img-responsive img-center" src="http://placehold.it/200x200" alt="">
                                                                                    <option value="cliente" item="${dc}">
                                                                                    <h3><p>Nombre: <c:out value="${cliente.getNombre()}"/></p></h3>
                                                                                    <h3><p>Apellido: <c:out value="${cliente.getApellido()}"/></p></h3>
                                                                                    <h3><p>Email: <c:out value="${cliente.getMail()}"/></p></h3>
                                                                                    <h3><p>Nickname: <c:out value="${cliente.getNickname()}"/></p></h3>
                                                                                    <h3><p>Direccion: <c:out value="${cliente.getDireccion()}"/></p></h3>
                                                                                    <h3><p>Fecha de Nacimiento: <c:out value="${cliente.getFNac()}"/></p></h3>
                                                                                    </option>    
                                                                                </div>
                                                                            </div>
                                                                            <div class="tab-pane fade" id="2">                             
                                                                                <c:forEach var="lPedidos" items="${lPedidos}">
                                                                                    <div class="col-sm-9 col-lg-9 col-md-9">
                                                                                        <div class="thumbnail" >                                        
                                                                                            <div class="caption">
                                                                                                <h4 class="pull-right">${lPedidos.getId()}</h4>                                         
                                                                                                <h4><p>${lPedidos.getNickRest()}</p><h4>
                                                                                                        <h4><p>${lPedidos.getPrecio_total()}</p><h4>        
                                                                                                                </div>                                                 
                                                                                                                <p><span class="glyphicon glyphicon-th-list"></span>Detalle</p>                                                
                                                                                                                <p><span class="glyphicon glyphicon-pencil"></span>Comentar</p>                                                

                                                                                                                </div>
                                                                                                                </div>       
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
