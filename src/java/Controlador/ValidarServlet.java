package Controlador;

import Modelo.DAO;
import Modelo.Usuario;
import Modelo.Error;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab01.server.DataCategoria;
import lab01.server.DataRestaurante;
import lab01.server.DtoArmarPromo;
import lab01.server.DtoEvaluacion;
import lab01.server.DtoIngresarDatos;
import lab01.server.DtoRegistrarCliente;
import lab01.server.DtoRegistrarProducto;
import lab01.server.Estados;

@WebServlet(name = "ValidarServlet", urlPatterns = {"/validar.do"})
public class ValidarServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        if(request.getParameter("rest") !=null){
            String nombre = (String)request.getParameter("rest");
            request.setAttribute("list", nombre);
            request.getRequestDispatcher("/Pantallas/VerInfoRestaurante.jsp").forward(request, response);
        }

        
        if (request.getParameter("cDatos") != null) {        
        //Fabrica fabrica = Fabrica.getInstance();
        ProxyUsuario ICU = ProxyUsuario.getInstance();
        ProxyPedido ICPed = ProxyPedido.getInstance();
        ProxyProducto ICProd = ProxyProducto.getInstance();
        //HUsuario HU = HUsuario.getinstance();
        //HImagenes HI = HImagenes.getInstance();
        Properties prop;
        InputStream input;
        
        prop = new Properties();
        input = null;
        
        try{
            input = new FileInputStream("/home/joaco/NetBeansProjects/Web/web/WEB-INF/config.testdata");
            //input = new FileInputStream("/home/martin/NetBeansProjects/web/web/WEB-INF/config.testdata");
            //input = new FileInputStream("/home/gera/NetBeansProjects/Lab02/Web/web/config.testdata");

            prop.load(input);

            //CLIENTES nickname,nombre,email,direccion
            DtoIngresarDatos datos1 = new DtoIngresarDatos();
            datos1.setNickname("costas");
            datos1.setNombre("Gerardo");
            datos1.setEmail("costas@gmail.com");
            datos1.setDireccion("Av. Italia 2078");
            ICU.ingresarDatos(datos1);
            File Cuno = new File(prop.getProperty("Cimagen1"));
            if(Cuno.exists()){
                //HI.guardarImagen(Cuno, datos1.getNickname());
                DtoRegistrarCliente dreg1 = new DtoRegistrarCliente(); //apellido,imagen,fecha,pwd
                dreg1.setApellido("Costas");
                dreg1.setImagen("costas");
                dreg1.setFecha("15/11/1983");
                dreg1.setPwd("costas123");
                ICU.registrarCliente(dreg1);
            }else{
                DtoRegistrarCliente dreg1 = new DtoRegistrarCliente();
                dreg1.setApellido("Costas");
                dreg1.setImagen("");
                dreg1.setFecha("15/11/1983");
                dreg1.setPwd("costas123");
                ICU.registrarCliente(dreg1);
            }
            
            DtoIngresarDatos datos2 = new DtoIngresarDatos();
            datos2.setNickname("roro");
            datos2.setNombre("Rodrigo");
            datos2.setEmail("rcotelo@yahoo.com");
            datos2.setDireccion("Pdte. Berro 1548");
            ICU.ingresarDatos(datos2);
            File Cdos = new File(prop.getProperty("Cimagen2"));
            if(Cdos.exists()){
                //HI.guardarImagen(Cdos, datos2.getNickname());
                DtoRegistrarCliente dreg2 = new DtoRegistrarCliente();
                dreg2.setApellido("Cotelo");
                dreg2.setImagen("roro");
                dreg2.setFecha("02/08/1975");
                dreg2.setPwd("12elroro");
                ICU.registrarCliente(dreg2);
            }else{
                DtoRegistrarCliente dreg2 = new DtoRegistrarCliente();
                dreg2.setApellido("Cotelo");
                dreg2.setImagen("");
                dreg2.setFecha("02/08/1975");
                dreg2.setPwd("12elroro");
                ICU.registrarCliente(dreg2);
            }
            

            DtoIngresarDatos datos3 = new DtoIngresarDatos();
            datos3.setNickname("chechi");
            datos3.setNombre("Cecilia");
            datos3.setEmail("cgarrido@hotmail.com");
            datos3.setDireccion("Gral. Urquiza 1548");
            ICU.ingresarDatos(datos3);
            File Ctres = new File(prop.getProperty("Cimagen3"));
            if(Ctres.exists()){    
                //HI.guardarImagen(Ctres, datos3.getNickname());
                DtoRegistrarCliente dreg3 = new DtoRegistrarCliente();
                dreg3.setApellido("Garrido");
                dreg3.setImagen("chechi");
                dreg3.setFecha("12/09/1987");
                dreg3.setPwd("ch4321");
                ICU.registrarCliente(dreg3);
            }else{
                DtoRegistrarCliente dreg3 = new DtoRegistrarCliente();
                dreg3.setApellido("Garrido");
                dreg3.setImagen("");
                dreg3.setFecha("12/09/1987");
                dreg3.setPwd("ch4321");
                ICU.registrarCliente(dreg3);
            }
            
            
            DtoIngresarDatos datos4 = new DtoIngresarDatos();
            datos4.setNickname("andy");
            datos4.setNombre("Andrea");
            datos4.setEmail("agarcia@gmail.com");
            datos4.setDireccion("Dr. Manuel Albo 4512");
            ICU.ingresarDatos(datos4);
            File Ccuatro = new File(prop.getProperty("Cimagen4"));
            if(Ccuatro.exists()){    
                //HI.guardarImagen(Ccuatro, datos4.getNickname());
                DtoRegistrarCliente dreg4 = new DtoRegistrarCliente();      
                dreg4.setApellido("García");
                dreg4.setImagen("andy");
                dreg4.setFecha("28/07/1951");
                dreg4.setPwd("andy_la1");
                ICU.registrarCliente(dreg4);
            }else{
                DtoRegistrarCliente dreg4 = new DtoRegistrarCliente();      
                dreg4.setApellido("García");
                dreg4.setImagen("");
                dreg4.setFecha("28/07/1951");
                dreg4.setPwd("andy_la1");
                ICU.registrarCliente(dreg4);
            }
            
            DtoIngresarDatos datos5 = new DtoIngresarDatos();
            datos5.setNickname("weiss");
            datos5.setNombre("Adrián");
            datos5.setEmail("aweiss@gmail.com");
            datos5.setDireccion("Monte Caseros 5615");
            ICU.ingresarDatos(datos5);
            File Ccinco = new File(prop.getProperty("Cimagen5"));
            if(Ccinco.exists()){    
                //HI.guardarImagen(Ccinco, datos5.getNickname());
                DtoRegistrarCliente dreg5 = new DtoRegistrarCliente();
                dreg5.setApellido("Weiss");
                dreg5.setImagen("weiss");
                dreg5.setFecha("23/12/1978");
                dreg5.setPwd("223_aweis");
                ICU.registrarCliente(dreg5);
            }else{
                DtoRegistrarCliente dreg5 = new DtoRegistrarCliente();
                dreg5.setApellido("Weiss");
                dreg5.setImagen("");
                dreg5.setFecha("23/12/1978");
                dreg5.setPwd("223_aweis");
                ICU.registrarCliente(dreg5);
            }
            
            //CATEGORÍAS

//            ICU.registrarCat("Chivitos");
//            ICU.registrarCat("Minutas");
//            ICU.registrarCat("Parrilla");
//            ICU.registrarCat("Pizzas");
//            ICU.registrarCat("Empanadas");
//            ICU.registrarCat("Milanesas");
//            ICU.registrarCat("Ensaladas");
//            ICU.registrarCat("Pastas");
//            ICU.registrarCat("Comida China");
//            ICU.registrarCat("Picadas");
//            ICU.registrarCat("Woks");
//            ICU.registrarCat("Comida Mexicana");
//            ICU.registrarCat("Entradas");
//            ICU.registrarCat("Bebidas");
//            ICU.registrarCat("Sushi");

            //RESTAURANTES

//            Map Categorias1 = new HashMap();
//            Map cats = new HashMap();
//            for(lab01.server.DataCategoria ci: ICU.retColCat()){
//                cats.put(ci.getNombre(), ci);
//            }
//            Categorias1.put("Chivitos", cats.get("Chivitos"));
//            Categorias1.put("Minutas", cats.get("Minutas"));
//            Categorias1.put("Parrilla", cats.get("Parrilla"));
//            Categorias1.put("Pizzas", cats.get("Pizzas"));
//            lab01.server.DataRestaurante res1 = new lab01.server.DataRestaurante();
//            //res1.setColCategoria(Categorias1);
//            res1.setDireccion("Av 8 de octubre 2704");
//            res1.setEmail("mera@hotmail.com");
//            res1.setNickname("mera");
//            res1.setNombre("Pizzería Mera");
//            ICU.registrarRestaurante(res1);
//
//            Map Categorias2 = new HashMap();
//            Categorias2.put("Chivitos", cats.get("Chivitos"));
//            Categorias2.put("Minutas", cats.get("Minutas"));
//            Categorias2.put("Pastas", cats.get("Pastas"));
//            Categorias2.put("Pizzas", cats.get("Pizzas"));
//            lab01.server.DataRestaurante res2 = new lab01.server.DataRestaurante();
//            //res2.setColCategoria(Categorias2);
//            res2.setDireccion("Bvar. Artigas 1601");
//            res2.setEmail("bar.rossel@gmail.com");
//            res2.setNickname("rossell");
//            res2.setNombre("Bar Rossell");
//            ArrayList<File> arrayfile2 = new ArrayList<>();
//            ArrayList<String> arraystring2 = new ArrayList<>();
//            File Runo = new File(prop.getProperty("Rimagen1"));
//            File Rdos = new File(prop.getProperty("Rimagen2"));
//            if(Runo.exists() && Rdos.exists()){
//                arrayfile2.add(Runo);
//                arrayfile2.add(Rdos);
//                //HI.guardarArrayImg(arrayfile2, res2.getNickname());
//                arraystring2.add(res2.getNickname().concat("0"));
//                arraystring2.add(res2.getNickname().concat("1"));
//                //res2.setLstImagen(arraystring2);
//                ICU.registrarRestaurante(res2);
//            }if(!Runo.exists() || !Rdos.exists()){
//                if(Runo.exists()){
//                    arrayfile2.add(Runo);
//                    //HI.guardarArrayImg(arrayfile2, res2.getNickname());
//                    arraystring2.add(res2.getNickname().concat("0"));
//                    //res2.setLstImagen(arraystring2);
//                    ICU.registrarRestaurante(res2);
//                }else{
//                    arrayfile2.add(Rdos);
//                    //HI.guardarArrayImg(arrayfile2, res2.getNickname());
//                    arraystring2.add(res2.getNickname().concat("0"));
//                    //res2.setLstImagen(arraystring2);
//                    ICU.registrarRestaurante(res2);
//                }
//            }if(!Runo.exists() && !Rdos.exists()){
//                ICU.registrarRestaurante(res2);
//            }
//            
//
//            Map Categorias3 = new HashMap();
//            Categorias3.put("Empanadas", cats.get("Empanadas"));
//            lab01.server.DataRestaurante res3 = new lab01.server.DataRestaurante();
//            //res3.setColCategoria(Categorias3);
//            res3.setDireccion("18 de julio 2138");
//            res3.setEmail("bocatti@gmail.com");
//            res3.setNickname("bocatti");
//            res3.setNombre("Empanadas Bocatti");
//            ArrayList<File> arrayfile3 = new ArrayList<>();
//            ArrayList<String> arraystring3 = new ArrayList<>();
//            File Rtres = new File(prop.getProperty("Rimagen3"));
//            File Rcuatro = new File(prop.getProperty("Rimagen4"));
//            File Rcinco = new File(prop.getProperty("Rimagen5"));
//            if(Rtres.exists() && Rcuatro.exists() && Rcinco.exists()){
//                arrayfile3.add(Rtres);
//                arrayfile3.add(Rcuatro);
//                arrayfile3.add(Rcinco);
//                //HI.guardarArrayImg(arrayfile3, res3.getNickname());
//                arraystring3.add(res3.getNickname().concat("0"));
//                arraystring3.add(res3.getNickname().concat("1"));
//                arraystring3.add(res3.getNickname().concat("2"));
//                //res3.setLstImagen(arraystring3);
//                ICU.registrarRestaurante(res3);
//            }if(!Rtres.exists() && !Rcuatro.exists() && Rcinco.exists()){
//                arrayfile3.add(Rcinco);
//                //HI.guardarArrayImg(arrayfile3, res3.getNickname());
//                arraystring3.add(res3.getNickname().concat("0"));
//                //res3.setLstImagen(arraystring3);
//                ICU.registrarRestaurante(res3);
//            }if(!Rtres.exists() && Rcuatro.exists() && !Rcinco.exists()){
//                arrayfile3.add(Rcuatro);
//                //HI.guardarArrayImg(arrayfile3, res3.getNickname());
//                arraystring3.add(res3.getNickname().concat("0"));
//                //res3.setLstImagen(arraystring3);
//                ICU.registrarRestaurante(res3);
//            }if(Rtres.exists() && !Rcuatro.exists() && !Rcinco.exists()){
//                arrayfile3.add(Rtres);
//                //HI.guardarArrayImg(arrayfile3, res3.getNickname());
//                arraystring3.add(res3.getNickname().concat("0"));
//                //res3.setLstImagen(arraystring3);
//                ICU.registrarRestaurante(res3);
//            }if(Rtres.exists() && Rcuatro.exists() && !Rcinco.exists()){
//                arrayfile3.add(Rtres);
//                arrayfile3.add(Rcuatro);
//                //HI.guardarArrayImg(arrayfile3, res3.getNickname());
//                arraystring3.add(res3.getNickname().concat("0"));
//                arraystring3.add(res3.getNickname().concat("1"));
//                //res3.setLstImagen(arraystring3);
//                ICU.registrarRestaurante(res3);
//            }if(Rtres.exists() && !Rcuatro.exists() && Rcinco.exists()){
//                arrayfile3.add(Rtres);
//                arrayfile3.add(Rcinco);
//                //HI.guardarArrayImg(arrayfile3, res3.getNickname());
//                arraystring3.add(res3.getNickname().concat("0"));
//                arraystring3.add(res3.getNickname().concat("1"));
//                //res3.setLstImagen(arraystring3);
//                ICU.registrarRestaurante(res3);
//            }if(!Rtres.exists() && Rcuatro.exists() && Rcinco.exists()){
//                arrayfile3.add(Rcuatro);
//                arrayfile3.add(Rcinco);
//                //HI.guardarArrayImg(arrayfile3, res3.getNickname());
//                arraystring3.add(res3.getNickname().concat("0"));
//                arraystring3.add(res3.getNickname().concat("1"));
//                //res3.setLstImagen(arraystring3);
//                ICU.registrarRestaurante(res3);
//            }if(!Rtres.exists() && !Rcuatro.exists() && !Rcinco.exists()){
//                ICU.registrarRestaurante(res3);
//            }
//            
//
//            Map Categorias4 = new HashMap();
//            Categorias4.put("Woks", cats.get("Woks"));
//            Categorias4.put("Pastas", cats.get("Pastas"));
//            Categorias4.put("Comida China", cats.get("Comida China"));
//            lab01.server.DataRestaurante res4 = new lab01.server.DataRestaurante();
//            //res4.setColCategoria(Categorias4);
//            res4.setDireccion("Libertad 2535");
//            res4.setEmail("wok.in.box@hotmail.com");
//            res4.setNickname("winb");
//            res4.setNombre("Wok in Box");
//            ArrayList<File> arrayfile4 = new ArrayList<>();
//            ArrayList<String> arraystring4 = new ArrayList<>();
//            File Rseis = new File(prop.getProperty("Rimagen6"));
//            File Rsiete = new File(prop.getProperty("Rimagen7"));
//            if(Rseis.exists() && Rsiete.exists()){
//                arrayfile4.add(Rseis);
//                arrayfile4.add(Rsiete);
//                //HI.guardarArrayImg(arrayfile4, res4.getNickname());
//                arraystring4.add(res4.getNickname().concat("0"));
//                arraystring4.add(res4.getNickname().concat("1"));
//                //res4.setLstImagen(arraystring4);
//                ICU.registrarRestaurante(res4);
//            }if(!Rseis.exists() || !Rsiete.exists()){
//                if(Rseis.exists()){
//                    arrayfile4.add(Rseis);
//                    //HI.guardarArrayImg(arrayfile4, res4.getNickname());
//                    arraystring4.add(res4.getNickname().concat("0"));
//                    //res4.setLstImagen(arraystring4);
//                    ICU.registrarRestaurante(res4);
//                }else{
//                    arrayfile4.add(Rsiete);
//                    //HI.guardarArrayImg(arrayfile4, res4.getNickname());
//                    arraystring4.add(res4.getNickname().concat("0"));
//                    //res4.setLstImagen(arraystring4);
//                    ICU.registrarRestaurante(res4);
//                }
//            }if(!Rseis.exists() && !Rsiete.exists()){
//                ICU.registrarRestaurante(res4);
//            }          
//
//            //PRODUCTOS INDIVIDUALES
//
//            lab01.server.DataIndividual di1 = new lab01.server.DataIndividual();
//            di1.setDataNombre("Asado");
//            di1.setDataDescripcion("Asado a la parrilla");
//            di1.setDataPrecio(225.0);
//            di1.setDataImagen("");
//            di1.setCantidad(300);
//            DtoRegistrarProducto prod1 = new DtoRegistrarProducto();
//            prod1.setDi(di1);
//            prod1.setNickRest("mera");
//            prod1.setPromo(false);
//            File Iuno = new File(prop.getProperty("Iimagen1"));
//            if(Iuno.exists()){
//                //HI.guardarImagen(Iuno, prod1.getDi().getDataNombre());
//                prod1.getDi().setDataImagen(prod1.getDi().getDataNombre());
//                ICProd.registrarProducto(prod1);
//            }else{
//                ICProd.registrarProducto(prod1);
//            }
//
//            lab01.server.DataIndividual di2 = new lab01.server.DataIndividual();
//            di2.setDataNombre("Milanesa de Carne");
//            di2.setDataDescripcion("Con lechuga, tomate, mayonesa y fritas");
//            di2.setDataPrecio(180.0);
//            di2.setDataImagen("");
//            di2.setCantidad(150);
//            DtoRegistrarProducto prod2 = new DtoRegistrarProducto();
//            prod2.setDi(di2);
//            prod2.setNickRest("mera");
//            prod2.setPromo(false);
//            File Idos = new File(prop.getProperty("Iimagen2"));
//            if(Idos.exists()){
//                //HI.guardarImagen(Idos, prod2.getDi().getDataNombre());
//                prod2.getDi().setDataImagen(prod2.getDi().getDataNombre());
//                ICProd.registrarProducto(prod2);
//            }else{
//                ICProd.registrarProducto(prod2);
//            }
//            
//            lab01.server.DataIndividual di3 = new lab01.server.DataIndividual();
//            di3.setDataNombre("Chivito canadiense");
//            di3.setDataDescripcion("Lomito, jamón, muzza, tomate, aceitunas, panceta, huevo, morrón y fritas");
//            di3.setDataPrecio(305.0);
//            di3.setDataImagen("");
//            di3.setCantidad(49);
//            DtoRegistrarProducto prod3 = new DtoRegistrarProducto();
//            prod3.setDi(di3);
//            prod3.setNickRest("mera");
//            prod3.setPromo(false);
//            File Itres = new File(prop.getProperty("Iimagen3"));
//            if(Itres.exists()){
//                //HI.guardarImagen(Itres, prod3.getDi().getDataNombre());
//                prod3.getDi().setDataImagen(prod3.getDi().getDataNombre());
//                ICProd.registrarProducto(prod3);
//            }else{
//                ICProd.registrarProducto(prod3);
//            }
//                
//            lab01.server.DataIndividual di4 = new lab01.server.DataIndividual();
//            di4.setDataNombre("Pizza 2 gustos");
//            di4.setDataDescripcion("Pizza con dos gustos a elección");
//            di4.setDataPrecio(130.0);
//            di4.setDataImagen("");
//            di4.setCantidad(100);
//            DtoRegistrarProducto prod4 = new DtoRegistrarProducto();
//            prod4.setDi(di4);
//            prod4.setNickRest("mera");
//            prod4.setPromo(false);
//            File Icuatro = new File(prop.getProperty("Iimagen4"));
//            if(Icuatro.exists()){
//                //HI.guardarImagen(Icuatro, prod4.getDi().getDataNombre());
//                prod4.getDi().setDataImagen(prod4.getDi().getDataNombre());
//                ICProd.registrarProducto(prod4);
//            }else{
//                ICProd.registrarProducto(prod4);
//            }
//            
//            lab01.server.DataIndividual di5 = new lab01.server.DataIndividual();
//            di5.setDataNombre("Chivito al plato");
//            di5.setDataDescripcion("Ensalada rusa, mixta, huevo, jamón, muzza, panceta, aceitunas y fritas");
//            di5.setDataPrecio(324.0);
//            di5.setDataImagen("");
//            di5.setCantidad(115);
//            DtoRegistrarProducto prod5 = new DtoRegistrarProducto();
//            prod5.setDi(di5);
//            prod5.setNickRest("rossell");
//            prod5.setPromo(false);
//            File Icinco = new File(prop.getProperty("Iimagen5"));
//            if(Icinco.exists()){
//                //HI.guardarImagen(Icinco, prod5.getDi().getDataNombre());
//                prod5.getDi().setDataImagen(prod5.getDi().getDataNombre());
//                ICProd.registrarProducto(prod5);
//            }else{
//                ICProd.registrarProducto(prod5);
//            }
//            
//            lab01.server.DataIndividual di6 = new lab01.server.DataIndividual();
//            di6.setDataNombre("Milanesa a caballo");
//            di6.setDataDescripcion("Milanesa con dos huevos fritos acompañado de fritas");
//            di6.setDataPrecio(270.0);
//            di6.setDataImagen("");
//            di6.setCantidad(115);
//            DtoRegistrarProducto prod6 = new DtoRegistrarProducto();
//            prod6.setDi(di6);
//            prod6.setNickRest("rossell");
//            prod6.setPromo(false);
//            File Iseis = new File(prop.getProperty("Iimagen6"));
//            if(Iseis.exists()){
//                //HI.guardarImagen(Iseis, prod6.getDi().getDataNombre());
//                prod6.getDi().setDataImagen(prod6.getDi().getDataNombre());
//                ICProd.registrarProducto(prod6);
//            }else{
//                ICProd.registrarProducto(prod6);
//            }
//            
//            lab01.server.DataIndividual di7 = new lab01.server.DataIndividual();
//            di7.setDataNombre("Pizza 2 gustos");
//            di7.setDataDescripcion("Pizza con dos gustos a elección");
//            di7.setDataPrecio(103.0);
//            di7.setDataImagen("");
//            di7.setCantidad(45);
//            DtoRegistrarProducto prod7 = new DtoRegistrarProducto();
//            prod7.setDi(di7);
//            prod7.setNickRest("rossell");
//            prod7.setPromo(false);
//            File Isiete = new File(prop.getProperty("Iimagen7"));
//            if(Isiete.exists()){
//                //HI.guardarImagen(Isiete, prod7.getDi().getDataNombre());
//                prod7.getDi().setDataImagen(prod7.getDi().getDataNombre());
//                ICProd.registrarProducto(prod7);
//            }else{
//                ICProd.registrarProducto(prod7);
//            }
//            
//            lab01.server.DataIndividual di8 = new lab01.server.DataIndividual();
//            di8.setDataNombre("Agnolotis");
//            di8.setDataDescripcion("Agnolotis de jamón y queso");
//            di8.setDataPrecio(225.0);
//            di8.setDataImagen("");
//            di8.setCantidad(50);
//            DtoRegistrarProducto prod8 = new DtoRegistrarProducto();
//            prod8.setDi(di8);
//            prod8.setNickRest("rossell");
//            prod8.setPromo(false);
//            File Iocho = new File(prop.getProperty("Iimagen8"));
//            if(Iocho.exists()){
//                //HI.guardarImagen(Iocho, prod8.getDi().getDataNombre());
//                prod8.getDi().setDataImagen(prod8.getDi().getDataNombre());
//                ICProd.registrarProducto(prod8);
//            }else{
//                ICProd.registrarProducto(prod8);
//            }
//            
//            lab01.server.DataIndividual di9 = new lab01.server.DataIndividual();
//            di9.setDataNombre("Empanada de carne");
//            di9.setDataDescripcion("Carne, aceitunas, huevo duro, condimentos");
//            di9.setDataPrecio(44.0);
//            di9.setDataImagen("");
//            di9.setCantidad(65);
//            DtoRegistrarProducto prod9 = new DtoRegistrarProducto();
//            prod9.setDi(di9);
//            prod9.setNickRest("bocatti");
//            prod9.setPromo(false);
//            File Inueve = new File(prop.getProperty("Iimagen9"));
//            if(Inueve.exists()){
//                //HI.guardarImagen(Inueve, prod9.getDi().getDataNombre());
//                prod9.getDi().setDataImagen(prod9.getDi().getDataNombre());
//                ICProd.registrarProducto(prod9);     
//            }else{
//                ICProd.registrarProducto(prod9);
//            }
//                
//            lab01.server.DataIndividual di10 = new lab01.server.DataIndividual();
//            di10.setDataNombre("Empanada Americana");
//            di10.setDataDescripcion("Carne, panceta y huevo duro");
//            di10.setDataPrecio(44.0);
//            di10.setDataImagen("");
//            di10.setCantidad(70);
//            DtoRegistrarProducto prod10 = new DtoRegistrarProducto();
//            prod10.setDi(di10);
//            prod10.setNickRest("bocatti");
//            prod10.setPromo(false);
//            File Idiez = new File(prop.getProperty("Iimagen10"));
//            if(Idiez.exists()){
//                //HI.guardarImagen(Idiez, prod10.getDi().getDataNombre());
//                prod10.getDi().setDataImagen(prod10.getDi().getDataNombre());
//                ICProd.registrarProducto(prod10);
//            }else{
//                ICProd.registrarProducto(prod10);
//            }
//            
//            lab01.server.DataIndividual di11 = new lab01.server.DataIndividual();
//            di11.setDataNombre("Empanada QyC");
//            di11.setDataDescripcion("Empanada de Queso y Cebolla");
//            di11.setDataPrecio(44.0);
//            di11.setDataImagen("");
//            di11.setCantidad(333);
//            DtoRegistrarProducto prod11 = new DtoRegistrarProducto();
//            prod11.setDi(di11);
//            prod11.setNickRest("bocatti");
//            prod11.setPromo(false);
//            File Ionce = new File(prop.getProperty("Iimagen11"));
//            if(Ionce.exists()){
//                //HI.guardarImagen(Ionce, prod11.getDi().getDataNombre());
//                prod11.getDi().setDataImagen(prod11.getDi().getDataNombre());
//                ICProd.registrarProducto(prod11);
//            }else{
//                ICProd.registrarProducto(prod11);
//            }
//            
//            lab01.server.DataIndividual di12 = new lab01.server.DataIndividual();
//            di12.setDataNombre("Empanada Capresse");
//            di12.setDataDescripcion("Queso, tomate y albahaca");
//            di12.setDataPrecio(44.0);
//            di12.setDataImagen("");
//            di12.setCantidad(230);
//            DtoRegistrarProducto prod12 = new DtoRegistrarProducto();
//            prod12.setDi(di12);
//            prod12.setNickRest("bocatti");
//            prod12.setPromo(false);
//            File Idoce = new File(prop.getProperty("Iimagen12"));
//            if(Idoce.exists()){
//                //HI.guardarImagen(Idoce, prod12.getDi().getDataNombre());
//                prod12.getDi().setDataImagen(prod12.getDi().getDataNombre());
//                ICProd.registrarProducto(prod12);     
//            }else{
//                ICProd.registrarProducto(prod12);
//            }
//            
//            lab01.server.DataIndividual di13 = new lab01.server.DataIndividual();
//            di13.setDataNombre("Thai wok");
//            di13.setDataDescripcion("Cerdo, calamares, sweet chili, salsa de ostras, maní y jugo de lima, acompañado de tallarines o arroz.");
//            di13.setDataPrecio(240.0);
//            di13.setDataImagen("");
//            di13.setCantidad(222);
//            DtoRegistrarProducto prod13 = new DtoRegistrarProducto();
//            prod13.setDi(di13);
//            prod13.setNickRest("winb");
//            prod13.setPromo(false);
//            File Itrece = new File(prop.getProperty("Iimagen13"));
//            if(Itrece.exists()){
//                //HI.guardarImagen(Itrece, prod13.getDi().getDataNombre());
//                prod13.getDi().setDataImagen(prod13.getDi().getDataNombre());
//                ICProd.registrarProducto(prod13);
//            }else{
//                ICProd.registrarProducto(prod13);
//            }
//            
//            lab01.server.DataIndividual di14 = new lab01.server.DataIndividual();
//            di14.setDataNombre("China wok");
//            di14.setDataDescripcion("Tempura de cerdo, vegetales mixtos, almendras, salsa de soja y naranja, acompañado de tallarines o arroz.");
//            di14.setDataPrecio(240.0);
//            di14.setDataImagen("");
//            di14.setCantidad(38);
//            DtoRegistrarProducto prod14 = new DtoRegistrarProducto();
//            prod14.setDi(di14);
//            prod14.setNickRest("winb");
//            prod14.setPromo(false);
//            File Icatorce = new File(prop.getProperty("Iimagen14"));
//            if(Icatorce.exists()){
//                //HI.guardarImagen(Icatorce, prod14.getDi().getDataNombre());
//                prod14.getDi().setDataImagen(prod14.getDi().getDataNombre());
//                ICProd.registrarProducto(prod14);
//            }else{
//                ICProd.registrarProducto(prod14);
//            }
//            
//            lab01.server.DataIndividual di15 = new lab01.server.DataIndividual();
//            di15.setDataNombre("Classic wok de pollo");
//            di15.setDataDescripcion("Pollo, vegetales mixtos, salsa agridulce, salsa de soja y cebollita de verdeo, acompañado de tallarines o arroz.");
//            di15.setDataPrecio(230.0);
//            di15.setDataImagen("");
//            di15.setCantidad(44);
//            DtoRegistrarProducto prod15 = new DtoRegistrarProducto();
//            prod15.setDi(di15);
//            prod15.setNickRest("winb");
//            prod15.setPromo(false);
//            File Iquince = new File(prop.getProperty("Iimagen15"));
//            if(Iquince.exists()){
//                //HI.guardarImagen(Iquince, prod15.getDi().getDataNombre());
//                prod15.getDi().setDataImagen(prod15.getDi().getDataNombre());
//                ICProd.registrarProducto(prod15);
//            }else{
//                ICProd.registrarProducto(prod15);
//            }
//            
//            lab01.server.DataIndividual di16 = new lab01.server.DataIndividual();
//            di16.setDataNombre("Classic wok de cerdo");
//            di16.setDataDescripcion("Cerdo, vegetales mixtos, jengibre, salsa de ostras y ralladura de lima, acompañado de tallarines o arroz.");
//            di16.setDataPrecio(230.0);
//            di16.setDataImagen("");
//            di16.setCantidad(65);
//            DtoRegistrarProducto prod16 = new DtoRegistrarProducto();
//            prod16.setDi(di16);
//            prod16.setNickRest("winb");
//            prod16.setPromo(false);
//            File Idieciseis = new File(prop.getProperty("Iimagen16"));
//            if(Idieciseis.exists()){
//                //HI.guardarImagen(Idieciseis, prod16.getDi().getDataNombre());
//                prod16.getDi().setDataImagen(prod16.getDi().getDataNombre());
//                ICProd.registrarProducto(prod16);
//            }else{
//                ICProd.registrarProducto(prod16);
//            }
//            
//            // Productos Promocionales
//            
//            ArrayList<lab01.server.DataIndividual> indiv1 = new ArrayList<>();
//            lab01.server.DataPromocional dprom1 = new lab01.server.DataPromocional();
//            dprom1.setDataNombre("ChiviPizza");
//            dprom1.setDataDescripcion("Chivito y Pizza");
//            dprom1.setDataDescuento(20);
//            String nomProd1Prom1 = "Chivito canadiense";
//            int cantProd1Prom1 = 1;
//            lab01.server.DataIndividual ind1 = new lab01.server.DataIndividual();
//            ind1.setDataNombre(nomProd1Prom1);
//            ind1.setCantidad(cantProd1Prom1);
//            indiv1.add(ind1);
//            String nomProd2Prom1 = "Pizza 2 gustos";
//            int cantProd2Prom1 = 1;
//            lab01.server.DataIndividual ind2 = new lab01.server.DataIndividual();
//            ind2.setDataNombre(nomProd2Prom1);
//            ind2.setCantidad(cantProd2Prom1);
//            indiv1.add(ind2);
//            ICProd.setPromo(indiv1);
//            DtoArmarPromo promo1 = new DtoArmarPromo();
//            promo1.setNickRest("mera");
//            promo1.setNombre(dprom1.getDataNombre());
//            promo1.setDescripcion(dprom1.getDataDescripcion());
//            promo1.setDescuento(dprom1.getDataDescuento());
//            File Puno = new File(prop.getProperty("Pimagen1"));
//            if(Puno.exists()){
//                //HI.guardarImagen(Puno, promo1.getNombre());
//                promo1.setImagen(promo1.getNombre());
//                ICProd.armarPromo(promo1);
//            }else{
//                promo1.setImagen("");
//                ICProd.armarPromo(promo1);
//            }
//            
//            ArrayList<lab01.server.DataIndividual> indivProm2 = new ArrayList<>();
//            lab01.server.DataPromocional dprom2 = new lab01.server.DataPromocional();
//            dprom2.setDataNombre("MilaAsado");
//            dprom2.setDataDescripcion("3 Milanesas + 1 Asado para compartir");
//            dprom2.setDataDescuento(30);
//            String nomProd1Prom2 = "Milanesa de Carne";
//            int cantProd1Prom2 = 3;
//            lab01.server.DataIndividual inprom2 = new lab01.server.DataIndividual();
//            inprom2.setDataNombre(nomProd1Prom2);
//            inprom2.setCantidad(cantProd1Prom2);
//            indivProm2.add(inprom2);
//            String nomProd2Prom2 = "Asado";
//            int cantProd2Prom2 = 1;
//            lab01.server.DataIndividual in2prom2 = new lab01.server.DataIndividual();
//            in2prom2.setDataNombre(nomProd2Prom2);
//            in2prom2.setCantidad(cantProd2Prom2);
//            indivProm2.add(in2prom2);
//            ICProd.setPromo(indivProm2);
//            DtoArmarPromo promo2 = new DtoArmarPromo();
//            promo2.setNickRest("mera");
//            promo2.setNombre(dprom2.getDataNombre());
//            promo2.setDescripcion(dprom2.getDataDescripcion());
//            promo2.setDescuento(dprom2.getDataDescuento());
//            File Pdos = new File(prop.getProperty("Pimagen2"));
//            if(Pdos.exists()){
//                //HI.guardarImagen(Pdos, promo2.getNombre());
//                promo2.setImagen(promo2.getNombre());
//                ICProd.armarPromo(promo2);
//            }else{
//                promo2.setImagen("");
//                ICProd.armarPromo(promo2);
//            }
//
//            ArrayList<lab01.server.DataIndividual> indivProm3 = new ArrayList<>();
//            lab01.server.DataPromocional dprom3 = new lab01.server.DataPromocional();
//            dprom3.setDataNombre("MilaPizza");
//            dprom3.setDataDescripcion("2 Milanesas a caballo + 1 Pizzas 2 gustos");
//            dprom3.setDataDescuento(30);
//            String nomProd1Prom3 = "Milanesa a caballo";
//            int cantProd1Prom3 = 2;
//            lab01.server.DataIndividual inprom3 = new lab01.server.DataIndividual();
//            inprom3.setDataNombre(nomProd1Prom3);
//            inprom3.setCantidad(cantProd1Prom3);
//            indivProm3.add(inprom3);
//            String nomProd2Prom3 = "Pizza 2 gustos";
//            int cantProd2Prom3 = 1;
//            lab01.server.DataIndividual in2prom3 = new lab01.server.DataIndividual();
//            in2prom3.setDataNombre(nomProd2Prom3);
//            in2prom3.setCantidad(cantProd2Prom3);
//            indivProm3.add(in2prom3);
//            ICProd.setPromo(indivProm3);
//            DtoArmarPromo promo3 = new DtoArmarPromo();
//            promo3.setNickRest("rossell");
//            promo3.setNombre(dprom3.getDataNombre());
//            promo3.setDescripcion(dprom3.getDataDescripcion());
//            promo3.setDescuento(dprom3.getDataDescuento());
//            File Ptres = new File(prop.getProperty("Pimagen3"));
//            if(Ptres.exists()){
//                //HI.guardarImagen(Ptres, promo3.getNombre());
//                promo3.setImagen(promo3.getNombre());
//                ICProd.armarPromo(promo3);
//            }else{
//                promo3.setImagen("");
//                ICProd.armarPromo(promo3);
//            }
//
//            // Pedidos
//
//            ICPed.setNickname("costas");
//            ICPed.setMemCliente();
//            ICPed.setMailCliente("gcostas@gmail.com");
//            ICPed.setMemRestaurante("bocatti");
//            boolean prod1ped1 = ICPed.selectProductos("Empanada de carne", 1);
//            boolean prod2ped1 = ICPed.selectProductos("Empanada Americana", 2);
//            boolean prod3ped1 = ICPed.selectProductos("Empanada QyC", 2);
//            lab01.server.DataPedido ped1 = ICPed.altaPedido();
//            ICPed.limpiarCtrl();
//
//            ICPed.actualizarFechaPedido(ped1.getNickUsr(), ped1.getId(), "12/8/2014");
//
//            ICPed.setNickname("roro");
//            ICPed.setMemCliente();
//            ICPed.setMailCliente("rcotelo@yahoo.com");
//            ICPed.setMemRestaurante("mera");
//            boolean prod1ped2 = ICPed.selectProductos("Asado", 3);
//            lab01.server.DataPedido ped2 = ICPed.altaPedido();
//            ICPed.limpiarCtrl();
//            
//            ICPed.actualizarFechaPedido(ped2.getNickUsr(), ped2.getId(), "19/8/2014");
//            ICPed.actualizarEPedido(ped2.getNickUsr(), ped2.getId(), Estados.ENVIADO);
//
//            ICPed.setNickname("chechi");
//            ICPed.setMemCliente();
//            ICPed.setMailCliente("cgarrido@hotmail.com");
//            ICPed.setMemRestaurante("winb");
//            boolean prod1ped3 = ICPed.selectProductos("Thai wok", 2);
//            boolean prod2ped3 = ICPed.selectProductos("China wok", 3);
//            lab01.server.DataPedido ped3 = ICPed.altaPedido();
//            ICPed.limpiarCtrl();
//            
//            ICPed.actualizarFechaPedido(ped3.getNickUsr(), ped3.getId(), "19/8/2014");
//            ICPed.actualizarEPedido(ped3.getNickUsr(), ped3.getId(), Estados.RECIBIDO);
//
//            ICPed.setNickname("andy");
//            ICPed.setMemCliente();
//            ICPed.setMailCliente("agarcia@gmail.com");
//            ICPed.setMemRestaurante("mera");
//            boolean prod1ped4 = ICPed.selectProductos("Chivito canadiense", 4);
//            lab01.server.DataPedido ped4 = ICPed.altaPedido();
//            ICPed.limpiarCtrl();
//            
//            ICPed.actualizarFechaPedido(ped4.getNickUsr(), ped4.getId(), "22/8/2014");
//            ICPed.actualizarEPedido(ped4.getNickUsr(), ped4.getId(), Estados.RECIBIDO);
//
//            ICPed.setNickname("weiss");
//            ICPed.setMemCliente();
//            ICPed.setMailCliente("aweiss@gmail.com");
//            ICPed.setMemRestaurante("rossell");
//            boolean prod1ped5= ICPed.selectProductos("Agnolotis", 1);
//            lab01.server.DataPedido ped5 = ICPed.altaPedido();
//            ICPed.limpiarCtrl();
//            
//            ICPed.actualizarFechaPedido(ped5.getNickUsr(), ped5.getId(), "25/8/2014");
//            ICPed.actualizarEPedido(ped5.getNickUsr(), ped5.getId(), Estados.RECIBIDO);
//            
//            
//            ICPed.setNickname("roro");
//            ICPed.setMemCliente();
//            ICPed.setMailCliente("rcotelo@yahoo.com");
//            ICPed.setMemRestaurante("mera");
//            boolean prod1ped6 = ICPed.selectProductos("Milanesa de Carne", 1);
//            boolean prod2ped6 = ICPed.selectProductos("Chivito canadiense", 1);
//            lab01.server.DataPedido ped6 = ICPed.altaPedido();
//            ICPed.limpiarCtrl();
//            
//            ICPed.actualizarFechaPedido(ped6.getNickUsr(), ped6.getId(), "20/9/2014");
//            ICPed.actualizarEPedido(ped6.getNickUsr(), ped6.getId(), Estados.RECIBIDO);
//            
//            ICPed.setNickname("andy");
//            ICPed.setMemCliente();
//            ICPed.setMailCliente("agarcia@gmail.com");
//            ICPed.setMemRestaurante("rossell");
//            boolean prod1ped7 = ICPed.selectProductos("Chivito al plato", 2);
//            boolean prod2ped7 = ICPed.selectProductos("Milanesa a caballo", 1);
//            lab01.server.DataPedido ped7 = ICPed.altaPedido();
//            ICPed.limpiarCtrl();
//            
//            ICPed.actualizarFechaPedido(ped7.getNickUsr(), ped7.getId(), "2/10/2014");
//            ICPed.actualizarEPedido(ped7.getNickUsr(), ped7.getId(), Estados.RECIBIDO);
//            
//            //Evaluaciones
//            
//            DtoEvaluacion ev1 = new DtoEvaluacion();
//            ev1.setComentario("Si bien el thai wok y el china wok están ricos, me cobraron 60$ de envío y eso no estaba aclarado y no pueden hacerlo. Me dejó muy molesto.");
//            ev1.setFecha("20/8/2014");
//            ev1.setPuntaje(2);
//            ICPed.altaEvaluacion(ped3.getId(), ev1);
//            ICPed.actualizarPromedioRest(res4.getNickname());
//            
//            DtoEvaluacion ev2 = new DtoEvaluacion();
//            ev2.setComentario("Los Agnolotis llegaron un poco fríos y demoraron más de la cuenta. Espero mejoren. De todas formas, muy ricos. ");
//            ev2.setFecha("26/8/2014");
//            ev2.setPuntaje(3);
//            ICPed.altaEvaluacion(ped5.getId(), ev2);
//            ICPed.actualizarPromedioRest(res2.getNickname());
//            
//            DtoEvaluacion ev3 = new DtoEvaluacion();
//            ev3.setComentario("Tanto la milanesa como el chivito llegaron 3 horas tarde!, obviamente helados!!, un desastre, nunca más pido ahí.");
//            ev3.setFecha("21/10/2014");
//            ev3.setPuntaje(1);
//            ICPed.altaEvaluacion(ped6.getId(), ev3);
//            ICPed.actualizarPromedioRest(res1.getNickname());
//            
//            DtoEvaluacion ev4 = new DtoEvaluacion();
//            ev4.setComentario("Todo llegó en hora. El chivito y la milanesa a caballo estaban un poco aceitosos, pero más allá de eso se comió rico y en abundancia.");
//            ev4.setFecha("3/10/2014");
//            ICPed.altaEvaluacion(ped7.getId(), ev4);
//            ICPed.actualizarPromedioRest(res2.getNickname());
            
            //JOptionPane.showMessageDialog(null, "Los datos de prueba se cargaron con exito","EXITO",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(IOException ex){
            ex.printStackTrace();
	}finally{
            if (input != null) {
                try {
                    input.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
	}
        
        Iterator it = ICU.retColCat().iterator();
        ArrayList<DataCategoria> lista = new ArrayList<>();
        while (it.hasNext()){
            DataCategoria cat = (DataCategoria)it.next();    
            lista.add(cat);
        }
        
        Iterator it2 = ICU.listaDataRestaurantes().iterator();
        ArrayList<DataRestaurante> listaRes = new ArrayList<>();
        while (it2.hasNext()){
            DataRestaurante r = (DataRestaurante)it2.next();    
            listaRes.add(r);
        }
        request.setAttribute("list", lista);
        HttpSession session = request.getSession();
        session.setAttribute("iniciada", "false");
        request.setAttribute("listres", listaRes);
        request.getRequestDispatcher("/Pantallas/VerRestaurantes.jsp").forward(request, response);
            
//                try (PrintWriter out = response.getWriter()) {
//
//                    out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet MenuServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet MenuServlet at " + request.getContextPath() + "</h1>");
//        if (ICU.retColCat().isEmpty()){
//            out.println("<h1>Sin Categoria</h1>");
//        }else{
//                
//            
//        }
//            
//            out.println("<a href = 'logout.do'>Cerrar Sesión</a>");
//            out.println("</body>");
//            out.println("</html>");
//                       
//
//    }
      }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    if (request.getParameter("ingresar") != null) {
        
        DAO dao = new DAO();
        
        String Mail, pass;
        
        Mail = request.getParameter("txtEmail");
        pass = request.getParameter("txtPassword");
        
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
   
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
