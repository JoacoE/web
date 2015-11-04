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
public class DTOActualizarIndividual {
    
    private DataIndividual di;
    private String nombre;
    private String nickRest;
    private String imagen;
    
    public DTOActualizarIndividual(){}
    
    public DTOActualizarIndividual(DataIndividual di, String nombre, String nickRest){
        this.di = di;
        this.nombre = nombre;
        this.nickRest = nickRest;
    }

    public DataIndividual getDi() {
        return di;
    }

    public void setDi(DataIndividual di) {
        this.di = di;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickRest() {
        return nickRest;
    }

    public void setNickRest(String nickRest) {
        this.nickRest = nickRest;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
