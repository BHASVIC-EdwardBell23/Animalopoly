package src.Player;

import src.Property.Property;

import java.util.ArrayList;

public class Player {
    public boolean MissTurn;
    public String getName;
    int Money;
    int Position;
    int Num;
    String Name;
    ArrayList<Property> ownedProperties;

    public Player(int money, int num, String name) {
        this.Money = money;
        this.Num = num;
        this.Name = name;
        this.Position = 0;
        this.MissTurn = false;
        ownedProperties = new ArrayList<>();
    }

    public int getMoney() {
        return Money;
    }

    public ArrayList<Property> getPropertiesOwned() {
        return ownedProperties;
    }

    public ArrayList<Property> addPropertyOwned(Property property) {
        ownedProperties.add(property);
        property.setOwned(this);
        return ownedProperties;
    }

    public void changeMoney(int money) {
        Money += money;
    }

    public int getPosition() {
        return Position;
    }

    public void changePosition(int position) {
        Position += position;
        if (Position > 25) {
            Position = Position - 26;
            if (Position == 0) {
                changeMoney(1000);
            }
            else {
                changeMoney(500);
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

    public boolean getMissTurn() {
        return MissTurn;
    }
}