package Twitter;

public class SesionUsuario {
    
    private static String usuarioEnSesion;
    
    public static void iniciarSesion(String username) {
        usuarioEnSesion = username;
    }
    
    public static void cerrarSesion() {
        usuarioEnSesion = null;
    }
}
