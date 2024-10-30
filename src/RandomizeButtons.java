import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomizeButtons {
        public RandomizeButtons(){}

    //Påverkar inte längre orginal listan!
        public List<JButton> getRamdomizedButtons(List<JButton> listOfButtonsInOrder){
            List<JButton> randomizedButtons = new ArrayList<>(listOfButtonsInOrder);
            Collections.shuffle(randomizedButtons);
            return randomizedButtons;
        }

        //onödig lista kanske
        //tar en JButton List och gör om till Integer List
        public List<Integer> getButtonNumber(List<JButton> listOfButtonsAlreadyRandomized){
           // int button=0;
            List<Integer> returnButtonNumber=new ArrayList<>();
            for (JButton buttonint : listOfButtonsAlreadyRandomized) {
                returnButtonNumber.add(Integer.parseInt(buttonint.getText()));
            }

            return returnButtonNumber;
        }
    }

