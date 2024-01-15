import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Registration {
    public Registration() throws IOException {
        JFrame frame = new JFrame("Sign up");

        ImageIcon image = new ImageIcon("src\\logok3.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(233, 203, 245));

        JLabel title = new JLabel("Signup Window");
        JTextField username = new JTextField();
        JTextField password = new JTextField();
        JButton submit = new JButton("Submit");
        JLabel userLabel = new JLabel("USERNAME");
        JLabel passwordLabel = new JLabel("PASSWORD");

        submit.addActionListener(e -> {
            File UN = new File("src\\username.txt");
            FileWriter UNfr = null;
            try {
                UNfr = new FileWriter(UN, true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                assert UNfr != null;
                UNfr.write('\n' + username.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                UNfr.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            File PW = new File("src\\password.txt");
            FileWriter PWfr = null;
            try {
                PWfr = new FileWriter(PW, true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                assert PWfr != null;
                PWfr.write('\n' + password.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                PWfr.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            frame.dispose();
            new Login();
        });

        userLabel.setBounds(100,135,100,30);
        passwordLabel.setBounds(100,210,100,30);
        username.setBounds(200,135,150,30);
        password.setBounds(200,210,150,30);
        submit.setBounds(170,355,150,40);

        title.setFont(new Font("Verdana", Font.PLAIN, 20));
        title.setBounds(175, 10, 200, 100);

        frame.add(title);
        frame.add(username);
        frame.add(password);
        frame.add(userLabel);
        frame.add(passwordLabel);
        frame.add(submit);

        frame.setBounds(500, 70, 500, 650);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}