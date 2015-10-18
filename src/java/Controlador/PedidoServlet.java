/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab01.Clases.Cliente;
import lab01.Clases.DTOEvaluacion;
import lab01.Clases.DataCarrito;
import lab01.Clases.DataCliente;
import lab01.Clases.DataPedido;
import lab01.Clases.DataRestaurante;
import lab01.Handlers.Fabrica;
import lab01.Interfaces.ICtrlPedido;
import lab01.Interfaces.ICtrlUsuario;

/**
 *
 * @author joaco
 */
@WebServlet(name = "PedidoServlet", urlPatterns = {"/pedido"})
public class PedidoServlet extends HttpServlet {

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
        
        if(request.getParameter("comment") != null){
            Fabrica f = Fabrica.getInstance();
            ICtrlPedido ICP = f.getICtrlPedido();
            
            String comentario = (String)request.getParameter("comment");  
            HttpSession sesion = request.getSession();
            String sobaquena = (String)sesion.getAttribute("idPed");
            DTOEvaluacion dto = new DTOEvaluacion(comentario,4);
            ICP.altaEvaluacion(Long.parseLong(sobaquena), dto);
            String punt = (String)request.getParameter("puntaje"); 
            
//            ICtrlUsuario ICU = f.getICtrlUsuario();
            
            request.getRequestDispatcher("/Pantallas/VerPedido.jsp").forward(request, response);
        }
        
            if(request.getParameter("pedido") != null){
            ArrayList<DataCarrito> listaCar = new ArrayList<>();
            Fabrica f = Fabrica.getInstance();
            ICtrlPedido ICP = f.getICtrlPedido();
            ICtrlUsuario ICU = f.getICtrlUsuario();
            String idPed = (String)request.getParameter("pedido");
            long idPedi = Long.parseLong(idPed);
            Map pedidos = ICP.listDataPedidos();
            Iterator it = pedidos.entrySet().iterator();
            DataPedido pedi=null;
            while(it.hasNext()){
                Map.Entry pedido = (Map.Entry) it.next();
                DataPedido dp = (DataPedido)pedido.getValue();
                if(idPedi==dp.getId())
                    pedi=dp;
            }
            Iterator it1 = pedi.getColCarrito().entrySet().iterator();
            while(it1.hasNext()){
                Map.Entry colca = (Map.Entry) it1.next();
                DataCarrito dc = (DataCarrito)colca.getValue();
                listaCar.add(dc);
            }
        DTOEvaluacion eva = ICP.getEvaluacionXid(idPedi);
        
        request.setAttribute("evaluacion", eva);
        request.setAttribute("carrito", listaCar);
        request.setAttribute("pedido", pedi);
        request.getRequestDispatcher("/Pantallas/VerPedido.jsp").forward(request, response);
        }
        
        if(request.getParameter("pedidosUsuario") != null){//devuelve los pedidos de un usuario...
            Fabrica f = Fabrica.getInstance();
            ICtrlPedido ICP = f.getICtrlPedido();
            ICtrlUsuario ICU = f.getICtrlUsuario();
            HttpSession session = request.getSession();
            //String nick = (String)session.getAttribute("usuario");
            String nick = (String)request.getParameter("pedidosUsuario");
            DataCliente dc=ICU.getUsuarioByNickname(nick);
            
            Map pedidos = ICP.listaPedidosRecibidos(dc.getNickname());
            ArrayList<DataPedido> listaPed = new ArrayList<>();
            Iterator it = pedidos.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry res =(Map.Entry)it.next();
                DataPedido dp = (DataPedido)res.getValue();    
                listaPed.add(dp);
            }
            request.setAttribute("cliente", dc);
            request.setAttribute("lPedidos", listaPed);
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
