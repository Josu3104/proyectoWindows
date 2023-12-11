package EditorTexto;

import java.io.Serializable;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class Documento_word implements Serializable{
    private JTextPane panel1;
    private StyledDocument docs;
    private Style style;

    public Documento_word(JTextPane panel1, StyledDocument docs, Style style) {
        this.panel1 = panel1;
        this.docs = docs;
        this.style = style;
    }

    public JTextPane getPanel() {
        return panel1;
    }

    public void setPanel(JTextPane panel1) {
        this.panel1 = panel1;
    }

    public StyledDocument getDoc() {
        return docs;
    }

    public void setDoc(StyledDocument docs) {
        this.docs = docs;
    }

    public Style getEstilo() {
        return style;
    }

    public void setEstilo(Style style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Documento{" + "panel=" + panel1 + ", doc=" + docs + ", estilo=" + style + '}';
    }
    
    
    
}
