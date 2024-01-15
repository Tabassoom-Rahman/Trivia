import javax.swing.*;
import java.awt.*;

class Feluda_or_Sherlocks{

    public Feluda_or_Sherlocks() {
        JFrame frame = new JFrame("Choose your favourite detective character 🤓");
        frame.setBounds(500, 70, 500, 650);

        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton SherlockButton = new JButton( new ImageIcon("src\\Sherlock.jpg"));
        SherlockButton.setBackground(new Color(233, 203, 245));
        //SherlockButton.setBounds(100,100,200,255);
        SherlockButton.setOpaque(false);
        SherlockButton.setBorderPainted(false);

        JButton FeludaButton = new JButton( new ImageIcon("src\\Feluda.png"));
        FeludaButton.setBackground(new Color(233, 203, 245));
        //FeludaButton.setBounds(250,400,210,233);
        FeludaButton.setOpaque(false);
        FeludaButton.setBorderPainted(false);

        SherlockButton.setBounds(100,50,200,255);
        FeludaButton.setBounds(290,305,210,233);
        frame.getContentPane().add(SherlockButton);
        frame.getContentPane().add(FeludaButton);

        frame.setVisible(true);


        ImageIcon image = new ImageIcon("src\\logok3.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(233, 203, 245));

        SherlockButton.addActionListener(e -> {
            frame.dispose();
            new SOption();
        });
        FeludaButton.addActionListener(e -> {
            frame.dispose();
            new FOption();
        });
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}