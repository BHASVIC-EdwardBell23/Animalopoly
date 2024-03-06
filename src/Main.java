package src;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean winner = false; //temp variable for testing
        Scanner scanner = new Scanner(System.in); //temp scanner until button is implemented for rolling
        boolean hasRolled = false;
        int diceSum;

        //creates a list of cards
        ArrayList cardList = new ArrayList<Cards>();
        cardList.add(new Cards(20, 0));
        cardList.add(new Cards(40, 5));
        cardList.add(new Cards(60, 14));
        cardList.add(new Cards(80, 11));
        cardList.add(new Cards(100, 14));
        cardList.add(new Cards(120, 17));
        cardList.add(new Cards(140, 2));
        cardList.add(new Cards(160, 19));
        cardList.add(new Cards(180, 1));
        cardList.add(new Cards(200, 13));
        cardList.add(new Cards(-20, 15));
        cardList.add(new Cards(-40, 6));
        cardList.add(new Cards(-60, 3));
        cardList.add(new Cards(-80, 4));
        cardList.add(new Cards(-100, 7));
        cardList.add(new Cards(-120, 8));
        cardList.add(new Cards(-140, 9));
        cardList.add(new Cards(-160, 10));
        cardList.add(new Cards(-180, 12));
        cardList.add(new Cards(-200, 15));

        //Create Dice
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();


        //do while loop for players turns
        do {
            // if player.getMissTurn() == true
            // player.setMissTurn(false)
            // continue;
            do {
                if (scanner.nextLine().equals("Roll") || scanner.nextLine().equals("roll")) {
                    hasRolled = true;
                    dice2.rollDice();
                    dice1.rollDice();
                }
            } while (!hasRolled);
            hasRolled = false;

            if (dice2.getNum() == dice1.getNum()) {
                for (Cards card: cardList) { ///??????????????????????????????? why
                    if (card.getNumber() == 0) {
                       // player.setMoney(card.getMoney()); ---
                    }
                    card.cardRotation();
                }
            }
            diceSum = dice1.getNum() + dice2.getNum();
            for (int i = 0; i < diceSum; i++) {
              //  player.move();
                //if player.getPosition() = miss turn
                // player.setMissTurn = true
                // playerTurn++;
                // continue;
            }
            /*
            board.showAnimal(player.position);
            if player buys {
                player.addMoney(board.getPrice(player.getPosition()))
            }
            else no buy

            playerTurn++
            */



        } while (!winner);
    }
}