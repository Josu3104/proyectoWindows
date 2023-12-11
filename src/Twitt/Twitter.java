package Twitt;

import javax.swing.*;
import java.awt.*;
import java.io.RandomAccessFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Twitter {

    protected DefaultListModel ListUsers;
    protected Usuario usuarioEnSesion;
    protected InstalarTwitter it = new InstalarTwitter();
    protected String userBuscado;

    //si no existe da true, sino false
    public boolean verificarUsuarioUnico(String username) throws IOException {
        it.usuarios.seek(0);
        while (it.usuarios.getFilePointer() < it.usuarios.length()) {
            it.usuarios.readUTF();
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

    private RandomAccessFile baseTwits() throws IOException {
        String path = "twitter/globalTwits.twc";
        return new RandomAccessFile(path, "rw");
    }

    //FORMATO TWITS: String autor, long fecha, String texto
    public void escribirTwit(String autor, String texto) throws IOException {
        RandomAccessFile twits = baseTwits();
        twits.seek(twits.length());
        twits.writeUTF(autor);
        twits.writeLong(Calendar.getInstance().getTimeInMillis());
        twits.writeUTF(texto);

    }

    public String mostrarTwitsGlobales(JTextArea area) throws IOException {
        RandomAccessFile twits = baseTwits();
        String todo="";
        twits.seek(0);
        while (twits.getFilePointer() < twits.length()) {
            String autor = twits.readUTF();
            Long provFecha = twits.readLong();
            
            Date loginDate = new Date(provFecha);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formateado = sdf.format(loginDate);
            String fecha = formateado;
            
            String texto = twits.readUTF();
            
            todo+="Autor: "+autor+" - Publicado: "+fecha+" - Contenido: \n"+texto+"\n";
            
        }
        area.setText(todo);
        System.out.println(todo);
        return todo;
    }

    protected boolean crearCuenta(String fullName, String username, String password, char gender, int age) throws IOException {
        if (verificarUsuarioUnico(username)) {
            //FORMATO: FullName ,Username, password, genero, fechaLogin, edad, activa
            it.usuarios.seek(it.usuarios.length());
            it.usuarios.writeUTF(fullName);
            it.usuarios.writeUTF(username);
            it.usuarios.writeUTF(password);
            it.usuarios.writeChar(gender);
            it.usuarios.writeLong(Calendar.getInstance().getTimeInMillis());
            it.usuarios.writeInt(age);
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
            it.usuarios.readUTF();

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
            String user = it.usuarios.readUTF();
            if (user.equals(username)) {
                String contra = it.usuarios.readUTF();
                char gen = it.usuarios.readChar();
                long fecha = it.usuarios.readLong();
                int edad = it.usuarios.readInt();
                boolean active = it.usuarios.readBoolean();
                usuarioEnSesion = new Usuario(nombre, user, contra, gen, fecha, edad, active);
                break;
            }
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
            System.out.println("ENTRA");
            return true;
        }
        JOptionPane.showMessageDialog(null, "Usuario o contraseña invalidos");
        return false;

    }

    //seguido = la persona a seguir, seguidor = la persona siguiendo
    //FORMATO: STRING username seguidor
    public int getSeguidos(String username) throws IOException {
        RandomAccessFile following = crearFollowing(username);
        following.seek(0);
        int seguidos = 0;
        while (following.getFilePointer() < following.length()) {
            if (!following.readUTF().startsWith("*")) {
                seguidos++;
            }

        }
        return seguidos;
    }

    public int getSeguidores(String username) throws IOException {
        RandomAccessFile followers = crearFollowers(username);
        followers.seek(0);
        int seguidores = 0;
        while (followers.getFilePointer() < followers.length()) {
            if (!followers.readUTF().startsWith("*")) {
                seguidores++;
            } else {
                seguidores--;
            }

        }
        return seguidores;

    }

    //Buscar usuario 
    //FORMATO: NomCompleto, Username, password, genero, fechaLogin, edad, activa
    public Usuario buscarUsuario(String username) throws IOException {
        it.usuarios.seek(0);
        while (it.usuarios.getFilePointer() < it.usuarios.length()) {
            String tempNombre = it.usuarios.readUTF();
            String tempUsuario = it.usuarios.readUTF();
            if (tempUsuario.equals(username)) {
                String tempPass = it.usuarios.readUTF();
                char tempGender = it.usuarios.readChar();
                long tempFecha = it.usuarios.readLong();
                int tempAge = it.usuarios.readInt();
                boolean tempState = it.usuarios.readBoolean();
                return new Usuario(tempNombre, tempUsuario, tempPass, tempGender, tempFecha, tempAge, tempState);
            }
            it.usuarios.readUTF();
            it.usuarios.readChar();
            it.usuarios.readLong();
            it.usuarios.readInt();
            it.usuarios.readBoolean();
        }
        return null;

    }

    public void follow(String seguido, String seguidor) throws IOException {
        String dirFollowing = "twitter/" + seguidor + "/following.twc";
        RandomAccessFile following = crearFollowing(seguidor);
        following.seek(following.length());
        following.writeUTF(seguido);

        String dirFollower = "twitter/" + seguido + "/followers.twc";
        RandomAccessFile followers = crearFollowers(seguido);
        followers.seek(followers.length());
        followers.writeUTF(seguidor);

    }

    //Cambio del estado del boton entre follow/unfollow
    public boolean loSigo(String seguidor, String seguido) throws IOException {
        RandomAccessFile following = crearFollowing(seguidor);
        following.seek(0);
        String prov;
        while (following.getFilePointer() < following.length()) {
            prov = following.readUTF();
            if (prov.equals(seguido)) {
                return true;

//            }else if(prov.contains(seguido)&&prov.startsWith("*")){
//                System.out.println("Lo dejo de seguir");
//                return false;
            }

        }
        System.out.println("No lo sigue");
        return false;
    }

    public void unfollow(String seguido, String seguidor) throws IOException {
        String dirFollowing = "twitter/" + seguidor + "/following.twc";
        RandomAccessFile following = crearFollowing(seguidor);
        following.seek(0);
        int indice = 1;
        int saveIndice;
        while (following.getFilePointer() < following.length()) {
            if (following.readUTF().equals(seguido)) {
                saveIndice = indice;
                following.seek(0);
                for (int i = 0; i < getSeguidos(seguidor); i++) {
                    if (i == saveIndice) {
                        following.writeUTF("*" + seguido);
                        System.out.println("Se ha dejado de seguir");
                    } else {
                        following.readUTF();
                    }
                    break;
                }
                break;
            }
        }

//        following.writeUTF(seguido);
        String dirFollower = "twitter/" + seguido + "/followers.twc";
        RandomAccessFile followers = crearFollowers(seguido);
        followers.seek(0);

        int indice2 = 1;
        int saveIndice2;
        while (followers.getFilePointer() < followers.length()) {
            if (followers.readUTF().equals(seguido)) {
                saveIndice2 = indice2;
                followers.seek(0);
                for (int i = 0; i < getSeguidores(seguido); i++) {
                    if (i == saveIndice2) {
                        followers.writeUTF("*" + seguidor);
                        System.out.println("Le han dejado de seguir");
                    } else {
                        followers.readUTF();
                    }
                    break;
                }
                break;
            }
        }

    }

    /*
    Pepe
    *Juan
    Luis
     */
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
    //FORMATO: NomCompleto, Username, password, genero, fechaLogin, edad, activa

    public void buscarListaUsuarios(JList<String> LISTA, String buscarUsuario) throws IOException {
        DefaultListModel<String> tempUsers = new DefaultListModel();
        it.usuarios.seek(0);
        while (it.usuarios.getFilePointer() < it.usuarios.length()) {
            it.usuarios.readUTF();
            String user = it.usuarios.readUTF();
            tempUsers.addElement(user);
            it.usuarios.readUTF();
            it.usuarios.readChar();
            it.usuarios.readLong();
            it.usuarios.readInt();
            it.usuarios.readBoolean();
        }
//        ArrayList<String> usuariosEncontrados = new ArrayList();
        ListUsers = new DefaultListModel();
        RandomAccessFile compararFollowings = crearFollowing(usuarioEnSesion.getUsername());
        compararFollowings.seek(0);

        ArrayList<String> provisional = new ArrayList();
        while (compararFollowings.getFilePointer() < compararFollowings.length()) {
            String provUser = compararFollowings.readUTF();
            if (!provUser.startsWith("*")) {
                provisional.add(provUser);
            }

        }

        for (int i = 0; i < tempUsers.size(); i++) {
            String element = tempUsers.getElementAt(i);
            if (element != null && element.contains(buscarUsuario) && !element.equals(usuarioEnSesion.getUsername())) {
                if (provisional.contains(element)) {
                    ListUsers.addElement(element + " - FOLLOWED");
                } else {
                    ListUsers.addElement(element + " - NOT FOLLOWED");
                }

            }
        }
        LISTA.setModel(ListUsers);
    }

    public String getSelectedUser(JList<String> lista) {
        String pos = lista.getSelectedValue();
        String provUser;

        if (pos != null) {
            String[] separador = pos.split(" - ");
//            int index = Integer.valueOf(separador[0]);
            provUser = separador[0];
            System.out.println(provUser);
            return provUser;
        }
        return null;
    }

    //FORMATO: NomCompleto, Username, password, genero, fechaLogin, edad, activa
    public void setDatosUserBuscado(JList<String> lista, JLabel name, JLabel date, JLabel sex, JLabel edad,
            JLabel followers, JLabel following, JLabel foto) throws IOException {
        it.usuarios.seek(0);
        while (it.usuarios.getFilePointer() < it.usuarios.length()) {
            String nombre = it.usuarios.readUTF();
            String user = it.usuarios.readUTF();
            userBuscado = user;
            if (user.equals(getSelectedUser(lista))) {
                String pass = it.usuarios.readUTF();
                char gender = it.usuarios.readChar();
                long fecha = it.usuarios.readLong();
                int age = it.usuarios.readInt();
                boolean state = it.usuarios.readBoolean();

                name.setText(nombre);
                setearFechaProfile(date, fecha);
                if (gender == 'M') {
                    sex.setText("Male");
                } else {
                    sex.setText("Female");
                }
                edad.setText(age + "");
                followers.setText(getSeguidores(user) + "");
                following.setText(getSeguidos(user) + "");
                setPfp(user, foto);
                break;

            }
            it.usuarios.readUTF();
            it.usuarios.readChar();
            it.usuarios.readLong();
            it.usuarios.readInt();
            it.usuarios.readBoolean();
        }
    }

    //UTILITARIAS
    public static void setPfp(String usuario, JLabel label) {
        try {

            ImageIcon icon = new ImageIcon("twitter\\FotosDePerfil\\" + usuario + ".jpg");
            Image image = icon.getImage();

            Image scaledImage = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            label.setIcon(scaledIcon);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setearFechaProfile(JLabel dt, long dat) {

        Date loginDate = new Date(dat);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formateado = sdf.format(loginDate);
        dt.setText(formateado);
    }

    public void patitoInsano() {

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

