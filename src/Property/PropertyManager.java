package src.Property;

import java.util.ArrayList;

public class PropertyManager {
    ArrayList<Property> propertiesList;
    String[] AnimalNames = {"Spider" ,"Hamster", "Squirrel", "Frog", "Rabbit", "Fox", "Wolf", "Deer", "Cat", "Dog", "Pig", "Cow", "Bear", "Lion", "Tiger", "Jaguar", "Elephant", "Giraffe" , "Rhino", "Penguin" ,"Dolpin", "Whale", "Dinosaur", "Shark", "Squid"};

    public PropertyManager() {
        this.propertiesList = createPropertyList();
    }

    public ArrayList<Property> createPropertyList() {
        ArrayList<Property> tempPropertyList = new ArrayList<>();
        for (int i = 0; i < AnimalNames.length; i++) {
            if (i == 13) {
                i++;
            }
            tempPropertyList.add(new Property(i+1, 100+(25*i), 50 + (15*i), AnimalNames[i]));
        }

        return tempPropertyList;
    }

    public ArrayList<Property> getPropertyList() {
        return propertiesList;
    }

    @Override
    public String toString() {
        return "" + propertiesList;
    }
}