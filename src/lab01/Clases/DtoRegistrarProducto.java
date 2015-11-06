/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author joaco
 */
@XmlAccessorType(XmlAccessType.FIELD)

public class DtoRegistrarProducto {

    private DataIndividual di;
    private String nickRest;
    private boolean promo;
    
    public DtoRegistrarProducto(){}
    
    public DtoRegistrarProducto(DataIndividual di, String nickRest, boolean promo){
        this.di = di;
        this.nickRest = nickRest;
        this.promo = promo;
    }

    public boolean isPromo() {
        return promo;
    }
    
    public DataIndividual getDi() {
        return di;
    }

    public void setDi(DataIndividual di) {
        this.di = di;
    }

    public String getNickRest() {
        return nickRest;
    }

    public void setNickRest(String nickRest) {
        this.nickRest = nickRest;
    }

    public boolean getPromo() {
        return promo;
    }

    public void setPromo(boolean promo) {
        this.promo = promo;
    }
}
