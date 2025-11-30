import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReporteDeHoras {
    private String descripcion;
    private int numHorasReportadas;
    private Estudiante estudiante;
    private String estadoReporte;
    private Date fechaCreacion;
    private List<String> comentarios;

    public ReporteDeHoras(String descripcion, Estudiante estudiante, int horas){
        this.descripcion = descripcion == null? "":descripcion;
        this.numHorasReportadas = horas;
        this.estadoReporte = "PENDIENTE (EMPRESA)";
        this.fechaCreacion = new Date();
        this.estudiante = estudiante;
        this.comentarios = new ArrayList<>();
    }

    public void actualizarHoras(int nuevasHoras){
        if (nuevasHoras > 0){
            this.numHorasReportadas = nuevasHoras;
        }
    }

    public void setDescripcion(String nuevaDescripcion){
        this.descripcion = nuevaDescripcion;
    }

    public void actualizarEstado(String nuevoEstado){
        this.estadoReporte = nuevoEstado;
    }

    // Agregar estos getters
    public String getDescripcion() {
        return descripcion;
    }

    public int getNumHorasReportadas() {
        return numHorasReportadas;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public String getEstadoReporte() {
        return estadoReporte;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    // Método para agregar comentarios
    public void agregarComentario(String comentario) {
        this.comentarios.add(comentario);
    }
}