package Controlador;

public class Asistencia {
    private String id_asistencia ="";
    private String id_alumno = "";
    private String nombre_alumno = "";
    private String apellido_paterno = "";
    private String fecha_asistencia = "";

    public Asistencia() {
    }

    public String getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(String id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getFecha_asistencia() {
        return fecha_asistencia;
    }

    public void setFecha_asistencia(String fecha_asistencia) {
        this.fecha_asistencia = fecha_asistencia;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "id_asistencia=" + id_asistencia + ", id_alumno=" + id_alumno + ", nombre_alumno=" + nombre_alumno + ", apellido_paterno=" + apellido_paterno + ", fecha_asistencia=" + fecha_asistencia + '}';
    }
    
}
