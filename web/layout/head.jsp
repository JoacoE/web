<link rel="stylesheet" type="text/css" href="../Branding/css/nav.css" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!--<link rel="stylesheet" type="text/css" href="../Branding/css/estilos.css" >-->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./Branding/js/head.js"></script>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-default" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        <img alt="img" src="./Branding/img/logo.png">
                    </a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->

                <div class="col-md-4 col-md-offset-3">
                    <form action="" class="search-form">
                        <div class="form-group has-feedback">
                            <label for="search" class="sr-only">Buscar restaurante...</label>
                            <input type="text" class="form-control" name="search" id="search" placeholder="Buscar restaurante...">
                            <span class="glyphicon glyphicon-search form-control-feedback"></span>
                        </div>
                    </form>
                </div>

                <ul class="nav navbar-nav navbar-right">
                    <input class="btn btn-link" type="submit" value="Registrarse" name="registrar" data-toggle="modal" data-target="#regmodal">

                    <!--<li><a href="http://www.jquery2dotnet.com">Registrarse</a></li>-->
                    <li class="dropdown">
                        <input class="btn btn-link dropdown-toggle" type="submit" value="Ingresar" name="ingresar" data-toggle="modal" data-target="#myModal">

                        <!--<a href="#" class="dropdown-toggle" data-toggle="dropdown"data-toggle="modal" data-target="#myModal">Ingresar<b class="caret"></b></a>-->
                        <ul class="dropdown-menu">
                            <li>
                                <div class="row">
                                    <div class="col-md-12">
                                        <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                                            <div class="form-group">
                                                <label class="sr-only" for="exampleInputEmail2">Email address</label>
                                                <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email address" required>
                                            </div>
                                            <div class="form-group">
                                                <label class="sr-only" for="exampleInputPassword2">Password</label>
                                                <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
                                            </div>
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"> Remember me
                                                </label>
                                            </div>
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-success btn-block">Sign in</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <input class="btn btn-primary btn-block" type="button" id="sign-in-google" value="Sign In with Google">
                                <input class="btn btn-primary btn-block" type="button" id="sign-in-twitter" value="Sign In with Twitter">
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>

        </div>
        <!-- /.navbar-collapse -->
    </div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

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
    <!-- Registrar -->

    <div class="modal fade" id="regmodal" tabindex="-1" role="dialog" aria-labelledby="registrarLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title text-center">Registrar</h3>
                            </div>
                            <div class="panel-body">
                                <form action="../Pantallas/RegistrarCliente.jsp" method="POST" accept-charset="UTF-8">
                                    <fieldset>
                                        <div class="form-group">
                                            <input class="form-control" type="email" name="txtMail" placeholder="E-mail" required="required">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="text" name="txtNickname" placeholder="Nickname" required="required">
                                        </div>
                                        <input class="btn btn-info " type="submit" value="Siguiente" name="siguiente">


                                    </fieldset>
                                </form>

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
</div>