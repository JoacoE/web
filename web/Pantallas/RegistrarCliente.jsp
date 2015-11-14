<%@page import="lab01.server.DataRestaurante"%>
<%@page import="lab01.server.DataProducto"%>

l<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8" />
        <title>Regitro</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="./Branding/css/nav.css" >
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />
        <link href="../Branding/css/datepicker.css" rel="stylesheet" type="text/css"/>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script src="../Branding/js/jquerylogin.js" type="text/javascript"></script>


        <script>
            $(function () {
               
                $("#datepicker").datepicker({
                     dateFormat: 'dd/mm/yy'
                });
            });
        </script>
    </head>
    <body>

        <div class="container">
            <jsp:include page="/layout/head.jsp"/>

            <!-- Contact Form - START -->

            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="well well-sm">
                            <form class="form-horizontal"action="usr" method="POST" onSubmit="validar()" accept-charset="UTF-8" enctype="multipart/form-data">
                                <fieldset>
                                    <legend class="text-center header">Registrarse</legend>

                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" name="txtNombre" placeholder="Nombre" required="required">

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" name="txtApellido" placeholder="Apellido" required="required">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-home bigicon"></i></span>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" name="txtDireccion" placeholder="Direccion" required="required">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-key bigicon"></i></span>
                                        <div class="col-md-8">
                                            <input type="password" class="form-control" id="txtPass" name="txtPass" placeholder="Constrase?a" required="required">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-key bigicon"></i></span>
                                        <div class="col-md-8">
                                            <input type="password" class="form-control" id="txtConfirmPass" name="txtConfirmPass" placeholder="Confirmar constrase?a" required="required">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-calendar bigicon"></i></span>
                                        <div class="col-md-8">
                                            <input  class="datepicker"type="text" id="datepicker" name="datepicker" placeholder="Fecha de nacimiento">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-photo bigicon"></i></span>
                                        <label for="selIMg">Seleccionar imagen:</label>
                                        <input type="file" id="imagen" class="form-control" name="imagen">
                                        <p class="help-block"></p>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12 text-center">
                                            <input class="btn btn-success" type="submit" value="Registrar" name="btnReg">
                                            <!--onclick="myFunction()"-->
                                            <input class="btn btn-danger"  type="submit" value="Cancelar" name="btnCancelar">
                                            <script type="text/javascript">
                                                function myFunction() {
                                                    alert("Registro realizado satisfactoriamente");
                                                }
                                            </script>
                                        </div>
                                    </div>

                                </fieldset>
                                <script>
                                    function validar(){
                                        var pass = document.getElementById("txtPass").value;
                                        var confirm = document.getElementById("txtConfirmPass").value;
                                        if(pass != confirm){
                                            alert("Las contrase?as no coinciden");
                                            return false
                                            
                                        }
                                    }
                                </script>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <style>
                .header {
                    color: #36A0FF;
                    font-size: 27px;
                    padding: 10px;
                }

                .bigicon {
                    font-size: 35px;
                    color: #36A0FF;
                }
            </style>

            <!-- Contact Form - END -->

        </div>
    </body>
</html>