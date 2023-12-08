/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package WORD;

import HOME.Desktop;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Josue Gavidia
 */
public class Editor extends javax.swing.JInternalFrame {

    /**
     * Creates new form Editor
     */
    
    StyledDocument doc;
    Style estilo;
    public Editor() {
        initComponents();
        this.setSize(1440, 847);
        
         doc = Pagina.getStyledDocument();
        estilo = Pagina.addStyle("miEstilo", null);

        DefaultComboBoxModel modelo = (DefaultComboBoxModel) combo_tipodeletra.getModel();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String fontNames[] = ge.getAvailableFontFamilyNames();
        for (int i = 0; i < fontNames.length; i++) {
            modelo.addElement(fontNames[i]);
        }
        combo_tipodeletra.setModel(modelo);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Pagina = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        cursiva = new javax.swing.JButton();
        subrayado = new javax.swing.JButton();
        color_letra = new javax.swing.JButton();
        highlight = new javax.swing.JButton();
        abrirarch_btn = new javax.swing.JButton();
        combo_tamaño = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        negrita = new javax.swing.JButton();
        combo_tipodeletra = new javax.swing.JComboBox<>();
        guardararch_btn = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(976, 637));
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(Pagina);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 140, 1390, 660));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cursiva.setBackground(new java.awt.Color(204, 204, 204));
        cursiva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cursiva.setForeground(new java.awt.Color(0, 0, 0));
        cursiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WORD/Cursiva.png"))); // NOI18N
        cursiva.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        cursiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursivaActionPerformed(evt);
            }
        });
        jPanel1.add(cursiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 40, 40));

        subrayado.setBackground(new java.awt.Color(204, 204, 204));
        subrayado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        subrayado.setForeground(new java.awt.Color(0, 0, 0));
        subrayado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WORD/Subrayado.png"))); // NOI18N
        subrayado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        subrayado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subrayadoActionPerformed(evt);
            }
        });
        jPanel1.add(subrayado, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 40, 40));

        color_letra.setBackground(new java.awt.Color(255, 255, 255));
        color_letra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        color_letra.setForeground(new java.awt.Color(0, 0, 0));
        color_letra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WORD/ColorLetra.png"))); // NOI18N
        color_letra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        color_letra.setMaximumSize(new java.awt.Dimension(76, 11));
        color_letra.setMinimumSize(new java.awt.Dimension(76, 11));
        color_letra.setPreferredSize(new java.awt.Dimension(76, 11));
        color_letra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color_letraMouseClicked(evt);
            }
        });
        color_letra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                color_letraActionPerformed(evt);
            }
        });
        jPanel1.add(color_letra, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 40, 40));

        highlight.setBackground(new java.awt.Color(204, 204, 204));
        highlight.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        highlight.setForeground(new java.awt.Color(0, 0, 0));
        highlight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WORD/resaltado.jpg"))); // NOI18N
        highlight.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        highlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highlightActionPerformed(evt);
            }
        });
        jPanel1.add(highlight, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 40, 40));

        abrirarch_btn.setBackground(new java.awt.Color(204, 204, 204));
        abrirarch_btn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        abrirarch_btn.setForeground(new java.awt.Color(0, 0, 0));
        abrirarch_btn.setText("Abrir");
        abrirarch_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirarch_btnMouseClicked(evt);
            }
        });
        abrirarch_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirarch_btnActionPerformed(evt);
            }
        });
        jPanel1.add(abrirarch_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 100, 40));

        combo_tamaño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "8", "10", "12", "14", "16", "18", "20", "24", "28", "32", "36", "42", "48", "60", "72" }));
        combo_tamaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tamañoActionPerformed(evt);
            }
        });
        jPanel1.add(combo_tamaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 230, 40));

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WORD/fuente.png"))); // NOI18N
        jToggleButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jToggleButton1.setFocusPainted(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 43, 40));

        negrita.setBackground(new java.awt.Color(204, 204, 204));
        negrita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        negrita.setForeground(new java.awt.Color(0, 0, 0));
        negrita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WORD/Negrita.png"))); // NOI18N
        negrita.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        negrita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negritaActionPerformed(evt);
            }
        });
        jPanel1.add(negrita, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 40, 40));

        combo_tipodeletra.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_tipodeletraItemStateChanged(evt);
            }
        });
        combo_tipodeletra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tipodeletraActionPerformed(evt);
            }
        });
        jPanel1.add(combo_tipodeletra, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 230, 40));

        guardararch_btn.setBackground(new java.awt.Color(204, 204, 204));
        guardararch_btn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        guardararch_btn.setForeground(new java.awt.Color(0, 0, 0));
        guardararch_btn.setText("save file");
        guardararch_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardararch_btnMouseClicked(evt);
            }
        });
        guardararch_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardararch_btnActionPerformed(evt);
            }
        });
        jPanel1.add(guardararch_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 50, 100, 40));

        jToggleButton2.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WORD/Tamañooo.png"))); // NOI18N
        jToggleButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jToggleButton2.setFocusPainted(false);
        jPanel1.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 43, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1430, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void color_letraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_color_letraMouseClicked
        try {
            StyleConstants.setForeground(estilo,
                JColorChooser.showDialog(this,
                    "Seleccione Color", Color.red)
            );
            doc.setCharacterAttributes(Pagina.getSelectionStart(),
                Pagina.getSelectionEnd() - Pagina.getSelectionStart(),
                Pagina.getStyle("miEstilo"),
                true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_color_letraMouseClicked
  boolean cursivaActiva=false;
    boolean subrayadoActivo=false;
    
    private void color_letraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_color_letraActionPerformed
        try {
            StyleConstants.setForeground(estilo,
                JColorChooser.showDialog(this,
                    "Seleccione Color", Color.red)
            );
            doc.setCharacterAttributes(Pagina.getSelectionStart(),
                Pagina.getSelectionEnd() - Pagina.getSelectionStart(),
                Pagina.getStyle("miEstilo"),
                true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_color_letraActionPerformed

    private void abrirarch_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirarch_btnMouseClicked
        File fichero;
        FileInputStream entrada;
        ObjectInputStream objeto;
        try {
            JFileChooser jfc = new JFileChooser();
            jfc.setCurrentDirectory(new File("words"));
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("text file", "txt");
            jfc.setFileFilter(filtro);
            int seleccion = jfc.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                fichero = jfc.getSelectedFile();
                entrada = new FileInputStream(fichero);
                objeto = new ObjectInputStream(entrada);
                Pagina.setText("");
                wordsito temp = (wordsito) objeto.readObject();
                Pagina.setStyledDocument(temp.getDoc());
                doc = temp.getDoc();
                estilo = temp.getEstilo();
            }
        } catch (HeadlessException | IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El archivo no existe.");
        }
    }//GEN-LAST:event_abrirarch_btnMouseClicked

    private void abrirarch_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirarch_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_abrirarch_btnActionPerformed

    private void guardararch_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardararch_btnMouseClicked
//        JFileChooser jfc = new JFileChooser();
//        jfc.setCurrentDirectory(new File("words"));
//        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Text file", "txt");
//        jfc.setFileFilter(filtro);
//        int seleccion = jfc.showSaveDialog(this);
//        FileOutputStream fw = null;
//        ObjectOutputStream bw = null;
//        try {
//            if (seleccion == JFileChooser.APPROVE_OPTION) {
//                File fichero ;
//                if (jfc.getFileFilter().getDescription().equals("Text file")) {
//                    fichero = new File(jfc.getSelectedFile().getPath() + ".txt");
//                } else {
//                    fichero = jfc.getSelectedFile();
//                }
//                fw = new FileOutputStream(fichero);
//                bw = new ObjectOutputStream(fw);
//                wordsito d = new wordsito(tp_texto, doc, estilo);
//                bw.writeObject(d);
//                bw.flush();
//                JOptionPane.showMessageDialog(this, "Archivo guardado exitosamente");
//            }
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_guardararch_btnMouseClicked

    private void guardararch_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardararch_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardararch_btnActionPerformed

    private void combo_tipodeletraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_tipodeletraItemStateChanged
        StyleConstants.setFontFamily(estilo, combo_tipodeletra.getSelectedItem().toString());
        doc.setCharacterAttributes(Pagina.getSelectionStart(),
            Pagina.getSelectionEnd() - Pagina.getSelectionStart(),
            Pagina.getStyle("miEstilo"),
            true);
    }//GEN-LAST:event_combo_tipodeletraItemStateChanged

    private void combo_tamañoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tamañoActionPerformed
        StyleConstants.setFontSize(estilo, Integer.parseInt(combo_tamaño.getSelectedItem().toString()));
        doc.setCharacterAttributes(Pagina.getSelectionStart(),
            Pagina.getSelectionEnd() - Pagina.getSelectionStart(),
            Pagina.getStyle("miEstilo"),
            true);
    }//GEN-LAST:event_combo_tamañoActionPerformed

    private void negritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negritaActionPerformed
        try {
            if (negritaActiva) {
                StyleConstants.setBold(estilo, false);
                negritaActiva = false;
            } else {
                StyleConstants.setBold(estilo, true);
                negritaActiva = true;
            }
            doc.setCharacterAttributes(Pagina.getSelectionStart(),
                Pagina.getSelectionEnd() - Pagina.getSelectionStart(),
                Pagina.getStyle("miEstilo"),
                true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_negritaActionPerformed

    private void cursivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursivaActionPerformed
        try {
            if (cursivaActiva) {
                StyleConstants.setItalic(estilo, false);
                cursivaActiva = false;
            } else {
                StyleConstants.setItalic(estilo, true);
                cursivaActiva = true;
            }
            doc.setCharacterAttributes(Pagina.getSelectionStart(),
                Pagina.getSelectionEnd() - Pagina.getSelectionStart(),
                Pagina.getStyle("miEstilo"),
                true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_cursivaActionPerformed

    private void subrayadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subrayadoActionPerformed
        try {
            if (subrayadoActivo) {
                StyleConstants.setUnderline(estilo, false);
                subrayadoActivo = false;
            } else {
                StyleConstants.setUnderline(estilo, true);
                subrayadoActivo = true;
            }
            doc.setCharacterAttributes(Pagina.getSelectionStart(),
                Pagina.getSelectionEnd() - Pagina.getSelectionStart(),
                Pagina.getStyle("miEstilo"),
                true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_subrayadoActionPerformed

    private void highlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highlightActionPerformed
        try {
            StyleConstants.setBackground(estilo,
                JColorChooser.showDialog(this,
                    "Seleccione Color", Color.yellow)
            );

            doc.setCharacterAttributes(Pagina.getSelectionStart(),
                Pagina.getSelectionEnd() - Pagina.getSelectionStart(),
                Pagina.getStyle("miEstilo"),
                true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_highlightActionPerformed

    private void combo_tipodeletraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tipodeletraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tipodeletraActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Pagina.setText("");
        Desktop.wordAdded=true;
        Desktop.contBotonWord++;
      
    }//GEN-LAST:event_formInternalFrameClosed
 boolean negritaActiva = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane Pagina;
    private javax.swing.JButton abrirarch_btn;
    private javax.swing.JButton color_letra;
    private javax.swing.JComboBox<String> combo_tamaño;
    private javax.swing.JComboBox<String> combo_tipodeletra;
    private javax.swing.JButton cursiva;
    private javax.swing.JButton guardararch_btn;
    private javax.swing.JButton highlight;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JButton negrita;
    private javax.swing.JButton subrayado;
    // End of variables declaration//GEN-END:variables
}