package src;

import javax.swing.*;

public class Cards {
    int Money;
    int Number;
    ImageIcon imageIcon;
    String Message;

    public Cards(int money, int number, ImageIcon img, String message) {
        this.Money = money;
        this.Number = number;
        this.imageIcon = img;
        this.Message = message;
    }

    public int getMoney() {
        return Money;
    }

    public int getNumber() {
        return this.Number;
    }

    public void cardRotation() {
        this.Number--;
        if (this.Number < 0) {
            this.Number = 19;
        }
    }

    @Override
    public String toString() {
        if (this.Money < 0) {
            return "You lost " + Money;
        }
        return "You won " + Money;
    }
}
