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
        int turn;

        turn = diceManager.determineWhoMovesFirst(playerList);
        playGame(turn);

        //ask for replay with buttons with GUI
        System.out.println("Replay?");
        if (!scanner.nextLine().isBlank()) {
            deleteGame();
            new Game();
        }
    }

    private void deleteGame() {
        playerList = null;
        propertyList = null;
        cardList = null;
        Lists = null;
        moneyManager = null;
        diceManager = null;
        turnManager = null;
    }


    private void playGame(int turn) {
        do {
            System.out.println(playerList.get(turn).getName() + "'s Turn");
            gameBoard.clearCardShowing();
            if (playerList.get(turn).getMissTurn()) {
                playerList.get(turn).setMissTurn(false);
                continue;
            }
            turnManager.BeforeRoll(gameBoard,turn, playerList, propertyDisplayManager, propertyList, moneyManager);
            int diceSum = gameBoard.getDiceSum();
            Lists = turnManager.AfterRoll(gameBoard, turn, playerList, diceSum, diceManager, cardList, cardsManager, playerManager, propertyList, propertyDisplayManager, moneyManager);
            turn = turnManager.turnRotation(turn, playerList);
        } while (!playerManager.determineWinner(playerList));
        System.out.println("You win: " + playerManager.WinnerName(playerList) + "!");
    }
}