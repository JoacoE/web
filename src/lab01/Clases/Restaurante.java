/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;


/**
 *
 * @author gera
 */
public class Restaurante extends Usuario{
    private ArrayList<String> lstImagen;
    private Map ColCategoria;
    private Map ColProducto;

    public Restaurante(String nickname, String nombre, String email, String direccion, ArrayList<String> lstImagenes, Map colProd, Map categorias) {
        super(nickname,nombre,email,direccion);
        ColCategoria = categorias;
        ColProducto = new HashMap();
        //this.lstImagen = new ArrayList<String>(); //Esto puede ser cualquera
    }
    
    public void addCategoria(Categoria c){
        ColCategoria.put(c.getNombre(), c);
    }
    public boolean member(String nombre){
        if(ColCategoria.isEmpty())
            return false;
        else
            return ColCategoria.containsKey(nombre);
    }
    
    public void addProducto(Producto p){
        ColProducto.put(p.getNombre(), p);
        
    }
    
    public Producto getProducto(String nombre){
        return (Producto)this.ColProducto.get(nombre);
    }
    
    public Map obtenerColeccion(){
        Map ret = new HashMap();
        Iterator it = ColCategoria.entrySet().iterator();
        //Iterator itret = ret.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            ret.put(map.getKey(), map.getKey());        
        }
        return ret;
    }
    public DataRestaurante RestauranteADR(){
        DataRestaurante DR = new DataRestaurante(this.nickname, this.nombre, this.mail, this.direccion, this.lstImagen, this.ColProducto, this.ColCategoria);
        return DR;
    }
    
    public Map obtenerColProductos(){
        Map ret = new HashMap();
        Iterator it = ColProducto.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            ret.put(map.getKey(), map.getKey());
        }
        return ret;
    }
    
    public Map obtenerListaProductos(){
        return this.ColProducto;
    }
    
    public Map obtenerListaIndividualesStock(){
    Map ret = new HashMap();
        Iterator it = ColProducto.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            if(map.getValue() instanceof Individual){
                Individual i = (Individual) map.getValue();
                int cant=i.getCantidad();
                ret.put(map.getKey(),cant);
            }
        }
        return ret;
    
    }
    
    public DataCarrito agregarProducto(String nombre, int cantidad){
        Producto prod = this.getProducto(nombre);
        String nomerror = prod.getNombre(); 
        if(prod.prodDisponible(cantidad)){
            DataCarrito dc = prod.getDataCarrito(cantidad);
            prod.restarStock(cantidad);
            return dc;
        }
        else
            JOptionPane.showMessageDialog(null, nomerror, "Sin Stock", JOptionPane.INFORMATION_MESSAGE);
            return null;
    }
    
    public Producto_Stock getProdCarrito(String nombre){
        Producto prod = this.getProducto(nombre);
        return prod.getProdStock();
    }
}