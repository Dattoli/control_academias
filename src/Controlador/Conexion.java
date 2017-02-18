package Controlador;
import java.awt.Component;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
   private Connection cnx = null;
   public Connection conectar() throws SQLException, ClassNotFoundException {
      if (cnx == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/academiastoluca", "root", "");
         } catch (SQLException ex) {
            //throw new SQLException(ex);
            JOptionPane.showMessageDialog(null, ex+" Error SQL");
         } catch (ClassNotFoundException ex) {
            //throw new ClassCastException(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex+" Error de Clase");
         }/*finally{
             JOptionPane.showMessageDialog(null,"Conectado a la Base de Datos");
         }*/
      }
      return cnx;
   }
   public void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }
}
