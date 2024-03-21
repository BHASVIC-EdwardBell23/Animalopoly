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
import java.util.Scanner;

public class TurnManager {

    final int ROLL = 2;
    final int  DOWNGRADE = 1;
    final int UPGRADE = 3;
    final int DISPLAY_PROPERTIES = 4;
    Scanner scanner;

    public TurnManager() {
        scanner = new Scanner(System.in);
    }

    public void displayPlayers(ArrayList<Player> players) {
        for (Player player: players) {
            System.out.println("\n\n-----------------------------------------\n" + player.getName() + "'s Money: " + player.getMoney() + "\n" +
                    "properties Owned:" + player.getPropertiesOwned() + "\n" +
                    "position: " + player.getPosition());
        }
    }


    public void BeforeRoll(GUI gameBoard,int turn, ArrayList<Player> playerList, PropertyDisplayManager propertyDisplayManager, ArrayList<Property> propertyList, MoneyManager moneyManager) {
        displayPlayers(playerList);
        boolean diceRolled = false;
        boolean playerOwnsProperty = false;
        int propertySelected = 0;
        Player player = playerList.get(turn);
        gameBoard.setTurnAnouncement(player.getName());
        int attempts = 0;
        int option = 0;
        do {
            gameBoard.resetClicked();
            while (gameBoard.getClicked() == 0) {}
            option = gameBoard.getClicked();
            if (option == DOWNGRADE) {
                System.out.println(player.getPropertiesOwned());
                while (!playerOwnsProperty && attempts < 3 && !player.getPropertiesOwned().isEmpty()) {
                    System.out.println("Input the position of the property you wish to downgrade/mortgage \n Example: 12");
                    try {
                        propertySelected = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("input a number");
                        propertySelected = 0;
                    }
                    if (propertySelected < 13) {
                        propertySelected--;
                    } else {
                        propertySelected= propertySelected - 2;
                    }

                    for (int i = 0; i < player.getPropertiesOwned().size(); i++) {
                        if (player.getPropertiesOwned().get(i).getPosition() == propertyList.get(propertySelected).getPosition()) {
                            playerOwnsProperty = true;
                            moneyManager.SellProperty(player, propertyList.get(propertySelected));
                        }
                    }
                    attempts++;
                }
            } else if (option == ROLL) {
                diceRolled = true;
            } else if (option == UPGRADE) {
                System.out.println(player.getPropertiesOwned());
                while (!playerOwnsProperty && attempts < 3 && !player.getPropertiesOwned().isEmpty()) {
                    System.out.println("Input the position of the property you wish to Upgrade \n Example: 12");
                    try {
                        propertySelected = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("input a number");
                    }
                    if (propertySelected < 13) {
                        propertySelected--;
                    } else {
                        propertySelected= propertySelected - 2;
                    }
                    for (int i = 0; i < player.getPropertiesOwned().size(); i++) {
                        if (player.getPropertiesOwned().get(i).getPosition() == propertyList.get(propertySelected).getPosition()) {
                            playerOwnsProperty = true;
                            moneyManager.upgradeProperty(player, propertyList.get(propertySelected));

                        }
                    }
                    attempts++;
                }
            } else if (option == DISPLAY_PROPERTIES) {
                System.out.println(player.getMoney());
                for (Property property: player.getPropertiesOwned()) {;
                    System.out.println(property.toStringWithUpgradesDisplayed());
                }
            }
        } while (!diceRolled);
    }

    public ArrayList<ArrayList> AfterRoll(GUI gameBoard, int turn, ArrayList<Player> playerList, int diceSum, DiceManager diceManager, ArrayList<Cards> cardList, CardsManager cardsManager, PlayerManager playerManager, ArrayList<Property> propertyList, PropertyDisplayManager propertyDisplayManager, MoneyManager moneyManager) {
        ArrayList<ArrayList> Lists = new ArrayList<>();
        Lists.add(playerList);
        Lists.add(propertyList);
        Lists.add(cardList);

        Player player = playerList.get(turn);
        player.changePosition(diceSum); // could make moving a for loop, so it's easy for visual representation

        if (gameBoard.checkDouble()) {
            cardsManager.drawCard(turn, player, gameBoard);
        }

        playerManager.positionCheck(turn, playerList, propertyList, gameBoard);
        moneyManager.isBankrupt(turn, propertyList);
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
