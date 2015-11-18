/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import static lab01.Clases.Estados.PREPARACION;
import static lab01.Clases.Estados.RECIBIDO;


/**
 *
 * @author gera
 */
//enum Estados {PREPARACION, ENVIADO, RECIBIDO};

public class Pedido {

    
    private long id; // ver como hacer el autogenerado
    private String fecha; // ver como hacer la fecha si con el jcalendar esta fecha tiene que ser la del momento en q se crea el objeto(la del sistema)
    private double precio_total;
    private Estados estado;
    private ArrayList<Producto_Stock> carrito;
    private DataPedido dp;
    private Evaluacion evaluacion;

    public Pedido(double precio_total) {
        this.setId();
        this.setFecha();
        this.precio_total = precio_total;
        this.estado = PREPARACION;
        this.evaluacion = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
        this.getDataPedido().setId(id);
    }
    
    public void setId() {
        Random randomid = new Random();
        String aux = String.valueOf(randomid.nextLong());
        if(aux.startsWith("-")){
            aux = aux.replaceFirst("-", "");
        }
        this.id = Long.valueOf(aux);
    }

    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
        this.getDataPedido().setFecha(fecha);
    }
    
    public void setFecha() {
        String hora = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        this.fecha = hora.concat(" hs");
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado){
        if("PREPARACION".equals(this.getEstado().toString())){
            if("ENVIADO".equals(estado.toString()) || "RECIBIDO".equals(estado.toString())){
                this.estado = estado;
                this.getDataPedido().setEstado(estado);
            }
            //JOptionPane.showMessageDialog(null, "Se cambio el estado del pedido ", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
        if("RECIBIDO".equals(estado.toString())){
            this.estado = estado;
            this.getDataPedido().setEstado(estado);
            //JOptionPane.showMessageDialog(null, "Se cambio el estado del pedido ", "Exito", JOptionPane.INFORMATION_MESSAGE);

        }
            //JOptionPane.showMessageDialog(null, "El pedido esta siendo Enviado", "Conflicto de Estado", JOptionPane.INFORMATION_MESSAGE);
        
        if(this.getEstado() == RECIBIDO){
           //JOptionPane.showMessageDialog(null, "El pedido fue Recibido", "Conflicto de Estado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public ArrayList<Producto_Stock> getDataCarrito(){
        return this.carrito;
    }
    
    public void setCarrito(ArrayList<Producto_Stock> carrito){
        this.carrito = carrito;
    }
    
    public void vaciarPedido(){
        this.getDataCarrito().clear();
        this.setDataPedido(null);
    }
    
    public boolean sePuedeBorrar(){
        return this.getEstado() == PREPARACION;
    }
    
    public DataPedido getDataPedido(){
        return this.dp;
    }
    
    public void setDataPedido(DataPedido dp){
        this.dp = dp;
    }
    
    public void setEvaluacion(Evaluacion e){
        this.evaluacion = e;
    }
    
    public Evaluacion getEvaluacion(){
        return this.evaluacion;
    }
    public DataPedido getDp() {
        return dp;
    }

    public void setDp(DataPedido dp) {
        this.dp = dp;
    }
}
