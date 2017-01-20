package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Controlador.Clases;
import Controlador.Conexion;
import Controlador.Usuarios;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LoginUsuario {
   private final String tabla = "usuarios";
   String usuario = "";
   String password = "";
   
   public List<Clases> recuperarTodas(Connection conexion) throws SQLException{
      List<Clases> tareas = new ArrayList<>();
      try{
         PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            tareas.add(new Clases(resultado.getString("ID"), resultado.getString("NombreClase")));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return tareas;
   }
   
   public int loginUsuario(String usuario, String password) throws SQLException, ClassNotFoundException{
       this.usuario = usuario;
       this.password = password;
       int resultado = 0;
       String sql = "";
       
       Conexion con = new Conexion();
       Connection conn = null;
       
       con.conectar();
       
       sql = "SELECT * FROM usuarios WHERE usuario = '"+usuario+"' and password = '"+password+"'";
       //JOptionPane.showMessageDialog(null, sql);
       
       conn = con.conectar();
       Statement st = conn.createStatement();
       ResultSet rs = st.executeQuery(sql);
       
       if(rs.next()){
           resultado = 1;
       }else{
           resultado = 0;
       }
       
       JOptionPane.showMessageDialog(null, "Bienvenido: "+rs.getString("nombre"));
       
       st.close();
       conn.close();
       con.cerrar();  
       
       return resultado;
   }
}
