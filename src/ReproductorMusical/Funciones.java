package ReproductorMusical;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class Funciones {
    
    JFileChooser ArchivoSeleccionado=new JFileChooser();
    ArrayList Canciones=new ArrayList();
    
    void Añadir(JInternalFrame frame){
    
        ArchivoSeleccionado.setMultiSelectionEnabled(true);
        int fileValid=ArchivoSeleccionado.showOpenDialog(frame);
        
        if (fileValid==javax.swing.JFileChooser.CANCEL_OPTION) {
        } 
        
        else if(fileValid==javax.swing.JFileChooser.APPROVE_OPTION) {
            
            File[] file=ArchivoSeleccionado.getSelectedFiles();
            Canciones.addAll(Arrays.asList(file));
            
        }
        
    }
    
   public ArrayList getCancion(){
        return Canciones;
    }
    
    
    FileOutputStream fos;
    ObjectOutputStream oos;
    
    
    public void GuardarCanciones(JFrame frame){
    
        ArchivoSeleccionado.setMultiSelectionEnabled(false);
        
        int Valid=ArchivoSeleccionado.showSaveDialog(frame);
        
        if (Valid==javax.swing.JFileChooser.CANCEL_OPTION) {
            
            return;
            
        } 
        
        else if(Valid==javax.swing.JFileChooser.APPROVE_OPTION) {
            
            File pls=ArchivoSeleccionado.getSelectedFile();
            
            try {
                   fos=new FileOutputStream(pls + ".tgr");
                   oos=new ObjectOutputStream(fos);
                   
                   for(int i=0;i<Canciones.size();i++){
                          File tmp=(File) Canciones.get(i);
                          oos.writeObject(tmp);}
                   oos.close();
            }catch (Exception e) {  
            }
            
        }
    }
    
    FileInputStream hola;
    ObjectInputStream hola2;
    
    public void Abrir(JFrame frame){
        ArchivoSeleccionado.setMultiSelectionEnabled(false);
        int Valid=ArchivoSeleccionado.showOpenDialog(frame);
        
        if (Valid==javax.swing.JFileChooser.CANCEL_OPTION) {
            
            File pls=ArchivoSeleccionado.getSelectedFile();
            
            try {
                   hola=new FileInputStream(pls);
                   hola2=new ObjectInputStream(hola);
                   File tmp;
                   
                   while((tmp=(File) hola2.readObject())==null)
                   {
                       Canciones.add(tmp);
                       
                   }
                   
                   if((tmp=(File) hola2.readObject())==null)
                      {
                          Canciones.isEmpty();
                          
                      }
                   hola2.close();
                
            } catch (Exception e) {
            }
            
        } else {
        }
        
    }
    
    
}
