import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario {
    private String matricula;
    private int totalHoras;
    private Proyecto proyectoAsignado;
    private List<ReporteDeHoras> reportes;


    public Estudiante(String nombre, String psww, String matricula) {
        super(nombre, psww);
        this.matricula = matricula;
        this.totalHoras = 0;
        this.reportes = new ArrayList<>();
    }

}
