package pk;

import java.util.ArrayList;

public class DiceData {

    // * Check number of skulls
    public static int Skulls(ArrayList<Faces> rollResults) {
        int skullCount = 0;
        for (int i = 0; i < rollResults.size(); i++) {
            if (rollResults.get(i) == Faces.SKULL) {
                skullCount++;
            }
        }
        return skullCount;
    }

    // * Score points via coins & diamonds
    public static int pointsCoinsDiamonds(ArrayList<Faces> rollResults) {
        int score = 0;
        for (int i = 0; i < rollResults.size(); i++) {
            if (rollResults.get(i) == Faces.DIAMOND || rollResults.get(i) == Faces.GOLD) {
                score++;
            }
        }
        return score * 100;
    }

    // * Check number of sabers
    public static int Sabers(ArrayList<Faces> rollResults) {
        int saberCount = 0;
        for (int i = 0; i < rollResults.size(); i++) {
            if (rollResults.get(i) == Faces.SABER) {
                saberCount++;
            }
        }
        return saberCount;
    }

    // * Score points via monkey and parrot
    public static int pointsMonkeyParrot(ArrayList<Faces> rollResults) {
        int count = 0;
        for (int i = 0; i < rollResults.size(); i++) {
            if (rollResults.get(i) == Faces.PARROT || rollResults.get(i) == Faces.MONKEY) {
                count++;
            }
        }
        if (count == 3) return 100;
        if (count == 4) return 200;
        if (count == 5) return 500;
        if (count == 6) return 1000;
        if (count == 7) return 2000;
        if (count == 8) return 4000;
        return 0;
    }

    // * Score points via combos
    public static int comboPoints(ArrayList<Faces> rollResults, boolean monkeyBusiness) {
        int score = 0;
        int[] counts = new int[6];
        for(int i=0; i < rollResults.size(); i++) {
            // If monkey business strategy (monkey business card drawn) than counts only contains the number of occurences of anything but skulls, parrot, monkey (ignore these faces when looking for combo)
            if(monkeyBusiness) {
                if (rollResults.get(i) != Faces.SKULL || rollResults.get(i) != Faces.PARROT || rollResults.get(i) != Faces.MONKEY) {
                    counts[rollResults.get(i).ordinal()]++;
                }
            }
            // If not monkey strategy
            else {
                if (rollResults.get(i) != Faces.SKULL) {
                    counts[rollResults.get(i).ordinal()]++;
                }
            }
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= 3) {
                if (counts[i] == 3) {
                    score += 100;
                } else if (counts[i] == 4) {
                    score += 200;
                } else if (counts[i] == 5) {
                    score += 500;
                } else if (counts[i] == 6) {
                    score += 1000;
                } else if (counts[i] == 7) {
                    score += 2000;
                } else if (counts[i] == 8) {
                    score += 4000;
                }
            }
        }
        return score;
    }

    // * Count number of faces seen in the roll
    public static int[] faceCounter(ArrayList<Faces> rollResults) {
        int goldCount = 0;
        int diamondCount = 0;
        int saberCount = 0;
        int parrotCount = 0;
        int monkeyCount = 0;
        for (int i=0; i<rollResults.size(); i++){
            if(rollResults.get(i)==Faces.MONKEY) {
                monkeyCount++;
            }
            if(rollResults.get(i)==Faces.PARROT) {
                parrotCount++;
            }
            if(rollResults.get(i)==Faces.GOLD) {
                goldCount++;
            }
            if(rollResults.get(i)==Faces.DIAMOND) {
                diamondCount++;
            }
            if(rollResults.get(i)==Faces.SABER) {
                saberCount++;
            }
        }

        return new int[]{monkeyCount, parrotCount, goldCount, diamondCount, saberCount};
    }

    // * Find face that appears the most in the roll
    public static Faces maxFaceCount(ArrayList<Faces> rollResults) {
        int[] faceCounter = faceCounter(rollResults);
        int maxCount = 0;
        Faces maxFace = Faces.SKULL;
        for (int i=0; i<faceCounter.length; i++){
            if(faceCounter[i] > maxCount) {
                maxCount = faceCounter[i];
                // Ensures that if multiples faces appear the same time then priority is given to gold as it provides better points
                if(faceCounter[i] == faceCounter[2]) {
                    maxFace = Faces.GOLD;
                }
                else if (faceCounter[3] == faceCounter[i]) {
                    maxFace = Faces.DIAMOND;
                }
                else {
                    // Array faceCounter has same ordering as in Faces.java so returning the i-th index returns the correct face
                    maxFace = Faces.values()[i];
                }
            }
        }

        return maxFace;
    }
}
