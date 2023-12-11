
package Visualizador;
import HOME.Desktop;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Medias extends javax.swing.JInternalFrame {

    public Medias() {
        initComponents();
        this.setTitle("Visor de imagenes");
        for (int a = 0; a < 10; a++) {
            Images[a] = new ImageIcon(getClass().getResource("/Visualizador/Imagenes/image" + (a+1) + ".jpg"));
        }

        jLabel2.setIcon(Images[0]);
        jlabel_actual.setIcon(Images[0]);

        jLabelPrev.setIcon(Images[9]);
        jLabelNext.setIcon(Images[(1)]);
    }
    ImageIcon Images[] = new ImageIcon[10];
    byte[] image;
    String imagepath = "";
    ImageIcon myimage;
    int contador = 0;
    private boolean nuevaImagenSeleccionada = false;

    

    public ImageIcon secticon(String m, byte[] image) {
        if (m != null) {
            myimage = new ImageIcon(m);

        } else {
            myimage = new ImageIcon(image);
        }
        
        Image img1 = myimage.getImage();
        Image img2 = img1.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(img2);
        return i;
    }
                                    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        btn_despues = new javax.swing.JButton();
        jLabelPrev = new javax.swing.JLabel();
        jlabel_actual = new javax.swing.JLabel();
        jLabelNext = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Visor de Imagenes");
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

        jLabel2.setToolTipText("");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 5));

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setForeground(new java.awt.Color(0, 0, 0));
        buscar.setText("Buscar Foto");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        btn_atras.setBackground(new java.awt.Color(255, 255, 255));
        btn_atras.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(0, 0, 0));
        btn_atras.setText("Atrás");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });

        btn_despues.setBackground(new java.awt.Color(255, 255, 255));
        btn_despues.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_despues.setForeground(new java.awt.Color(0, 0, 0));
        btn_despues.setText("Siguiente");
        btn_despues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_despuesActionPerformed(evt);
            }
        });

        jLabelPrev.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 5));

        jlabel_actual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 5));

        jLabelNext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_actual, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNext, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_despues)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buscar)
                .addGap(86, 86, 86)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlabel_actual, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNext, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_atras)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_despues)
                        .addGap(121, 121, 121))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try {
          JFileChooser file = new JFileChooser("Z/"+Desktop.LoggedUser+"/Imagenes");
            //file.setCurrentDirectory(new File("Z:\\" + Desktop.LoggedUser));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("All Pic", "png", "jpeg", "gif");
            file.addChoosableFileFilter(filter);
            int a = file.showOpenDialog(null);
            if (a == JFileChooser.APPROVE_OPTION) {
                File f = file.getSelectedFile();
                String p = f.getAbsolutePath();
                jLabel2.setIcon(secticon(p, null));
                jLabelPrev.setIcon(null);
                jlabel_actual.setIcon(secticon(p, null));
                jLabelNext.setIcon(null);
                nuevaImagenSeleccionada = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Elija una dirección correcta " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        /*
            if (songPlayer != null) {
            songPlayer.stop();
        }
        try {
            JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.showOpenDialog(this);
            File selectedFolder = chooser.getSelectedFile();
            if (selectedFolder == null) {
                return;
            }
            musicPath = selectedFolder.getCanonicalPath();
            songSeek = 0;
            currentSongName = "";
            updateData(musicPath, songSeek, currentSongName);
            loadSongs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }//GEN-LAST:event_buscarActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        if (!nuevaImagenSeleccionada) {
            contador--;
            if (contador == -1) {
                contador = 9;
            }

            jLabel2.setIcon(Images[contador]);
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

    private void btn_despuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_despuesActionPerformed
        if (!nuevaImagenSeleccionada) {
            contador++;
            if (contador == 10) {
                contador = 0;
            }
            jLabel2.setIcon(Images[contador]);
            jlabel_actual.setIcon(Images[contador]);
            int prev = contador-1==-1?9:contador-1;
            jLabelPrev.setIcon(Images[prev]);
            int sig = contador+1==10?0:contador+1;
            jLabelNext.setIcon(Images[sig]);
        }
        nuevaImagenSeleccionada = false;
    }//GEN-LAST:event_btn_despuesActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
       Desktop.imagesAdded = true;
        Desktop.contBotonImages++;
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_despues;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelNext;
    private javax.swing.JLabel jLabelPrev;
    private javax.swing.JLabel jlabel_actual;
    // End of variables declaration//GEN-END:variables
}
