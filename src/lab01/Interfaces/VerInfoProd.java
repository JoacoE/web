/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Interfaces;

import java.util.Iterator;
import java.util.Map;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lab01.Clases.DataCliente;
import lab01.Clases.Producto;
import lab01.Clases.Individual;
import lab01.Clases.Promocional;
import lab01.Handlers.Fabrica;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataPromocional;
import lab01.Clases.Restaurante;

/**
 *
 * @author martin
 */
public class VerInfoProd extends javax.swing.JFrame {

    /**
     * Creates new form VerIndoProd
     */
    private DataIndividual di = new DataIndividual();
    private DataPromocional dp = new DataPromocional();
    private Restaurante res;
    String nombre;
    boolean promo;
    
    public VerInfoProd(Restaurante r,DataIndividual individual) {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getICtrlProducto();
        modelo = (DefaultTableModel) jTabla.getModel();
        this.txtNomProd.setText(individual.getDataNombre());
        this.txtDescProd.setText(individual.getDataDescripcion());
        this.nombre = this.txtNomProd.getText();
        String precio = Double.toString(individual.getDataPrecio());
        this.txtPrecioProd.setText(precio);
        String stock = String.valueOf(individual.getCantidad());
        this.txtCantidad.setText(stock);
        this.lblEstadoPromo.setVisible(false);
        this.btnGuardar.setVisible(false);
        this.btnGuardar.setEnabled(false);
        this.jcEstado.setVisible(false);
        this.jPanel3.setVisible(false);
        this.tbDescuento.setVisible(false);
        this.lblDescuento.setVisible(false);
        this.di = individual;
        this.res = r;
        this.promo = false;
    }

    public VerInfoProd(DataPromocional promo, Restaurante r){
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getICtrlProducto();
        modelo = (DefaultTableModel) jTabla.getModel();
        this.res = r;
        //this.txtNomProd.enable(false);
        this.txtNomProd.setText(promo.getDataNombre());
        this.txtDescProd.setText(promo.getDataDescripcion());
        this.nombre = this.txtNomProd.getText();

        String precio = Double.toString(promo.getDataPrecio());
        this.txtPrecioProd.setText(precio);
        this.lblCant.setVisible(false);
        this.txtCantidad.setVisible(false);
        this.tbDescuento.setVisible(true);
        this.btnGuardar.setVisible(false);
        this.btnGuardar.setEnabled(false);
        this.lblDescuento.setVisible(true);
        this.tbDescuento.setText(String.valueOf(promo.getDescuento()));
        this.promo = true;
        if (promo.getActiva()) {
            this.jcEstado.addItem("ACTIVA");
        } else {
            this.jcEstado.addItem("INACTIVA");
        }
        cargartabla(promo, r);
    }
    DefaultTableModel modelo;
    private Producto p;
    ICtrlProducto ICP;
    

    private VerInfoProd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNomProd = new javax.swing.JLabel();
        txtNomProd = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblImagenProd = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescProd = new javax.swing.JTextArea();
        txtPrecioProd = new javax.swing.JTextField();
        lblPrecioProd = new javax.swing.JLabel();
        lblCant = new javax.swing.JLabel();
        lblEstadoPromo = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblDescuento = new javax.swing.JLabel();
        tbDescuento = new javax.swing.JTextField();
        jcEstado = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(1, 1, 1));

        lblNomProd.setText("Nombre: ");

        txtNomProd.setEditable(false);
        txtNomProd.setEnabled(false);
        txtNomProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomProdActionPerformed(evt);
            }
        });

        lblDescripcion.setText("Descripción: ");

        lblImagenProd.setText("ACA VA IMAGEN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenProd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        txtDescProd.setEditable(false);
        txtDescProd.setColumns(20);
        txtDescProd.setLineWrap(true);
        txtDescProd.setRows(5);
        txtDescProd.setEnabled(false);
        jScrollPane2.setViewportView(txtDescProd);

        txtPrecioProd.setEditable(false);
        txtPrecioProd.setEnabled(false);

        lblPrecioProd.setText("Precio: ");

        lblCant.setText("Stock:");

        lblEstadoPromo.setText("Estado: ");

        txtCantidad.setEditable(false);
        txtCantidad.setAutoscrolls(false);
        txtCantidad.setEnabled(false);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblDescuento.setText("Descuento:");

        tbDescuento.setEditable(false);
        tbDescuento.setEnabled(false);
        tbDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbDescuentoActionPerformed(evt);
            }
        });

        jcEstado.setForeground(new java.awt.Color(1, 1, 1));
        jcEstado.setToolTipText("");
        jcEstado.setEnabled(false);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(lblNomProd, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEstadoPromo)
                            .addComponent(lblPrecioProd)
                            .addComponent(lblCant)
                            .addComponent(lblDescuento))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomProd, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecioProd, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(tbDescuento)
                    .addComponent(jcEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomProd, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecioProd)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoPromo)
                    .addComponent(jcEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescuento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnEditar)
                    .addComponent(btnGuardar))
                .addGap(32, 32, 32))
        );

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTabla);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargartabla(DataPromocional promo, Restaurante r) {
        Iterator it = promo.getColDatIndividual().entrySet().iterator();
        String lista[] = new String[3];
        while (it.hasNext()) {
            Map.Entry map = (Map.Entry) it.next();
            DataIndividual di = (DataIndividual) map.getValue();
            //lista[0]=model.getSize()-1;
            lista[0] = di.getDataNombre();
            int cant = di.getCantidad();
            String st = Integer.toString(cant);
            lista[1] = st;
            int stock = r.getProducto(di.getDataNombre()).getCantidad();
            lista[2] = String.valueOf(stock);
            modelo.insertRow((int) jTabla.getRowCount(), lista);
        }

    }


    private void txtNomProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomProdActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNomProdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        
        this.txtNomProd.enable(true);
        this.txtNomProd.setEditable(true);
        this.txtDescProd.enable(true);
        this.txtDescProd.setEditable(true);
        this.txtPrecioProd.enable();
        this.txtPrecioProd.setEditable(true);
        this.txtCantidad.enable();
        this.txtCantidad.setEditable(true);
        this.tbDescuento.enable();
        this.tbDescuento.setEditable(true);
        this.jcEstado.enable();
        this.jcEstado.setEditable(true);
        this.jcEstado.addItem("INACTIVA");
        this.btnGuardar.setVisible(true);
        this.btnGuardar.setEnabled(true);
        this.btnEditar.setEnabled(false);
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tbDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDescuentoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        //String nombre = this.txtNomProd.getText();
        if(!this.promo){
            this.di.setDataNombre(this.txtNomProd.getText());
            this.di.setDataDescripcion(this.txtDescProd.getText());
            this.di.setDataPrecio(Double.parseDouble(this.txtPrecioProd.getText()));
            this.di.setCantidad(Integer.parseInt(this.txtCantidad.getText()));
            if(JOptionPane.showConfirmDialog(null, "Desea actualizar el producto?", "Confrimación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                ICP.actualizarIndividual(di,this.nombre , res);
                JOptionPane.showMessageDialog(null, "El producto se ha actualizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }else{
              JOptionPane.showMessageDialog(null, "No se ha actualizado el producto", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            this.dp.setDataNombre(this.txtNomProd.getText());
            this.dp.setDataDescripcion(this.txtDescProd.getText());
            this.dp.setDescuento(Double.parseDouble(this.tbDescuento.getText()));
            String activa = jcEstado.getSelectedItem().toString();
            if(activa.equals("ACTIVA")){
                this.dp.setActiva(true);
            }else{
                this.dp.setActiva(false);
            }
            if(JOptionPane.showConfirmDialog(null, "Desea actualizar el producto?", "Confrimación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                ICP.actualizarPromocional(dp,this.nombre , res);
                JOptionPane.showMessageDialog(null, "El producto se ha actualizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }else{
              JOptionPane.showMessageDialog(null, "No se ha actualizado el producto", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(VerInfoProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerInfoProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerInfoProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerInfoProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerInfoProd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabla;
    private javax.swing.JComboBox jcEstado;
    private javax.swing.JLabel lblCant;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblEstadoPromo;
    private javax.swing.JLabel lblImagenProd;
    private javax.swing.JLabel lblNomProd;
    private javax.swing.JLabel lblPrecioProd;
    private javax.swing.JTextField tbDescuento;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextArea txtDescProd;
    private javax.swing.JTextField txtNomProd;
    private javax.swing.JTextField txtPrecioProd;
    // End of variables declaration//GEN-END:variables
}
