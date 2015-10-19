<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="lab01.Clases.DataRestaurante"%>

<html lang="en">

<head>

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
        <script type="text/javascript" src="../Branding/js/jqueryRestaurante.js"></script>
        <script type="text/javascript" src="../Branding/js/bootstrap.min_1.js"></script><script src="../Branding/js/jquerylogin.js"></script>
        <script src="../Branding/js/bootstrap.min.js"></script>
                <!--<script type="text/javascript" src="./Branding/js/head.js"></script>-->
        <script src="./Branding/js/jquerylogin.js" type="text/javascript"></script>
    <title>QuickOrder</title>

    <!-- Bootstrap Core CSS -->
    <link href="../Branding/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../Branding/css/shop-homepage.css" >
    <!-- Custom CSS -->
    <!--<link href="css/shop-homepage.css" rel="stylesheet">-->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js">
    
                <link rel="stylesheet" type="text/css" href="./Branding/css/nav.css" >

    
</head>

<body class="home">
	<!-- Fixed navbar -->
        <jsp:include page="/layout/head.jsp"/>

    <div class="container">

        <div class="row">

            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div><h1>
                        <option value="restaurante">
                        <h2><c:out value="${restaurante.getNombre()}"/></h2>
                        <h2 hidden="true" id="nickrest"><c:out value="${restaurante.getNickname()}"/></h2>
                        </option>
                        </h1></div>
                  <div class="panel panel-info">
                            <div class="panel-heading">
                                <div class="tabbable">
                                    <ul class="nav nav-tabs">
                                        <li class="active">
                                            <a href="#1" data-toggle="tab">Menú</a>
                                        </li>
                                        <li>
                                            <a href="#2" data-toggle="tab">Información</a>
                                        </li>
                                        <li>
                                            <a href="#3" data-toggle="tab">Comentarios</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        <div class="tab-content">
                            <div class="tab-pane active" id="1">
                                <div class="row-tab">
                                    <br></br>
                                    <div class="row text-center"><h3>Productos promocionales</h3>
                                        <c:forEach var="promo" items="${promocionales}">
                                            <div class="col-sm-4 col-lg-4 col-md-4">
                                                <div class="thumbnail" >
                                                    <c:set var="Imagen" value="${promo.getDataImagen()}"/>
                                                    <c:if test="${Imagen == ''}">
                                                       <img src="<%=request.getContextPath()%>/Branding/img/NoImagen.jpeg" alt="no imagen">
                                                    </c:if>
                                                    <c:if test="${Imagen != ''}">
                                                        <img src="<%=request.getContextPath()%>/Branding/img/${promo.getDataImagen().toLowerCase()}.jpeg" alt="imagen">
                                                    </c:if>
                                                    <div class="caption">
                                                        <h4 id="precio" class="pull-right">$${promo.getDataPrecio()}</h4>
                                                        <h4 class="nombreProd">${promo.getDataNombre()}</h4>
                                                        <p class="desc">${promo.getDataDescripcion()}</p>
                                                        <button class="btnCarrito btn btn-success glyphicon glyphicon-shopping-cart">Agregar</button>
                                                    </div>   
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div> 
                                    <div class="row text-center"><h3>Productos individuales</h3>
                                        <c:forEach var="individ" items="${individuales}">
                                            <div class="col-sm-4 col-lg-4 col-md-4">
                                                <div class="thumbnail">
                                                    <c:set var="Imagen" value="${individ.getDataImagen()}"/>
                                                    <c:if test="${Imagen == ''}">
                                                        <img src="<%=request.getContextPath()%>/Branding/img/NoImagen.jpeg" alt="no imagen">
                                                    </c:if>
                                                    <c:if test="${Imagen != ''}">
                                                        <img src="<%=request.getContextPath()%>/Branding/img/${individ.getDataImagen().toLowerCase()}.jpeg" alt="imagen">
                                                    </c:if>
                                                    <div class="caption">
                                                        <h4 id="precio" class="pull-right">$${individ.getDataPrecio()}</h4>
                                                        <h4 class="nombreProd">${individ.getDataNombre()}</h4>
                                                        <p class="desc">${individ.getDataDescripcion()}</p>
                                                        <button class="btnCarrito btn btn-success glyphicon glyphicon-shopping-cart">Agregar</button>

                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="2">
                                <br>
                                <div>
                                    <option value="restaurante">
                                    <table class="table table-user-information">
                                        <tbody>
                                            <tr>
                                                <td>Nombre:</td>
                                                <td><a><c:out value="${restaurante.getNombre()}"/></a></td>
                                            </tr>
                                            <tr>
                                                <td>Nickname</td>
                                                <td><a><c:out value="${restaurante.getNickname()}"/></a></td>
                                            </tr>

                                            <tr>
                                                <td>Email:</td>
                                                <td><a><c:out value="${restaurante.getEmail()}"/></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Direccion:</td>
                                                <td><c:out value="${restaurante.getDireccion()}"/></td>
                                            </tr>
                                            <tr>
                                                <td>Calificación:</td>
                                                <td>
                                                    <c:forEach var="i" begin="1" end="${restaurante.getPromedio()}">
                                                        <span class="glyphicon glyphicon-star"></span>
                                                    </c:forEach>
                                                    <c:forEach var="i" begin="${restaurante.getPromedio()}" end="4">
                                                        <span class="glyphicon glyphicon-star-empty"></span>
                                                    </c:forEach>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    </option>
                                </div>
                                </br>
                            </div>
                            <div class="tab-pane fade" id="3">
                                <c:forEach var="evaluacion" items="${evaluaciones}">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <table class="table table-user-information">
                                                <tbody>
                                                    <tr>
                                                        <td>
                                                            <c:forEach var="i" begin="1" end="${evaluacion.getPuntaje()}">
                                                                <span class="glyphicon glyphicon-star"></span>
                                                            </c:forEach>
                                                            <c:forEach var="i" begin="${evaluacion.getPuntaje()}" end="4">
                                                                <span class="glyphicon glyphicon-star-empty"></span>
                                                            </c:forEach>
                                                            <p><b>${evaluacion.getNickname()} </b>- ${evaluacion.getFecha()}</p>
                                                            <p>${evaluacion.getComentario()}</p>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
        <div class="col-md-3">
                <div class="container-fluid">
                        <div class="row">
                                <div class="col-sm-12  col-md-10  main" id="main">
                                        <div class="">
                                                <div id="app"></div>
                                        </div>
                                        <div class="row">
                                                <ul id="default-item-list" class="col-md-12"></ul>
                                        </div>
                                        <div class="row">
                                                <div id="detail"></div>
                                        </div>
                                </div>
                            
                            <div class="mostrarCarro"></div>
                            
                                <div class="col-sm-3 col-sm-offset-3 col-md-2 col-md-offset-2 sidebar" id="sidebar">
                                           <form action="pedido" method="get" accept-charset="UTF-8">

                                               <table id="shopping-cart" name="nickrest" class="table table-responsive">
                                            <tbody id="shopping-list">
                                                
                                            </tbody>
                                                <tfoot>
                                                    <tr class="sum">
                                                            <td colspan="4" id="total"></td>
                                                        </tr>
                                                </tfoot>
                                        </table>
                                               <button class="btn btn-primary btn-lg" type="submit" id="comprar" name="comprar">Comprar</button>
                                           </form>

                                </div>
                        </div>
                 </div>
                
            </div>                                 
        </div>            
    </div>
    <!-- jQuery -->
    <!-- Bootstrap Core JavaScript -->
    <script src="../Branding/js/bootstrap.min.js"></script>
    <script src="../Branding/js/bootstrap.tab.js"></script>
    <script src="js/libs/underscore-min.js"></script>
    <script src="js/libs/backbone-min.js"></script>
    <script src="js/libs/lightbox.js"></script>
    <script src="js/store.js"></script>
    <script src="../Branding/js/jquery.js"></script>
    <script type="text/javascript">

        
        
            $(".btnCarrito").click(function(){
      var newRow = $("<tr>");
              var cols = "";
              var nickrest = $("#nickrest").text();
              var nombre = $(this).siblings(".nombreProd").text();
              var precio = $(this).siblings("#precio").text();
              nombre = $.trim(nombre);
              nickrest = $.trim(nickrest);
              precio = $.trim(precio);
              cols += '<td><input type="text" name="nickrest" value="'+nickrest+'"></td>';
              cols += '<td><input type="text" name="product" value="'+nombre+'"></td>';
              cols += '<td><input type="text" name="price" value="'+precio+'"></td>';
              cols += '<td><input type="text" name="qty" value="'+1+'"></td>';
              cols += '<td><button class="remove btn btn-danger">X</button></td>';
              newRow.append(cols);
        $("#shopping-list").append(newRow);
    });
        
         $(document).on('click','.remove',function(){

            $(this).parent().parent().remove();
        });
        
        
    </script>
   
</body>

</html>
