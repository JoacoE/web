/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Interfaces;
import java.util.Map;
import lab01.Clases.DTOActualizarIndividual;
import lab01.Clases.DTOActualizarPromocional;
import lab01.Clases.DTOArmarPromo;
import lab01.Clases.DTORegistrarProducto;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataPromocional;

/**
 *
 * @author gonzalo
 */
public interface ICtrlProducto {
    
    public abstract void registrarProducto(DTORegistrarProducto datos);
    public abstract boolean existeRestaurante(String nomRest);
    public abstract Map listarIndividuales(String nomRest);
    public abstract void setPromo(Map promo);
    public abstract void armarPromo(DTOArmarPromo datos);
    public abstract void actualizarIndividual(DTOActualizarIndividual datos);
    public abstract void actualizarPromocional(DTOActualizarPromocional datos);
    public abstract DataIndividual getProdIndividualXNombre(String nombre);
    public abstract DataPromocional getProdPromocionalXNombre(String nombre);
    public abstract void setIdCtrl(Integer idCtrl);
    public abstract Integer getIdCtrl();
}
