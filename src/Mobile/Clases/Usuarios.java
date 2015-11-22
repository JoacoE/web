
package Mobile.Clases;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuarios implements Serializable{
    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)    
//    private int idUser;
    private String nickRest;
    private String mailRest;
    private String PassRest;

    public Usuarios() {
    }

    public Usuarios(String nickRest, String mailRest, String PassRest) {
        this.nickRest = nickRest;
        this.mailRest = mailRest;
        this.PassRest = PassRest;
    }
//
//    public int getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(int idUser) {
//        this.idUser = idUser;
//    }

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
        
}
