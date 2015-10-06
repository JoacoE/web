/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;
import lab01.Clases.DataCliente;
import lab01.Handlers.Fabrica;
import lab01.Handlers.HImagenes;
import lab01.Interfaces.ICtrlUsuario;

/**
 *
 * @author joaco
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usr"})
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    
        if(request.getParameter("") != null){
            Fabrica fabrica = Fabrica.getInstance();
            ICtrlUsuario ICU = fabrica.getICtrlUsuario();
            HttpSession session = request.getSession();
            DataCliente usuario = ICU.getUsuarioByNickname((String)session.getAttribute("nickname"));//esto es chamullo
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("/Pantallas/VerPerfilCliente.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        if(request.getParameter("ingresar") != null){
            Fabrica fabrica = Fabrica.getInstance();
            ICtrlUsuario ICU = fabrica.getICtrlUsuario();
            HttpSession session = request.getSession();
            HImagenes HI = HImagenes.getInstance();
            File imagen = null;
            ImageIcon noImage = null;
            String id, pwd;
            id = request.getParameter("txtMail");
            pwd = request.getParameter("txtPass");
            DataCliente usuario = null;
            Iterator it = ICU.devListaDC().entrySet().iterator();
            while(it.hasNext()){
                Map.Entry usuarios = (Map.Entry)it.next();
                DataCliente dc = (DataCliente)usuarios.getValue();
                if(dc.getNickname().equals(id) || dc.getMail().equals(id)){
                    usuario = dc;
                }
            }
            if(usuario.getPwd().equals(pwd)){
                request.setAttribute("nickname", usuario.getNickname());
                session.setAttribute(usuario.getNickname(), usuario);
            }else{
                //avisar al jsp que esta mal la pwd xD
            }
            if(!usuario.getImagen().isEmpty()){
                imagen = HI.getImagen(usuario.getNickname());
                request.setAttribute("imgPerfil", imagen);
            }else{
                noImage = HI.getNoImgeUsuario();
                request.setAttribute("noImg", noImage);
            }
            request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
