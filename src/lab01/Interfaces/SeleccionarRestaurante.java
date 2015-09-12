/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Interfaces;

import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JTree;
import lab01.Clases.DataRestaurante;
import lab01.Clases.Restaurante;
import lab01.Clases.Usuario;
import lab01.Handlers.Fabrica;
import lab01.Clases.Categoria;
import lab01.Clases.DataCategoria;

/**
 *
 * @author gera
 */
public class SeleccionarRestaurante extends javax.swing.JInternalFrame {
    private ICtrlUsuario ICU;
        
    
    //DefaultTreeModel modelo;
    public SeleccionarRestaurante() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getICtrlUsuario();
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
        Map Ccat=ICU.retColCat();    
        if (Raiz != null){
            Iterator itC = Ccat.entrySet().iterator();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        treeCat = new javax.swing.JTree();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Categorias");
        treeCat.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeCat.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeCatValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(treeCat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
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
        DefaultMutableTreeNode sel = (DefaultMutableTreeNode)treeCat.getLastSelectedPathComponent();
        String rest = (String)sel.getUserObject(); 
        VerRestaurante verR = new VerRestaurante(rest);
            Console.EscritorioMenu.add(verR);
            verR.show();
            this.dispose();
    }//GEN-LAST:event_treeCatValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree treeCat;
    // End of variables declaration//GEN-END:variables
}
