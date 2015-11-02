/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;
import java.util.ArrayList;
import lab01.Clases.Cliente;
import lab01.Clases.Restaurante;
import javax.swing.JOptionPane;
import lab01.Interfaces.ICtrlUsuario;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import lab01.Clases.Categoria;
import lab01.Clases.DTODatosAdicionales;
import lab01.Clases.DTOIngresarDatos;
import lab01.Clases.DTORegistrarCliente;
import lab01.Clases.DataCategoria;
import lab01.Clases.DataCliente;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataPedido;
import lab01.Clases.DataRestaurante;
import lab01.Clases.Pedido;

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
    private Integer idCtrl;
    
    
    public CtrlUsuario(){}
    
    @Override
    public void setIdCtrl(int idCtrl){
        this.idCtrl = idCtrl;
    }
    
    @Override
    public Integer getIdCtrl(){
        return this.idCtrl;
    }
    
    @Override
    public void setCat(ArrayList<String> cate){
        HCategoria hc = HCategoria.getinstance();
        Map aux = new HashMap();
        Iterator cats = hc.obtenerColeccion().entrySet().iterator();
        while(cats.hasNext()){
            Map.Entry cat = (Map.Entry) cats.next();
            Categoria c = (Categoria)cat.getValue();
            Iterator scats = cate.iterator();
            while(scats.hasNext()){
                String selectedcat = (String) scats.next();
                if(c.getNombre().equals(selectedcat)){
                    DataCategoria dc = c.CatADC();
                    aux.put(dc.getNombre(), dc);
                }
            }
        }
        this.Cat = aux;
    }
    
    @Override
    public ArrayList<DataCategoria> getLstCat(){
        ArrayList<DataCategoria> ret = new ArrayList<>();
        Iterator it = this.Cat.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry cats = (Map.Entry)it.next();
            DataCategoria dc = (DataCategoria)cats.getValue();
            ret.add(dc);
        }
        return ret;
    }
    
    @Override
    public void setNickname(String nick){
        this.nickname=nick;
    }
    
    @Override
    public String getNickname(){
        return this.nickname;
    }

    @Override
    public boolean ingresarDatos(DTOIngresarDatos datos){
        this.nickname = datos.getNickname();
        this.direccion = datos.getDireccion();
        this.nombre = datos.getNombre();
        this.email = datos.getEmail();
        HUsuario HU = HUsuario.getinstance();
        return !(HU.find(nickname, email));
    }

    @Override
    public void registrarCliente(DTORegistrarCliente datos){
        if(datos.getImagen() == null){
            datos.setImagen("");
        }
        Cliente c = new Cliente(this.nickname, this.nombre, this.email, this.direccion, datos.getApellido(), datos.getImagen(), datos.getFecha(), datos.getPwd());
        HUsuario HU = HUsuario.getinstance();
        HU.addUsuario(c);
    }

    @Override
    public void registrarRestaurante(DataRestaurante dt){
        if(!dt.getColCategoria().isEmpty()){
            HCategoria hc = HCategoria.getinstance();
            Map categorias = new HashMap();
            Iterator cats = hc.obtenerColeccion().entrySet().iterator();
            while(cats.hasNext()){
                Map.Entry cat = (Map.Entry) cats.next();
                Categoria c = (Categoria)cat.getValue();
                Iterator dcats = dt.getColCategoria().entrySet().iterator();
                while(dcats.hasNext()){
                    Map.Entry dcat = (Map.Entry) dcats.next();
                    DataCategoria dc = (DataCategoria)dcat.getValue();
                    if(c.getNombre().equals(dc.getNombre())){
                        categorias.put(c.getNombre(), c);
                    }
                }                
            }
//            if(dt.getLstImagen() == null){
//                dt.getLstImagen().add("");
//            }
            Restaurante r = new Restaurante(dt.getNickname(),dt.getNombre(),dt.getEmail(),dt.getDireccion(), dt.getLstImagen(), dt.getColProducto(), categorias, dt.getPwd());
            HUsuario HU = HUsuario.getinstance();
            HU.addUsuario(r);
        }else{
            JOptionPane.showMessageDialog(null, "No se ingresaron categorias", "Error", JOptionPane.ERROR_MESSAGE);
            throw new NullPointerException();
        }
    }
    
    @Override
    public void datosAdicionales(DTODatosAdicionales datos){
        HUsuario mu = HUsuario.getinstance();
        Cliente c = mu.obtenerUsuario(this.nickname);
        c.setApellido(datos.getApellido());
        c.setImagen(datos.getImagen());
    }

    @Override
    public DataCliente getUsuarioByNickname(String nickname){
        HUsuario mu = HUsuario.getinstance();
        return (mu.obtenerUsuario(nickname)).ClienteADC();
    }

    @Override
    public DataRestaurante getRestauranteByNickname(String nickname){
        HUsuario mu = HUsuario.getinstance();
        Restaurante r = mu.obtenerRestaurante(nickname);
        DataRestaurante dr = r.RestauranteADR();
        return dr;
    }
    
    @Override
    public ArrayList<DataCliente> devListaDC(){
        HUsuario mu = HUsuario.getinstance();
        ArrayList<DataCliente> ret = new ArrayList<>();
        Map col = mu.obtenerColeccion();
        Iterator it = col.entrySet().iterator(); 
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            if(map.getValue() instanceof Cliente){
                Cliente cli = (Cliente)map.getValue();
                DataCliente dc = cli.ClienteADC();
                ret.add(dc);
            }
        }
    return ret;
    }
    
    @Override
    public ArrayList<DataRestaurante> listaDataRestaurantes(){
        HUsuario mu = HUsuario.getinstance();
        ArrayList<DataRestaurante> ret = new ArrayList<>();
        Map col = mu.obtenerColeccion();
        Iterator it = col.entrySet().iterator(); 
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            if(map.getValue() instanceof Restaurante){
                Restaurante res = (Restaurante)map.getValue();
                DataRestaurante dc = res.RestauranteADR();
                ret.add(dc);
            }
        }
    return ret;
    }
    
    @Override
    public ArrayList<DataRestaurante> listaUsuPorCategoria(String cate){
        HUsuario mu = HUsuario.getinstance();
        ArrayList<DataRestaurante> ret = new ArrayList<>();
        Iterator it = listaDataRestaurantes().iterator();
        while(it.hasNext()){
            DataRestaurante dr = (DataRestaurante)it.next();
            Iterator dcats = dr.getColCategoria().entrySet().iterator();
            while(dcats.hasNext()){
                Map.Entry dcat = (Map.Entry) dcats.next();
                DataCategoria dc = (DataCategoria)dcat.getValue();
                if(dc.getNombre().equals(cate)){
                    ret.add(dr);
                }
            }
        }
        return ret;
    }
            
    @Override
    public void registrarCat(String nombre){
        HCategoria hu = HCategoria.getinstance();
        if(hu.member(nombre)){
            
        }
            //JOptionPane.showMessageDialog(null, "La categoria ya existe","ERROR",JOptionPane.ERROR_MESSAGE);
        else{
            Categoria c = new Categoria(nombre);
            hu.addCategoria(c);
            //JOptionPane.showMessageDialog(null, "Se ha creado la nueva categoria","EXITO",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public ArrayList<DataCategoria> retColCat(){
        ArrayList<DataCategoria> ret  = new ArrayList<>();        
        HCategoria hc = HCategoria.getinstance();
        Iterator it = hc.obtenerColeccion().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry cat = (Map.Entry) it.next();
            Categoria c = (Categoria)cat.getValue();
            DataCategoria dc = c.CatADC();
            ret.add(dc);
        }
        return ret;
    }
    
    @Override
    public ArrayList<DataIndividual> listaProductosStock(String r){
        ArrayList<DataIndividual> ret = new ArrayList<>();
        HUsuario hu = HUsuario.getinstance();
        Restaurante rest = hu.obtenerRestaurante(r);
        Iterator it = rest.obtenerListaIndividualesStock().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry inds = (Map.Entry)it.next();
            DataIndividual di = (DataIndividual)inds.getValue();
            ret.add(di);
        }
        return ret;
    }
    
    @Override
    public ArrayList<DataPedido> listarPedidos(){
        HUsuario HU = HUsuario.getinstance();
        Map lu = HU.obtenerColeccion();
        ArrayList<DataPedido> ret = new ArrayList<>();
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
                    ret.add(dp);
                }
            }
        }
    return ret;
    }

    @Override
    public ArrayList<DataPedido> pedidosUsuario(String nickname){
        HUsuario hu = HUsuario.getinstance();
        Cliente user = (Cliente) hu.obtenerUsuario(nickname);
        Map pedidos = new HashMap();
        ArrayList<DataPedido> ret = new ArrayList<>();
        pedidos = user.getPedidos();
        Iterator it = pedidos.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry p = (Map.Entry) it.next();
            Pedido ped = (Pedido) p.getValue();
            DataPedido dp = ped.getDataPedido();
            ret.add(dp);
        }
        return ret;
    }
    
    @Override
    public boolean existeUsuario(String nickname, String email){
        HUsuario HU = HUsuario.getinstance();
        return HU.find(nickname, email);
    }
    
    @Override
    public boolean existeNickname(String nickname){
        HUsuario HU = HUsuario.getinstance();
        return HU.exists(nickname);
    }
    
    @Override
    public boolean existeMail(String mail){
        HUsuario HU = HUsuario.getinstance();
        return HU.existsMail(mail);
    }
    
    @Override
    public DataCliente getByMail(String mail){
        HUsuario HU = HUsuario.getinstance();
        Iterator it = HU.obtenerColeccion().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry usuarios = (Map.Entry)it.next();
            if(usuarios.getValue() instanceof Cliente){
                Cliente c = (Cliente)usuarios.getValue();
                if(c.getMail().equals(mail)){
                    return c.ClienteADC();
                }
            }
        }
        throw new NullPointerException();
    }
    
    public ArrayList<DataRestaurante> buscarRestaurantes(String nombre){
        ArrayList<DataRestaurante> lista = new ArrayList<>();
        HUsuario HU = HUsuario.getinstance();
        Map ColUsuarios = HU.obtenerColeccion();
        Iterator it = ColUsuarios.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry usuarios = (Map.Entry)it.next();
            if(usuarios.getValue() instanceof Restaurante){
                Restaurante r = (Restaurante)usuarios.getValue();
                String nom = nombre.toUpperCase();
                String n = r.getNombre().toUpperCase();
                if (n.contains(nom)){
                    DataRestaurante dr= r.RestauranteADR();
                    if(!lista.contains(dr))
                        lista.add(dr);
                }
                else{
                    if(r.tengoCategoria(nombre)){
                        DataRestaurante dr= r.RestauranteADR();
                        if(!lista.contains(dr))
                            lista.add(dr);
                    }
                    else{
                        if(r.tengoProducto(nombre)){
                            DataRestaurante dr= r.RestauranteADR();
                            if(!lista.contains(dr))
                                lista.add(dr);
                        }                    
                    }
                }
            }
        }
    return lista;
    }    
}