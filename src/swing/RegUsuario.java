/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import lab01.Clases.DataRestaurante;
import lab01.Handlers.Fabrica;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import lab01.Clases.DTOIngresarDatos;
import lab01.Clases.DTORegistrarCliente;
import lab01.Handlers.HImagenes;
import lab01.Interfaces.*;
/**
 *
 * @author gera
 */
public class RegUsuario extends javax.swing.JInternalFrame {
private ICtrlUsuario ICU;
private HImagenes HI;
private HashMap mapCat = new HashMap();
DefaultListModel model;
private boolean clientOrRestaurant;
private ArrayList<File> lstImagen = new ArrayList<>();
private ArrayList<String>  nombresImagenes = new ArrayList<>();
private String nombreImagen = null;
private File img = null;

    public RegUsuario() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getICtrlUsuario();
        HI = HImagenes.getInstance();
        model = new DefaultListModel();
    }
    
    //ButtonGroup buttonGroup1 = new ButtonGroup();
    //JRadioButton rbCliente= new JRadioButton();   
    //JRadioButton rbRestaurante= new JRadioButton();
    //buttonGroup1.add(rbCliente);
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngUsuarios = new javax.swing.ButtonGroup();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbCliente = new javax.swing.JRadioButton();
        rbRestaurante = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        tbMes = new com.toedter.calendar.JMonthChooser();
        tbDia = new com.toedter.components.JSpinField();
        jbSelCategoria = new javax.swing.JButton();
        tbAnio = new com.toedter.calendar.JYearChooser();
        lblFechaNacimiento = new javax.swing.JLabel();
        btnSelImagen = new javax.swing.JButton();
        lblApellido = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblNickname = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        tbApellido = new javax.swing.JTextField();
        tbNombre = new javax.swing.JTextField();
        tbMail = new javax.swing.JTextField();
        tbNickname = new javax.swing.JTextField();
        lblMail = new javax.swing.JLabel();
        tbDireccion = new javax.swing.JTextField();
        lblSelImg = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese el tipo de Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 14))); // NOI18N

        btngUsuarios.add(rbCliente);
        rbCliente.setText("Cliente");
        rbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbClienteMouseClicked(evt);
            }
        });

        btngUsuarios.add(rbRestaurante);
        rbRestaurante.setText("Restaurante");
        rbRestaurante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbRestauranteMouseClicked(evt);
            }
        });
        rbRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRestauranteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbRestaurante)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCliente)
                    .addComponent(rbRestaurante))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese los siguientes datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 14))); // NOI18N

        tbMes.setRequestFocusEnabled(false);

        tbDia.setValue(1);

        jbSelCategoria.setText("Seleccionar Categoria");
        jbSelCategoria.setVisible(false);
        jbSelCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSelCategoriaActionPerformed(evt);
            }
        });

        tbAnio.setValue(1997);

        lblFechaNacimiento.setText("Fecha de Nacimiento:");

        btnSelImagen.setText("Seleccionar imagen");
        btnSelImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelImagenActionPerformed(evt);
            }
        });

        lblApellido.setText("Apellido:");

        lblDireccion.setText("Direccion:");

        lblNickname.setText("Nickname:");

        lblNombre.setText("Nombre:");

        tbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbNombreActionPerformed(evt);
            }
        });

        tbMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbMailActionPerformed(evt);
            }
        });

        tbNickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbNicknameActionPerformed(evt);
            }
        });

        lblMail.setText("Correo electronico:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSelCategoria)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(tbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addComponent(lblSelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tbNickname, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                        .addComponent(tbMail)
                                        .addComponent(tbNombre))
                                    .addComponent(tbDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tbDia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(tbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNickname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(tbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSelImagen)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblSelImg)
                        .addGap(3, 3, 3)))
                .addGap(12, 12, 12)
                .addComponent(jbSelCategoria)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(359, 359, 359)
                        .addComponent(btnRegistrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbNombreActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        String nickname = this.tbNickname.getText();
        String mail = this.tbMail.getText();
        boolean mailok = validateEmail(mail);
        String nombre = this.tbNombre.getText();
        String apellido = (this.tbApellido.getText());
        String direccion = this.tbDireccion.getText();
        int dia = this.tbDia.getValue();
        int mes = this.tbMes.getMonth() + 1;
        int anio = this.tbAnio.getValue();
        String fecha = dia + "/" + mes + "/" + anio;
        DTOIngresarDatos dingresar = new DTOIngresarDatos(nickname, mail, nombre, direccion);
        DTORegistrarCliente dregcliente = new DTORegistrarCliente(apellido, nombreImagen, fecha);
        
        
        
        if(nickname.isEmpty()||mail.isEmpty()||nombre.isEmpty()||direccion.isEmpty())
            JOptionPane.showMessageDialog(null, "No debe haber campos vacios","ERROR",JOptionPane.ERROR_MESSAGE);
        else if (!mailok){
            JOptionPane.showMessageDialog(null, "Mail no válido","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else 
            if(ICU.ingresarDatos(dingresar)){
                if(rbCliente.isSelected()){
                    if (apellido.isEmpty()){
                        JOptionPane.showMessageDialog(null, "No debe haber campos vacios","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                    ICU.registrarCliente(dregcliente);
                    JOptionPane.showMessageDialog(null, "El cliente ha sido registrado","Exito",JOptionPane.INFORMATION_MESSAGE);
                    this.tbNickname.setText("");
                    this.tbMail.setText("");
                    this.tbNombre.setText("");
                    this.tbApellido.setText("");
                    this.tbDireccion.setText("");
                    this.lblSelImg.setText("");
                }}
                else
                    if(rbRestaurante.isSelected()){
                        DataRestaurante dt = new DataRestaurante(nickname, nombre, mail, direccion, nombresImagenes, null, ICU.getLstCat());
                        if(dt.getColCategoria() != null){
                            ICU.registrarRestaurante(dt);
                            JOptionPane.showMessageDialog(null, "El restaurante ha sido registrado","Exito",JOptionPane.INFORMATION_MESSAGE);
                            this.tbNickname.setText("");
                            this.tbMail.setText("");
                            this.tbNombre.setText("");
                            this.tbApellido.setText("");
                            this.tbDireccion.setText("");
                            this.lblSelImg.setText("");
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Debe ingresar al menos una categoria", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Seleccione Cliente o Restaurante","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "El Nickname y/o el E-Mail ya existen.","ERROR",JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSelImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelImagenActionPerformed
        if(rbRestaurante.isSelected()){
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPEG, PNG & GIF", "jpeg", "png", "gif");
            JFileChooser selector = new JFileChooser();
            selector.setMultiSelectionEnabled(true);
            selector.setFileFilter(filtroImagen);
            int r = selector.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                File archivos[] = selector.getSelectedFiles();
                for (int i = 0; i < archivos.length; i++) {
                    String indice = String.valueOf(i);
                    String nuevoNombre = tbNickname.getText().concat(indice);
                    File agregar = archivos[i];
                    lstImagen.add(agregar);
                    nombresImagenes.add(nuevoNombre);
                }
                HI.guardarArrayImg(lstImagen, tbNickname.getText());
            }
        } 
        if(rbCliente.isSelected()){
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPEG, PNG & GIF", "jpeg", "png", "gif");
            JFileChooser selector = new JFileChooser();
            selector.setFileFilter(filtroImagen);
            selector.showOpenDialog(null);
            img = selector.getSelectedFile();
            nombreImagen = tbNickname.getText();
            HI.guardarImagen(img, nombreImagen);
        }
    }//GEN-LAST:event_btnSelImagenActionPerformed

    private void tbNicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbNicknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbNicknameActionPerformed

    private void rbRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRestauranteActionPerformed
       //TODO add your handling code here:
       this.jbSelCategoria.setVisible(true);
    }//GEN-LAST:event_rbRestauranteActionPerformed

    private void rbClienteActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        this.jbSelCategoria.setVisible(false);
    }   
    private void tbMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbMailActionPerformed

    private void rbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbClienteMouseClicked
        // TODO add your handling code here:
        this.jbSelCategoria.setVisible(false);
        
        this.tbDia.setVisible(true);
        this.tbMes.setVisible(true);
        this.tbAnio.setVisible(true);
        this.tbApellido.setVisible(true);
        this.lblApellido.setVisible(true);
        this.lblFechaNacimiento.setVisible(true);
    }//GEN-LAST:event_rbClienteMouseClicked
 
    private void jbSelCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSelCategoriaActionPerformed
    SeleccionarCatReg selCat = new SeleccionarCatReg(mapCat);
    Console.EscritorioMenu.add(selCat);
    selCat.toFront();
    selCat.show();
        
// TODO add your handling code here:
    }//GEN-LAST:event_jbSelCategoriaActionPerformed

    private void rbRestauranteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbRestauranteMouseClicked
        // TODO add your handling code here:
        this.tbDia.setVisible(false);
        this.tbMes.setVisible(false);
        this.tbAnio.setVisible(false);
        this.tbApellido.setVisible(false);
        this.lblApellido.setVisible(false);
        this.lblFechaNacimiento.setVisible(false);
    }//GEN-LAST:event_rbRestauranteMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    
//public class ValidatorUtil {
    
    public static boolean validateEmail(String email){
 
    String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
    /**
     * Validate given email with regular expression.
     * 
     * @param email
     *            email for validation
     * @return true valid email, otherwise false
     */

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }
    
 
//}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSelImagen;
    private javax.swing.ButtonGroup btngUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbSelCategoria;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNickname;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSelImg;
    private javax.swing.JRadioButton rbCliente;
    private javax.swing.JRadioButton rbRestaurante;
    private com.toedter.calendar.JYearChooser tbAnio;
    private javax.swing.JTextField tbApellido;
    private com.toedter.components.JSpinField tbDia;
    private javax.swing.JTextField tbDireccion;
    private javax.swing.JTextField tbMail;
    private com.toedter.calendar.JMonthChooser tbMes;
    private javax.swing.JTextField tbNickname;
    private javax.swing.JTextField tbNombre;
    // End of variables declaration//GEN-END:variables


}
