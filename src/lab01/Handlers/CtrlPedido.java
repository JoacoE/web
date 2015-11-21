/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import lab01.Clases.Cliente;
import lab01.Clases.DtoEvaluacion;
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
import lab01.Clases.DtoHEstadoPedido;
import lab01.Clases.Evaluacion;
import lab01.Clases.Individual;
import lab01.Clases.Pedido;
import lab01.Clases.Producto;
import lab01.Clases.Producto_Stock;
import lab01.Clases.Promocional;
import lab01.Clases.Estados;

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
    private Integer idCtrl;
    
    public CtrlPedido(){
    this.ColDataCarrito = new HashMap();
    this.carrito = new ArrayList<>();
    }
    
    @Override
    public void setIdCtrl(Integer idCtrl){
        this.idCtrl = idCtrl;
    }
    
    @Override
    public Integer getIdCtrl(){
        return this.idCtrl;
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
    
    @Override
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
    
    @Override
    public void setMemoriaCliente(String nickname){
            HUsuario hu = HUsuario.getinstance();
            this.memCliente = hu.obtenerUsuario(nickname);
    }
    
    @Override
    public void setCat(String nombre){
        this.categoria=nombre;
    }
    
    @Override
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
    public ArrayList<DataCliente> devListaDC(){
        HUsuario mu = HUsuario.getinstance();
        Map col = mu.obtenerColeccion();
        ArrayList<DataCliente> lista = new ArrayList<>();
        Iterator it = col.entrySet().iterator(); 
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            if(map.getValue() instanceof Cliente){
                Cliente cli = (Cliente)map.getValue();
                DataCliente dc = cli.ClienteADC();
                lista.add(dc);
            }
            
        }
        
        
    return lista;
    }
   
    @Override
    public ArrayList<DataCategoria> retColDCat(){
        Map col;       
        ArrayList<DataCategoria> ret = new ArrayList<>();
        HCategoria hc = HCategoria.getinstance();
        col=hc.obtenerColeccion();
        Iterator it = col.entrySet().iterator(); 
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
                DataCategoria dc = (DataCategoria)map.getValue();
                ret.add(dc);
        }
    return ret;    
    }
    
    @Override
    public ArrayList<DataRestaurante> devListaDR(){
        HUsuario mu = HUsuario.getinstance();
        ArrayList<DataRestaurante> ret = new ArrayList<>();
        Map col = mu.obtenerColeccion();
        Iterator it = col.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            if(map.getValue() instanceof Restaurante){
                Restaurante rest = (Restaurante)map.getValue();
                if(rest.member(this.categoria)){
                    DataRestaurante dr = rest.RestauranteADR();
                    ret.add(dr);
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
        ArrayList<Producto> prods = this.memRestaurante.obtenerListaProductos();
        Iterator it = prods.iterator();
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
        ArrayList<DataCarrito> param = new ArrayList<>();
        Iterator it = this.getColDataCarrito().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry dcarts = (Map.Entry)it.next();
            DataCarrito dc = (DataCarrito)dcarts.getValue();
            param.add(dc);
        }
        DataPedido newDP = new DataPedido(nuevo.getId(), this.getNickname(), this.getMailCliente(), nuevo.getFecha(), this.memRestaurante.getNickname(), param, this.getMonto(), nuevo.getEstado());
        DtoHEstadoPedido inicioHistorial = new DtoHEstadoPedido(nuevo.getEstado().toString(), nuevo.getFecha());
        newDP.actualizarHistorial(inicioHistorial);
        nuevo.setDataPedido(newDP);
        this.memCliente.setPedido(nuevo);
        return newDP;
    }
    
    @Override
    public ArrayList<DataPedido> listDataPedidos(){       
        ArrayList<DataPedido> aux = new ArrayList<>();
        HUsuario hu = HUsuario.getinstance();
        Iterator user = hu.obtenerColeccion().entrySet().iterator();
        while(user.hasNext()){
            Map.Entry users = (Map.Entry) user.next();
            if(users.getValue() instanceof Cliente){
                Cliente client = (Cliente)users.getValue();
                for (Pedido ped : client.getPedidos()) {
                    DataPedido datped = ped.getDataPedido();
                    aux.add(datped);
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
                    if(ped.getEstado() == Estados.PREPARACION){
                        Restaurante r = hu.obtenerRestaurante(dp.getNickRest());
                        Iterator it = dp.getColCarrito().iterator();
                        while(it.hasNext()){
                            DataCarrito dc = (DataCarrito)it.next();
                            Producto prod = r.getProducto(dc.getNomProd());
                            prod.sumarStock(dc.getCantidad());
                        }
                        client.quitarPedido(id);
//                        ped.vaciarPedido();
//                        ped = null;
                    }else{
                        JOptionPane.showMessageDialog(null, "El pedido fue recibido y no puede eliminarse", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
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
    public void actualizarEPedido(String nickname, long id, Estados estado){//usar listarDataPedido antes q esto xD
        HUsuario hu = HUsuario.getinstance();
        Cliente user = hu.obtenerUsuario(nickname);
        String hActualizacion = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        user.actualizarEstadoPedido(id, estado);
        hActualizacion.concat(" hs");
        DtoHEstadoPedido historial = new DtoHEstadoPedido(estado.toString(), hActualizacion);
        user.getPedido(id).getDataPedido().actualizarHistorial(historial);
    }
    
    @Override
    public void actualizarEPedidoCDatos(String nickname, long id, Estados estado, String fecha){//usar listarDataPedido antes q esto xD
        HUsuario hu = HUsuario.getinstance();
        Cliente user = hu.obtenerUsuario(nickname);
        user.actualizarEstadoPedido(id, estado);
        DtoHEstadoPedido historial = new DtoHEstadoPedido(estado.toString(), fecha);
        user.getPedido(id).getDataPedido().actualizarHistorial(historial);
    }
    
    @Override
    public ArrayList<DataPedido> listaPedidosRecibidos(String nickname){
        ArrayList<DataPedido> aux = new ArrayList<>();
        HUsuario hu = HUsuario.getinstance();
        Iterator user = hu.obtenerColeccion().entrySet().iterator();
        while(user.hasNext()){
            Map.Entry users = (Map.Entry) user.next();
            if(users.getValue() instanceof Cliente){
                Cliente client = (Cliente)users.getValue();
                if(client.getNickname().equals(nickname)){
                    for (Pedido ped : client.getPedidos()) {
                        if(ped.getEstado() == Estados.RECIBIDO){
                            DataPedido datped = ped.getDataPedido();
                            aux.add(datped);
                        }
                    }
                }
            }
        }
        return aux;
    }
    
    @Override
    public ArrayList<DataPedido> listaPedidos(String nickname){
        ArrayList<DataPedido> aux = new ArrayList<>();
        HUsuario hu = HUsuario.getinstance();
        Iterator user = hu.obtenerColeccion().entrySet().iterator();
        while(user.hasNext()){
            Map.Entry users = (Map.Entry) user.next();
            if(users.getValue() instanceof Cliente){
                Cliente client = (Cliente)users.getValue();
                if(client.getNickname().equals(nickname)){
                    for (Pedido ped : client.getPedidos()) {
                        DataPedido datped = ped.getDataPedido();
                        aux.add(datped);                 
                    }
                }
            }
        }
        return aux;
    }
    

    @Override
    public void actualizarPromedioRest(String nickname){
        int cantidadPedidos = 0;
        float sumaPuntajes = 0;
        HUsuario hu = HUsuario.getinstance();
        Iterator clientes = hu.obtenerColeccion().entrySet().iterator();
        while(clientes.hasNext()){
            Map.Entry cliente = (Map.Entry) clientes.next();
            if(cliente.getValue() instanceof Cliente){
                Cliente c = (Cliente)cliente.getValue();
                for (Pedido p : c.getPedidos()) {
                    if((p.getDataPedido().getNickRest().equals(nickname) && (p.getEstado() == Estados.RECIBIDO))){
                        if(p.getEvaluacion() != null){
                            sumaPuntajes = sumaPuntajes + p.getEvaluacion().getPuntaje();
                            cantidadPedidos++;
                        }
                    }
                }
            }
        }
        float promedio = sumaPuntajes / cantidadPedidos;
        hu.obtenerRestaurante(nickname).setPromedio(promedio);
    }

    @Override
    public void altaEvaluacion(double id, DtoEvaluacion data){
        String rest = null;
        Evaluacion ev = null;
        if(data.getFecha() != null){
            ev = new Evaluacion(data.getComentario(), data.getPuntaje());
            ev.setFecha(data.getFecha());
        }else{
            ev = new Evaluacion(data.getComentario(), data.getPuntaje());
        }
        HUsuario hu = HUsuario.getinstance();
        Iterator user = hu.obtenerColeccion().entrySet().iterator();
        while(user.hasNext()){
            Map.Entry users = (Map.Entry) user.next();
            if(users.getValue() instanceof Cliente){
                Cliente client = (Cliente)users.getValue();
                for (Pedido p : client.getPedidos()) {
                    if(p.getId() == id){
                        p.setEvaluacion(ev);
                        rest = p.getDataPedido().getNickRest();
                    }
                }
            }
        }
        if(rest != null){
            actualizarPromedioRest(rest);
        }
        else{
            throw new NullPointerException();
        }
    }

    @Override
    public ArrayList<DtoEvaluacion> listarEvaluacionesRest(String nickname){
        ArrayList<DtoEvaluacion> aux = new ArrayList<>();
        HUsuario hu = HUsuario.getinstance();
        Iterator clientes = hu.obtenerColeccion().entrySet().iterator();
        while(clientes.hasNext()){
            Map.Entry cliente = (Map.Entry) clientes.next();
            if(cliente.getValue() instanceof Cliente){
                Cliente c = (Cliente)cliente.getValue();
                for (Pedido p : c.getPedidos()) {
                    if((p.getDataPedido().getNickRest().equals(nickname) && (p.getEstado() == Estados.RECIBIDO))){
                        if(p.getEvaluacion() != null){
                            DtoEvaluacion ev = p.getEvaluacion().getDTOEvaluacion();
                            ev.setNickname(c.getNickname());
                            aux.add(ev);
                        }
                    }
                }
            }
        }
        return aux;
    }
    
    @Override
    public boolean existeEvaluacionPedido(long id){
        HUsuario hu = HUsuario.getinstance();
        DtoEvaluacion ret = null;
        Iterator clientes = hu.obtenerColeccion().entrySet().iterator();
        while(clientes.hasNext()){
            Map.Entry cliente = (Map.Entry)clientes.next();
            if(cliente.getValue() instanceof Cliente){
                Cliente c = (Cliente)cliente.getValue();
                for (Pedido p : c.getPedidos()) {
                    if(p.getId() == id){
                        if(p.getEvaluacion()!=null){
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    public DtoEvaluacion getEvaluacionXid(long id){
        HUsuario hu = HUsuario.getinstance();
        DtoEvaluacion ret = null;
        Iterator clientes = hu.obtenerColeccion().entrySet().iterator();
        while(clientes.hasNext()){
            Map.Entry cliente = (Map.Entry)clientes.next();
            if(cliente.getValue() instanceof Cliente){
                Cliente c = (Cliente)cliente.getValue();
                for (Pedido p : c.getPedidos()) {
                    if(p.getId() == id){
                        if(p.getEvaluacion()!=null){
                            ret = p.getEvaluacion().getDTOEvaluacion();
                            return ret;
                        }else{
                            throw new NullPointerException();
                        }
                    }
                }
            }
        }
        throw new NullPointerException();
    }
    
    @Override
    public void actualizarFechaPedido(String nickname, long id, String fecha){
        HUsuario HU = HUsuario.getinstance();
        Cliente c = HU.obtenerUsuario(nickname);
        c.getPedido(id).setFecha(fecha);
    }
}
