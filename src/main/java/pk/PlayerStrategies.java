package pk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class PlayerStrategies {
    private static Random rand = new Random();
    private static final Logger logger = LogManager.getLogger(Game.class);

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

        if (ManageLogs.log){
            logger.trace(currPlayer + " Rolled: " + rollResults);
            logger.trace(currPlayer + " Skulls Rolled: " + numSkulls);
            logger.trace(currPlayer + " Turn Score: " + totalPoints);
            logger.trace(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
            logger.trace(currPlayer + " Combo Score: " + comboPoints);
        }

        while (reRoll) {
            if (numSkulls >= 3) {
                if(ManageLogs.log){
                logger.trace(currPlayer + "(END OF TURN) Turn Score: " + 0);
                logger.trace("--------------------------New Turn--------------------------");
                }
                return 0;
            }
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

            if(ManageLogs.log) {
                logger.trace("--------------------------Reroll--------------------------");
                logger.trace(currPlayer + " Next Roll: " + nextRollResults);
                logger.trace(currPlayer + " Skulls Rolled: " + numSkulls);
                logger.trace(currPlayer + " Turn Score: " + totalPoints);
                logger.trace(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
                logger.trace(currPlayer + " Combo Score: " + comboPoints);
            }
        }
        if (ManageLogs.log) logger.trace("--------------------------New Turn--------------------------");
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

        if(ManageLogs.log) {
            logger.trace(currPlayer + " Rolled: " + rollResults);
            logger.trace(currPlayer + " Skulls Rolled: " + numSkulls);
            logger.trace(currPlayer + " Turn Score: " + totalPoints);
            logger.trace(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
            logger.trace(currPlayer + " Combo Score: " + comboPoints);
        }

        int fourOfAKindPoints = 200;
        Faces[] facesKept = {DiceData.maxFaceCount(rollResults), Faces.SKULL};

        if(ManageLogs.log) logger.trace("!!!!!!!!!!! FACE KEPT: " + Arrays.toString(facesKept));

        while (true) {
            if (numSkulls >= 3) {
                if(ManageLogs.log){
                    logger.trace(currPlayer + "(END OF TURN) Turn Score: " + 0);
                    logger.trace("--------------------------New Turn--------------------------");
                }
                return 0;
            }
            // If user has rolled 2 skulls and has gotten 400 points, don't reroll
            if (numSkulls == 2 && totalPoints >= 300) {
                if(ManageLogs.log) {
                    logger.trace(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
                    logger.trace("--------------------------New Turn--------------------------");
                }
                return totalPoints;
            }
            // If user has rolled at least 4 of a kind (meaning 200 points), don't reroll
            if (comboPoints >= fourOfAKindPoints) {
                if(ManageLogs.log){
                    logger.trace(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
                    logger.trace("--------------------------New Turn--------------------------");
                }
                return totalPoints;
            }
            // If user has gotten 700 points, don't reroll
            if (totalPoints >= 600){
                if(ManageLogs.log){
                    logger.trace(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
                    logger.trace("--------------------------New Turn--------------------------");
                }
                return totalPoints;
            }

            if (count == 0) {
                nextRollResults = Dice.combosReRoll(rollResults, facesKept);
                count++;
            } else {
                nextRollResults = Dice.combosReRoll(nextRollResults, facesKept);
            }

            numSkulls = DiceData.Skulls(nextRollResults);
            pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
            comboPoints = DiceData.comboPoints(nextRollResults, false);
            totalPoints = comboPoints + pointsCoinsDiamonds;

            if(ManageLogs.log) {
                logger.trace("--------------------------Reroll--------------------------");
                logger.trace(currPlayer + " Next Roll: " + nextRollResults);
                logger.trace(currPlayer + " Skulls Rolled: " + numSkulls);
                logger.trace(currPlayer + " Turn Score: " + totalPoints);
                logger.trace(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
                logger.trace(currPlayer + " Combo Score: " + comboPoints);
            }
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

        if(ManageLogs.log) {
            logger.trace(currPlayer + " Rolled: " + rollResults);
            logger.trace(currPlayer + " Skulls Rolled: " + numSkulls);
            logger.trace(currPlayer + " Sabers Rolled: " + numSabers);
            logger.trace(currPlayer + " Turn Score: " + totalPoints);
            logger.trace(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
            logger.trace(currPlayer + " Combo Score: " + comboPoints);
        }

        Faces[] facesKept = {Faces.SABER, Faces.SKULL};

        while (true) {
            if (numSkulls >= 3) {
                totalPoints = 0;
                totalPoints -= points;
                if(ManageLogs.log) {
                    logger.trace(currPlayer + "(END OF TURN & SABERS NOT REACHED) Turn Score: " + totalPoints);
                    logger.trace("--------------------------New Turn--------------------------");
                }
                return totalPoints;
            }
            if (numSabers >= sabersNeeded) {
                totalPoints += points;
                if(ManageLogs.log) {
                    logger.trace(currPlayer + "(END OF TURN SABERS REACHED) Turn Score: " + totalPoints);
                    logger.trace("--------------------------New Turn--------------------------");
                }
                return totalPoints;
            }

            if (count == 0) {
                nextRollResults = Dice.combosReRoll(rollResults, facesKept);
                count++;
            } else {
                nextRollResults = Dice.combosReRoll(nextRollResults, facesKept);
            }

            numSkulls = DiceData.Skulls(nextRollResults);
            pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
            comboPoints = DiceData.comboPoints(nextRollResults,false);
            numSabers = DiceData.Sabers(nextRollResults);
            totalPoints = comboPoints + pointsCoinsDiamonds;

            if(ManageLogs.log){
                logger.trace("--------------------------Reroll--------------------------");
                logger.trace(currPlayer + " Next Roll: " + nextRollResults);
                logger.trace(currPlayer + " Skulls Rolled: " + numSkulls);
                logger.trace(currPlayer + " Sabers Rolled: " + numSabers);
                logger.trace(currPlayer + " Turn Score: " + totalPoints);
                logger.trace(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
                logger.trace(currPlayer + " Combo Score: " + comboPoints);
            }
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

        if(ManageLogs.log) {
            logger.trace(currPlayer + " Rolled: " + rollResults);
            logger.trace(currPlayer + " Skulls Rolled: " + numSkulls);
            logger.trace(currPlayer + " Turn Score: " + totalPoints);
            logger.trace(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
            logger.trace(currPlayer + " Monkeys/Parrot Score: " + pointsMonkeyParrot);
            logger.trace(currPlayer + " Combo Score: " + comboPoints);
        }

        Faces[] facesKept = {Faces.MONKEY, Faces.PARROT, Faces.SKULL};

        if(ManageLogs.log) logger.trace("FACE KEPT FOR Monkey Business Strat: " + Arrays.toString(facesKept));

        while (true) {
            if (numSkulls >= 3) {
                if(ManageLogs.log) {
                    logger.trace(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
                    logger.trace("--------------------------New Turn--------------------------");
                }
                return 0;
            }
            // If user has rolled 2 skulls and has gotten 400 points, don't reroll
            if (numSkulls == 2 && totalPoints >= 300) {
                if(ManageLogs.log) {
                    logger.trace(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
                    logger.trace("--------------------------New Turn--------------------------");
                }
                return totalPoints;
            }
            // If user has gotten 700 points, don't reroll
            if (totalPoints >= 600) {
                if(ManageLogs.log) {
                    logger.trace(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
                    logger.trace("--------------------------New Turn--------------------------");
                }
                return totalPoints;
            }
            // If user has rolled at least 4 of a kind (meaning 200 points), don't reroll
            if (comboPoints >= fourOfAKindPoints || pointsMonkeyParrot >= fourOfAKindPoints) {
                if(ManageLogs.log) {
                    logger.trace(currPlayer + "(END OF TURN) Turn Score: " + totalPoints);
                    logger.trace("--------------------------New Turn--------------------------");
                }
                return totalPoints;
            }

            if (count == 0) {
                nextRollResults = Dice.combosReRoll(rollResults, facesKept);
                count++;
            } else {
                nextRollResults = Dice.combosReRoll(nextRollResults, facesKept);
            }

            numSkulls = DiceData.Skulls(nextRollResults);
            pointsCoinsDiamonds = DiceData.pointsCoinsDiamonds(nextRollResults);
            pointsMonkeyParrot = DiceData.pointsMonkeyParrot(nextRollResults);
            comboPoints = DiceData.comboPoints(nextRollResults, true);
            totalPoints = pointsMonkeyParrot + pointsCoinsDiamonds + comboPoints;

            if(ManageLogs.log){
                logger.trace("--------------------------Reroll--------------------------");
                logger.trace(currPlayer + " Next Roll: " + nextRollResults);
                logger.trace(currPlayer + " Skulls Rolled: " + numSkulls);
                logger.trace(currPlayer + " Turn Score: " + totalPoints);
                logger.trace(currPlayer + " Coins/Diamonds Score: " + pointsCoinsDiamonds);
                logger.trace(currPlayer + " Monkeys/Parrot Score: " + pointsMonkeyParrot);
                logger.trace(currPlayer + " Combo Score: " + comboPoints);
            }
        }
    }

}