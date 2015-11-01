/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.server;

import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import lab01.Clases.DTODatosAdicionales;
import lab01.Clases.DTOIngresarDatos;
import lab01.Clases.DTORegistrarCliente;
import lab01.Clases.DataCliente;
import lab01.Clases.DataRestaurante;
import lab01.Handlers.Fabrica;

/**
 *
 * @author joaco
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorUsuario {
    
    private Endpoint endpoint = null;
    
    public PublicadorUsuario(){}
    
    @WebMethod(exclude = true)
    public void publicUsr(){
         endpoint = Endpoint.publish("http://localhost:9001/pubusr", this);
    }
    
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public Integer getId(){
        Integer idCtrlUsuario = Fabrica.getInstance().getICtrlUsuario(null).getIdCtrl();
        return idCtrlUsuario;
    }
    
    @WebMethod
    public void setNickname(Integer idCtrlUsuario, String nick){
        Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).setNickname(nick);
    }
    
    @WebMethod
    public String getNickname(Integer idCtrlUsuario){
        String ret = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).getNickname();
        return ret;
    }
    
    @WebMethod
    public boolean ingresarDatos(Integer idCtrlUsuario, DTOIngresarDatos datos){
        return Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).ingresarDatos(datos);
    }
    
    @WebMethod
    public void registrarCliente(Integer idCtrlUsuario, DTORegistrarCliente datos){
        Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).registrarCliente(datos);
    }
    
    @WebMethod
    public void registrarRestaurante(Integer idCtrlUsuario, DataRestaurante dt){
        Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).registrarRestaurante(dt);
    }
    
    @WebMethod
    public void datosAdicionales(Integer idCtrlUsuario, DTODatosAdicionales datos){
        Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).datosAdicionales(datos);
    }
    
    @WebMethod
    public DataCliente getUsuarioByNickname(Integer idCtrlUsuario, String nickname){
        DataCliente ret = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).getUsuarioByNickname(nickname);
        return ret;
    }
    
    @WebMethod
    public DataRestaurante getRestauranteByNickname(Integer idCtrlUsuario, String nickname){
        DataRestaurante ret = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).getRestauranteByNickname(nickname);
        return ret;
    }
    
    @WebMethod
    public DataCliente[] devListaDC(Integer idCtrlUsuario){
        ArrayList<DataCliente> clientes = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).devListaDC();
        DataCliente[] ret = new DataCliente[clientes.size()];
        Iterator it = clientes.iterator();
        int index = 0;
        while(it.hasNext()){
            ret[index] = (DataCliente) it.next();
            index++;
        }
        return ret;
    }
    
//    @WebMethod
//    public Map listaDataRestaurantes(){
//        Map ret = CU.listaDataRestaurantes();
//        return ret;
//    }
    
    @WebMethod
    public void registrarCat(Integer idCtrlUsuario, String nombre){
        Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).registrarCat(nombre);
    }
    
//    @WebMethod
//    public Map retColCat(){
//        Map ret = CU.retColCat();
//        return ret;
//    }
    
//    @WebMethod
//    public Map listaUsuPorCategoria(String cate){
//        Map ret = CU.listaUsuPorCategoria(cate);
//        return ret;
//    }
    
//    @WebMethod
//    public void setCat(Map cate){
//        CU.setCat(cate);
//    }
    
//    @WebMethod
//    public Map getLstCat(){
//        Map ret = CU.getLstCat();
//        return ret;
//    }
    
//    @WebMethod
//    public Map listaProductosStock(String r){
//        Map ret = CU.listaProductosStock(r);
//        return ret;
//    }
    
//    @WebMethod
//    public Map listarPedidos(){
//        Map ret = CU.listarPedidos();
//        return ret;
//    }
    
//    @WebMethod
//    public Map pedidosUsuario(String nickname){
//        Map ret = CU.pedidosUsuario(nickname);
//        return ret;
//    }
    
    @WebMethod
    public boolean existeUsuario(Integer idCtrlUsuario, String nickname, String email){
        return Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).existeUsuario(nickname, email);
    }
    
    @WebMethod
    public boolean existeNickname(Integer idCtrlUsuario, String nickname){
        return Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).existeNickname(nickname);
    }
    
    @WebMethod
    public boolean existeMail(Integer idCtrlUsuario, String mail){
        return Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).existeMail(mail);
    }
    
    @WebMethod
    public DataCliente getByMail(Integer idCtrlUsuario, String mail){
        DataCliente ret = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).getByMail(mail);
        return ret;
    }
    
    @WebMethod
    public DataRestaurante[] buscarRestaurantes(Integer idCtrlUsuario, String nombre){
        ArrayList<DataRestaurante> rests = Fabrica.getInstance().getICtrlUsuario(idCtrlUsuario).buscarRestaurantes(nombre);
        DataRestaurante[] ret = new DataRestaurante[rests.size()];
        Iterator it = rests.iterator();
        int index = 0;
        while(it.hasNext()){
            ret[index] = (DataRestaurante) it.next();
            index++;
        }
        return ret;
    }
}