/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

/**
 *
 * @author gera
 */
public abstract class Usuario {
    protected String nickname;
    protected String nombre;
    protected String mail;
    protected String direccion;
    protected String imagen; //esto es duda
    protected String tipoUsuario;

    public Usuario() {
    }
    
    public Usuario(String nickname, String nombre, String email, String direccion) {
        this.nickname=nickname;
        this.nombre=nombre;
        this.mail=email;
        this.direccion=direccion;
        this.tipoUsuario= "";
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMail() {
        return mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void getTipoUsuario(String tu)
    {
        tipoUsuario = tu;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    

    public String getImagen() {
        return imagen;
    }
   
      
    
}
