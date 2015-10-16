<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/layout/head.jsp"/>

        <meta charset="utf-8" />
        <title>Regitro</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />
        <link rel="stylesheet" href="../Branding/css/datepicker.css" rel="stylesheet">
        <!--<link rel="stylesheet" href="/resources/demos/style.css">-->
        <link rel="stylesheet" href="../Branding/css/datepicker_1.css">

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

        <script src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script>
            $(function () {

                $("#datepicker").datepicker();
            });
        </script>
    </head>
    <body>

        <div class="container">

            <!-- Contact Form - START -->

            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="well well-sm">
                            <form class="form-horizontal"action="usr" method="POST" accept-charset="UTF-8">
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
                                            <input type="password" class="form-control" name="txtPass" placeholder="Constraseña" required="required">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-key bigicon"></i></span>
                                        <div class="col-md-8">
                                            <input type="password" class="form-control" name="txtConfirmPass" placeholder="Confirmar constraseña" required="required">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-calendar bigicon"></i></span>
                                        <div class="col-md-8">
                                            <input type="text" id="datepicker" name="datepicker" placeholder="Fecha de nacimiento">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-photo bigicon"></i></span>
                                        <label for="selIMg">Seleccionar imagen:</label>
                                        <input type="file" name="imagen">
                                        <p class="help-block"></p>
                                    </div>






                                    <div class="form-group">
                                        <div class="col-md-12 text-center">
                                            <input class="btn btn-success" type="submit" value="Registrar" name="btnReg" onclick="myFunction()">
                                            <input class="btn btn-danger"  type="submit" value="Cancelar" name="btnCancelar">
                                            <script type="text/javascript">
                                                function myFunction() {
                                                    alert("Registro realizado satisfactoriamente");
                                                }
                                            </script>
                                        </div>
                                    </div>

                                </fieldset>
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