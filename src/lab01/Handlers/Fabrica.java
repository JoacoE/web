/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab01.Handlers;

import lab01.Interfaces.ICtrlUsuario;
import lab01.Interfaces.ICtrlProducto;
import lab01.Interfaces.ICtrlPedido;

/**
 *
 * @author admin123
 */
public class Fabrica {

    private static Fabrica instancia;
    
    private Fabrica(){};

    public static Fabrica getInstance(){
        if (instancia == null){
            instancia = new Fabrica();
        }
        return instancia;
    }
    
    public ICtrlUsuario getICtrlUsuario(Integer idCtrl){
        if(idCtrl == null){
            Integer nextId = HCtrlUsuario.getInstance().getSiguienteId();
            return HCtrlUsuario.getInstance().getControlador(nextId);
        }
        return HCtrlUsuario.getInstance().getControlador(idCtrl);
    }

    public ICtrlProducto getICtrlProducto(Integer idCtrl){
        if(idCtrl == null){
            Integer nextId = HCtrlProducto.getInstance().getSiguienteId();
            return HCtrlProducto.getInstance().getControlador(nextId);
        }
        return HCtrlProducto.getInstance().getControlador(idCtrl);
    }

    public ICtrlPedido getICtrlPedido(Integer idCtrl){
        if(idCtrl == null){
            Integer nextId = HCtrlPedido.getInstance().getSiguienteId();
            return HCtrlPedido.getInstance().getControlador(nextId);
        }
        return HCtrlPedido.getInstance().getControlador(idCtrl);
    }    
}