/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mobile;

import com.middleware.logic.Middleware;
import java.awt.BorderLayout;

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
        jDesktopPane1.setBorder(new ImagenFondoMovil());
        existeconexion();
    }
    
    public void existeconexion(){
        Middleware mid = new Middleware();
        if (mid.connection()){
            lblConexion.setVisible(false);
        }
        else
        {
            lblConexion.setVisible(true);
        }
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
        btnSesion = new javax.swing.JButton();
        lblConexion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FondoMovil = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpHome.setMaximumSize(new java.awt.Dimension(320, 480));
        jpHome.setMinimumSize(new java.awt.Dimension(320, 480));
        jpHome.setRequestFocusEnabled(false);
        jpHome.setLayout(null);

        btnSesion.setText("Iniciar sesion");
        btnSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesionActionPerformed(evt);
            }
        });
        jpHome.add(btnSesion);
        btnSesion.setBounds(110, 290, 120, 30);

        lblConexion.setForeground(new java.awt.Color(255, 0, 0));
        lblConexion.setText("ATENCION: No tiene conexion");
        jpHome.add(lblConexion);
        lblConexion.setBounds(19, 70, 290, 18);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Helpers/titulomovil.png"))); // NOI18N
        jpHome.add(jLabel3);
        jLabel3.setBounds(20, 100, 290, 100);
        jpHome.add(FondoMovil);
        FondoMovil.setBounds(0, 0, 0, 660);

        jDesktopPane1.setMaximumSize(new java.awt.Dimension(320, 480));
        jDesktopPane1.setMinimumSize(new java.awt.Dimension(320, 480));
        jpHome.add(jDesktopPane1);
        jDesktopPane1.setBounds(20, 70, 290, 520);
        jDesktopPane1.getAccessibleContext().setAccessibleName("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Helpers/mobile2.png"))); // NOI18N
        jpHome.add(jLabel1);
        jLabel1.setBounds(0, 0, 330, 650);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHome, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpHome, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSesionActionPerformed
        btnSesion.hide();
        login l =  new login(this);
        l.setLocation(40,150);
        jDesktopPane1.add(l);
        jDesktopPane1.show();
    }//GEN-LAST:event_btnSesionActionPerformed

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
    private javax.swing.JButton btnSesion;
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jpHome;
    private javax.swing.JLabel lblConexion;
    // End of variables declaration//GEN-END:variables
}
