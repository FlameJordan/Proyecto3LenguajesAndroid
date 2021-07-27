package ucr.cr.ac.proyecto3.model;

public class Vacuna {

    private String cedula_paciente;
    private String descripcion_vacuna_paciente;
    private String fecha_aplicacion;
    private String fecha_proxima_dosis;
    private String nombre_centro_salud;
    private String nombre_vacuna;

    public String getCedula_paciente() {
        return cedula_paciente;
    }

    public void setCedula_paciente(String cedula_paciente) {
        this.cedula_paciente = cedula_paciente;
    }

    public String getDescripcion_vacuna_paciente() {
        return descripcion_vacuna_paciente;
    }

    public void setDescripcion_vacuna_paciente(String descripcion_vacuna_paciente) {
        this.descripcion_vacuna_paciente = descripcion_vacuna_paciente;
    }

    public String getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(String fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public String getFecha_proxima_dosis() {
        return fecha_proxima_dosis;
    }

    public void setFecha_proxima_dosis(String fecha_proxima_dosis) {
        this.fecha_proxima_dosis = fecha_proxima_dosis;
    }

    public String getNombre_centro_salud() {
        return nombre_centro_salud;
    }

    public void setNombre_centro_salud(String nombre_centro_salud) {
        this.nombre_centro_salud = nombre_centro_salud;
    }

    public String getNombre_vacuna() {
        return nombre_vacuna;
    }

    public void setNombre_vacuna(String nombre_vacuna) {
        this.nombre_vacuna = nombre_vacuna;
    }
}
