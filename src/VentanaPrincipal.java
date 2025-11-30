import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class VentanaPrincipal extends JFrame {
    private CardLayout cambio;
    private JPanel contenedor;

    public VentanaPrincipal(){
        setTitle("Sistema de Prácticas Profesionales");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cambio = new CardLayout();
        contenedor = new JPanel(cambio);

        JPanel loginPanel = crearLoginPanel();
        JPanel menuEstudiante = crearMenuEstudiante();

        JPanel menuSupervisorPlaceholder = new JPanel();

        JPanel menuCoordinador = crearMenuCoordinador();
        JPanel menuJefeDepartamento = crearMenuJefeDepartamento();

        contenedor.add(loginPanel, "login");
        contenedor.add(menuEstudiante, "menuEstudiante");
        contenedor.add(menuSupervisorPlaceholder, "menuSupervisor"); // Usamos el placeholder
        contenedor.add(menuCoordinador, "menuCoordinador");
        contenedor.add(menuJefeDepartamento, "menuJefeDepartamento");

        add(contenedor);
        cambio.show(contenedor, "login");
    }

    private JPanel crearLoginPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Iniciar Sesión");
        label.setBounds(200,20,200,30);
        panel.add(label);

        //Usuario
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(70, 80, 80, 25);
        panel.add(lblUsuario);

        JTextField usuario = new JTextField();
        usuario.setBounds(150,80, 200,25);
        panel.add(usuario);

        //Contraseña
        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(70, 120, 80, 25);
        panel.add(lblPassword);

        JPasswordField pwss = new JPasswordField();
        pwss.setBounds(150,120,200,25);
        panel.add(pwss);

        JButton btn = new JButton("Iniciar");
        btn.setBounds(180,170,140,30);
        panel.add(btn);

        btn.addActionListener(e -> {
            String user = usuario.getText();
            String password = new String(pwss.getPassword());
            if (user.equals("estudiante") && password.equals("1234")) {
                cambio.show(contenedor, "menuEstudiante");

            } else if (user.equals("Supervisor") && password.equals("12345")) {

                // PRUEBA DE DATOS
                SupervisorEmpresa supervisorMock = new SupervisorEmpresa("Inge LeitoPP", "12345", "PepeElectronics");

                // DATOS PRUEBA
                Estudiante estu1 = new Estudiante("Luisito Rey", "123456", "14231");
                Proyecto proy1 = new Proyecto("Página Web", "TechCETYSZorroBot", new Date(), new Date(), "Java", 1, new ArrayList<>());

                // DATOS PRUEBA REPORTESSSSS
                ReporteDeHoras reporte1 = new ReporteDeHoras("AvanceKK", estu1, 10);
                ReporteDeHoras reporte2 = new ReporteDeHoras("CorreccionesPopo", estu1, 5);

                proy1.agregarReporte(reporte1);
                proy1.agregarReporte(reporte2);

                supervisorMock.agregarProyecto(proy1);

                JPanel panelSupervisorReal = crearMenuSupervisor(supervisorMock);
                contenedor.add(panelSupervisorReal, "menuSupervisor");
                cambio.show(contenedor, "menuSupervisor");

            } else if (user.equals("Coordinador") && password.equals("123456")) {


                cambio.show(contenedor, "menuCoordinador");
            } else if (user.equals("Jefe Departamento") && password.equals("1234567")) {

                cambio.show(contenedor, "menuJefeDepartamento");
            } else {
                JOptionPane.showMessageDialog(panel, "Credenciales incorrectas");
            }
        });
        return panel;
    }


    private JPanel crearMenuSupervisor(SupervisorEmpresa supervisor) {
        JPanel panel = new JPanel(new BorderLayout());


        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Bienvenido ");
        lbl.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(lbl);


        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> cambio.show(contenedor, "login"));
        topPanel.add(btnSalir);

        panel.add(topPanel, BorderLayout.NORTH);


        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> listaVisualReportes = new JList<>(listModel);

        List<ReporteDeHoras> reportesReales = new ArrayList<>();


        JScrollPane scrollPane = new JScrollPane(listaVisualReportes);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Reportes Pendientes de Revisión"));
        panel.add(scrollPane, BorderLayout.CENTER);

        // BTN
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton btnAprobar = new JButton("Aprobar");
        JButton btnRechazar = new JButton("Rechazar");

        btnAprobar.addActionListener(e -> {
            int index = listaVisualReportes.getSelectedIndex();

            if (index >= 0 && index < reportesReales.size()) {
                ReporteDeHoras reporteSeleccionado = reportesReales.get(index);
                supervisor.aprobarReporte(reporteSeleccionado);
                JOptionPane.showMessageDialog(panel, "Reporte Aprobado");
            } else {
                JOptionPane.showMessageDialog(panel, "Seleccione un reporte válido");
            }
        });

        btnRechazar.addActionListener(e -> {
            int index = listaVisualReportes.getSelectedIndex();
            if (index >= 0 && index < reportesReales.size()) {
                ReporteDeHoras reporteSeleccionado = reportesReales.get(index);
                String motivo = JOptionPane.showInputDialog(panel, "Ingrese motivo:");
                if (motivo != null && !motivo.trim().isEmpty()) {
                    supervisor.rechazarReporte(reporteSeleccionado, motivo);
                    JOptionPane.showMessageDialog(panel, "Reporte Rechazado");
                }
            } else {
                JOptionPane.showMessageDialog(panel, "Selecciona un reporte válido");
            }
        });

        btnPanel.add(btnAprobar);
        btnPanel.add(btnRechazar);
        panel.add(btnPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel crearMenuEstudiante(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel lbl = new JLabel("Bienvenido Estudiante", SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(lbl, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearMenuCoordinador(){
        JPanel panel = new JPanel(new BorderLayout());
        JLabel lbl = new JLabel("Bienvenido Coordinador", SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(lbl, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearMenuJefeDepartamento(){
        JPanel panel = new JPanel(new BorderLayout());
        JLabel lbl = new JLabel("Bienvenido Jefe de Departamento", SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(lbl, BorderLayout.CENTER);
        return panel;
    }
}