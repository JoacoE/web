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
    private ArrayList<Categoria> ColCategoria;
    private ArrayList<Individual> ColProductoInd;
    private ArrayList<Promocional> ColProductoProm;

    public Restaurante(String nickname, String nombre, String email, String direccion, ArrayList<String> lstImagenes, ArrayList<Categoria> categorias, String pwd){
        super(nickname,nombre,email,direccion, pwd);
        if(categorias == null){
            this.ColCategoria = null;
        }else{
            this.ColCategoria = new ArrayList<>();
            this.ColCategoria.addAll(categorias);
        }
        this.ColProductoInd = new ArrayList<>();
        this.ColProductoProm = new ArrayList<>();

        if(lstImagenes == null){
            this.lstImagen = null;
        }else{
            this.lstImagen = new ArrayList<>(); //Esto puede ser cualquera
            this.lstImagen.addAll(lstImagenes);
        }
    }
    
    public void addCategoria(Categoria c){
        ColCategoria.add(c);
    }
    
    public boolean member(String nombre){
//        boolean aux = false;
        if(ColCategoria.isEmpty())
            return false;
        else{
            for(Categoria itCat: ColCategoria){
               if(itCat.getNombre().equals(nombre)){
                   return true;
               }
            }
            return false;
        }
    }
    
    public void addProducto(Producto p){
        if(p instanceof Individual){            
            if(this.ColProductoInd== null){
                this.ColProductoInd = new ArrayList<>();
                this.ColProductoInd.add((Individual)p);
            }else{
                this.ColProductoInd.add((Individual)p);
            }
        }else{
            if(this.ColProductoProm == null){
                this.ColProductoProm = new ArrayList<>();
                this.ColProductoProm.add((Promocional)p);
            }else{
                this.ColProductoProm.add((Promocional)p);
            }
        }
    }
    
    public Producto getProducto(String nombre){
        if(!(ColProductoInd.isEmpty())){
            for(Individual itInd: ColProductoInd){
               if(itInd.getNombre().equals(nombre)){
                   return (Producto)itInd;
               }
            }
        }
        if(!(ColProductoProm.isEmpty())){
            for(Promocional itProm: ColProductoProm){
               if(itProm.getNombre().equals(nombre)){
                   return (Producto)itProm;
               }
            }
        }
        throw new NullPointerException();        
    }
    
    public ArrayList<Categoria> obtenerColeccion(){
        if(!(ColCategoria.isEmpty())){
            return this.ColCategoria;
        }
        throw new NullPointerException();        
    }
    
    public DataRestaurante RestauranteADR(){
        ArrayList<DataPromocional> dataPromocionales = new ArrayList<>();
        ArrayList<DataIndividual> dataIndividuales = new ArrayList<>();
        ArrayList<DataCategoria> dataCategorias = new ArrayList<>();
        for (Individual i: ColProductoInd){
                DataIndividual di = i.getDataIndividual();
                dataIndividuales.add(di);
            }
        for (Promocional p: ColProductoProm){
                DataPromocional dp = p.getDataPromo();
                dataPromocionales.add(dp);
            }
        for (Categoria c: ColCategoria){
            DataCategoria dc = c.CatADC();
            dataCategorias.add(dc);
        }
        DataRestaurante DR = new DataRestaurante(this.getNickname(), this.getNombre(), this.getMail(), this.getDireccion(), this.lstImagen, dataPromocionales , dataIndividuales, dataCategorias, this.contrasenia, this.getPromedio());
        return DR;
    }
    
    public ArrayList<Producto> obtenerColProductos(){
        ArrayList<Producto> ret = new ArrayList<>();
        for (Individual ind: ColProductoInd){
            Producto p = (Producto)ind;
            ret.add(p);
        }for (Promocional prom: ColProductoProm){
            Producto p = (Producto)prom;
            ret.add(p);
        }
        return ret;
    }
    
    public ArrayList<Producto> obtenerListaProductos(){
        ArrayList<Producto> ret = new ArrayList<>();
        for (Individual ind: ColProductoInd){
            Producto p = (Producto)ind;
            ret.add(p);
        }for (Promocional prom: ColProductoProm){
            Producto p = (Producto)prom;
            ret.add(p);
        }
        return ret;
    }    
    
    public ArrayList<DataIndividual> obtenerListaIndividualesStock(){
        ArrayList<DataIndividual> ret = new ArrayList<>();
        for (Individual i: ColProductoInd){
            if(i.getCantidad()>=1){
            DataIndividual di = i.getDataIndividual();
            ret.add(di);
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
    public boolean tengoCategoria(String nombre){
        for (Categoria cat : ColCategoria) {
            String nomCat = cat.getNombre().toUpperCase();
            String nom = nombre.toUpperCase();
            if(nomCat.contains(nom))
                return true;
        }
    return false;
    }
    
    public boolean tengoProducto(String nombre){
        for (Promocional p : ColProductoProm) {
            String nomProd = p.getNombre().toUpperCase();
            String nom = nombre.toUpperCase();
            if(nomProd.contains(nom))
                return true;
        }
        for (Individual i : ColProductoInd) {
            String nomProd = i.getNombre().toUpperCase();
            String nom = nombre.toUpperCase();
            if(nomProd.contains(nom))
                return true;
        }
    return false;
    }

    public float getPuntajeProm() {
        return puntajeProm;
    }

    public void setPuntajeProm(float puntajeProm) {
        this.puntajeProm = puntajeProm;
    }

    public ArrayList<String> getLstImagen() {
        return lstImagen;
    }

    public void setLstImagen(ArrayList<String> lstImagen) {
        this.lstImagen = lstImagen;
    }

    public ArrayList<Categoria> getColCategoria() {
        return ColCategoria;
    }

    public void setColCategoria(ArrayList<Categoria> ColCategoria) {
        this.ColCategoria = ColCategoria;
    }

    public ArrayList<Individual> getColProductoInd() {
        return ColProductoInd;
    }
    
    
    public ArrayList<Promocional> getColProductoProm() {
        return ColProductoProm;
    }

    public void setColProductoInd(ArrayList<Individual> ColProductoInd) {
        this.ColProductoInd = ColProductoInd;
    }
    
    public void setColProductoProm(ArrayList<Promocional> ColProductoProm) {
        this.ColProductoProm = ColProductoProm;
    }
    
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
