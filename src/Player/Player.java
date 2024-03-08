package src.Player;

import src.Property.Property;

import java.util.ArrayList;

public class Player {
    public boolean getMissTurn;
    public String getName;
    int Money;
    int Position;
    int Num;
    String Name;
    ArrayList<Property> ownedProperties;
    boolean MissTurn;

    public Player(int money, int num, String name) {
        this.Money = money;
        this.Num = num;
        this.Name = name;
        this.Position = 0;
        this.MissTurn = false;
    }

    public int getMoney() {
        return Money;
    }

    public ArrayList<Property> getPropertiesOwned() {
        return ownedProperties;
    }

    public void addPropertyOwned(Property property) {
        ownedProperties.add(property);
    }

    public void changeMoney(int money) {
        Money += money;
    }

    public int getPosition() {
        return Position;
    }

    public void changePosition(int position) {
        Position += position;
        if (position > 25) {
            position = position - 26;
            if (position == 0) {
                changeMoney(500);
            }
            else {
                changeMoney(250);
            }
        }
    }

    public void setMissTurn(boolean missTurn) {
         this.MissTurn = missTurn;
    }

    public int getNum() {
        return Num;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return Name;
    }
}