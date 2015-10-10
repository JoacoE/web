<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                <!--<script type="text/javascript" src="../Branding/js/head.js"></script>-->
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
    
    
    <script type="text/template" id="tmp-pictureItem">
	<div class="shoppingListItemContent">
		<a href="image" data-toggle="lightbox">
			<img src="thumb" class="img-responsive" />
		</a>
		<!-- Button trigger modal -->
		<div class="clearfix">
			<div class="product-tags pull-left">
				<span class="label label-danger">= photographer</span>
				<span class="label label-info"><tag</span>
			</div>
			<div class="product-price pull-right">
				<span class="price">€ = price.toFixed(2)</span>
			</div>
		</div>
		<div class="infos">
			<h4 class="name text-info">= title</h4>
			<button id="addCart" class="btn btn-danger btn-sm"><i class="fa fa-shopping-cart"></i> Agregar</button>
			<button id="moreInfo" class="btn btn-primary btn-sm hidden-md"><i class="fa fa-info-circle"></i> More Info</button>
		</div>
	</div>
	</script>

	<!-- Template for the single picture box in detail view-->
	<script type="text/template" id="tmp-details">
	<div class="col-md-6">
		<a href="<image" data-toggle="lightbox"><img src="= image" class="img-responsive"/></a>
	</div>
	<div class="col-md-6">
		<div class="product-tags">
			<span class="label label-danger">= photographer</span>
			<span class="label label-info">= tag</span>
		</div>
		<h4>= title</h4>
		<p class="description">= description</p>
		<div class="row">
			<div class="col-sm-3">
				<div class="product-price">€ = price.toFixed(2)</div>
			</div>
			<div class="col-sm-6 col-md-offset-3">
				<button id="cart" class="btn btn-lg btn-danger"><i class="fa fa-shopping-cart"></i> Add to cart</button>
			</div>
		</div>
	</div>
	<button id="back" class="btn btn-default"><i class="fa fa-chevron-left"></i> Back</button>
	</script>

	<!-- Template for the sshopping cart item-->
	<script type="text/template" id="tmp-shoppingCartItem">
		<td class="name"><i class="fa fa-times-circle"></i> = title</td>
		<td class="sub-total">€= total.toFixed(2)</td>
	</script>

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
                <div><h1>TITULO</h1></div>
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
                                <br></br>
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
                            <br></br>
                            <h4>ACÁ IRÍA LA INFORMACIÓN DEL RESTAURANTE</h4>
                        </div>
                        <div class="tab-pane fade" id="3">
                            <div class="row">
                                <div class="col-md-12">
                                    <br></br>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                    Anonymous
                                    <span class="pull-right">10 days ago</span>
                                    <p>This product was great in terms of quality. I would definitely buy another!</p>
                                </div>
                            </div>

                            <hr>

                            <div class="row">
                                <div class="col-md-12">
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                    Anonymous
                                    <span class="pull-right">12 days ago</span>
                                    <p>I've alredy ordered another one!</p>
                                </div>
                            </div>

                            <hr>

                            <div class="row">
                                <div class="col-md-12">
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                    Anonymous
                                    <span class="pull-right">15 days ago</span>
                                    <p>I've seen some better than this, but not at this price. I definitely recommend this item.</p>
                                </div>
                            </div>
                        </div>                        
                    </div>
                </div>  
            </div>
            <div class="col-md-3">
                <div class="navbar navbar-inverse" role="navigation">
                        <div class="container-fluid">
                                <div class="navbar-header">
                                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                                                <span class="sr-only">Toggle navigation</span>
                                                <span class="icon-bar"></span>
                                                <span class="icon-bar"></span>
                                                <span class="icon-bar"></span>
                                        </button>
                                </div>
                                <div class="navbar-collapse collapse">
                                        <h2 id="basket-message" class="text-centre">You have <span id="basket">0</span> items in your basket</h2>
                                </div>
                        </div>
                </div>

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


                                <div class="col-sm-3 col-sm-offset-3 col-md-2 col-md-offset-2 sidebar" id="sidebar">
                                        <table id="shopping-cart" class="table table-responsive">
                                                <tbody id="shopping-list"></tbody>
                                                <tfoot>
                                                        <tr>
                                                                <td colspan="4" id="total">$ 0.00</td>
                                                        </tr>
                                                </tfoot>
                                        </table>
                                        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="showForm">Check out</a>
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
            <button id="addCart" class="btn btn-danger btn-sm">
                <i class="fa fa-shopping-cart"></i>
                    Agregar
            </button>
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

</body>

</html>
