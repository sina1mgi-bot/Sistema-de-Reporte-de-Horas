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

}
