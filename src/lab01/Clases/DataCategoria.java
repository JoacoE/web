/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

/**
 *
 * @author joaquin
 */
public class DataCategoria {
    private String nombre;
    
    public DataCategoria(String nombre){
    this.nombre = nombre;
    }
    
    public void setNombre(String nombre){
    this.nombre=nombre;
    }
    
    public String getNombre(){
    return this.nombre;
    }
    public Categoria DCatAC(){
        Categoria cat = new Categoria(this.nombre);
        return cat;
    }
}
