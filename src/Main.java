package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean winner = false; //temp variable for testing
        Scanner scanner = new Scanner(System.in); //temp scanner until button is implemented for rolling
        int diceSum;
        int cardsPulled = 0;
        boolean shuffleWhenAllCardsPulled = true;

        //creates a list of cards
        CardsManager cardsManager = new CardsManager();
        ArrayList<Cards> cardList = cardsManager.getShuffledCards();
        //Create Dice
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();


        //do while loop for players turns
        do {
            //announce players turn
            // if player.getMissTurn() == true
            // player.setMissTurn(false)
            // announce miss turn
            // continue;

            scanner.nextLine();

            diceSum = dice1.getNum() + dice2.getNum();
            for (int i = 0; i < diceSum; i++) {
                //  move player around board
            }
            //check position on board, if not miss go:
            // show property player has landed on
            // check if buy or cancel button is pressed
            // if miss go:
            // player.setMissTurn(true)

            //checks if player rolled a double
            if (dice2.getNum() == dice1.getNum()) {
                //itterates through the cardList
                for (Cards card: cardList) {
                    if (card.getNumber() == 0) { // if card is first in the deck it gives player money
                        System.out.println(card.getMoney()); // placeholder to check code works
                        // show card pulled
                       // change players money based on the method card.getMoney()
                    }
                    card.cardRotation(); //rotates the cards to imitate the pulling of a card and putting
                                                  // it at the bottom of the deck
                }
                cardsPulled++;
                if (cardsPulled == 20 && shuffleWhenAllCardsPulled) {
                    cardList = cardsManager.getShuffledCards();
                }
            }


                // move player around board
                // check if position is on miss turn
                // player.setMissTurn(true)
                // playerTurn++;
                // continue;
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