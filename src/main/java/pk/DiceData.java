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

    // * Score points via combos
    public static int comboPoints(ArrayList<Faces> rollResults) {
        int score = 0;
        int[] counts = new int[6];
        for(int i=0; i< rollResults.size(); i++) {
            if (rollResults.get(i) != Faces.SKULL) {
                counts[rollResults.get(i).ordinal()]++;
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
}
