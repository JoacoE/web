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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfNac() {
        return fNac;
    }

    public void setfNac(String fNac) {
        this.fNac = fNac;
    }
    
    private String nickname;
    private String nombre;
    private String email;
    private String direccion;
    private String apellido;
    private String imagen;
    private String fNac;
    private String pwd;

    
    public DataCliente(){}
    
    public DataCliente(String nickname, String nombre, String mail, String direccion, String apellido, String img, String fecha, String pwd){
        this.nickname=nickname;
        this.nombre=nombre;
        this.email=mail;
        this.direccion=direccion;
        this.apellido = apellido;
        this.imagen=img;
        this.fNac = fecha;
        this.pwd = pwd;
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
    public void setNickname(String nickname) {    
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

//    public String getMail(){
//        return this.email;
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

//    }
    public String getNickname() {
        return this.nickname;
    }
    public String getDireccion(){
        return this.direccion;
    }

    public String getFNac(){
        return this.fNac;
    }
    
    public void setPwd(String pwd){
        this.pwd = pwd;
    }
    
    public String getPwd(){
        return this.pwd;
    }
    
//    public Usuario dataCliACli(){
//        Usuario c = new Cliente(this.nickname, this.nombre, this.email, this.direccion,this.apellido, this.imagen, this.fNac);
//        return c;
//    }
    
}
