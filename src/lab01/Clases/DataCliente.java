/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import java.util.Date;

/**
 *
 * @author gonzalo
 */
public class DataCliente{
    
    private String nickname;
    private String nombre;
    private String email;
    private String direccion;
    private String apellido;
    private String imagen;
    private String fNac;

    
    public DataCliente(){}
    
    public DataCliente(String nickname, String mail, String nombre, String direccion, String apellido, String img, String fecha){
        this.nickname=nickname;
        this.nombre=nombre;
        this.email=mail;
        this.direccion=direccion;
        this.apellido = apellido;
        this.imagen=img;
        this.fNac = fecha;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public String getImagen(){
        return this.imagen;
    }
    
    public String getMail(){
        return this.email;
    }
    public String getNickname() {
        return this.nickname;
    }
    public String getDireccion(){
        return this.direccion;
    }

    public String getFNac(){
        return this.fNac;
    }
    
    public Usuario dataCliACli(){
        Usuario c = new Cliente(this.nickname, this.nombre, this.email, this.direccion,this.apellido, this.imagen, this.fNac);
        return c;
    }
    
}
