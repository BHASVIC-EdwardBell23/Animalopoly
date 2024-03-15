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
        return Cost[CurrentUpgrade];
    }

    public int getCurrentUpgrade() {
        return CurrentUpgrade;
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
                "Current Upgrade: " + getCurrentUpgrade() +
                "\nUpgrade Num | Price | Rent \n" +
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

    public void downgrade() {
        if (CurrentUpgrade < 0) {
            return;
        }
        CurrentUpgrade--;
    }

    public boolean upgradeProperty() {

        if (CurrentUpgrade == Upgrades) {
            return false;
        }
        CurrentUpgrade++;
        return true;
    }

    @Override
    public String toString() {
        return this.Name + "(" + getPosition() + ")";
    }
}