/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import lab01.server.DataCategoria;
import lab01.server.DataCliente;
import lab01.server.DataIndividual;
import lab01.server.DataPedido;
import lab01.server.DataRestaurante;
import lab01.server.DtoDatosAdicionales;
import lab01.server.DtoIngresarDatos;
import lab01.server.DtoRegistrarCliente;
import lab01.server.PublicadorUsuario;
import lab01.server.PublicadorUsuarioService;
import lab01.server.StringArray;

/**
 *
 * @author joaco
 */
public class ProxyUsuario {
    
    private Integer idCtrlUsuario;
    private static ProxyUsuario instance = null;
    private PublicadorUsuario CU = null;
    private Properties prop;
    private InputStream input;
    private String cfgFolder;
    private String propertiesFile;
    private String propFilePath;
    
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
            prop.store(writer, "WorkStation Client Settings");
            writer.close();
            propFilePath = cfg.getAbsolutePath();
        } catch (IOException ex) {
            Logger.getLogger(ProxyProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private ProxyUsuario(){
        try {
            String usrpath = System.getProperty("user.home");
            File folder = new File(usrpath+"/.QuickOrder/WorkStation");
            if(!folder.exists() && !folder.mkdirs()){
                throw new IllegalStateException("Couldn't create dir: " + folder);
            }
            cfgFolder = folder.getPath();
            propertiesFile = "ProxyUsr.properties";
            prop = new Properties();
            input = null;
            if(!existCfgFile()){
                createCfgFile();
            }
            File Archivo = new File(cfgFolder,propertiesFile);
            input = new FileInputStream(Archivo);
            prop.load(input);
            String ip = prop.getProperty("Ip");
            String puerto = prop.getProperty("Port");
            String deployname = prop.getProperty("DeployName");
            URL url = new URL("http://"+ip+":"+puerto+"/"+deployname);
            idCtrlUsuario = null;
            PublicadorUsuarioService servicio = new PublicadorUsuarioService(url);
            CU = servicio.getPublicadorUsuarioPort();
            idCtrlUsuario = CU.getId();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProxyUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProxyUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ProxyUsuario getInstance(){
        if(ProxyUsuario.instance == null){
            ProxyUsuario.instance = new ProxyUsuario();
        }
        return ProxyUsuario.instance;
    }
    
    public void setNickname(String nickname){
        CU.setNickname(idCtrlUsuario, nickname);
    }
    
    public String getNickname(){
        return CU.getNickname(idCtrlUsuario);
    }
    
    public boolean ingresarDatos(DtoIngresarDatos datos){
        return CU.ingresarDatos(idCtrlUsuario, datos);
    }
    
    public void registrarCliente(DtoRegistrarCliente datos){
        CU.registrarCliente(idCtrlUsuario, datos);
    }
    
    public void registrarRestaurante(DataRestaurante dt){
        CU.registrarRestaurante(idCtrlUsuario, dt);
    }
    
    public void datosAdicionales(DtoDatosAdicionales datos){
        CU.datosAdicionales(idCtrlUsuario, datos);
    }
    
    public DataCliente getUsuarioByNickname(String nickname){
        return CU.getUsuarioByNickname(idCtrlUsuario, nickname);
    }
    
    public DataRestaurante getRestauranteByNickname(String nickname){
        return CU.getRestauranteByNickname(idCtrlUsuario, nickname);
    }
    
    public ArrayList<DataCliente> devListaDC(){
        ArrayList<DataCliente> ret = new ArrayList<>();
        ret.addAll(CU.devListaDC(idCtrlUsuario).getItem());
        return ret;
    }
    
    public ArrayList<DataRestaurante> listaDataRestaurantes(){
        ArrayList<DataRestaurante> ret = new ArrayList<>();
        ret.addAll(CU.listaDataRestaurantes(idCtrlUsuario).getItem());
        return ret;
    }
    
    public void registrarCat(String nombre){
        CU.registrarCat(idCtrlUsuario, nombre);
    }
    
    public ArrayList<DataCategoria> retColCat(){
        ArrayList<DataCategoria> ret = new ArrayList<>();
        ret.addAll(CU.retColCat(idCtrlUsuario).getItem());
        return ret;
    }
    
    public ArrayList<DataRestaurante> listaUsuPorCategoria(String cate){
        ArrayList<DataRestaurante> ret = new ArrayList<>();
        ret.addAll(CU.listaUsuPorCategoria(idCtrlUsuario, cate).getItem());
        return ret;
    }
    
    public void setCat(ArrayList<String> cate){
        StringArray param = new StringArray();
        for(String ci: cate){
            param.getItem().add(ci);
        }
        CU.setCat(idCtrlUsuario, param);
    }
    
    public ArrayList<DataCategoria> getLstCat(){
        ArrayList<DataCategoria> ret = new ArrayList<>();
        ret.addAll(CU.getLstCat(idCtrlUsuario).getItem());
        return ret;
    }
    
    public ArrayList<DataIndividual> listaProductosStock(String r){
        ArrayList<DataIndividual> ret = new ArrayList<>();
        ret.addAll(CU.listaProductosStock(idCtrlUsuario, r).getItem());
        return ret;
    }
    
    public ArrayList<DataPedido> listarPedidos(){
        ArrayList<DataPedido> ret = new ArrayList<>();
        ret.addAll(CU.listarPedidos(idCtrlUsuario).getItem());
        return ret;
    }
    
    public ArrayList<DataPedido> pedidosUsuario(String nickname){
        ArrayList<DataPedido> ret = new ArrayList<>();
        ret.addAll(CU.pedidosUsuario(idCtrlUsuario, nickname).getItem());
        return ret;
    }
    
    public boolean existeUsuario(String nickname, String mail){
        return CU.existeUsuario(idCtrlUsuario, nickname, mail);
    }
    
    public boolean existeNickname(String nickname){
        return CU.existeNickname(idCtrlUsuario, nickname);
    }
    
    public boolean existeMail(String mail){
        return CU.existeMail(idCtrlUsuario, mail);
    }
    
    public DataCliente getByMail(String mail){
        return CU.getByMail(idCtrlUsuario, mail);
    }
    
    public ArrayList<DataRestaurante> buscarRestaurantes(String nombre){
        ArrayList<DataRestaurante> ret = new ArrayList<>();
        ret.addAll(CU.buscarRestaurantes(idCtrlUsuario, nombre).getItem());
        return ret;
    }
    
}