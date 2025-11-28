import java.util.Date;

public class SolicituDeLiberacion {
    private Estudiante estudiante;
    private String estadoSolicitod;
    private Date fechaSolicitud;

    public SolicituDeLiberacion(Estudiante estudiante){
        this.estudiante = estudiante;
        this.estadoSolicitod = "GENERADA";
        this.fechaSolicitud = new Date();

    }



}
