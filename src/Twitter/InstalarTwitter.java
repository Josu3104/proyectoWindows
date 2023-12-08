package Twitter;

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
    
    protected RandomAccessFile ucods, usuarios;
            
    public InstalarTwitter(){
        try {
            // Aseguramos que el folder de Twitter exista
            File f = new File("twitter");
            f.mkdir();
            // 2.Instanciar los RAFs dentro twitter
            //archivo para numero de cuentas
            ucods = new RandomAccessFile("Twitter/codigos.twc", "rw");
            //archivo para guardar usuarios (tipo arraylist pero en archivos)
            usuarios = new RandomAccessFile("Twitter/usuarios.twc", "rw");
            // 3.Inicializar el archivo de código si es nuestro
            
            initCode();
        } catch (IOException e) {
            System.out.println("No debería pasar esto");
        }
    }
    
    //inicializar el ucods 
    protected void initCode() throws IOException {
        if (ucods.length() == 0) {
            ucods.writeInt(1);
        }
    }
    
    //conseguir cuantos codigos tiene el ucods
    protected int getCode() throws IOException {
        ucods.seek(0);
        int code = ucods.readInt();
        ucods.seek(0);
        ucods.writeInt(code + 1);
        return code;
    }
    
//    protected void crearCuenta(String username, String password, char gender, Date loginDate, int age) throws IOException{
//        //FORMATO: Username, password, genero, fechaLogin, edad, activa/
//        //Falta validacion para que no se cree el mismo usuario dos veces
//        usuarios.seek(usuarios.length());
//        usuarios.writeUTF(username);
//        usuarios.writeUTF(password);
//        usuarios.writeChar(gender);
//        usuarios.writeLong(Calendar.getInstance().getTimeInMillis());
//        usuarios.writeBoolean(true);
//    }
    
//    public boolean verificarUsuarioUnico(String user){
//        if(){
//            
//        }
//    }
    
    
}
