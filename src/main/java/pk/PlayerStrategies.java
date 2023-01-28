package pk;

import java.util.ArrayList;
import java.util.Random;

public class PlayerStrategies {
    private static Random rand = new Random();

    // * Implements the strategy where player randomly decides if they want to keep rerolling
    public static int randomStrategy(String currPlayer) {
        ArrayList<Faces> rollResults = Dice.rollEight();
        int numSkulls = DiceData.Skulls(rollResults);
        int pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(rollResults);
        int comboPoints = DiceData.comboPoints(rollResults, false);
        int totalPoints = comboPoints + pointsCoinsDiamonds;
        boolean reRoll = true;

        while (reRoll) {
            if (numSkulls >= 3)
                return 0;

            reRoll = rand.nextBoolean();

            ArrayList<Faces> nextRollResults = Dice.randomReRoll(rollResults);
            numSkulls = DiceData.Skulls(nextRollResults);
            pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
            comboPoints = DiceData.comboPoints(nextRollResults, false);
            totalPoints = comboPoints + pointsCoinsDiamonds;
        }
        return totalPoints;
    }

    public static int comboStrategy(String currPlayer) {

        ArrayList<Faces> rollResults = Dice.rollEight();
        int numSkulls = DiceData.Skulls(rollResults);
        int pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(rollResults);
        int comboPoints = DiceData.comboPoints(rollResults,false);
        int totalPoints = comboPoints + pointsCoinsDiamonds;

        int fourOfAKindPoints = 200;
        Faces[] facesKept = {DiceData.maxFaceCount(rollResults), Faces.SKULL};

        while (true) {
            if (numSkulls >= 3)
                return 0;
            // If user has rolled 2 skulls and has gotten 400 points, don't reroll
            if (numSkulls == 2 && totalPoints >= 300)
                return totalPoints;
            // If user has rolled at least 4 of a kind (meaning 200 points), don't reroll
            if (comboPoints >= fourOfAKindPoints)
                return totalPoints;
            // If user has gotten 700 points, don't reroll
            if (totalPoints >= 600)
                return totalPoints;

            ArrayList<Faces> nextRollResults = Dice.combosReRoll(rollResults, facesKept);
            numSkulls = DiceData.Skulls(nextRollResults);
            pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
            comboPoints = DiceData.comboPoints(nextRollResults, false);
            totalPoints = comboPoints + pointsCoinsDiamonds;

        }
    }

    public static int seaBattleStrategy(int sabersNeeded, int points, String currPlayer) {
        // Initial Roll
        ArrayList<Faces> rollResults = Dice.rollEight();
        int numSkulls = DiceData.Skulls(rollResults);
        int pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(rollResults);
        int comboPoints = DiceData.comboPoints(rollResults,false);
        int numSabers = DiceData.Sabers(rollResults);
        int totalPoints = comboPoints + pointsCoinsDiamonds;

        Faces[] facesKept = {Faces.SABER, Faces.SKULL};

        while (true) {
            if (numSkulls >= 3) {
                totalPoints = 0;
                totalPoints -= points;
                return totalPoints;
            } else if (numSabers >= sabersNeeded) {
                totalPoints += points;
                return totalPoints;
            }

            ArrayList<Faces> nextRollResults = Dice.combosReRoll(rollResults, facesKept);
            numSkulls = DiceData.Skulls(nextRollResults);
            pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
            comboPoints = DiceData.comboPoints(nextRollResults,false);
            numSabers = DiceData.Sabers(rollResults);
            totalPoints = comboPoints + pointsCoinsDiamonds;
        }
    }

    public static int monkeyBusinessStrategy() {
        ArrayList<Faces> rollResults = Dice.rollEight();
        int numSkulls = DiceData.Skulls(rollResults);
        int pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(rollResults);
        int pointsMonkeyParrot = DiceData.pointsMonkeyParrot(rollResults);
        int comboPoints = DiceData.comboPoints(rollResults, true);
        int totalPoints = pointsMonkeyParrot + pointsCoinsDiamonds + comboPoints;
        int fourOfAKindPoints = 200;
        Faces[] facesKept = {Faces.MONKEY, Faces.PARROT, Faces.SKULL};

        while (true) {
            if (numSkulls >= 3)
                return 0;
            // If user has rolled 2 skulls and has gotten 400 points, don't reroll
            if (numSkulls == 2 && totalPoints >= 300)
                return totalPoints;
            // If user has gotten 700 points, don't reroll
            if (totalPoints >= 600)
                return totalPoints;
            // If user has rolled at least 4 of a kind (meaning 200 points), don't reroll
            if (comboPoints >= fourOfAKindPoints || pointsMonkeyParrot >= fourOfAKindPoints)
                return totalPoints;

            ArrayList<Faces> nextRollResults = Dice.combosReRoll(rollResults, facesKept);
            numSkulls = DiceData.Skulls(nextRollResults);
            pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
            pointsMonkeyParrot = DiceData.pointsMonkeyParrot(nextRollResults);
            comboPoints = DiceData.comboPoints(nextRollResults, true);
            totalPoints = pointsMonkeyParrot + pointsCoinsDiamonds + comboPoints;

        }
    }

}