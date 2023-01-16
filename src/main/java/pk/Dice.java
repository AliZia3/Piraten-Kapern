package pk;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
    static int howManyFaces = Faces.values().length;
    static Random bag = new Random();

    // Rolls 1 dice
    public static Faces roll() {
        return Faces.values()[bag.nextInt(howManyFaces)];
    }

    // Rolls 8 dice
    public static ArrayList<Faces> rollEight() {
        ArrayList<Faces> roll_results = new ArrayList<Faces>();

        for (int i = 0; i < 8; i++) {
            roll_results.add(Faces.values()[bag.nextInt(howManyFaces)]);
        }

        return roll_results;

    }
}
