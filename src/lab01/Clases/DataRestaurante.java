/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author joaquin
 */
public class DataRestaurante {
    private String nickname;
    private String nombre;
    private String email;
    private String direccion;
    private String pwd;
    private float promedio;
    private ArrayList<String> lstImagen;
    private Map ColCategoria = new HashMap();
    private Map ColProducto = new HashMap();

    
    public DataRestaurante(){}
    
    public DataRestaurante(String nickname, String nombre, String mail, String direccion, ArrayList<String>lstImagen, Map colProd, Map colCategoria, String pwd){
        this.nickname=nickname;
        this.nombre=nombre;
        this.email=mail;
        this.direccion=direccion;
        this.pwd = pwd;
        if(lstImagen == null){
            this.lstImagen = null;
        }else{
            this.lstImagen = new ArrayList<>();
            this.lstImagen.addAll(lstImagen);
        }
        if(colProd == null){
            this.ColProducto = null;
        }else{
            this.ColProducto = new HashMap();
            this.ColProducto.putAll(colProd);
        }
        if(colCategoria == null){
            this.ColCategoria = null;
        }else{
            this.ColCategoria = new HashMap();
            this.ColCategoria.putAll(colCategoria);
        }
    }
    
    public DataRestaurante(String nickname, String mail, String nombre, String direccion, ArrayList<String>lstImagen, Map colProd, Map colCategoria, String pwd, float promedio){
        this.nickname=nickname;
        this.nombre=nombre;
        this.email=mail;
        this.direccion=direccion;
        this.pwd = pwd;
        this.promedio = promedio;
        if(lstImagen == null){
            this.lstImagen = null;
        }else{
            this.lstImagen = new ArrayList<>();
            this.lstImagen.addAll(lstImagen);
        }
        if(colProd == null){
            this.ColProducto = null;
        }else{
            this.ColProducto = new HashMap();
            this.ColProducto.putAll(colProd);
        }
        if(colCategoria == null){
            this.ColCategoria = null;
        }else{
            this.ColCategoria = new HashMap();
            this.ColCategoria.putAll(colCategoria);
        }
    }

    public boolean member(String nombre){
        Iterator dcats = getColCategoria().entrySet().iterator();
        while(dcats.hasNext()){
            Map.Entry dcat = (Map.Entry) dcats.next();
            DataCategoria dc = (DataCategoria)dcat.getValue();
            if(dc.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
    
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    
    public String getNickname(){
        return this.nickname;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setEmail(String mail){
        this.email = mail;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public String getDireccion(){
        return this.direccion;
    }
    
    public void setLstImagen(ArrayList<String> lstImagen){
        this.lstImagen = lstImagen;
    }
    
    public ArrayList<String> getLstImagen(){
        return this.lstImagen;
    }
    
    public void setColCategoria(Map colCategoria){
        this.ColCategoria.putAll(colCategoria);
    }
    
    public Map getColCategoria(){
        return this.ColCategoria;
    }
    
    public Map getColProducto(){
        return this.ColProducto;
    }
    
    public void setColProducto(Map colProd){
        this.ColProducto.putAll(colProd);
    }
    
    public Map listarCategorias(){
        return this.ColCategoria;
    }
    
    public void setPwd(String pwd){
        this.pwd = pwd;
    }
    
    public String getPwd(){
        return this.pwd;
    }
    
    public void setPromedio(float promedio){
        this.promedio = promedio;
    }
    
    public float getPromedio(){
        return this.promedio;
    }
}
