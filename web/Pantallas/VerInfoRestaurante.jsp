<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Homepage - Start Bootstrap Template</title>

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

</head>

<body class="home">
	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top headroom" >
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
				<a class="navbar-brand" href="index.html"><img src="assets/images/logo.png" alt="Progressus HTML5 template"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right">
					<li><a class="btn" href="http://localhost:8080/index.html">SIGN IN / SIGN UP</a></li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div> 
	<!-- /.navbar -->
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
                    <div class="tab-content">
                        <div class="tab-pane active" id="1">
                            <div class="row">

                                <div class="col-sm-4 col-lg-4 col-md-4">
                                    <div class="thumbnail" data-toggle="modal" data-target="#myModal">
                                        <img src="http://placehold.it/320x150" alt="">
                                        <div class="caption">
                                            <h4 class="pull-right">$24.99</h4>
                                            <h4><a href="#">First Product</a>
                                            </h4>
                                            <p>See more snippets like this online store item at <a target="_blank" href="http://www.bootsnipp.com">Bootsnipp - http://bootsnipp.com</a>.</p>
                                        </div>
                                        <div class="ratings">
                                            <p class="pull-right">15 reviews</p>
                                            <p>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                            </p>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-sm-4 col-lg-4 col-md-4">
                                    <div class="thumbnail" data-toggle="modal" data-target="#myModal">
                                        <img src="http://placehold.it/320x150" alt="">
                                        <div class="caption">
                                            <h4 class="pull-right">$64.99</h4>
                                            <h4><a href="#">Second Product</a>
                                            </h4>
                                            <p>This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                        </div>
                                        <div class="ratings">
                                            <p class="pull-right">12 reviews</p>
                                            <p>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star-empty"></span>
                                            </p>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-sm-4 col-lg-4 col-md-4">
                                    <div class="thumbnail" data-toggle="modal" data-target="#myModal">
                                        <img src="http://placehold.it/320x150" alt="">
                                        <div class="caption">
                                            <h4 class="pull-right">$74.99</h4>
                                            <h4><a href="#">Third Product</a>
                                            </h4>
                                            <p>This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                        </div>
                                        <div class="ratings">
                                            <p class="pull-right">31 reviews</p>
                                            <p>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star-empty"></span>
                                            </p>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-sm-4 col-lg-4 col-md-4">
                                    <div class="thumbnail" data-toggle="modal" data-target="#myModal">
                                        <img src="http://placehold.it/320x150" alt="">
                                        <div class="caption">
                                            <h4 class="pull-right">$84.99</h4>
                                            <h4><a href="#">Fourth Product</a>
                                            </h4>
                                            <p>This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                        </div>
                                        <div class="ratings">
                                            <p class="pull-right">6 reviews</p>
                                            <p>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star-empty"></span>
                                                <span class="glyphicon glyphicon-star-empty"></span>
                                            </p>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-sm-4 col-lg-4 col-md-4">
                                    <div class="thumbnail" data-toggle="modal" data-target="#myModal">
                                        <img src="http://placehold.it/320x150" alt="">
                                        <div class="caption">
                                            <h4 class="pull-right">$94.99</h4>
                                            <h4><a href="#">Fifth Product</a>
                                            </h4>
                                            <p>This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                        </div>
                                        <div class="ratings">
                                            <p class="pull-right">18 reviews</p>
                                            <p>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star-empty"></span>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="2">
                            <h4>ACÁ IRÍA LA INFORMACIÓN DEL RESTAURANTE</h4>
                        </div>
                        <div class="tab-pane fade" id="3">
                            <h4>ACÁ IRÍAN LOS COMENTARIOS</h4>
                        </div>                        
                    </div>
                </div>  
            </div>
        </div>
    </div>
    <!-- /.container -->
    <!-- /.container -->
    
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">GetNombreProducto</h4>
          </div>
          <div class="modal-body">
            <select class="form-control">
              <label class="col-lg-2 control-label">Cantidad</label>
              <option>1</option>
              <option>2</option>
              <option>3</option>
              <option>4</option>
              <option>5</option>
              <option>6</option>
              <option>7</option>
              <option>8</option>
              <option>9</option>
              <option>10</option>
            </select>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
            <button type="button" class="btn btn-primary">Agregar</button>
          </div>
        </div>
      </div>
    </div>

    <!-- jQuery -->
    <script src="../Branding/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../Branding/js/bootstrap.min.js"></script>
    <script src="../Branding/js/bootstrap.tab.js"></script>

</body>

</html>