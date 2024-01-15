import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class FEasy implements ActionListener{

    String[] questions = 	{
            "1. What is the name of Feluda's assistant?",
            "2. Which of these is Feluda's age as mentioned in the first story of the series, 'Feludar Goyendagiri'?",
            "3. What is the name of the person from whom Feluda takes advice, when he cannot solve a problem?",
            "4. What is the name of this Northern Railways station?",
            "5. What is the next story in the Feluda series after Feludar Goendagiri?",
            "6. What game was Naresh Pakrashi fond of playing?",
            "7. What was Feluda's profession before he became a detective?",
            "8. Where does Sidhu Jetha stay?",
            "9. Who appears as the villain in the novel 'Badshahi Angti'?",
            "10.What is the name of the story in which Feluda first appears?",

    };
    String[][] options = 	{
            {"Tapesh","Dinesh","Amrita","Prodesh"},
            {"32","28","25","26"},
            {"Lalmohon babu","Tapesh Bose","Sidha Jetha","Jayanta Mollik"},
            {"Jodhpur","Badmar","Ramdeora ","Jalsarmer"},
            {"Badshahi Angti","Chinnamastar Abhishaap","Gorosthane Shabdhan!","Tintorettor Jishu"},
            {"Cricket","Chess","Carrom","Kabaddi"},
            {"Banker","Employee","Teacher","Pion"},
            {"Shyampukur Lane","Chittaranjan Avenue","JGariaghat Road","Sardar Shankar Road"},
            {"Bonobihari Sarkar","Lalmohon Bihari","Jayanta Mollik","Dinesh Roy"},
            {"Darjiling Jomjomat","Feludar goyendagiri","Tintorotter Jishu","Londoney Feluda"},
    };
    char[] answers = 		{
            'A',
            'D',
            'C',
            'C',
            'A',
            'B',
            'A',
            'D',
            'A',
            'B', ' '
    };
    char answer;
    int index;
    int correct_guesses =0;
    int total_questions = questions.length;
    int seconds=10;

    JFrame frame = new JFrame("FeludaEasy");
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    Timer timer = new Timer(1000, e -> {
        seconds--;
        seconds_left.setText(String.valueOf(seconds));
        if(seconds<=0) {
            displayAnswer();
        }
    });

    public FEasy() throws IOException {

        ImageIcon image = new ImageIcon("src\\logok3.png");
        frame.setIconImage(image.getImage());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.getContentPane().setBackground(new Color(233,203,245));
        frame.setLayout(null);
        frame.setResizable(true);

        textfield.setBounds(0,0,1000,50);
        textfield.setBackground(new Color(127,50,168));
        textfield.setForeground(new Color(255,255,255));
        textfield.setFont(new Font("Times New Bd",Font.BOLD,30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(0,50,1000,100);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(127,50,168));
        textarea.setForeground(new Color(255,255,255));
        textarea.setFont(new Font("Times New Bd",Font.BOLD,25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        buttonA.setBounds(0,150,100,100);
        buttonA.setFont(new Font("Times New Bd",Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,250,100,100);
        buttonB.setFont(new Font("Times New Bd",Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,350,100,100);
        buttonC.setFont(new Font("Times New Bd",Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,450,100,100);
        buttonD.setFont(new Font("Times New Bd",Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(100,150,900,100);
        answer_labelA.setBackground(new Color(50,50,50));
        answer_labelA.setForeground(new Color(0,0,0));
        answer_labelA.setFont(new Font("Times New Bd",Font.PLAIN,35));

        answer_labelB.setBounds(100,250,900,100);
        answer_labelB.setBackground(new Color(50,50,50));
        answer_labelB.setForeground(new Color(0,0,0));
        answer_labelB.setFont(new Font("Times New Bd",Font.PLAIN,35));

        answer_labelC.setBounds(100,350,900,100);
        answer_labelC.setBackground(new Color(50,50,50));
        answer_labelC.setForeground(new Color(0,0,0));
        answer_labelC.setFont(new Font("Times New Bd",Font.PLAIN,35));

        answer_labelD.setBounds(100,450,900,100);
        answer_labelD.setBackground(new Color(50,50,50));
        answer_labelD.setForeground(new Color(0,0,0));
        answer_labelD.setFont(new Font("Times New Bd",Font.PLAIN,35));

        seconds_left.setBounds(850,455,100,100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(255,0,0));
        seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(850,420,100,25);
        time_label.setBackground(new Color(50,50,50));
        time_label.setForeground(new Color(255,0,0));
        time_label.setFont(new Font("Times New Bd",Font.PLAIN,16));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("10 secs only");

        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textarea);
        frame.add(textfield);
        frame.setVisible(true);

        nextQuestion();
    }
    public void nextQuestion() throws IOException {

        if(index>=total_questions) {
            frame.dispose();
            new result(correct_guesses);
        }
        else {
            textfield.setText("Question "+(index+1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource()==buttonA) {
            answer= 'A';
            if(answer == answers[index]) {
                playCorrect();
                correct_guesses++;
            }
            else{
                playWrong();
            }
        }
        if(e.getSource()==buttonB) {
            answer= 'B';
            if(answer == answers[index]) {
                playCorrect();
                correct_guesses++;
            }
            else{
                playWrong();
            }
        }
        if(e.getSource()==buttonC) {
            answer= 'C';
            if(answer == answers[index]) {
                playCorrect();
                correct_guesses++;
            }
            else{
                playWrong();
            }
        }
        if(e.getSource()==buttonD) {
            answer= 'D';
            if(answer == answers[index]) {
                playCorrect();
                correct_guesses++;
            }
            else{
                playWrong();
            }
        }
        displayAnswer();
    }
    public void displayAnswer() {

        timer.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index] != 'A')
            answer_labelA.setForeground(new Color(255,0,0));
        if(answers[index] != 'B')
            answer_labelB.setForeground(new Color(255,0,0));
        if(answers[index] != 'C')
            answer_labelC.setForeground(new Color(255,0,0));
        if(answers[index] != 'D')
            answer_labelD.setForeground(new Color(255,0,0));

        Timer pause = new Timer(2000, e -> {

            answer_labelA.setForeground(new Color(0,0,0));
            answer_labelB.setForeground(new Color(0,0,0));
            answer_labelC.setForeground(new Color(0,0,0));
            answer_labelD.setForeground(new Color(0,0,0));

            answer = ' ';
            seconds=10;
            seconds_left.setText(String.valueOf(seconds));
            buttonA.setEnabled(true);
            buttonB.setEnabled(true);
            buttonC.setEnabled(true);
            buttonD.setEnabled(true);
            index++;
            try {
                nextQuestion();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        pause.setRepeats(false);
        pause.start();
    }

    public void playCorrect()
    {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\CorrectAnswer.wav"));
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
    public void playWrong()
    {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\WrongAnswer.wav"));
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