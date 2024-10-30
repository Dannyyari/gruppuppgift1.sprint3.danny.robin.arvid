import javax.swing.*;
import java.util.ArrayList;

public class JButtonComparison {
    private ArrayList<JButton> userChoices = new ArrayList<>();
    private ArrayList<JButton> correctAnswers = new ArrayList<>();


    public JButtonComparison() {

        //Facit knappar
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button10 = new JButton("10");
        JButton button11 = new JButton("11");
        JButton button12 = new JButton("12");
        JButton button13 = new JButton("13");
        JButton button14 = new JButton("14");
        JButton button15 = new JButton("15");
        JButton button16 = new JButton("");

        //Facit
        correctAnswers.add(button1);
        correctAnswers.add(button2);
        correctAnswers.add(button3);
        correctAnswers.add(button4);
        correctAnswers.add(button5);
        correctAnswers.add(button6);
        correctAnswers.add(button7);
        correctAnswers.add(button8);
        correctAnswers.add(button9);
        correctAnswers.add(button10);
        correctAnswers.add(button11);
        correctAnswers.add(button12);
        correctAnswers.add(button13);
        correctAnswers.add(button14);
        correctAnswers.add(button15);
        correctAnswers.add(button16);


        // Panel knappar
        JButton userButton1  = new JButton("1");
        JButton userButton2 = new JButton("2");
        JButton userButton3 = new JButton("3");
        JButton userButton4 = new JButton("4");
        JButton userButton5 = new JButton("5");
        JButton userButton6 = new JButton("6");
        JButton userButton7 = new JButton("7");
        JButton userButton8 = new JButton("8");
        JButton userButton9 = new JButton("9");
        JButton userButton10 = new JButton("10");
        JButton userButton11 = new JButton("11");
        JButton userButton12 = new JButton("12");
        JButton userButton13 = new JButton("13");
        JButton userButton14 = new JButton("14");
        JButton userButton15 = new JButton("15");
        JButton userButton16 = new JButton("");

        userChoices.add(userButton1);
        userChoices.add(userButton2);
        userChoices.add(userButton3);
        userChoices.add(userButton4);
        userChoices.add(userButton5);
        userChoices.add(userButton6);
        userChoices.add(userButton7);
        userChoices.add(userButton8);
        userChoices.add(userButton9);
        userChoices.add(userButton10);
        userChoices.add(userButton11);
        userChoices.add(userButton12);
        userChoices.add(userButton13);
        userChoices.add(userButton14);
        userChoices.add(userButton15);
        userChoices.add(userButton16);

        boolean isCorrect = compareAnswers(userChoices, correctAnswers);

        if (isCorrect) {
            System.out.println("GRATTIS!");
        }
    }

    private boolean compareAnswers(ArrayList<JButton> userChoices, ArrayList<JButton> correctAnswers) {
        // Om inte texten matchar.
        for (int i = 0; i <userChoices.size(); i++) {
            if (!userChoices.get(i).getText().equals(correctAnswers.get(i).getText())){
                return false;
            }
        }
        return true;
    }
}