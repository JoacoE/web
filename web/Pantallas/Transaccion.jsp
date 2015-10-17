<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lab01.Clases.DataRestaurante"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" type="text/css" href="./Branding/css/nav.css" >

        <title>Confirmación</title>
    </head>
    <body>
    <div class="container">
        <jsp:include page="/layout/head.jsp"/>
        <a href="Transaccion.jsp"></a>
       
        <form role="form" method="POST" accept-charset="UTF-8">

              <div class="header pull-center">
                    <h2>¡Su pedido ha sido realizado con éxito!</h2>
                    <br></br>
                    <h4>ID Pedido: <c:out value="${restaurante.getNickname()}"/></h4>
                    <h4>Restaurante: <c:out value="${restaurante.getNickname()}"/></h4>
              </div>
                <div class="container pull-center">         
                  <table class="table table-condensed pull-center">
                    <thead>
                      <tr>
                        <th>Cantidad</th>
                        <th>Producto</th>
                        <th>Subtotal</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>John</td>
                        <td>Doe</td>
                        <td>john@example.com</td>
                      </tr>
                      <tr>
                        <td>Mary</td>
                        <td>Moe</td>
                        <td>mary@example.com</td>
                      </tr>
                      <tr>
                        <td>July</td>
                        <td>Dooley</td>
                        <td>july@example.com</td>
                      </tr>
                    </tbody>
                  </table>
                <div class="container"> 
                    <h4 >Total: </h4>
                </div>
                </div>
                <br></br>
                <div class="container">
                    <input class="btn btn-info"  type="submit" value="Volver al incio" name="btnVolver" src="../VerInfoRestaurante.jsp">
                </div>

        </form>
    </div>
    </body>
</html>
