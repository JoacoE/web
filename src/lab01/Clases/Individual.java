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
public class Individual extends Producto {

    public Individual(String nombre, String descripcion, double precio, int cantidad) {
        super(nombre,descripcion,cantidad);
        this.setPrecio(precio);
    }

    public DataIndividual getDataIndividual() {
        DataIndividual dIndividual = new DataIndividual(this.getNombre(), this.getDescripcion(), this.getPrecio(), this.getImagen(), this.getCantidad());
        return dIndividual;
    }
    
    @Override
    public DataCarrito getDataCarrito(int cantidad){
        DataCarrito dc = new DataCarrito(this.getNombre(), false, cantidad, this.getPrecio());
        return dc;
    }
    
    @Override
    public boolean prodDisponible(int cantidad){
        return this.getProdStock().getCantidad() >= cantidad;
    }
    
    @Override
    public void restarStock(int cantidad){
        int aux = this.getProdStock().getCantidad() - cantidad;
        this.getProdStock().setCantidad(aux);
    }
    
    @Override
    public void sumarStock(int cantidad){
        int aux = this.getProdStock().getCantidad() + cantidad;
        this.getProdStock().setCantidad(aux);
    }
}
