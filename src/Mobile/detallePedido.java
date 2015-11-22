package Mobile;

import Mobile.Clases.Pedidos;
import Mobile.Clases.ProdCarrito;
import Mobile.Controlador.Controlador;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martin
 */
public class detallePedido extends javax.swing.JInternalFrame {
    DefaultTableModel model;
    int fila = 0;
    ProdCarrito prodC;

    public detallePedido(Pedidos ped) {
        initComponents();
        Controlador c = Controlador.getInstance();
        String id = String.valueOf(ped.getId());
        lblIdPed.setText(id);
        lblCli.setText(ped.getNickUsr());
        lblDir.setText(ped.getDireccion());
        lblEst.setText(ped.getEstado());
        String PTotal = Double.toString(ped.getPrecio_total());
        lblTot.setText(PTotal);
        model = (DefaultTableModel)tblProdPedido.getModel();
        CargarTabla(ped);
    }
    
    
        public void CargarTabla(Pedidos ped){
        Controlador c = Controlador.getInstance();
        ArrayList<Pedidos> lstped= c.getLstPedidos(c.getRestLog());
        Iterator it = lstped.iterator();
        String lista[]=new String[5];
            for (ProdCarrito pc : ped.getColCarrito()){
//                DataCliente dc = ICU.getUsuarioByNickname(ped.getNickUsr());
                
//                String id = String.valueOf(prodC.getId());
                lista[0]= pc.getNomProd();
                String cant = String.valueOf(pc.getCantidad());
                lista[1]= cant;
                if (pc.isPromo()){
                   lista[2]= "Si";
                }
                else{
                    lista[2]= "No";
                }
                String subTot = Double.toString(pc.getPrecio());
                lista[3]= subTot;
                model.insertRow((int)tblProdPedido.getRowCount(), lista);           
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        lblIdPedido = new javax.swing.JLabel();
        lblNickCliente = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane = new javax.swing.JScrollPane();
        tblProdPedido = new javax.swing.JTable();
        lblEstado = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        lblIdPed = new javax.swing.JLabel();
        lblCli = new javax.swing.JLabel();
        lblDir = new javax.swing.JLabel();
        lblEst = new javax.swing.JLabel();
        lblTot = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setMaximumSize(new java.awt.Dimension(320, 480));
        setMinimumSize(new java.awt.Dimension(320, 480));

        lblIdPedido.setText("Id Pedido:");

        lblNickCliente.setText("Cliente:");

        lblDireccion.setText("Dirección:");

        tblProdPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane.setViewportView(tblProdPedido);

        jScrollPane1.setViewportView(jScrollPane);

        lblEstado.setText("Estado:");

        btnEliminar.setText("Dar de Baja el pedido");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jbActualizar.setText("Actualizar el pedido");
        jbActualizar.setFocusable(false);
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jComboBox1.setEditable(true);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar..." }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total:");

        jMenu1.setText("Salir");
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDireccion)
                    .addComponent(lblNickCliente)
                    .addComponent(lblEstado)
                    .addComponent(lblIdPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdPed)
                    .addComponent(lblCli)
                    .addComponent(lblDir)
                    .addComponent(lblEst))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar)
                    .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTot)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdPedido)
                    .addComponent(lblIdPed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNickCliente)
                    .addComponent(lblCli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(lblDir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(lblEst))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTot))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null,"Desea cancelar el pedido?","Confirmación",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            JOptionPane.showMessageDialog(null, "El pedido se ha cancelado con éxito", "Éxito",JOptionPane.WARNING_MESSAGE);
            //ICP.cancelarPedido(this.datped.getId());
        }else{
            JOptionPane.showMessageDialog(null, "El pedido no ha sido cancelado","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }

        this.dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        jComboBox1.setEditable(false);
        jComboBox1.setVisible(true);
        //datped.setEstado(lab01.server.Estados.ENVIADO);

    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        //Estados es = null;
        jComboBox1.setEditable(false);

        if("ENVIADO".equals(jComboBox1.getSelectedItem().toString())){
            //es = Estados.ENVIADO;

        }
        if("RECIBIDO".equals(jComboBox1.getSelectedItem().toString())){
            //es =  Estados.RECIBIDO;
        }
        if(JOptionPane.showConfirmDialog(null,"Desea actualizar el pedido?","Confirmación",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            //ICP.actualizarEPedido(datped.getNickUsr(), datped.getId(), datped.getEstado());
            jComboBox1.removeAllItems();
            jComboBox1.setVisible(false);
            jbActualizar.setEnabled(false);
            //lblEstado.setText(datped.getEstado().toString());

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
        //datped.setEstado(lab01.server.Estados.ENVIADO);

    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JLabel lblCli;
    private javax.swing.JLabel lblDir;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEst;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIdPed;
    private javax.swing.JLabel lblIdPedido;
    private javax.swing.JLabel lblNickCliente;
    private javax.swing.JLabel lblTot;
    private javax.swing.JTable tblProdPedido;
    // End of variables declaration//GEN-END:variables
}
