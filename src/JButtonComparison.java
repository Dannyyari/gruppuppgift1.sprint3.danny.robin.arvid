import javax.swing.*;
import java.util.List;

public class JButtonComparison {
    public void compareAnswers(List<JButton> listOfRandomizedButtons, List<JButton> listOfButtonsSorted) {
        for (int i = 0; i < listOfRandomizedButtons.size(); i++) {
            if (listOfRandomizedButtons.get(i).getText().equals(listOfButtonsSorted.get(i).getText()))
                JOptionPane.showMessageDialog(null, "GRATTIS!");
        }
    }
}