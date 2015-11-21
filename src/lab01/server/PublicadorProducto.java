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
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Arrays;
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
import lab01.Clases.DtoActualizarIndividual;
import lab01.Clases.DtoActualizarPromocional;
import lab01.Clases.DtoArmarPromo;
import lab01.Clases.DtoRegistrarProducto;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataPromocional;
import lab01.Handlers.Fabrica;

/**
 *
 * @author joaco
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorProducto {
    
    private Endpoint endpoint = null;
    private Properties prop;
    private InputStream input;
    private String jarDir;
    private String propertiesFile;
    private String propFilePath;
    
    public PublicadorProducto(){
        try {
            CodeSource codeSource = PublicadorProducto.class.getProtectionDomain().getCodeSource();
            File jarFile;
            jarFile = new File(codeSource.getLocation().toURI().getPath());
            jarDir = jarFile.getParentFile().getPath();
        } catch (URISyntaxException ex) {
            Logger.getLogger(PublicadorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        prop = new Properties();
        input = null;
        propertiesFile = "PublicadorProd.properties";
    }
    
    public boolean existCfgFile(){
        File cfg = new File(jarDir,propertiesFile);
        if(cfg.exists()){
            return true;
        }
        return false;
    }
    
    public void createCfgFile(){
        try{
            CodeSource codeSource = PublicadorProducto.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            jarDir = jarFile.getParentFile().getPath();
            File cfg = new File(jarDir,propertiesFile);
            prop.setProperty("Ip", "127.0.0.1");
            prop.setProperty("Port", "9002");
            prop.setProperty("DeployName", "pubprod");
            FileWriter writer = new FileWriter(cfg);
            prop.store(writer, "Endpoint Settings");
            writer.close();
            propFilePath = cfg.getAbsolutePath();
        } catch (URISyntaxException ex) {
            Logger.getLogger(PublicadorProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PublicadorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(exclude = true)
    public void publicProd(){
        try{
            if(!existCfgFile()){
                createCfgFile();
            }
            input = new FileInputStream(propFilePath);
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
        return Fabrica.getInstance().getICtrlProducto(null).getIdCtrl();
    }
    
    @WebMethod
    public void registrarProducto(Integer idCtrlProducto, DtoRegistrarProducto datos){
        Fabrica.getInstance().getICtrlProducto(idCtrlProducto).registrarProducto(datos);
    }
    
    @WebMethod
    public boolean existeRestaurante(Integer idCtrlProducto, String nomRest){
        return Fabrica.getInstance().getICtrlProducto(idCtrlProducto).existeRestaurante(nomRest);
    }
    
    @WebMethod
    public DataIndividual[] listarIndividuales(Integer idCtrlProducto, String nomRest){
        ArrayList<DataIndividual> datas = Fabrica.getInstance().getICtrlProducto(idCtrlProducto).listarIndividuales(nomRest);
        DataIndividual[] ret = new DataIndividual[datas.size()];
        Iterator it = datas.iterator();
        int i = 0;
        while (it.hasNext()){
            ret[i]= (DataIndividual)it.next();
            i++;
        }        
        return ret;
    }
    
    @WebMethod
    public void setPromo(Integer idCtrlProducto, DataIndividual[] promo){
        ArrayList<DataIndividual> ret = new ArrayList();
        ret.addAll(Arrays.asList(promo));
        Fabrica.getInstance().getICtrlProducto(idCtrlProducto).setPromo(ret);
    }
    
    @WebMethod
    public void armarPromo(Integer idCtrlProducto, DtoArmarPromo datos){
        Fabrica.getInstance().getICtrlProducto(idCtrlProducto).armarPromo(datos);
    }
    
    @WebMethod
    public void actualizarIndividual(Integer idCtrlProducto, DtoActualizarIndividual datos){
        Fabrica.getInstance().getICtrlProducto(idCtrlProducto).actualizarIndividual(datos);
    }
    
    @WebMethod
    public void actualizarPromocional(Integer idCtrlProducto, DtoActualizarPromocional datos){
        Fabrica.getInstance().getICtrlProducto(idCtrlProducto).actualizarPromocional(datos);
    }
    
    @WebMethod
    public DataIndividual getProdIndividualXNombre(Integer idCtrlProducto, String nombre){
        DataIndividual ret = Fabrica.getInstance().getICtrlProducto(idCtrlProducto).getProdIndividualXNombre(nombre);
        return ret;
    }
    
    @WebMethod
    public DataPromocional getProdPromocionalXNombre(Integer idCtrlProducto, String nombre){
        DataPromocional ret = Fabrica.getInstance().getICtrlProducto(idCtrlProducto).getProdPromocionalXNombre(nombre);
        return ret;
    }
}
