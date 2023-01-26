package pk;

import java.util.ArrayList;
import java.util.Random;

public class PlayerStrategies {
    private static Random rand = new Random();

    // * Implements the strategy where player randomly decides if they want to keep rerolling
    public static int randomStrategyPlayer(String currPlayer) {
        ArrayList<Faces> rollResults = Dice.rollEight();
        int numSkulls = DiceData.Skulls(rollResults);
        int pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(rollResults);
        int comboPoints = DiceData.comboPoints(rollResults);
        int totalPoints = comboPoints + pointsCoinsDiamonds;

//        System.out.println(currPlayer + " Rolled: " + rollResults);
//        System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);

        if (numSkulls >= 3) {
            totalPoints = 0;
//            System.out.println(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
        } else {
            boolean nextTurn = rand.nextBoolean();
//            System.out.println(currPlayer + " Turn Score: " + totalPoints);
//            System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
//            System.out.println(currPlayer + " Combo Score: " + comboPoints);

            while (nextTurn) {
//                System.out.println("--------------------------Reroll--------------------------");
                ArrayList<Faces> nextRollResults = Dice.reRoll(rollResults);

                numSkulls = DiceData.Skulls(nextRollResults);
                pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
                comboPoints = DiceData.comboPoints(nextRollResults);
                totalPoints = comboPoints + pointsCoinsDiamonds;

                if (numSkulls >= 3) {
                    totalPoints = 0;
                    nextTurn = false;
                } else {
                    nextTurn = rand.nextBoolean();
                }
//                System.out.println(currPlayer + " Next Roll: " + nextRollResults);
//                System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);
//                System.out.println(currPlayer + " Turn Score: " + totalPoints);
//                System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
//                System.out.println(currPlayer + " Combo Score: " + comboPoints);

            }
        }
//        System.out.println("--------------------------New Turn--------------------------");
        return totalPoints;
    }
}
