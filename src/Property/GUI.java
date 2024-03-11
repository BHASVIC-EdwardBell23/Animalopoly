package src.Property;

import javax.swing.*;

public class GUI extends JFrame {
    private JTextArea Start;
    private JTextArea a19TextArea;
    private JTextArea a20TextArea;
    private JTextArea space21;
    private JTextArea space22;
    private JTextArea space23;
    private JTextArea space24;
    private JTextArea space25;
    private JTextArea space26;
    private JTextArea space3;
    private JTextArea space4;
    private JTextArea space5;
    private JTextArea space2;
    private JTextArea space6;
    private JTextArea space7;
    private JTextArea space8;
    private JTextArea space9;
    private JTextArea space10;
    private JTextArea space11;
    private JTextArea space13;
    private JTextArea space14;
    private JTextArea space15;
    private JTextArea space16;
    private JTextArea space17;
    private JTextArea space18;
    private JTextArea space12;
    private JButton Cards;
    private JButton DiceRoll;
    private JTextArea space1;
    private JPanel panel;
    private JLabel cardShow;
    private JLabel diceResult;
    private JLabel propertyShow;

    public GUI (){
        setContentPane(panel);
        setTitle("Animalopoly");
        setSize(400,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args){
        GUI myGUI =new GUI();
    }
}
