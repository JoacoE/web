/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Interfaces;
import java.util.ArrayList;
import lab01.Clases.DtoActualizarIndividual;
import lab01.Clases.DtoActualizarPromocional;
import lab01.Clases.DtoArmarPromo;
import lab01.Clases.DtoRegistrarProducto;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataPromocional;

/**
 *
 * @author gonzalo
 */
public interface ICtrlProducto {
    
    public abstract void registrarProducto(DtoRegistrarProducto datos);
    public abstract boolean existeRestaurante(String nomRest);
    public abstract ArrayList<DataIndividual> listarIndividuales(String nomRest);
    public abstract void setPromo(ArrayList<DataIndividual> promo);
    public abstract void armarPromo(DtoArmarPromo datos);
    public abstract void actualizarIndividual(DtoActualizarIndividual datos);
    public abstract void actualizarPromocional(DtoActualizarPromocional datos);
    public abstract DataIndividual getProdIndividualXNombre(String nombre);
    public abstract DataPromocional getProdPromocionalXNombre(String nombre);
    public abstract void setIdCtrl(Integer idCtrl);
    public abstract Integer getIdCtrl();
}
