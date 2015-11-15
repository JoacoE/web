/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Controlador;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
import java.util.Map;
import javax.imageio.ImageIO;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
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
@MultipartConfig
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
    private String userdir = System.getProperty("user.dir").concat("/Uploads");
   
    public void getCarpeta(){
        boolean uploads = (new File(userdir).mkdir());
        if(!uploads){
            File directorio = new File(userdir);
            if(!directorio.exists()){
                throw new NullPointerException();
            }
        }
    }
    
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
            ProxyUsuario PU = ProxyUsuario.getInstance();
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
                DataRestaurante r = (DataRestaurante)it2.next();
                listaRes.add(r);
            }
            request.setAttribute("list", lista);
            request.setAttribute("listres", listaRes);
            request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);

        }
        if (request.getParameter("home") != null) {
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
            String decode = "data:image/png;charset=utf-8;base64,";
            ArrayList<String> imagenes = new ArrayList<>();
            for(String s: dr.getLstImagen()){
                String agregar = decode.concat(s);
                imagenes.add(agregar);
            }
            String primera = imagenes.get(0);
            imagenes.remove(0);
            request.setAttribute("restaurante", dr);
            request.setAttribute("individuales", individuales);
            request.setAttribute("promocionales", promocionales);
            request.setAttribute("evaluaciones", evaluaciones);
            request.setAttribute("primera", primera);
            request.setAttribute("imagenes", imagenes);
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
            ProxyUsuario PU = ProxyUsuario.getInstance();
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
            ProxyUsuario PU = ProxyUsuario.getInstance();
            HttpSession session = request.getSession();
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
                for(DataCliente dc: PU.devListaDC()){
                        if(dc.getNickname().equals(id) || dc.getEmail().equals(id)){
                            usuario = dc;
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
                    if(request.getPart("imagen") != null){
                        getCarpeta();
                        Part filePart = request.getPart("imagen");
                        String fileName = filePart.getSubmittedFileName();
                        File imagen = new File(userdir,nickname);
                        try(InputStream input = filePart.getInputStream()){
                            Files.copy(input, imagen.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        }catch(Exception e){
                            e = new IOException();
                        }
                        BufferedImage bufferImagen = ImageIO.read(imagen);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(bufferImagen, "jpeg", baos);
                        baos.flush();
                        byte[] imageinbyteArray = baos.toByteArray();
                        baos.close();
                        String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageinbyteArray);
//                        WritableRaster raster = bufferImagen.getRaster();
//                        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
                        regCliente.setImagen(b64);
                    }

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
