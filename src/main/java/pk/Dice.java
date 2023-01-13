package pk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Dice {

    public static ArrayList<Faces> roll() {
        ArrayList<Faces> roll_results = new ArrayList<Faces>();
        int howManyFaces = Faces.values().length;
//        System.out.println("  (DEBUG) there are " + howManyFaces + " faces");
//        System.out.println("  (DEBUG) " + Arrays.toString(Faces.values()));
        Random bag = new Random();

        KeepDice dices = new KeepDice();

        for (int i = 0; i < dices.diceInHand(); i++) {
            roll_results.add(Faces.values()[bag.nextInt(howManyFaces)]);
        }
        return roll_results;
    }
}
