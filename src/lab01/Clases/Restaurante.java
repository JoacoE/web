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
        Iterator it = this.ColProducto.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry mprod = (Map.Entry) it.next();
            Producto prod = (Producto) mprod.getValue();
            if(prod.getNombre().equals(nombre)){
                return prod;
            }
        }
        throw new NullPointerException();
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
        DataRestaurante DR = new DataRestaurante(this.getNickname(), this.getNombre(), this.getMail(), this.getDireccion(), this.lstImagen, this.ColProducto, this.ColCategoria);
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
    public void ModificarProductoIndividual(DataIndividual ind, String nombreOld){
        Producto p = this.getProducto(nombreOld);
        p.setNombre(ind.getDataNombre());
       
    
}
}