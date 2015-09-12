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
import javax.swing.JOptionPane;
import static lab01.Clases.estados.ENVIADO;
import static lab01.Clases.estados.PREPARACION;
import static lab01.Clases.estados.RECIBIDO;


/**
 *
 * @author gera
 */
//enum estados {PREPARACION, ENVIADO, RECIBIDO};

public class Pedido {
    private long id; // ver como hacer el autogenerado
    private String fecha; // ver como hacer la fecha si con el jcalendar esta fecha tiene que ser la del momento en q se crea el objeto(la del sistema)
    private double precio_total;
    private estados estado;
    private ArrayList<Producto_Stock> carrito;
    private DataPedido dp;

    public Pedido(double precio_total) {
        this.setId();
        this.setFecha();
        this.precio_total = precio_total;
        this.estado = PREPARACION;
    }

    public long getId() {
        return id;
    }

    public void setId() {
        Random randomid = new Random();
        this.id = randomid.nextLong();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha() {
        this.fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public estados getEstado() {
        return estado;
    }

    public void setEstado(estados estado){
        if(this.getEstado() == PREPARACION){
            if(estado == ENVIADO || estado == RECIBIDO){
                this.estado = estado;
                this.getDataPedido().setEstado(estado);
            }
            JOptionPane.showMessageDialog(null, "El pedido esta en Preparacion", "Conflicto de Estado", JOptionPane.INFORMATION_MESSAGE);
        }
        if(this.getEstado() == ENVIADO){
            if(estado == RECIBIDO){
                this.estado = estado;
                this.getDataPedido().setEstado(estado);
            }
            JOptionPane.showMessageDialog(null, "El pedido esta siendo Enviado", "Conflicto de Estado", JOptionPane.INFORMATION_MESSAGE);
        }
        if(this.getEstado() == RECIBIDO){
            JOptionPane.showMessageDialog(null, "El pedido fue Recibido", "Conflicto de Estado", JOptionPane.INFORMATION_MESSAGE);
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
}
