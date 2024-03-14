package src.Game;

import src.Cards.Cards;
import src.Cards.CardsManager;
import src.Dice.DiceManager;
import src.GUI;
import src.Player.Player;
import src.Player.PlayerManager;
import src.Property.Property;
import src.Property.PropertyDisplayManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TurnManager {
    Scanner scanner;

    public TurnManager() {
        scanner = new Scanner(System.in);
    }


    public void BeforeRoll(GUI gameBoard,int turn, ArrayList<Player> playerList, PropertyDisplayManager propertyDisplayManager, ArrayList<Property> propertyList, MoneyManager moneyManager) {
        boolean diceRolled = false;
        boolean playerOwnsProperty = false;
        int propertySelected;
        Player player = playerList.get(turn);
        gameBoard.setTurnAnouncement(player.getName());
        int attempts = 0;
        int option = 0;
        do {
            gameBoard.resetClicked();
            while (gameBoard.getClicked() == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            option = gameBoard.getClicked();
            if (option == 1) {
                propertyDisplayManager.MortgageMenu(turn, playerList);
            } else if (option == 2) {
                diceRolled = true;
            } else if (option == 3) {
                while (!playerOwnsProperty || attempts < 3 || player.getPropertiesOwned() != null) {
                    propertySelected = scanner.nextInt();
                    for (int i = 0; i < player.getPropertiesOwned().size(); i++) {
                        if (player.getPropertiesOwned().get(i) == propertyList.get(propertySelected)) {
                            playerOwnsProperty = true;
                            moneyManager.SellProperty(player, propertyList.get(propertySelected));
                        }
                    }
                    attempts++;
                }
            }
        } while (!diceRolled);
    }

    public ArrayList<ArrayList> AfterRoll(GUI gameBoard, int turn, ArrayList<Player> playerList, int diceSum, DiceManager diceManager, ArrayList<Cards> cardList, CardsManager cardsManager, PlayerManager playerManager, ArrayList<Property> propertyList, PropertyDisplayManager propertyDisplayManager, MoneyManager moneyManager) {
        ArrayList<ArrayList> Lists = new ArrayList<>();
        Lists.add(playerList);
        Lists.add(propertyList);
        Lists.add(cardList);

        playerList.get(turn).changePosition(diceSum); // could make moving a for loop, so it's easy for visual representation
        if (diceManager.rolledDouble()) {
            cardsManager.drawCard(turn, playerList, gameBoard);
        }
        playerManager.positionCheck(turn, playerList, propertyList, propertyDisplayManager);
        moneyManager.isBankrupt(turn);
        return Lists;
    }

    public int turnRotation(int turn, ArrayList<Player> playerList) {
        turn++;
        if (turn == playerList.size()) {
            turn = 0;
        }
        return turn;
    }
}
