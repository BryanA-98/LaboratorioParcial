/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    private Cuenta cuenta;

    public Menu() {
        cuenta = new Cuenta();

        setTitle("Cajero ATM");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 30));
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel("MENÚ PRINCIPAL", SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        JButton btnSaldo = new JButton("Consultar Saldo");
        JButton btn100 = new JButton("Retirar Q100");
        JButton btn300 = new JButton("Retirar Q300");
        JButton btn500 = new JButton("Retirar Q500");
        JButton btnSalir = new JButton("Salir");

        estiloBoton(btnSaldo, new Color(0, 120, 215));
        estiloBoton(btn100, new Color(0, 153, 76));
        estiloBoton(btn300, new Color(0, 153, 76));
        estiloBoton(btn500, new Color(0, 153, 76));
        estiloBoton(btnSalir, Color.RED);

        btnSaldo.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Saldo: Q" + cuenta.getSaldo())
        );

        btn100.addActionListener(e -> retirar(100));
        btn300.addActionListener(e -> retirar(300));
        btn500.addActionListener(e -> retirar(500));
        btnSalir.addActionListener(e -> System.exit(0));

        panel.add(titulo);
        panel.add(btnSaldo);
        panel.add(btn100);
        panel.add(btn300);
        panel.add(btn500);
        panel.add(btnSalir);

        add(panel);
    }

    private void retirar(double monto) {
        if (cuenta.retirar(monto)) {
            JOptionPane.showMessageDialog(this,
                    "Retiro exitoso\nNuevo saldo: Q" + cuenta.getSaldo());
        } else {
            JOptionPane.showMessageDialog(this, "Saldo insuficiente");
        }
    }

    private void estiloBoton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
    }
}