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
public class Cantidad_Individual {
    private int cantidad;
    private Individual prodIndividual;
    
    public Cantidad_Individual(Individual i, int cant){
        this.cantidad=cant;
        this.prodIndividual=i;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public Individual getProdIndividual(){
        return this.prodIndividual;
    }
    
    public void setProdIndividual(Individual prodIndividual){
        this.prodIndividual = prodIndividual;
    } 
}
