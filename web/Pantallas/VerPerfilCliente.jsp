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
    <!-- Page Content -->
    <div class="container">
        <div class="thumbnail">
            <img src="http://placehold.it/800x300" alt="">
        </div>
        <div class="tabbable">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#1" data-toggle="tab">Información</a>
                </li>
                <li>
                    <a href="#2" data-toggle="tab">Pedidos</a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="1">
                    <h4>ACÁ IRÍA LA INFORMACIÓN DEL CLIENTE</h4>                            
                </div>
                <div class="tab-pane fade" id="2">
                    <h4>ACÁ IRÍAN LOS PEDIDOS DEL CLIENTE</h4>
                </div>                      
            </div>
        </div>
    </div>
    <!-- /.container -->
    <!-- jQuery -->
    <script src="../Branding/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../Branding/js/bootstrap.min.js"></script>
    <script src="../Branding/js/bootstrap.tab.js"></script>

</body>

</html>