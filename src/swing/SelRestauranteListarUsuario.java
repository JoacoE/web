/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JTree;
import lab01.Handlers.Fabrica;
import lab01.Clases.DataCategoria;
import lab01.Interfaces.*;
/**
 *
 * @author gera
 */
public class SelRestauranteListarUsuario extends javax.swing.JInternalFrame {
    private ICtrlUsuario ICU;
        
    
    //DefaultTreeModel modelo;
    public SelRestauranteListarUsuario() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getICtrlUsuario();
        //modelo = (DefaultTreeModel) treeCat.getModel();
        modelRest = new DefaultListModel();
        Raiz = new DefaultMutableTreeNode("Categorias");
        modelo = new DefaultTreeModel(Raiz);
        JTree tree = new JTree(modelo);
        this.cargarTree();
        //this.cargarRestaurantesTree();
    }
    DefaultListModel modelRest;
    DefaultMutableTreeNode Raiz;// = new DefaultMutableTreeNode("Restaurantes");
    DefaultTreeModel modelo; //= new DefaultTreeModel(Raiz);


    
    public void cargarTree(){
        if (Raiz != null){
            Iterator itC = ICU.retColCat().entrySet().iterator();
            while(itC.hasNext()){
                Map.Entry mapC = (Map.Entry) itC.next();
                DataCategoria cat= (DataCategoria)mapC.getValue();
                DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(cat.getNombre());
                modelo.insertNodeInto(nodo, Raiz, 0);
                Map Crest = ICU.listaUsuPorCategoria(cat.getNombre());
                if(Crest.isEmpty()){
                    DefaultMutableTreeNode vacio = new DefaultMutableTreeNode("Sin restaurantes");
                    modelo.insertNodeInto(vacio, nodo, 0);
                }
                else{
                    Iterator itR = Crest.entrySet().iterator();
                    while(itR.hasNext()){
                        Map.Entry mapR = (Map.Entry) itR.next();
                        String c= (String)mapR.getKey();
                        DefaultMutableTreeNode Res = new DefaultMutableTreeNode(c);
                        modelo.insertNodeInto(Res, nodo, 0);
                    }
                }
            }  
            this.treeCat.setModel(modelo);
        }
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeCat = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione un restaurante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 14))); // NOI18N

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Categorias");
        treeCat.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeCat.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeCatValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(treeCat);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void treeCatValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeCatValueChanged
        // TODO add your handling code here:
        try{
        DefaultMutableTreeNode sel = (DefaultMutableTreeNode)treeCat.getLastSelectedPathComponent();
        String rest = (String)sel.getUserObject(); 
        ListarProductosRestaurante verP = new ListarProductosRestaurante(rest);
            Console.EscritorioMenu.add(verP);
            verP.show();
            this.dispose();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La categoria seleccionada no tiene restaurantes", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_treeCatValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree treeCat;
    // End of variables declaration//GEN-END:variables
}
