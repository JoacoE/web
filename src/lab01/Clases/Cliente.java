/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author gera
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente extends Usuario{
    private String apellido;
    private String fNac;
//    private Map pedidos;
    private ArrayList<Pedido> pedidos;

    public Cliente(){}
    public Cliente(String nickname, String nombre, String email, String direccion,String apellido, String img, String fecha, String pwd) {
        super(nickname,nombre,email,direccion, pwd);
       //setNickname(); poner los valores de los tb
        this.apellido = apellido;
        this.setImagen(img);
        this.fNac = fecha;
        this.pedidos = new ArrayList<>();
    }

    public Cliente(String nickname, String nombre, String email, String direccion, String apellido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getApellido() {
        return apellido;
    }
   
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getFecha(){
        return fNac;
    }

    public void setFecha(String fecha) {
        this.fNac = fecha;
    }
    public String getMail(){
        return mail;
    }
    public String getNickname() {
        return nickname;
    }
    
    public ArrayList<Pedido> getPedidos(){
        return this.pedidos;
    }
    
    public Pedido getPedido(long id){
        double iderror = 0;
        for (Pedido p : this.getPedidos()) {
            if(p.getId() == id){
                return p;
            }
        }
        JOptionPane.showMessageDialog(null, "Id:" + iderror, "No Existe Pedido", JOptionPane.INFORMATION_MESSAGE);
        return null;
    }
    
    public boolean existePedido(long id){
        for (Pedido p : this.getPedidos()) {
            if(p.getId() == id){
                return true;
            }
        }
        return false;
    }
    
    public void quitarPedido(long id){
        this.getPedidos().remove(id);
    }
    
    public void setPedido(Pedido p){
        this.pedidos.add(p);
    }
    
    public void setPedidos(ArrayList<Pedido> pedidos){
        this.pedidos = pedidos;
    }
    
    public DataCliente ClienteADC(){
        DataCliente DC = new DataCliente(this.nickname, this.nombre, this.mail, this.direccion, this.apellido, this.imagen, this.fNac, this.contrasenia);
        return DC;
    }
    
    public void actualizarEstadoPedido(long id, Estados estado){
        this.getPedido(id).setEstado(estado);
    }
    
    public ArrayList<Pedido> listaPedidos(){
    return this.pedidos;
    }
}
