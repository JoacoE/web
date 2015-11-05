/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab01.server.*;

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
//            Fabrica f = Fabrica.getInstance();
//            ICtrlPedido PP = f.getICtrlPedido();
//            ICtrlUsuario PU = f.getICtrlUsuario();
            ProxyPedido PP = ProxyPedido.getInstance();
            ProxyUsuario PU = ProxyUsuario.getInstance();
            ArrayList<DataCarrito> listaCar = new ArrayList<>();
            
            String comentario = (String)request.getParameter("comment");  
            HttpSession sesion = request.getSession();
            String idPedi = (String)sesion.getAttribute("idPed");
            String punt = (String)request.getParameter("star"); 
            float puntaje = Float.parseFloat(punt);
            DtoEvaluacion dto = new DtoEvaluacion();
            dto.setComentario(comentario);
            dto.setPuntaje(puntaje);
            dto.setFecha(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            PP.altaEvaluacion(Long.parseLong(idPedi), dto);
            
            
            
            Long idPed = Long.parseLong(idPedi);
            ArrayList<DataPedido> pedidos = PP.listDataPedidos();
            Iterator it = pedidos.iterator();
            DataPedido pedi=null;
            while(it.hasNext()){
                Map.Entry pedido = (Map.Entry) it.next();
                DataPedido dp = (DataPedido)pedido.getValue();
                if(idPed==dp.getId())
                    pedi=dp;
            }
            Iterator it1 = pedi.getColCarrito().iterator();
            while(it1.hasNext()){
                Map.Entry colca = (Map.Entry) it1.next();
                DataCarrito dc = (DataCarrito)colca.getValue();
                listaCar.add(dc);}
            
//            ICtrlUsuario PU = f.getICtrlUsuario();
            
        request.setAttribute("evaluacion", dto);
        request.setAttribute("carrito", listaCar);
        request.setAttribute("pedido", pedi);
        request.getRequestDispatcher("/Pantallas/VerPedido.jsp").forward(request, response);
        }
        
            if(request.getParameter("pedido") != null){
            ArrayList<DataCarrito> listaCar = new ArrayList<>();
//            Fabrica f = Fabrica.getInstance();
//            ICtrlPedido PP = f.getICtrlPedido();
//            ICtrlUsuario PU = f.getICtrlUsuario();
            ProxyPedido PP = ProxyPedido.getInstance();
            ProxyProducto PU = ProxyProducto.getInstance();
            String idPed = (String)request.getParameter("pedido");
            long idPedi = Long.parseLong(idPed);
            ArrayList<DataPedido> pedidos = PP.listDataPedidos();
            Iterator it = pedidos.iterator();
            DataPedido pedi=null;
            while(it.hasNext()){
                Map.Entry pedido = (Map.Entry) it.next();
                DataPedido dp = (DataPedido)pedido.getValue();
                if(idPedi==dp.getId())
                    pedi=dp;
            }
            Iterator it1 = pedi.getColCarrito().iterator();
            while(it1.hasNext()){
                Map.Entry colca = (Map.Entry) it1.next();
                DataCarrito dc = (DataCarrito)colca.getValue();
                listaCar.add(dc);
            }
        DtoEvaluacion eva = PP.getEvaluacionXid(idPedi);
        
        request.setAttribute("evaluacion", eva);
        request.setAttribute("carrito", listaCar);
        request.setAttribute("pedido", pedi);
        request.getRequestDispatcher("/Pantallas/VerPedido.jsp").forward(request, response);
        }
        
        if(request.getParameter("pedidosUsuario") != null){//devuelve los pedidos de un usuario...
//            Fabrica f = Fabrica.getInstance();
//            ICtrlPedido PP = f.getICtrlPedido();
//            ICtrlUsuario PU = f.getICtrlUsuario();
            ProxyPedido PP = ProxyPedido.getInstance();
            ProxyUsuario PU = ProxyUsuario.getInstance();
            HttpSession session = request.getSession();
            //String nick = (String)session.getAttribute("usuario");
            String nick = (String)request.getParameter("pedidosUsuario");
            DataCliente dc=PU.getUsuarioByNickname(nick);
            
            ArrayList<DataPedido> pedidos = PP.listaPedidos(dc.getNickname());
            ArrayList<DataPedido> listaPed = new ArrayList<>();
            Iterator it = pedidos.iterator();
            while (it.hasNext()){
                Map.Entry res =(Map.Entry)it.next();
                DataPedido dp = (DataPedido)res.getValue();    
                listaPed.add(dp);
            }
            request.setAttribute("cliente", dc);
            request.setAttribute("lPedidos", listaPed);
            request.getRequestDispatcher("/Pantallas/VerPerfilCliente.jsp").forward(request, response);
        }
        if(request.getParameter("comprar") != null){
            ArrayList<DataCarrito> listaCar = new ArrayList<>();
//            Fabrica f = Fabrica.getInstance();
//            ICtrlPedido PP = f.getICtrlPedido();
//            ICtrlUsuario PU = f.getICtrlUsuario();
            ProxyPedido PP = ProxyPedido.getInstance();
            ProxyUsuario PU = ProxyUsuario.getInstance();
            HttpSession session = request.getSession();
            String nickrest = request.getParameter("nickrest");
            if(session.getAttribute("iniciada").equals("false")){
                ArrayList<DataIndividual> individuales = new ArrayList<>();
                ArrayList<DataPromocional> promocionales = new ArrayList<>();
                ArrayList<DtoEvaluacion> evaluaciones = new ArrayList<>();
                DataRestaurante dr = PU.getRestauranteByNickname(nickrest);
                Iterator it = dr.getColIndividuales().iterator();
                Iterator it2 = dr.getColPromocionales().iterator();
                while (it.hasNext()) {
                    Map.Entry ind = (Map.Entry) it.next();
                    DataIndividual di = (DataIndividual) ind.getValue();
                    individuales.add(di);
                }
                while(it2.hasNext()){
                    Map.Entry promo =(Map.Entry)it2.next();
                        DataPromocional dp = (DataPromocional) promo.getValue();
                        promocionales.add(dp);
                }
                Iterator evs = PP.listarEvaluacionesRest(nickrest).iterator();
                while (evs.hasNext()) {
                    Map.Entry evals = (Map.Entry) evs.next();
                    DtoEvaluacion de = (DtoEvaluacion) evals.getValue();
                    evaluaciones.add(de);
                }
                request.setAttribute("restaurante", dr);
                request.setAttribute("individuales", individuales);
                request.setAttribute("promocionales", promocionales);
                request.setAttribute("evaluaciones", evaluaciones);
                request.setAttribute("logeado", "no");
                request.getRequestDispatcher("/Pantallas/VerInfoRestaurante.jsp").forward(request, response); 
            }else{
            DataCliente dc = (DataCliente)session.getAttribute("dcliente");            
            String[] nombres = request.getParameterValues("product");
            String[] cantidad = request.getParameterValues("qty");
            
            if(nombres == null){
                String alert = "Debe ingresar productos al carrito";
                request.setAttribute("alert", alert);
                ArrayList<DataIndividual> individuales = new ArrayList<>();
                ArrayList<DataPromocional> promocionales = new ArrayList<>();
                ArrayList<DtoEvaluacion> evaluaciones = new ArrayList<>();
                DataRestaurante dr = PU.getRestauranteByNickname(nickrest);
                Iterator it = dr.getColIndividuales().iterator();
                while (it.hasNext()) {
                    Map.Entry productos = (Map.Entry) it.next();
                    DataIndividual di = (DataIndividual) productos.getValue();
                    individuales.add(di);
                }
                while(it.hasNext()){
                    Map.Entry promo = (Map.Entry) it.next();
                    DataPromocional dp = (DataPromocional) promo.getValue();
                    promocionales.add(dp);
                    

                }
                Iterator evs = PP.listarEvaluacionesRest(nickrest).iterator();
                while (evs.hasNext()) {
                    Map.Entry evals = (Map.Entry) evs.next();
                    DtoEvaluacion de = (DtoEvaluacion) evals.getValue();
                    evaluaciones.add(de);
                }
                request.setAttribute("restaurante", dr);
                request.setAttribute("individuales", individuales);
                request.setAttribute("promocionales", promocionales);
                request.setAttribute("evaluaciones", evaluaciones);
                request.getRequestDispatcher("/Pantallas/VerInfoRestaurante.jsp").forward(request, response);
            }
            
            PP.setNickname(dc.getNickname());
            PP.setMemCliente();
            PP.setMailCliente(dc.getEmail());
            PP.setMemRestaurante(nickrest);
            
            boolean exito = true;
            
            for(int i = 0; i < nombres.length || exito != true; i++){
                exito = PP.selectProductos(nombres[i], Integer.parseInt(cantidad[i]));
            }
            DataPedido dp = PP.altaPedido();
            PP.limpiarCtrl();
            
            Iterator it5 = dp.getColCarrito().iterator();
            while(it5.hasNext()){
                Map.Entry colca = (Map.Entry) it5.next();
                DataCarrito dcar = (DataCarrito)colca.getValue();
                listaCar.add(dcar);
            }
            request.setAttribute("carrito", listaCar);
            request.setAttribute("pedido", dp);
            request.getRequestDispatcher("/Pantallas/Transaccion.jsp").forward(request, response);
            }                     
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
