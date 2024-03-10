package src.Game;

import src.Cards.Cards;
import src.Cards.CardsManager;
import src.Dice.DiceManager;
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


    public void BeforeRoll(int turn, ArrayList<Player> playerList, PropertyDisplayManager propertyDisplayManager, ArrayList<Property> propertyList, MoneyManager moneyManager) {
        boolean diceRolled = false;
        boolean playerOwnsProperty = false;
        int propertySelected;
        Player player = playerList.get(turn);
        int attempts = 0;
        do {
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
    }

    public ArrayList<ArrayList> AfterRoll(int turn, ArrayList<Player> playerList, int diceSum, DiceManager diceManager, ArrayList<Cards> cardList, CardsManager cardsManager, PlayerManager playerManager, ArrayList<Property> propertyList, PropertyDisplayManager propertyDisplayManager, MoneyManager moneyManager) {
        ArrayList<ArrayList> Lists = new ArrayList<>();
        Lists.add(playerList);
        Lists.add(propertyList);
        Lists.add(cardList);

        playerList.get(turn).changePosition(diceSum); // could make moving a for loop, so it's easy for visual representation
        if (diceManager.rolledDouble()) {
            cardList = cardsManager.drawCard(turn, playerList); // show the card
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
