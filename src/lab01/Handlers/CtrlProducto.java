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
import lab01.Clases.Cliente;
import lab01.Clases.DataCliente;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataProducto;
import lab01.Clases.Cantidad_Individual;
//import lab01.Clases.DataProducto_Stock;
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

    public void registrarProducto(DataIndividual di, String nomRest, boolean promocional) {

        //primero obtengo el restaurante, si existe
        HUsuario HU = HUsuario.getinstance();
        Restaurante restoran = HU.obtenerRestaurante(nomRest);
        if (restoran == null) {
            JOptionPane.showMessageDialog(null, "El restaurante no esta registrado en el sistema", "Aviso", JOptionPane.INFORMATION_MESSAGE);

        } else {
            if (!promocional) { // si el producto es individual
                Producto i = new Individual(di.getDataNombre(), di.getDataDescripcion(), di.getDataPrecio(), di.getCantidad());
                restoran.addProducto(i); //agrego el producto a la coleccion de productos de ese restoran

            } else {

            }
        }

    }

    public boolean existeRestaurante(String nomRest) {
        HUsuario HU = HUsuario.getinstance();
        Restaurante restoran = HU.obtenerRestaurante(nomRest);
        if (restoran == null) {
            return false;

        } else {
            return true;
        }

    }

    public void setPromo(Map promo) {
        this.Promo = promo;
    }

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

    public void armarPromo(String rest, String nombre, String desc, double descuento) {
        Iterator it = this.Promo.entrySet().iterator();
        HUsuario HU = HUsuario.getinstance();
        Restaurante r = HU.obtenerRestaurante(rest);
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
        Promocional pro = new Promocional(nombre, desc, true, descuento, ColCantIndividual);
        pro.setPrecioPromo(descuento);
        r.addProducto(pro);
    }
    public Producto getProdNombre(String Nprod, Restaurante res){
        return res.getProducto(Nprod);
    
    }
}
