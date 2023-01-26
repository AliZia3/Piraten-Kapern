package pk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// * Dice Class
public class Dice {
    static private final int howManyFaces = Faces.values().length;
    static private Random bag = new Random();

    // * Roll 8 dice
    public static ArrayList<Faces> rollEight() {
        ArrayList<Faces> rollResults = new ArrayList<Faces>();
        for (int i = 0; i < 8; i++) {
            rollResults.add(Faces.values()[bag.nextInt(howManyFaces)]);
        }
        return rollResults;
    }

    // * Roll random dice
    public static ArrayList<Faces> reRoll(ArrayList<Faces> prevRollResults) {
        int dices = bag.nextInt(7) + 2;
        ArrayList<Faces> nextRollResults = new ArrayList<Faces>(prevRollResults);
        Collections.shuffle(nextRollResults);

        for (int i = 0; i < dices; i++) {
            if (nextRollResults.get(i) != Faces.SKULL) {
                nextRollResults.set(i, Faces.values()[bag.nextInt(howManyFaces)]);
            }
        }
        return nextRollResults;
    }
}
