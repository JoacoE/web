/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JTree;
import lab01.server.DataCategoria;
import lab01.server.DataRestaurante;
/**
 *
 * @author gera
 */
public class SeleccionarRestaurantePed extends javax.swing.JInternalFrame {
    private ProxyUsuario ICU;
        
    
    //DefaultTreeModel modelo;
    public SeleccionarRestaurantePed() {
        initComponents();
        ICU = ProxyUsuario.getInstance();
        //modelo = (DefaultTreeModel) treeCat.getModel();
        modelRest = new DefaultListModel();
        Raiz = new DefaultMutableTreeNode("Restaurantes");
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
            for (DataCategoria cat : ICU.retColCat()) {
                DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(cat.getNombre());
                modelo.insertNodeInto(nodo, Raiz, 0);
                ArrayList<DataRestaurante> Crest = ICU.listaUsuPorCategoria(cat.getNombre());
                if(Crest.isEmpty()){
                    DefaultMutableTreeNode vacio = new DefaultMutableTreeNode("Sin restaurantes");
                    modelo.insertNodeInto(vacio, nodo, 0);
                }
                else{
                    for (DataRestaurante dt : Crest) {
                        DefaultMutableTreeNode Res = new DefaultMutableTreeNode(dt.getNickname());
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void treeCatValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeCatValueChanged
        // TODO add your handling code here:
        DefaultMutableTreeNode sel = (DefaultMutableTreeNode)treeCat.getLastSelectedPathComponent();
        String rest = (String)sel.getUserObject(); 
        VerRestaurante verR = new VerRestaurante(rest);
            Console.EscritorioMenu.add(verR);
            verR.show();
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
