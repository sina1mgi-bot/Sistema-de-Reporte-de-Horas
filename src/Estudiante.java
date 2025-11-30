import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario {
    private String matricula;
    private int totalHoras;
    private Proyecto proyectoAsignado;
    private List<ReporteDeHoras> reportes;
    private String nombre;


    public Estudiante(String nombre, String psww, String matricula) {
        super(nombre, psww);
        this.matricula = matricula;
        this.totalHoras = 0;
        this.reportes = new ArrayList<>();
        this.nombre = nombre;
    }

    public List<Proyecto> consultarProyectos(List <Proyecto> disponibles) {
        return disponibles;
    }

    public void asignarseProyecto (Proyecto proyecto) {
        this.proyectoAsignado = proyecto;
        proyecto.agregarEstudiante(this);
    }
    public void getNombre(String nombre){
        this.nombre = nombre;
    }

    public ReporteDeHoras crearReporte(String descripcion, int horas){
        ReporteDeHoras reporte = new ReporteDeHoras(descripcion, this, horas);
        reportes.add(reporte);
        return reporte;
    }

    public void corregirReporte (ReporteDeHoras reporte, String nuevaDescripcion, int nuevasHoras){
        reporte.setDescripcion(nuevaDescripcion);
        reporte.actualizarHoras(nuevasHoras);
    }

    public void sumarHoras(int horas) {
        if (horas > 0) {this.totalHoras += horas;}
    }

}
