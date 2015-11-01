/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author joaco
 */
public class HCtrlProducto {
    private static HCtrlProducto instance = null;
    private Map<Integer,CtrlProducto> CUColection;
    
    private HCtrlProducto(){}
    
    public static HCtrlProducto getInstance(){
        if(HCtrlProducto.instance == null){
            HCtrlProducto.instance = new HCtrlProducto();
            HCtrlProducto.instance.CUColection = new HashMap();
        }
        return HCtrlProducto.instance;
    }
    
    public CtrlProducto getControlador(Integer idCtrlProducto){
        if(CUColection.containsKey(idCtrlProducto)){
            return CUColection.get(idCtrlProducto);
        }else{
            CtrlProducto CP = new CtrlProducto();
            CP.setIdCtrl(idCtrlProducto);
            CUColection.put(idCtrlProducto, CP);
            return CP;
        }
    }
    
    public Integer getSiguienteId(){
        return CUColection.keySet().size();
    }
}
