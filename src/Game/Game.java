package src.Game;

import src.Cards.Cards;
import src.Cards.CardsManager;
import src.Player.Player;
import src.Player.PlayerManager;
import src.Property.Property;
import src.Property.PropertyManager;

import java.util.ArrayList;
import java.util.Iterator;

public class Game {
    CardsManager cardsManager = new CardsManager();
    PlayerManager playerManager = new PlayerManager(getPlayerAmount());
    ArrayList<Player> playerList = new ArrayList<>();
    ArrayList<Property> propertyList = new ArrayList<>();
    PropertyManager propertyManager = new PropertyManager();
    ArrayList<Cards> cardList = new ArrayList<>();
    Dice dice1 = new Dice();
    Dice dice2 = new Dice();

    public Game() {
        playerList = playerManager.getPlayerArrayList();
        propertyList = propertyManager.getPropertyList();
        cardList = cardsManager.getCardList();
        createBoard();
        int Turn = determineWhoMovesFirst();
        startGame(Turn);
    }

    private void startGame(int turn) {
        boolean replay = false;
        do {
            playGame(turn);

            //ask for replay with buttons with GUI
            turn = determineWhoMovesFirst();
        } while (replay);
    }

    private int getPlayerAmount() {
        int Players = 0;
        //ask how many people are playing with GUI
        Players = 3212;
        return Players;
    }

    private int determineWhoMovesFirst() {
        int DiceSum = 0;
        int GreatestNum = 0;
        int Turn = 0;

        try {
            for (Player player: playerList) {
                DiceSum = diceRoll();
                if (DiceSum > GreatestNum) {
                    GreatestNum = DiceSum;
                    Turn = player.getNum();
                }
            }
        } catch (Exception e) {
            System.out.println("playerList is empty");
        }
        return Turn;
    } // could make visual

    private void createBoard() {
    } //GUI

    private void playGame(int turn) {
        boolean winner = false;
        do {
            if (playerList.get(turn).getMissTurn) {
                playerList.get(turn).setMissTurn(false);
                continue;
            }
            int diceSum = diceRoll(); // make them click a button to roll
            playerList.get(turn).changePosition(diceSum); // could make moving a for loop, so it's easy for visual representation
            if (rolledDouble()) {
                drawCard(turn); // show the carc
            }
            positionCheck(turn);


            turn++;
            if (turn == playerList.size()) {
                turn = 0;
            }
        } while (!winner);
    }

    private void positionCheck(int turn) {
        //check position and give reasonable response
        //possible response - miss turn activated - property pops up
        Player player = playerList.get(turn);
        int playerPosition = player.getPosition();
        if (playerPosition == 13) {
            playerList.get(turn).setMissTurn(true);
        }
        else {
            Iterator<Property> iterator = propertyList.iterator();
            for (Property property : propertyList) {
                if (property.getPosition() == playerPosition && property.getOwned() == -1) {
                    showPropoertyWithBuyOption();
                }
                else if (property.getPosition() == playerPosition){
                    showPropertyWithRentOwed();
                }
            }
        }
    }

    private void showPropertyWithRentOwed() {
    }//use ToStringWithRent method

    private void showPropoertyWithBuyOption() {
    } //use ToStringWithBuy method

    private void drawCard(int turn) {
        for (Cards card: cardList) {
            if (card.getNumber() == 0) {
                playerList.get(turn).changeMoney(card.getMoney());
            }
            card.cardRotation();
        }
    }

    private boolean rolledDouble() {
        return dice2.getNum() == dice1.getNum();
    }

    private int diceRoll() {
        return dice1.rollDice() + dice2.rollDice();
    }

    private String WinnerName() {
        if (playerList.size() > 1) {
            return "Null";
        }
        return playerList.get(0).getName;
    }
}