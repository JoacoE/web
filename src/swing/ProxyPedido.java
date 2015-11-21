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
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.xml.ws.Endpoint;
import lab01.server.DataCategoria;
import lab01.server.DataRestaurante;
import lab01.server.DataCliente;
import lab01.server.DataPedido;
import lab01.server.DataProducto;
import lab01.server.DtoEvaluacion;
import lab01.server.Estados;
import lab01.server.PublicadorPedido;
import lab01.server.PublicadorPedidoService;
import java.util.Properties;

/**
 *
 * @author joaco
 */
public class ProxyPedido {
    private Integer idCtrlPedido;
    private static ProxyPedido instance = null;
    private PublicadorPedido PP;
    private Properties prop;
    private InputStream input;
    private String jarDir;
    private String propertiesFile;
    private String propFilePath;
    
    public boolean existCfgFile(){
        File cfg = new File(jarDir,propertiesFile);
        if(cfg.exists()){
            return true;
        }
        return false;
    }
    
    public void createCfgFile(){
        try{
            File cfg = new File(jarDir,propertiesFile);
            prop.setProperty("Ip", "127.0.0.1");
            prop.setProperty("Port", "9003");
            prop.setProperty("DeployName", "pubped");
            FileWriter writer = new FileWriter(cfg);
            prop.store(writer, "Swing Client Settings");
            writer.close();
            propFilePath = cfg.getAbsolutePath();
        } catch (IOException ex) {
            Logger.getLogger(ProxyPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ProxyPedido(){
        try {
            CodeSource codeSource = ProxyPedido.class.getProtectionDomain().getCodeSource();
            File jarFile;
            jarFile = new File(codeSource.getLocation().toURI().getPath());
            jarDir = jarFile.getParentFile().getPath();
            propertiesFile = "ProxyPed.properties";
            prop = new Properties();
            input = null;
            if(!existCfgFile()){
                createCfgFile();
            }
            input = new FileInputStream(propFilePath);
            prop.load(input);
            String ip = prop.getProperty("Ip");
            String puerto = prop.getProperty("Port");
            String deployname = prop.getProperty("DeployName");
            URL url = new URL("http://"+ip+":"+puerto+"/"+deployname);
            idCtrlPedido = null;
            PublicadorPedidoService servicio = new PublicadorPedidoService(url);
            PP = servicio.getPublicadorPedidoPort();
            idCtrlPedido = PP.getId();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ProxyPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProxyPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProxyPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProxyPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ProxyPedido getInstance(){
        if(ProxyPedido.instance == null){
            ProxyPedido.instance = new ProxyPedido();
        }
        return ProxyPedido.instance;
    }
    
    public void setNickname(String nick){
        PP.setNickname(idCtrlPedido, nick);
    }
    
    public void setMailCliente(String mail){
        PP.setMailCliente(idCtrlPedido, mail);
        
    }
    
    public void setMemCliente(){
        PP.setMemCliente(idCtrlPedido);
    }

    public void setCat(String nombre){
        PP.setCat(idCtrlPedido, nombre);
    }
    
    public String getCat(){
       return PP.getCat(idCtrlPedido);
    }

    public String getNickname(){
        return PP.getNickname(idCtrlPedido);
    }
    
    public ArrayList<DataCliente> devListaDC(int index){
        ArrayList<DataCliente> lista = new ArrayList<>();
        lista.addAll(PP.devListaDC(idCtrlPedido).getItem());
        return lista;
    }
    
    public ArrayList<DataRestaurante> devListaDR(){
        ArrayList<DataRestaurante> ret = new ArrayList<>();
        ret.addAll(PP.devListaDR(idCtrlPedido).getItem());
        return ret;
    }
    
    public ArrayList<DataCategoria> retColDCat(){
        ArrayList<DataCategoria> ret = new ArrayList<>();
        ret.addAll(PP.retColDCat(idCtrlPedido).getItem());
        return ret;
    }
    
    public DataProducto devListaProductos(){
        return PP.devListaProductos(idCtrlPedido);
        
    }
    
    public boolean selectProductos(String nombre, int cantidad){
        return PP.selectProductos(idCtrlPedido, nombre,cantidad);
    }
    
    public void setMonto(){
        PP.setMonto(idCtrlPedido);
    }
    
    public DataPedido altaPedido(){
        return PP.altaPedido(idCtrlPedido);
    }
      
    public ArrayList<DataPedido> listDataPedidos(){
        ArrayList<DataPedido> lista = new ArrayList<>();
        lista.addAll(PP.listDataPedidos(idCtrlPedido).getItem());
        return lista;
    }

    public void actualizarEPedido(String nickname, long id, Estados estado){
        PP.actualizarEPedido(idCtrlPedido, nickname, id, estado);
    }
    
    public void actualizarEPedidoCDatos(String nickname, long id, Estados estado, String fecha){
        PP.actualizarEPedidoCDatos(idCtrlPedido, nickname, id, estado, fecha);
    }
    
    public void setDp(DataPedido dp){
        PP.setDp(idCtrlPedido, dp);
    }
    
    public DataPedido getDp(){
        return PP.getDp(idCtrlPedido);
    }
    
    public void setMemoriaCliente(String nickname){
        PP.setMemoriaCliente(idCtrlPedido, nickname);
    }
    
    public void limpiarCtrl(){
        PP.limpiarCtrl(idCtrlPedido);
    }
    
    public void cancelarPedido(long id){
        PP.cancelarPedido(idCtrlPedido, id);
    }
    
    public ArrayList<DataPedido> listaPedidosRecibidos(String nickname){
        ArrayList<DataPedido> lista = new ArrayList<>();
        lista.addAll(PP.listaPedidosRecibidos(idCtrlPedido, nickname).getItem());
        return lista;
    }
    
    public void actualizarPromedioRest(String nickname){
        PP.actualizarPromedioRest(idCtrlPedido, nickname);
    }

    public void altaEvaluacion(double id, DtoEvaluacion data){
        PP.altaEvaluacion(idCtrlPedido, id, data);
    }

    public ArrayList<DtoEvaluacion> listarEvaluacionesRest(String nickname){
        ArrayList<DtoEvaluacion> lista = new ArrayList<>();
        lista.addAll(PP.listarEvaluacionesRest(idCtrlPedido, nickname).getItem());
        return lista;
    }

    public DtoEvaluacion getEvaluacionXid(long id){
        return PP.getEvaluacionXid(idCtrlPedido, id);
    }
    
    public ArrayList<DataPedido> listaPedidos(String nickname){
        ArrayList<DataPedido> lista = new ArrayList<>();
        lista.addAll(PP.listaPedidos(idCtrlPedido, nickname).getItem());
        return lista;
    }
    
    public void setMemRestaurante(String nickname){
     PP.setMemRestaurante(idCtrlPedido, nickname);
    }
    
    public void actualizarFechaPedido(String nickname, long id, String fecha){
        PP.actualizarFechaPedido(idCtrlPedido, nickname, id, fecha);
    }
    
}