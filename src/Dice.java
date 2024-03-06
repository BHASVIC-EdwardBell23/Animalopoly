package src;

import java.util.Random;
import java.util.Scanner;
public class Dice {

    int Num;
    Random random = new Random();

    public Dice() {

    }

    public void rollDice() {
        this.Num = random.nextInt(6);
    }

    public int getNum() {
        return Num;
    }

    @Override
    public String toString() {
        return "Num:" + Num;
    }
}