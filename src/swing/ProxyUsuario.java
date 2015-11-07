/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.util.ArrayList;
import lab01.server.DataCategoria;
import lab01.server.DataCliente;
import lab01.server.DataIndividual;
import lab01.server.DataPedido;
import lab01.server.DataRestaurante;
import lab01.server.DtoDatosAdicionales;
import lab01.server.DtoIngresarDatos;
import lab01.server.DtoRegistrarCliente;
import lab01.server.PublicadorUsuario;
import lab01.server.PublicadorUsuarioService;
import lab01.server.StringArray;

/**
 *
 * @author joaco
 */
public class ProxyUsuario {
    
    private Integer idCtrlUsuario;
    private static ProxyUsuario instance = null;
    private final PublicadorUsuario CU;
    
    private ProxyUsuario(){
        idCtrlUsuario = null;
        PublicadorUsuarioService servicio = new PublicadorUsuarioService();
        CU = servicio.getPublicadorUsuarioPort();
        idCtrlUsuario = CU.getId();
    }
    
    public static ProxyUsuario getInstance(){
        if(ProxyUsuario.instance == null){
            ProxyUsuario.instance = new ProxyUsuario();
        }
        return ProxyUsuario.instance;
    }
    
    public void setNickname(String nickname){
        CU.setNickname(idCtrlUsuario, nickname);
    }
    
    public String getNickname(){
        return CU.getNickname(idCtrlUsuario);
    }
    
    public boolean ingresarDatos(DtoIngresarDatos datos){
        return CU.ingresarDatos(idCtrlUsuario, datos);
    }
    
    public void registrarCliente(DtoRegistrarCliente datos){
        CU.registrarCliente(idCtrlUsuario, datos);
    }
    
    public void registrarRestaurante(DataRestaurante dt){
        CU.registrarRestaurante(idCtrlUsuario, dt);
    }
    
    public void datosAdicionales(DtoDatosAdicionales datos){
        CU.datosAdicionales(idCtrlUsuario, datos);
    }
    
    public DataCliente getUsuarioByNickname(String nickname){
        return CU.getUsuarioByNickname(idCtrlUsuario, nickname);
    }
    
    public DataRestaurante getRestauranteByNickname(String nickname){
        return CU.getRestauranteByNickname(idCtrlUsuario, nickname);
    }
    
    public ArrayList<DataCliente> devListaDC(){
        ArrayList<DataCliente> ret = new ArrayList<>();
        ret.addAll(CU.devListaDC(idCtrlUsuario).getItem());
        return ret;
    }
    
    public ArrayList<DataRestaurante> listaDataRestaurantes(){
        ArrayList<DataRestaurante> ret = new ArrayList<>();
        ret.addAll(CU.listaDataRestaurantes(idCtrlUsuario).getItem());
        return ret;
    }
    
    public void registrarCat(String nombre){
        CU.registrarCat(idCtrlUsuario, nombre);
    }
    
    public ArrayList<DataCategoria> retColCat(){
        ArrayList<DataCategoria> ret = new ArrayList<>();
        ret.addAll(CU.retColCat(idCtrlUsuario).getItem());
        return ret;
    }
    
    public ArrayList<DataRestaurante> listaUsuPorCategoria(String cate){
        ArrayList<DataRestaurante> ret = new ArrayList<>();
        ret.addAll(CU.listaUsuPorCategoria(idCtrlUsuario, cate).getItem());
        return ret;
    }
    
    public void setCat(ArrayList<String> cate){
        StringArray param = new StringArray();
        for(String ci: cate){
            param.getItem().add(ci);
        }
        CU.setCat(idCtrlUsuario, param);
    }
    
    public ArrayList<DataCategoria> getLstCat(){
        ArrayList<DataCategoria> ret = new ArrayList<>();
        ret.addAll(CU.getLstCat(idCtrlUsuario).getItem());
        return ret;
    }
    
    public ArrayList<DataIndividual> listaProductosStock(String r){
        ArrayList<DataIndividual> ret = new ArrayList<>();
        ret.addAll(CU.listaProductosStock(idCtrlUsuario, r).getItem());
        return ret;
    }
    
    public ArrayList<DataPedido> listarPedidos(){
        ArrayList<DataPedido> ret = new ArrayList<>();
        ret.addAll(CU.listarPedidos(idCtrlUsuario).getItem());
        return ret;
    }
    
    public ArrayList<DataPedido> pedidosUsuario(String nickname){
        ArrayList<DataPedido> ret = new ArrayList<>();
        ret.addAll(CU.pedidosUsuario(idCtrlUsuario, nickname).getItem());
        return ret;
    }
    
    public boolean existeUsuario(String nickname, String mail){
        return CU.existeUsuario(idCtrlUsuario, nickname, mail);
    }
    
    public boolean existeNickname(String nickname){
        return CU.existeNickname(idCtrlUsuario, nickname);
    }
    
    public boolean existeMail(String mail){
        return CU.existeMail(idCtrlUsuario, mail);
    }
    
    public DataCliente getByMail(String mail){
        return CU.getByMail(idCtrlUsuario, mail);
    }
    
    public ArrayList<DataRestaurante> buscarRestaurantes(String nombre){
        ArrayList<DataRestaurante> ret = new ArrayList<>();
        ret.addAll(CU.buscarRestaurantes(idCtrlUsuario, nombre).getItem());
        return ret;
    }
    
}