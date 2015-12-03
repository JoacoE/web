package Mobile.Clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProdCarrito implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_PCARR")
    private int idProdc;
    private String nomProd;
    private boolean promo;
    private int cantidad;
    private double precio;

    public ProdCarrito() {
    }

    public ProdCarrito(String nomProd, boolean promo, int cantidad, double precio) {
        this.nomProd = nomProd;
        this.promo = promo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getIdProdc() {
        return idProdc;
    }

    public void setIdProdc(int idProdc) {
        this.idProdc = idProdc;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public boolean isPromo() {
        return promo;
    }

    public void setPromo(boolean promo) {
        this.promo = promo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
        
}
