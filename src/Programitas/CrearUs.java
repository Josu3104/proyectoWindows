/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Programitas;

import BRAIN.FolderManager;

import HOME.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Josue Gavidia
 */
public class CrearUs extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    static String user;
    static String pass;
    protected RandomAccessFile Acc;
    public CrearUs()throws IOException {
        
        Acc = new RandomAccessFile("users/usuarios.sop","rw") ;
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserCreator = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        US = new javax.swing.JTextField();
        PASS = new javax.swing.JTextField();
        CreateUserFolders = new javax.swing.JButton();

        setClosable(true);
        setTitle("Crearu Usuario");
        setToolTipText("");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        UserCreator.setBackground(new java.awt.Color(0, 102, 0));
        UserCreator.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Usuario");
        UserCreator.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Contraseña");
        UserCreator.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        US.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USActionPerformed(evt);
            }
        });
        UserCreator.add(US, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 217, -1));
        UserCreator.add(PASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 217, -1));

        CreateUserFolders.setBackground(new java.awt.Color(0, 0, 0));
        CreateUserFolders.setForeground(new java.awt.Color(255, 255, 255));
        CreateUserFolders.setText("Crear Usuario");
        CreateUserFolders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateUserFoldersActionPerformed(evt);
            }
        });
        UserCreator.add(CreateUserFolders, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(UserCreator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(UserCreator, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void USActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_USActionPerformed

    private void CreateUserFoldersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateUserFoldersActionPerformed
        user = US.getText();
        pass = PASS.getText();
        
        try {
            if(crearAccount(user,pass)){
                JOptionPane.showMessageDialog(this, "Usuario creado exitosamente");
            }else{
                 JOptionPane.showMessageDialog(this, "Usuario no creado, ha ocurrido un error");
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }//GEN-LAST:event_CreateUserFoldersActionPerformed

    public void crearFolderAccount(String user)throws IOException {
        File AccFolder = new File("Z/" + user);
        AccFolder.mkdir();
        File documentos = new File(AccFolder, "Documentos");
        documentos.mkdir();
        File musica = new File(AccFolder, "Musica");
        musica.mkdir();
        File imagenes = new File(AccFolder, "Imagenes");
        imagenes.mkdir();
        
    }
    
    public void writeAccount(String us, String pw)throws IOException{
        //Formato: String username, String password
        Acc.seek(Acc.length());
        Acc.writeUTF(us);
        Acc.writeUTF(pw);
        
    }
    
    public boolean verificarUnico(String us)throws IOException{
        Acc.seek(0);
        while(Acc.getFilePointer()<Acc.length()){
            if(Acc.readUTF().equals(us)){
                return false;
            }
            Acc.readUTF();
        }
        return true;
    }
    
     public boolean LogInAcc(String us,String pass)throws IOException{
        Acc.seek(0);
        while(Acc.getFilePointer()<Acc.length()){
            if(Acc.readUTF().equals(us)){
                if(Acc.readUTF().equals(pass)){
                     return true;
                }else{
                        return false;
                }
               
            }
            Acc.readUTF();
        }
        return false;
    }
   
    public boolean crearAccount(String username, String pass) throws IOException{
        if(verificarUnico(username)){
            writeAccount(username,pass);
            crearFolderAccount(username);
            return true;
        }
        return false;
    }
    


    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Desktop.userCreated = true;
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateUserFolders;
    private javax.swing.JTextField PASS;
    private javax.swing.JTextField US;
    private javax.swing.JPanel UserCreator;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
