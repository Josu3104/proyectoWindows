package Visualizador;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Visualizador extends javax.swing.JFrame {

    ImageIcon Images[] = new ImageIcon[10];
    byte[] image;
    String imagepath = "";
    ImageIcon myimage;
    int contador = 0;
    private boolean nuevaImagenSeleccionada = false;

    public Visualizador() {
        initComponents();
        this.setTitle("Visor de imagenes");
        for (int a = 0; a < 10; a++) {
            Images[a] = new ImageIcon(getClass().getResource("/visualizador/Imagenes/image" + (a+1) + ".jpg"));
        }

        jLabel1.setIcon(Images[0]);
        jlabel_actual.setIcon(Images[0]);

        jLabelPrev.setIcon(Images[9]);
        jLabelNext.setIcon(Images[(1)]);
    }

    public ImageIcon secticon(String m, byte[] image) {
        if (m != null) {
            myimage = new ImageIcon(m);

        } else {
            myimage = new ImageIcon(image);
        }
        Image img1 = myimage.getImage();
        Image img2 = img1.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(img2);
        return i;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_atras = new javax.swing.JButton();
        btn_despues = new javax.swing.JButton();
        jLabelPrev = new javax.swing.JLabel();
        jlabel_actual = new javax.swing.JLabel();
        jLabelNext = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 5, true));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 470, 300));

        btn_atras.setBackground(new java.awt.Color(255, 255, 255));
        btn_atras.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(0, 0, 0));
        btn_atras.setText("Atrás");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, -1, -1));

        btn_despues.setBackground(new java.awt.Color(255, 255, 255));
        btn_despues.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_despues.setForeground(new java.awt.Color(0, 0, 0));
        btn_despues.setText("Siguiente");
        btn_despues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_despuesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_despues, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 450, -1, -1));

        jLabelPrev.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrev.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 5));
        getContentPane().add(jLabelPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 210, 150));

        jlabel_actual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabel_actual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 5));
        getContentPane().add(jlabel_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 210, 150));

        jLabelNext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 5));
        getContentPane().add(jLabelNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 390, 210, 150));

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buscar.setForeground(new java.awt.Color(0, 0, 0));
        buscar.setText("Buscar Foto");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visualizador/fondoimage.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_despuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_despuesActionPerformed
        if (!nuevaImagenSeleccionada) {
            contador++;
            if (contador == 10) {
                contador = 0;
            }
            jLabel1.setIcon(Images[contador]);
            jlabel_actual.setIcon(Images[contador]);
            int prev = contador-1==-1?9:contador-1;
            jLabelPrev.setIcon(Images[prev]);
            int sig = contador+1==10?0:contador+1;
            jLabelNext.setIcon(Images[sig]);
        }
        nuevaImagenSeleccionada = false;
    }//GEN-LAST:event_btn_despuesActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        if (!nuevaImagenSeleccionada) {
            contador--;
            if (contador == -1) {
                contador = 9;
            }

            jLabel1.setIcon(Images[contador]);
            jlabel_actual.setIcon(Images[contador]);
            if (contador == 0) {
                jLabelPrev.setIcon(Images[9]);
                jLabelNext.setIcon(Images[1]);
            } else {
                jLabelPrev.setIcon(Images[contador-1]);
                jLabelNext.setIcon(Images[(contador+1)%10]);
            }
            nuevaImagenSeleccionada = false;
        }

    }//GEN-LAST:event_btn_atrasActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try {
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File("C:\\Users\\Josue Gavidia\\Documents\\NetBeansProjects\\ProyectoWindows\\src\\visualizador\\Imagenes"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("All Pic", "png", "jpeg", "gif");
            file.addChoosableFileFilter(filter);
            int a = file.showSaveDialog(null);
            if (a == JFileChooser.APPROVE_OPTION) {
                File f = file.getSelectedFile();
                String p = f.getAbsolutePath();
                jLabel1.setIcon(secticon(p, null));
                jLabelPrev.setIcon(null);
                jlabel_actual.setIcon(secticon(p, null));
                jLabelNext.setIcon(null);
                nuevaImagenSeleccionada = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Elija una dirección correcta " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visualizador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_despues;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelNext;
    private javax.swing.JLabel jLabelPrev;
    private javax.swing.JLabel jlabel_actual;
    // End of variables declaration//GEN-END:variables
}
