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
}
