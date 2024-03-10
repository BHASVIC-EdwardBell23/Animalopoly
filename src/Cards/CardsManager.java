package src.Cards;

import src.Player.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class CardsManager {
    // Method to create a list of Cards objects

    ArrayList<Cards> cardList;

    ArrayList<Integer> randomNumbers = new ArrayList<>();


    public CardsManager() {
        this.cardList = createCardList();
    }

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
        cards.add(new Cards(20, randomNumbers.get(0), new ImageIcon("bunnyMakingMoney.png"), "Your bunny gets lots of attraction."));
        cards.add(new Cards(40, randomNumbers.get(1), new ImageIcon("catMakingMoney.png"), "Your cat gets pregnant, get money from government."));
        cards.add(new Cards(60, randomNumbers.get(2), new ImageIcon("monkeyMakingMoney.png"), "Your Monkey performs tricks that attract customers."));
        cards.add(new Cards(80, randomNumbers.get(3), new ImageIcon("dogmakingmoney.png"), "Your dog wins an award."));
        cards.add(new Cards(100, randomNumbers.get(4), new ImageIcon("dogmakingmoney.png"), "Your dog kills Thomas, the government award you for the bounty given because he committed armed robbery with a spoon."));
        cards.add(new Cards(120, randomNumbers.get(5), new ImageIcon("monkeyMakingMoney.png"), "Your Monkey throws poop at all of the targets at the competition."));
        cards.add(new Cards(140, randomNumbers.get(6), new ImageIcon("catMakingMoney.png"), "Your cat brings back money from strangers wallets.."));
        cards.add(new Cards(160, randomNumbers.get(7), new ImageIcon("bunnyMakingMoney.png"), "Your bunny wins a competition."));
        cards.add(new Cards(180, randomNumbers.get(8), new ImageIcon("monkeyMakingMoney.png"), "Your monkey climbs the fastest." ));
        cards.add(new Cards(200, randomNumbers.get(9), new ImageIcon("dogmakingmoney.png"), "Your dog eats 100 hot dogs in 2 minutes."));
        cards.add(new Cards(-20, randomNumbers.get(10), new ImageIcon("dogEatingAllFood.png"), "Your dog escapes and steals food."));
        cards.add(new Cards(-40, randomNumbers.get(11), new ImageIcon("monkeyDrawing.png"), "Your monkey destroys kids drawing, pay for compensation."));
        cards.add(new Cards(-60, randomNumbers.get(12), new ImageIcon("catFire.png"), "Your cat breaks microwave."));
        cards.add(new Cards(-80, randomNumbers.get(13), new ImageIcon("monkeyDrawing.png"), "Your monkey destroys drawing equipment."));
        cards.add(new Cards(-100, randomNumbers.get(14), new ImageIcon("dogEatingAllFood.png"), "Your dog steals kids lunch that costed a 'reasonable' price."));
        cards.add(new Cards(-120, randomNumbers.get(15), new ImageIcon("catFire.png"), "Your cat burns hand, pay for the Vets."));
        cards.add(new Cards(-140, randomNumbers.get(16), new ImageIcon("monkeyDrawing.png"), "Your monkey draws all over the walls."));
        cards.add(new Cards(-160, randomNumbers.get(17), new ImageIcon("catFire.png"), "Your cat burns down bakery."));
        cards.add(new Cards(-180, randomNumbers.get(18), new ImageIcon("catFire.png"), "Your cat burns down bakery whilst people are inside."));
        cards.add(new Cards(-200, randomNumbers.get(19), new ImageIcon("monkeyDrawing.png"), "Your monkey attacks a zookeeper."));
        return cards;
    }

    public ArrayList<Cards> getCardList() {
        return cardList;
    }

    public ArrayList<Cards> drawCard(int turn, ArrayList<Player> playerList) {
        for (Cards card: cardList) {
            if (card.getNumber() == 0) {
                playerList.get(turn).changeMoney(card.getMoney());
            }
            card.cardRotation();
        }

        return cardList;
    }
}