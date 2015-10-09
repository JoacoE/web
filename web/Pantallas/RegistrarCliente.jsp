<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Registro</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="../Branding/css/themes/default.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="../Branding/js/jquerylogin.js"></script>
        <script src="../Branding/js/bootstrap.min.js"></script>
    </head>
    <div class="container">
        <jsp:include page="/layout/head.jsp"/>

        <h2>Registrarse</h2>
        
        <form role="form">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="txtNombre" placeholder="Nombre" required="required">
            </div>
            <div class="form-group">
                <label for="apellido">Apellido:</label>
                <input type="text" class="form-control" id="txtApellido" placeholder="Apellido" required="required">
            </div>
            <div class="form-group">
                <label for="direccion">Dirección:</label>
                <input type="text" class="form-control" id="txtDireccion" placeholder="Direccion" required="required">
            </div>
            <div class="form-group">
                <label for="pwd">Contraseña:</label>
                <input type="password" class="form-control" id="txtPass" placeholder="Constraseña" required="required">
            </div>
            <div class="form-group">
                <label for="pwd">Confirmar contraseña:</label>
                <input type="password" class="form-control" id="txtConfirmPass" placeholder="Confirmar constraseña" required="required">
            </div>
            <!--controlar que las contraseñas sean iguales-->

            <div class="form-group">
                <label for="date">Fecha de Nacimiento:</label>
                <input type="text" class="form-control" id="txtFecha" placeholder="Fecha de nacimiento" data-date-format="dd-mm-yyyy" required="required">
            </div>

            <div class="form-group">
                <label for="selIMg">Seleccionar imagen:</label>
                <input type="file" id="img">
                <p class="help-block"></p>
            </div>

            <!--<input data-toggle="modal" class="btn btn-success" type="submit" onclick= "return alertify.confirm('Confirmaci?n','Registro exitoso',0,0).set('labels', {ok:'Ok'});" value="Registrar" name="btnRegistrar" data-dismiss="modal">-->
            <input class="btn btn-success" type="submit" value="Registrar" name="btnReg" onclick="myFunction()">
            <input class="btn btn-danger"  type="submit" value="Cancelar" name="btnCancelar">
            <script type="text/javascript">
                function myFunction() {
                    alert("Registro realizado satisfactoriamente");
                }
            </script>

        </form>
    </div>
</html>