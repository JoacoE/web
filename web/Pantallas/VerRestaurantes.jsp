<%@page import="lab01.Clases.DataCategoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lab01.Clases.DataRestaurante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

    </head>

    <body>
    <body>
        <!-- Page Content -->
        <div class="container">

            <!-- Introduction Row -->
            <div class="row">
                <div class="col-md-3">
                    <p class="lead">Categorias</p>
                    <%
                        ArrayList<DataCategoria> Lista = (ArrayList<DataCategoria>) request.getAttribute("list");
                        for (DataCategoria ci : Lista) {
                    %>
                    <div class="list-group">
                        <option value="<%=ci%>">
                        <a href="#" class="list-group-item"><%=ci.getNombre()%></a>
                        </option>
                    </div>
                    <%
                        }
                    %>  


                    <!--<a href="#" class="list-group-item">Category 1</a>
                    <a href="#" class="list-group-item">Category 2</a>
                    <a href="#" class="list-group-item">Category 3</a>-->

                </div>
            </div>
    </body>   

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Start Bootstrap</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Team Members Row -->
    
        
    <div class="row">
        
                <%
                    ArrayList<DataRestaurante> Listares = (ArrayList<DataRestaurante>) request.getAttribute("listres");
                    for (DataRestaurante ci : Listares) {
                %>
                <div class="col-lg-4 col-sm-6 text-center">
                    <img class="img-circle img-responsive img-center" src="http://placehold.it/200x200" alt="">
                    <option value="<%=ci%>">
                    <h3><a><%=ci.getNickname()%></a></h3>
                    </option>
                </div>
                <%
                    }
                %>  
            </form>
        </div>
    </div>
    </li>
    <hr>

<!--     Footer 
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Your Website 2014</p>
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

