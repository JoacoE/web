/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import lab01.Clases.DtoDatosAdicionales;
import lab01.Clases.DtoIngresarDatos;
import lab01.Clases.DtoRegistrarCliente;
import lab01.Clases.DataCategoria;
import lab01.Clases.DataCliente;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataPedido;
import lab01.Clases.DataRestaurante;
import lab01.Handlers.Fabrica;

/**
 *
 * @author joaco
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorUsuario {
    
    private Endpoint endpoint = null;
    private Properties prop;
    private InputStream input;
    private String cfgFolder;
    private String propertiesFile;
    private String propFilePath;
    
    public PublicadorUsuario(){
        String usrpath = System.getProperty("user.home");
        File folder = new File(usrpath+"/.QuickOrder/CentralServer");
        if(!folder.exists() && !folder.mkdirs()){
            throw new IllegalStateException("Couldn't create dir: " + folder);
        }
        cfgFolder = folder.getPath();
        prop = new Properties();
        input = null;
        propertiesFile = "PublicadorUsr.properties";
    }
    
    public boolean existCfgFile(){
        File cfg = new File(cfgFolder,propertiesFile);
        if(cfg.exists()){
            return true;
        }
        return false;
    }
    
    public void createCfgFile(){
        try{
            File cfg = new File(cfgFolder,propertiesFile);
            prop.setProperty("Ip", "127.0.0.1");
            prop.setProperty("Port", "9001");
            prop.setProperty("DeployName", "pubusr");
            FileWriter writer = new FileWriter(cfg);
            prop.store(writer, "Endpoint Settings");
            writer.close();
            propFilePath = cfg.getAbsolutePath();
        } catch (IOException ex) {
            Logger.getLogger(PublicadorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(exclude = true)
    public void publicUsr(){
        try{
            if(!existCfgFile()){
                createCfgFile();
            }
            File Archivo = new File(cfgFolder,propertiesFile);
            input = new FileInputStream(Archivo);
            prop.load(input);
            String ip = prop.getProperty("Ip");
            String puerto = prop.getProperty("Port");
            String deployname = prop.getProperty("DeployName");
            String url = "http://"+ip+":"+puerto+"/"+deployname;
            endpoint = Endpoint.publish(url, this);
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
    }
    
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public Integer getId(){
        Integer idCtrlUsuario = Fabrica.getInstance().getICtrlUsuario(null).getIdCtrl();
        return idCtrlUsuario;
    }
    
    @WebMethod
    public void setNickname(Integer idCtrlUsuario, String nick){
        Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).setNickname(nick);
    }
    
    @WebMethod
    public String getNickname(Integer idCtrlUsuario){
        String ret = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).getNickname();
        return ret;
    }
    
    @WebMethod
    public boolean ingresarDatos(Integer idCtrlUsuario, DtoIngresarDatos datos){
        return Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).ingresarDatos(datos);
    }
    
    @WebMethod
    public void registrarCliente(Integer idCtrlUsuario, DtoRegistrarCliente datos){
        Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).registrarCliente(datos);
    }
    
    @WebMethod
    public void registrarRestaurante(Integer idCtrlUsuario, DataRestaurante dt){
        Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).registrarRestaurante(dt);
    }
    
    @WebMethod
    public void datosAdicionales(Integer idCtrlUsuario, DtoDatosAdicionales datos){
        Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).datosAdicionales(datos);
    }
    
    @WebMethod
    public DataCliente getUsuarioByNickname(Integer idCtrlUsuario, String nickname){
        DataCliente ret = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).getUsuarioByNickname(nickname);
        return ret;
    }
    
    @WebMethod
    public DataRestaurante getRestauranteByNickname(Integer idCtrlUsuario, String nickname){
        DataRestaurante ret = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).getRestauranteByNickname(nickname);
        return ret;
    }
    
    @WebMethod
    public DataCliente[] devListaDC(Integer idCtrlUsuario){
        ArrayList<DataCliente> clientes = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).devListaDC();
        DataCliente[] ret = new DataCliente[clientes.size()];
        Iterator it = clientes.iterator();
        int index = 0;
        while(it.hasNext()){
            ret[index] = (DataCliente) it.next();
            index++;
        }
        return ret;
    }
    
    @WebMethod
    public DataRestaurante[] listaDataRestaurantes(Integer idCtrlUsuario){
        ArrayList<DataRestaurante> rests = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).listaDataRestaurantes();
        DataRestaurante[] ret = new DataRestaurante[rests.size()];
        Iterator it = rests.iterator();
        int index = 0;
        while(it.hasNext()){
            ret[index] = (DataRestaurante)it.next();
            index++;
        }
        return ret;
    }
    
    @WebMethod
    public void registrarCat(Integer idCtrlUsuario, String nombre){
        Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).registrarCat(nombre);
    }
    
    @WebMethod
    public DataCategoria[] retColCat(Integer idCtrlUsuario){
        ArrayList<DataCategoria> cats = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).retColCat();
        DataCategoria[] ret = new DataCategoria[cats.size()];
        Iterator it = cats.iterator();
        int index = 0;
        while(it.hasNext()){
            ret[index] = (DataCategoria)it.next();
            index++;
        }
        return ret;
    }
    
    @WebMethod
    public DataRestaurante[] listaUsuPorCategoria(Integer idCtrlUsuario, String cate){
        ArrayList<DataRestaurante> rests = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).listaUsuPorCategoria(cate);
        DataRestaurante[] ret = new DataRestaurante[rests.size()];
        Iterator it = rests.iterator();
        int index = 0;
        while(it.hasNext()){
            ret[index] = (DataRestaurante)it.next();
            index++;
        }
        return ret;
    }
    
    @WebMethod
    public void setCat(Integer idCtrlUsuario, String[] cate){
        ArrayList<String> param = new ArrayList<>();
        for(int i = 0; i < cate.length; i++){
            param.add(cate[i]);
        }
        Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).setCat(param);
    }
    
    @WebMethod
    public DataCategoria[] getLstCat(Integer idCtrlUsuario){
        ArrayList<DataCategoria> cats = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).getLstCat();
        DataCategoria[] ret = new DataCategoria[cats.size()];
        int index = 0;
        Iterator it = cats.iterator();
        while(it.hasNext()){
            ret[index] = (DataCategoria)it.next();
            index++;
        }
        return ret;
    }
    
    @WebMethod
    public DataIndividual[] listaProductosStock(Integer idCtrlUsuario, String r){
        ArrayList<DataIndividual> indivs = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).listaProductosStock(r);
        DataIndividual[] ret = new DataIndividual[indivs.size()];
        int index = 0;
        Iterator it = indivs.iterator();
        while(it.hasNext()){
            ret[index] = (DataIndividual)it.next();
            index++;
        }
        return ret;
    }
    
    @WebMethod
    public DataPedido[] listarPedidos(Integer idCtrlUsuario){
        ArrayList<DataPedido> peds = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).listarPedidos();
        DataPedido[] ret = new DataPedido[peds.size()];
        int index = 0;
        Iterator it = peds.iterator();
        while(it.hasNext()){
            ret[index] = (DataPedido)it.next();
            index++;
        }
        return ret;
    }
    
    @WebMethod
    public DataPedido[] pedidosUsuario(Integer idCtrlUsusario, String nickname){
        ArrayList<DataPedido> peds = Fabrica.getInstance().getICtrlUsuario(idCtrlUsusario).pedidosUsuario(nickname);
        DataPedido[] ret = new DataPedido[peds.size()];
        int index = 0;
        Iterator it = peds.iterator();
        while(it.hasNext()){
            ret[index] = (DataPedido)it.next();
            index++;
        }
        return ret;
    }
    
    @WebMethod
    public boolean existeUsuario(Integer idCtrlUsuario, String nickname, String email){
        return Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).existeUsuario(nickname, email);
    }
    
    @WebMethod
    public boolean existeNickname(Integer idCtrlUsuario, String nickname){
        return Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).existeNickname(nickname);
    }
    
    @WebMethod
    public boolean existeMail(Integer idCtrlUsuario, String mail){
        return Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).existeMail(mail);
    }
    
    @WebMethod
    public DataCliente getByMail(Integer idCtrlUsuario, String mail){
        DataCliente ret = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).getByMail(mail);
        return ret;
    }
    
    @WebMethod
    public DataRestaurante[] buscarRestaurantes(Integer idCtrlUsuario, String nombre){
        ArrayList<DataRestaurante> rests = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).buscarRestaurantes(nombre);
        DataRestaurante[] ret = new DataRestaurante[rests.size()];
        Iterator it = rests.iterator();
        int index = 0;
        while(it.hasNext()){
            ret[index] = (DataRestaurante) it.next();
            index++;
        }
        return ret;
    }
}