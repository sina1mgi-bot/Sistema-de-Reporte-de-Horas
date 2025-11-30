import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Proyecto {
    private String nombre;
    private String empresa;
    private Date fechaInicio;
    private Date fechaFin;
    private String actividades;
    private int numParticipantes;
    private List<Estudiante> estudiantesAsignados;
    private List<ReporteDeHoras> reportes;


    public Proyecto(String nombre, String empresa, Date fechaInicio, Date fechaFin, String actividades, int numParticipantes, List<Estudiante> listaEstudiantes) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.numParticipantes = numParticipantes;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.actividades = actividades;
        this.estudiantesAsignados = listaEstudiantes;
        this.reportes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantesAsignados.add(estudiante);
    }

    public List<ReporteDeHoras> getReportes() {
        return reportes;
    }

    public void agregarReporte(ReporteDeHoras reporte) {
        this.reportes.add(reporte);
    }


}