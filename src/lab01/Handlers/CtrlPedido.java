/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import lab01.Clases.Cliente;
import lab01.Clases.DataCarrito;
import lab01.Clases.DataCliente;
import lab01.Clases.Restaurante;
import lab01.Clases.DataRestaurante;
import lab01.Interfaces.ICtrlPedido;
import lab01.Clases.DataCategoria;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataPedido;
import lab01.Clases.DataProducto;
import lab01.Clases.DataPromocional;
import lab01.Clases.Individual;
import lab01.Clases.Pedido;
import lab01.Clases.Producto;
import lab01.Clases.Producto_Stock;
import lab01.Clases.Promocional;
import lab01.Clases.estados;

/**
 *
 * @author gera
 */
public class CtrlPedido implements ICtrlPedido {
    
    private String nickname;
    private String mailCliente;
    private Cliente memCliente;
    private String categoria;
    private Restaurante memRestaurante;
    private double monto;
    private Map ColDataCarrito;
    private ArrayList<Producto_Stock> carrito;
    private DataPedido dp;
    
    public CtrlPedido(){
    this.ColDataCarrito = new HashMap();
    this.carrito = new ArrayList<>();
    }
    
    @Override
    public DataPedido getDp() {
        return dp;
    }
    
    @Override
    public void setDp(DataPedido dp) {
        this.dp = dp;
    }
    
    @Override
    public void setNickname(String nick){
        this.nickname=nick;
    }
    public String getNickname(){
        return this.nickname;
    }
    
    public String getMailCliente(){
        return this.mailCliente;
    }
    
    @Override
    public void setMailCliente(String mail){
        this.mailCliente = mail;
    }
    
    public Cliente getMemCliente(){
        return this.memCliente;
    }
    
    @Override
    public void setMemCliente(){
        HUsuario mu = HUsuario.getinstance();
        if(mu.exists(this.getNickname())){
            this.memCliente = mu.obtenerUsuario(this.getNickname());
        }
    }
    public void setMemoriaCliente(Cliente c){
            this.memCliente = c;
        
    }
    public void setCat(String nombre){
        this.categoria=nombre;
    }
    public String getCat(){
        return this.categoria;
    }
    
    public Map getColDataCarrito(){
        return this.ColDataCarrito;
    }
    
    public void setDataCarrito(DataCarrito dc){
        this.ColDataCarrito.put(dc.getNomProd(), dc);
    }
    
    public void setColDataCarrito(Map ColDataCarrito){
        this.ColDataCarrito.putAll(ColDataCarrito);
    }
    
    public ArrayList<Producto_Stock> getCarrito(){
        return this.carrito;
    }
    
    public void addCarrito(Producto_Stock pd){
        this.carrito.add(pd);
    }
    
    public void setCarrito(ArrayList<Producto_Stock> carrito){
        this.carrito = carrito;
    }
    
    public double getMonto(){
        return this.monto;
    }
    
    @Override
    public void setMonto(){
        double suma = 0;
        Iterator<DataCarrito> it = this.getColDataCarrito().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            DataCarrito dc = (DataCarrito)map.getValue();
            suma = suma + (dc.getPrecio()*dc.getCantidad());
        }
        this.monto = suma;
    }
    
    @Override
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
    public Map retColDCat(){
        Map col;       
        Map ret = new HashMap();
        HCategoria hc = HCategoria.getinstance();
        col=hc.obtenerColeccion();
        Iterator it = col.entrySet().iterator(); 
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
                DataCategoria dc = (DataCategoria)map.getValue();
                ret.put(dc.getNombre(), dc);
        }
    return (Map)ret;    
    }
    
    @Override
    public Map devListaDR(){
        HUsuario mu = HUsuario.getinstance();
        Map ret = new HashMap();
        Map col = mu.obtenerColeccion();
        Iterator it = col.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            if(map.getValue() instanceof Restaurante){
                Restaurante rest = (Restaurante)map.getValue();
                if(rest.member(this.categoria)){
                    DataRestaurante dr = rest.RestauranteADR();
                    ret.put(dr.getNickname(), dr);
                }
            }
        }
        return ret;
    }

    @Override
    public boolean setMemRestaurante(String nickname){
        HUsuario mu = HUsuario.getinstance();
        if(mu.exists(nickname)){
            this.memRestaurante = mu.obtenerRestaurante(nickname);
            return true;
        }
        return false;
    }
    
    @Override
    public DataProducto devListaProductos(){
        DataProducto dp = new DataProducto();
        Map prods = this.memRestaurante.obtenerListaProductos();
        Iterator it = prods.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            if(map.getValue() instanceof Individual){
                Individual ind = (Individual)map.getValue();
                DataIndividual di = ind.getDataIndividual();
                dp.setDatIndividual(di);
            }
            if(map.getValue() instanceof Promocional){
                Promocional prom = (Promocional)map.getValue();
                DataPromocional dprom = prom.getDataPromo();
                dp.setDatPromocional(dprom);
            }
        }
        return dp;
    }
    
    @Override
    public boolean selectProductos(String nombre, int cantidad){//esto va en un loop en la interfaz
        DataCarrito dc = this.memRestaurante.agregarProducto(nombre, cantidad);
        if(dc != null){
            Producto pro = this.memRestaurante.getProducto(dc.getNomProd());
            this.setDataCarrito(dc);
            Producto_Stock prodStock = this.memRestaurante.getProdCarrito(nombre);
            prodStock.setProducto(pro);
            this.addCarrito(prodStock);
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public DataPedido altaPedido(){
        this.setMonto();
        Pedido nuevo = new Pedido(this.getMonto());
        nuevo.setCarrito(this.getCarrito());
        DataPedido newDP = new DataPedido(nuevo.getId(), this.getNickname(), this.getMailCliente(), nuevo.getFecha(), this.memRestaurante.getNickname(), this.getColDataCarrito(), this.getMonto(), nuevo.getEstado());
        nuevo.setDataPedido(newDP);
        this.memCliente.setPedido(nuevo);
        return newDP;
    }
    
    @Override
    public Map listDataPedidos(){
        Map aux = new HashMap();
        HUsuario hu = HUsuario.getinstance();
        Iterator user = hu.obtenerColeccion().entrySet().iterator();
        while(user.hasNext()){
            Map.Entry users = (Map.Entry) user.next();
            if(users.getValue() instanceof Cliente){
                Cliente client = (Cliente)users.getValue();
                Iterator pedidos = client.getPedidos().entrySet().iterator();
                while(pedidos.hasNext()){
                    Map.Entry p = (Map.Entry) pedidos.next();
                    Pedido ped = (Pedido)p.getValue();
                    aux.put(ped.getDataPedido().getId(), ped.getDataPedido());
                }
            }
        }
        return aux;
    }
    
    @Override
    public void cancelarPedido(long id){
        HUsuario hu = HUsuario.getinstance();
        Pedido ped;
        Iterator user = hu.obtenerColeccion().entrySet().iterator();
        while(user.hasNext()){
            Map.Entry users = (Map.Entry) user.next();
            if(users.getValue() instanceof Cliente){
                Cliente client = (Cliente)users.getValue();
                if(client.existePedido(id)){
                    ped = client.getPedido(id);
                    DataPedido dp = ped.getDataPedido();
                    Restaurante r = hu.obtenerRestaurante(dp.getNickRest());
                    Iterator it = dp.getColCarrito().entrySet().iterator();
                    while(it.hasNext()){
                        Map.Entry map = (Map.Entry)it.next();
                        DataCarrito dc = (DataCarrito)map.getValue();
                        Producto prod = r.getProducto(dc.getNomProd());
                        prod.sumarStock(dc.getCantidad());
                    }
                    client.quitarPedido(id);
                    ped.vaciarPedido();
                    ped = null;
                }
            }
        }
    }
    
    @Override
    public void limpiarCtrl(){
        this.getCarrito().clear();
        this.getColDataCarrito().clear();
    }
    
    @Override
    public void actualizarEPedido(String nickname, long id, estados estado){//usar listarDataPedido antes q esto xD
        HUsuario hu = HUsuario.getinstance();
        Cliente user = hu.obtenerUsuario(nickname);
        user.actualizarEstadoPedido(id, estado);
    }
}
