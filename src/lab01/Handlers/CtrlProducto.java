/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import lab01.Clases.DataIndividual;
import lab01.Clases.Cantidad_Individual;
import lab01.Clases.DTOActualizarIndividual;
import lab01.Clases.DTOActualizarPromocional;
import lab01.Clases.DTOArmarPromo;
import lab01.Clases.DTORegistrarProducto;
import lab01.Clases.Individual;
import lab01.Clases.Promocional;
import lab01.Clases.Producto;
import lab01.Clases.Restaurante;
import lab01.Interfaces.ICtrlProducto;

/**
 *
 * @author gera
 */
public class CtrlProducto implements ICtrlProducto {

    private Map Promo;

    @Override
    public void registrarProducto(DTORegistrarProducto datos) {
        //primero obtengo el restaurante, si existe
        HUsuario HU = HUsuario.getinstance();
        Restaurante restoran = HU.obtenerRestaurante(datos.getNickRest());
        if (restoran == null) {
            JOptionPane.showMessageDialog(null, "El restaurante no esta registrado en el sistema", "Aviso", JOptionPane.INFORMATION_MESSAGE);

        } else {
            if (!datos.isPromo()) { // si el producto es individual
                Producto i = new Individual(datos.getDi().getDataNombre(), datos.getDi().getDataDescripcion(), datos.getDi().getDataPrecio(), datos.getDi().getCantidad());
                if(!datos.getDi().getDataImagen().equals("")){
                    i.setImagen(datos.getDi().getDataImagen());
                }else{
                    i.setImagen("");
                }
                restoran.addProducto(i); //agrego el producto a la coleccion de productos de ese restoran
            }
        }
    }

    @Override
    public boolean existeRestaurante(String nomRest) {
        HUsuario HU = HUsuario.getinstance();
        Restaurante restoran = HU.obtenerRestaurante(nomRest);
        if (restoran == null) {
            return false;

        } else {
            return true;
        }

    }

    @Override
    public void setPromo(Map promo) {
        this.Promo = promo;
    }

    @Override
    public Map listarIndividuales(String nomRest) {

        Map ret = new HashMap();
        HUsuario HU = HUsuario.getinstance();
        Restaurante restoran = HU.obtenerRestaurante(nomRest);
        Iterator it = restoran.obtenerListaProductos().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry map = (Map.Entry) it.next();
            if ((Producto) map.getValue() instanceof Individual) {
                Individual ind = (Individual) map.getValue();
                DataIndividual di = ind.getDataIndividual();
                ret.put(di.getDataNombre(), di);
            }

        }
        return ret;
    }

    @Override
    public void armarPromo(DTOArmarPromo datos) {
        Iterator it = this.Promo.entrySet().iterator();
        HUsuario HU = HUsuario.getinstance();
        Restaurante r = HU.obtenerRestaurante(datos.getNickRest());
        ArrayList<Cantidad_Individual> ColCantIndividual = new ArrayList<Cantidad_Individual>();
        //Promocional pro = 
        while (it.hasNext()) {
            Map.Entry map = (Map.Entry) it.next();
            Individual i = (Individual) r.getProducto(map.getKey().toString());
            String cant = (String) map.getValue().toString();
            int cantidad = Integer.parseInt(cant);
            Cantidad_Individual CI = new Cantidad_Individual(i, cantidad);
            ColCantIndividual.add(CI);
        }
        String prueba = String.valueOf(datos.getDescuento());
        if(prueba.isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar el descuento", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            throw new NullPointerException();
        }else{
            Promocional pro = new Promocional(datos.getNombre(), datos.getDescripcion(), true, datos.getDescuento(), ColCantIndividual);
            pro.setPrecioPromo(datos.getDescuento());
            if(!datos.getImagen().equals("")){
                pro.setImagen(datos.getImagen());
            }else{
                pro.setImagen("");
            }
            r.addProducto(pro);
        }
    }
    
    public Producto getProdNombre(String Nprod, String nickRes){
        HUsuario hu = HUsuario.getinstance();
        Restaurante res = hu.obtenerRestaurante(nickRes);
        return res.getProducto(Nprod);
    }
    
    @Override
    public void actualizarIndividual(DTOActualizarIndividual datos){
        Individual individual = (Individual) this.getProdNombre(datos.getNombre(), datos.getNickRest());
        individual.setNombre(datos.getDi().getDataNombre());
        individual.setDescripcion(datos.getDi().getDataDescripcion());
        individual.setCantidad(datos.getDi().getCantidad());
        individual.setPrecio(datos.getDi().getDataPrecio());
        individual.setImagen(datos.getImagen());
    }
    
    @Override
    public void actualizarPromocional(DTOActualizarPromocional datos){
        Promocional promo = (Promocional) this.getProdNombre(datos.getNombre(), datos.getNickRest());
        promo.setNombre(datos.getDp().getDataNombre());
        promo.setDescripcion(datos.getDp().getDataDescripcion());
        promo.setActiva(datos.getDp().getActiva());
        promo.setDescuento(datos.getDp().getDescuento());
        promo.setPrecioPromo(promo.getDescuento());
        promo.setImagen(datos.getImagen());
    }
}
