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
public class HCtrlUsuario {
    
    private static HCtrlUsuario instance = null;
    private Map<Integer,CtrlUsuario> CUColection;
    
    private HCtrlUsuario(){}
    
    public static HCtrlUsuario getInstance(){
        if(HCtrlUsuario.instance == null){
            HCtrlUsuario.instance = new HCtrlUsuario();
            HCtrlUsuario.instance.CUColection = new HashMap();
        }
        return HCtrlUsuario.instance;
    }
    
    public CtrlUsuario getControlador(Integer idCtrlUsuario){
        if(CUColection.containsKey(idCtrlUsuario)){
            return CUColection.get(idCtrlUsuario);
        }else{
            CtrlUsuario CU = new CtrlUsuario();
            CU.setIdCtrl(idCtrlUsuario);
            CUColection.put(idCtrlUsuario, CU);
            return CU;
        }
    }
    
    public Integer getSiguienteId(){
        return CUColection.keySet().size();
    }
}
