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
    <table width ="100%">
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <td width ="10%"align="left">
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
                    </div>
                </div>
            </div>        
        </td>
        <td width ="80%" align="left">
        
            <%
                    ArrayList<DataRestaurante> Listares = (ArrayList<DataRestaurante>) request.getAttribute("listres");
                    for (DataRestaurante ci : Listares) {
                %>
                <th>
                <img class="img-circle img-responsive img-center" src="http://placehold.it/200x200" alt="">
                <option value="<%=ci%>">
                    <h3><a><%=ci.getNickname()%></a></h3>
                </option>
                </th>
                <%
                    }
                %>  
            

        </td>
        <td width ="10%" valign="baseline" align="left">

        </td>
    </table>
    <!-- Page Content -->

</body>   

<!-- jQuery -->
<script src="/Branding/js/jqueryRestaurante.js.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/Branding/js/bootstrap.min_1.js.js"></script>


</body>

</html>

