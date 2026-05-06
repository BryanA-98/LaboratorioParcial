package cajero;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private JPasswordField txtPin;
    private int intentos = 0;

    public Login() {
        setTitle("Cajero ATM");
        setSize(350, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 30));
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Título
        JLabel titulo = new JLabel("CAJERO AUTOMÁTICO", SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        // Campo PIN
        txtPin = new JPasswordField();
        txtPin.setFont(new Font("Arial", Font.PLAIN, 14));

        // Botón
        JButton btnIngresar = new JButton("Ingresar");
        estiloBoton(btnIngresar, new Color(0, 120, 215));

        btnIngresar.addActionListener(e -> verificarPIN());

        panel.add(titulo);
        JLabel lblPin = new JLabel("Ingrese PIN:", SwingConstants.CENTER);
lblPin.setForeground(Color.WHITE);
panel.add(lblPin);
        panel.add(txtPin);
        panel.add(btnIngresar);

        add(panel);
    }

    private void verificarPIN() {
        String pin = new String(txtPin.getPassword());

        if (pin.equals("1234")) {
            new Menu().setVisible(true);
            dispose();
        } else {
            intentos++;
            JOptionPane.showMessageDialog(this, "PIN incorrecto");

            if (intentos >= 3) {
                JOptionPane.showMessageDialog(this, "Acceso Bloqueado");
                System.exit(0);
            }
        }
    }

    private void estiloBoton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
    }
}