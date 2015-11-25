/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

/**
 *
 * @author joaquin
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import lab01.server.DataIndividual;
import lab01.server.DataIndividualArray;
import lab01.server.DataPromocional;
import lab01.server.DtoActualizarIndividual;
import lab01.server.DtoActualizarPromocional;
import lab01.server.DtoArmarPromo;
import lab01.server.DtoRegistrarProducto;
import lab01.server.PublicadorProducto;
import lab01.server.PublicadorProductoService;
/**
 *
 * @author joaquin
 */
public class ProxyProducto {
    
    private Integer idCtrlProducto;
    private static ProxyProducto instance = null;
    private PublicadorProducto CP;
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
            prop.setProperty("Port", "9002");
            prop.setProperty("DeployName", "pubprod");
            FileWriter writer = new FileWriter(cfg);
            prop.store(writer, "Swing Client Settings");
            writer.close();
            propFilePath = cfg.getAbsolutePath();
        } catch (IOException ex) {
            Logger.getLogger(ProxyProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ProxyProducto(){
        try {
            CodeSource codeSource = ProxyProducto.class.getProtectionDomain().getCodeSource();
            File jarFile;
            jarFile = new File(codeSource.getLocation().toURI().getPath());
            jarDir = jarFile.getParentFile().getPath();
            propertiesFile = "ProxyProd.properties";
            prop = new Properties();
            input = null;
            if(!existCfgFile()){
                createCfgFile();
            }
            File Archivo = new File(jarDir,propertiesFile);
            input = new FileInputStream(Archivo);
            prop.load(input);
            String ip = prop.getProperty("Ip");
            String puerto = prop.getProperty("Port");
            String deployname = prop.getProperty("DeployName");
            URL url = new URL("http://"+ip+":"+puerto+"/"+deployname);
            idCtrlProducto = null;
            PublicadorProductoService servicio = new PublicadorProductoService(url);
            CP = servicio.getPublicadorProductoPort();
            idCtrlProducto = CP.getId();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ProxyProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProxyProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProxyProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ProxyProducto getInstance(){
        if(ProxyProducto.instance == null){
            ProxyProducto.instance = new ProxyProducto();
        }
        return ProxyProducto.instance;
        }    

        public void registrarProducto(DtoRegistrarProducto datos){
            CP.registrarProducto(idCtrlProducto, datos);
        }

        public boolean existeRestaurante(String nomRest){
            return CP.existeRestaurante(idCtrlProducto, nomRest);
        }

        public ArrayList<DataIndividual> listarIndividuales(String nomRest){
            ArrayList<DataIndividual> ret = new ArrayList<>();
            ret.addAll(CP.listarIndividuales(idCtrlProducto, nomRest).getItem());
            return ret;
        }

        public void setPromo(ArrayList<DataIndividual> promo){
            DataIndividualArray param = new DataIndividualArray();
            for(DataIndividual di: promo){
                param.getItem().add(di);
            }
            CP.setPromo(idCtrlProducto, param);
        }

        public void armarPromo(DtoArmarPromo datos){
            CP.armarPromo(idCtrlProducto, datos);
        }

        public void actualizarIndividual(DtoActualizarIndividual datos){
            CP.actualizarIndividual(idCtrlProducto, datos);
        }

        public void actualizarPromocional(DtoActualizarPromocional datos){
            CP.actualizarPromocional(idCtrlProducto, datos);
        }

        public DataIndividual getProdIndividualXNombre(String nombre){
            lab01.server.DataIndividual ret = CP.getProdIndividualXNombre(idCtrlProducto, nombre);
            return ret;
        }

        public DataPromocional getProdPromocionalXNombre(String nombre){
            lab01.server.DataPromocional ret = CP.getProdPromocionalXNombre(idCtrlProducto, nombre);
            return ret;
        }
    }