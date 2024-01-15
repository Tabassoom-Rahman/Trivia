import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class FOption
{
    FOption()
    {
        JFrame frame = new JFrame("Feluda Difficulty Level");
        frame.setBounds(500, 70, 500, 650);
        frame.setLayout(null);

        JButton FEbutton = new JButton("EASY 😃");
        FEbutton.setBackground(Color.pink);
        FEbutton.setOpaque(true);
        FEbutton.setBorderPainted(true);
        JButton FMbutton = new JButton("MEDIUM 🙂");
        FMbutton.setBackground(Color.pink);
        FMbutton.setOpaque(true);
        FMbutton.setBorderPainted(true);
        JButton FHbutton = new JButton("HARD 🙁");
        FHbutton.setBackground(Color.pink);
        FHbutton.setOpaque(true);
        FHbutton.setBorderPainted(true);
        FEbutton.setBounds(200,100,100,50);
        FMbutton.setBounds(200,250,100,50);
        FHbutton.setBounds(200,400,100,50);
        frame.add(FEbutton);
        frame.add(FMbutton);
        frame.add(FHbutton);

        frame.setVisible(true);

        FEbutton.addActionListener(e -> {
            frame.dispose();
            try {
                new FEasy();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        FMbutton.addActionListener(e -> {
            frame.dispose();
            try {
                new FMedium();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        FHbutton.addActionListener(e -> {
            frame.dispose();
            try {
                new FHard();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        ImageIcon image = new ImageIcon("src\\logok3.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(233, 203, 245));

        JButton Back = new JButton("Back");
        frame.add(Back);
        Back.setBounds(350,545,100,30);
        Back.addActionListener(e -> {
            frame.dispose();
            new Feluda_or_Sherlocks();
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}