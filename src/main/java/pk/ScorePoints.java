package pk;

import java.util.ArrayList;

public class ScorePoints {
    public static int Points(ArrayList<Faces> roll_results) {
        int score=0;
        for (int i=0; i<roll_results.size(); i++){
            if(roll_results.get(i) == Faces.DIAMOND || roll_results.get(i) == Faces.GOLD){
                score++;
            }
        }
        return score*100;
    }
    
}
