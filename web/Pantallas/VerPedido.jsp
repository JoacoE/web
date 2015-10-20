<%-- 
    Document   : Confirmacion
    Created on : Oct 17, 2015, 12:35:36 PM
    Author     : joaquin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
        <link rel="stylesheet" type="text/css" href="./Branding/css/stars.css">
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
        <link rel="stylesheet" type="text/css" href="./Branding/css/nav.css" >

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        
        
    </head>
    <body>
    
    
    <div class="container">
        <jsp:include page="/layout/head.jsp"/>

        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h4><b>Detalle</b></h4>
                    </div>
                    <option value="pedido" item="${pedi}">
                    <table class="table table-user-information">
                        <tbody>
                            <c:set var="idPed" scope="session" value="${pedido.getId().toString()}"></c:set>
                            <tr>
                                <td>Id:</td>
                                <td><c:out value="${pedido.getId()}"/></td>
                            </tr>
                            <tr>
                                <td>Restaurante:</td>
                                <td><c:out value="${pedido.getNickRest()}"/></td>
                            </tr>
                            <tr>
                                <td>Fecha:</td>
                                <td><c:out value="${pedido.getFecha()}"/></td>
                            </tr>
                            <tr>
                                <td>Estado:</td>
                                <td><c:out value="${pedido.getEstado()}"/></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h4><b>Contenido</b></h4>
                    </div>
                    <table class="table table-user-information">
                        <c:forEach var="carrito" items="${carrito}">
                            <tbody>
                                <tr>
                                    <td>${carrito.getCantidad()} ${carrito.getNomProd()}</td>
                                    <td><c:out value="$${carrito.getPrecio()*carrito.getCantidad()}"/></td>
                                </tr>  
                            </tbody>
                        </c:forEach>
                        <tr>
                            <td><b>Total:<b></td>
                            <td><c:out value="$${pedido.getPrecio_total()}"/></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <c:if test="${pedido.esRecibido()}">                      
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h4><b>Evaluacion</b></h4>
                    </div>
                    <form class="formtest">
                        <table class="table table-user-information">
                            <tbody class="text-center">
                                <option value="evaluacion" item="${eva}">
                                <c:if test="${evaluacion==null || evaluacion.getComentario()==null}">
                                    <br></br>
                                    <div class="text-center">
                                        <div>
                                            <fieldset id="puntaje" name="stars" value="">
                                                1<input type="radio" name="star" value="1">  
                                                2<input type="radio" name="star" value="2">  
                                                3<input type="radio" name="star" value="3">  
                                                4<input type="radio" name="star" value="4">  
                                                5<input type="radio" name="star" value="5">  
                                            </fieldset>
                                        </div>
                                    </div>
                                    <div class="text-center">
                                        <textarea cols="60" id="comentario" name="comment" value="" placeholder="Ingrese su comentario..."></textarea>
                                        <div class="text-center">	
                                            <form action="pedido" method="GET" accept-charset="UTF-8">
                                                <button class="btn btn-success" type="submit">Enviar evaluacion <i class="fa fa-reply"></i></button>
                                            </form>
                                        </div>	
                                    </div>	
                                </c:if>
                                <c:if test="${evaluacion.getComentario()!=null}">
                                    <tr>
                                        <div class="text-center">
                                            <c:forEach var="i" begin="1" end="${evaluacion.getPuntaje()}">
                                                <span class="glyphicon glyphicon-star"></span>
                                            </c:forEach>
                                            <c:forEach var="i" begin="${evaluacion.getPuntaje()}" end="4">
                                                <span class="glyphicon glyphicon-star-empty"></span>
                                            </c:forEach>
                                        </div>
                                    </tr>
                                    <tr><td><c:out value="${evaluacion.getComentario()} (${evaluacion.getFecha()})"/></td></tr>
                                </c:if>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </c:if>   
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
    <script src="../Branding/js/jsComentario.js"></script>
        
    </body>

</html>
