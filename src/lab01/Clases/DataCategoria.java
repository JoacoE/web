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
 * @author joaquin
 */
@XmlAccessorType(XmlAccessType.FIELD)

public class DataCategoria {
    
    private String nombre;
    
    public DataCategoria(){}
    
    public DataCategoria(String nombre){
        this.nombre = nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
}
