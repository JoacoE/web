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
import lab01.Clases.DTOActualizarIndividual;
import lab01.Clases.DTOActualizarPromocional;
import lab01.Clases.DTOArmarPromo;
import lab01.Clases.DTORegistrarProducto;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataPromocional;
import lab01.Handlers.Fabrica;

/**
 *
 * @author joaco
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorProducto {
    
    private Endpoint endpoint = null;
    
    public PublicadorProducto(){}
    
    @WebMethod(exclude = true)
    public void publicProd(){
         endpoint = Endpoint.publish("http://localhost:9002/pubprod", this);
    }
    
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public Integer getId(){
        return Fabrica.getInstance().getICtrlProducto(null).getIdCtrl();
    }
    
    @WebMethod
    public void registrarProducto(Integer idCtrlProducto, DTORegistrarProducto datos){
        Fabrica.getInstance().getICtrlProducto(idCtrlProducto).registrarProducto(datos);
    }
    
    @WebMethod
    public boolean existeRestaurante(Integer idCtrlProducto, String nomRest){
        return Fabrica.getInstance().getICtrlProducto(idCtrlProducto).existeRestaurante(nomRest);
    }
    
    @WebMethod
    public DataIndividual[] listarIndividuales(Integer idCtrlProducto, String nomRest){
         
        ArrayList<DataIndividual> datas = Fabrica.getInstance().getICtrlProducto(idCtrlProducto).listarIndividuales(nomRest);
        DataIndividual[] ret = new DataIndividual[datas.size()];
        Iterator it = datas.iterator();
        int i = 0;
        while (it.hasNext()){
            ret[i]= (DataIndividual)it.next();
            i++;
        }
        
        return ret;
    }
    
    @WebMethod
    public void setPromo(Integer idCtrlProducto, DataIndividual[] promo){
        ArrayList<DataIndividual> ret = new ArrayList();
        for(int i=0; i<promo.length; i++){
            ret.add(promo[i]);
            i++;
        }
        Fabrica.getInstance().getICtrlProducto(idCtrlProducto).setPromo(ret);
    }
    
    @WebMethod
    public void armarPromo(Integer idCtrlProducto, DTOArmarPromo datos){
        Fabrica.getInstance().getICtrlProducto(idCtrlProducto).armarPromo(datos);
    }
    
    @WebMethod
    public void actualizarIndividual(Integer idCtrlProducto, DTOActualizarIndividual datos){
        Fabrica.getInstance().getICtrlProducto(idCtrlProducto).actualizarIndividual(datos);
    }
    
    @WebMethod
    public void actualizarPromocional(Integer idCtrlProducto, DTOActualizarPromocional datos){
        Fabrica.getInstance().getICtrlProducto(idCtrlProducto).actualizarPromocional(datos);
    }
    
    @WebMethod
    public DataIndividual getProdIndividualXNombre(Integer idCtrlProducto, String nombre){
        DataIndividual ret = Fabrica.getInstance().getICtrlProducto(idCtrlProducto).getProdIndividualXNombre(nombre);
        return ret;
    }
    
    @WebMethod
    public DataPromocional getProdPromocionalXNombre(Integer idCtrlProducto, String nombre){
        DataPromocional ret = Fabrica.getInstance().getICtrlProducto(idCtrlProducto).getProdPromocionalXNombre(nombre);
        return ret;
    }
}
