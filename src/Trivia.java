import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Trivia {
    public Trivia(){
        JFrame frame = new JFrame("Main Menu");

        playSound();

        ImageIcon image = new ImageIcon("src\\logok3.png");
        frame.setIconImage(image.getImage());

        JButton button1 = new JButton("Start Game");
        JButton button2 = new JButton("Dashboard");
        JButton button3 = new JButton("Help");
        JButton button4 = new JButton("Quit");

        button1.addActionListener(e -> {
            frame.dispose();
            new Feluda_or_Sherlocks();

        });
        button2.addActionListener(e -> {
            try {
                frame.dispose();
                new Dashboard();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        button3.addActionListener(e -> {
            frame.dispose();
            new Help();
        });
        button4.addActionListener(e -> {
            System.exit(0);
        });

        button1.setBounds(160,100,150,40);
        button2.setBounds(160,200,150,40);
        button3.setBounds(160,300,150,40);
        button4.setBounds(160,400,150,40);

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

        frame.getContentPane().setBackground(new Color(233, 203, 245));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 70, 500, 650);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void playSound()
    {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\WelcomeToTrivia.wav"));
            Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
        }
    }

}