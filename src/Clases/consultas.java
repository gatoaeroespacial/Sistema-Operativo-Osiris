package Clases;

import Formularios.Escritorio;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class consultas {

    private static final String BASE_DIRECTORY = "C:\\Users\\juanm\\OneDrive\\Documentos\\NetBeansProjects\\SOsiris\\src\\Users"; // Cambia esta ruta a la ubicación deseada

    public void guardarUsuario(String usuario, String password, JFrame frame) {
        ConexionDB db = new ConexionDB();
        String sql = "insert into usuarios(nombre, clave) values ('" + usuario + "', '" + password + "');";
        Statement st;
        Connection conexion = db.conectar();
        if (usuario.length() < 5) {
            JOptionPane.showMessageDialog(null, "Usuario no Guardado, el usuario ingresado debe tener como minimo 5 caracteres");
            return;
        } else if (password.length() < 4) {
            JOptionPane.showMessageDialog(null, "Usuario no Guardado, la contraseña ingresada debe tener como minimo 5 caracteres");
            return;
        }
        try {
            st = conexion.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
            // Esto supone que estás llamando a guardarUsuario() desde un objeto dentro del formulario
            frame.dispose();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

   public void consultarUsuario(String user, String pass, JFrame frame) {
    ConexionDB db = new ConexionDB();
    String usuarioCorrecto = null;
    String passCorrecto = null;
    try {
        Connection cn = db.conectar();
        PreparedStatement pst = cn.prepareStatement("SELECT nombre, clave, init, idUsuario FROM usuarios where nombre = ? and clave = ?");
        pst.setString(1, user);
        pst.setString(2, pass);
        ResultSet rs = pst.executeQuery();
        System.out.println(rs);

        if (rs.next()) {
            usuarioCorrecto = rs.getString(1);
            passCorrecto = rs.getString(2);
        }

        if (user.equals(usuarioCorrecto) && pass.equals(passCorrecto)) {
            System.out.println(rs.getString(3));
            if (rs.getString(3).equals("NO")) {
                pst = cn.prepareStatement("UPDATE usuarios SET init = 'SI' WHERE idUsuario = ?");
                pst.setString(1, rs.getString(4));
                int updateResult = pst.executeUpdate();
                System.out.println(updateResult);
                crearCarpetasUser(user);
            }

            Escritorio esc = new Escritorio(BASE_DIRECTORY+"\\" + user);
            esc.setVisible(true);
            frame.dispose();

        } else if (!user.equals(usuarioCorrecto) || pass.equals(passCorrecto)) {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error " + e);
    }
}

    public static void crearCarpetasUser(String nombreUser) {
        // Define la ruta de la carpeta principal del usuario
        String userDirPath = BASE_DIRECTORY + File.separator + nombreUser;

        // Crea un arreglo con los nombres de las carpetas a crear
        String[] subCarpetas = {"Documentos", "Escritorio", "Descargas", "Música", "Videos"};

        // Crea la carpeta principal del usuario
        File userDir = new File(userDirPath);
        if (!userDir.exists()) {
            if (userDir.mkdirs()) {
                System.out.println("Carpeta principal creada: " + userDirPath);
            } else {
                System.out.println("Error al crear la carpeta principal: " + userDirPath);
                return;
            }
        }

        // Crea las subcarpetas
        for (String carpeta : subCarpetas) {
            File subCarpeta = new File(userDirPath + File.separator + carpeta);
            if (!subCarpeta.exists()) {
                if (subCarpeta.mkdirs()) {
                    System.out.println("Carpeta creada: " + subCarpeta.getPath());
                } else {
                    System.out.println("Error al crear la carpeta: " + subCarpeta.getPath());
                }
            }
        }
    }

}
