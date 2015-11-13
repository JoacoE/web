/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author joaco
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtoRegistrarCliente {
    
    private String apellido;
    private String imagen;
    private String fecha;
    private String pwd;
    
    public DtoRegistrarCliente(){}
    
    public DtoRegistrarCliente(String apellido, String imagen, String fecha, String pwd){
        this.apellido = apellido;
        this.imagen = imagen;
        this.fecha = fecha;
        this.pwd = pwd;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void setPwd(String pwd){
        this.pwd = pwd;
    }
    
    public String getPwd(){
        return this.pwd;
    }
}
