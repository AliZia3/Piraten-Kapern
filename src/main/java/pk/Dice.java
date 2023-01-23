package pk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// * Dice Class
public class Dice {
    static private int howManyFaces = Faces.values().length;
    static private Random bag = new Random();

    // * Roll 8 dice
    public static ArrayList<Faces> rollEight() {
        ArrayList<Faces> rollResults = new ArrayList<Faces>();

        for (int i = 0; i < 8; i++) {
            rollResults.add(Faces.values()[bag.nextInt(howManyFaces)]);
        }

        return rollResults;
    }


}
