package ucr.cr.ac.proyecto3.Request;

public class PacienteEditRequest {

    private String cedula_paciente;

    private String estado_civil;
    private String provincia ;
    private String canton;
    private String distrito;
    private String seña;
    private String[] telefonosOld = new String[3];
    private String[] telefonosNew;


    public String getCedula_paciente() {
        return cedula_paciente;
    }

    public void setCedula_paciente(String cedula_paciente) {
        this.cedula_paciente = cedula_paciente;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getSeña() {
        return seña;
    }

    public void setSeña(String seña) {
        this.seña = seña;
    }

    public String[] getTelefonosOld() {
        return telefonosOld;
    }

    public void setTelefonosOld(String[] telefonosOld) {
        this.telefonosOld = telefonosOld;
    }

    public String[] getTelefonosNew() {
        return telefonosNew;
    }

    public void setTelefonosNew(String[] telefonosNew) {
        this.telefonosNew = telefonosNew;
    }
}
