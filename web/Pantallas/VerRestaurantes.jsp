<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <!--<script type="text/javascript" src="/js/CategoriasTree.js"></script>-->
        <title>Ver Restaurantes</title>
    </head>
    <body>
        <div class="container">
	<div class="row">
        <div class="well" style="width:300px; padding: 8px 0;">
            <div style="overflow-y: scroll; overflow-x: hidden; height: 500px;">
                <ul class="nav nav-list">
                    <li><label class="tree-toggler nav-header">Header 1</label>
                        <ul class="nav nav-list tree">
                            <li><a href="#">Link</a></li>
                            <li><a href="#">Link</a></li>
                            <li><label class="tree-toggler nav-header">Header 1.1</label>
                                <ul class="nav nav-list tree">
                                    <li><a href="#">Link</a></li>
                                    <li><a href="#">Link</a></li>
                                    <li><label class="tree-toggler nav-header">Header 1.1.1</label>
                                        <ul class="nav nav-list tree">
                                            <li><a href="#">Link</a></li>
                                            <li><a href="#">Link</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="divider"></li>
                    <li><label class="tree-toggler nav-header">Header 2</label>
                        <ul class="nav nav-list tree">
                            <li><a href="#">Link</a></li>
                            <li><a href="#">Link</a></li>
                            <li><label class="tree-toggler nav-header">Header 2.1</label>
                                <ul class="nav nav-list tree">
                                    <li><a href="#">Link</a></li>
                                    <li><a href="#">Link</a></li>
                                    <li><label class="tree-toggler nav-header">Header 2.1.1</label>
                                        <ul class="nav nav-list tree">
                                            <li><a href="#">Link</a></li>
                                            <li><a href="#">Link</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li><label class="tree-toggler nav-header">Header 2.2</label>
                                <ul class="nav nav-list tree">
                                    <li><a href="#">Link</a></li>
                                    <li><a href="#">Link</a></li>
                                    <li><label class="tree-toggler nav-header">Header 2.2.1</label>
                                        <ul class="nav nav-list tree">
                                            <li><a href="#">Link</a></li>
                                            <li><a href="#">Link</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
	</div>
</div>
        <script text="text/javascript">
            $(document).ready(function () {
    $('label.tree-toggler').click(function () {
        $(this).parent().children('ul.tree').toggle(300);
    });
});
</script>
    </body>
</html>
