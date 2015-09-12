/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Interfaces;

import java.util.Map;
import lab01.Clases.Cliente;
import lab01.Clases.DataPedido;
import lab01.Clases.DataProducto;
import lab01.Clases.estados;

/**
 *
 * @author joaquin
 */
public interface ICtrlPedido {
    
    public abstract void setNickname(String nick);
    public abstract void setMailCliente(String mail);
    public abstract void setMemCliente();
    public abstract void setCat(String nombre);
    public abstract String getCat();
    public abstract String getNickname();
    public abstract Map devListaDC();
    public abstract Map devListaDR();
    public abstract boolean setMemRestaurante(String nickname);
    public abstract Map retColDCat();
    public abstract DataProducto devListaProductos();
    public abstract boolean selectProductos(String nombre, int cantidad);
    public abstract void setMonto();
    public abstract DataPedido altaPedido();
    public abstract Map listDataPedidos();
    public abstract void actualizarEPedido(String nickname, long id, estados estado);
    public abstract void setDp(DataPedido dp);
    public abstract DataPedido getDp();
    public abstract void setMemoriaCliente(Cliente c);
    public abstract void limpiarCtrl();
    public abstract void cancelarPedido(long id);
}
