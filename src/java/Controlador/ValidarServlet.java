package Controlador;

import Modelo.DAO;
import Modelo.Usuario;
import Modelo.Error;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ValidarServlet", urlPatterns = {"/validar.do"})
public class ValidarServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        DAO dao = new DAO();
        
        String Mail, pass;
        
        Mail = request.getParameter("txtMail");
        pass = request.getParameter("txtPass");
        
        Usuario u = new Usuario(Mail, pass);
        Usuario u2 = dao.exist(u);
        
        HttpSession session = request.getSession();
        if(u2.existeError()){
            //Enviar a error.view (Lista de errores)
            List<Error> errores = u2.getErrores();
            //HttpSession session = request.getSession();
            session.setAttribute("errores", errores);
            request.getRequestDispatcher("error.view").forward(request, response);
        }
        else{
            //Ir al menu
            //HttpSession session = request.getSession();
            session.setAttribute("Usuario", u2);
            request.getRequestDispatcher("menu.view").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
