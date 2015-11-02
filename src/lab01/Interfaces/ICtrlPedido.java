/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Interfaces;

import java.util.ArrayList;
import lab01.Clases.DTOEvaluacion;
import lab01.Clases.DataCategoria;
import lab01.Clases.DataCliente;
import lab01.Clases.DataPedido;
import lab01.Clases.DataProducto;
import lab01.Clases.DataRestaurante;
import lab01.Clases.Estados;

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
    public abstract ArrayList<DataCliente> devListaDC();
    public abstract ArrayList<DataRestaurante> devListaDR();
    public abstract boolean setMemRestaurante(String nickname);
    public abstract ArrayList<DataCategoria> retColDCat();
    public abstract DataProducto devListaProductos();
    public abstract boolean selectProductos(String nombre, int cantidad);
    public abstract void setMonto();
    public abstract DataPedido altaPedido();
    public abstract ArrayList<DataPedido> listDataPedidos();
    public abstract void actualizarEPedido(String nickname, long id, Estados estado);
    public abstract void setDp(DataPedido dp);
    public abstract DataPedido getDp();
    public abstract void setMemoriaCliente(String nickname);
    public abstract void limpiarCtrl();
    public abstract void cancelarPedido(long id);
    public abstract ArrayList<DataPedido> listaPedidosRecibidos(String nickname);
    public abstract void actualizarPromedioRest(String nickname);
    public abstract void altaEvaluacion(double id, DTOEvaluacion data);
    public abstract ArrayList<DTOEvaluacion> listarEvaluacionesRest(String nickname);
    public abstract DTOEvaluacion getEvaluacionXid(long id);
    public abstract ArrayList<DataPedido> listaPedidos(String nickname);
    public abstract void setIdCtrl(Integer idCtrl);
    public abstract Integer getIdCtrl();
}