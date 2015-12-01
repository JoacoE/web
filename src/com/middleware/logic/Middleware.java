/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.middleware.logic;

import com.middleware.proxy.ProxyUsuario;
import com.middleware.proxy.ProxyProducto;
import com.middleware.proxy.ProxyPedido;
import java.util.ArrayList;
import lab01.server.*;

/**
 *
 * @author joaco
 */
public class Middleware {
    private ProxyUsuario PUsr;
    private ProxyProducto PProd;
    private ProxyPedido PPed;
    
    public Middleware(){}
    
    public boolean connection(){
        try{
            PUsr = ProxyUsuario.getInstance();
            PProd = ProxyProducto.getInstance();
            PPed = ProxyPedido.getInstance();
            existeMail("");
        }catch(Exception ex){
            return false;
        }
        return true;
    }
    
    //////////////////////INICIO METODOS CTRLUSUARIO////////////////////////////
    
    public void setNickname(String nickname)throws Exception{
        PUsr.setNickname(nickname);
    }
    
    public String getNickname()throws Exception{
        return PUsr.getNickname();
    }
    
    public boolean ingresarDatos(DtoIngresarDatos datos)throws Exception{
        return PUsr.ingresarDatos(datos);
    }
    
    public void registrarCliente(DtoRegistrarCliente datos)throws Exception{
        PUsr.registrarCliente(datos);
    }
    
    public void registrarRestaurante(DataRestaurante dt)throws Exception{
        PUsr.registrarRestaurante(dt);
    }
    
    public void datosAdicionales(DtoDatosAdicionales datos)throws Exception{
        PUsr.datosAdicionales(datos);
    }
    
    public DataCliente getUsuarioByNickname(String nickname)throws Exception{
        return PUsr.getUsuarioByNickname(nickname);
    }
    
    public DataRestaurante getRestauranteByNickname(String nickname)throws Exception{
        return PUsr.getRestauranteByNickname(nickname);
    }
    
    public ArrayList<DataCliente> devListaDC()throws Exception{
        return PUsr.devListaDC();
    }
    
    public ArrayList<DataRestaurante> listaDataRestaurantes()throws Exception{
        return PUsr.listaDataRestaurantes();
    }
    
    public void registrarCat(String nombre)throws Exception{
        PUsr.registrarCat(nombre);
    }
    
    public ArrayList<DataCategoria> retColCat()throws Exception{
        return PUsr.retColCat();
    }
    
    public ArrayList<DataRestaurante> listaUsuPorCategoria(String cate)throws Exception{
        return PUsr.listaUsuPorCategoria(cate);
    }
    
    public void setCat(ArrayList<String> cate)throws Exception{
        PUsr.setCat(cate);
    }
    
    public ArrayList<DataCategoria> getLstCat()throws Exception{
        return PUsr.getLstCat();
    }
    
    public ArrayList<DataIndividual> listaProductosStock(String r)throws Exception{
        return PUsr.listaProductosStock(r);
    }
    
    public ArrayList<DataPedido> listarPedidos()throws Exception{
        return PUsr.listarPedidos();
    }
    
    public ArrayList<DataPedido> pedidosUsuario(String nickname)throws Exception{
        return PUsr.pedidosUsuario(nickname);
    }
    
    public boolean existeUsuario(String nickname, String mail)throws Exception{
        return PUsr.existeUsuario(nickname, mail);
    }
    
    public boolean existeNickname(String nickname)throws Exception{
        return PUsr.existeNickname(nickname);
    }
    
    public boolean existeMail(String mail)throws Exception{
        return PUsr.existeMail(mail);
    }
    
    public DataCliente getByMail(String mail)throws Exception{
        return PUsr.getByMail(mail);
    }
    
    public ArrayList<DataRestaurante> buscarRestaurantes(String nombre)throws Exception{
        return PUsr.buscarRestaurantes(nombre);
    }
    
    /////////////////////FIN METODOS CTRLUSUARIO////////////////////////////////
    
    ///////////////////INICIO METODOS CTRLPRODUCTO//////////////////////////////
    
    public void registrarProducto(DtoRegistrarProducto datos)throws Exception{
        PProd.registrarProducto(datos);
    }
    
    public boolean existeRestaurante(String nomRest)throws Exception{
        return PProd.existeRestaurante(nomRest);
    }

    public ArrayList<DataIndividual> listarIndividuales(String nomRest)throws Exception{
        return PProd.listarIndividuales(nomRest);
    }
    
    public void setPromo(ArrayList<DataIndividual> promo)throws Exception{
        PProd.setPromo(promo);
    }

    public void armarPromo(DtoArmarPromo datos)throws Exception{
        PProd.armarPromo(datos);
    }

    public void actualizarIndividual(DtoActualizarIndividual datos)throws Exception{
        PProd.actualizarIndividual(datos);
    }

    public void actualizarPromocional(DtoActualizarPromocional datos)throws Exception{
        PProd.actualizarPromocional(datos);
    }

    public DataIndividual getProdIndividualXNombre(String nombre)throws Exception{
        return PProd.getProdIndividualXNombre(nombre);
    }

    public DataPromocional getProdPromocionalXNombre(String nombre)throws Exception{
        return PProd.getProdPromocionalXNombre(nombre);
    }
    
    /////////////////////FIN METODOS CTRLPRODUCTO///////////////////////////////
    
    /////////////////////INICIO METODOS CTRLPEDIDO//////////////////////////////
    
    public void setNicknameCtrlPedido(String nick)throws Exception{
        PPed.setNickname(nick);
    }
    
    public void setMailCliente(String mail)throws Exception{
        PPed.setMailCliente(mail);
        
    }
    
    public void setMemCliente()throws Exception{
        PPed.setMemCliente();
    }

    public void setCat(String nombre)throws Exception{
        PPed.setCat(nombre);
    }
    
    public String getCat()throws Exception{
       return PPed.getCat();
    }

    public String getNicknameCtrlPedido()throws Exception{
        return PPed.getNickname();
    }
    
    public ArrayList<DataCliente> devListaDC(int index)throws Exception{
        return PPed.devListaDC(index);
    }
    
    public ArrayList<DataRestaurante> devListaDR()throws Exception{
        return PPed.devListaDR();
    }
    
    public ArrayList<DataCategoria> retColDCat()throws Exception{
        return PPed.retColDCat();
    }
    
    public DataProducto devListaProductos()throws Exception{
        return PPed.devListaProductos();
        
    }
    
    public boolean selectProductos(String nombre, int cantidad)throws Exception{
        return PPed.selectProductos(nombre, cantidad);
    }
    
    public void setMonto()throws Exception{
        PPed.setMonto();
    }
    
    public DataPedido altaPedido()throws Exception{
        return PPed.altaPedido();
    }
      
    public ArrayList<DataPedido> listDataPedidos()throws Exception{
        return PPed.listDataPedidos();
    }

    public void actualizarEPedido(String nickname, long id, String estado)throws Exception{
        if(estado.equals(Estados.ENVIADO.toString()))
            PPed.actualizarEPedido(nickname, id, Estados.ENVIADO);
        if(estado.equals(Estados.PREPARACION.toString()))
            PPed.actualizarEPedido(nickname, id, Estados.PREPARACION);
        if(estado.equals(Estados.RECIBIDO.toString()))
            PPed.actualizarEPedido(nickname, id, Estados.RECIBIDO);            
    }
    
    public void actualizarEPedidoCDatos(String nickname, long id, Estados estado, String fecha)throws Exception{
        PPed.actualizarEPedidoCDatos(nickname, id, estado, fecha);
    }
    
    public void setDp(DataPedido dp)throws Exception{
        PPed.setDp(dp);
    }
    
    public DataPedido getDp()throws Exception{
        return PPed.getDp();
    }
    
    public void setMemoriaCliente(String nickname)throws Exception{
        PPed.setMemoriaCliente(nickname);
    }
    
    public void limpiarCtrl()throws Exception{
        PPed.limpiarCtrl();
    }
    
    public void cancelarPedido(long id)throws Exception{
        PPed.cancelarPedido(id);
    }
    
    public ArrayList<DataPedido> listaPedidosRecibidos(String nickname)throws Exception{
        return PPed.listaPedidosRecibidos(nickname);
    }
    
    public void actualizarPromedioRest(String nickname)throws Exception{
        PPed.actualizarPromedioRest(nickname);
    }

    public void altaEvaluacion(double id, DtoEvaluacion data)throws Exception{
        PPed.altaEvaluacion(id, data);
    }

    public ArrayList<DtoEvaluacion> listarEvaluacionesRest(String nickname)throws Exception{
        return PPed.listarEvaluacionesRest(nickname);
    }

    public DtoEvaluacion getEvaluacionXid(long id)throws Exception{
        return PPed.getEvaluacionXid(id);
    }
    
    public ArrayList<DataPedido> listaPedidos(String nickname)throws Exception{
        return PPed.listaPedidos(nickname);
    }
    
    public void setMemRestaurante(String nickname)throws Exception{
     PPed.setMemRestaurante(nickname);
    }
    
    public void actualizarFechaPedido(String nickname, long id, String fecha)throws Exception{
        PPed.actualizarFechaPedido(nickname, id, fecha);
    }
    
    ////////////////////////FIN METODOS CTRLPEDIDO//////////////////////////////
}
