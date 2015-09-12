/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author joaquin
 */
public class DataRestaurante {
    private String nickname;
    private String nombre;
    private String email;
    private String direccion;
    private ArrayList<String> lstImagen;
    private Map ColCategoria;
    private Map ColProducto;

    
    public DataRestaurante(){}
    
    public DataRestaurante(String nickname, String mail, String nombre, String direccion, ArrayList<String>lstImagen, Map colProd, Map colCategoria){
        this.nickname=nickname;
        this.nombre=nombre;
        this.email=mail;
        this.direccion=direccion;
        this.lstImagen=lstImagen;
        this.ColProducto=colProd;
        this.ColCategoria=colCategoria;
    }

    public Usuario dataResAres(){
        Usuario r = new Restaurante(this.nickname, this.nombre, this.email, this.direccion, this.lstImagen, this.ColProducto, this.ColCategoria);
        return r;
    }
    public boolean member(String nombre){
        return ColCategoria.containsKey(nombre);
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
        this.ColCategoria = colCategoria;
    }
    
    public Map getColCategoria(){
        return this.ColCategoria;
    }
    
    public Map getColProducto(){
        return this.ColProducto;
    }
    
    public void setColProducto(Map colProd){
        this.ColProducto = colProd;
        
    }
    
    public Map listarCategorias(){
        return this.ColCategoria;
    }
}
