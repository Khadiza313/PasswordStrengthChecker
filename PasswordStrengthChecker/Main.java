import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;



public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Password Strength Checker");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel passLabel = new JLabel("Enter Password:");
        passLabel.setBounds(30, 30, 120, 25);
        frame.add(passLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 30, 180, 25);
        frame.add(passwordField);

        JLabel strengthLabel = new JLabel("Strength: ");
        strengthLabel.setBounds(30, 70, 300, 25);
        strengthLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        frame.add(strengthLabel);
        
        passwordField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String password = new String(passwordField.getPassword());
                String strength;

                if (password.length() == 0) {
                    strength = "Empty";
                    strengthLabel.setForeground(Color.GRAY);
                } 
                else if (password.length() < 6) {
                    strength = "Weak";
                    strengthLabel.setForeground(Color.BLACK);
                } 
                else if (password.length() < 10) {
                    strength = "Medium";
                    strengthLabel.setForeground(Color.BLUE);
                } 
                else {
                    strength = "Strong";
                    strengthLabel.setForeground(Color.RED);
                }

                strengthLabel.setText("Strength: " + strength);
            }
        });

        frame.setVisible(true);
    }
}