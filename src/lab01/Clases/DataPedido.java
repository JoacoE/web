/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author joaco
 */
public class DataPedido {
    private long id;  //ver q historia con el autogenerado...
    private String fecha; 
    private double precio_total;
    private estados estado;
    private String nickUsr;
    private String mailUsr;
    private String nickRest; //o el nombre no c
    private Map ColCarrito; //map de DataCarrito
    
    public DataPedido(long id, String nickUsr, String mailUsr, String fecha, String nickRest, Map ColCarrito, double precio_total, estados estado){
        this.id = id;
        this.nickUsr = nickUsr;
        this.mailUsr = mailUsr;
        this.fecha = fecha;
        this.nickRest = nickRest;
        this.ColCarrito = new HashMap();
        this.ColCarrito.putAll(ColCarrito);
        //if(this.ColCarrito.isEmpty()){
        //    this.ColCarrito = new HashMap();}
        this.precio_total = precio_total;
        this.estado = estado;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public estados getEstado() {
        return estado;
    }

    public void setEstado(estados estado) {
        this.estado = estado;
    }
    
    public String getNickUsr(){
        return this.nickUsr;
    }
    
    public void setNickUsr(String nickUsr){
        this.nickUsr = nickUsr;
    }
    
    public String getMailUsr(){
        return this.mailUsr;
    }
    
    public void setMailUsr(String mailUsr){
        this.mailUsr = mailUsr;
    }
    
    public String getNickRest(){
        return this.nickRest;
    }
    
    public void setNickRest(String nickRest){
        this.nickRest = nickRest;
    }
    
    public Map getColCarrito(){
        return this.ColCarrito;
    }
    
    public void setColCarrito(Map ColCarrito){//por si queda mas comodo...
        this.ColCarrito = ColCarrito;
    }
    
    public void setDatCarrito(DataCarrito dc){
        this.ColCarrito.put(dc.getNomProd(), dc);
    }
}
