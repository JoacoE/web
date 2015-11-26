package Mobile.Controlador;
import Mobile.Clases.*;
import static Mobile.Home.jDesktopPane1;
//import com.middleware.dtos.*;
import com.middleware.logic.Middleware;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

    public ArrayList<Usuarios> getRests() {
        return rests;
    }

    public void setRests(ArrayList<Usuarios> rests) {
        this.rests = rests;
    }

    public ArrayList<Pedidos> getPeds() {
        return peds;
    }

    public void setPeds(ArrayList<Pedidos> peds) {
        this.peds = peds;
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
                Usuarios usu = null;
                usu = em.find(Usuarios.class, dr.getNickname());
//                
                if (usu == null){
//                em.
//                if(!em.contains(u)){
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
                        JOptionPane.showInternalMessageDialog(jDesktopPane1, "Password incorrecta");
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
//            Usuarios usu = null;
                try{
//                    usu = em.find(Usuarios.class, user);
                    Query query = em.createQuery("SELECT u FROM Usuarios u", Usuarios.class);
//                    Usuarios usu = (Usuarios)query.setParameter("nickname", user).getSingleResult();
                    List<Usuarios> usu = query.getResultList();
                    for (Usuarios u : usu){
                        if (u.getNickRest().equals(user)){
                            if (u.getPassRest().equals(password)){
                                setRestLog(user);
                                existe = true;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(jDesktopPane1, "Password incorrecta");
                            }  
                        }
                        
                    }
                }catch (Exception ex){
                    JOptionPane.showInternalMessageDialog(jDesktopPane1, ex);
                }
            return existe;
        }
    }


    public void cerrarSesion(){
        this.RestLog= "";
        this.peds.clear();
//        this.rests = null;
    }
    
    public void getLstPedidos(){
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
//                ArrayList<ProdCarrito> aux = new ArrayList<>();
                for(DataCarrito dcarr: dp.getColCarrito()){
                    ProdCarrito pc = new ProdCarrito();
                    pc.setNomProd(dcarr.getNomProd());
                    pc.setCantidad(dcarr.getCantidad());
                    pc.setPrecio(dcarr.getPrecio());
                    pc.setPromo(dcarr.isPromo());
//                    aux.add(pc);
                    p.addProducto(pc);
                }
//                p.setColCarrito(aux);

                if (p.getNickRest().equals(RestLog)){
                    peds.add(p);
                }
                EntityManager em= getEntityManager();
                
                
                Pedidos ped = null;
                ped = em.find(Pedidos.class, p.getId());
//                
                if (ped == null){
                
                
//                if(!em.contains(p)){
                    em.getTransaction().begin();
                    em.persist(p);
                    em.getTransaction().commit();
                    em.close();    
                }
        }        
        
    }   catch (Exception ex) {
            EntityManager em= getEntityManager();
            Pedidos ped = null;
            List<Pedidos> lstped = null;
                try{
                    //falta recorrer todos los pedidos con ese restaurante
                    TypedQuery<Pedidos> q = em.createQuery("SELECT p FROM Pedidos p", Pedidos.class);
                    
                    lstped = q.getResultList();
                    peds.clear();
                    for (Pedidos p : lstped){
                        if (p.getNickRest().equals(this.RestLog)){
                            agregarPed(p);
                        }
                    }
                }catch (Exception e){
                    JOptionPane.showInternalMessageDialog(jDesktopPane1, e);
                }
    //IR CONTRA LA BASE    
    }
        
    }
    
    public void agregarPed(Pedidos p){
        if(this.peds == null){
            peds = new ArrayList<>();
        }
        peds.add(p);
    }
            
            
            
    public Pedidos getPedidoById(long id){
        for(Pedidos p : this.peds){
            if (p.getId() == id){
                return p;
            }
        }
        throw new NullPointerException();
    }
    
    public void actualizarEstadoPed(String nickname, long id, String est){
        try {
            mid.actualizarEPedido(nickname, id, est);
            EntityManager em= getEntityManager();
            TypedQuery<Pedidos> q = em.createQuery("SELECT p FROM Pedidos p", Pedidos.class);
            List<Pedidos> lstped = null;
            lstped = q.getResultList();
            for (Pedidos p : lstped){
                if (p.getId() ==(id)){
                    Pedidos pedido = em.find(Pedidos.class, p.getId());
                    em.getTransaction().begin();
                    pedido.setEstado(est);
                    em.getTransaction().commit();
                    em.close();
                }
            }
        } catch (Exception ex) {
            EntityManager em= getEntityManager();
            TypedQuery<Pedidos> q = em.createQuery("SELECT p FROM Pedidos p", Pedidos.class);
            List<Pedidos> lstped = null;
            lstped = q.getResultList();
            for (Pedidos p : lstped){
                if (p.getId() ==(id)){
                    Pedidos pedido = em.find(Pedidos.class, p.getId());
                    em.getTransaction().begin();
                    pedido.setEstado(est);
                    
//                    em.merge(est);
                    em.getTransaction().commit();
                    em.close();
                }
            }
        }
    }
    
    public void syncEstados(){
        try {
            EntityManager em = getEntityManager();
            ArrayList<DataPedido> aux = new ArrayList<>();
            ArrayList<Pedidos> aux2 = new ArrayList<>();
            List<Pedidos> lstped = null;
                    
            for (DataPedido dp :mid.listDataPedidos()){
                if(dp.getNickRest().equals(RestLog)){
                    aux.add(dp);
                }
            }
            TypedQuery<Pedidos> q = em.createQuery("SELECT p FROM Pedidos p", Pedidos.class);               
            lstped = q.getResultList();
            for (Pedidos p : lstped){
                if (p.getNickRest().equals(this.RestLog)){
                    aux2.add(p);
                }
            }
            for (Pedidos p : aux2){
                for (DataPedido dp : aux){
                    if(dp.getMailUsr().equals(p.getMailUsr()) && dp.getNickRest().equals(p.getNickRest()) && dp.getPrecioTotal() == p.getPrecio_total()){
                        if(!dp.getEstado().toString().equals(p.getEstado())){
                            mid.actualizarEPedido(p.getNickUsr(), dp.getId(), p.getEstado());
                        }
                    }
                }
                JOptionPane.showInternalMessageDialog(jDesktopPane1, "Sincronización exitosa");
            }
        } catch (Exception ex) {
            JOptionPane.showInternalMessageDialog(jDesktopPane1, "No hay conexion");
        }
    }
    
}