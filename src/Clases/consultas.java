    package Clases;

import Formularios.Escritorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class consultas {
    public void guardarUsuario(String usuario, String password, JFrame frame){
        ConexionDB db = new ConexionDB();
        String sql = "insert into usuarios(nombre, clave) values ('" + usuario +"', '" + password +"');";
        Statement st;
        Connection conexion = db.conectar();
        if (usuario.length()<5){
          JOptionPane.showMessageDialog(null, "Usuario no Guardado, el usuario ingresado debe tener como minimo 5 caracteres");
          return;
        }else if(password.length()<4){
              JOptionPane.showMessageDialog(null, "Usuario no Guardado, la contraseña ingresada debe tener como minimo 5 caracteres");
          return;
        }
        try
        {
            st = conexion.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
             // Esto supone que estás llamando a guardarUsuario() desde un objeto dentro del formulario
        frame.dispose();
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    public void consultarUsuario(String user, String pass, JFrame frame)
    {
        // TODO add your handling code here:
        ConexionDB db = new ConexionDB();
        // Se inicializa a null
        String usuarioCorrecto = null;
        String passCorrecto = null;
    try {

        Connection cn = db.conectar();
        PreparedStatement pst = cn.prepareStatement("SELECT nombre, clave FROM usuarios where nombre ='"+ user +"' and clave = '"+pass+"'");
        ResultSet rs = pst.executeQuery();
        System.out.println(rs);
      

        if (rs.next()) {
            usuarioCorrecto = rs.getString(1);
            passCorrecto = rs.getString(2);
            
        } 
         
        if (user.equals(usuarioCorrecto) && pass.equals(passCorrecto)) {
            Escritorio esc=new Escritorio();
            esc.setVisible(true);
          // JOptionPane.showMessageDialog(null, "Login correcto Bienvenido " + user);
            frame.dispose();
            
            
        } else if (!user.equals(usuarioCorrecto) || pass.equals(passCorrecto)) {
         
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error " + e);
    }
    }
    
}
