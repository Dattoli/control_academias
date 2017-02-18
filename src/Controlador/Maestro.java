package Controlador;

public class Maestro {
    private String id_maestro       = "";
    private String nombre           = "";
    private String apellido_paterno = "";
    private String apellido_materno = "";
    private String id_clase         = "";
    private String clase            = "";

    public Maestro() {
    }

    public String getId_maestro() {
        return id_maestro;
    }

    public void setId_maestro(String id_maestro) {
        this.id_maestro = id_maestro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getId_clase() {
        return id_clase;
    }

    public void setId_clase(String id_clase) {
        this.id_clase = id_clase;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "Maestro{" + "id_maestro=" + id_maestro + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", id_clase=" + id_clase + ", clase=" + clase + '}';
    }
    
}
