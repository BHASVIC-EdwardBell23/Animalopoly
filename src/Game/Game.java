package src.Game;

import src.Cards.Cards;
import src.Cards.CardsManager;
import src.Dice.DiceManager;
import src.GUI;
import src.Player.Player;
import src.Player.PlayerManager;
import src.Property.Property;
import src.Property.PropertyDisplayManager;
import src.Property.PropertyManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    CardsManager cardsManager = new CardsManager();
    PlayerManager playerManager = new PlayerManager();
    ArrayList<Player> playerList;
    ArrayList<Property> propertyList;
    ArrayList<Cards> cardList;
    ArrayList<ArrayList> Lists;
    PropertyManager propertyManager = new PropertyManager();
    MoneyManager moneyManager;
    TurnManager turnManager;
    DiceManager diceManager;
    PropertyDisplayManager propertyDisplayManager;
    GUI gameBoard;

    public Game() {
        gameBoard = new GUI();
        playerList = playerManager.getPlayerArrayList();
        propertyList = propertyManager.getPropertyList();
        cardList = cardsManager.getCardList();
        Lists = new ArrayList<>();
        moneyManager = new MoneyManager(playerManager);
        diceManager = new DiceManager();
        propertyDisplayManager = new PropertyDisplayManager();
        turnManager = new TurnManager();

        Lists.add(playerList);
        Lists.add(propertyList);
        Lists.add(cardList);
        //Make gui
        startGame();
    }

    private void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean replay;
        int turn;
        do {
            turn = diceManager.determineWhoMovesFirst(playerList, gameBoard);
            playGame(turn);

            //ask for replay with buttons with GUI
            System.out.println("Replay?");
            replay = !scanner.nextLine().isBlank();
        } while (replay);
    }


    private void playGame(int turn) {
        do {
            if (playerList.get(turn).getMissTurn) {
                playerList.get(turn).setMissTurn(false);
                continue;
            }
            System.out.println("Enter Roll , Mortgage or Sell");
            turnManager.BeforeRoll(gameBoard,turn, playerList, propertyDisplayManager, propertyList, moneyManager);
            int diceSum = diceManager.diceRoll(gameBoard); // make them click a button to roll
            Lists = turnManager.AfterRoll(turn, playerList, diceSum, diceManager, cardList, cardsManager, playerManager, propertyList, propertyDisplayManager, moneyManager);
            turn = turnManager.turnRotation(turn, playerList);
        } while (!playerManager.determineWinner(playerList));
        System.out.println("You win: " + playerManager.WinnerName(playerList) + "!");
    }
}