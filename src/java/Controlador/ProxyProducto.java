/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author joaquin
 */
import java.util.ArrayList;
import lab01.server.DataIndividual;
import lab01.server.DataIndividualArray;
import lab01.server.DataPromocional;
import lab01.server.DtoActualizarIndividual;
import lab01.server.DtoActualizarPromocional;
import lab01.server.DtoArmarPromo;
import lab01.server.DtoRegistrarProducto;
import lab01.server.PublicadorProducto;
import lab01.server.PublicadorProductoService;
/**
 *
 * @author joaquin
 */
public class ProxyProducto {
    
private Integer idCtrlProducto;
private static ProxyProducto instance = null;
private final PublicadorProducto CP;

private ProxyProducto(){
    idCtrlProducto = null;
    PublicadorProductoService servicio = new PublicadorProductoService();
    CP = servicio.getPublicadorProductoPort();
    idCtrlProducto = CP.getId();
}

public static ProxyProducto getInstance(){
    if(ProxyProducto.instance == null){
        ProxyProducto.instance = new ProxyProducto();
    }
    return ProxyProducto.instance;
    }    
    
    public void registrarProducto(DtoRegistrarProducto datos){
        CP.registrarProducto(idCtrlProducto, datos);
    }
    
    public boolean existeRestaurante(String nomRest){
        return CP.existeRestaurante(idCtrlProducto, nomRest);
    }

    public ArrayList<DataIndividual> listarIndividuales(String nomRest){
        ArrayList<DataIndividual> ret = new ArrayList<>();
        ret.addAll(CP.listarIndividuales(idCtrlProducto, nomRest).getItem());
        return ret;
    }
    
    public void setPromo(ArrayList<DataIndividual> promo){
        DataIndividualArray param = new DataIndividualArray();
        for(DataIndividual di: promo){
            param.getItem().add(di);
        }
        CP.setPromo(idCtrlProducto, param);
    }

    public void armarPromo(DtoArmarPromo datos){
        CP.armarPromo(idCtrlProducto, datos);
    }

    public void actualizarIndividual(DtoActualizarIndividual datos){
        CP.actualizarIndividual(idCtrlProducto, datos);
    }

    public void actualizarPromocional(DtoActualizarPromocional datos){
        CP.actualizarPromocional(idCtrlProducto, datos);
    }

    public DataIndividual getProdIndividualXNombre(String nombre){
        lab01.server.DataIndividual ret = CP.getProdIndividualXNombre(idCtrlProducto, nombre);
        return ret;
    }

    public DataPromocional getProdPromocionalXNombre(String nombre){
        lab01.server.DataPromocional ret = CP.getProdPromocionalXNombre(idCtrlProducto, nombre);
        return ret;
    }
}