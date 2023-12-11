package EditorTexto;
import Explorador.ExploradorDeArchivos;
import HOME.Desktop;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import static java.awt.SystemColor.text;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.PlainDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Editortexto extends javax.swing.JInternalFrame {
   
    public Editortexto() {
        initComponents();
        docs = txt_area.getStyledDocument();
        style = txt_area.addStyle("miEstilo", null);
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) tipoletra.getModel();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String fontNames[] = ge.getAvailableFontFamilyNames();
        for (int i = 0; i < fontNames.length; i++) {
            modelo.addElement(fontNames[i]);
        }
        tipoletra.setModel(modelo);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        txt_area.setEditable(true);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area = new javax.swing.JTextPane();
        jToolBar1 = new javax.swing.JToolBar();
        tipoletra = new javax.swing.JComboBox<>();
        tamañoletra = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_negrita = new javax.swing.JButton();
        btn_cursiva = new javax.swing.JButton();
        btn_subrayado = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_resaltador = new javax.swing.JButton();
        btn_color = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        btn_guardar1 = new javax.swing.JButton();
        abrir_btn = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Texto");
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

        txt_area.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(txt_area);

        jToolBar1.setRollover(true);

        tipoletra.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoletraItemStateChanged(evt);
            }
        });
        jToolBar1.add(tipoletra);

        tamañoletra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "18", "24", "36", "48", "60", "72" }));
        tamañoletra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamañoletraActionPerformed(evt);
            }
        });
        jToolBar1.add(tamañoletra);
        jToolBar1.add(jSeparator2);

        btn_negrita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EditorTexto/images/bold_2.png"))); // NOI18N
        btn_negrita.setToolTipText("");
        btn_negrita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_negrita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_negrita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_negritaMouseClicked(evt);
            }
        });
        jToolBar1.add(btn_negrita);

        btn_cursiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EditorTexto/images/cursive_2.png"))); // NOI18N
        btn_cursiva.setFocusable(false);
        btn_cursiva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cursiva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_cursiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cursivaMouseClicked(evt);
            }
        });
        jToolBar1.add(btn_cursiva);

        btn_subrayado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EditorTexto/images/underlined_2.png"))); // NOI18N
        btn_subrayado.setFocusable(false);
        btn_subrayado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_subrayado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_subrayado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_subrayadoMouseClicked(evt);
            }
        });
        jToolBar1.add(btn_subrayado);
        jToolBar1.add(jSeparator1);

        btn_resaltador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EditorTexto/images/highlight_2.png"))); // NOI18N
        btn_resaltador.setFocusable(false);
        btn_resaltador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_resaltador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_resaltador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resaltadorMouseClicked(evt);
            }
        });
        btn_resaltador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resaltadorActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_resaltador);

        btn_color.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EditorTexto/images/color_2.png"))); // NOI18N
        btn_color.setFocusable(false);
        btn_color.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_color.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_colorMouseClicked(evt);
            }
        });
        btn_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_colorActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_color);

        jToolBar2.setRollover(true);

        btn_guardar1.setIcon(new javax.swing.ImageIcon("C:\\Users\\irisa\\OneDrive\\Documentos\\NetBeansProjects\\Windows\\src\\EditorTexto\\images\\save_2.png")); // NOI18N
        btn_guardar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_guardar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_guardar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_guardar1MouseClicked(evt);
            }
        });
        btn_guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar1ActionPerformed(evt);
            }
        });
        jToolBar2.add(btn_guardar1);

        abrir_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EditorTexto/images/open_2.png"))); // NOI18N
        abrir_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abrir_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        abrir_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrir_btnMouseClicked(evt);
            }
        });
        abrir_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrir_btnActionPerformed(evt);
            }
        });
        jToolBar2.add(abrir_btn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                                   

    private void btn_resaltadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resaltadorMouseClicked
        // TODO add your handling code here:
        try {

            StyleConstants.setBackground(style,
                    JColorChooser.showDialog(this,
                            "Seleccione Color", Color.yellow)
            );

            docs.setCharacterAttributes(txt_area.getSelectionStart(),
                    txt_area.getSelectionEnd() - txt_area.getSelectionStart(),
                    txt_area.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_resaltadorMouseClicked

    private void btn_colorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_colorMouseClicked
        // TODO add your handling code here:
        try {

            StyleConstants.setForeground(style,
                    JColorChooser.showDialog(this,
                            "Seleccione Color", Color.red)
            );

            docs.setCharacterAttributes(txt_area.getSelectionStart(),
                    txt_area.getSelectionEnd() - txt_area.getSelectionStart(),
                    txt_area.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_colorMouseClicked

    private void btn_negritaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_negritaMouseClicked
        try {
            StyleConstants.setBold(style, true);

            docs.setCharacterAttributes(txt_area.getSelectionStart(),
                    txt_area.getSelectionEnd() - txt_area.getSelectionStart(),
                    txt_area.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_negritaMouseClicked

    private void btn_cursivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cursivaMouseClicked
       
        try {
            StyleConstants.setItalic(style, true);

            docs.setCharacterAttributes(txt_area.getSelectionStart(),
                    txt_area.getSelectionEnd() - txt_area.getSelectionStart(),
                    txt_area.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_cursivaMouseClicked

    private void btn_subrayadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_subrayadoMouseClicked
        // TODO add your handling code here:
        try {
            StyleConstants.setUnderline(style, true);

            docs.setCharacterAttributes(txt_area.getSelectionStart(),
                    txt_area.getSelectionEnd() - txt_area.getSelectionStart(),
                    txt_area.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_subrayadoMouseClicked

    private void tamañoletraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamañoletraActionPerformed
      
        StyleConstants.setFontSize(style, Integer.parseInt(tamañoletra.getSelectedItem().toString()));
        docs.setCharacterAttributes(txt_area.getSelectionStart(),
                txt_area.getSelectionEnd() - txt_area.getSelectionStart(),
                txt_area.getStyle("miEstilo"),
                true);
    }//GEN-LAST:event_tamañoletraActionPerformed

    private void tipoletraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoletraItemStateChanged
        // TODO add your handling code here:
        StyleConstants.setFontFamily(style, tipoletra.getSelectedItem().toString());
       
        docs.setCharacterAttributes(txt_area.getSelectionStart(),
                txt_area.getSelectionEnd() - txt_area.getSelectionStart(),
                txt_area.getStyle("miEstilo"),
                true);
    }//GEN-LAST:event_tipoletraItemStateChanged

    private void abrir_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrir_btnMouseClicked
 File ficha;
        FileInputStream enter;
        ObjectInputStream objeto;
        try {
            JFileChooser jc = new JFileChooser("Z/"+Desktop.LoggedUser+"/Documentos");
//            jc.setCurrentDirectory(new File("words"));
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("text file", "txt");
            jc.setFileFilter(filtro);
            int eleccion = jc.showOpenDialog(this);
            if (eleccion == JFileChooser.APPROVE_OPTION) {
                ficha = jc.getSelectedFile();
                enter = new FileInputStream(ficha);
                objeto = new ObjectInputStream(enter);
                txt_area.setText("");
                Documento_word temporal = (Documento_word) objeto.readObject();
                txt_area.setStyledDocument(temporal.getDoc());
                docs = temporal.getDoc();
                style = temporal.getEstilo();
            }
        } catch (HeadlessException | IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El archivo que está buscando no existe.");
        }
        

    }//GEN-LAST:event_abrir_btnMouseClicked


    private void abrir_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrir_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_abrir_btnActionPerformed

    private void btn_guardar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardar1MouseClicked
      
    }//GEN-LAST:event_btn_guardar1MouseClicked

    private void btn_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar1ActionPerformed
         JFileChooser jfc = new JFileChooser("Z/"+Desktop.LoggedUser+"/Documentos");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Text file", "txt");
        jfc.setFileFilter(filtro);
        int seleccion = jfc.showSaveDialog(this);
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File fichero ;
                if (jfc.getFileFilter().getDescription().equals("Text file")) {
                    fichero = new File(jfc.getSelectedFile().getPath() + ".txt");
                } else {
                    fichero = jfc.getSelectedFile();
                }
                fw = new FileOutputStream(fichero);
                bw = new ObjectOutputStream(fw);
                Documento_word d = new Documento_word(txt_area, docs, style);
                bw.writeObject(d);
                bw.flush();
                JOptionPane.showMessageDialog(this, "Archivo guardado exitosamente");
            }
        } catch (Exception e) {
        } 
    }//GEN-LAST:event_btn_guardar1ActionPerformed

    private void btn_resaltadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resaltadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_resaltadorActionPerformed

    private void btn_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_colorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_colorActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
         Desktop.wordAdded = true;
        Desktop.contBotonWord++;
    }//GEN-LAST:event_formInternalFrameClosed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrir_btn;
    private javax.swing.JButton btn_color;
    private javax.swing.JButton btn_cursiva;
    private javax.swing.JButton btn_guardar1;
    private javax.swing.JButton btn_negrita;
    private javax.swing.JButton btn_resaltador;
    private javax.swing.JButton btn_subrayado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JComboBox<String> tamañoletra;
    private javax.swing.JComboBox<String> tipoletra;
    private javax.swing.JTextPane txt_area;
    // End of variables declaration//GEN-END:variables


    StyledDocument docs;
    Style style;
}
