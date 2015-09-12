/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

/**
 *
 * @author gera
 */
public class Producto_Stock {
    private int cantidad;
    private double precio;
    private Producto prod;

    public Producto getProd() {
        return prod;
    }

    public Producto_Stock(int cantidad/*, double precio*/) {
        this.cantidad = cantidad;
        //this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getPrecio(){
        return this.precio;
    } 
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public void setProducto(Producto p){
        this.prod=p;
    }
}
