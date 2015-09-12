/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab01.Clases;

/**
 *
 * @author admin123
 */
public class DataUsuario {

    private String nombre;
    private String mail;

    public DataUsuario(String nombre, String mail){
        this.nombre=nombre;
        this.mail=mail;
    }
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getMail(){
        return this.mail;
    }
    
    public void setMail(String mail){
        this.mail=mail;
    }
}


