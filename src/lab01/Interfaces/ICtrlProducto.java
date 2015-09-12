/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Interfaces;
import java.util.Map;

import lab01.Clases.DataProducto;
import lab01.Clases.DataIndividual;
import lab01.Clases.Producto;
import lab01.Clases.Restaurante;

/**
 *
 * @author gonzalo
 */
public interface ICtrlProducto {
    
    public abstract void registrarProducto(DataIndividual di, String nomRest, boolean promocional);
    public abstract boolean existeRestaurante(String nomRest);
    public abstract Map listarIndividuales(String nomRest);
    public abstract void setPromo(Map promo);
    public abstract void armarPromo(String rest, String nombre, String desc, double descuento);
    public abstract Producto getProdNombre(String Nprod, Restaurante res);
}
