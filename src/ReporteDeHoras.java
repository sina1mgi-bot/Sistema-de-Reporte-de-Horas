import java.util.Date;

public class ReporteDeHoras {
    private String descripcion;
    private int numHorasReportadas;
    private Estudiante estudiante;
    private String estadoReporte;
    private Date fechaCreacion;

    public ReporteDeHoras(String descripcion, Estudiante estudiante, int numHorasReportadas){
        this.estadoReporte = "PENDIENTE EMPRESA";
        this.descripcion = descripcion;
        this.fechaCreacion = new Date();
        this.estudiante = estudiante;
        this.numHorasReportadas = numHorasReportadas;
    }

}
