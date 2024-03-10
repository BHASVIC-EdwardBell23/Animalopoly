package src.Player;

import src.Player.Player;
import src.Property.Property;
import src.Property.PropertyDisplayManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PlayerManager {
    int PlayerAmounts;
    String Name;
    ArrayList<Player> playerArrayList = new ArrayList<>();

    public PlayerManager() {
        this.PlayerAmounts = getPlayerAmount();
        this.playerArrayList = createPlayerList();
    }

    private ArrayList<Player> createPlayerList() {
        ArrayList<Player> playerArrayList1 = new ArrayList<>();
        for (int i = 0; i < PlayerAmounts; i++) {
            //Ask For Name
            String Name = "Test " + i;
            playerArrayList1.add(new Player(500, i,Name));
        }
        return playerArrayList1;
    }

    private int getPlayerAmount() {
        int Players = 0;
        Scanner scanner = new Scanner(System.in);
        //ask how many people are playing with GUI
        Players = scanner.nextInt();
        return Players;
    }

    public void positionCheck(int turn, ArrayList<Player> playerList, ArrayList<Property> propertyList, PropertyDisplayManager propertyDisplayManager) {
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
                    propertyDisplayManager.showPropertyWithBuyOption();
                }
                else if (property.getPosition() == playerPosition){
                    propertyDisplayManager.showPropertyWithRentOwed();
                }
            }
        }
    }

    public ArrayList<Player> getPlayerArrayList() {
        return playerArrayList;
    }
}