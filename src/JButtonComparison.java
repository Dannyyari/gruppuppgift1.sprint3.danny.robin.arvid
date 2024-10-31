import javax.swing.*;
import java.util.List;

public class JButtonComparison {
    public void compareAnswers(List<JButton> listOfRandomizedButtons, List<JButton> listOfButtonsSorted) {
        //Läser från play area för varje plats, så fort det inte stämmer överens med facit så bryter den.
        for (int i = 0; i < listOfButtonsSorted.size(); i++) {
            if (!listOfRandomizedButtons.get(i).getText().equals(listOfButtonsSorted.get(i).getText())) {
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "GRATTIS! Du har löst spelet!");

    }

}