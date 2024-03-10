package src.Property;

import src.Player.Player;

import java.util.ArrayList;

public class PropertyDisplayManager {
    String text;

    public PropertyDisplayManager() {

    }

    public void showPropertyWithRentOwed() {
    }//use ToStringWithRent method

    public void showPropertyWithBuyOption() {
    } //use ToStringWithBuy method

    public void MortgageMenu(int turn, ArrayList<Player> playerList) {
        Player player = playerList.get(turn);
        System.out.println(player.getPropertiesOwned());

    }
}
