/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swing;

import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import lab01.Handlers.Fabrica;
import java.util.Map;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import lab01.Clases.DataCategoria;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataPromocional;
import lab01.Clases.DataRestaurante;
import lab01.Handlers.HImagenes;
import lab01.Interfaces.*;

/**
 *
 * @author admin123
 */

public class VerRestaurante extends javax.swing.JInternalFrame {
    private ICtrlUsuario ICU; 
    private ICtrlProducto CP;
    private HImagenes HI;
    private String nickname;
    private int max;
    /**
     * Creates new form VerCliente
     */

    public VerRestaurante(String restau) {
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getICtrlUsuario();
        CP = fabrica.getICtrlProducto();
        HI = HImagenes.getInstance();
        max = (HI.getArrayImg(restau).size()) - 1;
        initComponents();
        this.tbNickNameCliente.setVisible(false);
        this.tbdireccionCliente.setVisible(false);
        this.tbmailCliente.setVisible(false);
        this.tbnombreCliente.setVisible(false);
        this.lblNicknameCliente.setVisible(false);
        this.lbldireccionCliente.setVisible(false);
        this.lblmailCliente.setVisible(false);
        this.lblnombreCliente.setVisible(false);
        model = new DefaultListModel();
        modelProd = new DefaultListModel();
        this.client=restau;
        DataRestaurante c = ICU.getRestauranteByNickname(client);
        verRest();
        CargarLista(c);   
    }
    DefaultListModel model;
    DefaultListModel modelProd;
    String client;
    //Restaurante c = ICU.getRestauranteByNickname(client);
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    public void verRest(){
        DataRestaurante c = ICU.getRestauranteByNickname(client);
        this.tbNickNameCliente.setVisible(true);
        this.tbNickNameCliente.setText(c.getNickname());
        this.nickname = c.getNickname();
        this.tbdireccionCliente.setVisible(true);
        this.tbdireccionCliente.setText(c.getDireccion());
        this.tbmailCliente.setVisible(true);
        this.tbmailCliente.setText(c.getEmail());
        this.tbnombreCliente.setVisible(true);
        this.tbnombreCliente.setText(c.getNombre());
        this.lblNicknameCliente.setVisible(true);
        if(c.getLstImagen() != null){
            ArrayList<File> imagen = HI.getArrayImg(c.getNickname());
            max = imagen.size();
            if(max > 1){
                this.jSlider = new JSlider();
                this.jSlider.setMaximum(max);
                this.jSlider.setPaintTicks(true);
                this.jSlider.setVisible(true);
            }else{
                this.jSlider.setEnabled(false);
                this.jSlider.setVisible(false);
            }
            ImageIcon icon = new ImageIcon(imagen.get(0).getAbsolutePath());
            this.lblImagenes.setIcon(icon);
            this.lblImagenes.setVisible(true);
        }else{
            this.lblImagenes.setIcon(HI.getNoImage());
            this.lblImagenes.setVisible(true);
            this.jSlider.setEnabled(false);
            this.jSlider.setVisible(false);
        }
        this.lblmailCliente.setVisible(true);
        this.lblnombreCliente.setVisible(true);
        model.clear();
        Map cats = c.getColCategoria();
        Iterator it = cats.entrySet().iterator();
        //Iterator itret = ret.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            DataCategoria dc = (DataCategoria)map.getValue();
            model.addElement(dc.getNombre());
        }
        this.jlCat.setModel(model);
    }
    
    public void CargarLista(DataRestaurante c){
        if(!c.getColProducto().isEmpty()){
            Iterator it = c.getColProducto().entrySet().iterator();
            while(it.hasNext()){
                Map.Entry map = (Map.Entry) it.next();
                if(map.getValue() instanceof DataIndividual){
                    DataIndividual di = (DataIndividual)map.getValue();
                    modelProd.addElement(di.getDataNombre());
                }
                if(map.getValue() instanceof DataPromocional){
                    DataPromocional dp = (DataPromocional)map.getValue();
                    modelProd.addElement(dp.getDataNombre());
                }
            }
            this.jListProd.setModel(modelProd);
        }else{
            this.jListProd.setEnabled(false);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlCat = new javax.swing.JList();
        lblNicknameCliente = new javax.swing.JLabel();
        tbdireccionCliente = new javax.swing.JTextField();
        tbnombreCliente = new javax.swing.JTextField();
        tbmailCliente = new javax.swing.JTextField();
        tbNickNameCliente = new javax.swing.JTextField();
        lblmailCliente = new javax.swing.JLabel();
        lbldireccionCliente = new javax.swing.JLabel();
        lblnombreCliente = new javax.swing.JLabel();
        lblCatRestaurante = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListProd = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jSlider = new javax.swing.JSlider();
        lblImagenes = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(690, 676));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion del restaurante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 14))); // NOI18N

        jlCat.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jlCat);

        lblNicknameCliente.setText("NickName:");

        tbdireccionCliente.setEditable(false);

        tbnombreCliente.setEditable(false);

        tbmailCliente.setEditable(false);

        tbNickNameCliente.setEditable(false);

        lblmailCliente.setText("Correo electronico:");

        lbldireccionCliente.setText("Direccion:");

        lblnombreCliente.setText("Nombre:");

        lblCatRestaurante.setText("Categorias:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblmailCliente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnombreCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbldireccionCliente, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCatRestaurante, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNicknameCliente, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbnombreCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tbmailCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(tbdireccionCliente, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tbNickNameCliente))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbNickNameCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNicknameCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmailCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbnombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnombreCliente))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbdireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldireccionCliente))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(lblCatRestaurante)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos del restaurante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 14))); // NOI18N

        jListProd.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProdMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListProd);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSlider.setMajorTickSpacing(1);
        jSlider.setMaximum(max);
        jSlider.setPaintTicks(true);
        jSlider.setSnapToTicks(true);
        jSlider.setValue(0);
        jSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(228, 228, 228))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addGap(82, 82, 82)
                        .addComponent(lblImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 216, Short.MAX_VALUE))
                    .addComponent(lblImagenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProdMouseClicked
        // TODO add your handling code here:
        DataRestaurante c = ICU.getRestauranteByNickname(client);
        String prod = jListProd.getSelectedValue().toString();
        Iterator dprods = c.getColProducto().entrySet().iterator();
        while(dprods.hasNext()){
            Map.Entry dprod = (Map.Entry) dprods.next();
            if(dprod.getValue() instanceof DataIndividual){
                DataIndividual di = (DataIndividual)dprod.getValue();
                if(di.getDataNombre().equals(prod)){
                    VerInfoProd verProd = new VerInfoProd(di, c);
                    verProd.show();
                }
            }
            if(dprod.getValue() instanceof DataPromocional){
                DataPromocional dp = (DataPromocional)dprod.getValue();
                if(dp.getDataNombre().equals(prod)){
                    VerInfoProd verProd = new VerInfoProd(dp, c);
                    verProd.show();
                }
            }
        }
    }//GEN-LAST:event_jListProdMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
       
    private void jSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderStateChanged
        // TODO add your handling code here:
        ArrayList<File> imagenes = HI.getArrayImg(this.nickname);
        JSlider source = (JSlider)evt.getSource();
        this.jSlider.setMaximum(max);
        this.jSlider.setPaintTicks(true);
        this.jSlider.setVisible(true);
        int posicion = (int)source.getValue();
        ImageIcon icons = new ImageIcon(imagenes.get(posicion).getAbsolutePath());
        this.lblImagenes.setIcon(icons);
        this.lblImagenes.setVisible(true);
    }//GEN-LAST:event_jSliderStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JList jListProd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider;
    private javax.swing.JList jlCat;
    private javax.swing.JLabel lblCatRestaurante;
    private javax.swing.JLabel lblImagenes;
    private javax.swing.JLabel lblNicknameCliente;
    private javax.swing.JLabel lbldireccionCliente;
    private javax.swing.JLabel lblmailCliente;
    private javax.swing.JLabel lblnombreCliente;
    private javax.swing.JTextField tbNickNameCliente;
    private javax.swing.JTextField tbdireccionCliente;
    private javax.swing.JTextField tbmailCliente;
    private javax.swing.JTextField tbnombreCliente;
    // End of variables declaration//GEN-END:variables

 
}
