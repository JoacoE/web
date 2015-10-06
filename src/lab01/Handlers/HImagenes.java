/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import static java.nio.file.Files.copy;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author joaco
 */
public class HImagenes {
    private static String carpeta;
    private static HImagenes instancia = null;

    private HImagenes(){
        try {
            CodeSource codeSource = HImagenes.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String imagenes = jarFile.getParentFile().getPath();
            String image = "/imagenes";
            carpeta = imagenes.concat(image);
            boolean success = (new File(carpeta).mkdir());
            if(!success){
                File directorio = new File(carpeta);
                if(!directorio.exists()){
                    throw new NullPointerException();
                }
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(HImagenes.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public static HImagenes getInstance(){
        if(instancia == null){
            instancia = new HImagenes();
        }
        return instancia;
    }
    
    public void guardarImagen(File imagen, String nickname){       
        if(imagen.exists()){
            try {
                File guardar = new File(carpeta, nickname);
                Path pathcarpeta = Paths.get(guardar.getAbsolutePath());
                Path pathimagen = Paths.get(imagen.getAbsolutePath());
                Path img = copy(pathimagen, pathcarpeta, StandardCopyOption.REPLACE_EXISTING);
                File nuevo = img.toFile();
                nuevo.renameTo(guardar);
            } catch (Exception e) {
                e = new IOException();
            }
        }
    }
    
    public File getImagen(String nickname){
        return new File(carpeta, nickname);
    }
    
    public void guardarArrayImg(ArrayList<File> imagenes, String nickname){
        try{
            int i = 0;
            for(File ci: imagenes){
                String indice = String.valueOf(i);
                String newName = nickname.concat(indice);
                File guardar = new File(carpeta, newName);
                Path pathcarpeta = Paths.get(guardar.getAbsolutePath());
                Path pathimagen = Paths.get(ci.getAbsolutePath());
                Path img = copy(pathimagen, pathcarpeta, StandardCopyOption.REPLACE_EXISTING);
                File nuevo = img.toFile();
                nuevo.renameTo(guardar);
                i++;
            }
        }catch(Exception e){
            e = new IOException();
        }
    }
    
    public ArrayList<File> getArrayImg(String nickname){
        boolean finalizar = false;
        ArrayList<File> imagenes = new ArrayList<>();
        File planb = null;
        File aux = new File(carpeta, nickname.concat("0"));
        int i = 0;
        while(finalizar == false){
            String indice = String.valueOf(i);
            String nombreRetorno = nickname.concat(indice);
            File retorno = new File(carpeta, nombreRetorno);
            if(retorno.exists()){
                imagenes.add(retorno);
            }
            else{
                finalizar = true;
            }
            i++;
        }
        return imagenes;
    }
    
    public String getCarpeta(){//devuelve el path de la carpeta de imagenes como un string
        return this.carpeta;
    }
    
    public ImageIcon getNoImgeUsuario(){
        URL imagePath = null;
        try {
            imagePath = new URL(getClass().getResource("/Helpers/generico.jpeg").toString());
        } catch (MalformedURLException ex) {
        }
        return new ImageIcon(imagePath);
    }
    
    public ImageIcon getNoImage(){
        URL imagePath = null;
        try {
            imagePath = new URL(getClass().getResource("/Helpers/Noimage.png").toString());
        } catch (MalformedURLException ex) {
        }
        return new ImageIcon(imagePath);
    }
}