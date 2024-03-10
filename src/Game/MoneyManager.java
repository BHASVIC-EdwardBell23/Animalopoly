package src.Game;

import src.Player.Player;
import src.Player.PlayerManager;
import src.Property.Property;

import java.util.ArrayList;

public class MoneyManager {
    ArrayList<Player> playerList;

    ArrayList<Property> propertyArrayList;

    public MoneyManager(PlayerManager playerManager) {
        playerList = playerManager.getPlayerArrayList();
    }

    public boolean isBankrupt(int turn) {
        Player player = playerList.get(turn);

        if (player.getMoney() < 0) {
            System.out.println("You must sell properties etc"); //make this gui ofcourse
        }
        if (player.getMoney() < 0 && player.getPropertiesOwned().isEmpty()) {
            System.out.println("You are bankrupt!");
            playerList.remove(player);
            return true;
        }
        return false;
    }

    public ArrayList<Property> SellProperty(Player player,Property property) {
        propertyArrayList = player.getPropertiesOwned();
        propertyArrayList.remove(property);
        player.changeMoney(property.getCost()/2);
        return propertyArrayList;
    }
}
