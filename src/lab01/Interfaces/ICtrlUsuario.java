/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab01.Interfaces;

import java.util.Date;
import lab01.Clases.Cliente;
import lab01.Clases.Restaurante;
import java.util.Map;
import java.util.HashMap;
import lab01.Clases.DataCliente;
import lab01.Clases.DataRestaurante;

/**
 *
 * @author admin123
 */
public interface ICtrlUsuario {
    public abstract void setNickname(String nick);
    public abstract String getNickname();
    public abstract boolean ingresarDatos(String nickname, String email, String nombre, String direccion);
    public abstract void registrarCliente(String apellido, String imagen, String fecha);
    public abstract void registrarRestaurante(DataRestaurante dt);
    public abstract void datosAdicionales(String apellido);
    public abstract DataCliente getUsuarioByNickname(String nickname);
    public abstract Restaurante getRestauranteByNickname(String nickname);
    public abstract Map devListaDC();
    public abstract Map listaDataRestaurantes();
    public abstract void registrarCat(String nombre);
    public abstract Map retColCat();
    public abstract Map listaUsuPorCategoria(String cate);
    public abstract void setCat(Map cate);
    public abstract Map getLstCat();
    public abstract Map listaProductosStock(String r);
    public abstract Map listarPedidos();
    public abstract Cliente getUsuNick(String nickname);
}