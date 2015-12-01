package Mobile;

import Mobile.Clases.Pedidos;
import Mobile.Clases.ProdCarrito;
import Mobile.Controlador.Controlador;
import static Mobile.Home.jDesktopPane1;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import lab01.server.Estados;


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
    Pedidos p;
private Home h;
    public detallePedido(Pedidos ped, Home h) {
        initComponents();
        this.h=h;
        this.h.existeconexion();
        Controlador c = Controlador.getInstance();
        String id = String.valueOf(ped.getId());
        lblIdPed.setText(id);
        lblCli.setText(ped.getNickUsr());
        lblDir.setText(ped.getDireccion());
        lblEst.setText(ped.getEstado());
        String PTotal = Double.toString(ped.getPrecio_total());
        lblTot.setText(PTotal);
        p = ped;
        model = (DefaultTableModel)tblProdPedido.getModel();
        CargarTabla(ped);
        actualizarEstado(ped);
    }
    
    
        public void CargarTabla(Pedidos ped){
        Controlador c = Controlador.getInstance();
        ArrayList<Pedidos> lstped= c.getPeds();
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
        jComboBox1.setVisible(false);
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
        jbActualizar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        lblIdPed = new javax.swing.JLabel();
        lblCli = new javax.swing.JLabel();
        lblDir = new javax.swing.JLabel();
        lblEst = new javax.swing.JLabel();
        lblTot = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setMaximumSize(new java.awt.Dimension(313, 414));
        setMinimumSize(new java.awt.Dimension(313, 414));
        setPreferredSize(new java.awt.Dimension(313, 414));

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

        jbActualizar.setText("Actualizar pedido");
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

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(lblEst)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTot))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblTot)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        //actualizarEstado();
        jComboBox1.setEditable(false);
        jComboBox1.setVisible(true);
        //datped.setEstado(lab01.server.Estados.ENVIADO);

    }//GEN-LAST:event_jbActualizarActionPerformed
    public void actualizarEstado(Pedidos ped){
        if ("PREPARACION".equals(ped.getEstado())){
            jComboBox1.addItem("ENVIADO");
            jComboBox1.addItem("RECIBIDO");
            
        }else{
             if("ENVIADO".equals(ped.getEstado())){
                 jComboBox1.addItem("RECIBIDO");
             }
            if("RECIBIDO".equals(ped.getEstado())){
                 jbActualizar.setEnabled(false);
             }
         }
    }
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        Estados es = null;
        jComboBox1.setEditable(false);
        Controlador c = Controlador.getInstance();
        if("ENVIADO".equals(jComboBox1.getSelectedItem().toString())){
            es = Estados.ENVIADO;

        }
        if("RECIBIDO".equals(jComboBox1.getSelectedItem().toString())){
            es =  Estados.RECIBIDO;
        }
        if(JOptionPane.showInternalConfirmDialog(jDesktopPane1,"Desea actualizar el pedido?","Confirmación",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            //ICP.actualizarEPedido(datped.getNickUsr(), datped.getId(), datped.getEstado());
            jComboBox1.removeAllItems();
            jComboBox1.setVisible(false);
            jbActualizar.setEnabled(false);
            c.actualizarEstadoPed(p, es.toString());
            JOptionPane.showInternalMessageDialog(jDesktopPane1, "El pedido se ha actualizado","Informacion",JOptionPane.INFORMATION_MESSAGE);
            //lblEstado.setText(datped.getEstado().toString());
            this.setVisible(false);
            listaPedidos l = new listaPedidos(h);
            l.setLocation(0, 150);
            Home.jDesktopPane1.add(l);
            l.show();
        }else{
            JOptionPane.showInternalMessageDialog(jDesktopPane1, "El pedido no se ha actualizado","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }

        if(jComboBox1.getItemCount() !=1){
            jComboBox1.removeAllItems();
            jComboBox1.setEnabled(false);
        }
        SwingUtilities.updateComponentTreeUI(this);
        this.revalidate();
        this.repaint();
        //actualizarEstado();
        //datped.setEstado(lab01.server.Estados.ENVIADO);

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        listaPedidos l = new listaPedidos(h);
        l.setLocation(0, 150);
        Home.jDesktopPane1.add(l);
        l.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Controlador c = Controlador.getInstance();
        c.cerrarSesion();
        this.setVisible(false);
        login l = new login(h);
        l.setLocation(40, 150);
        Home.jDesktopPane1.add(l);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
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
