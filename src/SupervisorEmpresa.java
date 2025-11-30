import java.util.ArrayList;
import java.util.List;

public class SupervisorEmpresa extends Usuario{
    private String empresa;
    private List<Proyecto> proyectos;

    public SupervisorEmpresa(String nombre, String psww, String empresa) {
        super(nombre, psww);
        this.empresa = empresa;
        this.proyectos = new ArrayList<>();
    }

    public void getNombre(String nombre){
        this.nombre = nombre;
    }

    public void aprobarReporte(ReporteDeHoras reporte) {
        if (reporte.getEstadoReporte().equals("PENDIENTE")) {
            reporte.actualizarEstado("PENDIENTE");
            System.out.println("Reporte aprobado por el supervisor de empresa.");
        } else {
            System.out.println("El reporte no está en estado pendiente de revisión.");
        }
    }

    public void rechazarReporte(ReporteDeHoras reporte, String comentario) {
        if (reporte.getEstadoReporte().equals("PENDIENTE")) {
            reporte.actualizarEstado("RECHAZADO");
            reporte.agregarComentario(comentario);
            System.out.println("Reporte rechazado. Comentarios: " + comentario);
        } else {
            System.out.println("El reporte no está pendiente de revisión.");
        }
    }

    public List<ReporteDeHoras> obtenerReportesPendientes() {
        List<ReporteDeHoras> reportesPendientes = new ArrayList<>();


        if (this.proyectos != null) {
            for (Proyecto proyecto : proyectos) {
                if (proyecto.getReportes() != null) {

                    for (ReporteDeHoras reporte : proyecto.getReportes()) {
                        if ("PENDIENTE".equals(reporte.getEstadoReporte())) {

                            reportesPendientes.add(reporte);


                        }
                    }


                }




            }
        } return reportesPendientes;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void agregarProyecto(Proyecto proyecto) {
        this.proyectos.add(proyecto);
    }
}