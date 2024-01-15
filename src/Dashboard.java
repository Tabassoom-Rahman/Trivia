import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dashboard {
    public Dashboard () throws FileNotFoundException {
        JFrame frame = new JFrame("Dashboard");

        ImageIcon image = new ImageIcon("src\\logok3.png");
        frame.setIconImage(image.getImage());

        JLabel title = new JLabel("         Dashboard");
        title.setFont(new Font("Verdana", Font.PLAIN, 20));
        JButton back = new JButton(new ImageIcon("src\\logo.png"));
        back.setBounds(350,450,100,117);
        frame.add(back);

        back.addActionListener(e -> {
            frame.dispose();
            new Trivia();
        });

        title.setBounds(125, 20, 200, 100);

        File text = new File("src\\dashboard.txt");
        Scanner DB = new Scanner(text);

        int y = 125;
        while(DB.hasNextLine()) {
            String s = "";
            s += DB.nextLine();

            JLabel temp = new JLabel(s);
            temp.setBounds(75, y, 150, 20);

            y += 25;

            frame.add(temp);
        }

        frame.add(title);

        frame.getContentPane().setBackground(new Color(233, 203, 245));
        frame.setBounds(500, 70, 500, 650);
        frame.setResizable(true);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
