import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private CardLayout cambio;
    private JPanel contenedor;

    public VentanaPrincipal(){
        setTitle("Sistema de Prácticas Profesionales");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cambio = new CardLayout();
        contenedor = new JPanel(cambio);

        JPanel loginPanel = crearLoginPanel();
        JPanel menu = crearMenuPanel();

        contenedor.add(loginPanel,"login");
        contenedor.add(menu, "menu");

        add(contenedor);

        cambio.show(contenedor,"login");



    }
    private JPanel crearLoginPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Iniciar Sesión");
        label.setBounds(100,20,200,30);
        panel.add(label);

        JTextField usuario = new JTextField();
        usuario.setBounds(150,80, 200,25);
        panel.add(usuario);

        JPasswordField pwss = new JPasswordField();
        pwss.setBounds(150,120,200,25);
        panel.add(pwss);

        JButton btn = new JButton("Iniciar");
        btn.setBounds(180,170,140,30);
        panel.add(btn);

        btn.addActionListener(e -> {
            String user = usuario.getText();
            String password = new String(pwss.getPassword());


            //prueba de que funciona lol
            if (user.equals("estudiante") && password.equals("1234")) {
                cambio.show(contenedor, "menu");
            } else {
                JOptionPane.showMessageDialog(panel, "Credenciales incorrectas");
            }
        });
        return panel;
    }
    private JPanel crearMenuPanel(){
        JPanel panel =  new JPanel();
        JLabel lbl = new JLabel("Bienvenido al Sistema");
        lbl.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(lbl);
        return panel;
    }



}
