package src.Game;

import src.Cards.Cards;
import src.Cards.CardsManager;
import src.Dice.DiceManager;
import src.Player.Player;
import src.Player.PlayerManager;
import src.Property.Property;
import src.Property.PropertyDisplayManager;
import src.Property.PropertyManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    CardsManager cardsManager = new CardsManager();
    PlayerManager playerManager = new PlayerManager();
    ArrayList<Player> playerList;
    ArrayList<Property> propertyList;
    PropertyManager propertyManager = new PropertyManager();
    ArrayList<Cards> cardList;
    MoneyManager moneyManager;
    DiceManager diceManager;
    PropertyDisplayManager propertyDisplayManager;

    public Game() {
        playerList = playerManager.getPlayerArrayList();
        propertyList = propertyManager.getPropertyList();
        cardList = cardsManager.getCardList();
        moneyManager = new MoneyManager(playerManager);
        diceManager = new DiceManager();
        propertyDisplayManager = new PropertyDisplayManager();
        //Make gui
        startGame();
    }

    private void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean replay;
        int turn;
        do {
            turn = diceManager.determineWhoMovesFirst(playerList);
            playGame(turn);

            //ask for replay with buttons with GUI
            replay = !scanner.nextLine().isBlank();
        } while (replay);
    }


    private void playGame(int turn) {
        do {
            Player player = playerList.get(turn);
            Scanner scanner = new Scanner(System.in);
            if (playerList.get(turn).getMissTurn) {
                playerList.get(turn).setMissTurn(false);
                continue;
            }
            boolean diceRolled = false;
            do {
                boolean playerOwnsProperty = false;
                int attempts = 0;
                int propertySelected;
                if (scanner.nextLine().equals("Mortgage")) {
                    propertyDisplayManager.MortgageMenu(turn, playerList);
                } else if (scanner.nextLine().equals("Roll")) {
                    diceRolled = true;
                } else if (scanner.nextLine().equals("Sell")) {
                    do {
                        propertySelected = scanner.nextInt();
                        for (int i = 0; i < player.getPropertiesOwned().size(); i++) {
                            if (player.getPropertiesOwned().get(i) == propertyList.get(propertySelected)) {
                                playerOwnsProperty = true;
                                moneyManager.SellProperty(player, propertyList.get(propertySelected));
                            }
                        }
                        attempts++;
                    } while (!playerOwnsProperty || attempts < 3);
                }
            } while (!diceRolled);
            int diceSum = diceManager.diceRoll(); // make them click a button to roll
            playerList.get(turn).changePosition(diceSum); // could make moving a for loop, so it's easy for visual representation
            if (diceManager.rolledDouble()) {
                cardList = cardsManager.drawCard(turn, playerList); // show the card
            }
            playerManager.positionCheck(turn, playerList, propertyList, propertyDisplayManager);
            moneyManager.isBankrupt(turn);

            turn++;
            if (turn == playerList.size()) {
                turn = 0;
            }
        } while (!determineWinner());
        System.out.println("You win: " + WinnerName() + "!");
    }

    private boolean determineWinner() {
        return playerList.size() <= 1;
    }

    private String  WinnerName() {
        if (playerList.size() > 1) {
            return "Null";
        }
        return playerList.get(0).getName;
    }
}