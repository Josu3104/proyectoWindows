package Twitter;

import javax.swing.*;
import java.awt.*;
import java.io.RandomAccessFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Twitter {

    protected Usuario usuarioEnSesion;
    protected InstalarTwitter it = new InstalarTwitter();

    //si no existe da true, sino false
    public boolean verificarUsuarioUnico(String username) throws IOException {
        it.usuarios.seek(0);
        while (it.usuarios.getFilePointer() < it.usuarios.length()) {
            String comprobar = it.usuarios.readUTF();
            if (comprobar.equals(username)) {
                return false;
            }
            it.usuarios.readUTF();
            it.usuarios.readChar();
            it.usuarios.readLong();
            it.usuarios.readInt();
            it.usuarios.readBoolean();
        }
        return true;
    }

    public void crearFolderUsuario(String username) {
        File udir = new File("twitter/" + username);
        udir.mkdir();
    }

    private RandomAccessFile crearFollowers(String username) throws IOException {
        String path = "twitter/" + username + "/followers.twc";
        return new RandomAccessFile(path, "rw");
    }

    private RandomAccessFile crearFollowing(String username) throws IOException {
        String path = "twitter/" + username + "/following.twc";
        return new RandomAccessFile(path, "rw");
    }

    private RandomAccessFile crearTwits(String username) throws IOException {
        String path = "twitter/" + username + "/twits.twc";
        return new RandomAccessFile(path, "rw");
    }

//    private String folderUsuario(username){
//        
//    }
    protected boolean crearCuenta(String username, String password, char gender, Long loginDate, int age) throws IOException {
        if (verificarUsuarioUnico(username)) {
            //FORMATO: Username, password, genero, fechaLogin, edad, activa
            it.usuarios.seek(it.usuarios.length());
            it.usuarios.writeUTF(username);
            it.usuarios.writeUTF(password);
            it.usuarios.writeChar(gender);
            it.usuarios.writeLong(Calendar.getInstance().getTimeInMillis());
            it.usuarios.writeBoolean(true);
            crearFolderUsuario(username);
            crearFollowers(username);
            crearFollowing(username);
            crearTwits(username);
            return true;
        }
        return false;
    }

    //si la password es correcta da true, sino false
    public boolean verificarPassword(String username, String password) throws IOException {
        it.usuarios.seek(0);
        while (it.usuarios.getFilePointer() < it.usuarios.length()) {
            if (it.usuarios.readUTF().equals(username)) {
                String verificar = it.usuarios.readUTF();
                if (verificar.equals(password)) {
                    return true;
                }
            } else {
                it.usuarios.readUTF();

            }

            it.usuarios.readChar();
            it.usuarios.readLong();
            it.usuarios.readInt();
            it.usuarios.readBoolean();
        }
        return false;
    }

    public void usuarioEnSesion(String username) throws IOException {
        it.usuarios.seek(0);
        while (it.usuarios.getFilePointer() < it.usuarios.length()) {
            String nombre = it.usuarios.readUTF();
            if (nombre.equals(username)) {
                String contra = it.usuarios.readUTF();
                char gen = it.usuarios.readChar();
                long fecha = it.usuarios.readLong();
                int edad = it.usuarios.readInt();
                boolean active = it.usuarios.readBoolean();
                usuarioEnSesion = new Usuario(nombre, contra, gen, fecha, edad);
                break;
            }
            it.usuarios.readUTF();
            it.usuarios.readUTF();
            it.usuarios.readChar();
            it.usuarios.readLong();
            it.usuarios.readInt();
            it.usuarios.readBoolean();
        }

    }

    public boolean iniciarSesion(String username, String password) throws IOException {
        if (verificarPassword(username, password)) {
            usuarioEnSesion(username);
            return true;
        }
        return false;
    }

    //seguido = la persona a seguir, seguidor = la persona siguiendo
    //FORMATO: INT codigo seguidor, STRING username seguidor
    public void follow(String seguido, String seguidor) throws IOException {
        String dirFollow = "twitter/" + seguidor + "/following.twc";
        RandomAccessFile follow = crearFollowing(seguido);
        follow.seek(0);

//        if (follow.length() == 0) {
//            follow.writeInt(0);
//        } 
//        follow.seek(0);
//        int followings = follow.readInt();
//        follow.seek(0);
//        follow.writeInt(followings+1);
//        follow.writeUTF(seguidor);
    }

    public void unfollow() {

    }

//    public void agregarPost() {
//
//        
//        
//        
//        
//        
//        
//    }
    public boolean cerrarSesion() {
        usuarioEnSesion = null;
        return true;
    }

    //Editar
//    public void cambiarUsername(){
//    }
    public String getUsernameEnSesion() {
        return usuarioEnSesion.getUsername();
    }

    public boolean cambiarEdad(String usuarioActual, int newAge) throws IOException {
        it.usuarios.seek(0);
        while (it.usuarios.getFilePointer() < it.usuarios.length()) {
            String verificar = it.usuarios.readUTF();
            if (verificar.equals(usuarioActual)) {
                it.usuarios.readUTF();
                it.usuarios.readChar();
                it.usuarios.readLong();
                it.usuarios.writeInt(newAge);
                return true;
            }
            it.usuarios.readUTF();
            it.usuarios.readChar();
            it.usuarios.readLong();
            it.usuarios.readInt();
            it.usuarios.readBoolean();

        }
        return false;
    }

    public boolean cambiarGenero(String usernameActual, char nuevoGeneroxd) throws IOException {
        it.usuarios.seek(0);
        while (it.usuarios.getFilePointer() < it.usuarios.length()) {
            String verificar = it.usuarios.readUTF();
            if (verificar.equals(usernameActual)) {
                it.usuarios.readUTF();
                it.usuarios.writeChar(nuevoGeneroxd);
                it.usuarios.readLong();
                it.usuarios.readInt();
                return true;
            }
            it.usuarios.readUTF();
            it.usuarios.readChar();
            it.usuarios.readLong();
            it.usuarios.readInt();
            it.usuarios.readBoolean();

        }
        return false;
    }

    //PARA CAMBIAR PASSWORD HAY QUE INGRESAR LA ANTIGUA PASSWORD 
    public boolean cambiarPassword(String password, String usernameActual, String nuevaPassword) throws IOException {
        it.usuarios.seek(0);
        while (it.usuarios.getFilePointer() < it.usuarios.length()) {
            String verificar = it.usuarios.readUTF();
            if (verificar.equals(usernameActual)) {
                String verificar2 = it.usuarios.readUTF();
                if (verificar2.equals(password)) {
                    byte[] bytesMenos = verificar2.getBytes(java.nio.charset.StandardCharsets.UTF_8);
                    int size = bytesMenos.length;
                    it.usuarios.seek(it.usuarios.getFilePointer() - size);
                    it.usuarios.writeUTF(nuevaPassword);
                    it.usuarios.readChar();
                    it.usuarios.readLong();
                    it.usuarios.readInt();
                    return true;
                } else {
                    return false;
                }
            }
            it.usuarios.readUTF();
            it.usuarios.readChar();
            it.usuarios.readLong();
            it.usuarios.readInt();
            it.usuarios.readBoolean();
        }
        return false;
    }

    public boolean desactivarCuenta(String username) throws IOException {
        it.usuarios.seek(0);
        while (it.usuarios.getFilePointer() < it.usuarios.length()) {
            String verificar = it.usuarios.readUTF();
            if (verificar.equals(username)) {
                it.usuarios.readUTF();
                it.usuarios.readChar();
                it.usuarios.readLong();
                it.usuarios.readInt();
                it.usuarios.writeBoolean(false);
                return true;
            }
            it.usuarios.readUTF();
            it.usuarios.readChar();
            it.usuarios.readLong();
            it.usuarios.readInt();
            it.usuarios.readBoolean();
        }
        return false;
    }

}

//    public boolean verificarUsuario(String username) throws IOException{
//        it.usuarios.seek(0);
//        while(it.usuarios.getFilePointer() < it.usuarios.length()){
//            String nombre = it.usuarios.readUTF();
//            if (nombre.equals(username)) {
//                return 
//            }
//            it.usuarios.readUTF();
//            it.usuarios.readUTF();
//            it.usuarios.readChar();
//            it.usuarios.readLong();
//            it.usuarios.readInt();
//            it.usuarios.readBoolean();
//        }
//        return 
//    }

