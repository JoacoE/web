<%@page import="lab01.server.DataCategoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lab01.server.DataRestaurante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="./Branding/css/nav.css" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="./Branding/css/style.css" rel="stylesheet" type="text/css"/>
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
        <script type="text/javascript" src="../Branding/js/bootstrap.min_1.js"></script><script src="../Branding/js/jquerylogin.js"></script>
        <script src="../Branding/js/bootstrap.min.js"></script>
        <!--<script type="text/javascript" src="../Branding/js/head.js"></script>-->
        <script src="./Branding/js/jquerylogin.js" type="text/javascript"></script>
    </head>
    <body>
        <!-- Page Content -->
        <div class="container">
            <jsp:include page="/layout/head.jsp"/>
            <!-- /.container -->
            <!-- Introduction Row -->
            <div class="row body-content">
                <div class="col-md-3">
                    <p class="lead">Categorias</p>
                    <form action="usr" method="GET" accept-charset="UTF-8">
                        <c:forEach var="listCat" items="${list}">
                            <div class="list-group">
                                <option value="list">
                                <input type="submit" class="list-group-item boton" name="list-group-item" value="<c:out value="${listCat.getNombre()}"/>"> 
                                </option>
                            </div>
                        </c:forEach>
                    </form>
                </div>
                <div class="col-md-9">
                    <form action="usr" method="get" accept-charset="UTF-8">
                        <c:forEach var="listRestaurante" items="${listres}">
                            <div class="col-lg-4 col-sm-6 wraper-box">
                                <div class="text-center box-restaurantes">
                                    <button type="submit" name="restaurante" value="${listRestaurante.getNickname()}">
                                     <!--Aca va el codigo de la imagen--> 
                                        <option value="lista">
                                        <h3><a><c:out value="${listRestaurante.getNombre()}"/></a></h3>

                                        <c:forEach var="i" begin="1" end="${listRestaurante.getPromedio()}">
                                            <span class="fa fa-star fa-2x"></span>
                                        </c:forEach>
                                        <c:forEach var="i" begin="${listRestaurante.getPromedio()}" end="4">
                                            <span class="fa fa-star-o fa-2x"></span>
                                        </c:forEach>
                                        </option>

                                    </button>
                                </div>   
                            </div>
                        </c:forEach>
                    </form>
                </div>
            </div>
        </div>
        <!-- Team Members Row -->
        <!-- Footer -->
        <!--        <footer>
                    <div class="row">
                        <div class="col-lg-12">
                            <p>Copyright &copy; QuickOrder 2015</p>
                        </div>
                         /.col-lg-12 
                    </div>
                     /.row 
                </footer>-->
        <!-- /.container -->
        <!-- jQuery -->
        <script src="/Branding/js/jqueryRestaurante.js.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="/Branding/js/bootstrap.min_1.js.js"></script>
    </body>
</html>

