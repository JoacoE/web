<%-- 
    Document   : header
    Created on : 06/10/2015, 12:54:28 PM
    Author     : martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <!--<link rel="stylesheet" type="text/css" href="../Branding/css/estilos.css" >-->
        <link rel="stylesheet" type="text/css" href="../Branding/css/search.css" >

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


    </head>
    <table width ="100%">
        <tr></tr>
        <tr></tr>

        <td width ="50%" valign="baseline" align="left" >
            <th>
                <img class="img-responsive" src="../Branding/img/logo.png">
            </th>
        </td>
        <td width ="50%" align="right" valign="baseline" >
            <form action="" class="search-form">
                <div class="form-group has-feedback">
                    <label for="search" class="sr-only">Buscar restaurante...</label>
                    <input type="text" class="form-control" name="search" id="search" placeholder="Buscar restaurante...">
                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                </div>
            </form>
            <th><input class="btn btn-success" type="submit" value="Ingresar" name="ingresar" data-toggle="modal" data-target="#myModal"></th>
            <th><input class="btn btn-warning" type="submit" value="Registrarse" name="registrar" ></th>
            <th><img class="img-rounded img-responsive" src="../Branding/img/defecto.gif"></th> 
        </td>

    </table>
    
    
        <!-- Modal -->

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
<!--          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">GetNombreProducto</h4>
          </div>
          <div class="modal-body">
            <div class="container">
            <div class="jumbotron" id="jumbo">

            </div>-->
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title text-center" >Ingresar a mi cuenta</h3>
                        </div>
                        <div class="panel-body">
                            <form action="validar.do" method="POST" accept-charset="UTF-8">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" type="email" name="txtMail" placeholder="E-mail" required="required">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" type="password" name="txtPass" placeholder="Contraseña" required="required">
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input name="remember" type="checkbox" value="Remember Me"> Remember Me
                                        </label>
                                    </div>
                                        <input class="btn btn-lg btn-success btn-block" type="submit" value="Ingresar" name="ingresar">
                                        

                                    <div class="social-buttons" id="login-dp">
                                        <a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a>
                                        <a href="#" class="btn btn-gp"><i class="fa fa-google-plus"></i> Google+</a>
                                        <a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Twitter</a>
                                    </div>

                                </fieldset>
                            </form>
                            <form action="validar.do" method="GET" accept-charset="UTF-8">
                                <input class="btn btn-cdatos btn-warning btn-block" type="submit" value="Cargar Datos" name="cDatos">
                            </form>
                        </div>
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


    
    
    
    
</html>
<!--<style>
    body{
        background-color: #e0070e;
    }
</style>    -->