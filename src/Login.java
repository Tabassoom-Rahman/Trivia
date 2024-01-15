import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    static boolean successful = false;

    public Login() {
        JFrame frame = new JFrame("Login");

        ImageIcon image = new ImageIcon("src\\logok3.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(233, 203, 245));

        JLabel userLabel = new JLabel("USERNAME");
        JLabel passwordLabel = new JLabel("PASSWORD");
        JTextField userTextField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("LOGIN");
        JButton signupButton = new JButton("SIGN-UP");
        JCheckBox showPassword = new JCheckBox("Show Password");

        userLabel.setBounds(100,125,100,30);
        passwordLabel.setBounds(100,200,100,30);
        userTextField.setBounds(200,125,150,30);
        passwordField.setBounds(200,200,150,30);
        showPassword.setBounds(200,250,150,30);
        loginButton.setBounds(100,375,120,40);
        signupButton.setBounds(270,375,120,40);

        showPassword.addActionListener(e -> {
            if(showPassword.isSelected())
                passwordField.setEchoChar((char)0);
            else
                passwordField.setEchoChar('*');
        });

        loginButton.addActionListener(e -> {

            if(userTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "Enter User Name", "Authentication error", JOptionPane.ERROR_MESSAGE);
            }
            else if(passwordField.getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "Enter Password", "Authentication error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                FileWriter myWriter = null;
                try {
                    myWriter = new FileWriter("src\\logged_in.txt");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    myWriter.write(userTextField.getText());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    myWriter.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                File username = new File("src\\username.txt");
            Scanner UN = null;
            try {
                UN = new Scanner(username);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

            int numberOfUsers = 0;
            String[] UserNames = new String[100];
            for(int i = 0; Objects.requireNonNull(UN).hasNextLine(); i++) {
                UserNames[i] = "";
                UserNames[i] += UN.nextLine();
                numberOfUsers++;
            }

            File password = new File("src\\password.txt");
            Scanner PW = null;
            try {
                PW = new Scanner(password);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            String[] PassWords = new String[100];
            for(int i = 0; Objects.requireNonNull(PW).hasNextLine(); i++) {
                PassWords[i] = "";
                PassWords[i] += PW.nextLine();
            }

            int foundIndex = -1;
            for(int i = 0; i < numberOfUsers; i++) {
                if(userTextField.getText().equals(UserNames[i])) {
                    foundIndex = i;
                    break;
                }
            }

            if(foundIndex == -1)
                JOptionPane.showMessageDialog(frame, "Username not Found!", "Authentication error", JOptionPane.ERROR_MESSAGE);
            else {
                char[] pass = new char[PassWords[foundIndex].length()];
                for(int i = 0; i < PassWords[foundIndex].length(); i++) {
                    pass[i] = PassWords[foundIndex].charAt(i);
                }

                if(Arrays.equals(pass, passwordField.getPassword())) {
                    successful = true;
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Wrong Password!", "Authentication error", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(successful) {
                frame.dispose();
                new Trivia();
            }
        }
        });
        signupButton.addActionListener(e -> {
            frame.dispose();
            try {
                new Registration();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        frame.add(userLabel);
        frame.add(passwordField);
        frame.add(userTextField);
        frame.add(passwordLabel);
        frame.add(showPassword);
        frame.add(loginButton);
        frame.add(signupButton);

        frame.setBounds(500, 70, 500, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Login();
    }
}
