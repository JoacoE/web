<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmación</title>
    </head>
    <body>
    <div class="container">
        <jsp:include page="/layout/head.jsp"/>
       
        <form role="form">

              <div class="header pull-center">
                    <h2>¡Su pedido ha sido realizado con éxito!</h2>
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
              <div class="footer">
                    <input class="btn btn-danger"  type="submit" value="Volver" name="btnCancelar">
              </div>

        </form>
    </div>
    </body>
</html>