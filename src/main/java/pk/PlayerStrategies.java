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
        int comboPoints = DiceData.comboPoints(rollResults);
        int totalPoints = comboPoints + pointsCoinsDiamonds;

        System.out.println(currPlayer + " Rolled: " + rollResults);
        System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);

        if (numSkulls >= 3) {
            System.out.println(currPlayer + "(END OF TURN) Turn Score: " + 0);
            return 0;
        } else {
            boolean reRoll = rand.nextBoolean();
            System.out.println(currPlayer + " Turn Score: " + totalPoints);
            System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
            System.out.println(currPlayer + " Combo Score: " + comboPoints);

            while (reRoll) {
                System.out.println("--------------------------Reroll--------------------------");
                ArrayList<Faces> nextRollResults = Dice.randomReRoll(rollResults);
                numSkulls = DiceData.Skulls(nextRollResults);
                pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
                comboPoints = DiceData.comboPoints(nextRollResults);
                totalPoints = comboPoints + pointsCoinsDiamonds;

                if (numSkulls >= 3) {
                    return 0;
                } else {
                    reRoll = rand.nextBoolean();
                }

                System.out.println(currPlayer + " Next Roll: " + nextRollResults);
                System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);
                System.out.println(currPlayer + " Turn Score: " + totalPoints);
                System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
                System.out.println(currPlayer + " Combo Score: " + comboPoints);
            }
        }
        System.out.println("--------------------------New Turn--------------------------");
        return totalPoints;
    }


    public static int comboStrategy(String currPlayer) {

        // Initial Roll
        ArrayList<Faces> rollResults = Dice.rollEight();
        int numSkulls = DiceData.Skulls(rollResults);
        int pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(rollResults);
        int comboPoints = DiceData.comboPoints(rollResults);
        int totalPoints = comboPoints + pointsCoinsDiamonds;

        System.out.println(currPlayer + " Rolled: " + rollResults);
        System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);

        if (numSkulls >= 3) {
            System.out.println(currPlayer + "(END OF TURN) Turn Score: " + 0);
            return 0;
        } else {
            int fourOfAKindPoints = 200;
            Faces faceKept = DiceData.maxFaceCount(rollResults);

            System.out.println("!!!!!!!!!!! FACE KEPT: " + faceKept);
            System.out.println(currPlayer + " Turn Score: " + totalPoints);
            System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
            System.out.println(currPlayer + " Combo Score: " + comboPoints);

            while (true) {
                // If user has rolled 2 skulls and has gotten 400 points, don't reroll
                if (numSkulls == 2 && totalPoints >= 300) break;
                // If user has rolled at least 4 of a kind (meaning 200 points), don't reroll
                if (comboPoints >= fourOfAKindPoints) break;
                // If user has gotten 700 points, don't reroll
                if (totalPoints >= 600) break;

                System.out.println("--------------------------Reroll--------------------------");
                ArrayList<Faces> nextRollResults = Dice.combosReRoll(rollResults, faceKept);
                numSkulls = DiceData.Skulls(nextRollResults);
                pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
                comboPoints = DiceData.comboPoints(nextRollResults);
                totalPoints = comboPoints + pointsCoinsDiamonds;

                if (numSkulls >= 3) {
                    return 0;
                }
                System.out.println(currPlayer + " Next Roll: " + nextRollResults);
                System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);
                System.out.println(currPlayer + " Turn Score: " + totalPoints);
                System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
                System.out.println(currPlayer + " Combo Score: " + comboPoints);
            }
        }
        System.out.println("--------------------------New Turn--------------------------");
        return totalPoints;
    }

    public static int seaBattleStrategy(int sabersNeeded, int points, String currPlayer) {
        // Initial Roll
        ArrayList<Faces> rollResults = Dice.rollEight();
        int numSkulls = DiceData.Skulls(rollResults);
        int pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(rollResults);
        int comboPoints = DiceData.comboPoints(rollResults);
        int numSabers = DiceData.Sabers(rollResults);
        int totalPoints = comboPoints + pointsCoinsDiamonds;

        System.out.println(currPlayer + " Rolled: " + rollResults);
        System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);
        System.out.println(currPlayer + " Sabers Rolled: " + numSabers);

        if (numSkulls >= 3) {
            // reset total score
            totalPoints = 0;
            // deduct points for losing sea battle
            totalPoints -= points;
            System.out.println(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
        }
        else if (numSabers>=sabersNeeded) {
            totalPoints += points;
            System.out.println(currPlayer + "(END OF TURN REQUIRED SABERS REACHED) Turn Score: " + totalPoints);
        }
        else {
            Faces faceKept = Faces.SABER;

            System.out.println("FACE KEPT FOR SABER REROLL: " + faceKept);

            System.out.println(currPlayer + " Turn Score: " + totalPoints);
            System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
            System.out.println(currPlayer + " Combo Score: " + comboPoints);
            while (true) {
                System.out.println("--------------------------Reroll--------------------------");
                if (numSkulls >= 3) {
                    totalPoints = 0;
                    totalPoints -= points;
                    System.out.println(currPlayer + " Turn Score: " + totalPoints);
                    break;
                }
                if (numSabers>=sabersNeeded){
                    totalPoints += points;
                    System.out.println(currPlayer + " Turn Score: " + totalPoints);
                    break;
                }

                ArrayList<Faces> nextRollResults = Dice.combosReRoll(rollResults, faceKept);
                numSkulls = DiceData.Skulls(nextRollResults);
                pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
                comboPoints = DiceData.comboPoints(nextRollResults);
                numSabers = DiceData.Sabers(rollResults);
                totalPoints = comboPoints + pointsCoinsDiamonds;


                System.out.println(currPlayer + " Next Roll: " + nextRollResults);
                System.out.println(currPlayer + " Skulls Rolled: " + numSkulls);
                System.out.println(currPlayer + " Sabers Rolled: " + numSabers);
                System.out.println(currPlayer + " Turn Score: " + totalPoints);
                System.out.println(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
                System.out.println(currPlayer + " Combo Score: " + comboPoints);
            }
        }
        System.out.println("--------------------------New Turn--------------------------");
        return totalPoints;
    }
}
