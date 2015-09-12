/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

/**
 *
 * @author martin
 */
public class DataIndividual {
    
    private String DataNombre;
    private String DataDescripcion;
    private double DataPrecio;
    private String DataImagen;
    private int cantidad;

    public DataIndividual() {
    }
    
    public DataIndividual(String nombre, String descripcion, double precio, int cantidad){
         this.DataNombre = nombre;
        this.DataDescripcion = descripcion;
        this.DataPrecio = precio;
       
        this.cantidad = cantidad;
    }
    public DataIndividual(String nombre, String descripcion, double precio, String imagen, int cantidad) {
        this.DataNombre = nombre;
        this.DataDescripcion = descripcion;
        this.DataPrecio = precio;
        this.DataImagen = imagen;
        this.cantidad = cantidad;
    }

    public String getDataNombre() {
        return DataNombre;
    }

    public void setDataNombre(String nombre) {
        this.DataNombre = nombre;
    }

    public String getDataDescripcion() {
        return DataDescripcion;
    }

    public void setDataDescripcion(String descripcion) {
        this.DataDescripcion = descripcion;
    }

    public double getDataPrecio() {
        return DataPrecio;
    }

    public void setDataPrecio(double precio) {
        this.DataPrecio = precio;
    }

    public String getDataImagen() {
        return DataImagen;
    }

    public void setDataImagen(String imagen) {
        this.DataImagen = imagen;
    }  
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
        
    }
}