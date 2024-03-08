package src.Board;

import java.util.Random;
import java.util.Scanner;
public class Dice {

    int Num;
    Random random = new Random();

    public Dice() {

    }

    public int rollDice() {
        this.Num = random.nextInt(6);
        return Num;
    }

    public int getNum() {
        return Num;
    }

    @Override
    public String toString() {
        return "Num:" + Num;
    }
}