package src;

public class Cards {
    int Money;
    int Number;

    public Cards(int money, int number) {
        this.Money = money;
        this.Number = number;
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
