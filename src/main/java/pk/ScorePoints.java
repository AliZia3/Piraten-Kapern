package pk;

import java.util.ArrayList;

public class ScorePoints {

    // Points scored via coins & diamonds (F04)
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
