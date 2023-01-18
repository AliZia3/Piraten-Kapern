package pk;

import java.util.ArrayList;

public class Turns {
    public static int turn(String currPlayer) {

        ArrayList<Faces> rollResults = Dice.rollEight();
        int[] turnStatus = { CheckSkulls.Skulls(rollResults), ScorePoints.pointsCoinsDiamonds(rollResults) };

        // Display initial roll results
        // System.out.println(currPlayer + " Rolled: " + rollResults);
        // System.out.println(currPlayer + " Skulls Rolled: " + turnStatus[0]);

        // If 3 or more skulls in first roll give player 0 points
        if (turnStatus[0] >= 3) {
            // turnStatus[1] = 0;
            // System.out.println(currPlayer + "(END OF TURN) Turn Score: " + turnStatus[1]);
            // System.out.println("=====================New Turn=============================");
            return 0;
        } else {
            // int turnTotalScore = turnStatus[1];
            // System.out.println(currPlayer + " Turn Score: " + turnStatus[1]);

            // Keep rerolling until 3 or more skulls
            while (turnStatus[0] < 3) {
                // System.out.println("====================Next Roll========================");
                ArrayList<Faces> nextRollResults = Dice.reRoll(rollResults);

                // Stores values of the next roll
                turnStatus[0] = CheckSkulls.Skulls(nextRollResults);
                turnStatus[1] = ScorePoints.pointsCoinsDiamonds(nextRollResults);
                // turnTotalScore += turnStatus[1];

                // Displays values of the next roll
                // System.out.println(currPlayer + " Next Roll: " + nextRollResults);
                // System.out.println(currPlayer + " Skulls Rolled: " + turnStatus[0]);
                // System.out.println(currPlayer + " Turn Score: " + turnStatus[1]);
                // System.out.println(currPlayer + " Turn Total Score: " + turnTotalScore);
            }
            // System.out.println("=====================New Turn=============================");
            return turnStatus[1];
        }

    }
}
