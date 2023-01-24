package pk;

import java.util.ArrayList;
import java.util.Random;

public class PlayerStrategies {

    // * Implements the strategy where player randomly decides if they want to keep rerolling
    public static int randomStrategyPlayer(String currPlayer) {
        ArrayList<Faces> rollResults = Dice.rollEight();
        int[] turnStatus = { DiceData.Skulls(rollResults), DiceData.pointsCoinsDiamonds(rollResults) };

        // Display initial roll results
//         System.out.println(currPlayer + " Rolled: " + rollResults);
//         System.out.println(currPlayer + " Skulls Rolled: " + turnStatus[0]);

        if (turnStatus[0] >= 3) {
            turnStatus[1] = 0;
//             System.out.println(currPlayer + "(END OF TURN) Turn Score: " + turnStatus[1]);
        } else {
            Random rand = new Random();
            boolean nextTurn = rand.nextBoolean();
//             System.out.println(currPlayer + " Turn Score: " + turnStatus[1]);

            while (nextTurn) {
//                 System.out.println("--------------------------Reroll--------------------------");
                ArrayList<Faces> nextRollResults = Dice.reRoll(rollResults);

                turnStatus[0] = DiceData.Skulls(nextRollResults);
                turnStatus[1] = DiceData.pointsCoinsDiamonds(nextRollResults);

                if (turnStatus[0] >= 3) {
                    turnStatus[1] = 0;
                    nextTurn = false;
                } else {
                    nextTurn = rand.nextBoolean();
                }

//                 System.out.println(currPlayer + " Next Roll: " + nextRollResults);
//                 System.out.println(currPlayer + " Skulls Rolled: " + turnStatus[0]);
//                 System.out.println(currPlayer + " Turn Score: " + turnStatus[1]);

            }
        }
//         System.out.println("--------------------------New Turn--------------------------");
        return turnStatus[1];
    }
}
