/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import lab01.server.DataCategoria;
import lab01.server.DataRestaurante;
import lab01.server.DataCliente;
import lab01.server.DataPedido;
import lab01.server.DataProducto;
import lab01.server.DtoEvaluacion;
import lab01.server.Estados;
import lab01.server.PublicadorPedido;
import lab01.server.PublicadorPedidoService;

/**
 *
 * @author joaco
 */
public class ProxyPedido {
    private Integer idCtrlPedido;
    private static ProxyPedido instance = null;
    private final PublicadorPedido PP;
    
    private ProxyPedido(){
        idCtrlPedido = null;
        PublicadorPedidoService servicio = new PublicadorPedidoService();
        PP = servicio.getPublicadorPedidoPort();
        idCtrlPedido = PP.getId();
    }
    
    public static ProxyPedido getInstance(){
        if(ProxyPedido.instance == null){
            ProxyPedido.instance = new ProxyPedido();
        }
        return ProxyPedido.instance;
    }
    
    public void setNickname(String nick){
        PP.setNickname(idCtrlPedido, nick);
    }
    
    public void setMailCliente(String mail){
        PP.setMailCliente(idCtrlPedido, mail);
        
    }
    
    public void setMemCliente(){
        PP.setMemCliente(idCtrlPedido);
    }

    public void setCat(String nombre){
        PP.setCat(idCtrlPedido, nombre);
    }
    
    public String getCat(){
       return PP.getCat(idCtrlPedido);
    }

    public String getNickname(){
        return PP.getNickname(idCtrlPedido);
    }
    
    public ArrayList<DataCliente> devListaDC(int index){
        ArrayList<DataCliente> lista = new ArrayList<>();
        lista.addAll(PP.devListaDC(idCtrlPedido).getItem());
        return lista;
    }
    
    public ArrayList<DataRestaurante> devListaDR(){
        ArrayList<DataRestaurante> ret = new ArrayList<>();
        ret.addAll(PP.devListaDR(idCtrlPedido).getItem());
        return ret;
    }
    
    public ArrayList<DataCategoria> retColDCat(){
        ArrayList<DataCategoria> ret = new ArrayList<>();
        ret.addAll(PP.retColDCat(idCtrlPedido).getItem());
        return ret;
    }
    
    public DataProducto devListaProductos(){
        return PP.devListaProductos(idCtrlPedido);
        
    }
    
    public boolean selectProductos(String nombre, int cantidad){
        return PP.selectProductos(idCtrlPedido, nombre,cantidad);
    }
    
    public void setMonto(){
        PP.setMonto(idCtrlPedido);
    }
    
    public DataPedido altaPedido(){
        return PP.altaPedido(idCtrlPedido);
    }
      
    public ArrayList<DataPedido> listDataPedidos(){
        ArrayList<DataPedido> lista = new ArrayList<>();
        lista.addAll(PP.listDataPedidos(idCtrlPedido).getItem());
        return lista;
    }

    public void actualizarEPedido(String nickname, long id, Estados estado){
        PP.actualizarEPedido(idCtrlPedido, nickname, id, estado);
    }
    
    public void setDp(DataPedido dp){
        PP.setDp(idCtrlPedido, dp);
    }
    
    public DataPedido getDp(){
        return PP.getDp(idCtrlPedido);
    }
    
    public void setMemoriaCliente(String nickname){
        PP.setMemoriaCliente(idCtrlPedido, nickname);
    }
    
    public void limpiarCtrl(){
        PP.limpiarCtrl(idCtrlPedido);
    }
    
    public void cancelarPedido(long id){
        PP.cancelarPedido(idCtrlPedido, id);
    }
    
    public ArrayList<DataPedido> listaPedidosRecibidos(String nickname){
        ArrayList<DataPedido> lista = new ArrayList<>();
        lista.addAll(PP.listaPedidosRecibidos(idCtrlPedido, nickname).getItem());
        return lista;
    }
    
    public void actualizarPromedioRest(String nickname){
        PP.actualizarPromedioRest(idCtrlPedido, nickname);
    }

    public void altaEvaluacion(double id, DtoEvaluacion data){
        PP.altaEvaluacion(idCtrlPedido, id, data);
    }

    public ArrayList<DtoEvaluacion> listarEvaluacionesRest(String nickname){
        ArrayList<DtoEvaluacion> lista = new ArrayList<>();
        lista.addAll(PP.listarEvaluacionesRest(idCtrlPedido, nickname).getItem());
        return lista;
    }

    public DtoEvaluacion getEvaluacionXid(long id){
        return PP.getEvaluacionXid(idCtrlPedido, id);
    }
    
    public ArrayList<DataPedido> listaPedidos(String nickname){
        ArrayList<DataPedido> lista = new ArrayList<>();
        lista.addAll(PP.listaPedidos(idCtrlPedido, nickname).getItem());
        return lista;
    }
    
    public void setMemRestaurante(String nickname){
     PP.setMemRestaurante(idCtrlPedido, nickname);
    }
    
    public void actualizarFechaPedido(String nickname, long id, String fecha){
        PP.actualizarFechaPedido(idCtrlPedido, nickname, id, fecha);
    }
}