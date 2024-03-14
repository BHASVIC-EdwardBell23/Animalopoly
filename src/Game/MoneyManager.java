package src.Game;

import src.Player.Player;
import src.Player.PlayerManager;
import src.Property.Property;

import java.util.ArrayList;
import java.util.Scanner;

public class MoneyManager {
    ArrayList<Player> playerList;

    ArrayList<Property> propertyArrayList;

    public MoneyManager(PlayerManager playerManager) {
        playerList = playerManager.getPlayerArrayList();
    }

    public void isBankrupt(int turn, ArrayList<Property> propertyList) {
        Player player = playerList.get(turn);
        int propertySelected;
        Scanner scanner = new Scanner(System.in);
        if (player.getMoney() < 0 && !player.getPropertiesOwned().isEmpty()) {
            System.out.println(player.getPropertiesOwned());
            while (!player.getPropertiesOwned().isEmpty() && player.getMoney() < 0) {
                propertySelected = 0;
                System.out.println("Input the position of the property you wish to downgrade/mortgage \n Example: 12");
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
                        this.SellProperty(player, propertyList.get(propertySelected));
                    }
                }
            }
        }
        if (player.getMoney() < 0 && player.getPropertiesOwned().isEmpty()) {
            System.out.println("You are bankrupt!");
            playerList.remove(player);
        }
    }

    public ArrayList<Property> SellProperty(Player player,Property property) {
        propertyArrayList = player.getPropertiesOwned();
        if (property.getCurrentUpgrade() > 0) {
            player.changeMoney(property.getCost()/2);
            property.downgrade();
            return propertyArrayList;
        }
        propertyArrayList.remove(property);
        player.changeMoney(property.getCost()/2);
        return propertyArrayList;
    }

    public void upgradeProperty(Player player, Property property) {
        if (player.getMoney() < property.getCost()) {
            return;
        }
        if (property.getCurrentUpgrade() == 4) {
            return;
        }
        property.upgradeProperty();
        player.changeMoney(-property.getCost());
    }
}
