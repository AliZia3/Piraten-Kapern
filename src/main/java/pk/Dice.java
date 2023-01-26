package pk;

import java.util.ArrayList;
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
    public static ArrayList<Faces> combosReRoll(ArrayList<Faces> prevRollResults, Faces maxFace) {
        // still rerolling a random number of dice between 2 and 8, but doesnt include dice we want combo for
        // ! Code may seem redundant and similar to above method, but is used to ensure that the random player and combo players' rerolls are different
        dices = bag.nextInt(7) + 2;
        ArrayList<Faces> reRollIndices = new ArrayList<Faces>(prevRollResults);
        Collections.shuffle(reRollIndices);

        for (int i=0; i < dices; i++) {
            if(reRollIndices.get(i) != maxFace && reRollIndices.get(i) != Faces.SKULL) {
                reRollIndices.set(i, Faces.values()[bag.nextInt(howManyFaces)]);
            }
        }
        return reRollIndices;
    }
}
