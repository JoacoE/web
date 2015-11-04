/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mobile;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author gera
 */
public class Connect {
    Connection conn = null;
    
public static Connection ConnectBD(){
    try{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:Tarea3.sqlite");
        JOptionPane.showMessageDialog(null, "Se conecto carajo");
        
        return conn;
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    return null;
}
    
    
    
    
}
