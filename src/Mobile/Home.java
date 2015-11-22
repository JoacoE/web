/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mobile;
import Mobile.Clases.Pedidos;
import java.awt.*;
import javax.swing.*;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import com.middleware.logic.Middleware;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Mobile.Clases.Usuarios;
import Mobile.Controlador.Controlador;
import java.util.ArrayList;
//import lab01.Clases.ImagenFondoMovil;

/**
 *
 * @author gera
 */
public class Home extends javax.swing.JFrame {
//
//EntityManagerFactory emf = Persistence.createEntityManagerFactory("MobileQuickOrderPU");
//EntityManager em = emf.createEntityManager();

    public Home() {
        initComponents();
        
//    jDesktopPane2.setBorder(new ImagenFondoMovil());
//            conn = Connect.ConnectBD();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpHome = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tbLogin = new javax.swing.JTextField();
        tbPassword = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        FondoMovil = new javax.swing.JLabel();
        MobileFondo = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpHome.setLayout(null);
        jpHome.add(jLabel3);
        jLabel3.setBounds(20, 100, 290, 100);

        tbLogin.setText("mera");
        tbLogin.setToolTipText("User o Email");
        tbLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbLoginActionPerformed(evt);
            }
        });
        jpHome.add(tbLogin);
        tbLogin.setBounds(70, 280, 190, 28);

        tbPassword.setText("abc12");
        jpHome.add(tbPassword);
        tbPassword.setBounds(70, 320, 190, 28);

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jpHome.add(btnIngresar);
        btnIngresar.setBounds(92, 380, 140, 30);
        jpHome.add(FondoMovil);
        FondoMovil.setBounds(0, 0, 0, 660);
        jpHome.add(MobileFondo);
        MobileFondo.setBounds(20, 70, 290, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHome, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHome, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbLoginActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        Controlador c = Controlador.getInstance();
        String user = this.tbLogin.getText();
        String pass = this.tbPassword.getText();
        if(c.iniciarSesion(user, pass)){
            ArrayList<Pedidos> lstped= c.getLstPedidos(user);
            listaPedidos listaPed = new listaPedidos();
            MobileFondo.add(listaPed);
            listaPed.show();
//            jpHome.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No existe ese usuario");
        }    

//        Middleware gil = new Middleware();
//
//        if(gil.connection()){
//            System.out.print("WS ENABLED");
//        }else{
//            System.out.print("WS DISABLED");
//            
//            Usuarios usu = null;
//            try{
//                usu = em.find(Usuarios.class, tbLogin.getText());
//                if (usu.getPassRest().equals(tbPassword.getText())){
//                    listaPedidos listaPed = new listaPedidos();
//                    MobileFondo.add(listaPed);
//                    listaPed.show();
//                }
//                else{
//                    JOptionPane.showMessageDialog(null, "Password incorrecta");
//                }
//            }catch (Exception ex){
//                JOptionPane.showMessageDialog(null, ex);
//            }
//        }

//        String sql = "select * from Usuarios where Usuario=? and Password=?";
//        try{
//            pst=conn.prepareStatement(sql);
//            pst.setString(1, tbLogin.getText());
//            pst.setString(2, tbPassword.getText());
//            
//            rs= pst.executeQuery();
//            
//            if(rs.next()){
//                JOptionPane.showMessageDialog(null, "Se conecto de la base");
//            
//            
//                //listaPedidos lista = new listaPedidos();
//                //jDesktopPane2.add(lista);
//                //lista.show();
//            }
//            else{
//                JOptionPane.showMessageDialog(null, "No existe ese usuario");
//            }
//
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//        
        
        
                // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FondoMovil;
    public static javax.swing.JDesktopPane MobileFondo;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jpHome;
    private javax.swing.JTextField tbLogin;
    private javax.swing.JTextField tbPassword;
    // End of variables declaration//GEN-END:variables
}
