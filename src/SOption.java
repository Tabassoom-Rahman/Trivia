import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class SOption extends JFrame implements ActionListener
{
    SOption()
    {
        setTitle("Sherlock Difficulty Level");
        setBounds(500, 70, 500, 650);
        setLayout(null);

        JButton SEbutton = new JButton("EASY 😃");
        SEbutton.setBackground(Color.pink);
        SEbutton.setOpaque(true);
        SEbutton.setBorderPainted(true);
        JButton SMbutton = new JButton("MEDIUM 🙂");
        SMbutton.setBackground(Color.pink);
        SMbutton.setOpaque(true);
        SMbutton.setBorderPainted(true);
        JButton SHbutton = new JButton("HARD 🙁");
        SHbutton.setBackground(Color.pink);
        SHbutton.setOpaque(true);
        SHbutton.setBorderPainted(true);
        SEbutton.setBounds(200,100,100,50);
        SMbutton.setBounds(200,250,100,50);
        SHbutton.setBounds(200,400,100,50);
        add(SEbutton);
        add(SMbutton);
        add(SHbutton);

        setVisible(true);

        SEbutton.addActionListener(e -> {
            dispose();
            try {
                new SEasy();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        SMbutton.addActionListener(e -> {
            dispose();
            try {
                new SMedium();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        SHbutton.addActionListener(e -> {
            dispose();
            try {
                new SHard();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        ImageIcon image = new ImageIcon("src\\logok3.png");
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(233, 203, 245));

        JButton Back = new JButton("Back");
        add(Back);
        Back.setBounds(350,545,100,30);
        Back.addActionListener(e -> {
            dispose();
            new Feluda_or_Sherlocks();
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}

