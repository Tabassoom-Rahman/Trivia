import javax.swing.*;
import java.awt.*;

public class Help {
    public Help(){
        JFrame frame = new JFrame();

        ImageIcon image = new ImageIcon("src\\logok3.png");
        frame.setIconImage(image.getImage());

        JButton back = new JButton(new ImageIcon("src\\logo.png"));
        back.setBounds(200,420,100,117);
        frame.add(back);

        back.addActionListener(e -> {
            frame.dispose();
            new Trivia();
        });

        JLabel labelhead = new JLabel("                             \" Help \" ");
        labelhead.setFont(new Font("Verdana", Font.PLAIN, 20));
        JLabel star = new JLabel("                                  ************");
        star.setFont(new Font("Verdana", Font.PLAIN, 15));
        JLabel label1 = new JLabel(" ");
        JLabel label2 = new JLabel(" ");

        JLabel label3 = new JLabel("   #  There are 6 different categories questions in the game.");
        JLabel labeln1 = new JLabel(" ");
        JLabel label4 = new JLabel("   #  You can play each category separately.");
        JLabel labeln2 = new JLabel(" ");
        JLabel label5 = new JLabel("   #  Each category contains 10 different questions and each question contains");
        JLabel label13 = new JLabel("      4 options.");
        JLabel labeln3 = new JLabel(" ");
        JLabel label10 = new JLabel("   #  You'll get 10 seconds to answer each questions.");
        JLabel labeln5 = new JLabel(" ");
        JLabel label6 = new JLabel("   #  If you choose an easy category, you can answer all the questions respectively.");
        JLabel label7 = new JLabel("       If you choose medium difficulty, You'll be kicked after giving 5 wrong answers");
        JLabel label8 = new JLabel("      consecutively. If you choose hard difficulty, You'll be kicked after giving 2 ");
        JLabel label19 = new JLabel("      wrong answers consecutively.");
        JLabel labeln4 = new JLabel(" ");
        JLabel label9 = new JLabel("   #  No mark will be deducted for any wrong answer.");
        JLabel labeln6 = new JLabel(" ");
        JLabel labeln8 = new JLabel(" ");
        JLabel label11 = new JLabel("                 ******************************* Best of Luck ******************************* ");
        JLabel labeln7 = new JLabel(" ");
        JLabel label12 = new JLabel("                                        \"TRIVIA\" is developed by \"Team NYK\"");


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(labelhead);
        panel.add(star);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(labeln1);
        panel.add(label4);
        panel.add(labeln2);
        panel.add(label5);
        panel.add(label13);
        panel.add(labeln3);
        panel.add(label10);
        panel.add(labeln5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label19);
        panel.add(labeln4);
        panel.add(label9);
        panel.add(labeln6);
        panel.add(labeln8);
        panel.add(label11);
        panel.add(labeln7);
        panel.add(label12);

        panel.setBackground(new Color(233, 203, 245));

        frame.add(panel);

        frame.setTitle("Help");
        frame.setBounds(500, 70, 500, 650);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}