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
private static ICtrlUsuario ICU;
private static ICtrlProducto ICP;
private static ICtrlPedido ICPed;
private Fabrica(){};

    public static Fabrica getInstance(){
    if (instancia == null){
        instancia = new Fabrica();
    }
    return instancia;
}
    
public ICtrlUsuario getICtrlUsuario() {
    if(ICU==null)
        ICU = new CtrlUsuario();
    return ICU;
}

public ICtrlProducto getICtrlProducto(){
    if(ICP==null)
        ICP = new CtrlProducto();
    return ICP;
}

public ICtrlPedido getICtrlPedido(){
    if(ICPed==null)
        ICPed = new CtrlPedido();
    return ICPed;
}
    
}