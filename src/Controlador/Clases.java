package Controlador;

public class Clases {
   private String id_clase;
   private String nombreClase;
   
   public Clases() {
      this.id_clase = null;
      this.nombreClase = null;
   }
   
   public Clases(String id_clase, String nombreClase) {
      this.id_clase = id_clase;
      this.nombreClase = nombreClase;
   }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getId_clase() {
        return id_clase;
    }

    public void setId_clase(String id_clase) {
        this.id_clase = id_clase;
    }
   
   @Override
   public String toString() {
      return "Clase{" + "id_clase=" + id_clase + ", Nombre=" + nombreClase + '}';
   } 
}