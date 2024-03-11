package src.Dice;

import src.GUI;
import src.Player.Player;

import java.util.ArrayList;

public class DiceManager {

    Dice dice1;
    Dice dice2;

    public DiceManager() {
        dice1 = new Dice();
        dice2 = new Dice();
    }

    public boolean rolledDouble() {
        return dice2.getNum() == dice1.getNum();
    }

    public int diceRoll(GUI gameBoard) {
        int diceSum = dice1.rollDice() + dice2.rollDice();
        gameBoard.setDiceResult(diceSum);
        return diceSum;
    }

    public int determineWhoMovesFirst(ArrayList<Player> playerList, GUI gameBoard) {
        int DiceSum;
        int GreatestNum = 0;
        int Turn = 0;

        try {
            for (Player player: playerList) {
                DiceSum = diceRoll(gameBoard);
                gameBoard.setDiceResult(DiceSum);

                if (DiceSum > GreatestNum) {
                    GreatestNum = DiceSum;
                    Turn = player.getNum();
                }
            }
        } catch (Exception e) {
            System.out.println("playerList can't be empty");
        }
        return Turn;
    } // could make visual
}
