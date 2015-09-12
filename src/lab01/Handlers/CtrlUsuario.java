/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;
import lab01.Clases.Cliente;
import lab01.Clases.Restaurante;
//import static lab01.Handlers.tipoU.cliente;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lab01.Interfaces.ICtrlUsuario;
import lab01.Clases.DataCliente;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import lab01.Clases.Categoria;
import lab01.Clases.DataCliente;
import lab01.Clases.DataPedido;
import lab01.Clases.DataRestaurante;
import lab01.Clases.Pedido;
import lab01.Clases.Usuario;

/**
 *
 * @author gera
 */
//enum tipoU{cliente,restaurante}

public class CtrlUsuario implements ICtrlUsuario {

    private String nickname;
    private String nombre;
    private String email;
    private String direccion;
    private Map Cat;
    
    
    public CtrlUsuario(){}
    
    public void setCat(Map cate){
        this.Cat=cate;
        //JOptionPane.showMessageDialog(null, "Categoria recordada","EXITO",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public Map getLstCat(){
        return this.Cat;
    }
    public void setNickname(String nick){
        this.nickname=nick;
    }
    public String getNickname(){
        return this.nickname;
    }

    @Override
    public boolean ingresarDatos(String nickname, String nombre, String email, String direccion){
        this.nickname=nickname;
        this.direccion=direccion;
        this.nombre=nombre;
        this.email=email;
        HUsuario HU = HUsuario.getinstance();
        return !(HU.find(nickname, email));
    }

    @Override
    public void registrarCliente(String apellido, String img, String fecha){
        Cliente c = new Cliente(this.nickname, this.nombre, this.email, this.direccion, apellido, img, fecha);
        HUsuario HU = HUsuario.getinstance();
        HU.addUsuario(c);
    }

   
    public void registrarRestaurante(DataRestaurante dt){
        Restaurante r = new Restaurante(dt.getNickname(),dt.getNombre(),dt.getEmail(),dt.getDireccion(), dt.getLstImagen(), dt.getColProducto(), dt.getColCategoria());
        HUsuario HU = HUsuario.getinstance();
        HU.addUsuario(r);
    }
    
    public void datosAdicionales(String apellido, String img){
        HUsuario mu = HUsuario.getinstance();
        Cliente c = mu.obtenerUsuario(this.nickname);
        c.setApellido(apellido);
        c.setImagen(img);
    }

    @Override
    public DataCliente getUsuarioByNickname(String nickname){
        HUsuario mu = HUsuario.getinstance();
        return (mu.obtenerUsuario(nickname)).ClienteADC();
    }
    public Cliente getUsuNick(String nickname){
        HUsuario mu = HUsuario.getinstance();
        return mu.obtenerUsuario(nickname);
    }

    @Override
    public Restaurante getRestauranteByNickname(String nickname){
        HUsuario mu = HUsuario.getinstance();
        return (Restaurante)(mu.obtenerRestaurante(nickname));
    }

    public Map devListaDC(){
        HUsuario mu = HUsuario.getinstance();
        Map ret = new HashMap();
        Map col = mu.obtenerColeccion();
        Iterator it = col.entrySet().iterator(); 
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            if(map.getValue() instanceof Cliente){
                Cliente cli = (Cliente)map.getValue();
                DataCliente dc = cli.ClienteADC();
                ret.put(dc.getNickname(), dc);
            }
        }
    return ret;
    }

    public Map listaDataRestaurantes(){
        HUsuario mu = HUsuario.getinstance();
        Map ret = new HashMap();
        Map col = mu.obtenerColeccion();
        Iterator it = col.entrySet().iterator(); 
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            if(map.getValue() instanceof Restaurante){
                Restaurante res = (Restaurante)map.getValue();
                DataRestaurante dc = res.RestauranteADR();
                ret.put(dc.getNickname(), dc);
            }
        }
    return ret;
    }
    
    public Map listaUsuPorCategoria(String cate){
        HUsuario mu = HUsuario.getinstance();
        Map Ldr = listaDataRestaurantes();
        Map ret = new HashMap();
        Iterator it = Ldr.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            DataRestaurante r = (DataRestaurante)map.getValue();
            if(r.member(cate))
                ret.put(r.getNickname(),r);
            }
        return ret;
    
    }
            
    
    
    public void registrarCat(String nombre){
        HCategoria hu = HCategoria.getinstance();
        if(hu.member(nombre))
            JOptionPane.showMessageDialog(null, "La categoria ya existe","ERROR",JOptionPane.ERROR_MESSAGE);
        else{
            Categoria c = new Categoria(nombre);
            hu.addCategoria(c);
            //JOptionPane.showMessageDialog(null, "Se ha creado la nueva categoria","EXITO",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Map retColCat(){
        Map ret  = new HashMap();        
        HCategoria hc = HCategoria.getinstance();
        ret=hc.obtenerColeccion();
        return (Map)ret;
    }

    @Override
    public void datosAdicionales(String apellido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    
    public Map listaProductosStock(String r){
        Restaurante rest = getRestauranteByNickname(r);
        Map lProd = rest.obtenerListaIndividualesStock();
        
        return lProd;
    }

    public Map listarPedidos(){
        HUsuario HU = HUsuario.getinstance();
        Map lu = HU.obtenerColeccion();
        Map ret = new HashMap();
        Iterator it = lu.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            if(map.getValue() instanceof Cliente){
                Cliente c = (Cliente)map.getValue();
                Map lp = c.listaPedidos();
                Iterator itp = lp.entrySet().iterator();
                while(itp.hasNext()){
                    Map.Entry mapP = (Map.Entry) itp.next();
                    Pedido p = (Pedido)mapP.getValue();
                    DataPedido dp = p.getDataPedido();
                    
                    ret.put(dp.getId(), dp);
                }
            }
        }
    return ret;
    }
//    @Override
//    public void registrarRestaurante(DataRestaurante dt) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    

}