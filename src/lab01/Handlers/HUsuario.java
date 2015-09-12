/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import lab01.Clases.Usuario;
import lab01.Clases.Cliente;
import lab01.Clases.Restaurante;
import java.util.Iterator;
import javax.swing.JOptionPane;
import lab01.Clases.DataUsuario;
/**
 *
 * @author Pablo
 */
public class HUsuario {
    //Clase que conserva la colección global de los Usuarios del Sistema
    private Map Colusuarios;
    private static HUsuario instancia=null;
    
    private HUsuario(){
       Colusuarios =new HashMap();
    }
    
    public static HUsuario getinstance(){
        if (instancia==null)
            instancia = new HUsuario();
        return instancia;
    }
    
    public void addUsuario(Usuario usu){
        String nickname = usu.getNickname();
        Colusuarios.put(nickname,usu);
        //JOptionPane.showMessageDialog(null, usu.getNickname());
    }
    
    public Map obtenerColeccion(){        
        return Colusuarios;
    }
    
    public Cliente obtenerUsuario(String nickname){
        return ((Cliente) Colusuarios.get(nickname));
    }
    public Restaurante obtenerRestaurante(String nickname){
        return ((Restaurante) Colusuarios.get(nickname));
    }
    public boolean find(String nickname, String email){
       
        if(Colusuarios.isEmpty())
            return false;
        else
            if(Colusuarios.containsKey(nickname))
                return true;
            else{
                Iterator it = Colusuarios.entrySet().iterator();
                
                while(it.hasNext()){
                    Map.Entry map = (Map.Entry) it.next();
                    Usuario usu= (Usuario)map.getValue();
                    if(email.equals(usu.getMail()))
                        return true;   
                }
            }
        return false;
    }
    
    public boolean exists(String nickname){
        if(Colusuarios.isEmpty())
            return false;
        else
            if(Colusuarios.containsKey(nickname))
                return true;
        
        return false;
    }
}
    
    