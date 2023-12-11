package CMD;
import java.io.*;
public class FuncionesCMD {

    public File currentDir;

    public FuncionesCMD(String startPath) {
        currentDir = new File(startPath);
    }

    public String CHDIR(String path) {
        if (path.charAt(0) != '/') {
            File newDir = new File(currentDir.getAbsolutePath() + "/" + path);

            if (!newDir.isDirectory()) {
                return "Error. La direccion tiene que ser una carpeta.";
            }
            currentDir = newDir;
            System.out.println("NUEVO DIR ES: " + newDir.getAbsolutePath());
            return "";
        }

        currentDir = new File(path);
        return "";
    }

    public String MKDIR(String path) {
        String mensaje = "";
        File folder = new File(path);

        if (folder.exists()) {
            mensaje = "Error: Esta carpeta ya existe";
            return mensaje;
        } else {

            mensaje = "Carpeta creada existosamente";
            folder.mkdir();
            return mensaje;
        }
    }

    public String MFILE(String path) {
        String mensaje = "";
        File archivo = new File(path);

        if (archivo.exists()) {
            mensaje = "Error: Este archivo ya existe";
            return mensaje;
        } else {
            mensaje = "Archivo creado existosamente";

            try {
                archivo.createNewFile();
            } catch (IOException e) {
                mensaje = "Error: no se pudo crear";
            }
            return mensaje;

        }
    }

    public void VaciarCarpeta(File avaciar) {
        if (avaciar.isDirectory()) {
            for (File vacio : avaciar.listFiles()) {
                vacio.delete();
            }
        }

    }

    public String Eliminar(File nose) {
        if (nose.isDirectory()) {
            for (File hola : nose.listFiles()) {
                if (hola.isDirectory()) {
                    VaciarCarpeta(hola);
                    hola.delete();
                } else {
                    hola.delete();
                }
            }
            nose.delete();
            return "Carpeta Vaciada";
        }

        if (nose.isFile()) {
            nose.delete();
            return "Archivo eliminado";
        }

        return "Error";
    }

    public String Escribir(String mensaje, String path) {
        File nose = new File(path);
        String salida = "";

        if (nose.exists()) {
            if (nose.isFile()) {
                try {

                    FileWriter fr = new FileWriter(nose);
                    fr.write(mensaje);
                    fr.flush();
                } catch (IOException e) {
                    salida = "Error: no se pudo crear";
                }
                salida = "Escritura completada";
                return salida;
            } else {
                salida = "Error: debe seleccionar un archivo";
                return salida;
            }
        } else {
            salida = "Error: Archivo inexistente";
            return salida;
        }

    }

    public static String leer(String path) {
        File nose = new File(path);
        String mensaje = "";

        if (nose.exists()) {
            if (nose.isFile()) {
                try {
                    FileReader fr = new FileReader(nose);

                    String contenido = "";

                    for (int i = fr.read(); i != -1; i = fr.read()) {
                        contenido += (char) i;
                    }
                    return contenido;

                } catch (IOException e) {
                    mensaje = "Error: no se pudo leer";
                    return mensaje;
                }
            } else {
                mensaje = "Error: debe seleccionar un archivo";
                return mensaje;
            }
        } else {
            mensaje = "Error: Archivo inexistente";
            return mensaje;
        }
    }

    public static String listarFiles(String path) {
        String mensaje;
        String lista = "";
        File listado = new File(path);

        if (listado.isDirectory()) {

            for (File archivo : listado.listFiles()) {
                lista += "\n ->" + archivo.getName();
            }

            return lista;
        } else {
            return "Error: debe seleccionar un directorio";
        }
    }

    public String getCurrentPath() {
        try {
            return currentDir.getCanonicalPath();
        } catch (Exception e) {
            System.out.println("Un error ha ocurrido intentando obtener el canonicalPath");
            return currentDir.getAbsolutePath();
        }

    }

    public static void main(String[] args) {
        System.out.println(listarFiles("C:\\Users\\HP\\Documents\\NetBeansProjects\\Programacion_2\\Holaa\\Folder # 0"));
    }

}

