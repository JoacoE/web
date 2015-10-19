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
import lab01.Clases.DTOIngresarDatos;
import lab01.Clases.DTORegistrarCliente;
import lab01.Clases.DataCategoria;
import lab01.Clases.DataCliente;
import lab01.Clases.DataRestaurante;
import lab01.Handlers.Fabrica;
import lab01.Handlers.HImagenes;
import lab01.Interfaces.ICtrlUsuario;
import java.util.ArrayList;
import java.util.Iterator;
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
   
    
    public void validar(String correo, String nick){
        Fabrica f = Fabrica.getInstance();
        ICtrlUsuario ICU = f.getICtrlUsuario();
        if(!ICU.existeUsuario(nick, correo)){
            setMail(correo);
            setNombre(nick);
        }
            

        
    }
    
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
            session.removeAttribute("dcliente");
            session.setAttribute("iniciada", "false");
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
        if(request.getParameter("home")!=null){
            Fabrica f = Fabrica.getInstance();
            ICtrlUsuario ICU = f.getICtrlUsuario();
            HttpSession session = request.getSession();
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
        if(request.getParameter("list-group-item") != null){
            Fabrica fabrica = Fabrica.getInstance();
            ICtrlUsuario ICU = fabrica.getICtrlUsuario();
            String cat = (String)request.getParameter("list-group-item");
            ArrayList<DataRestaurante> restaurantes = new ArrayList<>();
            Iterator it = ICU.listaUsuPorCategoria(cat).entrySet().iterator();
            while(it.hasNext()){
                Map.Entry rests = (Map.Entry)it.next();
                DataRestaurante dr = (DataRestaurante)rests.getValue();
                restaurantes.add(dr);
            }
            Iterator cats = ICU.retColCat().entrySet().iterator();
            ArrayList<DataCategoria> lista = new ArrayList<>();
            while (cats.hasNext()){
                Map.Entry categs =(Map.Entry)cats.next();
                DataCategoria categ = (DataCategoria)categs.getValue();    
                lista.add(categ);
            }
            request.setAttribute("list", lista);
            request.setAttribute("listres", restaurantes);
            request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);
        }        
        if(request.getParameter("search") !=null){
            String busqueda = (String)request.getParameter("search");
            Fabrica fabrica = Fabrica.getInstance();
            ICtrlUsuario ICU = fabrica.getICtrlUsuario();
            ArrayList<DataRestaurante> dr=ICU.buscarRestaurantes(busqueda);
            Iterator cats = ICU.retColCat().entrySet().iterator();
            ArrayList<DataCategoria> lista = new ArrayList<>();
            while (cats.hasNext()){
                Map.Entry categs =(Map.Entry)cats.next();
                DataCategoria categ = (DataCategoria)categs.getValue();    
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
            boolean mail =ICU.existeMail(id);
            boolean nick =ICU.existeNickname(id);

            if(mail || nick){
                while(it.hasNext()){
                    Map.Entry usuarios = (Map.Entry)it.next();
                    DataCliente dc = (DataCliente)usuarios.getValue();
                    if(dc.getNickname().equals(id) || dc.getMail().equals(id)){
                        usuario = dc;
                    }
                }
                if(usuario.getPwd().equals(pwd)){
                    request.setAttribute("usuario", usuario.getNickname());
                    session.setAttribute("iniciada", "true");
                    session.setAttribute("dcliente", usuario);
                }else{
                    //avisar al jsp que esta mal la pwd xD
                }
                if(!usuario.getImagen().isEmpty()){
                    imagen = HI.getImagen(usuario.getNickname());
                    //String path = session.getServletContext().getRealPath("/web/build/web/WEB-INF/lib/imagenes");
                    String path = imagen.getPath();
                    String url = path.concat(".jpeg");
                    request.setAttribute("imgPerfil", url);
                    
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
        if(request.getParameter("registrar") != null){
            Fabrica fabrica = Fabrica.getInstance();
            ICtrlUsuario ICU = fabrica.getICtrlUsuario();
            HttpSession session = request.getSession();
            String nickname = request.getParameter("txtNickname");
            String email = request.getParameter("txtMail");
            if(!ICU.existeUsuario(nickname, email)){
                setMail(email);
                setNombre(nickname);
                request.getRequestDispatcher("/Pantallas/RegistrarCliente.jsp").forward(request, response);
            }

        }
            if(request.getParameter("btnReg") != null){//registrar cliente
            Fabrica fabrica = Fabrica.getInstance();
            ICtrlUsuario ICU = fabrica.getICtrlUsuario();
            HttpSession session = request.getSession();
            HImagenes HI = HImagenes.getInstance();
            File imagen = null;
            String nickname, email, nombre, apellido, fecha, direccion, pwd;
            nickname = getNombre();
            email = getMail();
            nombre = request.getParameter("txtNombre");
            apellido = request.getParameter("txtApellido");
            fecha = request.getParameter("datepicker");
            direccion = request.getParameter("txtDireccion");
            pwd = request.getParameter("txtPass");
            imagen = new File((String)request.getAttribute("imagen"));
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
//                if(imagen.exists()){
//                    HI.guardarImagen(imagen, nickname);
//                    regCliente.setImagen(nickname);
//                }else{
//                    regCliente.setImagen("");
//                }
//                ICU.registrarCliente(regCliente);
//            }
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
