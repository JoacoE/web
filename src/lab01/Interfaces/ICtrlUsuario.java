/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab01.Interfaces;

import java.util.ArrayList;
import lab01.Clases.DTODatosAdicionales;
import lab01.Clases.DTOIngresarDatos;
import lab01.Clases.DTORegistrarCliente;
import lab01.Clases.DataCategoria;
import lab01.Clases.DataCliente;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataPedido;
import lab01.Clases.DataRestaurante;

/**
 *
 * @author admin123
 */
public interface ICtrlUsuario {
    public abstract void setNickname(String nick);
    public abstract String getNickname();
    public abstract boolean ingresarDatos(DTOIngresarDatos datos);
    public abstract void registrarCliente(DTORegistrarCliente datos);
    public abstract void registrarRestaurante(DataRestaurante dt);
    public abstract void datosAdicionales(DTODatosAdicionales datos);
    public abstract DataCliente getUsuarioByNickname(String nickname);
    public abstract DataRestaurante getRestauranteByNickname(String nickname);
    public abstract ArrayList<DataCliente> devListaDC();
    public abstract ArrayList<DataRestaurante> listaDataRestaurantes();
    public abstract void registrarCat(String nombre);
    public abstract ArrayList<DataCategoria> retColCat();
    public abstract ArrayList<DataRestaurante> listaUsuPorCategoria(String cate);
    public abstract void setCat(ArrayList<String> cate);
    public abstract ArrayList<DataCategoria> getLstCat();
    public abstract ArrayList<DataIndividual> listaProductosStock(String r);
    public abstract ArrayList<DataPedido> listarPedidos();
    public abstract ArrayList<DataPedido> pedidosUsuario(String nickname);
    public abstract boolean existeUsuario(String nickname, String email);
    public abstract boolean existeNickname(String nickname);
    public abstract boolean existeMail(String mail);
    public abstract DataCliente getByMail(String mail);
    public abstract ArrayList<DataRestaurante> buscarRestaurantes(String nombre);
    public abstract void setIdCtrl(int idCtrl);
    public abstract Integer getIdCtrl();
}