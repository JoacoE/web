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
    
    <jsp:include page="/layout/head.jsp"/>
    
    <div>
    <option value="pedido" item="${pedi}">
   
        <div class=" col-md-9 col-lg-9 "> 
            <table class="table table-user-information">
                <tbody>
                    <tr>
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
                            <c:forEach var="carrito" items="${carrito}">
                                <table class="table table-user-information">
                                    <tbody>
                                        <tr>
                                            <div class="col-sm-4 col-lg-4 col-md-4">
                                                <!--<img src="http://placehold.it./320x150" alt="">-->
                                                    <td>${carrito.getCantidad()} ${carrito.getNomProd()}</td>
                                                    <td>${carrito.getPrecio()*carrito.getCantidad()}</td>                                                                                                  
                                            </div>
                                        </tr>    
                                    </tbody>
                                </table>    
                            </c:forEach>                
                            <table class="table table-user-information">    
                                <tbody>
                                    <tr>
                                        <td>Total:</td>
                                        <td><c:out value="${pedido.getPrecio_total()}"/></td>
                                    </tr>
                                </tbody>    
                            </table>  

                            <option value="evaluacion" item="${eva}">
                                <c:if test="${evaluacion.getComentario()==null}">
                                <div class="container">
                                    <div class="row" style="margin-top:50px">
                                        <div class="col-md-12">
                                            <form class="formtest">
                                                <button type="button" class="btaval btn btn-success" data-toggle="collapse" data-target="#1" onClick="esconder(this)">Review !!</button>
                                                    <div id="1" class="collapse">
                                                        <div class="col-md-12 avaliar ">
                                                            <textarea cols="50" id="comentario" name="comment" value="" placeholder="Tell me your rate"></textarea>				
                                                            <div class="stars starrr" data-rating="2">
                                                                <input class="nota" name="rating" type="hidden" value="">
                                                            </div>
                                                            <div class="text-right">	
                                                                <form action="pedido" method="GET" accept-charset="UTF-8">
                                                                    <button class="btn btn-success" type="submit" onclick="test()" >Enviar <i class="fa fa-reply"></i> </button>
                                                                    <span class="btn btn-danger" data-toggle="collapse" data-target="#1" onClick="mostrar()">Cancelar <i class="fa fa-times"></i> </span>
                                                                </form>
                                                            </div>	
                                                        </div>
                                                    </div>	
                                            </form>
                                        </div>    
                                    </div>
                                </div> 
                                </c:if>
                                <c:if test="${evaluacion.getComentario()!=null}">
                                        <c:forEach var="i" begin="1" end="${evaluacion.getPuntaje()}">
                                            <span class="glyphicon glyphicon-star"></span>
                                        </c:forEach>
                                        <c:forEach var="i" begin="${evaluacion.getPuntaje()}" end="4">
                                            <span class="glyphicon glyphicon-star-empty"></span>
                                        </c:forEach>
                                        <br></br>
                                        <td>Comentario:</td>
                                        <td><c:out value="${evaluacion.getComentario()}"/></td>
                                    
                                    
                                </c:if>    
                    </tr>
                </tbody>
            </table>
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
        <script src="../Branding/js/jsComentario.js"></script>
        
    </body>

</html>
