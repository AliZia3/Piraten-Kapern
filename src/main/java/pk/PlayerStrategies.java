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
        ArrayList<Faces> nextRollResults = null;
        int count = 0;
        boolean reRoll = true;

//        System.out.println(currPlayer + " Rolled: " + rollResults);
//        System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);
//        System.out.println(currPlayer + " Turn Score: " + totalPoints);
//        System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
//        System.out.println(currPlayer + " Combo Score: " + comboPoints);

        while (reRoll) {
            if (numSkulls >= 3) {
//                System.out.println(currPlayer + "(END OF TURN) Turn Score: " + 0);
//                System.out.println("--------------------------New Turn--------------------------");
                return 0;
            }
//            System.out.println("--------------------------Reroll--------------------------");
            reRoll = rand.nextBoolean();

            if (count == 0) {
                nextRollResults = Dice.randomReRoll(rollResults);
                count++;
            } else {
                nextRollResults = Dice.randomReRoll(nextRollResults);
            }

            numSkulls = DiceData.Skulls(nextRollResults);
            pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
            comboPoints = DiceData.comboPoints(nextRollResults, false);
            totalPoints = comboPoints + pointsCoinsDiamonds;

//            System.out.println(currPlayer + " Next Roll: " + nextRollResults);
//            System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);
//            System.out.println(currPlayer + " Turn Score: " + totalPoints);
//            System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
//            System.out.println(currPlayer + " Combo Score: " + comboPoints);
        }
//        System.out.println("--------------------------New Turn--------------------------");
        return totalPoints;
    }

    public static int comboStrategy(String currPlayer) {

        ArrayList<Faces> rollResults = Dice.rollEight();
        int numSkulls = DiceData.Skulls(rollResults);
        int pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(rollResults);
        int comboPoints = DiceData.comboPoints(rollResults,false);
        int totalPoints = comboPoints + pointsCoinsDiamonds;

        ArrayList<Faces> nextRollResults = null;
        int count = 0;

//        System.out.println(currPlayer + " Rolled: " + rollResults);
//        System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);
//        System.out.println(currPlayer + " Turn Score: " + totalPoints);
//        System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
//        System.out.println(currPlayer + " Combo Score: " + comboPoints);

        int fourOfAKindPoints = 200;
        Faces[] facesKept = {DiceData.maxFaceCount(rollResults), Faces.SKULL};
//        System.out.println("!!!!!!!!!!! FACE KEPT: " + Arrays.toString(facesKept));

        while (true) {
            if (numSkulls >= 3) {
//                System.out.println(currPlayer + "(END OF TURN) Turn Score: " + 0);
//                System.out.println("--------------------------New Turn--------------------------");
                return 0;
            }
            // If user has rolled 2 skulls and has gotten 400 points, don't reroll
            if (numSkulls == 2 && totalPoints >= 300) {
//                System.out.println(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
//                System.out.println("--------------------------New Turn--------------------------");
                return totalPoints;
            }
            // If user has rolled at least 4 of a kind (meaning 200 points), don't reroll
            if (comboPoints >= fourOfAKindPoints) {
//                System.out.println(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
//                System.out.println("--------------------------New Turn--------------------------");
                return totalPoints;
            }
            // If user has gotten 700 points, don't reroll
            if (totalPoints >= 600){
//                System.out.println(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
//                System.out.println("--------------------------New Turn--------------------------");
                return totalPoints;
            }

            if (count == 0) {
                nextRollResults = Dice.combosReRoll(rollResults, facesKept);
                count++;
            } else {
                nextRollResults = Dice.combosReRoll(nextRollResults, facesKept);
            }
//            System.out.println("--------------------------Reroll--------------------------");

            numSkulls = DiceData.Skulls(nextRollResults);
            pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
            comboPoints = DiceData.comboPoints(nextRollResults, false);
            totalPoints = comboPoints + pointsCoinsDiamonds;

//            System.out.println(currPlayer + " Next Roll: " + nextRollResults);
//            System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);
//            System.out.println(currPlayer + " Turn Score: " + totalPoints);
//            System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
//            System.out.println(currPlayer + " Combo Score: " + comboPoints);
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

        ArrayList<Faces> nextRollResults = null;
        int count = 0;

//        System.out.println(currPlayer + " Rolled: " + rollResults);
//        System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);
//        System.out.println(currPlayer + " Sabers Rolled: " + numSabers);
//        System.out.println(currPlayer + " Turn Score: " + totalPoints);
//        System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
//        System.out.println(currPlayer + " Combo Score: " + comboPoints);

        Faces[] facesKept = {Faces.SABER, Faces.SKULL};
//        System.out.println("FACE KEPT FOR SABER REROLL: " + Arrays.toString(facesKept));

        while (true) {
            if (numSkulls >= 3) {
                totalPoints = 0;
                totalPoints -= points;
//                System.out.println(currPlayer + "(END OF TURN & SABERS NOT REACHED) Turn Score: " + totalPoints);
//                System.out.println("--------------------------New Turn--------------------------");
                return totalPoints;
            }
            if (numSabers >= sabersNeeded) {
                totalPoints += points;
//                System.out.println(currPlayer + "(END OF TURN SABERS REACHED) Turn Score: " + totalPoints);
//                System.out.println("--------------------------New Turn--------------------------");
                return totalPoints;
            }

            if (count == 0) {
                nextRollResults = Dice.combosReRoll(rollResults, facesKept);
                count++;
            } else {
                nextRollResults = Dice.combosReRoll(nextRollResults, facesKept);
            }

//            System.out.println("--------------------------Reroll--------------------------");


            numSkulls = DiceData.Skulls(nextRollResults);
            pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
            comboPoints = DiceData.comboPoints(nextRollResults,false);
            numSabers = DiceData.Sabers(nextRollResults);
            totalPoints = comboPoints + pointsCoinsDiamonds;

//            System.out.println(currPlayer + " Next Roll: " + nextRollResults);
//            System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);
//            System.out.println(currPlayer + " Sabers Rolled: " + numSabers);
//            System.out.println(currPlayer + " Turn Score: " + totalPoints);
//            System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
//            System.out.println(currPlayer + " Combo Score: " + comboPoints);
        }
    }

    public static int monkeyBusinessStrategy(String currPlayer) {
        ArrayList<Faces> rollResults = Dice.rollEight();
        int numSkulls = DiceData.Skulls(rollResults);
        int pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(rollResults);
        int pointsMonkeyParrot = DiceData.pointsMonkeyParrot(rollResults);
        int comboPoints = DiceData.comboPoints(rollResults, true);
        int totalPoints = pointsMonkeyParrot + pointsCoinsDiamonds + comboPoints;
        int fourOfAKindPoints = 200;

        ArrayList<Faces> nextRollResults = null;
        int count = 0;

//        System.out.println(currPlayer + " Rolled: " + rollResults);
//        System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);
//        System.out.println(currPlayer + " Turn Score: " + totalPoints);
//        System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
//        System.out.println(currPlayer + " Monkeys/Parrot Score: " + pointsMonkeyParrot);
//        System.out.println(currPlayer + " Combo Score: " + comboPoints);

        Faces[] facesKept = {Faces.MONKEY, Faces.PARROT, Faces.SKULL};

//        System.out.println("FACE KEPT FOR Monkey Business Strat: " + Arrays.toString(facesKept));

        while (true) {
            if (numSkulls >= 3) {
//                System.out.println(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
//                System.out.println("--------------------------New Turn--------------------------");
                return 0;
            }
            // If user has rolled 2 skulls and has gotten 400 points, don't reroll
            if (numSkulls == 2 && totalPoints >= 300) {
//                System.out.println(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
//                System.out.println("--------------------------New Turn--------------------------");
                return totalPoints;
            }
            // If user has gotten 700 points, don't reroll
            if (totalPoints >= 600) {
//                System.out.println(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
//                System.out.println("--------------------------New Turn--------------------------");
                return totalPoints;
            }
            // If user has rolled at least 4 of a kind (meaning 200 points), don't reroll
            if (comboPoints >= fourOfAKindPoints || pointsMonkeyParrot >= fourOfAKindPoints) {
//                System.out.println(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
//                System.out.println("--------------------------New Turn--------------------------");
                return totalPoints;
            }

            if (count == 0) {
                nextRollResults = Dice.combosReRoll(rollResults, facesKept);
                count++;
            } else {
                nextRollResults = Dice.combosReRoll(nextRollResults, facesKept);
            }
//            System.out.println("--------------------------Reroll--------------------------");


            numSkulls = DiceData.Skulls(nextRollResults);
            pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
            pointsMonkeyParrot = DiceData.pointsMonkeyParrot(nextRollResults);
            comboPoints = DiceData.comboPoints(nextRollResults, true);
            totalPoints = pointsMonkeyParrot + pointsCoinsDiamonds + comboPoints;

//            System.out.println(currPlayer + " Next Roll: " + nextRollResults);
//            System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);
//            System.out.println(currPlayer + " Turn Score: " + totalPoints);
//            System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
//            System.out.println(currPlayer + " Monkeys/Parrot Score: " + pointsMonkeyParrot);
//            System.out.println(currPlayer + " Combo Score: " + comboPoints);
        }
    }

}