/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

/**
 *
 * @author joaco
 */
public class DTOIngresarDatos {
    private String nickname;
    private String nombre;
    private String email;
    private String direccion;

    public DTOIngresarDatos(){
    }
    
    public DTOIngresarDatos(String nickname, String nombre, String email, String direccion){
        this.nickname = nickname;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }
    
    
}
