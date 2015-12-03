
package Mobile.Clases;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Usuarios implements Serializable{
    @Id
    @Column(name="NICK_REST")
//    @GeneratedValue(strategy=GenerationType.IDENTITY)    
//    private int idUser;
    private String nickRest;
    private String mailRest;
    private String PassRest;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="ID_PED")
    private ArrayList<Pedidos> pedidos;

    public Usuarios() {
        this.pedidos = new ArrayList<>();
    }

    public Usuarios(String nickRest, String mailRest, String PassRest) {
        this.nickRest = nickRest;
        this.mailRest = mailRest;
        this.PassRest = PassRest;
        this.pedidos = new ArrayList<>();
    }

    public String getNickRest() {
        return nickRest;
    }

    public void setNickRest(String nickRest) {
        this.nickRest = nickRest;
    }

    public String getMailRest() {
        return mailRest;
    }

    public void setMailRest(String mailRest) {
        this.mailRest = mailRest;
    }

    public String getPassRest() {
        return PassRest;
    }

    public void setPassRest(String PassRest) {
        this.PassRest = PassRest;
    }
    
    public void setPedidos(ArrayList<Pedidos> peds){
        this.pedidos.addAll(peds);
    }
    
    public ArrayList<Pedidos> getPedidos(){
        return this.pedidos;
    }
    
    public void addPedido(Pedidos ped){
        this.pedidos.add(ped);
    }
    
    public boolean existePedido(int id){
        for(Pedidos ped : pedidos){
            if(ped.getId() == id){
                return true;
            }
        }
        return false;
    }
        
}
