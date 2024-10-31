import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class Main extends JFrame implements ActionListener {
    boolean presentationMode = false;
    RandomizeButtons rb = new RandomizeButtons();
    JButtonComparison jbc = new JButtonComparison();
    JPanel mainArea = new JPanel();
    JPanel southArea = new JPanel();
    JPanel playArea = new JPanel();
    JButton resetButton = new JButton("Nytt spel");
    JButton highscore = new JButton("Highscore");
    int moveCounter = 0;
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
        // Lägg till knappar och lyssnare i playArea.
        resetGame();

        setTitle("Slide Puzzle");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // pack(); //ska göras på slutet
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

        }
        else {
            clickedButton = (JButton) e.getSource();
            moveButton();
        }
    }

    public void resetGame() {
        playArea.removeAll();
        listOfRandomizedButtons = rb.getRamdomizedButtons(listOfButtonsSorted);
        if (presentationMode){
            listOfRandomizedButtons = listOfPresentationButtons;
        }
        for (JButton button : listOfRandomizedButtons) {
            Font newFont=new Font(button.getName(), Font.ITALIC, 40);
            button.setFont(newFont);
            playArea.add(button);
            button.addActionListener(this);
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
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}
// Merge konflikt: Vid merge av Arvids branch till master och sedan
// robins till master så visade master en variant INNAN Arvids branch