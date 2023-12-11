package Twitt;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class InstalarTwitter {
    
    protected RandomAccessFile  usuarios;
            
    public InstalarTwitter(){
        try {
            // Aseguramos que el folder de Twitter exista
            File f = new File("twitter");
            f.mkdir();
            // 2.Instanciar los RAFs dentro twitter
            //archivo para numero de cuentas
//            ucods = new RandomAccessFile("twitter/codigos.twc", "rw");
            //archivo para guardar usuarios (tipo arraylist pero en archivos)
            usuarios = new RandomAccessFile("twitter/usuarios.twc", "rw");
            // 3.Inicializar el archivo de código si es nuestro
            File pfp = new File("twitter/FotosDePerfil");
            pfp.mkdir();
//            initCode();
        } catch (IOException e) {
            System.out.println("No debería pasar esto");
        }
    }
    
    //inicializar el ucods 
//    protected void initCode() throws IOException {
//        if (ucods.length() == 0) {
//            ucods.writeInt(1);
//        }
//    }
    
    //conseguir cuantos codigos tiene el ucods
//    protected int getCode() throws IOException {
//        ucods.seek(0);
//        int code = ucods.readInt();
//        ucods.seek(0);
//        ucods.writeInt(code + 1);
//        return code;
//    }
//    
//    protected void crearCuenta(String fullName, String username, String password, char gender, long loginDate, int age) throws IOException{
//        //FORMATO: Nombre completo ,Username, password, genero, fechaLogin, edad, activa
//        usuarios.seek(usuarios.length());
//        usuarios.writeUTF(fullName);
//        usuarios.writeUTF(username);
//        usuarios.writeUTF(password);
//        usuarios.writeChar(gender);
//        usuarios.writeLong(Calendar.getInstance().getTimeInMillis());
//        usuarios.writeInt(age);
//        usuarios.writeBoolean(true);
//    }
    
    
    
}
