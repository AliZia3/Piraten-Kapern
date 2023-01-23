package pk;

import java.util.ArrayList;
import java.util.Random;

public class PlayerStrategies {
    public static int randomStrategy(String currPlayer) {
        ArrayList<Faces> rollResults = Dice.rollEight();
        int[] turnStatus = { DiceData.Skulls(rollResults), DiceData.pointsCoinsDiamonds(rollResults) };

        if (turnStatus[0] >= 3) {
            return 0;
        } else {
            Random attempts = new Random();
            int turnCondition = attempts.nextInt(2);

            while (turnCondition != 0) {
                ArrayList<Faces> nextRollResults = Dice.reRoll(rollResults);

                turnStatus[0] = DiceData.Skulls(nextRollResults);
                turnStatus[1] = DiceData.pointsCoinsDiamonds(nextRollResults);

                if (turnStatus[0] >= 3) {
                    return 0;
                } else {
                    turnCondition = attempts.nextInt(2);
                }

            }
            return turnStatus[1];
        }
    }
}
