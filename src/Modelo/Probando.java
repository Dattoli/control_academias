package Modelo;
import Controlador.Clases;
import Controlador.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Probando {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<Clases> lista = new ArrayList<>();
        LoginUsuario ex = new LoginUsuario();
        Conexion con = new Conexion();
        
        try {
            con.conectar();
        } catch (ClassNotFoundException ex1) {
            Logger.getLogger(Probando.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
        lista = ex.recuperarTodas(con.conectar());
        
        for(Clases i: lista){
            System.out.println(i.toString());
        }
    }
}
