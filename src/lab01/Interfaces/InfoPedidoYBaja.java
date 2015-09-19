/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Interfaces;

import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lab01.Clases.DataCarrito;
import lab01.Clases.DataPedido;
import lab01.Handlers.Fabrica;
import javax.swing.SwingUtilities;
import lab01.Clases.estados;

/**
 *
 * @author joaco
 */
public class InfoPedidoYBaja extends javax.swing.JFrame {

    /**
     * Creates new form InfoPedidoYBaja
     */
    private ICtrlPedido ICP;
    int fila = 0;
    private DataPedido datped;
    public InfoPedidoYBaja(DataPedido dp){
        initComponents();
        datped = dp;
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getICtrlPedido();
        String id = Long.toString(dp.getId());
        lblIDpedido.setText(id);
        lblNickCliente.setText(dp.getNickUsr());
        lblNIckRestaurant.setText(dp.getNickRest());
        lblEstado.setText(dp.getEstado().toString());
        modelo = (DefaultTableModel)jTable.getModel();
        cargarTabla(this.datped);
        String PTotal = Double.toString(dp.getPrecio_total());
        lblPrecioTotal.setText(PTotal);
        jComboBox1.setVisible(false);
        if("RECIBIDO".equals(datped.getEstado().toString())){
            jbActualizar.setEnabled(false);
        }
        if(this.datped.getEstado() == estados.ENVIADO || this.datped.getEstado() == estados.RECIBIDO){
            btnEliminar.setEnabled(false);
        }
    }
    DefaultTableModel modelo;

    private InfoPedidoYBaja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarTabla(DataPedido dp){
        Iterator it = dp.getColCarrito().entrySet().iterator();
        String lista[] = new String[4];
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            DataCarrito dc = (DataCarrito)map.getValue();
            lista[0] = dc.getNomProd();
            String cant = Integer.toString(dc.getCantidad());
            lista[1] = cant;
            boolean promo = dc.getPromo();
            if(promo){
                lista[2] = "SI";
            }else{
                lista[2] = "NO";
            }
            double subT = dc.getCantidad() * dc.getPrecio();
            String SsubT = Double.toString(subT);
            lista[3] = SsubT;
            modelo.insertRow((int)fila, lista);
            fila++;
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

        lstEstado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNickCliente = new javax.swing.JLabel();
        lblNIckRestaurant = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        lblIDpedido = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lblPrecioTotal = new javax.swing.JLabel();
        jbActualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        lstEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion del pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 14))); // NOI18N

        jLabel1.setText("Id Pedido:");

        jLabel2.setText("Cliente:");

        jLabel3.setText("Restaurante:");

        btnEliminar.setText("Dar de Baja el pedido");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Promo", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane.setViewportView(jTable);

        jLabel4.setText("Total:");

        jbActualizar.setText("Actualizar el pedido");
        jbActualizar.setFocusable(false);
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado de Pedido:");

        jComboBox1.setEditable(true);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar..." }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lstEstadoLayout = new javax.swing.GroupLayout(lstEstado);
        lstEstado.setLayout(lstEstadoLayout);
        lstEstadoLayout.setHorizontalGroup(
            lstEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lstEstadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lstEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(lstEstadoLayout.createSequentialGroup()
                        .addGroup(lstEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btnEliminar)
                            .addComponent(jbActualizar)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(lstEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIDpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(lstEstadoLayout.createSequentialGroup()
                                .addGroup(lstEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNickCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNIckRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lstEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(lstEstadoLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        lstEstadoLayout.setVerticalGroup(
            lstEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lstEstadoLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(lblEstado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lstEstadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lstEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblIDpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lstEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lstEstadoLayout.createSequentialGroup()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(lstEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lblPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(lstEstadoLayout.createSequentialGroup()
                        .addGroup(lstEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblNickCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(lstEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblNIckRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(21, 21, 21)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbActualizar)))
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar)
                    .addComponent(lstEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lstEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null,"Desea cancelar el pedido?","Confirmación",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            JOptionPane.showMessageDialog(null, "El pedido se ha cancelado con éxito", "Éxito",JOptionPane.WARNING_MESSAGE);
            ICP.cancelarPedido(this.datped.getId());
        }else{
            JOptionPane.showMessageDialog(null, "El pedido no ha sido cancelado","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }
        
        this.dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    // TODO add your handling code here:
        estados es = null;
        jComboBox1.setEditable(false);
        
        if("ENVIADO".equals(jComboBox1.getSelectedItem().toString())){
            es = estados.ENVIADO;
            
        }
        if("RECIBIDO".equals(jComboBox1.getSelectedItem().toString())){
            es =  estados.RECIBIDO;
        }
        if(JOptionPane.showConfirmDialog(null,"Desea actualizar el pedido?","Confirmación",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            ICP.actualizarEPedido(datped.getNickUsr(), datped.getId(),es);
            jComboBox1.removeAllItems();
            jComboBox1.setVisible(false);
            jbActualizar.setEnabled(false);
            lblEstado.setText(datped.getEstado().toString());

        }else{
            JOptionPane.showMessageDialog(null, "El pedido no se ha actualizado","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        if(jComboBox1.getItemCount() !=1){
            jComboBox1.removeAllItems();
            jComboBox1.setEnabled(false);
        }
        SwingUtilities.updateComponentTreeUI(this);
        this.revalidate();
        this.repaint();
        actualizarEstado();
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        jComboBox1.setEditable(false);
        jComboBox1.setVisible(true);
        actualizarEstado();
        
         
    }//GEN-LAST:event_jbActualizarActionPerformed
    public void actualizarEstado(){
        if ("PREPARACION".equals(this.datped.getEstado().toString())){
            jComboBox1.addItem("ENVIADO");
            jComboBox1.addItem("RECIBIDO");
            
        }else{
             if("ENVIADO".equals(this.datped.getEstado().toString())){
                 jComboBox1.addItem("RECIBIDO");
             }
         }
    }
        
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
            java.util.logging.Logger.getLogger(InfoPedidoYBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoPedidoYBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoPedidoYBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoPedidoYBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoPedidoYBaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIDpedido;
    private javax.swing.JLabel lblNIckRestaurant;
    private javax.swing.JLabel lblNickCliente;
    private javax.swing.JLabel lblPrecioTotal;
    private javax.swing.JPanel lstEstado;
    // End of variables declaration//GEN-END:variables
}
