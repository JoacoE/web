/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author gera
 */
@XmlAccessorType(XmlAccessType.FIELD)

public class DataProducto {
    private ArrayList<DataIndividual> ColDatIndividual;
    private ArrayList<DataPromocional> ColDatPromocional;
    
    public DataProducto() {}

    public ArrayList<DataIndividual> getColDatIndividual() {
        return this.ColDatIndividual;
    }

    public void setDatIndividual(DataIndividual di) {
        this.ColDatIndividual.add(di);
    }
    
    public void setColDatIndividual(ArrayList<DataIndividual> ColDatIndividual){//comodidad...
        this.ColDatIndividual = ColDatIndividual;
    }
    
    public ArrayList<DataPromocional> getColDatPromocional(){
        return this.ColDatPromocional;
    }

    public void setDatPromocional(DataPromocional dp) {
        this.ColDatPromocional.add(dp);
    }
    
    public void setColDatPromocional(ArrayList<DataPromocional> ColDatPromocional){//comodidad...
        this.ColDatPromocional = ColDatPromocional;
    }
    
}
