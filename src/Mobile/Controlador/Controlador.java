package Mobile.Controlador;
import Mobile.Clases.*;
import Mobile.listaPedidos;
//import com.middleware.dtos.*;
import com.middleware.logic.Middleware;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import lab01.server.DataCarrito;
import lab01.server.DataCliente;
import lab01.server.DataPedido;
import lab01.server.DataRestaurante;


public class Controlador {
    private static Controlador cont;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("MobileQuickOrderPU");
    Middleware mid = new Middleware();
    private String RestLog;
    private ArrayList<Usuarios> rests;
    private ArrayList<Pedidos> peds;
    
    
    public EntityManager getEntityManager(){
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
    
    private Controlador(){
        RestLog = "";
        rests = new ArrayList<>();
        peds = new ArrayList<>();
    }

    public
        static Controlador getInstance(){
        if (cont == null){
            cont = new Controlador();
        }
        return cont;
    }
    
    public String getRestLog() {
        return RestLog;
    }

    public void setRestLog(String RestLog) {
        this.RestLog = RestLog;
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
                        setRestLog(user);                        
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
                        setRestLog(user);
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
    
    public ArrayList<Pedidos> getLstPedidos(String RestLog){
        try{
            for(DataPedido dp: mid.listDataPedidos()){
                Pedidos p = new Pedidos();
                p.setId(dp.getId());
                String est = dp.getEstado().toString();
                p.setEstado(est);
                p.setNickUsr(dp.getNickUsr());
                DataCliente dc = mid.getUsuarioByNickname(dp.getNickUsr());
                p.setDireccion(dc.getDireccion());
                p.setFecha(dp.getFecha());
                p.setMailUsr(dp.getMailUsr());
                p.setNickRest(dp.getNickRest());
                p.setPrecio_total(dp.getPrecioTotal());
                ArrayList<ProdCarrito> aux = new ArrayList<>();
                for(DataCarrito dcarr: dp.getColCarrito()){
                    ProdCarrito pc = new ProdCarrito();
                    pc.setNomProd(dcarr.getNomProd());
                    pc.setCantidad(dcarr.getCantidad());
                    pc.setPrecio(dcarr.getPrecio());
                    pc.setPromo(dcarr.isPromo());
                    aux.add(pc);
                }
                p.setColCarrito(aux);

                if (p.getNickRest().equals(RestLog)){
                    peds.add(p);
                }
                EntityManager em= getEntityManager();
                if(!em.contains(p)){
                    em.getTransaction().begin();
                    em.persist(p);
                    em.getTransaction().commit();
                    em.close();    
                }
        }        
        
    }   catch (Exception ex) {
            EntityManager em= getEntityManager();
            Pedidos ped = null;
                try{
                    //falta recorrer todos los pedidos con ese restaurante
                    ped = em.find(Pedidos.class, getRestLog());
                    peds.add(ped);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
    //IR CONTRA LA BASE    
    }
        return peds;
    }
    
    public Pedidos getPedidoById(long id){
        for(Pedidos p : this.peds){
            if (p.getId() == id){
                return p;
            }
        }
        throw new NullPointerException();
    }
    
    
}