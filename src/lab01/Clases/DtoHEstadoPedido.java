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
public class DtoHEstadoPedido{
    private String estado;
    private String fyhora;
    
    public DtoHEstadoPedido(){}
    
    public DtoHEstadoPedido(String estado, String fyhora){
        this.estado = estado;
        this.fyhora = fyhora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFyhora() {
        return fyhora;
    }

    public void setFyhora(String fyhora) {
        this.fyhora = fyhora;
    }
}
