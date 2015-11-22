package Mobile.Controlador;
import Mobile.Clases.*;
import Mobile.listaPedidos;
import com.middleware.dtos.*;
import com.middleware.logic.Middleware;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import lab01.server.DataRestaurante;


public class Controlador {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("MobileQuickOrderPU");
    Middleware mid = new Middleware();
    private ArrayList<Usuarios> rests;
    private ArrayList<Pedidos> peds;
    
    
    public EntityManager getEntityManager(){
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
    public Controlador(){
        rests = new ArrayList<>();
        peds = new ArrayList<>();
    }
    
    public boolean iniciarSesionWS(String user, String password){
        try{            
            for(DataRestaurante dr: mid.listaDataRestaurantes()){
                Usuarios u = new Usuarios();
                u.setNickRest(dr.getNickname());
                u.setPassRest(dr.getPwd());
                u.setMailRest(dr.getEmail());
                rests.add(u);
                EntityManager em= getEntityManager();
//                Usuarios usu = null;
//                usu = em.find(Usuarios.class, dr.getNickname());
//                
//                if (usu == null){
                if(!em.contains(u)){
                    em.getTransaction().begin();
                    em.persist(u);
                    em.getTransaction().commit();
                    em.close();    
                }
                
            }
            for (Usuarios r : rests){
                if (r.getNickRest().equals(user) || r.getMailRest().equals(user)){
                    if (r.getPassRest().equals(password)){
                        return true;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Password incorrecta");
                    }    
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean iniciarSesion(String user, String password){
        
        if (mid.connection()){
            return iniciarSesionWS(user, password);
        }    
        else
        {
            boolean existe= false;
            EntityManager em= getEntityManager();
            Usuarios usu = null;
                try{
                    usu = em.find(Usuarios.class, user);
                    if (usu.getPassRest().equals(password)){
                        existe = true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Password incorrecta");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            return existe;
        }
    }


    public void cerrarSesion(){

    }   
}