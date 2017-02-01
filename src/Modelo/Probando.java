package Modelo;
import Controlador.Clases;
import Controlador.Conexion;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Probando {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        Date fecha = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //Para declarar valores en nuevos objetos date, usa el mismo formato date que usaste al crear las fechas 
        Date date1 = sdf.parse("1995-02-23"); //date1 es el 23 de febrero de 1995
        Date date2 = sdf.parse("1995-02-23"); //date2 es el 31 de octubre de 2001
        Date date3 = sdf.parse("1995-02-23");
        
        System.out.println(date1.compareTo(date2));
        
    }
}
