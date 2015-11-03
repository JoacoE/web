/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import java.util.ArrayList;

/**
 *
 * @author joaco
 */
public class DataPromocional {

    
    private boolean DataActiva;
    private double DataDescuento;
    private String DataNombre;
    private String DataDescripcion;
    private double DataPrecio;
    private String DataImagen;
    private ArrayList<DataIndividual> ColDatIndividual;
    
    public DataPromocional(){}
    
    public DataPromocional(boolean activa, double descuento, String nombre, String descripcion, double precio, String imagen, ArrayList<DataIndividual> ColDatIndividual){
        this.DataActiva = activa;
        this.DataDescuento = descuento;
        this.DataNombre = nombre;
        this.DataDescripcion = descripcion;
        this.DataPrecio = precio;
        this.DataImagen = imagen;
        if(ColDatIndividual == null){
            this.ColDatIndividual = null;
        }else{
            this.ColDatIndividual.addAll(ColDatIndividual);
        }
    }
    
    public boolean isDataActiva() {
        return DataActiva;
    }

    public void setDataActiva(boolean DataActiva) {
        this.DataActiva = DataActiva;
    }

    public double getDataDescuento() {
        return DataDescuento;
    }

    public void setDataDescuento(double DataDescuento) {
        this.DataDescuento = DataDescuento;
    }
    public void setActiva(boolean activa){
        this.DataActiva = activa;
    }
    
    public boolean getActiva(){
        return DataActiva;
    }

    public String getDataNombre() {
        return DataNombre;
    }

    public void setDataNombre(String DataNombre) {
        this.DataNombre = DataNombre;
    }

    public String getDataDescripcion() {
        return DataDescripcion;
    }

    public void setDataDescripcion(String DataDescripcion) {
        this.DataDescripcion = DataDescripcion;
    }

    public double getDataPrecio() {
        return DataPrecio;
    }

    public void setDataPrecio(double DataPrecio) {
        this.DataPrecio = DataPrecio;
    }

    public String getDataImagen() {
        return DataImagen;
    }

    public void setDataImagen(String DataImagen) {
        this.DataImagen = DataImagen;
    }
    
    public void setDescuento(double descuento){
        this.DataDescuento = descuento;
    }
    
    public double getDescuento(){
        return DataDescuento;
    }
    
    public ArrayList<DataIndividual> getColDatIndividual(){
        return this.ColDatIndividual;
    }
    
    public void setDatIndividual(DataIndividual di){
        this.ColDatIndividual.add(di);
    }
    
    public void setColDataIndividual(ArrayList<DataIndividual> ColDatIndividual){
        this.ColDatIndividual = ColDatIndividual;
    }
}
