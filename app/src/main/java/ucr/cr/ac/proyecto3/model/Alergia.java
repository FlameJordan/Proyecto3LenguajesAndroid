package ucr.cr.ac.proyecto3.model;

public class Alergia {


    public int cod_alergia;
    public String cedula_paciente;
    public String nombre_alergia;
    public String descripcion_alergia;
    public String fecha_diagnostico;
    public String medicamentos;

    public int getCod_alergia() {
        return cod_alergia;
    }

    public void setCod_alergia(int cod_alergia) {
        this.cod_alergia = cod_alergia;
    }

    public String getCedula_paciente() {
        return cedula_paciente;
    }

    public void setCedula_paciente(String cedula_paciente) {
        this.cedula_paciente = cedula_paciente;
    }

    public String getNombre_alergia() {
        return nombre_alergia;
    }

    public void setNombre_alergia(String nombre_alergia) {
        this.nombre_alergia = nombre_alergia;
    }

    public String getDescripcion_alergia() {
        return descripcion_alergia;
    }

    public void setDescripcion_alergia(String descripcion_alergia) {
        this.descripcion_alergia = descripcion_alergia;
    }

    public String getFecha_diagnostico() {
        return fecha_diagnostico;
    }

    public void setFecha_diagnostico(String fecha_diagnostico) {
        this.fecha_diagnostico = fecha_diagnostico;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }
}
