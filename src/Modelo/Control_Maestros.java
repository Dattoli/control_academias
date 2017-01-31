package Modelo;

import Controlador.Conexion;
import Controlador.Maestro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Control_Maestros {
    String id_maestro ="";
    String nombre="";
    String a_paterno="";
    String a_materno="";
    String id_clase="";
    String clase="";

    public Control_Maestros(Maestro m) {
        this.nombre = m.getNombre();
        this.a_paterno = m.getApellido_paterno();
        this.a_materno = m.getApellido_materno();
        this.clase = m.getClase();
        this.recuperaIDClase();
    }
    
    
    public int altaMaestro(){
        int bandera = 0;
        String sql="";
        Conexion con = new Conexion();
        Connection conn = null;
        
        this.id_maestro=this.generaIDMaestro();
        
        sql = "INSERT INTO maestro values (?,?,?,?,?)";
        PreparedStatement ps;
        
        try {
            conn = con.conectar();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, this.id_maestro);
            ps.setString(2, this.nombre);
            ps.setString(3, this.a_paterno);
            ps.setString(4, this.a_materno);
            ps.setString(5,this.id_clase);
            
            ps.execute();
            conn.close();
            
            bandera = 1;
        } catch (SQLException ex) {
            Logger.getLogger(Control_Maestros.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error de SQL");
            bandera = 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Control_Maestros.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error de Inesperado");
            bandera = 0;
        }
        
        return bandera;
    }
    
    public String generaIDMaestro(){
        String aux="";
        aux=id_clase.substring(3, 5);
        
        return nombre.substring(0,1).toUpperCase()+a_paterno.substring(0, 1).toUpperCase()
                +a_materno.substring(0,1).toUpperCase()+aux;

    }
    
    public final String recuperaIDClase(){
        switch (clase.toLowerCase()){
            case "coreano basico":
                id_clase="KOR01";
                break;
            case "coreano intermedio":
                id_clase="KOR02";
                break;
            case "frances basico":
                id_clase="FRN01";
                break;
            case "frances intermedio":
                id_clase="FRN02";
                break;
            case "ingles basico":
                id_clase="ING01";
                break;
            case "ingles intermedio":
                id_clase="ING02";
                break;
            case "guitarra basico":
                id_clase="GTA01";
                break;
            case "guitarra intermedio":
                id_clase="GTA02";
                break;
            default:
                id_clase = "NA";
                break;
        }
        return id_clase;
    }
    
}
