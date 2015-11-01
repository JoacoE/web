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
public class HCtrlPedido {
    
    private static HCtrlPedido instance = null;
    private Map<Integer,CtrlPedido> CUColection;
    
    private HCtrlPedido(){}
    
    public static HCtrlPedido getInstance(){
        if(HCtrlPedido.instance == null){
            HCtrlPedido.instance = new HCtrlPedido();
            HCtrlPedido.instance.CUColection = new HashMap();
        }
        return HCtrlPedido.instance;
    }
    
    public CtrlPedido getControlador(Integer idCtrlPedido){
        if(CUColection.containsKey(idCtrlPedido)){
            return CUColection.get(idCtrlPedido);
        }else{
            CtrlPedido CP = new CtrlPedido();
            CP.setIdCtrl(idCtrlPedido);
            CUColection.put(idCtrlPedido, CP);
            return CP;
        }
    }
    
    public Integer getSiguienteId(){
        return CUColection.keySet().size();
    }
}
