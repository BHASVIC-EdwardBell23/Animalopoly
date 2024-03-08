package src.Player;

import src.Player.Player;

import java.util.ArrayList;

public class PlayerManager {
    int PlayerAmounts;
    String Name;
    ArrayList<Player> playerArrayList = new ArrayList<>();

    public PlayerManager(int playerAmounts) {
        this.PlayerAmounts = playerAmounts;
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

    public ArrayList<Player> getPlayerArrayList() {
        return playerArrayList;
    }
}