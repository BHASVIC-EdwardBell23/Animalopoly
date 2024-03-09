package src.Property;

import src.Player.Player;

public class Property
{
    int Position;
    String Name;
    int[] Cost;
    int Upgrades;
    int[] Rent;
    int Owned;
    int CurrentUpgrade;
    public Property(int position, int cost, int rent, String name) {
        this.Position = position;
        this.Cost = new int[]{cost, cost * 2, cost * 4, cost * 8, cost*16};
        this.Rent = new int[]{rent, rent+50, rent+100, rent+150, rent+200};
        this.Owned = -1;
        this.Upgrades = 4;
        this.Name = name;
        this.CurrentUpgrade = 0;
    }

    public int getPosition() {
        return Position;
    }

    public int getCost() {
        return Cost[Upgrades];
    }

    public int getCurrentUpgrade() {
        return CurrentUpgrade;
    }

    public void buyUpgrade(Player player) {
        if (player.getMoney() > Cost[CurrentUpgrade+1] && this.CurrentUpgrade < Upgrades) {
            CurrentUpgrade++;
            System.out.println("Purchased Upgrade");
        }
        else {
            System.out.println("Not enough money!");
        }
    }
    public int sellProperty(Player player) {
        int sellValue = 0;
        if (Owned != player.getNum())
        for (int i = 0; i < CurrentUpgrade; i++) {
            sellValue = sellValue + (Cost[i]/2);
        }
        return sellValue;
    }
    public int getRent() {
        return Rent[CurrentUpgrade];
    }

    public int getOwned() {
        return Owned;
    }

    public void setOwned(Player player) {
        this.Owned = player.getNum();
    }

    public String toStringWithUpgradesDisplayed() {
        return "\nAnimal Name: " + this.Name + "\n" +
                "Upgrade Num | Price | Rent \n" +
                "Upgrade 0   |" + Cost[0] + "|" + Rent[0] +
                "\nUpgrade 1   |" + Cost[1] + "|" + Rent[1] +
                "\nUpgrade 2   |" + Cost[2] + "|" + Rent[2] +
                "\nUpgrade 3   |" + Cost[3] + "|" + Rent[3] +
                "\nUpgrade 4   |" + Cost[4] + "|" + Rent[4] +
                "\nPropertyNumber :" + Position;
    }
    public String toStringWithRent() {
        return "\nAnimal Name: " + this.Name + "\n" +
                "Upgrade " +CurrentUpgrade + " | " + Cost[CurrentUpgrade];
    }

    public String toStringWithBuy() {
        return "\nAnimal Name: " + this.Name + "\n" +
                "Price: " + Cost[0];
    }
}