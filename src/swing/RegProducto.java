/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.event.ItemEvent;
import java.io.File;
import java.util.Map;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import lab01.Clases.DTOArmarPromo;
import lab01.Clases.DTORegistrarProducto;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataRestaurante;
import lab01.Handlers.Fabrica;
import lab01.Handlers.HImagenes;
import lab01.Interfaces.*;
/**
 *
 * @author gonzalo
 */
public class RegProducto extends javax.swing.JInternalFrame {

    private ICtrlProducto CP;
    private ICtrlUsuario ICU;
    private HImagenes HI;
    private String restaurante;
    private String nomProd;
    private String imagen = "";

    public RegProducto() {
        initComponents();
        Fabrica f = Fabrica.getInstance();
        CP = f.getICtrlProducto();
        ICU = f.getICtrlUsuario();
        HI = HImagenes.getInstance();
        cargarCBbox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngProducto = new javax.swing.ButtonGroup();
        btnSelImagen = new javax.swing.JButton();
        jp1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblRest = new javax.swing.JLabel();
        tbNombre = new javax.swing.JTextField();
        tbDesc = new javax.swing.JTextField();
        rbIndividual = new javax.swing.JRadioButton();
        rbPromocional = new javax.swing.JRadioButton();
        tbCantidad = new javax.swing.JTextField();
        lblDesc1 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        tbPrecio = new javax.swing.JTextField();
        jcbRest = new javax.swing.JComboBox();
        btnSeleccionarImagen = new javax.swing.JButton();
        lblDescuento = new javax.swing.JLabel();
        tbDescuento = new javax.swing.JTextField();
        btnRegistro = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        btnSelImagen.setText("Seleccionar imagen");
        btnSelImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelImagenActionPerformed(evt);
            }
        });

        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);

        jp1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo producto"), "Nuevo producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 14))); // NOI18N

        lblNombre.setText("Nombre del producto: ");

        lblCantidad.setText("Cantidad: ");

        lblRest.setText("Restaurante: ");

        btngProducto.add(rbIndividual);
        rbIndividual.setText("Individual");
        rbIndividual.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbIndividualItemStateChanged(evt);
            }
        });
        rbIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbIndividualActionPerformed(evt);
            }
        });

        btngProducto.add(rbPromocional);
        rbPromocional.setText("Promocional");
        rbPromocional.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbPromocionalItemStateChanged(evt);
            }
        });
        rbPromocional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPromocionalActionPerformed(evt);
            }
        });

        tbCantidad.setEnabled(false);

        lblDesc1.setText("Descripción: ");

        lblPrecio.setText("Precio:");

        tbPrecio.setEnabled(false);
        tbPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbPrecioActionPerformed(evt);
            }
        });

        jcbRest.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija un restaurante..." }));

        btnSeleccionarImagen.setText("Seleccionar imagen");
        btnSeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarImagenActionPerformed(evt);
            }
        });

        lblDescuento.setText("Descuento:");

        tbDescuento.setEnabled(false);
        tbDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbDescuentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblCantidad))
                            .addGroup(jp1Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(lblDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jp1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblDesc1)
                                    .addComponent(lblRest)
                                    .addComponent(lblPrecio))))
                        .addGap(18, 18, 18)
                        .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbNombre)
                            .addComponent(tbDesc)
                            .addComponent(jcbRest, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jp1Layout.createSequentialGroup()
                                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 37, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp1Layout.createSequentialGroup()
                                .addComponent(rbIndividual)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbPromocional)
                                .addGap(111, 111, 111))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp1Layout.createSequentialGroup()
                                .addComponent(btnSeleccionarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(305, 305, 305)))))
                .addContainerGap())
        );
        jp1Layout.setVerticalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(tbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDesc1))
                .addGap(18, 18, 18)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRest)
                    .addComponent(jcbRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecio))
                .addGap(11, 11, 11)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescuento)
                    .addComponent(tbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidad)
                    .addComponent(tbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbIndividual)
                    .addComponent(rbPromocional))
                .addGap(18, 18, 18)
                .addComponent(btnSeleccionarImagen)
                .addContainerGap())
        );

        btnRegistro.setText("Registrar");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnRegistro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        boolean Promocional = false;
        double precio;
        double descuento = 0;
        int cantidad;

        if (evt.getSource() == btnRegistro) {
            this.restaurante = (String) jcbRest.getSelectedItem();
            if (CP.existeRestaurante(restaurante)) { // si el restaurante se encuentra registrado
                if (rbIndividual.isSelected()) { // si quiero registar producto individual 
                    try{
                        precio = Double.parseDouble(tbPrecio.getText());
                        cantidad = Integer.parseInt(tbCantidad.getText()); // me guardo la cantidad de productos para ese producto particular
                        DataIndividual di = new DataIndividual(tbNombre.getText(), tbDesc.getText(), precio, cantidad); // me guardo los datos en el dataproducto
                        if(!this.imagen.equals("")){
                            di.setDataImagen(this.imagen);
                        }else{
                            di.setDataImagen("");
                        }
                        DTORegistrarProducto datosi = new DTORegistrarProducto(di, restaurante, Promocional);
                        CP.registrarProducto(datosi); // registro producto
                        JOptionPane.showMessageDialog(null, "Producto registrado con exito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                    }catch(NumberFormatException ex){
                        JOptionPane.showInternalMessageDialog(rootPane, "Debe ingresar datos validos", "Error", JOptionPane.ERROR_MESSAGE);
                        this.tbPrecio.setText("");
                        this.tbCantidad.setText("");
                    }

                } else { // si es promocional
                    if (rbPromocional.isSelected()) {
                        try{
                            descuento = Double.parseDouble(tbDescuento.getText());
                            String control = String.valueOf(descuento);
                            if(control.isEmpty()){
                                JOptionPane.showInternalMessageDialog(rootPane, "Ingrese descuento", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                            }
                            DTOArmarPromo datosp = new DTOArmarPromo(restaurante, tbNombre.getText(), tbDesc.getText(), descuento);
                            if(!this.imagen.equals("")){
                                datosp.setImagen(this.imagen);
                            }else{
                                datosp.setImagen("");
                            }
                            CP.armarPromo(datosp);
                            JOptionPane.showMessageDialog(null, "Promocion registrada con exito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            limpiarCampos();
                        }catch(NumberFormatException ex){
                            JOptionPane.showInternalMessageDialog(rootPane, "Debe ingresar datos validos", "Error", JOptionPane.ERROR_MESSAGE);
                            this.tbDesc.setText("");
                        }
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "El restaurante " + jcbRest.getName() + " no se encuentra registrado", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void rbIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbIndividualActionPerformed
        tbCantidad.setEnabled(true);
        tbDescuento.setEnabled(false);
        tbPrecio.setEnabled(true);
    }//GEN-LAST:event_rbIndividualActionPerformed

    private void rbPromocionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPromocionalActionPerformed
        tbCantidad.setEnabled(false);
        tbDescuento.setEnabled(true);
        tbPrecio.setEnabled(false);
    }//GEN-LAST:event_rbPromocionalActionPerformed

    private void rbPromocionalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbPromocionalItemStateChanged
        // TODO add your handling code here:
        try {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                tbCantidad.setEnabled(false);
                tbDescuento.setEnabled(true);
                String restoran = (String) jcbRest.getSelectedItem();
                ElegirProductos ep = new ElegirProductos(restoran);
                Console.EscritorioMenu.add(ep);
                ep.show();
                ep.toFront();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado restaurante", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_rbPromocionalItemStateChanged

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tbPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbPrecioActionPerformed

    }//GEN-LAST:event_tbPrecioActionPerformed

    private void btnSelImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelImagenActionPerformed

    }//GEN-LAST:event_btnSelImagenActionPerformed

    private void btnSeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarImagenActionPerformed
        if(rbIndividual.isSelected()){
            JFileChooser selector = new JFileChooser();
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPEG, JPG, PNG & GIF", "jpeg", "jpg", "png", "gif");
            selector.setFileFilter(filtroImagen);
            selector.showOpenDialog(null);
            File archivo = selector.getSelectedFile();
            String aux = (String) jcbRest.getSelectedItem();
            this.imagen = aux.concat(this.tbNombre.getText());
            HI.guardarImagen(archivo, this.imagen);
        }
        if(rbPromocional.isSelected()){
            JFileChooser selector = new JFileChooser();
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPEG, JPG, PNG & GIF", "jpeg", "jpg", "png", "gif");
            selector.setFileFilter(filtroImagen);
            selector.showOpenDialog(null);
            File archivo = selector.getSelectedFile();
            String aux = (String) jcbRest.getSelectedItem();
            this.imagen = aux.concat(this.tbNombre.getText());
            HI.guardarImagen(archivo, this.imagen);
        }
    }//GEN-LAST:event_btnSeleccionarImagenActionPerformed

    private void tbDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDescuentoActionPerformed

    private void rbIndividualItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbIndividualItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String rest = (String) jcbRest.getSelectedItem();
            if (rest.equals("Elija un restaurante...")) {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado restaurante", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            tbCantidad.setEnabled(true);
            tbDescuento.setEnabled(false);
        }
    }//GEN-LAST:event_rbIndividualItemStateChanged

    public void limpiarCampos() {
        tbNombre.setText("");
        tbDesc.setText("");
        tbPrecio.setText("");
        tbDescuento.setText("");
        tbCantidad.setText("");
    }

    public void cargarCBbox() {
        Iterator it = ICU.listaDataRestaurantes().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry map = (Map.Entry) it.next();
            DataRestaurante res = (DataRestaurante) map.getValue();
            this.jcbRest.addItem(res.getNickname());
        }
        //String res = (String) jcbRest.getItemAt(WIDTH);
        //this.restaurante = res;
        //this.restaurante = (String)jcbRest.getSelectedItem();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JButton btnSelImagen;
    private javax.swing.JButton btnSeleccionarImagen;
    private javax.swing.ButtonGroup btngProducto;
    private javax.swing.JComboBox jcbRest;
    private javax.swing.JPanel jp1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDesc1;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblRest;
    private javax.swing.JRadioButton rbIndividual;
    private javax.swing.JRadioButton rbPromocional;
    private javax.swing.JTextField tbCantidad;
    private javax.swing.JTextField tbDesc;
    private javax.swing.JTextField tbDescuento;
    private javax.swing.JTextField tbNombre;
    private javax.swing.JTextField tbPrecio;
    // End of variables declaration//GEN-END:variables
}
