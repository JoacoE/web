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
            <th><input class="btn btn-success" type="submit" value="Ingresar" name="ingresar" ></th>
            <th><input class="btn btn-warning" type="submit" value="Registrarse" name="registrar" ></th>
            <th><img class="img-rounded img-responsive" src="../Branding/img/defecto.gif"></th> 
        </td>

    </table>
</html>
<style>
    body{
        background-color: #e0070e;
    }
</style>    