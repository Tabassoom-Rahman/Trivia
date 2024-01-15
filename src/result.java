import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class result {
    public result(int num) throws IOException {
        JFrame frame = new JFrame("Score");
        ImageIcon image = new ImageIcon("src\\logok3.png");
        frame.setIconImage(image.getImage());

        JButton back = new JButton(new ImageIcon("src\\logo.png"));
        back.setBounds(200,420,100,117);
        frame.add(back);

        back.addActionListener(e -> {
            frame.dispose();
            new Trivia();
        });

        JLabel label = new JLabel("Your score is: ");
        label.setFont(new Font("Arial",Font.PLAIN,35));
        label.setBounds(10, 10, 230, 100);

        JLabel score = new JLabel(Integer.toString(num == -1? 0 : num));
        score.setBounds(240, 10, 50, 100);
        score.setFont(new Font("Arial",Font.PLAIN,35));

        JLabel excelent = new JLabel("Excellent");
        excelent.setBounds(10, 60, 230, 100);
        JLabel good = new JLabel("Good");
        good.setBounds(10, 60, 230, 100);
        JLabel average = new JLabel("Average");
        average.setBounds(10, 60, 230, 100);
        JLabel needToWork = new JLabel("Need to work on it");
        needToWork.setBounds(10, 60, 230, 100);
        JLabel kick = new JLabel("Too many wrong answers");
        kick.setBounds(10, 60, 230, 100);

        frame.add(label);
        frame.add(score);

        if(num == -1) {
            frame.add(kick);
        }
        else if(num < 5) {
            frame.add(needToWork);
        }
        else if(num < 7) {
            frame.add(average);
        }
        else if(num < 9) {
            frame.add(good);
        }
        else {
            frame.add(excelent);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 70, 500, 650);
        frame.getContentPane().setBackground(new Color(233,203,245));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);


        String[] names = new String[500];
        int[] scores = new int[500];
        File dashboard = new File("src\\dashboard.txt");
        Scanner in = new Scanner(dashboard);

        int i = 0;
        while(in.hasNextLine()) {
            String temp = in.nextLine();

            String[] splited = temp.split("\\s+");

            names[i] = splited[0];
            scores[i++] = Integer.parseInt(splited[1]);
        }

        in.close();

        File currUser = new File("src\\logged_in.txt");
        in = new Scanner(currUser);

        names[i] = in.next();
        scores[i++] = num;

        in.close();

        for(int j = 0; j < i; j++) {
            for(int k = j + 1; k < i; k++) {
                if(scores[k] > scores[j]) {
                    int temp = scores[k];
                    scores[k] = scores[j];
                    scores[j] = temp;

                    String temp1 = names[k];
                    names[k] = names[j];
                    names[j] = temp1;
                }
            }
        }

        FileWriter finalDashboard = new FileWriter("src\\dashboard.txt");

        for(int j = 0; j <= 9; j++) {
            if(j == 0) finalDashboard.write(names[j] + ' ' + scores[j]);
            else finalDashboard.write('\n' + names[j] + ' ' + scores[j]);
        }
        finalDashboard.close();
    }
}