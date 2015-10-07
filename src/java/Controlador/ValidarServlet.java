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
import lab01.Clases.Cliente;
import lab01.Clases.DTOArmarPromo;
import lab01.Clases.DTOIngresarDatos;
import lab01.Clases.DTORegistrarCliente;
import lab01.Clases.DTORegistrarProducto;
import lab01.Clases.DataCategoria;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataPedido;
import lab01.Clases.DataPromocional;
import lab01.Clases.DataRestaurante;
import lab01.Clases.Pedido;
import lab01.Clases.estados;
import lab01.Handlers.Fabrica;
import lab01.Handlers.HImagenes;
import lab01.Handlers.HUsuario;
import lab01.Interfaces.ICtrlPedido;
import lab01.Interfaces.ICtrlProducto;
import lab01.Interfaces.ICtrlUsuario;

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
        
        if (request.getParameter("cDatos") != null) {        
        Fabrica fabrica = Fabrica.getInstance();
        ICtrlUsuario ICU = fabrica.getICtrlUsuario();
        ICtrlPedido ICPed = fabrica.getICtrlPedido();
        ICtrlProducto ICProd = fabrica.getICtrlProducto();
        HUsuario HU = HUsuario.getinstance();
        HImagenes HI = HImagenes.getInstance();
        Properties prop;
        InputStream input;
        
        prop = new Properties();
        input = null;
        
        try{
            input = new FileInputStream("C:\\Users\\ggonzalez\\Desktop\\Lab02\\Web\\config.testdata");
            prop.load(input);

            //CLIENTES                                  //  nickname, nombre,             email,      direccion
            DTOIngresarDatos datos1 = new DTOIngresarDatos("costas", "gcostas@gmail.com","Gerardo",  "Av. Italia 2078");
            ICU.ingresarDatos(datos1);                        // apellido, imagen,                                                                                             fecha,        pwd
            File Cuno = new File(prop.getProperty("Cimagen1"));
            if(Cuno.exists()){
                HI.guardarImagen(Cuno, datos1.getNickname());
                DTORegistrarCliente dreg1 = new DTORegistrarCliente("Costas", "costas", "15/11/1983", "costas123");
                ICU.registrarCliente(dreg1);
            }else{
                DTORegistrarCliente dreg1 = new DTORegistrarCliente("Costas", "", "15/11/1983", "costas123");
                ICU.registrarCliente(dreg1);
            }
            
            DTOIngresarDatos datos2 = new DTOIngresarDatos("roro", "rcotelo@yahoo.com","Rodrigo", "Pdte. Berro 1548");
            ICU.ingresarDatos(datos2);
            File Cdos = new File(prop.getProperty("Cimagen2"));
            if(Cdos.exists()){
                HI.guardarImagen(Cdos, datos2.getNickname());
                DTORegistrarCliente dreg2 = new DTORegistrarCliente("Cotelo", "roro", "02/08/1975", "12elroro");
                ICU.registrarCliente(dreg2);
            }else{
                DTORegistrarCliente dreg2 = new DTORegistrarCliente("Cotelo", "", "02/08/1975", "12elroro");
                ICU.registrarCliente(dreg2);
            }
            

            DTOIngresarDatos datos3 = new DTOIngresarDatos("chechi", "cgarrido@hotmail.com","Cecilia", "Gral. Urquiza 1548");
            ICU.ingresarDatos(datos3);
            File Ctres = new File(prop.getProperty("Cimagen3"));
            if(Ctres.exists()){    
                HI.guardarImagen(Ctres, datos3.getNickname());
                DTORegistrarCliente dreg3 = new DTORegistrarCliente("Garrido", "chechi", "12/09/1987", "ch4321");
                ICU.registrarCliente(dreg3);
            }else{
                DTORegistrarCliente dreg3 = new DTORegistrarCliente("Garrido", "", "12/09/1987", "ch4321");
                ICU.registrarCliente(dreg3);
            }
            
            
            DTOIngresarDatos datos4 = new DTOIngresarDatos("andy", "agarcia@gmail.com","Andrea", "Dr. Manuel Albo 4512");
            ICU.ingresarDatos(datos4);
            File Ccuatro = new File(prop.getProperty("Cimagen4"));
            if(Ccuatro.exists()){    
                HI.guardarImagen(Ccuatro, datos4.getNickname());
                DTORegistrarCliente dreg4 = new DTORegistrarCliente("García", "andy", "28/07/1951", "andy_la1");      
                ICU.registrarCliente(dreg4);
            }else{
                DTORegistrarCliente dreg4 = new DTORegistrarCliente("García", "", "28/07/1951", "andy_la1");      
                ICU.registrarCliente(dreg4);
            }
            
            DTOIngresarDatos datos5 = new DTOIngresarDatos("weiss", "aweiss@gmail.com","Adrián", "Monte Caseros 5615");
            ICU.ingresarDatos(datos5);
            File Ccinco = new File(prop.getProperty("Cimagen5"));
            if(Ccinco.exists()){    
                HI.guardarImagen(Ccinco, datos5.getNickname());
                DTORegistrarCliente dreg5 = new DTORegistrarCliente("Weiss", "weiss", "23/12/1978", "223_aweis");
                ICU.registrarCliente(dreg5);
            }else{
                DTORegistrarCliente dreg5 = new DTORegistrarCliente("Weiss", "", "23/12/1978", "223_aweis");
                ICU.registrarCliente(dreg5);
            }
            
            //CATEGORÍAS

            ICU.registrarCat("Chivitos");
            ICU.registrarCat("Minutas");
            ICU.registrarCat("Parrilla");
            ICU.registrarCat("Pizzas");
            ICU.registrarCat("Empanadas");
            ICU.registrarCat("Milanesas");
            ICU.registrarCat("Ensaladas");
            ICU.registrarCat("Pastas");
            ICU.registrarCat("Comida China");
            ICU.registrarCat("Picadas");
            ICU.registrarCat("Woks");
            ICU.registrarCat("Comida Mexicana");
            ICU.registrarCat("Entradas");
            ICU.registrarCat("Bebidas");
            ICU.registrarCat("Sushi");

            //RESTAURANTES

            Map Categorias1 = new HashMap();
            Categorias1.put("Chivitos", ICU.retColCat().get("Chivitos"));
            Categorias1.put("Minutas", ICU.retColCat().get("Minutas"));
            Categorias1.put("Parrilla", ICU.retColCat().get("Parrilla"));
            Categorias1.put("Pizzas", ICU.retColCat().get("Pizzas"));
            DataRestaurante res1 = new DataRestaurante();
            res1.setColCategoria(Categorias1);
            res1.setDireccion("Av 8 de octubre 2704");
            res1.setEmail("mera@hotmail.com");
            res1.setNickname("mera");
            res1.setNombre("Pizzería Mera");
            ICU.registrarRestaurante(res1);

            Map Categorias2 = new HashMap();
            Categorias2.put("Chivitos", ICU.retColCat().get("Chivitos"));
            Categorias2.put("Minutas", ICU.retColCat().get("Minutas"));
            Categorias2.put("Pastas", ICU.retColCat().get("Pastas"));
            Categorias2.put("Pizzas", ICU.retColCat().get("Pizzas"));
            DataRestaurante res2 = new DataRestaurante();
            res2.setColCategoria(Categorias2);
            res2.setDireccion("Bvar. Artigas 1601");
            res2.setEmail("bar.rossel@gmail.com");
            res2.setNickname("rossell");
            res2.setNombre("Bar Rossell");
            ArrayList<File> arrayfile2 = new ArrayList<>();
            ArrayList<String> arraystring2 = new ArrayList<>();
            File Runo = new File(prop.getProperty("Rimagen1"));
            File Rdos = new File(prop.getProperty("Rimagen2"));
            if(Runo.exists() && Rdos.exists()){
                arrayfile2.add(Runo);
                arrayfile2.add(Rdos);
                HI.guardarArrayImg(arrayfile2, res2.getNickname());
                arraystring2.add(res2.getNickname().concat("0"));
                arraystring2.add(res2.getNickname().concat("1"));
                res2.setLstImagen(arraystring2);
                ICU.registrarRestaurante(res2);
            }if(!Runo.exists() || !Rdos.exists()){
                if(Runo.exists()){
                    arrayfile2.add(Runo);
                    HI.guardarArrayImg(arrayfile2, res2.getNickname());
                    arraystring2.add(res2.getNickname().concat("0"));
                    res2.setLstImagen(arraystring2);
                    ICU.registrarRestaurante(res2);
                }else{
                    arrayfile2.add(Rdos);
                    HI.guardarArrayImg(arrayfile2, res2.getNickname());
                    arraystring2.add(res2.getNickname().concat("0"));
                    res2.setLstImagen(arraystring2);
                    ICU.registrarRestaurante(res2);
                }
            }if(!Runo.exists() && !Rdos.exists()){
                ICU.registrarRestaurante(res2);
            }
            

            Map Categorias3 = new HashMap();
            Categorias3.put("Empanadas", ICU.retColCat().get("Empanadas"));
            DataRestaurante res3 = new DataRestaurante();
            res3.setColCategoria(Categorias3);
            res3.setDireccion("18 de julio 2138");
            res3.setEmail("bocatti@gmail.com");
            res3.setNickname("bocatti");
            res3.setNombre("Empanadas Bocatti");
            ArrayList<File> arrayfile3 = new ArrayList<>();
            ArrayList<String> arraystring3 = new ArrayList<>();
            File Rtres = new File(prop.getProperty("Rimagen3"));
            File Rcuatro = new File(prop.getProperty("Rimagen4"));
            File Rcinco = new File(prop.getProperty("Rimagen5"));
            if(Rtres.exists() && Rcuatro.exists() && Rcinco.exists()){
                arrayfile3.add(Rtres);
                arrayfile3.add(Rcuatro);
                arrayfile3.add(Rcinco);
                HI.guardarArrayImg(arrayfile3, res3.getNickname());
                arraystring3.add(res3.getNickname().concat("0"));
                arraystring3.add(res3.getNickname().concat("1"));
                arraystring3.add(res3.getNickname().concat("2"));
                res3.setLstImagen(arraystring3);
                ICU.registrarRestaurante(res3);
            }if(!Rtres.exists() && !Rcuatro.exists() && Rcinco.exists()){
                arrayfile3.add(Rcinco);
                HI.guardarArrayImg(arrayfile3, res3.getNickname());
                arraystring3.add(res3.getNickname().concat("0"));
                res3.setLstImagen(arraystring3);
                ICU.registrarRestaurante(res3);
            }if(!Rtres.exists() && Rcuatro.exists() && !Rcinco.exists()){
                arrayfile3.add(Rcuatro);
                HI.guardarArrayImg(arrayfile3, res3.getNickname());
                arraystring3.add(res3.getNickname().concat("0"));
                res3.setLstImagen(arraystring3);
                ICU.registrarRestaurante(res3);
            }if(Rtres.exists() && !Rcuatro.exists() && !Rcinco.exists()){
                arrayfile3.add(Rtres);
                HI.guardarArrayImg(arrayfile3, res3.getNickname());
                arraystring3.add(res3.getNickname().concat("0"));
                res3.setLstImagen(arraystring3);
                ICU.registrarRestaurante(res3);
            }if(Rtres.exists() && Rcuatro.exists() && !Rcinco.exists()){
                arrayfile3.add(Rtres);
                arrayfile3.add(Rcuatro);
                HI.guardarArrayImg(arrayfile3, res3.getNickname());
                arraystring3.add(res3.getNickname().concat("0"));
                arraystring3.add(res3.getNickname().concat("1"));
                res3.setLstImagen(arraystring3);
                ICU.registrarRestaurante(res3);
            }if(Rtres.exists() && !Rcuatro.exists() && Rcinco.exists()){
                arrayfile3.add(Rtres);
                arrayfile3.add(Rcinco);
                HI.guardarArrayImg(arrayfile3, res3.getNickname());
                arraystring3.add(res3.getNickname().concat("0"));
                arraystring3.add(res3.getNickname().concat("1"));
                res3.setLstImagen(arraystring3);
                ICU.registrarRestaurante(res3);
            }if(!Rtres.exists() && Rcuatro.exists() && Rcinco.exists()){
                arrayfile3.add(Rcuatro);
                arrayfile3.add(Rcinco);
                HI.guardarArrayImg(arrayfile3, res3.getNickname());
                arraystring3.add(res3.getNickname().concat("0"));
                arraystring3.add(res3.getNickname().concat("1"));
                res3.setLstImagen(arraystring3);
                ICU.registrarRestaurante(res3);
            }if(!Rtres.exists() && !Rcuatro.exists() && !Rcinco.exists()){
                ICU.registrarRestaurante(res3);
            }
            

            Map Categorias4 = new HashMap();
            Categorias4.put("Woks", ICU.retColCat().get("Woks"));
            Categorias4.put("Pastas", ICU.retColCat().get("Pastas"));
            Categorias4.put("Comida China", ICU.retColCat().get("Comida China"));
            DataRestaurante res4 = new DataRestaurante();
            res4.setColCategoria(Categorias4);
            res4.setDireccion("Libertad 2535");
            res4.setEmail("wok.in.box@hotmail.com");
            res4.setNickname("winb");
            res4.setNombre("Wok in Box");
            ArrayList<File> arrayfile4 = new ArrayList<>();
            ArrayList<String> arraystring4 = new ArrayList<>();
            File Rseis = new File(prop.getProperty("Rimagen6"));
            File Rsiete = new File(prop.getProperty("Rimagen7"));
            if(Rseis.exists() && Rsiete.exists()){
                arrayfile4.add(Rseis);
                arrayfile4.add(Rsiete);
                HI.guardarArrayImg(arrayfile4, res4.getNickname());
                arraystring4.add(res4.getNickname().concat("0"));
                arraystring4.add(res4.getNickname().concat("1"));
                res4.setLstImagen(arraystring4);
                ICU.registrarRestaurante(res4);
            }if(!Rseis.exists() || !Rsiete.exists()){
                if(Rseis.exists()){
                    arrayfile4.add(Rseis);
                    HI.guardarArrayImg(arrayfile4, res4.getNickname());
                    arraystring4.add(res4.getNickname().concat("0"));
                    res4.setLstImagen(arraystring4);
                    ICU.registrarRestaurante(res4);
                }else{
                    arrayfile4.add(Rsiete);
                    HI.guardarArrayImg(arrayfile4, res4.getNickname());
                    arraystring4.add(res4.getNickname().concat("0"));
                    res4.setLstImagen(arraystring4);
                    ICU.registrarRestaurante(res4);
                }
            }if(!Rseis.exists() && !Rsiete.exists()){
                ICU.registrarRestaurante(res4);
            }          

            //PRODUCTOS INDIVIDUALES

            DataIndividual di1 = new DataIndividual("Asado", "Asado a la parrilla", 225.0, "", 300);
            DTORegistrarProducto prod1 = new DTORegistrarProducto(di1, "mera", false);
            File Iuno = new File(prop.getProperty("Iimagen1"));
            if(Iuno.exists()){
                HI.guardarImagen(Iuno, prod1.getDi().getDataNombre());
                prod1.getDi().setDataImagen(prod1.getDi().getDataNombre());
                ICProd.registrarProducto(prod1);
            }else{
                ICProd.registrarProducto(prod1);
            }

            DataIndividual di2 = new DataIndividual("Milanesa de Carne", "Con lechuga, tomate, mayonesa y fritas", 180.0, "", 150);
            DTORegistrarProducto prod2 = new DTORegistrarProducto(di2, "mera", false);
            File Idos = new File(prop.getProperty("Iimagen2"));
            if(Idos.exists()){
                HI.guardarImagen(Idos, prod2.getDi().getDataNombre());
                prod2.getDi().setDataImagen(prod2.getDi().getDataNombre());
                ICProd.registrarProducto(prod2);
            }else{
                ICProd.registrarProducto(prod2);
            }
            
            DataIndividual di3 = new DataIndividual("Chivito canadiense", "Lomito, jamón, muzza, tomate, aceitunas, panceta, huevo, morrón y fritas", 305.0, "", 49);
            DTORegistrarProducto prod3 = new DTORegistrarProducto(di3, "mera", false);
            File Itres = new File(prop.getProperty("Iimagen3"));
            if(Itres.exists()){
                HI.guardarImagen(Itres, prod3.getDi().getDataNombre());
                prod3.getDi().setDataImagen(prod3.getDi().getDataNombre());
                ICProd.registrarProducto(prod3);
            }else{
                ICProd.registrarProducto(prod3);
            }
                
            DataIndividual di4 = new DataIndividual("Pizza 2 gustos", "Pizza con dos gustos a elección", 130.0, "", 100);
            DTORegistrarProducto prod4 = new DTORegistrarProducto(di4, "mera", false);
            File Icuatro = new File(prop.getProperty("Iimagen4"));
            if(Icuatro.exists()){
                HI.guardarImagen(Icuatro, prod4.getDi().getDataNombre());
                prod4.getDi().setDataImagen(prod4.getDi().getDataNombre());
                ICProd.registrarProducto(prod4);
            }else{
                ICProd.registrarProducto(prod4);
            }
            
            DataIndividual di5 = new DataIndividual("Chivito al plato", "Ensalada rusa, mixta, huevo, jamón, muzza, panceta, aceitunas y fritas", 324.0, "", 115);
            DTORegistrarProducto prod5 = new DTORegistrarProducto(di5, "rossell", false);
            File Icinco = new File(prop.getProperty("Iimagen5"));
            if(Icinco.exists()){
                HI.guardarImagen(Icinco, prod5.getDi().getDataNombre());
                prod5.getDi().setDataImagen(prod5.getDi().getDataNombre());
                ICProd.registrarProducto(prod5);
            }else{
                ICProd.registrarProducto(prod5);
            }
            
            DataIndividual di6 = new DataIndividual("Milanesa a caballo", "Milanesa con dos huevos fritos acompañado de fritas", 270.0, "", 35);
            DTORegistrarProducto prod6 = new DTORegistrarProducto(di6, "rossell", false);
            File Iseis = new File(prop.getProperty("Iimagen6"));
            if(Iseis.exists()){
                HI.guardarImagen(Iseis, prod6.getDi().getDataNombre());
                prod6.getDi().setDataImagen(prod6.getDi().getDataNombre());
                ICProd.registrarProducto(prod6);
            }else{
                ICProd.registrarProducto(prod6);
            }
            
            DataIndividual di7 = new DataIndividual("Pizza 2 gustos", "Pizza con dos gustos a elección", 103.0, "", 45);
            DTORegistrarProducto prod7 = new DTORegistrarProducto(di7, "rossell", false);
            File Isiete = new File(prop.getProperty("Iimagen7"));
            if(Isiete.exists()){
                HI.guardarImagen(Isiete, prod7.getDi().getDataNombre());
                prod7.getDi().setDataImagen(prod7.getDi().getDataNombre());
                ICProd.registrarProducto(prod7);
            }else{
                ICProd.registrarProducto(prod7);
            }
            
            DataIndividual di8 = new DataIndividual("Agnolotis", "Agnolotis de jamón y queso", 225.0, "", 50);
            DTORegistrarProducto prod8 = new DTORegistrarProducto(di8, "rossell", false);
            File Iocho = new File(prop.getProperty("Iimagen8"));
            if(Iocho.exists()){
                HI.guardarImagen(Iocho, prod8.getDi().getDataNombre());
                prod8.getDi().setDataImagen(prod8.getDi().getDataNombre());
                ICProd.registrarProducto(prod8);
            }else{
                ICProd.registrarProducto(prod8);
            }
            
            DataIndividual di9 = new DataIndividual("Empanada de carne", "Carne, aceitunas, huevo duro, condimentos", 44.0, "", 65);
            DTORegistrarProducto prod9 = new DTORegistrarProducto(di9, "bocatti", false);
            File Inueve = new File(prop.getProperty("Iimagen9"));
            if(Inueve.exists()){
                HI.guardarImagen(Inueve, prod9.getDi().getDataNombre());
                prod9.getDi().setDataImagen(prod9.getDi().getDataNombre());
                ICProd.registrarProducto(prod9);     
            }else{
                ICProd.registrarProducto(prod9);
            }
                
            DataIndividual di10 = new DataIndividual("Empanada Americana", "Carne, panceta y huevo duro", 44.0, "", 70);
            DTORegistrarProducto prod10 = new DTORegistrarProducto(di10, "bocatti", false);
            File Idiez = new File(prop.getProperty("Iimagen10"));
            if(Idiez.exists()){
                HI.guardarImagen(Idiez, prod10.getDi().getDataNombre());
                prod10.getDi().setDataImagen(prod10.getDi().getDataNombre());
                ICProd.registrarProducto(prod10);
            }else{
                ICProd.registrarProducto(prod10);
            }
            
            DataIndividual di11 = new DataIndividual("Empanada QyC", "Empanada de Queso y Cebolla", 44.0, "", 333);
            DTORegistrarProducto prod11 = new DTORegistrarProducto(di11, "bocatti", false);      
            File Ionce = new File(prop.getProperty("Iimagen11"));
            if(Ionce.exists()){
                HI.guardarImagen(Ionce, prod11.getDi().getDataNombre());
                prod11.getDi().setDataImagen(prod11.getDi().getDataNombre());
                ICProd.registrarProducto(prod11);
            }else{
                ICProd.registrarProducto(prod11);
            }
            
            DataIndividual di12 = new DataIndividual("Empanada Capresse", "Queso, tomate y albahaca", 44.0, "", 230);
            DTORegistrarProducto prod12 = new DTORegistrarProducto(di12, "bocatti", false);
            File Idoce = new File(prop.getProperty("Iimagen12"));
            if(Idoce.exists()){
                HI.guardarImagen(Idoce, prod12.getDi().getDataNombre());
                prod12.getDi().setDataImagen(prod12.getDi().getDataNombre());
                ICProd.registrarProducto(prod12);     
            }else{
                ICProd.registrarProducto(prod12);
            }
            
            DataIndividual di13 = new DataIndividual("Thai wok", "Cerdo, calamares, sweet chili, salsa de ostras, maní y jugo de lima, acompañado de tallarines o arroz.", 240.0, "", 222);
            DTORegistrarProducto prod13 = new DTORegistrarProducto(di13, "winb", false);
            File Itrece = new File(prop.getProperty("Iimagen13"));
            if(Itrece.exists()){
                HI.guardarImagen(Itrece, prod13.getDi().getDataNombre());
                prod13.getDi().setDataImagen(prod13.getDi().getDataNombre());
                ICProd.registrarProducto(prod13);
            }else{
                ICProd.registrarProducto(prod13);
            }
            
            DataIndividual di14 = new DataIndividual("China wok", "Tempura de cerdo, vegetales mixtos, almendras, salsa de soja y naranja, acompañado de tallarines o arroz.", 240.0, "", 38);
            DTORegistrarProducto prod14 = new DTORegistrarProducto(di14, "winb", false);
            File Icatorce = new File(prop.getProperty("Iimagen14"));
            if(Icatorce.exists()){
                HI.guardarImagen(Icatorce, prod14.getDi().getDataNombre());
                prod14.getDi().setDataImagen(prod14.getDi().getDataNombre());
                ICProd.registrarProducto(prod14);
            }else{
                ICProd.registrarProducto(prod14);
            }
            
            DataIndividual di15 = new DataIndividual("Classic wok de pollo", "Pollo, vegetales mixtos, salsa agridulce, salsa de soja y cebollita de verdeo, acompañado de tallarines o arroz.", 230.0, "", 44);
            DTORegistrarProducto prod15 = new DTORegistrarProducto(di15, "winb", false);
            File Iquince = new File(prop.getProperty("Iimagen15"));
            if(Iquince.exists()){
                HI.guardarImagen(Iquince, prod15.getDi().getDataNombre());
                prod15.getDi().setDataImagen(prod15.getDi().getDataNombre());
                ICProd.registrarProducto(prod15);
            }else{
                ICProd.registrarProducto(prod15);
            }
            
            DataIndividual di16 = new DataIndividual("Classic wok de cerdo", "Cerdo, vegetales mixtos, jengibre, salsa de ostras y ralladura de lima, acompañado de tallarines o arroz.", 230.0, "", 65);
            DTORegistrarProducto prod16 = new DTORegistrarProducto(di16, "winb", false);
            File Idieciseis = new File(prop.getProperty("Iimagen16"));
            if(Idieciseis.exists()){
                HI.guardarImagen(Idieciseis, prod16.getDi().getDataNombre());
                prod16.getDi().setDataImagen(prod16.getDi().getDataNombre());
                ICProd.registrarProducto(prod16);
            }else{
                ICProd.registrarProducto(prod16);
            }
            
            // Productos Promocionales

            Map indivProm1 = new HashMap();
            DataPromocional dprom1 = new DataPromocional();
            dprom1.setDataNombre("ChiviPizza");
            dprom1.setDataDescripcion("Chivito y Pizza");
            dprom1.setDescuento(20);
            String nomProd1Prom1 = "Chivito canadiense";
            int cantProd1Prom1 = 1;
            indivProm1.put(nomProd1Prom1, cantProd1Prom1);
            String nomProd2Prom1 = "Pizza 2 gustos";
            int cantProd2Prom1 = 1;
            indivProm1.put(nomProd2Prom1, cantProd2Prom1);
            ICProd.setPromo(indivProm1);
            DTOArmarPromo promo1 = new DTOArmarPromo("mera", dprom1.getDataNombre(), dprom1.getDataDescripcion(), dprom1.getDescuento());
            File Puno = new File(prop.getProperty("Pimagen1"));
            if(Puno.exists()){
                HI.guardarImagen(Puno, promo1.getNombre());
                promo1.setImagen(promo1.getNombre());
                ICProd.armarPromo(promo1);
            }else{
                promo1.setImagen("");
                ICProd.armarPromo(promo1);
            }
            
            Map indivProm2 = new HashMap();
            DataPromocional dprom2 = new DataPromocional();
            dprom2.setDataNombre("MilaAsado");
            dprom2.setDataDescripcion("3 Milanesas + 1 Asado para compartir");
            dprom2.setDescuento(30);
            String nomProd1Prom2 = "Milanesa de Carne";
            int cantProd1Prom2 = 3;
            indivProm2.put(nomProd1Prom2, cantProd1Prom2);
            String nomProd2Prom2 = "Asado";
            int cantProd2Prom2 = 1;
            indivProm2.put(nomProd2Prom2, cantProd2Prom2);
            ICProd.setPromo(indivProm2);
            DTOArmarPromo promo2 = new DTOArmarPromo("mera", dprom2.getDataNombre(), dprom2.getDataDescripcion(), dprom2.getDescuento());
            File Pdos = new File(prop.getProperty("Pimagen2"));
            if(Pdos.exists()){
                HI.guardarImagen(Pdos, promo2.getNombre());
                promo2.setImagen(promo2.getNombre());
                ICProd.armarPromo(promo2);
            }else{
                promo2.setImagen("");
                ICProd.armarPromo(promo2);
            }

            Map indivProm3 = new HashMap();
            DataPromocional dprom3 = new DataPromocional();
            dprom3.setDataNombre("MilaPizza");
            dprom3.setDataDescripcion("2 Milanesas a caballo + 1 Pizzas 2 gustos");
            dprom3.setDescuento(30);
            String nomProd1Prom3 = "Milanesa a caballo";
            int cantProd1Prom3 = 2;
            indivProm3.put(nomProd1Prom3, cantProd1Prom3);
            String nomProd2Prom3 = "Pizza 2 gustos";
            int cantProd2Prom3 = 1;
            indivProm3.put(nomProd2Prom3, cantProd2Prom3);
            ICProd.setPromo(indivProm3);
            DTOArmarPromo promo3 = new DTOArmarPromo("rossell", dprom3.getDataNombre(), dprom3.getDataDescripcion(), dprom3.getDescuento());
            File Ptres = new File(prop.getProperty("Pimagen3"));
            if(Ptres.exists()){
                HI.guardarImagen(Ptres, promo3.getNombre());
                promo3.setImagen(promo3.getNombre());
                ICProd.armarPromo(promo3);
            }else{
                promo3.setImagen("");
                ICProd.armarPromo(promo3);
            }

            // Pedidos

            ICPed.setNickname("costas");
            ICPed.setMemCliente();
            ICPed.setMailCliente("gcostas@gmail.com");
            ICPed.setMemRestaurante("bocatti");
            boolean prod1ped1 = ICPed.selectProductos("Empanada de carne", 1);
            boolean prod2ped1 = ICPed.selectProductos("Empanada Americana", 2);
            boolean prod3ped1 = ICPed.selectProductos("Empanada QyC", 2);
            DataPedido ped1 = ICPed.altaPedido();
            ICPed.limpiarCtrl();

            Cliente c1 = HU.obtenerUsuario(ped1.getNickUsr());
            Pedido p1 = c1.getPedido(ped1.getId());
            p1.setFecha("12/8/2014");

            ICPed.setNickname("roro");
            ICPed.setMemCliente();
            ICPed.setMailCliente("rcotelo@yahoo.com");
            ICPed.setMemRestaurante("mera");
            boolean prod1ped2 = ICPed.selectProductos("Asado", 3);
            DataPedido ped2 = ICPed.altaPedido();
            ICPed.limpiarCtrl();

            Cliente c2 = HU.obtenerUsuario(ped2.getNickUsr());
            Pedido p2 = c2.getPedido(ped2.getId());
            p2.setFecha("19/8/2014");
            ICPed.actualizarEPedido(ped2.getNickUsr(), p2.getId(), estados.ENVIADO);

            ICPed.setNickname("chechi");
            ICPed.setMemCliente();
            ICPed.setMailCliente("cgarrido@hotmail.com");
            ICPed.setMemRestaurante("winb");
            boolean prod1ped3 = ICPed.selectProductos("Thai wok", 2);
            boolean prod2ped3 = ICPed.selectProductos("China wok", 3);
            DataPedido ped3 = ICPed.altaPedido();
            ICPed.limpiarCtrl();

            Cliente c3 = HU.obtenerUsuario(ped3.getNickUsr());
            Pedido p3 = c3.getPedido(ped3.getId());
            p3.setFecha("19/8/2014");
            ICPed.actualizarEPedido(ped3.getNickUsr(), p3.getId(), estados.RECIBIDO);

            ICPed.setNickname("andy");
            ICPed.setMemCliente();
            ICPed.setMailCliente("agarcia@gmail.com");
            ICPed.setMemRestaurante("mera");
            boolean prod1ped4 = ICPed.selectProductos("Chivito canadiense", 4);
            DataPedido ped4 = ICPed.altaPedido();
            ICPed.limpiarCtrl();

            Cliente c4 = HU.obtenerUsuario(ped4.getNickUsr());
            Pedido p4 = c4.getPedido(ped4.getId());
            p4.setFecha("22/8/2014");
            ICPed.actualizarEPedido(ped4.getNickUsr(), p4.getId(), estados.RECIBIDO);

            ICPed.setNickname("weiss");
            ICPed.setMemCliente();
            ICPed.setMailCliente("aweiss@gmail.com");
            ICPed.setMemRestaurante("rossell");
            boolean prod1ped5= ICPed.selectProductos("Agnolotis", 1);
            DataPedido ped5 = ICPed.altaPedido();
            ICPed.limpiarCtrl();

            Cliente c5 = HU.obtenerUsuario(ped5.getNickUsr());
            Pedido p5 = c5.getPedido(ped5.getId());
            p5.setFecha("25/8/2014");
            ICPed.actualizarEPedido(ped5.getNickUsr(), p5.getId(), estados.RECIBIDO);
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
        
        Iterator it = ICU.retColCat().entrySet().iterator();
        ArrayList<DataCategoria> lista = new ArrayList<>();
        while (it.hasNext()){
            Map.Entry cats =(Map.Entry)it.next();
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
        }if(request.getParameter("list-group-item") != null){
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    if (request.getParameter("ingresar") != null) {
        
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
   
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
