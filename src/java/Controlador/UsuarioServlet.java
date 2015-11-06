/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;
import lab01.server.DataCategoria;
import lab01.server.DataCliente;
import lab01.server.DataRestaurante;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lab01.server.DtoEvaluacion;
import lab01.server.DataIndividual;
import lab01.server.DataPromocional;
import lab01.server.DtoIngresarDatos;
import lab01.server.DtoRegistrarCliente;

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
    private String nombre;
    private String mail;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void validar(String correo, String nick) {
        ProxyUsuario ICU = ProxyUsuario.getInstance();
        if (!ICU.existeUsuario(nick, correo)) {
            setMail(correo);
            setNombre(nick);
        }

    }
//    lab01.server.PublicadorUsuarioService serviceUsuario =  new PublicadorUsuarioService();
//    lab01.server.PublicadorUsuario  port =  serviceUsuario.getPublicadorUsuarioPort();
    
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
        if (request.getParameter("cargaDatos") != null) {
            ProxyUsuario PU = ProxyUsuario.getInstance();
            ArrayList<DataCategoria> lista = new ArrayList<>();
            Iterator it3 = PU.retColCat().iterator();
            while (it3.hasNext()) {
                Map.Entry cats = (Map.Entry) it3.next();
                DataCategoria cat = (DataCategoria) cats.getValue();
                lista.add(cat);
            }
            Iterator it2 = PU.listaDataRestaurantes().iterator();
            ArrayList<DataRestaurante> listaRes = new ArrayList<>();
            while (it2.hasNext()) {
                Map.Entry res = (Map.Entry) it2.next();
                DataRestaurante r = (DataRestaurante) res.getValue();
                listaRes.add(r);
            }
            request.setAttribute("list", lista);
            request.setAttribute("listres", listaRes);
            request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);


        }

        if (request.getParameter("cerrar") != null) {
            //Fabrica f = Fabrica.getInstance();
            ProxyUsuario PU = ProxyUsuario.getInstance();
            //ICtrlUsuario PU = .getICtrlUsuario();
            HttpSession session = request.getSession();
            session.removeAttribute("usuario");
            session.removeAttribute("dcliente");
            session.setAttribute("iniciada", "false");
            Iterator it3 = PU.retColCat().iterator();
            ArrayList<DataCategoria> lista = new ArrayList<>();
            while (it3.hasNext()) {
                DataCategoria cat = (DataCategoria)it3.next();
                lista.add(cat);
            }
            Iterator it2 = PU.listaDataRestaurantes().iterator();
            ArrayList<DataRestaurante> listaRes = new ArrayList<>();
            while (it2.hasNext()) {
                Map.Entry res = (Map.Entry) it2.next();
                DataRestaurante r = (DataRestaurante) res.getValue();
                listaRes.add(r);
            }
            request.setAttribute("list", lista);
            request.setAttribute("listres", listaRes);
            request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);

        }
        if (request.getParameter("home") != null) {
//            Fabrica f = Fabrica.getInstance();
//            ICtrlUsuario ICU = f.getICtrlUsuario();
            ProxyUsuario PU = ProxyUsuario.getInstance();
            HttpSession session = request.getSession();
            Iterator it3 = PU.retColCat().iterator();
            ArrayList<DataCategoria> lista = new ArrayList<>();
            while (it3.hasNext()) {
                DataCategoria cat = (DataCategoria)it3.next();
                lista.add(cat);
            }
            Iterator it2 = PU.listaDataRestaurantes().iterator();
            ArrayList<DataRestaurante> listaRes = new ArrayList<>();
            while (it2.hasNext()) {
                DataRestaurante r = (DataRestaurante)it2.next();
                listaRes.add(r);
            }
            request.setAttribute("list", lista);
            request.setAttribute("listres", listaRes);
            request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);
        }
        if(request.getParameter("restaurante") != null){
            ProxyUsuario PU = ProxyUsuario.getInstance();
            ProxyPedido PP = ProxyPedido.getInstance();

            ArrayList<DataIndividual> individuales = new ArrayList<>();
            ArrayList<DataPromocional> promocionales = new ArrayList<>();
            ArrayList<DtoEvaluacion> evaluaciones = new ArrayList<>();
            String nickname = (String) request.getParameter("restaurante");
            DataRestaurante dr = PU.getRestauranteByNickname(nickname);
            Iterator indvs = dr.getColIndividuales().iterator();
            Iterator proms = dr.getColPromocionales().iterator();
            Iterator evs = PP.listarEvaluacionesRest(nickname).iterator();
            while(indvs.hasNext()){
                    DataIndividual di = (DataIndividual)indvs.next();
                    individuales.add(di);
            }
            while(proms.hasNext()){
                DataPromocional dp = (DataPromocional)proms.next();
                promocionales.add(dp);
            } 
            while(evs.hasNext()){
                DtoEvaluacion de = (DtoEvaluacion) evs.next();
                evaluaciones.add(de);
            }
            request.setAttribute("restaurante", dr);
            request.setAttribute("individuales", individuales);
            request.setAttribute("promocionales", promocionales);
            request.setAttribute("evaluaciones", evaluaciones);
            request.getRequestDispatcher("/Pantallas/VerInfoRestaurante.jsp").forward(request, response);
        }
        if(request.getParameter("list-group-item") != null){
            ProxyUsuario PU = ProxyUsuario.getInstance();
            String cat = (String) request.getParameter("list-group-item");
            ArrayList<DataRestaurante> restaurantes = new ArrayList<>();
            Iterator it = PU.listaUsuPorCategoria(cat).iterator();
            while (it.hasNext()) {
                DataRestaurante dr = (DataRestaurante)it.next();
                restaurantes.add(dr);
            }
            Iterator cats = PU.retColCat().iterator();
            ArrayList<DataCategoria> lista = new ArrayList<>();
            while (cats.hasNext()) {
                DataCategoria categ = (DataCategoria)cats.next();
                lista.add(categ);
            }
            request.setAttribute("list", lista);
            request.setAttribute("listres", restaurantes);
            request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);
        }
        if (request.getParameter("search") != null) {
            String busqueda = (String) request.getParameter("search");
            //Fabrica fabrica = Fabrica.getInstance();
            ProxyUsuario PU = ProxyUsuario.getInstance();
            //ICtrlUsuario ICU = fabrica.getICtrlUsuario();
            ArrayList<DataRestaurante> dr = PU.buscarRestaurantes(busqueda);
            Iterator cats = PU.retColCat().iterator();
            ArrayList<DataCategoria> lista = new ArrayList<>();
            while (cats.hasNext()) {
                DataCategoria categ = (DataCategoria)cats.next();
                lista.add(categ);
            }
            request.setAttribute("list", lista);
            request.setAttribute("listres", dr);
            request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);
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
        if (request.getParameter("ingresar") != null) {
            //Fabrica fabrica = Fabrica.getInstance();
            //ICtrlUsuario ICU = fabrica.getICtrlUsuario();
            ProxyUsuario PU = ProxyUsuario.getInstance();
            HttpSession session = request.getSession();
            //HImagenes HI = HImagenes.getInstance();
            File imagen = null;
            ImageIcon noImage = null;
            String id, pwd;
            id = request.getParameter("txtCorreo");
            pwd = request.getParameter("txtPass");
            DataCliente usuario = null;
            Iterator it = PU.devListaDC().iterator();
            boolean mail = PU.existeMail(id);
            boolean nick = PU.existeNickname(id);

            if (mail || nick) {
//                while (it.hasNext()) {
//                    Map.Entry usuarios = (Map.Entry) it.next();
//                    DataCliente dc = (DataCliente) usuarios.getValue();
//                    if (dc.getNickname().equals(id) || dc.getEmail().equals(id)) {
//                        usuario = dc;
//                    }
//                }
                List<DataCliente> lista = PU.devListaDC();
                
                for(int i = 0; i<lista.size();i++){
                        if(lista.get(i).getNickname().equals(id) || lista.get(i).getEmail().equals(id)){
                            usuario = lista.get(i);
                            if (usuario.getPwd().equals(pwd)) {
                                request.setAttribute("usuario", usuario.getNickname());
                                session.setAttribute("iniciada", "true");
                                session.setAttribute("dcliente", usuario);
                            } else {
                                request.setAttribute("pass", "incorrecto");
                            }
                        }
                        
//                    if (!usuario.getImagen().isEmpty()) {
//                        //imagen = HI.getImagen(usuario.getNickname());
//                        //String path = session.getServletContext().getRealPath("/web/build/web/WEB-INF/lib/imagenes");
//                        String path = imagen.getPath();
//                        String url = path.concat(".jpeg");
//                        request.setAttribute("imgPerfil", url);
//
//                    } else {
//                        //noImage = HI.getNoImgeUsuario();
//                        //request.setAttribute("noImg", noImage);
//                    }
                }
            } else {
                    request.setAttribute("succesmail", "incorrecto");
            }
            Iterator it3 = PU.retColCat().iterator();
            ArrayList<DataCategoria> lista = new ArrayList<>();
            while (it3.hasNext()) {
                DataCategoria cat = (DataCategoria)it3.next();
                lista.add(cat);
            }
            Iterator it2 = PU.listaDataRestaurantes().iterator();
            ArrayList<DataRestaurante> listaRes = new ArrayList<>();
            while (it2.hasNext()) {
                DataRestaurante r = (DataRestaurante)it2.next();
                listaRes.add(r);
            }
            request.setAttribute("list", lista);
            request.setAttribute("listres", listaRes);
            request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);
        }
        if(request.getParameter("registrar") != null){
//            Fabrica fabrica = Fabrica.getInstance();
//            ICtrlUsuario ICU = fabrica.getICtrlUsuario();
            ProxyUsuario PU = ProxyUsuario.getInstance();
            HttpSession session = request.getSession();
            String nickname = request.getParameter("txtNickname");
            String email = request.getParameter("txtMail");
            if (!PU.existeUsuario(nickname, email)) {
                setMail(email);
                setNombre(nickname);
                request.getRequestDispatcher("/Pantallas/RegistrarCliente.jsp").forward(request, response);
            }
            else{
                
                Iterator it3 = PU.retColCat().iterator();
            ArrayList<DataCategoria> lista = new ArrayList<>();
            while (it3.hasNext()) {
                DataCategoria cat = (DataCategoria)it3.next();
                lista.add(cat);
            }
            Iterator it2 = PU.listaDataRestaurantes().iterator();
            ArrayList<DataRestaurante> listaRes = new ArrayList<>();
            while (it2.hasNext()) {
                DataRestaurante r = (DataRestaurante)it2.next();
                listaRes.add(r);
            }
            request.setAttribute("list", lista);
            request.setAttribute("listres", listaRes);
                
                
            String alert = "El usuario ya existe";
            request.setAttribute("alertaUsuario", alert);
            request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);
            }

        }
        if(request.getParameter("btnReg") != null){//registrar cliente
            ProxyUsuario PU = ProxyUsuario.getInstance();

            HttpSession session = request.getSession();
            //HImagenes HI = HImagenes.getInstance();
            File imagen = null;
            String nickname, email, nombre, apellido, fecha, direccion, pwd, confirm;
            nickname = getNombre();
            email = getMail();
            nombre = request.getParameter("txtNombre");
            apellido = request.getParameter("txtApellido");
            fecha = request.getParameter("datepicker");
            direccion = request.getParameter("txtDireccion");
            pwd = request.getParameter("txtPass");
            confirm = request.getParameter("txtConfirmPass");
//            imagen = new File((String)request.getAttribute("imagen"));
            if (!PU.existeUsuario(nickname, email)) {
                if (pwd.equals(confirm)) {
                    DtoIngresarDatos ingDatos = new DtoIngresarDatos();
                    ingDatos.setNickname(nickname);
                    ingDatos.setEmail(email);
                    ingDatos.setNombre(nombre);
                    ingDatos.setDireccion(direccion);
                    PU.ingresarDatos(ingDatos);
                    DtoRegistrarCliente regCliente = new DtoRegistrarCliente();
                    regCliente.setApellido(apellido);
                    regCliente.setFecha(fecha);
                    regCliente.setPwd(pwd);
    //                if(imagen.exists()){
                    //                    HI.guardarImagen(imagen, nickname);
                    //                    regCliente.setImagen(nickname);
                    //                }else{
                    //                    regCliente.setImagen("");
                    //                }
                    PU.registrarCliente(regCliente);
                    Iterator it3 = PU.retColCat().iterator();
                    ArrayList<DataCategoria> lista = new ArrayList<>();
                    while (it3.hasNext()) {
                       DataCategoria cat = (DataCategoria)it3.next();
                       lista.add(cat);
                    }
                    Iterator it2 = PU.listaDataRestaurantes().iterator();
                    ArrayList<DataRestaurante> listaRes = new ArrayList<>();
                    while (it2.hasNext()) {
                        DataRestaurante r = (DataRestaurante)it2.next();
                        listaRes.add(r);
                    }
                    request.setAttribute("list", lista);
                    request.setAttribute("listres", listaRes);
                    request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);

                } else {
                    request.getRequestDispatcher("/Pantallas/RegistrarCliente.jsp").forward(request, response);

                }
            }

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
