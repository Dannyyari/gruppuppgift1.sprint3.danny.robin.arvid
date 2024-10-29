import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JPanel mainArea =new JPanel();
    JPanel centerArea =new JPanel();
    JPanel southArea=new JPanel();
    JPanel playArea=new JPanel();
    JButton resetButton=new JButton("Nytt spel");
    JButton o1 =new JButton("1");
    JButton to=new JButton("2");
    JButton tr=new JButton("3");
    JButton four=new JButton("4");
    JButton five=new JButton("5");
    JButton six=new JButton("6");

    public Main(){
        add(mainArea);
        mainArea.setLayout(new BorderLayout());
        playArea.setLayout(new GridLayout(4,4));
        mainArea.add(centerArea, BorderLayout.CENTER);
        mainArea.add(southArea, BorderLayout.SOUTH);
        centerArea.add(playArea);
        southArea.add(resetButton);
        playArea.add(o1);
        playArea.add(to);
        playArea.add(tr);
        playArea.add(four);
        playArea.add(five);
        playArea.add(six);


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

    }
}