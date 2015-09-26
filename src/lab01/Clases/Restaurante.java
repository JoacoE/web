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
    private float puntajeProm;
    private ArrayList<String> lstImagen;
    private Map ColCategoria;
    private Map ColProducto;

    public Restaurante(String nickname, String nombre, String email, String direccion, ArrayList<String> lstImagenes, Map colProd, Map categorias, String pwd) {
        super(nickname,nombre,email,direccion, pwd);
        if(categorias == null){
            this.ColCategoria = null;
        }else{
            this.ColCategoria = new HashMap();
            this.ColCategoria.putAll(categorias);
        }
        this.ColProducto = new HashMap();
        if(lstImagenes == null){
            this.lstImagen = null;
        }else{
            this.lstImagen = new ArrayList<>(); //Esto puede ser cualquera
            this.lstImagen.addAll(lstImagenes);
        }
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
        if(this.ColProducto == null){
            this.ColProducto = new HashMap();
            this.ColProducto.put(p.getNombre(), p);
        }else{
            ColProducto.put(p.getNombre(), p);
        }
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
        Map dataProductos = new HashMap();
        Map dataCategorias = new HashMap();
        Iterator prods = this.ColProducto.entrySet().iterator();
        while(prods.hasNext()){
            Map.Entry prod = (Map.Entry) prods.next();
            if(prod.getValue() instanceof Individual){
                Individual i = (Individual) prod.getValue();
                DataIndividual di = i.getDataIndividual();
                dataProductos.put(di.getDataNombre(), di);
            }
            if(prod.getValue() instanceof Promocional){
                Promocional p = (Promocional) prod.getValue();
                DataPromocional dp = p.getDataPromo();
                dataProductos.put(dp.getDataNombre(), dp);
            }
        }
        Iterator categs = this.ColCategoria.entrySet().iterator();
        while(categs.hasNext()){
            Map.Entry cat = (Map.Entry) categs.next();
            Categoria c = (Categoria) cat.getValue();
            DataCategoria dc = c.CatADC();
            dataCategorias.put(dc.getNombre(), dc);
        }
        DataRestaurante DR = new DataRestaurante(this.getNickname(), this.getNombre(), this.getMail(), this.getDireccion(), this.lstImagen, dataProductos, dataCategorias, this.contrasenia);
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
                DataIndividual di = i.getDataIndividual();
                ret.put(di.getDataNombre(),di.getCantidad());
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
    
    public void setPromedio(float prom){
        this.puntajeProm = prom;
    }
    
    public float getPromedio(){
        return this.puntajeProm;
    }
    
    public void setImagenes(ArrayList<String> lstimagen){
        if(this.lstImagen == null){    
            this.lstImagen = new ArrayList<>();
            this.lstImagen.addAll(lstimagen);
        }
        else{
            this.lstImagen = lstimagen;
        }
    }
    
    public ArrayList<String> getImagenes(){
        return this.lstImagen;
    }
}