/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.security.NoSuchProviderException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
                DataPedido dp = (DataPedido)it.next();
                if(idPed==dp.getId())
                    pedi=dp;
            }
            Iterator it1 = pedi.getColCarrito().iterator();
            while(it1.hasNext()){
                DataCarrito dc = (DataCarrito)it1.next();
                listaCar.add(dc);
            }
            boolean estado = pedi.getEstado()==Estados.RECIBIDO;
            request.setAttribute("evaluacion", dto);
            request.setAttribute("carrito", listaCar);
            request.setAttribute("pedido", pedi);
            request.setAttribute("recibido", estado);
            request.getRequestDispatcher("/Pantallas/VerPedido.jsp").forward(request, response);
        }
        
        if(request.getParameter("pedido") != null){//trae informacion del pedido
            ArrayList<DataCarrito> listaCar = new ArrayList<>();
            ProxyPedido PP = ProxyPedido.getInstance();
            ProxyProducto PU = ProxyProducto.getInstance();
            String idPed = (String)request.getParameter("pedido");
            long idPedi = Long.parseLong(idPed);
            ArrayList<DataPedido> pedidos = PP.listDataPedidos();
            Iterator it = pedidos.iterator();
            DataPedido pedi=null;
            while(it.hasNext()){
                DataPedido dp = (DataPedido)it.next();
                if(idPedi==dp.getId())
                    pedi=dp;
            }
            Iterator it1 = pedi.getColCarrito().iterator();
            while(it1.hasNext()){
                DataCarrito dc = (DataCarrito)it1.next();
                listaCar.add(dc);
            }
            DtoEvaluacion eva = null;
            if(PP.existeEvaluacioPedido(idPedi)){
                eva = PP.getEvaluacionXid(idPedi);
                request.setAttribute("evaluacion", eva);
            } 
            boolean estado = pedi.getEstado()==Estados.RECIBIDO;
            request.setAttribute("carrito", listaCar);
            request.setAttribute("pedido", pedi);
            request.setAttribute("recibido", estado);
            request.getRequestDispatcher("/Pantallas/VerPedido.jsp").forward(request, response);
        }
        
        if(request.getParameter("pedidosUsuario") != null){//trae informacion del cliente
            ProxyPedido PP = ProxyPedido.getInstance();
            ProxyUsuario PU = ProxyUsuario.getInstance();
            HttpSession session = request.getSession();
            String nick = (String)request.getParameter("pedidosUsuario");
            DataCliente dc=PU.getUsuarioByNickname(nick);
            
            ArrayList<DataPedido> pedidos = PP.listaPedidos(dc.getNickname());
            ArrayList<DataPedido> listaPed = new ArrayList<>();
            Iterator it = pedidos.iterator();
            while (it.hasNext()){
                DataPedido dp = (DataPedido)it.next();
                listaPed.add(dp);
            }
            
            request.setAttribute("cliente", dc);
            request.setAttribute("lPedidos", listaPed);
            request.getRequestDispatcher("/Pantallas/VerPerfilCliente.jsp").forward(request, response);
        }
        if(request.getParameter("comprar") != null){
            ArrayList<DataCarrito> listaCar = new ArrayList<>();
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
                    DataIndividual di = (DataIndividual)it.next();
                    individuales.add(di);
                }
                while(it2.hasNext()){
                    DataPromocional dp = (DataPromocional)it2.next();
                    promocionales.add(dp);
                }
                Iterator evs = PP.listarEvaluacionesRest(nickrest).iterator();
                while (evs.hasNext()) {
                    DtoEvaluacion de = (DtoEvaluacion)evs.next();
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
                    DataIndividual di = (DataIndividual)it.next();
                    individuales.add(di);
                }
                while(it.hasNext()){
                    DataPromocional dp = (DataPromocional)it.next();
                    promocionales.add(dp);
                    

                }
                Iterator evs = PP.listarEvaluacionesRest(nickrest).iterator();
                while (evs.hasNext()) {
                    DtoEvaluacion de = (DtoEvaluacion)evs.next();
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
                DataCarrito dcar = (DataCarrito)it5.next();
                listaCar.add(dcar);
            }
            request.setAttribute("carrito", listaCar);
            request.setAttribute("pedido", dp);
            request.getRequestDispatcher("/Pantallas/Transaccion.jsp").forward(request, response);

            String nickUsu = dp.getNickUsr();
                String mail = dp.getMailUsr();
                String precioTotal = Double.toString(dp.getPrecioTotal());
                String nickRest = dp.getNickRest();
                String tipo, prod = "";
                String fecha = dp.getFecha();
                int hora, minutos;
                String hour, min;

                Calendar calendario = new GregorianCalendar();
                hora = calendario.get(Calendar.HOUR_OF_DAY);
                minutos = calendario.get(Calendar.MINUTE);
                hour = Integer.toString(hora);
                min = Integer.toString(minutos);

                for (DataCarrito i : dp.getColCarrito()) {
                    if (i.isPromo()) {
                        tipo = "Promocional";
                    } else {
                        tipo = "Individual";
                    }
                    prod = prod + "    -Nombre: " + i.getNomProd() + "   -Tipo: " + tipo + "  - Cantidad: " + i.getCantidad() + "\n ";
                }

                try {
                    this.enviarMail(fecha, prod, nickUsu, mail, precioTotal, nickRest, hour, min);
                } catch (NoSuchProviderException | MessagingException ex) {
                    Logger.getLogger(PedidoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }
    
    
        public void enviarMail(String fecha, String prod, String nickUsu, String mail, String precioTotal, String nickRest, String hora, String minutos) throws NoSuchProviderException, MessagingException {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "localhost");
        props.setProperty("mail.smtp.user", "hola@hola.com");
        props.setProperty("mail.smtp.port", "1025");
        props.setProperty("mail.smtp.password", "");

        Session mailSession = Session.getDefaultInstance(props, null);
        Transport transport = mailSession.getTransport();
        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("[Quick Order]" + "[" + fecha + "  " + hora + ":" + minutos + "]");
        message.setText("Asunto\n[QuickOrder]" + "[" + fecha + "  " + hora + ":" + minutos + "]\n\nEstimado/a " + nickUsu + ". Su pedido ha sido realizado con exito.\n"
                + "--Detalle del pedido\n-Productos:\n " + prod + "- Precio Total: " + precioTotal
                + "\n\nGracias por preferirnos,\nSaludos\n" + nickRest);

        message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
        transport.connect();
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();
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
