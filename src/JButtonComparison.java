import javax.swing.*;
import java.util.List;

public class JButtonComparison {
    public void compareAnswers(List<JButton> listOfRandomizedButtons, List<JButton> listOfButtonsSorted) {
        boolean match = false;
        for (int i = 0; i < listOfRandomizedButtons.size(); i++) {
            if (listOfRandomizedButtons.get(i).getText().equals(listOfButtonsSorted.get(i).getText()))
                match = true;
            else
                match = false;
        }
            if (match)
                JOptionPane.showMessageDialog(null, "Grattis, du vann!");
    }

}