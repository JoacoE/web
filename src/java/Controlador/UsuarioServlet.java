/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
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
import javax.swing.ImageIcon;
import lab01.Clases.DTOIngresarDatos;
import lab01.Clases.DTORegistrarCliente;
import lab01.Clases.DataCategoria;
import lab01.Clases.DataCliente;
import lab01.Clases.DataRestaurante;
import lab01.Handlers.Fabrica;
import lab01.Handlers.HImagenes;
import lab01.Interfaces.ICtrlUsuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lab01.Clases.DTOEvaluacion;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataPromocional;
import lab01.Interfaces.ICtrlPedido;

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
    
        if(request.getParameter("cerrar") != null){
            Fabrica f = Fabrica.getInstance();
            ICtrlUsuario ICU = f.getICtrlUsuario();
            HttpSession session = request.getSession();
            session.removeAttribute("usuario");
            Iterator it3 = ICU.retColCat().entrySet().iterator();
            ArrayList<DataCategoria> lista = new ArrayList<>();
            while (it3.hasNext()){
                Map.Entry cats =(Map.Entry)it3.next();
                DataCategoria cat = (DataCategoria)cats.getValue();    
                lista.add(cat);
            }
            Iterator it2 = ICU.listaDataRestaurantes().entrySet().iterator();
            ArrayList<DataRestaurante> listaRes = new ArrayList<>();
            while (it2.hasNext()){
                Map.Entry res =(Map.Entry)it2.next();
                DataRestaurante r = (DataRestaurante)res.getValue();    
                listaRes.add(r);
            }
            request.setAttribute("list", lista);
            request.setAttribute("listres", listaRes);
            request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);
            
        }
        
        if(request.getParameter("restaurante") != null){
            Fabrica f = Fabrica.getInstance();
            ICtrlUsuario ICU = f.getICtrlUsuario();
            ICtrlPedido ICP = f.getICtrlPedido();
            ArrayList<DataIndividual> individuales = new ArrayList<>();
            ArrayList<DataPromocional> promocionales = new ArrayList<>();
            ArrayList<DTOEvaluacion> evaluaciones = new ArrayList<>();
            String nickname = (String)request.getParameter("restaurante");
            DataRestaurante dr = ICU.getRestauranteByNickname(nickname);
            Iterator it = dr.getColProducto().entrySet().iterator();
            while(it.hasNext()){
                Map.Entry productos = (Map.Entry)it.next();
                if(productos.getValue() instanceof DataIndividual){
                    DataIndividual di = (DataIndividual)productos.getValue();
                    individuales.add(di);
                }
                if(productos.getValue() instanceof DataPromocional){
                    DataPromocional dp = (DataPromocional)productos.getValue();
                    promocionales.add(dp);
                }
            }
            Iterator evs = ICP.listarEvaluacionesRest(nickname).entrySet().iterator();
            while(evs.hasNext()){
                Map.Entry evals = (Map.Entry)evs.next();
                DTOEvaluacion de = (DTOEvaluacion)evals.getValue();
                evaluaciones.add(de);
            }
            request.setAttribute("restaurante", dr);
            request.setAttribute("individuales", individuales);
            request.setAttribute("promocionales", promocionales);
            request.setAttribute("evaluaciones", evaluaciones);
            request.getRequestDispatcher("/Pantallas/VerInfoRestaurante.jsp").forward(request, response);
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
            id = request.getParameter("txtCorreo");
            pwd = request.getParameter("txtPass");
            DataCliente usuario = null;
            Iterator it = ICU.devListaDC().entrySet().iterator();
            if(ICU.existeNickname(id) || ICU.existeMail(id)){
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
            }else{
                //avisar al jsp que esta mal el id xD
            }    
            Iterator it3 = ICU.retColCat().entrySet().iterator();
            ArrayList<DataCategoria> lista = new ArrayList<>();
            while (it3.hasNext()){
                Map.Entry cats =(Map.Entry)it3.next();
                DataCategoria cat = (DataCategoria)cats.getValue();    
                lista.add(cat);
            }
            Iterator it2 = ICU.listaDataRestaurantes().entrySet().iterator();
            ArrayList<DataRestaurante> listaRes = new ArrayList<>();
            while (it2.hasNext()){
                Map.Entry res =(Map.Entry)it2.next();
                DataRestaurante r = (DataRestaurante)res.getValue();    
                listaRes.add(r);
            }
            request.setAttribute("list", lista);
            request.setAttribute("listres", listaRes);
            request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);
        }
        if(request.getParameter("registrar") != null){//registrar cliente
            Fabrica fabrica = Fabrica.getInstance();
            ICtrlUsuario ICU = fabrica.getICtrlUsuario();
            HttpSession session = request.getSession();
            HImagenes HI = HImagenes.getInstance();
            File imagen = null;
            String nickname, email, nombre, apellido, fecha, direccion, pwd;
            nickname = request.getParameter("txtNickname");
            email = request.getParameter("txtMail");
            nombre = request.getParameter("txtNombre");
            apellido = request.getParameter("txtApellido");
            fecha = request.getParameter("txtfecha");
            direccion = request.getParameter("txtDireccion");
            pwd = request.getParameter("txtPass");
            imagen = (File)request.getAttribute("imagen");
            if(!ICU.existeUsuario(nickname, email)){
                DTOIngresarDatos ingDatos = new DTOIngresarDatos();
                ingDatos.setNickname(nickname);
                ingDatos.setEmail(email);
                ingDatos.setNombre(nombre);
                ingDatos.setDireccion(direccion);
                ICU.ingresarDatos(ingDatos);
                DTORegistrarCliente regCliente = new DTORegistrarCliente();
                regCliente.setApellido(apellido);
                regCliente.setFecha(fecha);
                regCliente.setPwd(pwd);
                if(imagen.exists()){
                    HI.guardarImagen(imagen, nickname);
                    regCliente.setImagen(nickname);
                }else{
                    regCliente.setImagen("");
                }
                ICU.registrarCliente(regCliente);
            }
//            borrar este comentario
            request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);//deberia mandarlo a iniciar sesion
        }
//        
//        if(request.getParameter("/*parametro*/") != null){
//            Fabrica fabrica = Fabrica.getInstance();
//            ICtrlUsuario ICU = fabrica.getICtrlUsuario();
//            String id = (String)request.getAttribute("txtMail");
//            String pwd = (String)request.getAttribute("txtPass");
//            DataCliente dc = null;
//            if(ICU.existeNickname(id) || ICU.existeMail(id)){
//                if(ICU.existeNickname(id)){
//                    dc = ICU.getUsuarioByNickname(id);
//                }if(ICU.existeMail(id)){
//                    dc = ICU.getByMail(id);
//                }
//                if(dc.getPwd().equals(pwd)){
//                    HttpSession session = request.getSession();
//                    request.setAttribute("usuario", dc);
//                    request.getRequestDispatcher("/Pantallas/VerPerfilCliente.jsp").forward(request, response);
//                }   
//            }
//        }
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
