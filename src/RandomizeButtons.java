import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomizeButtons {
    public RandomizeButtons(){}

    public List<JButton> getRamdomizedButtons(List<JButton> listOfButtonsInOrder){
        List<JButton> copyOfList = new ArrayList<>(listOfButtonsInOrder);
        Collections.shuffle(copyOfList);
        return copyOfList;
    }
}
