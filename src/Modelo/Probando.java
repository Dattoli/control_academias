package Modelo;
import Controlador.Clases;
import Controlador.Conexion;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Probando {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.format(fecha);
        System.out.println (formato.format(fecha).toString());
        
    }
}
