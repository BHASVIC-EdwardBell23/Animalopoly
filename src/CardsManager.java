package src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class CardsManager {
    // Method to create a list of Cards objects

    private ArrayList<Cards> cardList;
    ArrayList<Integer> randomNumbers = new ArrayList<>();


    public CardsManager() {
        this.cardList = createCardList();
    }
    Random random = new Random();

    public void randomNumberListMaker() {
        for (int i = 0; i < 20; i++) {
            randomNumbers.add(i);
        }
    }

    public void deckNumberGenerator() {
        Collections.shuffle(randomNumbers);
    }
    private ArrayList<Cards> createCardList() {
        randomNumberListMaker();
        deckNumberGenerator();
        ArrayList<Cards> cards = new ArrayList<>();
        cards.add(new Cards(20, randomNumbers.get(0)));
        cards.add(new Cards(40, randomNumbers.get(1)));
        cards.add(new Cards(60, randomNumbers.get(2)));
        cards.add(new Cards(80, randomNumbers.get(3)));
        cards.add(new Cards(100, randomNumbers.get(4)));
        cards.add(new Cards(120, randomNumbers.get(5)));
        cards.add(new Cards(140, randomNumbers.get(6)));
        cards.add(new Cards(160, randomNumbers.get(7)));
        cards.add(new Cards(180, randomNumbers.get(8)));
        cards.add(new Cards(200, randomNumbers.get(9)));
        cards.add(new Cards(-20, randomNumbers.get(10)));
        cards.add(new Cards(-40, randomNumbers.get(11)));
        cards.add(new Cards(-60, randomNumbers.get(12)));
        cards.add(new Cards(-80, randomNumbers.get(13)));
        cards.add(new Cards(-100, randomNumbers.get(14)));
        cards.add(new Cards(-120, randomNumbers.get(15)));
        cards.add(new Cards(-140, randomNumbers.get(16)));
        cards.add(new Cards(-160, randomNumbers.get(17)));
        cards.add(new Cards(-180, randomNumbers.get(18)));
        cards.add(new Cards(-200, randomNumbers.get(19)));
        return cards;
    }

    public ArrayList<Cards> getCardList() {
        return cardList;
    }
}