package Controlador;

public class Alumno {
    private String id_alumno          = "";
    private String nombre             = "";
    private String apellido_paterno   = "";
    private String apellido_materno   = "";
    private String fecha_registro     = "";
    private String telefono_contacto  = "";
    private String id_clase_registrada= "";
    private String horario            = "";
    private String id_maestro         = "";
    private String email              = "";
    private int edad                  = 0;
    private String sexo               = "";

    public Alumno() {
    }

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
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

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getTelefono_contacto() {
        return telefono_contacto;
    }

    public void setTelefono_contacto(String telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    public String getId_clase_registrada() {
        return id_clase_registrada;
    }

    public void setId_clase_registrada(String id_clase_registrada) {
        this.id_clase_registrada = id_clase_registrada;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getId_maestro() {
        return id_maestro;
    }

    public void setId_maestro(String id_maestro) {
        this.id_maestro = id_maestro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id_alumno=" + id_alumno + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", fecha_registro=" + fecha_registro + ", telefono_contacto=" + telefono_contacto + ", id_clase_registrada=" + id_clase_registrada + ", horario=" + horario + ", id_maestro=" + id_maestro + ", email=" + email + ", edad=" + edad + ", sexo=" + sexo + '}';
    }
    
}
