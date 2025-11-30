import javax.swing.*;

public class VentanaInicioSesion extends JFrame{
    private JLabel inicioSesionLbl;
    private JLabel tituloBienve;
    private JTextField usuarioField;
    private JPasswordField passwordField;
    private JButton entrarBtn;
    private JLabel usuarioLbl;
    private JLabel passLbl;

    public VentanaInicioSesion(){
        setTitle("Inicio Sesión");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        tituloBienve.setBounds(130, 20, 200, 30);

        usuarioLbl.setBounds(50, 70, 80, 25);
        usuarioField.setBounds(130, 70, 150, 25);

        passLbl.setBounds(50, 110, 80, 25);
        passwordField.setBounds(130, 110, 150, 25);

        entrarBtn.setBounds(140, 160, 100, 30);
    add(inicioSesionLbl);
    add(tituloBienve);
    add(usuarioLbl);
    add(passLbl);
    add(usuarioField);
    add(passwordField);
    add(entrarBtn);
    }
}
