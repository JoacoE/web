/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import lab01.server.DataCarrito;
import lab01.server.DataIndividual;
import lab01.server.DataPedido;
import lab01.server.DataPromocional;
import lab01.server.DataRestaurante;
import lab01.server.DtoActualizarIndividual;
import lab01.server.DtoActualizarPromocional;
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
    private DataRestaurante res;
    private ProxyPedido ICPed;
    private String imagen = "";
    String nomprod;
    String nombre;
    boolean promo;
    
    public VerInfoProd(DataIndividual individual, DataRestaurante dr) {
        initComponents();
        ICPed = ProxyPedido.getInstance();
        ICP = ProxyProducto.getInstance();
        modelo = (DefaultTableModel) jTabla.getModel();
        modelo2 = (DefaultTableModel) jTablaPedidos.getModel();
        imagen = individual.getDataImagen();
        if(!individual.getDataImagen().equals("")){
//            ImageIcon icon = new ImageIcon(HI.getImagen(individual.getDataImagen()).getAbsolutePath());
//            this.lblImagen.setIcon(icon);
//            this.lblImagen.setVisible(true);
        }else{
//            this.lblImagen.setIcon(HI.getNoImage());
//            this.lblImagen.setVisible(true);
        }
        this.nomprod = individual.getDataNombre();
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
        this.jbImagen.setEnabled(false);
        this.jbImagen.setVisible(false);
        this.jcEstado.setVisible(false);
        this.jPanel3.setVisible(false);
        this.tbDescuento.setVisible(false);
        this.lblDescuento.setVisible(false);
        this.di = individual;
        this.res = dr;
        this.promo = false;
        if(!cargarTablaPedidos()){
            this.jTablaPedidos.setEnabled(false);
        }
    }

    public VerInfoProd(DataPromocional promo, DataRestaurante dr){
        initComponents();
        ICPed = ProxyPedido.getInstance();
        ICP = ProxyProducto.getInstance();
        modelo = (DefaultTableModel) jTabla.getModel();
        modelo2 = (DefaultTableModel) jTablaPedidos.getModel();
        this.res = dr;
        imagen = promo.getDataImagen();
        if(!promo.getDataImagen().equals("")){
//            ImageIcon icon = new ImageIcon(HI.getImagen(promo.getDataImagen()).getAbsolutePath());
//            this.lblImagen.setIcon(icon);
//            this.lblImagen.setVisible(true);
        }else{
//            this.lblImagen.setIcon(HI.getNoImage());
//            this.lblImagen.setVisible(true);
        }
        this.nomprod = promo.getDataNombre();
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
        this.jbImagen.setEnabled(false);
        this.jbImagen.setVisible(false);
        this.lblDescuento.setVisible(true);
        this.tbDescuento.setText(String.valueOf(promo.getDataDescuento()));
        this.promo = true;
        if (promo.isDataActiva()) {
            this.jcEstado.addItem("ACTIVA");
        } else {
            this.jcEstado.addItem("INACTIVA");
        }
        cargartabla(promo, dr);
        if(!cargarTablaPedidos()){
            this.jTablaPedidos.setEnabled(false);
        }
    }
    DefaultTableModel modelo;
    DefaultTableModel modelo2;
    ProxyProducto ICP;
    

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
        lblDescuento = new javax.swing.JLabel();
        tbDescuento = new javax.swing.JTextField();
        jcEstado = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablaPedidos = new javax.swing.JTable();
        lblImagen = new javax.swing.JLabel();
        jbImagen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(759, 393));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion del producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 14))); // NOI18N
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(jcEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de promocion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 14))); // NOI18N

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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jTablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Usuario", "Precio Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTablaPedidos);

        jbImagen.setText("Seleccionar Imagen");
        jbImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbImagen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(76, 76, 76)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbImagen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar)
                            .addComponent(btnGuardar)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargartabla(DataPromocional promo, DataRestaurante r) {
        Iterator it = promo.getColDatIndividual().iterator();
        String lista[] = new String[3];
        while (it.hasNext()) {
            DataIndividual di = (DataIndividual)it.next();
            lista[0] = di.getDataNombre();
            int cant = di.getCantidad();
            String st = Integer.toString(cant);
            lista[1] = st;
            /*Iterator dprods = r.getColProducto().entrySet().iterator();
            while(dprods.hasNext()){
                Map.Entry dprod = (Map.Entry) dprods.next();
                if(dprod.getValue() instanceof DataIndividual){
                    DataIndividual dind = (DataIndividual)dprod.getValue();
                    if(dind.getDataNombre().equals(di.getDataNombre())){
                        lista[2] = String.valueOf(dind.getCantidad());
                    }
                }
            }*/
            modelo.insertRow((int) jTabla.getRowCount(), lista);
        }
    }
    
    public boolean cargarTablaPedidos(){
        Iterator dpedidos = ICPed.listDataPedidos().iterator();
        String list[] = new String[3];
        while(dpedidos.hasNext()){
            DataPedido datp = (DataPedido)dpedidos.next();
            for(DataCarrito dc: datp.getColCarrito()){
                if(dc.getNomProd().equals(this.nomprod)){
                    list[0] = datp.getFecha();
                    list[1] = datp.getNickUsr();
                    String ptotal = Double.toString(datp.getPrecioTotal());
                    list[2] = ptotal;
                    modelo2.insertRow((int) jTablaPedidos.getRowCount(), list);
                    return true;
                }
            }
        }
        return false;
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
        if(!this.promo){
            this.txtNomProd.enable(true);
            this.txtNomProd.setEditable(true);
            this.txtDescProd.enable(true);
            this.txtDescProd.setEditable(true);
            this.txtPrecioProd.enable();
            this.txtPrecioProd.setEditable(true);
            this.txtCantidad.enable();
            this.txtCantidad.setEditable(true);
            this.btnGuardar.setVisible(true);
            this.btnGuardar.setEnabled(true);
            this.btnEditar.setEnabled(false);
            this.jbImagen.setEnabled(true);
            this.jbImagen.setVisible(true);
        }else{
            this.txtNomProd.enable(true);
            this.txtNomProd.setEditable(true);
            this.txtDescProd.enable(true);
            this.txtDescProd.setEditable(true);
            this.tbDescuento.enable();
            this.tbDescuento.setEditable(true);
            this.jcEstado.enable();
            this.jcEstado.setEditable(true);
            this.jcEstado.addItem("INACTIVA");
            this.btnGuardar.setVisible(true);
            this.btnGuardar.setEnabled(true);
            this.btnEditar.setEnabled(false);
            this.jbImagen.setEnabled(true);
            this.jbImagen.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tbDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDescuentoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        //String nombre = this.txtNomProd.getText();
        if(!this.promo){
            try{
                this.di.setDataNombre(this.txtNomProd.getText());
                this.di.setDataDescripcion(this.txtDescProd.getText());
                this.di.setDataPrecio(Double.parseDouble(this.txtPrecioProd.getText()));
                this.di.setCantidad(Integer.parseInt(this.txtCantidad.getText()));
                if(JOptionPane.showConfirmDialog(null, "Desea actualizar el producto?", "Confrimación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                    DtoActualizarIndividual datosi = new DtoActualizarIndividual();
                    datosi.setDi(di);
                    datosi.setNombre(this.nombre);
                    datosi.setNickRest(res.getNickname());
//                    if(HI.getImagen(imagen).exists()){
//                        datosi.setImagen(imagen);
//                        ICP.actualizarIndividual(datosi);
//                    }else{
                        datosi.setImagen(imagen);
                        ICP.actualizarIndividual(datosi);
                    //}
                    JOptionPane.showMessageDialog(null, "El producto se ha actualizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha actualizado el producto", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(NumberFormatException ex){
                JOptionPane.showInternalMessageDialog(rootPane, "Debe ingresar datos validos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            try{
                this.dp.setDataNombre(this.txtNomProd.getText());
                this.dp.setDataDescripcion(this.txtDescProd.getText());
                this.dp.setDataDescuento(Double.parseDouble(this.tbDescuento.getText()));
                String activa = jcEstado.getSelectedItem().toString();
                if(activa.equals("ACTIVA")){
                    this.dp.setDataActiva(true);
                }else{
                    this.dp.setDataActiva(false);
                }
                if(JOptionPane.showConfirmDialog(null, "Desea actualizar el producto?", "Confrimación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                    DtoActualizarPromocional datosp = new DtoActualizarPromocional();
                    datosp.setDp(dp);
                    datosp.setNombre(this.nombre);
                    datosp.setNickRest(res.getNickname());
//                    if(HI.getImagen(imagen).exists()){
//                        datosp.setImagen(imagen);
//                        ICP.actualizarPromocional(datosp);
//                    }else{
                        datosp.setImagen(imagen);
                        ICP.actualizarPromocional(datosp);
                    //}
                    JOptionPane.showMessageDialog(null, "El producto se ha actualizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha actualizado el producto", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(NumberFormatException ex){
                JOptionPane.showInternalMessageDialog(rootPane, "Debe ingresar datos validos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jbImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImagenActionPerformed
        // TODO add your handling code here:
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPEG, JPG, PNG & GIF", "jpeg", "jpg", "png", "gif");
        selector.setFileFilter(filtroImagen);
        selector.showOpenDialog(null);
        File archivo = selector.getSelectedFile();
        String aux = res.getNickname();
        this.imagen = aux.concat(this.txtNomProd.getText());
//        HI.guardarImagen(archivo, this.imagen);
//        ImageIcon icon = new ImageIcon(HI.getImagen(imagen).getAbsolutePath());
//        this.lblImagen.setIcon(icon);
//        this.lblImagen.setVisible(true);
    }//GEN-LAST:event_jbImagenActionPerformed

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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTabla;
    private javax.swing.JTable jTablaPedidos;
    private javax.swing.JButton jbImagen;
    private javax.swing.JComboBox jcEstado;
    private javax.swing.JLabel lblCant;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblEstadoPromo;
    private javax.swing.JLabel lblImagen;
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
