/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gera
 */
public class Promocional extends Producto {
    private boolean activa;
    private double descuento; //ver como se hace JoacoP(me imagino yo que seria un entero % y lo q se hace despues es a precio_total calcularsele ese descuento)
    private ArrayList<Cantidad_Individual> ColCantIndividual;
    
    public Promocional(String nombre, String descripcion, /*double precio,*/ boolean activa, double descuento, ArrayList<Cantidad_Individual> ColCantIndividual) {
        super(nombre, descripcion, /*precio,*/1);
        this.activa = activa;
        this.descuento = descuento;
        this.ColCantIndividual = ColCantIndividual;
        //this.setPrecioPromo(descuento); hay que llamar a esta operacion una vez creado el promocional...
    }//ver como se hace

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public ArrayList<Cantidad_Individual> getColCantIndividual(){
        return this.ColCantIndividual;
    }
    
    public void setCantIndividual(Cantidad_Individual cantInd){
        this.ColCantIndividual.add(cantInd);
    }
    
    public void setColCantIndividual(ArrayList<Cantidad_Individual> ColCantIndividual){
        this.ColCantIndividual = ColCantIndividual;
    }
    
    public void setPrecioPromo(double descuento){
        double aux = 0;
        double aux2;
        for(Cantidad_Individual ci: ColCantIndividual){
            if(ci.getCantidad() > 1){
                aux = aux + (ci.getProdIndividual().getPrecio() * ci.getCantidad());
            }
            else{
                aux = aux + ci.getProdIndividual().getPrecio();
            }
        }
        aux2 = (aux * descuento) / 100;
        aux = aux - aux2;
        this.setPrecio(aux);
    }
    
    public DataPromocional getDataPromo(){
        Map ColDatIndividual = new HashMap();
        for(Cantidad_Individual ci: ColCantIndividual){
            DataIndividual di = ci.getProdIndividual().getDataIndividual();
            di.setCantidad(ci.getCantidad());
            ColDatIndividual.put(di.getDataNombre(), di);
        }
        DataPromocional dPromo = new DataPromocional(this.isActiva(), this.getDescuento(), this.getDescripcion(), this.getNombre(), this.getPrecio(), this.getImagen(), ColDatIndividual);
        return dPromo;
    }
    
    @Override
    public DataCarrito getDataCarrito(int cantidad){
        DataCarrito dc = new DataCarrito(this.getNombre(), true, cantidad, this.getPrecio());
        return dc;
    }
    
    @Override
    public boolean prodDisponible(int cantidad){
        for(Cantidad_Individual ci: ColCantIndividual){
            int aux = ci.getCantidad() * cantidad;
            if(ci.getProdIndividual().prodDisponible(aux)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void restarStock(int cantidad){
        for(Cantidad_Individual ci: ColCantIndividual){
            int aux = ci.getCantidad() * cantidad;
            int aux2 = ci.getProdIndividual().getProdStock().getCantidad() - aux;
            ci.getProdIndividual().getProdStock().setCantidad(aux2);
        }
    }
    
    @Override
    public void sumarStock(int cantidad){
        for(Cantidad_Individual ci: ColCantIndividual){
            int aux = ci.getCantidad() * cantidad;
            int aux2 = ci.getProdIndividual().getProdStock().getCantidad() + aux;
            ci.getProdIndividual().getProdStock().setCantidad(aux2);
        }
    }
}
