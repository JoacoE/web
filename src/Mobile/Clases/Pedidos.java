package Mobile.Clases;

//import com.middleware.dtos.DataCarrito;
//import com.middleware.dtos.Estados;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Pedidos implements Serializable{
    @Id
    private long id;
    private String fecha; 
    private double precio_total;
    //@Enumerated(EnumType.STRING)
    private String estado;
    private String nickUsr;
    private String mailUsr;
    private String nickRest;
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="Ped_ID")
    private ArrayList<ProdCarrito> ColCarrito;

    public Pedidos() {
    }

    public Pedidos(long id, String fecha, double precio_total, String estado, String nickUsr, String mailUsr, String nickRest, ArrayList<ProdCarrito> ColCarrito) {
        this.id = id;
        this.fecha = fecha;
        this.precio_total = precio_total;
        this.estado = estado;
        this.nickUsr = nickUsr;
        this.mailUsr = mailUsr;
        this.nickRest = nickRest;
        this.ColCarrito = ColCarrito;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNickUsr() {
        return nickUsr;
    }

    public void setNickUsr(String nickUsr) {
        this.nickUsr = nickUsr;
    }

    public String getMailUsr() {
        return mailUsr;
    }

    public void setMailUsr(String mailUsr) {
        this.mailUsr = mailUsr;
    }

    public String getNickRest() {
        return nickRest;
    }

    public void setNickRest(String nickRest) {
        this.nickRest = nickRest;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public ArrayList<ProdCarrito> getColCarrito() {
        return ColCarrito;
    }

    public void setColCarrito(ArrayList<ProdCarrito> ColCarrito) {
        this.ColCarrito = new ArrayList<>();
        this.ColCarrito.addAll(ColCarrito);
    }
    
    public void addProducto(ProdCarrito pc){
        this.ColCarrito.add(pc);
    }
    
}
