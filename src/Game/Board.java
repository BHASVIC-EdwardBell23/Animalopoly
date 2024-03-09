package src.Game;

import src.Cards.Cards;
import src.Player.Player;
import src.Property.Property;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JFrame{

    JFrame game;
    JPanel gameBoard;
    JButton[][] boardSpace;
    final int HorizontalBoardSize = 8;
    final int VerticalBoardSize = 7;

    public Board(ArrayList<Property> propertyArrayList, ArrayList<Player> playerArrayList, ArrayList<Cards> cardsArrayList) {
        setTitle("Animanopoly");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        this.game = new JFrame();
        this.gameBoard = new JPanel(new GridBagLayout());
        this.boardSpace = new JButton[HorizontalBoardSize][VerticalBoardSize];
        int boardSpaceNumber = 0;
        for (int i = 0; i < HorizontalBoardSize; i++) {
            for (int j = 0; j < VerticalBoardSize; j++) {
                if (i == HorizontalBoardSize-1 && j == VerticalBoardSize-1) {
                    boardSpace[i][j] = new JButton("Miss Next Turn");
                    gameBoard.add(boardSpace[i][j]);
                } else if (i == HorizontalBoardSize-1 || j == VerticalBoardSize-1 || i == 0 || j == 0) {
                    boardSpace[i][j] = new JButton();
                    boardSpace[i][j].setText("Space " + boardSpaceNumber + "\n" + propertyArrayList.get(boardSpaceNumber).getName());
                    boardSpace[i][j].addActionListener(new ActionListener(i,j, propertyArrayList.get(boardSpaceNumber)));
                    gameBoard.add(boardSpace[i][j]);
                    boardSpaceNumber++;
                } else {
                    JPanel emptyPanel = new JPanel();
                    emptyPanel.setBackground(Color.white);
                    gameBoard.add(emptyPanel);
                }
            }
        }
        add(gameBoard);
        setSize(HorizontalBoardSize*100,VerticalBoardSize*100);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
