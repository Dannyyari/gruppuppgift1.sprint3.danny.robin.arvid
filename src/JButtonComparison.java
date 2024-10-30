import javax.swing.*;
import java.util.ArrayList;

public class JButtonComparison {
    private ArrayList<JButton> RamdomizedButtons = new ArrayList<>();
    private ArrayList<JButton> listOfButtonsSorted = new ArrayList<>();


    public JButtonComparison() {

        boolean isCorrect = compareAnswers(RamdomizedButtons, listOfButtonsSorted);

        if (isCorrect) {
            System.out.println("GRATTIS!");
        }
    }

    private boolean compareAnswers(ArrayList<JButton> RamdomizedButtons, ArrayList<JButton> listOfButtonsSorted) {
        // Om inte texten matchar.
        for (int i = 0; i <RamdomizedButtons.size(); i++) {
            if (!RamdomizedButtons.get(i).getText().equals(listOfButtonsSorted.get(i).getText())){
                return false;
            }
        }
        return true;
    }
}