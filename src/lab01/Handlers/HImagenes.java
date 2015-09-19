/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;

import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
                if(directorio.exists()){
                    JOptionPane.showMessageDialog(null, "El directorio de imagenes ya existe!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }else{
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
        File nuevo = new File(carpeta, nickname);
        imagen.renameTo(nuevo);
    }
    
    public File getImagen(String nickname){
        return new File(carpeta, nickname);
    }
    
    public void guardarArrayImg(ArrayList<File> imagenes, String nickname){
        int i = 0;
        for(File ci: imagenes){
            String indice = String.valueOf(i);
            String newName = nickname.concat(indice);
            File nuevo = new File(carpeta, newName);
            ci.renameTo(nuevo);
            i++;
        }
    }
    
    public ArrayList<File> getArrayImg(String nickname){
        boolean finalizar = false;
        ArrayList<File> imagenes = new ArrayList<>();
        for(int i = 0; finalizar == true; i++){
            String indice = String.valueOf(i);
            String nombreRetorno = nickname.concat(indice);
            File retorno = new File(carpeta, nombreRetorno);
            imagenes.add(retorno);
        }
        return imagenes;
    }
}