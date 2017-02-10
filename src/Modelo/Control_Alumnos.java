package Modelo;

import Controlador.Alumno;
import Controlador.Clases;
import Controlador.Conexion;
import Vista.Consultas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    String id_asistencia = "";
    String fechaAsistencia = "";
    String fechaPago = "";
    
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
    
    public int asistencia(Alumno alumno, String fecha){
        this.id_alumno = alumno.getId_alumno();
        int bandera = 0;
        String sql = "";
        Conexion con = new Conexion();
        Connection conn = null;
        this.fechaAsistencia = fecha;
        
//JOptionPane.showMessageDialog(null, id_clase+" "+id_maestro);
        sql = "INSERT INTO asistencia values(?,?,?,?,?)";
        PreparedStatement ps;
        try {
            id_asistencia = this.recuperaIdAsistencia().toString();
            
            conn = con.conectar();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, id_asistencia);
            ps.setString(2, id_alumno);
            ps.setString(3, alumno.getNombre());
            ps.setString(4, alumno.getApellido_paterno());
            ps.setString(5, fechaAsistencia);
            ps.execute();
            conn.close();
            bandera = 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error de SQL");
            bandera = 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error Inesperado");
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
    
    public String recuperaIdAsistencia() throws SQLException, ClassNotFoundException{
        String sql="";
        int resultadob=0;
        String resultado = "";
        Conexion con = new Conexion();
        Connection conn = null;
        
        sql = "SELECT COUNT(id_asistencia) as id_asistencia FROM asistencia";
        conn = con.conectar();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        if(rs.next()){
            
            resultado = rs.getString("id_asistencia");
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
    
    public String obtenerFechaPago(String id_alumno){
        String sql="";
        String alumno = id_alumno;
        Conexion con = new Conexion();
        Connection conn = null;
        
        sql = "SELECT fch_proximo_pago FROM fechaspagos WHERE id_alumno = '"+alumno+"'";
        try {
            conn = con.conectar();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                //JOptionPane.showMessageDialog(null, rs.getString("id_alumno"));
                fechaPago = rs.getString("fch_proximo_pago");
            }else{
                fechaPago = "NA";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fechaPago;
    }
    
    public int registraPago(String id_alumno, String fecha, String pago){
        this.id_alumno = id_alumno;
        this.fechaPago = fecha;
        String cantidad = pago;
        int bandera = 0;
        String sqll = "";
        String sql2 = "";
        String resultado = "";
        int resultadob = 0;
        Conexion con = new Conexion();
        Connection conn = null;
        
        sqll = "SELECT MAX(id_pago) as id_pago FROM pagos";
        
        //Obtenemos el ID del Pago a Insertar
        try {
            conn = con.conectar();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqll);
            
            if(rs.next()){
                //JOptionPane.showMessageDialog(null, rs.getString("id_alumno"));
                resultado = rs.getString("id_pago");
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
            
        } catch (SQLException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al generar el ID del Pago");
            bandera = 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error desconocido al generar el ID Pago");
            bandera = 0;
        }
        
        //Insertamos el Pago en la Tabla
        
        sql2 = "INSERT INTO pagos values(?,?,?,?)";
        PreparedStatement ps;
        
        try {
            ps = conn.prepareStatement(sql2);
            
            ps.setString(1, resultado);
            ps.setString(2, this.id_alumno);
            ps.setString(3, fechaPago);
            ps.setString(4, cantidad);
            
            ps.execute();
            conn.close();
            bandera = 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(Control_Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Insertar el Pago");
            bandera = 0;
        }
        
        return bandera;
    }
    
    /*SECCION DE METODOS PARA CONSULTA DE DATOS*/
    
    public String[] getColumnas(String opcion){
        String columna[]={};
        switch(opcion){
            case "ALUMNOS ACTIVOS":
                String col[]={"ID ALUMNO", "NOMBRE", "A PATERNO", "A MATERNO", "ID CLASE", "HORARIO", "STATUS"};
                columna = col;
                break;
            case "ALUMNOS INACTIVOS":
                String col2[]={"ID ALUMNO", "NOMBRE", "A PATERNO", "A MATERNO", "ID CLASE", "HORARIO", "STATUS"};
                columna = col2;
                break;
            case "MAESTROS":
                String col3[]={"ID MAESTRO", "NOMBRE", "APELLIDO PATERNO","APELLIDO MATERNO", "ID CLASE" };
                columna = col3;
                break;
            default:
                break;
        }
        
        return columna;
    }
    
    public void setFilas(DefaultTableModel modeloTabla, String opcion){
        String sql = "";
        Conexion con = new Conexion();
        Connection conn = null;
        Object datos[] = null; //Numero de Columnas de la Tabla
        
        switch(opcion){
            case "ALUMNOS ACTIVOS":
                sql = "SELECT id_alumno, nombre, apellido_paterno, apellido_materno, id_clase_registrada, horario, STATUS FROM alumno "
                        + "WHERE STATUS = 'ACTIVO'";
                datos= new Object[7];
                break;
            case "ALUMNOS INACTIVOS":
                sql = "SELECT id_alumno, nombre, apellido_paterno, apellido_materno, id_clase_registrada, horario, STATUS FROM alumno "
                        + "WHERE STATUS = 'INACTIVO'";
                datos= new Object[7];
                break;
            case "MAESTROS":
                sql = "SELECT * FROM maestro";
                datos= new Object[5];
                break;
            default:
                break;
        }
        
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                for(int i = 0; i<datos.length; i++){
                    datos[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(datos);
            }
            
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] getColumnasClase(){
        String columna[]={"ID ALUMNO", "NOMBRE", "A PATERNO", "A MATERNO", "ID CLASE", "HORARIO", "STATUS"};
        
        return columna;
    }
    
    public void setFilasClase(DefaultTableModel modeloTabla, String opcion){
        String sql = "";
        Conexion con = new Conexion();
        Connection conn = null;
        Object datos[] = null; //Numero de Columnas de la Tabla
        
        switch(opcion){
            case "COREANO BASICO":
                sql = "SELECT id_alumno, nombre, apellido_paterno, apellido_materno, id_clase_registrada, horario, STATUS FROM alumno "
                        + "WHERE STATUS = 'ACTIVO' AND id_clase_registrada = 'KOR01'";
                datos= new Object[7];
                break;
            case "COREANO INTERMEDIO":
                sql = "SELECT id_alumno, nombre, apellido_paterno, apellido_materno, id_clase_registrada, horario, STATUS FROM alumno "
                        + "WHERE STATUS = 'ACTIVO' AND id_clase_registrada = 'KOR02'";
                datos= new Object[7];
                break;
            case "INGLES BASICO":
                sql = "SELECT id_alumno, nombre, apellido_paterno, apellido_materno, id_clase_registrada, horario, STATUS FROM alumno "
                        + "WHERE STATUS = 'ACTIVO' AND id_clase_registrada = 'ING01'";
                datos= new Object[7];
                break;
            case "INGLES INTERMEDIO":
                sql = "SELECT id_alumno, nombre, apellido_paterno, apellido_materno, id_clase_registrada, horario, STATUS FROM alumno "
                        + "WHERE STATUS = 'ACTIVO' AND id_clase_registrada = 'ING02'";
                datos= new Object[7];
                break;
            case "FRANCES BASICO":
                sql = "SELECT id_alumno, nombre, apellido_paterno, apellido_materno, id_clase_registrada, horario, STATUS FROM alumno "
                        + "WHERE STATUS = 'ACTIVO' AND id_clase_registrada = 'FRN01'";
                datos= new Object[7];
                break;
            case "FRANCES INTERMEDIO":
                sql = "SELECT id_alumno, nombre, apellido_paterno, apellido_materno, id_clase_registrada, horario, STATUS FROM alumno "
                        + "WHERE STATUS = 'ACTIVO' AND id_clase_registrada = 'FRN02'";
                datos= new Object[7];
                break;
            case "GUITARRA BASICO":
                sql = "SELECT id_alumno, nombre, apellido_paterno, apellido_materno, id_clase_registrada, horario, STATUS FROM alumno "
                        + "WHERE STATUS = 'ACTIVO' AND id_clase_registrada = 'GTA01'";
                datos= new Object[7];
                break;
            case "GUITARRA INTERMEDIO":
                sql = "SELECT id_alumno, nombre, apellido_paterno, apellido_materno, id_clase_registrada, horario, STATUS FROM alumno "
                        + "WHERE STATUS = 'ACTIVO' AND id_clase_registrada = 'GTA02'";
                datos= new Object[7];
                break;
            default:
                break;
        }
        
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                for(int i = 0; i<datos.length; i++){
                    datos[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(datos);
            }
            
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
