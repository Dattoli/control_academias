package Modelo;

import Controlador.Maestro;

public class Control_Maestros {
    String id_maestro ="";
    String nombre="";
    String a_paterno="";
    String a_materno="";
    String id_clase="";
    String clase="";
    
    Maestro m = new Maestro();

    public Control_Maestros(String nombre, String a_paterno, String a_materno, String clase) {
        m.setNombre(nombre);
        m.setApellido_paterno(a_paterno);
        m.setApellido_materno(a_materno);
        m.setId_clase(this.recuperaIDClase());
    }
    
    public String generaIDMaestro(){
        String aux="";
        
        aux=m.getId_clase().substring(3, 2);
        
        return m.getNombre().substring(0,1).toUpperCase()+m.getApellido_paterno().substring(0, 1).toUpperCase()
                +m.getApellido_materno().substring(0,1).toUpperCase()+aux;

    }
    
    
    public final String recuperaIDClase(){
        switch (m.getClase().toLowerCase()){
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
