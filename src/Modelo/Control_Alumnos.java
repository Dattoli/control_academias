package Modelo;

import Controlador.Alumno;
import Controlador.Clases;
import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Uknown
 */
public class Control_Alumnos {
    private final String tablaAlumno ="";
    String id_alumno="";
    String nombre = "";
    String a_paterno = "";
    String a_materno = "";
    String email = "";
    int edad = 0;
    String sexo = "";
    String fecha = "";
    String telefono = "";
    String clase = "";
    String horario = "";
    String id_clase="";
    String id_maestro ="";
    
    public Control_Alumnos(String nombre, String a_paterno, String a_materno, String email, int edad, String sexo,
            String fecha, String telefono, String clase, String horario){
        this.nombre=nombre;
        this.a_paterno=a_paterno;
        this.a_materno=a_materno;
        this.email=email;
        this.edad=edad;
        this.sexo=sexo;
        this.fecha=fecha;
        this.telefono=telefono;
        this.clase=clase;
        this.horario=horario;
    }
    public Control_Alumnos(){
    }
    
    public int insertaUsuario(){
        int resultado = 0;
        String sql="";
        Conexion con = new Conexion();
        Connection conn = null;

        this.recuperaIDClase();

        //JOptionPane.showMessageDialog(null, id_clase+" "+id_maestro);
        sql = "INSERT INTO alumno values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            id_alumno=this.recuperaID();
            this.recuperaIDMaestro(id_clase);
            
            conn = con.conectar();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, id_alumno);
            ps.setString(2, nombre);
            ps.setString(3, a_paterno);
            ps.setString(4, a_materno);
            ps.setString(5, email);
            ps.setInt(6,edad);
            ps.setString(7, sexo);
            ps.setString(8, fecha);
            ps.setString(9, telefono);
            ps.setString(10, id_clase);
            ps.setString(11, horario);
            ps.setString(12, id_maestro);
            ps.setString(13, "ACTIVO");
            ps.execute();
            conn.close();
            resultado = 1;
        } catch (SQLException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error de SQL");
            resultado = 0;
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error Inesperado");
            resultado = 0;
        }
        return resultado;
    }
    
    public Alumno recuperaAlumno(Alumno alumno, Clases clase){
        this.id_alumno = alumno.getId_alumno();
        String sql = "";
        Conexion con = new Conexion();
        Connection conn = null;
        Statement st;
        ResultSet rs;
        
        sql = "SELECT a.id_alumno, a.nombre, a.apellido_paterno, b.NombreClase, a.status "
                + "from alumno a, clase b WHERE a.id_clase_registrada = b.ID and id_alumno = '"+id_alumno+"'";
        
        //JOptionPane.showMessageDialog(null, sql);
        
        try {
            conn = con.conectar();
        } catch (SQLException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse a la BD");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error desconocido al intentar conectarse");
        }
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                alumno.setNombre(rs.getString("nombre"));
                alumno.setId_alumno(rs.getString("id_alumno"));
                alumno.setApellido_paterno(rs.getString("apellido_paterno"));
                clase.setNombreClase(rs.getString("NombreClase"));
                alumno.setStatus(rs.getString("status"));
                
                return alumno;
            }else{
                JOptionPane.showMessageDialog(null, "Alummno Inexistente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return alumno;
    }
    
    public int bajaAlumno(String id_alumno){
        this.id_alumno = id_alumno;
        int bandera;
        String sql = "";
        Conexion con = new Conexion();
        Connection conn = null;
        PreparedStatement ps;
        
        sql = "UPDATE alumno set status = 'INACTIVO' WHERE id_alumno = ?";
        
        try {
            conn = con.conectar();
        } catch (SQLException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse a la BD");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error desconocido al intentar conectarse");
        }

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id_alumno);
            ps.executeUpdate();
            
            conn.close();
            
            bandera = 1;
        } catch (SQLException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            bandera = 0;
        }
        return bandera;
    }
    
    public String recuperaID() throws SQLException, ClassNotFoundException{
        String sql="";
        int resultadob=0;
        String resultado = "";
        Conexion con = new Conexion();
        Connection conn = null;
        
        sql = "SELECT MAX(id_alumno) as id_alumno FROM alumno";
        conn = con.conectar();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        if(rs.next()){
            //JOptionPane.showMessageDialog(null, rs.getString("id_alumno"));
            resultado = rs.getString("id_alumno");
            resultadob =Integer.parseInt(resultado)+1;
            if(resultadob<10){
                resultado = "0000"+ resultadob;
            }else if(resultadob>=10 && resultadob<100){
                resultado = "000"+ resultadob;
            }else if(resultadob>=100 && resultadob<1000){
                resultado = "00"+ resultadob;
            }else{
                resultado = "0000"+ resultadob;
            }
            
        }else{
            resultado = "00001";
        }
        
        return resultado;
    }
    
    public String recuperaIDClase(){
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
    
    public String recuperaIDMaestro(String id_clase) throws SQLException, ClassNotFoundException{
        String sql="";
        String clase = id_clase;
        Conexion con = new Conexion();
        Connection conn = null;
        
        sql = "SELECT id_maestro FROM maestro WHERE id_clase ='"+clase+"'";
        conn = con.conectar();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        if(rs.next()){
            //JOptionPane.showMessageDialog(null, rs.getString("id_alumno"));
            id_maestro = rs.getString("id_maestro");
        }else{
            id_maestro = "NA";
        }
        
        return id_maestro;
    }
}
