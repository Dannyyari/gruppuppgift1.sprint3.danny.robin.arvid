import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame implements ActionListener {
    boolean presentationMode = false;

    RandomizeButtons rb = new RandomizeButtons();
    JButtonComparison jbc = new JButtonComparison();

    JPanel mainArea = new JPanel();
    JPanel southArea = new JPanel();
    JPanel playArea = new JPanel();

    int moveCounter =0;

    JButton resetButton = new JButton("Nytt spel");
    JButton highscore = new JButton("Highscore");
    JLabel counter = new JLabel("Antal klick: " + moveCounter);

    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");
    JButton b6 = new JButton("6");
    JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    JButton b10 = new JButton("10");
    JButton b11 = new JButton("11");
    JButton b12 = new JButton("12");
    JButton b13 = new JButton("13");
    JButton b14 = new JButton("14");
    JButton b15 = new JButton("15");
    JButton b16 = new JButton("");

    List<JButton> listOfButtonsSorted = Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8,
            b9, b10, b11, b12, b13, b14, b15, b16);
    List<JButton> listOfRandomizedButtons = rb.getRamdomizedButtons(listOfButtonsSorted);
    List<JButton> listOfPresentationButtons = Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8,
            b9, b10, b11, b12, b13, b14, b16,b15);
    JButton clickedButton;

    public Main() {
        add(mainArea);

        mainArea.setLayout(new BorderLayout());
        playArea.setLayout(new GridLayout(4, 4));

        mainArea.add(southArea, BorderLayout.SOUTH);
        mainArea.add(playArea);

        southArea.add(resetButton);
        southArea.add(counter);
        southArea.add(highscore);

        resetButton.addActionListener(this);
        highscore.addActionListener(this);

        for (JButton button : listOfButtonsSorted) {
            button.addActionListener(this);
        }

        resetGame();

        setTitle("Slide Puzzle");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            resetGame();
            resetGame();
        }
        else if (e.getSource() == highscore) {
            showHighScore();
        }
        else {
            clickedButton = (JButton) e.getSource();
            moveButton();
        }
    }

    public void resetGame() {
        playArea.removeAll();
        moveCounter = 0;
        counter.setText("Antal klick: " + moveCounter);
        listOfRandomizedButtons = rb.getRamdomizedButtons(listOfButtonsSorted);
        if (presentationMode){
            listOfRandomizedButtons = listOfPresentationButtons;
        }

        for (JButton button : listOfRandomizedButtons) {
            Font newFont=new Font(button.getName(), Font.ITALIC, 40);
            button.setFont(newFont);
            playArea.add(button);
        }
        playArea.revalidate();
        playArea.repaint();
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void moveButton() {
        int indexClick = listOfRandomizedButtons.indexOf(clickedButton);
        int index16 = listOfRandomizedButtons.indexOf(b16);
        if ((indexClick - 1) == index16 || (indexClick + 1) == index16 ||
                (indexClick - 4) == index16 || (indexClick + 4) == index16) {
            Collections.swap(listOfRandomizedButtons, listOfRandomizedButtons.indexOf(clickedButton),
                    listOfRandomizedButtons.indexOf(b16));
            for (JButton jb : listOfRandomizedButtons) {
                playArea.add(jb);
            }
            moveCounter++;
            counter.setText("Antal klick: " + moveCounter);
            playArea.repaint();
            SwingUtilities.updateComponentTreeUI(this);
            jbc.compareAnswers(listOfRandomizedButtons,listOfButtonsSorted);
            if (listOfRandomizedButtons.equals(listOfButtonsSorted)){
                addToHighscore();
            }
        }
    }

    public void showHighScore(){
        Path hsPath = Paths.get("src/highscore.txt");
        StringBuilder highscore = new StringBuilder();
        try(Scanner sc = new Scanner(hsPath)){
            while (sc.hasNextLine()){
                highscore.append(sc.nextLine()).append("\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel vid läsning av fil.");
        }
        JOptionPane.showMessageDialog(null, highscore);
    }

    public void addToHighscore() {
        String pathtofile="src/highscore.txt";
        try(BufferedWriter w=new BufferedWriter(new FileWriter(pathtofile, true))) {
            String name = JOptionPane.showInputDialog("vad heter du");
            w.write(name + " poäng: " +moveCounter+"\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
    }

}

// Merge konflikt: Vid merge av Arvids branch --> master och sedan
// robins --> master så visade master en variant INNAN Arvids branch