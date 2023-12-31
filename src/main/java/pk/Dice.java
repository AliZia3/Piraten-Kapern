package pk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

// * Dice Class
public class Dice {
    static private final int howManyFaces = Faces.values().length;
    static private Random bag = new Random();
    static private int dices;

    // * Roll 8 dice
    public static ArrayList<Faces> rollEight() {
        ArrayList<Faces> rollResults = new ArrayList<Faces>();
        for (int i = 0; i < 8; i++) {
            rollResults.add(Faces.values()[bag.nextInt(howManyFaces)]);
        }
        return rollResults;
    }

    // * Roll random dice
    public static ArrayList<Faces> randomReRoll(ArrayList<Faces> prevRollResults) {
        dices = bag.nextInt(7) + 2;
        ArrayList<Faces> nextRollResults = new ArrayList<Faces>(prevRollResults);
        // Shuffles the indexes so any index has an eaual chance of being looped through in the for loop
        Collections.shuffle(nextRollResults);

        for (int i = 0; i < dices; i++) {
            if (nextRollResults.get(i) != Faces.SKULL) {
                nextRollResults.set(i, Faces.values()[bag.nextInt(howManyFaces)]);
            }
        }
        return nextRollResults;
    }

    // * Roll specified dice to maximize combos
    public static ArrayList<Faces> combosReRoll(ArrayList<Faces> prevRollResults, Faces[] facesKept) {
        // still rerolling a random number of dice between 2 and 8, but does not include dice we want combo for
        dices = bag.nextInt(7) + 2;
        ArrayList<Faces> nextRollResults = new ArrayList<Faces>(prevRollResults);
        Collections.shuffle(nextRollResults);

        for (int i=0; i < dices; i++) {
            if(!Arrays.asList(facesKept).contains(nextRollResults.get(i))) {
                nextRollResults.set(i, Faces.values()[bag.nextInt(howManyFaces)]);
            }
        }
        return nextRollResults;
    }
}
