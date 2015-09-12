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
public class DataCarrito {
    private String nomProd;
    private boolean promo;
    private int cantidad;
    private double precio;
    
    DataCarrito(String nomProd, boolean promo, int cantidad, double precio){
        this.nomProd = nomProd;
        this.promo = promo;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public String getNomProd(){
        return this.nomProd;
    }
    
    public void setNomProd(String nomProd){
        this.nomProd = nomProd;
    }
    
    public boolean getPromo(){
        return this.promo;
    }
    
    public void setPromo(boolean promo){
        this.promo = promo;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public double getPrecio(){
        return this.precio;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
}
