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
public class DtoDatosAdicionales {
    
    private String apellido;
    private String imagen;
    
    public DtoDatosAdicionales(){}
    
    public DtoDatosAdicionales(String apellido, String imagen){
        this.apellido = apellido;
        this.imagen = imagen;
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
}
