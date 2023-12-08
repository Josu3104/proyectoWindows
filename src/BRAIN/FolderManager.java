/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BRAIN;

import HOME.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

/**
 *
 * @author Josue Gavidia
 */
public class FolderManager {

    private static String root;
    private String spawn;
    public  static RandomAccessFile usuarios=null;
    public static File files = null;
   

    public FolderManager(String user) {
 
    }

    public String getRoot() {
        return root;
    }

    public  void CrearZyAdmin()throws IOException {
       
        File admin = new File("Z", "Default");
        File documentos = new File(admin, "Documentos");
        File musica = new File(admin, "Musica");
        File imagenes = new File(admin, "Imagenes");
        File users = new File("ProyectoWindows","users");

        if (!admin.exists() && admin.mkdirs()) {
            System.out.println(admin.getAbsolutePath() + " creado");
        } else {
            System.out.println(admin.getAbsolutePath() + " existe");
        }
      
        if (!documentos.exists() && documentos.mkdirs()) {
            System.out.println(documentos.getAbsolutePath() + " creado ");
        } else {
            System.out.println(documentos.getAbsolutePath() + " existe");
        }
        if (!musica.exists() && musica.mkdirs()) {
            System.out.println(musica.getAbsolutePath() + " creado");
        } else {
            System.out.println(musica.getAbsolutePath() + " existe ");
        }
        if (!imagenes.exists() && imagenes.mkdirs()) {
            System.out.println(imagenes.getAbsolutePath() + " creado ");
        } else {
            System.out.println(imagenes.getAbsolutePath() + " existe");
        }
        
        if (!users.exists() && users.mkdirs()) {
            usuarios = new RandomAccessFile("ProyectoWindows//users//usuarios.sop","rw");
            System.out.println(users.getAbsolutePath() + " creado ");
        } else {
            System.out.println(users.getAbsolutePath() + " existe");
        }

        root = admin.getAbsolutePath();
        

    }

    //Crear cuentas de usuarios
    
//    public void greenLight()throws IOException{
//        if(){
//            
//        }
//    }
//    
//
//    
//    public boolean buscarCuentaSys(String user, String pass){
//        
//    }
//    
//    
//    
//    public static boolean GuardarUsuarioSOP(String user, String pass) throws IOException {
//        usuarios.seek(0);
//        usuarios.writeUTF(user);
//        usuarios.writeUTF(pass);
//        
//    }
//    
    
    

}
