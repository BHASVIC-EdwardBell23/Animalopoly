package src.Player;

import src.Property.Property;

import java.util.ArrayList;
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
            System.out.println("What is your name? \n");
            Scanner scanner = new Scanner(System.in);
            Name = scanner.nextLine();
            playerArrayList1.add(new Player(500, i,Name));
        }
        return playerArrayList1;
    }

    private int getPlayerAmount() {
        int Players;
        Scanner scanner = new Scanner(System.in);
        //ask how many people are playing with GUI
        System.out.println("How many players?");
        try {
            Players = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Input a number");
            Players = getPlayerAmount();
        }
        return Players;
    }

    public void positionCheck(int turn, ArrayList<Player> playerList, ArrayList<Property> propertyList) {
        //check position and give reasonable response
        //possible response - miss turn activated - property pops up
        Player player = playerList.get(turn);
        int playerPosition = player.getPosition();
        if (playerPosition == 13) {
            playerList.get(turn).setMissTurn(true);
        }
        else {
            Scanner scanner = new Scanner(System.in);
            int Option;
            for (Property property : propertyList) {
                if (property.getPosition() == playerPosition && property.getOwned() == -1) {
                    property.toStringWithBuy();
                    System.out.println("""
                            Do you want to buy this property?\s
                            1) Yes\s
                            2) No""");
                    try {
                        Option = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Automatically selected yes");
                        Option = 1;
                    }
                    if (Option == 1) {
                        if (property.getCost() < player.getMoney()) {
                            player.ownedProperties = player.addPropertyOwned(property);
                            player.changeMoney(-property.getCost());
                        } else {
                            System.out.println("You don't have enough money");
                        }
                    }
                }
                else if (property.getPosition() == playerPosition && property.getOwned() != player.getNum()){
                    property.toStringWithRent();
                    player.changeMoney(-property.getRent());
                    int owned = property.getOwned();
                    for (Player player1 : playerList) {
                        if (player1.getNum() == owned) {
                            player1.changeMoney(property.getRent());
                        }
                    }
                }
            }
        }
    }

    public boolean determineWinner(ArrayList<Player> playerList) {
        return playerList.size() <= 1;
    }

    public String  WinnerName(ArrayList<Player> playerList) {
        if (playerList.size() > 1) {
            return "Null";
        }
        return playerList.get(0).getName();
    }

    public ArrayList<Player> getPlayerArrayList() {
        return playerArrayList;
    }
}