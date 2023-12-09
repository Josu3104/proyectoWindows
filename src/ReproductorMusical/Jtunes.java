/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ReproductorMusical;

import HOME.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Josue Gavidia
 */
public class Jtunes extends javax.swing.JInternalFrame {

    /**
     * Creates new form Jtunes
     */
    public Jtunes() {
        initComponents();

    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MP3 = new javax.swing.JPanel();
        btnadd = new javax.swing.JButton();
        btnremove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPlaylist = new javax.swing.JList<>();
        btnplay = new javax.swing.JButton();
        btnstop = new javax.swing.JButton();
        btnstop1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("MUSIC PLAYER");
        setPreferredSize(new java.awt.Dimension(800, 500));
        setVisible(true);
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

        MP3.setBackground(new java.awt.Color(255, 255, 255));
        MP3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MP3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnadd.setText("Añadir cancion");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        MP3.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 14, 126, -1));

        btnremove.setText("Quitar cancion");
        btnremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoveActionPerformed(evt);
            }
        });
        MP3.add(btnremove, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 53, 126, -1));

        jScrollPane2.setViewportView(jPlaylist);

        MP3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 380, 314));

        btnplay.setText("Play");
        btnplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnplayActionPerformed(evt);
            }
        });
        MP3.add(btnplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 92, 84, 68));

        btnstop.setText("Pause");
        btnstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstopActionPerformed(evt);
            }
        });
        MP3.add(btnstop, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 84, 68));

        btnstop1.setText("Stop");
        btnstop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstop1ActionPerformed(evt);
            }
        });
        MP3.add(btnstop1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 84, 68));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MP3, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MP3, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Jtunes");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        AñadirCancion();
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnplayActionPerformed

        Reproducir();
    }//GEN-LAST:event_btnplayActionPerformed

    private void btnstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstopActionPerformed
        if (this.Reproductor != null) {
            Reproductor.close();
        } else {
            JOptionPane.showMessageDialog(null, "Algo salio mal");
        }
    }//GEN-LAST:event_btnstopActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
       Desktop.tunesAdded=true;
       Desktop.contBotonJtunes++;
    }//GEN-LAST:event_formInternalFrameClosed

    private void btnstop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstop1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnstop1ActionPerformed

    private void btnremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoveActionPerformed
        QuitarCancion();
    }//GEN-LAST:event_btnremoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MP3;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnplay;
    private javax.swing.JButton btnremove;
    private javax.swing.JButton btnstop;
    private javax.swing.JButton btnstop1;
    private javax.swing.JList<String> jPlaylist;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

//MP33333333333
    Funciones nose = new Funciones();

    public ArrayList ListaCanciones = new ArrayList();
    private int posicionDeReproduccion = 0;
    private boolean enPausa = false;
    private int segundosAdelantados = 10;
    javazoom.jl.player.Player Reproductor;
    File archivo;

    public void ActualizarLista() {

        ListaCanciones = nose.getCancion();
        DefaultListModel model = new DefaultListModel();

        for (int i = 0; i < ListaCanciones.size(); i++) {
            int x = i + 1;
            model.add(i, x + "- " + ((File) ListaCanciones.get(i)).getName());

        }
        jPlaylist.setModel(model);
       
        

    }

    public void AñadirCancion() {
        nose.Añadir(this);
        ActualizarLista();
    }

    public void QuitarCancion() {

        try {
            int CancionSeleccionada = jPlaylist.getLeadSelectionIndex();
            nose.Canciones.remove(CancionSeleccionada);
            ActualizarLista();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Seleccione una canción valida");
        }

    }

    File Cancion1;
    static int hola = 0;

    public void Reproducir() {

        if (hola == 0) {
            try {
                int CancionSeleccionada = jPlaylist.getSelectedIndex();
                Cancion1 = (File) this.ListaCanciones.get(CancionSeleccionada);
                FileInputStream song = new FileInputStream(Cancion1);
                BufferedInputStream song2 = new BufferedInputStream(song);
                Reproductor = new javazoom.jl.player.Player(song2);
                hola = 1;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: eliga una cancion valida");
            }

            new Thread() {
                @Override
                public void run() {

                    try {
                        Reproductor.play();

                    } catch (Exception e) {

                    }
                }

            }.start();

        } else {
            Reproductor.close();
            hola = 0;
            Reproducir();

        }

    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
