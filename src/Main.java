import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Main extends JFrame implements ActionListener {
    RandomizeButtons rb =new RandomizeButtons();

    JPanel mainArea =new JPanel();
 //   JPanel centerArea =new JPanel();
    JPanel southArea=new JPanel();
    JPanel playArea=new JPanel();
    JButton resetButton=new JButton("Nytt spel");
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
    List<JButton> listOfButtonsSorted= Arrays.asList(b1, b2,b3,b4,b5,b6,b7,b8,
            b9,b10,b11,b12,b13,b14,b15,b16);
    List<JButton> listOfRandomizedButtons= rb.getRamdomizedButtons(listOfButtonsSorted);
    public Main(){
        add(mainArea);
        mainArea.setLayout(new BorderLayout());
        playArea.setLayout(new GridLayout(4,4));
        mainArea.add(southArea, BorderLayout.SOUTH);
        mainArea.add(playArea);
        southArea.add(resetButton);

        for (JButton randomButton : listOfRandomizedButtons) {
            playArea.add(randomButton);
        }
        //Kanske flytta denna actionlistner i en annan klass?
        resetButton.addActionListener(this);


        setTitle("15 game");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // pack(); //ska göras på slutet
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        Main m =new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==resetButton) {
            List<JButton> randomizedListForButton=rb.getRamdomizedButtons(listOfButtonsSorted);
            playArea.removeAll();
            for (JButton jButton : randomizedListForButton){
                playArea.add(jButton);
            }
            playArea.repaint();
            //funktion nedan förnyar rutan
            SwingUtilities.updateComponentTreeUI(this);
        }
    }
}