/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import lab01.Clases.DTOEvaluacion;
import lab01.Clases.DataPedido;
import lab01.Clases.DataProducto;
import lab01.Clases.estados;
import lab01.Handlers.Fabrica;

/**
 *
 * @author joaco
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorPedido {
    
    private Endpoint endpoint = null;
    
    public PublicadorPedido(){}
    
    @WebMethod(exclude = true)
    public void publicPed(){
         endpoint = Endpoint.publish("http://localhost:9003/pubped", this);
    }
    
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public Integer getId(){
        return Fabrica.getInstance().getICtrlPedido(null).getIdCtrl();
    }
    
    @WebMethod
    public void setNickname(Integer idCtrlPedido, String nick){
        Fabrica.getInstance().getICtrlPedido(idCtrlPedido).setNickname(nick);
    }
    
    @WebMethod
    public void setMailCliente(Integer idCtrlPedido, String mail){
        Fabrica.getInstance().getICtrlPedido(idCtrlPedido).setMailCliente(mail);
    }
    
    @WebMethod
    public void setMemCliente(Integer idCtrlPedido){
        Fabrica.getInstance().getICtrlPedido(idCtrlPedido).setMemCliente();
    }
    
    @WebMethod
    public void setCat(Integer idCtrlPedido, String nombre){
        Fabrica.getInstance().getICtrlPedido(idCtrlPedido).setCat(nombre);
    }
    
    @WebMethod
    public String getCat(Integer idCtrlPedido){
        String ret = Fabrica.getInstance().getICtrlPedido(idCtrlPedido).getCat();
        return ret;
    }
    
    @WebMethod
    public String getNickname(Integer idCtrlPedido){
        String ret = Fabrica.getInstance().getICtrlPedido(idCtrlPedido).getNickname();
        return ret;
    }
    
//    @WebMethod
//    public Map devListaDC(int index){
//        Map ret = CP.get(index).devListaDC();
//        return ret;
//    }
    
//    @WebMethod
//    public Map devListaDR(){
//        Map ret = CP.devListaDR();
//        return ret;
//    }
    
    @WebMethod
    public boolean setMemRestaurante(Integer idCtrlPedido, String nickname){
        return Fabrica.getInstance().getICtrlPedido(idCtrlPedido).setMemRestaurante(nickname);
    }
    
//    @WebMethod
//    public Map retColDCat(){
//        Map ret = CP.retColDCat();
//        return ret;
//    }
    
    @WebMethod
    public DataProducto devListaProductos(Integer idCtrlPedido){
        DataProducto ret = Fabrica.getInstance().getICtrlPedido(idCtrlPedido).devListaProductos();
        return ret;
    }
    
    @WebMethod
    public boolean selectProductos(Integer idCtrlPedido, String nombre, int cantidad){
        return Fabrica.getInstance().getICtrlPedido(idCtrlPedido).selectProductos(nombre, cantidad);
    }
    
    @WebMethod
    public void setMonto(Integer idCtrlPedido){
        Fabrica.getInstance().getICtrlPedido(idCtrlPedido).setMonto();
    }
    
    @WebMethod
    public DataPedido altaPedido(Integer idCtrlPedido){
        DataPedido ret = Fabrica.getInstance().getICtrlPedido(idCtrlPedido).altaPedido();
        return ret;
    }
    
//    @WebMethod
//    public Map listDataPedidos(){
//        Map ret = CP.listDataPedidos();
//        return ret;
//    }
    
    @WebMethod
    public void actualizarEPedido(Integer idCtrlPedido, String nickname, long id, estados estado){
        Fabrica.getInstance().getICtrlPedido(idCtrlPedido).actualizarEPedido(nickname, id, estado);
    }
    
    @WebMethod
    public void setDp(Integer idCtrlPedido, DataPedido dp){
        Fabrica.getInstance().getICtrlPedido(idCtrlPedido).setDp(dp);
    }
    
    @WebMethod
    public DataPedido getDp(Integer idCtrlPedido){
        DataPedido ret = Fabrica.getInstance().getICtrlPedido(idCtrlPedido).getDp();
        return ret;
    }
    
    @WebMethod
    public void setMemoriaCliente(Integer idCtrlPedido, String nickname){
        Fabrica.getInstance().getICtrlPedido(idCtrlPedido).setMemoriaCliente(nickname);
    }
    
    @WebMethod
    public void limpiarCtrl(Integer idCtrlPedido){
        Fabrica.getInstance().getICtrlPedido(idCtrlPedido).limpiarCtrl();
    }
    
    @WebMethod
    public void cancelarPedido(Integer idCtrlPedido, long id){
        Fabrica.getInstance().getICtrlPedido(idCtrlPedido).cancelarPedido(id);
    }
    
//    @WebMethod
//    public Map listaPedidosRecibidos(String nickname){
//        Map ret = CP.listaPedidosRecibidos(nickname);
//        return ret;
//    }
    
    @WebMethod
    public void actualizarPromedioRest(Integer idCtrlPedido, String nickname){
        Fabrica.getInstance().getICtrlPedido(idCtrlPedido).actualizarPromedioRest(nickname);
    }
    
    @WebMethod
    public void altaEvaluacion(Integer idCtrlPedido, double id, DTOEvaluacion data){
        Fabrica.getInstance().getICtrlPedido(idCtrlPedido).altaEvaluacion(id, data);
    }
    
//    @WebMethod
//    public Map listarEvaluacionesRest(String nickname){
//        Map ret = CP.listarEvaluacionesRest(nickname);
//        return ret;
//    }
    
    @WebMethod
    public DTOEvaluacion getEvaluacionXid(Integer idCtrlPedido, long id){
        DTOEvaluacion ret = Fabrica.getInstance().getICtrlPedido(idCtrlPedido).getEvaluacionXid(id);
        return ret;
    }
    
//    @WebMethod
//    public Map listaPedidos(String nickname){
//        Map ret = CP.listaPedidos(nickname);
//        return ret;
//    }
}
