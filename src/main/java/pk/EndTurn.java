package pk;

import java.util.ArrayList;

public class EndTurn {

    public boolean turn_condition(ArrayList<Faces> results) {
        int skullCount = 0;

        for (int i=0; i< results.size(); i++){
            if(skullCount == 3) {
                return false;
            }
            if (results.get(i) == Faces.SKULL){
                skullCount++;
            }
        }
        return true;
    }
}
