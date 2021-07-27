package ucr.cr.ac.proyecto3.model;

public class Cita {

    private int cod_cita;
    private String nombre_centro_salud;
    private String nombre_especialidad;
    private String medico;
    private String fecha_hora;
    private String cita_descripcion;

    public int getCod_cita() {
        return cod_cita;
    }

    public void setCod_cita(int cod_cita) {
        this.cod_cita = cod_cita;
    }

    public String getNombre_centro_salud() {
        return nombre_centro_salud;
    }

    public void setNombre_centro_salud(String nombre_centro_salud) {
        this.nombre_centro_salud = nombre_centro_salud;
    }

    public String getNombre_especialidad() {
        return nombre_especialidad;
    }

    public void setNombre_especialidad(String nombre_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getCita_descripcion() {
        return cita_descripcion;
    }

    public void setCita_descripcion(String cita_descripcion) {
        this.cita_descripcion = cita_descripcion;
    }
}
