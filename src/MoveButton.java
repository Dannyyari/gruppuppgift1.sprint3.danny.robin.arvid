import java.util.Collections;

public class MoveButton {
    public void moveButton(){

        Main m = new Main();
//        m.b1.getAlignmentX();
        m.b1.getLocation();
        System.out.println(m.playArea.getComponent(5).toString());
        int i = 0;
        int j = 0;
        m.playArea.getComponent(i);
        //System.out.println(b16.getComponentOrientation());
        Collections.swap(m.buttonList,i,j);


    }

    public static void main(String[] args) {
        MoveButton mb = new MoveButton();
    }
}
