/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;


import java.util.Map;

/**
 *
 * @author gera
 */
public class DataProducto {
    private Map ColDatIndividual;
    private Map ColDatPromocional;
    
    public DataProducto() {   
    }

    public Map getColDatIndividual() {
        return this.ColDatIndividual;
    }

    public void setDatIndividual(DataIndividual di) {
        this.ColDatIndividual.put(di.getDataNombre(), di);
    }
    
    public void setColDatIndividual(Map ColDatIndividual){//comodidad...
        this.ColDatIndividual = ColDatIndividual;
    }
    
    public Map getColDatPromocional(){
        return this.ColDatPromocional;
    }

    public void setDatPromocional(DataPromocional dp) {
        this.ColDatPromocional.put(dp.getDataNombre(), dp);
    }
    
    public void setColDatPromocional(Map ColDatPromocional){//comodidad...
        this.ColDatPromocional = ColDatPromocional;
    }
    
}
