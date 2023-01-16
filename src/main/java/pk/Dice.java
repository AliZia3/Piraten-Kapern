package pk;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
    static int howManyFaces = Faces.values().length;
    static Random bag = new Random();

    // * Roll 1 dice
    // public Faces roll() {
    // return Faces.values()[bag.nextInt(howManyFaces)];
    // }

    // * Roll 8 dice (F02)
    public ArrayList<Faces> rollEight() {
        ArrayList<Faces> rollResults = new ArrayList<Faces>();

        for (int i = 0; i < 8; i++) {
            rollResults.add(Faces.values()[bag.nextInt(howManyFaces)]);
        }

        return rollResults;
    }

    // * Player keeps random number of dice (F03)
    public ArrayList<Faces> nextRoll(ArrayList<Faces> rollResults) {
        Random dice = new Random();
        int dices = dice.nextInt(7) + 2;

        ArrayList<Faces> nextRollResults = new ArrayList<Faces>(rollResults);

        for (int i = 0; i < dices; i++) {
            int index = bag.nextInt(8);
            nextRollResults.set(index, Faces.values()[bag.nextInt(howManyFaces)]);
        }

        return nextRollResults;
    }

}
