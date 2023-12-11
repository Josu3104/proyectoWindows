package CMD;

import HOME.Desktop;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class cmd extends javax.swing.JInternalFrame {
 File carpetainicial = new File("Z/"+Desktop.LoggedUser);
    String carpetaAct=carpetainicial.getAbsolutePath();
    public static String tipo;
    public static String nombre;
    public cmd() {
        initComponents();
        jTextArea1.append("Carpeta actual: "+carpetaAct);
    }

    private void print(String msg) {
        String newText = jTextArea1.getText();
        newText += "\n" + msg;
        jTextArea1.setText(newText);
    }
    private String parseLine() {
        String lineNormal = "";
        String lineReverse = "";
        String consoleText = jTextArea1.getText();         
        
        // Tomar de la consola la linea
        for (int i = consoleText.length() - 1; i >= 0; i--) {
            if (consoleText.charAt(i) == '>') break;
            lineReverse += consoleText.charAt(i);
        }
        
        // Invertir y guardar
        for (int i = lineReverse.length()-1;i >= 0; i--) {
            lineNormal += lineReverse.charAt(i);
        }
        
        return lineNormal;
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Enter");
        jButton1.setBorder(null);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 50, 50));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 255));
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 255)));
        jTextArea1.setCaretColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextArea1.setEnabled(false);
        jTextArea1.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 640, 370));

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 255)));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 530, 40));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String command = jTextField1.getText();
        String[] tokens = command.split(" ");

        String nombreCarpetas = tokens[0];

        File carpetaActual = new File("Z/"+Desktop.LoggedUser);

        switch (tokens[0]) {
            case "mkdir":
                  String nombreCarpeta = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));
                    String rutaNuevaCarpeta = carpetaActual.getAbsolutePath() + File.separator + nombreCarpeta;
                    File nuevaCarpeta = new File(rutaNuevaCarpeta);
                    if (nuevaCarpeta.mkdir()) {
                        jTextArea1.append("\nCarpeta creada: " + nuevaCarpeta.getAbsolutePath() + "\n");
                    } else {
                        jTextArea1.append("\nError al crear carpeta.\n");
                    }
                    break;

            case "rm":
                nombreCarpetas = tokens[1];
                String rutaCarpetaAEliminar = carpetaActual.getAbsolutePath() + File.separator + nombreCarpetas;
                File carpetaAEliminar = new File(rutaCarpetaAEliminar);
                if (carpetaAEliminar.delete()) {
                    jTextArea1.append("\nCarpeta eliminada: " + carpetaAEliminar.getAbsolutePath() + "\n");
                } else {
                    jTextArea1.append("\nError al eliminar la carpeta\n");
                }
                break;
            case "cd":
                 String nombreCarpetaCD = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));
                    
                    File carpetaACambiar = new File(carpetaActual, nombreCarpetaCD);
                    if (carpetaACambiar.isDirectory()) {
                        System.setProperty("Z/"+Desktop.LoggedUser, carpetaACambiar.getAbsolutePath());
                        carpetaAct= carpetaACambiar.getAbsolutePath();
                        jTextArea1.append("\nCarpeta actual: " + carpetaACambiar.getAbsolutePath() + "\n");
                    } else {
                        jTextArea1.append("\nError: " + nombreCarpetaCD + " no es una carpeta\n");
                    }
                    break;
                    
            case "cd..":
                File carpetaAnterior = new File("Z/"+Desktop.LoggedUser).getParentFile();
                System.setProperty("Z/"+Desktop.LoggedUser, carpetaAnterior.getAbsolutePath());
                jTextArea1.append("\nCarpeta actual: " + carpetaAnterior.getAbsolutePath() + "\n");
                break;
            case "dir":
                File[] archivos = carpetaActual.listFiles();
                Arrays.sort(archivos);

                String formatoFecha = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);

                String tabla = String.format("%-50s%-20s\n", "Nombre", "Fecha de creación");
                tabla += "------------------------------------------------------------------\n";

                for (File archivo : archivos) {
                    if (archivo.isDirectory()) {
                        String fecha = sdf.format(new Date(archivo.lastModified()));
                        tabla += String.format("%-50s%-20s\n", archivo.getName(), fecha);
                    }
                }

                jTextArea1.setText(tabla);

                break;
            case "date":
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date = new Date();
                jTextArea1.append("\nFecha actual: " + dateFormat.format(date) + "\n");
                break;
            case "time":
                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                Date time = new Date();
                jTextArea1.append("\nHora actual: " + timeFormat.format(time) + "\n");
                break;
                case "help":
                    jTextArea1.append("\nComandos disponibles:\n");
                    jTextArea1.append("mkdir <nombreCarpeta>: Crear una nueva carpeta.\n");
                    jTextArea1.append("rm <nombreCarpeta>: Eliminar una carpeta.\n");
                    jTextArea1.append("cd <nombreCarpeta>: Cambiar al directorio especificado.\n");
                    jTextArea1.append("cd..: Retroceder al directorio padre.\n");
                    jTextArea1.append("dir: Mostrar lista de carpetas en el directorio actual.\n");
                    jTextArea1.append("date: Mostrar la fecha actual.\n");
                    jTextArea1.append("time: Mostrar la hora actual.\n");
                    jTextArea1.append("help: Mostrar esta ayuda.\n");
                    break;
                    
            default:
                jTextArea1.append("\nError: comando desconocido\n");
                break;
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Desktop.cmdAdded = true;
        Desktop.contBotonCmd++;
    }//GEN-LAST:event_formInternalFrameClosed

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
            java.util.logging.Logger.getLogger(cmd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cmd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cmd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cmd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cmd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
