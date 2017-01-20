package Controlador;

public class Pagos {
    private String id_pago = "";
    private String fecha_pago = "";
    private String id_alumno = "";

    public Pagos() {
    }

    public String getId_pago() {
        return id_pago;
    }

    public void setId_pago(String id_pago) {
        this.id_pago = id_pago;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
    }

    @Override
    public String toString() {
        return "Pagos{" + "id_pago=" + id_pago + ", fecha_pago=" + fecha_pago + ", id_alumno=" + id_alumno + '}';
    }
  
}
