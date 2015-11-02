/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author joaco
 */
public class DataPedido {
    private long id;
    private String fecha; 
    private double precio_total;
    private Estados estado;
    private String nickUsr;
    private String mailUsr;
    private String nickRest;
    private ArrayList<DataCarrito> ColCarrito;
    
    public DataPedido(){}
    
    public DataPedido(long id, String nickUsr, String mailUsr, String fecha, String nickRest, ArrayList<DataCarrito> ColCarrito, double precio_total, Estados estado){
        this.id = id;
        this.nickUsr = nickUsr;
        this.mailUsr = mailUsr;
        this.fecha = fecha;
        this.nickRest = nickRest;
        if(ColCarrito == null){
            this.ColCarrito = null;
        }else{
            this.ColCarrito = new ArrayList<>();
            this.ColCarrito.addAll(ColCarrito);
        }
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

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
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
    
    public ArrayList<DataCarrito> getColCarrito(){
        return this.ColCarrito;
    }
    
    public void setColCarrito(ArrayList<DataCarrito> ColCarrito){//por si queda mas comodo...
        this.ColCarrito = ColCarrito;
    }
    
    public void setDatCarrito(DataCarrito dc){
        this.ColCarrito.add(dc);
    }
    
    public boolean existeProducto(String nombre){
        Iterator it = this.getColCarrito().iterator();
        while(it.hasNext()){
            DataCarrito dc = (DataCarrito)it.next();
            if(dc.getNomProd().equals(nombre)){
                return true;
            }
        }
        return false;
    }
    public boolean esRecibido(){
        if (this.estado==Estados.RECIBIDO)
            return true;
        else 
            return false;
    }
}
