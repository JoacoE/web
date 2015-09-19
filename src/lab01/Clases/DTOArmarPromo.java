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
public class DTOArmarPromo {
    String nickRest;
    String nombre;
    String descripcion;
    double descuento;
    
    public DTOArmarPromo(){
    }
    
    public DTOArmarPromo(String nickRest, String nombre, String descripcion, double descuento){
        this.nickRest = nickRest;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuento = descuento;
    }

    public String getNickRest() {
        return nickRest;
    }

    public void setNickRest(String nickRest) {
        this.nickRest = nickRest;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
