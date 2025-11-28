import java.util.ArrayList;
import java.util.List;

public class CoordinadorAcademico extends Usuario{
    private List<ReporteDeHoras> reportesPendientes;

    public CoordinadorAcademico(String nombre, String psww) {
        super(nombre, psww);
        this.reportesPendientes = new ArrayList<>();
    }
}
