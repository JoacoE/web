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
public abstract class  Producto {
    private String nombre;
    private String descripcion;
    //private double precio;
    private String imagen;
    private Producto_Stock prodStock;

    public Producto(String nombre, String descripcion, /*double precio,*/ int cantidad){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.prodStock = new Producto_Stock(cantidad/*,precio*/);
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
   
    public int getCantidad(){
        return prodStock.getCantidad();
    }
    
    public void setCantidad(int cant){
       this.prodStock.setCantidad(cant);
    }
     
    public double getPrecio(){
         return this.prodStock.getPrecio();
    }
    
    public void setPrecio(double precio){
        this.getProdStock().setPrecio(precio);
    }
     
    public Producto_Stock getProdStock(){
         return this.prodStock;
    }
    
    public void setProdStock(Producto_Stock prodStock){
        this.prodStock = prodStock;
    }
    
    public abstract boolean prodDisponible(int cantidad);
    
    public abstract void restarStock(int cantidad);

    public abstract void sumarStock(int cantidad);
    
    public abstract DataCarrito getDataCarrito(int cantidad);
    
}
