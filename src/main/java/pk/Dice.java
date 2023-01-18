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
    public static ArrayList<Faces> rollEight() {
        ArrayList<Faces> rollResults = new ArrayList<Faces>();

        for (int i = 0; i < 8; i++) {
            rollResults.add(Faces.values()[bag.nextInt(howManyFaces)]);
        }

        return rollResults;
    }

    // * Roll/Keep random dice (F03)
    public static ArrayList<Faces> reRoll(ArrayList<Faces> prevRollResults) {
        Random dice = new Random();
        int dices = dice.nextInt(7) + 2;
        ArrayList<Faces> nextRollResults = prevRollResults;

        for(int i=0; i<dices; i++){
            if (nextRollResults.get(i)!=Faces.SKULL){
                nextRollResults.set(i, Faces.values()[bag.nextInt(howManyFaces)]);
            }
        }

        return nextRollResults;
    }

}
