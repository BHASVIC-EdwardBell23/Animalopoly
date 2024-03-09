package src.Game;

import src.Property.Property;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionListener implements java.awt.event.ActionListener {

    private int row;
    private int column;
    String property;
    public ActionListener(int i, int j,Property property) {
        this.row = i;
        this.column = j;
        this.property = property.toStringWithUpgradesDisplayed();
    }

    public void actionPerformed(ActionEvent e) {

    }
}
