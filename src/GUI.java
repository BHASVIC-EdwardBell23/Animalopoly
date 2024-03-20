package src;


import src.Cards.Cards;
import src.Dice.DiceManager;
import src.Player.Player;
import src.Property.Property;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextField TurnAnouncement;

    DiceManager diceManager;
    private int clicked = 0;
    private int property;

    private int DiceSum;

    // Possible Ben fix
    private JButton yesButton;
    private JButton noButton;
    private JLabel cardText;

    public GUI () {
        setContentPane(panel);
        setTitle("Animalopoly");
        setSize(2000, 2000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        diceManager = new DiceManager();

        DiceRoll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiceSum = diceManager.diceRoll();
                setDiceResult(DiceSum);
                clicked = 2;
            }
        });
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked = 1;
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked = 2;
            }
        });
    }

    public void setDiceResult(int diceSum) {
        diceResult.setText("Dice Result: " + diceSum);
    }

    public boolean checkDouble() {
        return diceManager.rolledDouble();
    }


    public void setTurnAnouncement(String name) {
        TurnAnouncement.setText(name + "'s Turn");
    }

    public int getClicked() {
        return clicked;
    }

    public void setCardShowing(Cards card) {
        ImageIcon icon;
        icon = (ImageIcon) cardShow.getIcon();
        icon = card.getImage();
        cardShow.setIcon(icon);
        cardText.setText(card.getMessage() + " || " + card);
    }



    public void clearCardShowing() {
        cardShow.setIcon(null);
        cardShow.setText("");
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void resetClicked() {
        clicked = 0;
    }

    public int getDiceSum() {
        return DiceSum;
    }

    /*
    public void purchaseProperty(Property property, Player currentPlayer) {
         // Implement this method
        int propertyPrice = property.getCost(); // Implement this method in Property class
        if (currentPlayer.getMoney() >= propertyPrice) {
            currentPlayer.changeMoney(propertyPrice);
            currentPlayer.addPropertyOwned(property);

            JOptionPane.showMessageDialog(null, "Property purchased successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Not enough money to purchase this property.");
        }
    }

    */
    public void purchase() {

    }
}

